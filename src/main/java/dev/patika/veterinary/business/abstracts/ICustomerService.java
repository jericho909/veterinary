package dev.patika.veterinary.business.abstracts;

import dev.patika.veterinary.entities.Customer;
import org.springframework.data.domain.Page;

public interface ICustomerService {
    Customer save(Customer customer);
    Customer get(int id);
    Customer update(Customer customer);
    Page<Customer> cursor(int page, int pageSize);
    boolean delete(int id);

}
