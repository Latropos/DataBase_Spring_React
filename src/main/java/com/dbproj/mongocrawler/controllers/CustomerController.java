package com.dbproj.mongocrawler.controllers;


import com.dbproj.mongocrawler.data.Customer;
import com.dbproj.mongocrawler.data.CustomerRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customers;

    @GetMapping(path = "/", produces = "application/json")
    public ResponseEntity<List<Customer>> findAllCustomers(
            @RequestParam(required = false) String firstName
    ) {
        if (!Strings.isBlank(firstName)) {
            return ResponseEntity.ok(customers.findByFirstNameContainingIgnoreCase(firstName));
        }
        return ResponseEntity.ok(customers.findAll());
    }

    @PostMapping(path = "/", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Customer> createCustomer(
            @RequestBody Customer customerToCreate
    ) {
        Customer saved = customers.save(customerToCreate);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping(path = "/", produces = "application/json")
    public ResponseEntity<String> deleteCustomer(
            @RequestParam String id
    ) {
        customers.deleteById(id);
        return ResponseEntity.ok("Success");
    }

}