package dev.patika.veterinary.api;

import dev.patika.veterinary.business.concretes.AppointmentManager;
import dev.patika.veterinary.core.config.modelMapper.IModelMapper;
import dev.patika.veterinary.core.result.Result;
import dev.patika.veterinary.core.result.ResultWithData;
import dev.patika.veterinary.core.utils.ResultHelper;
import dev.patika.veterinary.dto.requests.appointment.AppointmentSaveRequest;
import dev.patika.veterinary.dto.requests.appointment.AppointmentUpdateRequest;
import dev.patika.veterinary.dto.responses.appointment.AppointmentResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
}