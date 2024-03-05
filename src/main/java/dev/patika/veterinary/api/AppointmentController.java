package dev.patika.veterinary.api;

import dev.patika.veterinary.business.concretes.AppointmentManager;
import dev.patika.veterinary.core.config.modelMapper.IModelMapper;
import dev.patika.veterinary.core.result.Result;
import dev.patika.veterinary.core.result.ResultWithData;
import dev.patika.veterinary.core.utils.ResultHelper;
import dev.patika.veterinary.dto.requests.appointment.AppointmentSaveRequest;
import dev.patika.veterinary.dto.requests.appointment.AppointmentUpdateRequest;
import dev.patika.veterinary.dto.responses.CursorResponse;
import dev.patika.veterinary.dto.responses.animal.AnimalResponse;
import dev.patika.veterinary.dto.responses.appointment.AppointmentResponse;
import dev.patika.veterinary.entities.Animal;
import dev.patika.veterinary.entities.Appointment;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/v1/appointments")
public class AppointmentController {
    private final AppointmentManager appointmentManager;
    private final IModelMapper modelMapper;

    public AppointmentController(AppointmentManager appointmentManager, IModelMapper modelMapper) {
        this.appointmentManager = appointmentManager;
        this.modelMapper = modelMapper;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultWithData<AppointmentResponse> save(@Valid @RequestBody AppointmentSaveRequest appointmentSaveRequest){
        return ResultHelper.created(this.appointmentManager.save(appointmentSaveRequest));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<AppointmentResponse> get(@PathVariable ("id") Long id){
        return ResultHelper.ok(this.appointmentManager.get(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable ("id") Long id){
        this.appointmentManager.delete(id);
        return ResultHelper.successfulOperation();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<AppointmentResponse> update(@PathVariable ("id") Long id, @Valid @RequestBody AppointmentUpdateRequest appointmentUpdateRequest){
        return ResultHelper.ok(this.appointmentManager.update(id, appointmentUpdateRequest));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<CursorResponse<AppointmentResponse>> cursor(@RequestParam (value = "page", required = false, defaultValue = "0") int page,
                                                                 @RequestParam (value = "pageSize", required = false, defaultValue = "10") int pageSize){
        Page<Appointment> appointments = this.appointmentManager.cursor(page, pageSize);
        Page<AppointmentResponse> appointmentResponses = appointments.map(appointment -> this.modelMapper.forResponse().map(appointment, AppointmentResponse.class));
        return ResultHelper.cursor(appointmentResponses);
    }

    @GetMapping("/findByDoctorIdAndDate")
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<List<AppointmentResponse>> findByDoctorIdAndDate(@RequestParam ("doctorId") Long id, @RequestParam ("startTime") LocalDate startTime, @RequestParam ("endTime") LocalDate endTime){
        List<Appointment> appointments = this.appointmentManager.findAllByDoctorIdAndDateBetween(id, startTime, endTime);
        List<AppointmentResponse> appointmentResponses = appointments.stream().map(appointment -> this.modelMapper.forResponse().map(appointment, AppointmentResponse.class)).toList();

        return ResultHelper.ok(appointmentResponses);
    }

    @GetMapping("/findByAnimalIdAndDate")
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<List<AppointmentResponse>> findByAnimalIdAndDate(@RequestParam ("animalId") Long id, @RequestParam ("startTime") LocalDate startTime, @RequestParam ("endTime") LocalDate endTime){
        List<Appointment> appointments = this.appointmentManager.findAllByAnimalIdAndDateBetween(id, startTime, endTime);
        List<AppointmentResponse> appointmentResponses = appointments.stream().map(appointment -> this.modelMapper.forResponse().map(appointment, AppointmentResponse.class)).toList();

        return ResultHelper.ok(appointmentResponses);
    }
}