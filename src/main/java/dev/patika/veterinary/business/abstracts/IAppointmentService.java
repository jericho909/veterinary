package dev.patika.veterinary.business.abstracts;

import dev.patika.veterinary.dto.requests.appointment.AppointmentSaveRequest;
import dev.patika.veterinary.dto.requests.appointment.AppointmentUpdateRequest;
import dev.patika.veterinary.dto.responses.appointment.AppointmentResponse;
import dev.patika.veterinary.entities.Appointment;
import org.springframework.data.domain.Page;

public interface IAppointmentService {
    AppointmentResponse save(AppointmentSaveRequest appointmentSaveRequest);
    AppointmentResponse get (Long id);
    void delete(Long id);
    Page<Appointment> cursor(int page, int pageSize);
    AppointmentResponse update(Long id, AppointmentUpdateRequest appointmentUpdateRequest);

}
