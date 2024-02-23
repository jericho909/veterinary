package dev.patika.veterinary.api;

import dev.patika.veterinary.business.abstracts.IAnimalService;
import dev.patika.veterinary.core.config.modelMapper.IModelMapper;
import dev.patika.veterinary.core.result.Result;
import dev.patika.veterinary.core.result.ResultWithData;
import dev.patika.veterinary.core.utils.ResultHelper;
import dev.patika.veterinary.dto.requests.animal.AnimalSaveRequest;
import dev.patika.veterinary.dto.requests.animal.AnimalUpdateRequest;
import dev.patika.veterinary.dto.responses.animal.AnimalResponse;
import dev.patika.veterinary.dto.responses.customer.CustomerResponse;
import dev.patika.veterinary.entities.Animal;
import dev.patika.veterinary.entities.Customer;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/animals")
public class AnimalController {
    private final IAnimalService animalService;
    private final IModelMapper modelMapper;

    public AnimalController(IAnimalService animalService, IModelMapper modelMapper) {
        this.animalService = animalService;
        this.modelMapper = modelMapper;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultWithData<AnimalResponse> save(@Valid @RequestBody AnimalSaveRequest animalSaveRequest){
        Animal newAnimal = this.modelMapper.forRequest().map(animalSaveRequest, Animal.class);
        this.animalService.save(newAnimal);

        // we retrieve the new animal from the db
        newAnimal = this.animalService.get(Math.toIntExact(newAnimal.getId()));

        // we get the owner of the animal and save it
        Customer owner = newAnimal.getCustomer();

        //we map the response so unnecessary info won't be shown to the API user
        CustomerResponse ownerResponse = this.modelMapper.forResponse().map(owner, CustomerResponse.class);

        // Create the AnimalAPIResponse and map the new owner info to the obj
        AnimalResponse animalResponse = this.modelMapper.forResponse().map(newAnimal, AnimalResponse.class);
        //set the customer
        animalResponse.setOwnerInfo(ownerResponse);

        return ResultHelper.created(animalResponse);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<AnimalResponse> get(@PathVariable("id") int id){
        Animal animal = this.animalService.get(id);
        Customer owner = animal.getCustomer();
        CustomerResponse ownerResponse = this.modelMapper.forResponse().map(owner, CustomerResponse.class);

        AnimalResponse animalResponse = this.modelMapper.forResponse().map(animal, AnimalResponse.class);
        animalResponse.setOwnerInfo(ownerResponse);

        return ResultHelper.ok(animalResponse);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<AnimalResponse> update(@Valid @RequestBody AnimalUpdateRequest animalUpdateRequest){
        Animal updatedAnimal = this.modelMapper.forRequest().map(animalUpdateRequest, Animal.class);
        this.animalService.update(updatedAnimal);

        Customer owner = updatedAnimal.getCustomer();
        CustomerResponse ownerResponse = this.modelMapper.forResponse().map(owner, CustomerResponse.class);

        AnimalResponse animalResponse = this.modelMapper.forResponse().map(updatedAnimal, AnimalResponse.class);
        animalResponse.setOwnerInfo(ownerResponse);

        return ResultHelper.ok(animalResponse);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id){
        this.animalService.delete(id);
        return ResultHelper.successfulOperation();
    }

}
