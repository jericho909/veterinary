package dev.patika.veterinary.business.concretes;

import dev.patika.veterinary.business.abstracts.IAppointmentService;
import dev.patika.veterinary.core.config.modelMapper.IModelMapper;
import dev.patika.veterinary.core.exceptions.NotFoundException;
import dev.patika.veterinary.core.utils.Msg;
import dev.patika.veterinary.dao.AppointmentRepo;
import dev.patika.veterinary.dto.requests.appointment.AppointmentSaveRequest;
import dev.patika.veterinary.dto.requests.appointment.AppointmentUpdateRequest;
import dev.patika.veterinary.dto.responses.appointment.AppointmentResponse;
import dev.patika.veterinary.entities.Animal;
import dev.patika.veterinary.entities.Appointment;
import dev.patika.veterinary.entities.Doctor;
import org.springframework.stereotype.Service;

@Service
public class AppointmentManager implements IAppointmentService {
    private final AppointmentRepo appointmentRepo;
    private final IModelMapper modelMapper;
    private final DoctorManager doctorManager;
    private final AnimalManager animalManager;

    public AppointmentManager(AppointmentRepo appointmentRepo, IModelMapper modelMapper, DoctorManager doctorManager, AnimalManager animalManager) {
        this.appointmentRepo = appointmentRepo;
        this.modelMapper = modelMapper;
        this.doctorManager = doctorManager;
        this.animalManager = animalManager;
    }

    @Override
    public AppointmentResponse save(AppointmentSaveRequest appointmentSaveRequest) {
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
}
