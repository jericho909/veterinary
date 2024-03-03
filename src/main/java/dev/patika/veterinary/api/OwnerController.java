package dev.patika.veterinary.api;

import dev.patika.veterinary.business.concretes.OwnerManager;
import dev.patika.veterinary.core.config.modelMapper.IModelMapper;
import dev.patika.veterinary.core.exceptions.NotFoundException;
import dev.patika.veterinary.core.result.Result;
import dev.patika.veterinary.core.result.ResultWithData;
import dev.patika.veterinary.core.utils.Msg;
import dev.patika.veterinary.core.utils.ResultHelper;
import dev.patika.veterinary.dto.requests.owner.OwnerSaveRequest;
import dev.patika.veterinary.dto.requests.owner.OwnerUpdateRequest;
import dev.patika.veterinary.dto.responses.CursorResponse;
import dev.patika.veterinary.dto.responses.owner.OwnerResponse;
import dev.patika.veterinary.entities.Owner;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/owners")
public class OwnerController {
    private final OwnerManager ownerManager;
    private final IModelMapper modelMapper;

    public OwnerController(OwnerManager ownerManager, IModelMapper modelMapper) {
        this.ownerManager = ownerManager;
        this.modelMapper = modelMapper;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultWithData<OwnerResponse> save(@Valid @RequestBody OwnerSaveRequest ownerSaveRequest){
        return ResultHelper.created(this.ownerManager.save(ownerSaveRequest));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<OwnerResponse> get(@PathVariable("id") Long id){
        return ResultHelper.ok(this.ownerManager.get(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") Long id){
        this.ownerManager.delete(id);
        return ResultHelper.successfulOperation();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<OwnerResponse> update(@PathVariable ("id") Long id, @Valid @RequestBody OwnerUpdateRequest ownerUpdateRequest){
        return ResultHelper.ok(this.ownerManager.update(id, ownerUpdateRequest));
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<CursorResponse<OwnerResponse>> cursor(@RequestParam (value = "page", required = false, defaultValue = "0") int page,
                                                                @RequestParam (value = "pageSize", required = false, defaultValue = "10") int pageSize){
        Page<Owner> owners = this.ownerManager.cursor(page, pageSize);
        Page<OwnerResponse> ownerResponses = owners.map(owner -> this.modelMapper.forResponse().map(owner, OwnerResponse.class));

        return ResultHelper.cursor(ownerResponses);
    }

    @GetMapping("/byOwnerName")
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<List<OwnerResponse>> getByName(@RequestParam ("name") String name){
        List<Owner> owners = this.ownerManager.findByName(name);
        List<OwnerResponse> ownerResponses = owners.stream().map(owner -> this.modelMapper.forResponse().map(owner, OwnerResponse.class)).toList();
        if (ownerResponses.isEmpty()){
            throw new NotFoundException("OWNER NOT FOUND");
        }
        return ResultHelper.ok(ownerResponses);
    }
}
