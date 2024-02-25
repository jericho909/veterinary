package dev.patika.veterinary.api;

import dev.patika.veterinary.business.concretes.DoctorManager;
import dev.patika.veterinary.core.config.modelMapper.IModelMapper;
import dev.patika.veterinary.core.result.Result;
import dev.patika.veterinary.core.result.ResultWithData;
import dev.patika.veterinary.core.utils.ResultHelper;
import dev.patika.veterinary.dao.DoctorRepo;
import dev.patika.veterinary.dto.requests.doctor.DoctorSaveRequest;
import dev.patika.veterinary.dto.requests.doctor.DoctorUpdateRequest;
import dev.patika.veterinary.dto.responses.doctor.DoctorResponse;
import dev.patika.veterinary.entities.Doctor;
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
        Doctor newDoctor = this.modelMapper.forRequest().map(doctorSaveRequest, Doctor.class);
        this.doctorManager.save(newDoctor);
        return ResultHelper.created(this.modelMapper.forResponse().map(newDoctor, DoctorResponse.class));
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<DoctorResponse> update(@Valid @RequestBody DoctorUpdateRequest doctorUpdateRequest){
        Doctor updatedDoctor = this.modelMapper.forRequest().map(doctorUpdateRequest, Doctor.class);
        if (doctorUpdateRequest.getCity() == null){
            String doctorCity = this.doctorManager.get(Math.toIntExact(doctorUpdateRequest.getId())).getCity();
            updatedDoctor.setCity(doctorCity);
        }
        this.doctorManager.update(updatedDoctor);
        return ResultHelper.ok(this.modelMapper.forResponse().map(updatedDoctor, DoctorResponse.class));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<DoctorResponse> get(@PathVariable ("id") int id){
        Doctor doctor = this.doctorManager.get(id);
        return ResultHelper.ok(this.modelMapper.forResponse().map(doctor, DoctorResponse.class));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable ("id") int id){
        this.doctorManager.delete(id);
        return ResultHelper.successfulOperation();
    }

}
