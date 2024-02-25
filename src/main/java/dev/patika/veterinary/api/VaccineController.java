package dev.patika.veterinary.api;

import dev.patika.veterinary.business.concretes.VaccineManager;
import dev.patika.veterinary.core.config.modelMapper.IModelMapper;
import dev.patika.veterinary.core.result.Result;
import dev.patika.veterinary.core.result.ResultWithData;
import dev.patika.veterinary.core.utils.ResultHelper;
import dev.patika.veterinary.dto.requests.vaccine.VaccineSaveRequest;
import dev.patika.veterinary.dto.responses.vaccine.VaccineResponse;
import dev.patika.veterinary.entities.Vaccine;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
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
        Vaccine newVaccine = this.modelMapper.forRequest().map(vaccineSaveRequest, Vaccine.class);
        this.vaccineManager.save(newVaccine);
        return ResultHelper.created(this.modelMapper.forResponse().map(newVaccine, VaccineResponse.class));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<VaccineResponse> get(@PathVariable("id") int id){
        Vaccine vaccine = this.vaccineManager.get(id);
        return ResultHelper.ok(this.modelMapper.forResponse().map(vaccine, VaccineResponse.class));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable ("id") int id){
        this.vaccineManager.delete(id);
        return ResultHelper.successfulOperation();
    }
}
