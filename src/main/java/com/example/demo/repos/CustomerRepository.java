package com.example.demo.repos;

import com.example.demo.entity.Address;
import com.example.demo.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    List<Customer> findByLastName(String lastName);
    List<Customer> findAll();
    List<Customer> findByAddress(Address address);
    Customer findById(int id);
    Customer save(Customer customer);
}
