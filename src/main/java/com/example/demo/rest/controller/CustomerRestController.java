package com.example.demo.rest.controller;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.entity.Address;
import com.example.demo.entity.Customer;
import com.example.demo.rest.service.CustomerService;
import com.example.demo.util.ResponseGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * This class exposes its methods as HTTP endpoints, and passes requests to the service layer.
 */

@RestController
@RequestMapping("/customers")
public class CustomerRestController {

    private final CustomerService customerService;

    /**
     * Constructor injection to avoid making the service layer mutable
     * @param customerService the object which services the request passed to this controller
     */
    @Autowired
    public CustomerRestController(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * Get all customers in the database
     * @return
     */
    @GetMapping("/all")
    public ResponseDTO getCustomer() {
        try {
            return ResponseGenerator.generateResponseDTO(customerService.findAll());
        } catch (Exception ex) {
            return ResponseGenerator.generateExceptionDTO(ex);
        }
    }

    /**
     * Get a single customer by their ID
     * @param customerId the primary key for a particular customer
     * @return a DTO containing the customer object
     */
    @GetMapping("/customer/{customerId}")
    public ResponseDTO getCustomerById(@PathVariable int customerId) {
        try {
            return ResponseGenerator.generateResponseDTO(customerService.findById(customerId));
        } catch (Exception ex) {
            return ResponseGenerator.generateExceptionDTO(ex);
        }
    }

    /**
     * Find a list of customers all of whom have a last name in common
     * @param lastName the last name to search for
     * @return a DTO containing the list of customers
     */
    @GetMapping
    public ResponseDTO findCustomersByLastName(@RequestParam String lastName) {
        try {
            return ResponseGenerator.generateResponseDTO(customerService.findByLastName(lastName));
        } catch (Exception ex) {
            return ResponseGenerator.generateExceptionDTO(ex);
        }
    }

    /**
     * Create and persist a new customer
     * @param customer a deserialized JSON object representing a new customer
     * @return a DTO containing the newly created customer for further operations
     */
    @PostMapping("/customer/new")
    public ResponseDTO addNewCustomer(@RequestBody Customer customer) {
        try {
            return ResponseGenerator.generateResponseDTO(customerService.save(customer));
        } catch (Exception ex) {
            return ResponseGenerator.generateExceptionDTO(ex);
        }
    }

    /**
     * Update an existing customer in the database
     * @param customer a deserialized JSON object representing an existing customer with fields updated
     * @return a DTO containing the updated customer for further operations
     */
    @PostMapping("/customer/update")
    public ResponseDTO updateCustomer(@RequestBody Customer customer) {

        try {
            return ResponseGenerator.generateResponseDTO(customerService.updateCustomer(customer));
        } catch (Exception ex) {
            return ResponseGenerator.generateExceptionDTO(ex);
        }
    }

    /**
     * Find all customers with an address in common
     * @param address a de-serialized JSON object representing an address
     * @return a DTO containing a list of customers with the given address
     */
    @GetMapping("/by-address")
    public ResponseDTO findByAddress(@RequestBody Address address) {
        try {
            return ResponseGenerator.generateResponseDTO(customerService.findByAddress(address));
        } catch (Exception ex) {
            return ResponseGenerator.generateExceptionDTO(ex);
        }
    }

    /**
     * Create new customers from a list
     * @param customers a deserialized JSON object representing a list of customers
     * @return a list of newly created customer objects for further operations
     */
    @PostMapping("/add-all")
    public ResponseDTO addAll(@RequestBody ArrayList<Customer> customers) {
        try {
            return ResponseGenerator.generateResponseDTO(customerService.addAll(customers));
        } catch (Exception ex) {
            return ResponseGenerator.generateExceptionDTO(ex);
        }
    }
}
