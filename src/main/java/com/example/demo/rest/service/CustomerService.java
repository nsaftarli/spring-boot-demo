package com.example.demo.rest.service;

import com.example.demo.entity.Address;
import com.example.demo.entity.Customer;
import com.example.demo.repos.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer findById(int customerId) {
        return customerRepository.findById(customerId);
    }

    public List<Customer> findByLastName(String lastName) {
        return customerRepository.findByLastName(lastName);
    }

    public Customer save(Customer customer) throws Exception {
        if (customer.getCustomerId() == null) {
            Customer saved = customerRepository.save(customer);
            return saved;
        } else if(!customerRepository.existsById(customer.getCustomerId())) {
            Customer saved = customerRepository.save(customer);
            return saved;
        } else {
            throw new Exception("Customer already exists");
        }
    }

    public Customer updateCustomer(Customer customer) throws Exception {
        Customer updated = null;
        if (customerRepository.existsById(customer.getCustomerId())) {
            updated = customerRepository.save(customer);
            return updated;
        } else {
            throw new Exception("Specified customer does not exist. Check the ID code.");
        }
    }

    public List<Customer> findByAddress(Address address) {
        List<Customer> customers = customerRepository.findByAddress(address);
        return customers;
    }

    public List<Customer> addAll(ArrayList<Customer> customers) {
        ArrayList<Customer> customerList  = (ArrayList<Customer>) customerRepository.saveAll(customers);
        return customers;
    }

}
