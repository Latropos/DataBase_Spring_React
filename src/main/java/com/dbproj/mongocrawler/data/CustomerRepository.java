package com.dbproj.mongocrawler.data;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, String> {

    public List<Customer> findByFirstNameContainingIgnoreCase(String firstName);
    public List<Customer> findByLastName(String lastName);

}