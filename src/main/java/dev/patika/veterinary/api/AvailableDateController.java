package dev.patika.veterinary.api;

import dev.patika.veterinary.business.concretes.AvailableDateManager;
import dev.patika.veterinary.core.config.modelMapper.IModelMapper;
import dev.patika.veterinary.core.result.ResultWithData;
import dev.patika.veterinary.core.utils.ResultHelper;
import dev.patika.veterinary.dto.requests.availableDate.AvailableDateSaveRequest;
import dev.patika.veterinary.dto.responses.availableDate.AvailableDateResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/availabledates")
public class AvailableDateController {
    private final AvailableDateManager availableDateManager;
    private final IModelMapper modelMapper;

    public AvailableDateController(AvailableDateManager availableDateManager, IModelMapper modelMapper) {
        this.availableDateManager = availableDateManager;
        this.modelMapper = modelMapper;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultWithData<AvailableDateResponse> save(@Valid @RequestBody AvailableDateSaveRequest availableDateSaveRequest){
        return ResultHelper.created(this.availableDateManager.save(availableDateSaveRequest));
    }
}
