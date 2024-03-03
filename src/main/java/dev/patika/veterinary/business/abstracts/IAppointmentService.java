package dev.patika.veterinary.business.abstracts;

import dev.patika.veterinary.dto.requests.appointment.AppointmentSaveRequest;
import dev.patika.veterinary.dto.requests.appointment.AppointmentUpdateRequest;
import dev.patika.veterinary.dto.responses.appointment.AppointmentResponse;

public interface IAppointmentService {
    AppointmentResponse save(AppointmentSaveRequest appointmentSaveRequest);
    AppointmentResponse get (Long id);
    void delete(Long id);

    AppointmentResponse update(Long id, AppointmentUpdateRequest appointmentUpdateRequest);

}
