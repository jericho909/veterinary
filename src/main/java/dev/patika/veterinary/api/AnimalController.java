package dev.patika.veterinary.api;

import dev.patika.veterinary.business.abstracts.IAnimalService;
import dev.patika.veterinary.core.config.modelMapper.IModelMapper;
import dev.patika.veterinary.core.result.ResultWithData;
import dev.patika.veterinary.core.utils.ResultHelper;
import dev.patika.veterinary.dto.requests.animal.AnimalSaveRequest;
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResultWithData<AnimalResponse> save(@Valid @RequestBody AnimalSaveRequest animalSaveRequest){
        Animal newAnimal = this.modelMapper.forRequest().map(animalSaveRequest, Animal.class);
        this.animalService.save(newAnimal);

        // Retrieve the saved animal with associated customer
        newAnimal = this.animalService.get(Math.toIntExact(newAnimal.getId()));

        // Map owner information from Customer to CustomerResponse
        Customer owner = newAnimal.getCustomer();
        CustomerResponse ownerResponse = this.modelMapper.forResponse().map(owner, CustomerResponse.class);

        // Create AnimalResponse and set ownerInfo
        AnimalResponse animalResponse = this.modelMapper.forResponse().map(newAnimal, AnimalResponse.class);
        animalResponse.setOwnerInfo(ownerResponse);

        return ResultHelper.created(animalResponse);
    }

}
