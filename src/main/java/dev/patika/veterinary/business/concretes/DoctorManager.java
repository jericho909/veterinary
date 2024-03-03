package dev.patika.veterinary.business.concretes;

import dev.patika.veterinary.business.abstracts.IDoctorService;
import dev.patika.veterinary.core.config.modelMapper.IModelMapper;
import dev.patika.veterinary.core.exceptions.NotFoundException;
import dev.patika.veterinary.core.utils.Msg;
import dev.patika.veterinary.dao.DoctorRepo;
import dev.patika.veterinary.dto.requests.doctor.DoctorSaveRequest;
import dev.patika.veterinary.dto.requests.doctor.DoctorUpdateRequest;
import dev.patika.veterinary.dto.responses.doctor.DoctorResponse;
import dev.patika.veterinary.entities.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DoctorManager implements IDoctorService {
    private final DoctorRepo doctorRepo;
    private final IModelMapper modelMapper;

    public DoctorManager(DoctorRepo doctorRepo, IModelMapper modelMapper) {
        this.doctorRepo = doctorRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public DoctorResponse save(DoctorSaveRequest doctorSaveRequest) {
        Doctor newDoctor = this.modelMapper.forRequest().map(doctorSaveRequest, Doctor.class);
        this.doctorRepo.save(newDoctor);
        return this.modelMapper.forResponse().map(newDoctor, DoctorResponse.class);
    }

    @Override
    public DoctorResponse get(Long id) {
        return this.modelMapper.forResponse().map(this.doctorRepo.findById(id).orElseThrow(()-> new NotFoundException(Msg.NOT_FOUND)), DoctorResponse.class);
    }

    @Override
    public void delete(Long id) {
        this.doctorRepo.delete(this.doctorRepo.findById(id).orElseThrow(()-> new NotFoundException(Msg.NOT_FOUND)));
    }

    @Override
    public Page<Doctor> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.doctorRepo.findAll(pageable);
    }

    @Override
    public DoctorResponse update(Long id, DoctorUpdateRequest doctorUpdateRequest) {
        Doctor updatedDoctor = this.doctorRepo.findById(id).orElseThrow(()-> new NotFoundException(Msg.NOT_FOUND));
        updatedDoctor.setName(doctorUpdateRequest.getName());
        updatedDoctor.setPhone(doctorUpdateRequest.getPhone());
        updatedDoctor.setEmail(doctorUpdateRequest.getEmail());
        updatedDoctor.setAddress(doctorUpdateRequest.getAddress());
        updatedDoctor.setCity(doctorUpdateRequest.getCity());
        this.doctorRepo.save(updatedDoctor);

        return this.modelMapper.forResponse().map(updatedDoctor, DoctorResponse.class);
    }
}
