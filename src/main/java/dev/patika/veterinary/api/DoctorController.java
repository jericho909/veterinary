package dev.patika.veterinary.api;

import dev.patika.veterinary.business.concretes.DoctorManager;
import dev.patika.veterinary.core.config.modelMapper.IModelMapper;
import dev.patika.veterinary.core.result.Result;
import dev.patika.veterinary.core.result.ResultWithData;
import dev.patika.veterinary.core.utils.ResultHelper;
import dev.patika.veterinary.dto.requests.doctor.DoctorSaveRequest;
import dev.patika.veterinary.dto.requests.doctor.DoctorUpdateRequest;
import dev.patika.veterinary.dto.responses.doctor.DoctorResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;

@RestController
@RequestMapping("/v1/doctors")
public class DoctorController {
    private final DoctorManager doctorManager;
    private final IModelMapper modelMapper;

    public DoctorController(DoctorManager doctorManager, IModelMapper modelMapper) {
        this.doctorManager = doctorManager;
        this.modelMapper = modelMapper;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultWithData<DoctorResponse> save(@Valid @RequestBody DoctorSaveRequest doctorSaveRequest){
        return ResultHelper.created(this.doctorManager.save(doctorSaveRequest));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<DoctorResponse> update(@PathVariable("id")Long id, @Valid @RequestBody DoctorUpdateRequest doctorUpdateRequest){
        return ResultHelper.ok(this.doctorManager.update(id, doctorUpdateRequest));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable ("id") Long id){
        this.doctorManager.delete(id);
        return ResultHelper.successfulOperation();
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<DoctorResponse> get(@PathVariable ("id") Long id){
        return ResultHelper.ok(this.doctorManager.get(id));
    }
}
