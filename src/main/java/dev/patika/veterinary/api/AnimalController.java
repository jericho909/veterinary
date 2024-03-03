package dev.patika.veterinary.api;

import dev.patika.veterinary.business.concretes.AnimalManager;
import dev.patika.veterinary.core.config.modelMapper.IModelMapper;
import dev.patika.veterinary.core.exceptions.NotFoundException;
import dev.patika.veterinary.core.result.Result;
import dev.patika.veterinary.core.result.ResultWithData;
import dev.patika.veterinary.core.utils.Msg;
import dev.patika.veterinary.core.utils.ResultHelper;
import dev.patika.veterinary.dto.requests.animal.AnimalSaveRequest;
import dev.patika.veterinary.dto.requests.animal.AnimalUpdateRequest;
import dev.patika.veterinary.dto.responses.CursorResponse;
import dev.patika.veterinary.dto.responses.animal.AnimalResponse;
import dev.patika.veterinary.entities.Animal;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/animals")
public class AnimalController {
    private final AnimalManager animalManager;
    private final IModelMapper modelMapper;

    public AnimalController(AnimalManager animalManager, IModelMapper modelMapper) {
        this.animalManager = animalManager;
        this.modelMapper = modelMapper;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultWithData<AnimalResponse> save(@Valid @RequestBody AnimalSaveRequest animalSaveRequest){
        return ResultHelper.created(this.animalManager.save(animalSaveRequest));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<AnimalResponse> get(@PathVariable("id") Long id){
        return ResultHelper.ok(this.animalManager.get(id));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<AnimalResponse> update(@PathVariable ("id") Long id, @Valid @RequestBody AnimalUpdateRequest animalUpdateRequest){
        return ResultHelper.ok(this.animalManager.update(id, animalUpdateRequest));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") Long id){
        this.animalManager.delete(id);
        return ResultHelper.successfulOperation();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<CursorResponse<AnimalResponse>> cursor(@RequestParam (value = "page", required = false, defaultValue = "0") int page,
                                                                 @RequestParam (value = "pageSize", required = false, defaultValue = "10") int pageSize){
        Page<Animal> animals = this.animalManager.cursor(page, pageSize);
        Page<AnimalResponse> animalResponses = animals.map(animal -> this.modelMapper.forResponse().map(animal, AnimalResponse.class));
        return ResultHelper.cursor(animalResponses);
    }

    @GetMapping("/findByName")
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<List<AnimalResponse>> getByName (@RequestParam ("name") String name){
        List<Animal> animals = this.animalManager.findByName(name);
        List<AnimalResponse> animalResponses = animals.stream().map(animal -> this.modelMapper.forResponse().map(animal, AnimalResponse.class)).toList();

        if (animalResponses.isEmpty()){
            throw new NotFoundException(Msg.ANIMAL_NOT_FOUND);
        }

        return ResultHelper.ok(animalResponses);
    }
}
