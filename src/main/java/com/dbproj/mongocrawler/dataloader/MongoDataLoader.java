package com.dbproj.mongocrawler.dataloader;

import com.dbproj.mongocrawler.data.Question;
import com.dbproj.mongocrawler.data.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MongoDataLoader implements CommandLineRunner {

    @Autowired
    private QuestionRepository repository;

    /**
     * Seed data into the database
     *
     * @param args
     */
    @Override
    public void run(String... args) throws Exception {

        repository.deleteAll();

        // save a couple of customers
        repository.save(new Question("What is your favorite answer", "Smith", "A", "B", "C", "D", "E"));
        // repository.save(new Customer("Bob", "smith"));



        // fetch all customers

        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Question customer : repository.findAll()) {
            System.out.println(customer);
        }
        System.out.println();

        // fetch an individual customer
        System.out.println("Customer found with findByFirstName('Alice'):");
        System.out.println("--------------------------------");
        System.out.println(repository.findByQuestionTextContainingIgnoreCase("Alice"));
/*
        System.out.println("Customers found with findByLastName('Smith'):");
        System.out.println("--------------------------------");
        for (Customer customer : repository.findByLastName("Smith")) {
            System.out.println(customer);
        }

 */
    }
}