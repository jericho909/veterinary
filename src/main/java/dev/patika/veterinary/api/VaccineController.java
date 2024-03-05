package dev.patika.veterinary.api;

import dev.patika.veterinary.business.concretes.VaccineManager;
import dev.patika.veterinary.core.config.modelMapper.IModelMapper;
import dev.patika.veterinary.core.result.Result;
import dev.patika.veterinary.core.result.ResultWithData;
import dev.patika.veterinary.core.utils.ResultHelper;
import dev.patika.veterinary.dto.requests.vaccine.VaccineSaveRequest;
import dev.patika.veterinary.dto.requests.vaccine.VaccineUpdateRequest;
import dev.patika.veterinary.dto.responses.CursorResponse;
import dev.patika.veterinary.dto.responses.animal.AnimalResponse;
import dev.patika.veterinary.dto.responses.vaccine.VaccineResponse;
import dev.patika.veterinary.entities.Animal;
import dev.patika.veterinary.entities.Vaccine;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

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

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<CursorResponse<VaccineResponse>> cursor(@RequestParam (value = "page", required = false, defaultValue = "0") int page,
                                                                 @RequestParam (value = "pageSize", required = false, defaultValue = "10") int pageSize){
        Page<Vaccine> vaccines = this.vaccineManager.cursor(page, pageSize);
        Page<VaccineResponse> vaccineResponses = vaccines.map(vaccine -> this.modelMapper.forResponse().map(vaccine, VaccineResponse.class));
        return ResultHelper.cursor(vaccineResponses);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<VaccineResponse> update(@PathVariable ("id") Long id, @Valid @RequestBody VaccineUpdateRequest vaccineUpdateRequest){
        return ResultHelper.ok(this.vaccineManager.update(id, vaccineUpdateRequest));
    }

    @GetMapping("/findByAnimalId")
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<List<VaccineResponse>> findAllByAnimalId(@RequestParam ("animalId") Long animalId) {
        List<Vaccine> vaccines = this.vaccineManager.findAllByAnimalId(animalId);
        List<VaccineResponse> vaccineResponses = vaccines.stream().map(vaccine -> this.modelMapper.forResponse().map(vaccine, VaccineResponse.class)).toList();

        return ResultHelper.ok(vaccineResponses);
    }

    @GetMapping("/findByVaccineDates")
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<List<VaccineResponse>> findByVaccineDates(@RequestParam ("startDate")LocalDate startDate, @RequestParam ("endDate") LocalDate endDate){
        List<Vaccine> vaccines = this.vaccineManager.findAllByEndDateBetween(startDate, endDate);
        List<VaccineResponse> vaccineResponses = vaccines.stream().map(vaccine -> this.modelMapper.forResponse().map(vaccine, VaccineResponse.class)).toList();

        return ResultHelper.ok(vaccineResponses);
    }
}
