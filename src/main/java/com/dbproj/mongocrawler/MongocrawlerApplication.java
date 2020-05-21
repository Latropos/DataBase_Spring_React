package com.dbproj.mongocrawler;

import com.dbproj.mongocrawler.data.Customer;
import com.dbproj.mongocrawler.data.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongocrawlerApplication {

    @Autowired
    public static void main(String[] args) {
        SpringApplication.run(MongocrawlerApplication.class, args);
    }

}
