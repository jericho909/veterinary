package dev.patika.veterinary.business.concretes;

import dev.patika.veterinary.business.abstracts.ICustomerService;
import dev.patika.veterinary.core.utils.Msg;
import dev.patika.veterinary.dao.CustomerRepo;
import dev.patika.veterinary.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CustomerManager implements ICustomerService {
    private final CustomerRepo customerRepo;
    @Autowired
    public CustomerManager(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public Customer save(Customer customer) {
        return this.customerRepo.save(customer);
    }

    @Override
    public Customer get(int id) {
        return this.customerRepo.findById(id).orElseThrow(()-> new RuntimeException(Msg.NOT_FOUND));
    }

    @Override
    public Customer update(Customer customer) {
        this.get(Math.toIntExact(customer.getId()));
        return this.customerRepo.save(customer);
    }

    @Override
    public Page<Customer> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.customerRepo.findAll(pageable);
    }

    @Override
    public boolean delete(int id) {
        Customer customerToBeDeleted = this.get(id);
        this.customerRepo.delete(customerToBeDeleted);
        return true;
    }
}
