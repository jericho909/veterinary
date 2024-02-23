package dev.patika.veterinary.api;

import dev.patika.veterinary.business.abstracts.ICustomerService;
import dev.patika.veterinary.core.config.modelMapper.IModelMapper;
import dev.patika.veterinary.core.result.Result;
import dev.patika.veterinary.core.result.ResultWithData;
import dev.patika.veterinary.core.utils.ResultHelper;
import dev.patika.veterinary.dto.requests.customer.CustomerSaveRequest;
import dev.patika.veterinary.dto.requests.customer.CustomerUpdateRequest;
import dev.patika.veterinary.dto.responses.customer.CustomerResponse;
import dev.patika.veterinary.entities.Customer;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/customers")
public class CustomerController {
    private final ICustomerService customerService;
    private final IModelMapper modelMapper;

    public CustomerController(ICustomerService customerService, IModelMapper modelMapper) {
        this.customerService = customerService;
        this.modelMapper = modelMapper;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResultWithData<CustomerResponse> save(@Valid @RequestBody CustomerSaveRequest customerSaveRequest){
        Customer newCustomer = this.modelMapper.forRequest().map(customerSaveRequest, Customer.class);
        this.customerService.save(newCustomer);
        return ResultHelper.created(this.modelMapper.forResponse().map(newCustomer, CustomerResponse.class));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<CustomerResponse> update(@Valid @RequestBody CustomerUpdateRequest customerUpdateRequest){
        Customer updatedCustomer = this.modelMapper.forRequest().map(customerUpdateRequest, Customer.class);
        this.customerService.update(updatedCustomer);

        return ResultHelper.ok(this.modelMapper.forResponse().map(updatedCustomer, CustomerResponse.class));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultWithData<CustomerResponse> get(@PathVariable("id") int id){
        Customer customer = this.customerService.get(id);
        return ResultHelper.ok(this.modelMapper.forResponse().map(customer, CustomerResponse.class));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id){
        this.customerService.delete(id);
        return ResultHelper.successfulOperation();
    }
}
