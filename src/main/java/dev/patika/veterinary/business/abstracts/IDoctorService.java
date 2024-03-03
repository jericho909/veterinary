package dev.patika.veterinary.business.abstracts;

import dev.patika.veterinary.dto.requests.doctor.DoctorSaveRequest;
import dev.patika.veterinary.dto.requests.doctor.DoctorUpdateRequest;
import dev.patika.veterinary.dto.responses.doctor.DoctorResponse;
import dev.patika.veterinary.entities.Doctor;
import org.springframework.data.domain.Page;

public interface IDoctorService {
    DoctorResponse save(DoctorSaveRequest doctorSaveRequest);
    DoctorResponse get(Long id);
    void delete(Long id);
    Page<Doctor> cursor(int page, int pageSize);
    DoctorResponse update(Long id, DoctorUpdateRequest doctorUpdateRequest);
}
