package dev.patika.veterinary.business.concretes;

import dev.patika.veterinary.business.abstracts.IAppointmentService;
import dev.patika.veterinary.core.config.modelMapper.IModelMapper;
import dev.patika.veterinary.core.exceptions.NotFoundException;
import dev.patika.veterinary.core.utils.Msg;
import dev.patika.veterinary.core.utils.ResultHelper;
import dev.patika.veterinary.dao.AppointmentRepo;
import dev.patika.veterinary.dao.AvailableDateRepo;
import dev.patika.veterinary.dto.requests.appointment.AppointmentSaveRequest;
import dev.patika.veterinary.dto.requests.appointment.AppointmentUpdateRequest;
import dev.patika.veterinary.dto.responses.appointment.AppointmentResponse;
import dev.patika.veterinary.entities.Animal;
import dev.patika.veterinary.entities.Appointment;
import dev.patika.veterinary.entities.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class AppointmentManager implements IAppointmentService {
    private final AppointmentRepo appointmentRepo;
    private final IModelMapper modelMapper;
    private final DoctorManager doctorManager;
    private final AnimalManager animalManager;
    private final AvailableDateRepo availableDateRepo;

    public AppointmentManager(AppointmentRepo appointmentRepo, IModelMapper modelMapper, DoctorManager doctorManager, AnimalManager animalManager, AvailableDateRepo availableDateRepo) {
        this.appointmentRepo = appointmentRepo;
        this.modelMapper = modelMapper;
        this.doctorManager = doctorManager;
        this.animalManager = animalManager;
        this.availableDateRepo = availableDateRepo;
    }

    @Override
    public AppointmentResponse save(AppointmentSaveRequest appointmentSaveRequest) {
        Long doctorId = appointmentSaveRequest.getDoctorId();
        LocalDateTime appointmentDate = appointmentSaveRequest.getDate();
        boolean doctorNotWorking = this.availableDateRepo.existsByDoctorIdAndDate(doctorId, appointmentDate.toLocalDate());
        if (!doctorNotWorking) {
            throw new RuntimeException("DOCTOR IS NOT WORKING THAT DAY");
        }
        boolean doctorNotAvailable = this.appointmentRepo.existsByDoctorIdAndDateBetween(doctorId, appointmentDate, appointmentDate.plusHours(1));
        if (doctorNotAvailable) {
            throw new RuntimeException("DOCTOR IS BUSY BETWEEN THOSE HOURS");
        }
        Appointment newAppointment = this.modelMapper.forRequest().map(appointmentSaveRequest, Appointment.class);
        Animal animal = this.modelMapper.forRequest().map(this.animalManager.get(appointmentSaveRequest.getAnimalId()), Animal.class);
        Doctor doctor = this.modelMapper.forRequest().map(this.doctorManager.get(appointmentSaveRequest.getDoctorId()), Doctor.class);
        newAppointment.setAnimal(animal);
        newAppointment.setDoctor(doctor);
        this.appointmentRepo.save(newAppointment);
        return this.modelMapper.forResponse().map(newAppointment, AppointmentResponse.class);
    }

    @Override
    public AppointmentResponse get(Long id) {
        Appointment appointment = this.appointmentRepo.findById(id).orElseThrow(()-> new NotFoundException(Msg.NOT_FOUND));
        return this.modelMapper.forResponse().map(appointment, AppointmentResponse.class);
    }

    @Override
    public void delete(Long id) {
        Appointment appointment = this.appointmentRepo.findById(id).orElseThrow(()-> new NotFoundException(Msg.NOT_FOUND));
        this.appointmentRepo.delete(appointment);
    }

    @Override
    public Page<Appointment> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.appointmentRepo.findAll(pageable);
    }

    @Override
    public AppointmentResponse update(Long id, AppointmentUpdateRequest appointmentUpdateRequest) {
        Appointment appointment = this.appointmentRepo.findById(id).orElseThrow(()-> new NotFoundException(Msg.NOT_FOUND));
        appointment.setDate(appointmentUpdateRequest.getDate());
        Animal animal = this.modelMapper.forRequest().map(this.animalManager.get(appointmentUpdateRequest.getAnimalId()), Animal.class);
        appointment.setAnimal(animal);
        Doctor doctor = this.modelMapper.forRequest().map(this.doctorManager.get(appointmentUpdateRequest.getDoctorId()), Doctor.class);
        appointment.setDoctor(doctor);
        this.appointmentRepo.save(appointment);
        return this.modelMapper.forResponse().map(appointment, AppointmentResponse.class);
    }

    public List<Appointment> findAllByDoctorIdAndDateBetween(Long id, LocalDate startDate, LocalDate endDate){
        LocalDateTime startLocalDateTime = LocalDateTime.of(startDate, LocalTime.of(0,0));
        LocalDateTime endLocalDateTime = LocalDateTime.of(endDate, LocalTime.of(23,59));

        return this.appointmentRepo.findAllByDoctorIdAndDateBetween(id, startLocalDateTime, endLocalDateTime);
    }

    public List<Appointment> findAllByAnimalIdAndDateBetween(Long id, LocalDate startDate, LocalDate endDate){
        LocalDateTime startLocalDateTime = LocalDateTime.of(startDate, LocalTime.of(0,0));
        LocalDateTime endLocalDateTime = LocalDateTime.of(endDate, LocalTime.of(23,59));

        return this.appointmentRepo.findAllByAnimalIdAndDateBetween(id, startLocalDateTime, endLocalDateTime);
    }

}
