package dev.patika.veterinary.api;

import dev.patika.veterinary.business.concretes.VaccineManager;
import dev.patika.veterinary.core.config.modelMapper.IModelMapper;
import dev.patika.veterinary.core.result.Result;
import dev.patika.veterinary.core.result.ResultWithData;
import dev.patika.veterinary.core.utils.ResultHelper;
import dev.patika.veterinary.dto.requests.vaccine.VaccineSaveRequest;
import dev.patika.veterinary.dto.requests.vaccine.VaccineUpdateRequest;
import dev.patika.veterinary.dto.responses.vaccine.VaccineResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/vaccines")
public class VaccineController {
    private final VaccineManager vaccineManager;
    private final IModelMapper modelMapper;

    public VaccineController(VaccineManager vaccineManager, IModelMapper modelMapper) {
        this.vaccineManager = vaccineManager;
        this.modelMapper = modelMapper;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultWithData<VaccineResponse> save(@Valid @RequestBody VaccineSaveRequest vaccineSaveRequest){
        return ResultHelper.created(this.vaccineManager.save(vaccineSaveRequest));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable ("id") Long id){
        this.vaccineManager.delete(id);
        return ResultHelper.successfulOperation();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<VaccineResponse> get(@PathVariable ("id") Long id){
        return ResultHelper.ok(this.vaccineManager.get(id));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<VaccineResponse> update(@PathVariable ("id") Long id, @Valid @RequestBody VaccineUpdateRequest vaccineUpdateRequest){
        return ResultHelper.ok(this.vaccineManager.update(id, vaccineUpdateRequest));
    }
}
