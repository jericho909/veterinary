package dev.patika.veterinary.business.abstracts;

import dev.patika.veterinary.entities.Doctor;
import org.springframework.data.domain.Page;

import javax.print.Doc;

public interface IDoctorService {
    Doctor save (Doctor doctor);
    Doctor get(int id);
    Doctor update(Doctor doctor);
    Page<Doctor> cursor(int page, int pageSize);
    boolean delete(int id);
}
