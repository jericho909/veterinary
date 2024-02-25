package dev.patika.veterinary.business.concretes;

import dev.patika.veterinary.business.abstracts.IDoctorService;
import dev.patika.veterinary.core.exceptions.NotFoundException;
import dev.patika.veterinary.core.utils.Msg;
import dev.patika.veterinary.dao.DoctorRepo;
import dev.patika.veterinary.entities.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.print.Doc;
@Service
public class DoctorManager implements IDoctorService {
    private final DoctorRepo doctorRepo;
    @Autowired
    public DoctorManager(DoctorRepo doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    @Override
    public Doctor save(Doctor doctor) {
        return this.doctorRepo.save(doctor);
    }

    @Override
    public Doctor get(int id) {
        return this.doctorRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public Doctor update(Doctor doctor) {
        this.get(Math.toIntExact(doctor.getId()));
        return this.doctorRepo.save(doctor);
    }

    @Override
    public Page<Doctor> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.doctorRepo.findAll(pageable);
    }

    @Override
    public boolean delete(int id) {
        Doctor doctor = this.get(id);
        this.doctorRepo.delete(doctor);
        return true;
    }
}
