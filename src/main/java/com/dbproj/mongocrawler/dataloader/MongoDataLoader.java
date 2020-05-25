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

        // save a couple of questions
        repository.save(new Question("To be or not to be?", 2, "To be!", "Not to be."));
        repository.save(new Question("What is your favourite answer?", 5, "A", "B","C", "D", "E"));
        repository.save(new Question("What is your favourite emoji?", 5, "(-:", ":-)", "<3", ":-P", ":-O"));


        // fetch all questions
        System.out.println("Questions found with findAll():");
        System.out.println("-------------------------------");
        for (Question q : repository.findAll()) {
            System.out.println(q);
        }
        System.out.println();

        // fetch an individual q
        System.out.println("Question found with findByQuestion('Hello?'):");
        System.out.println("--------------------------------");
        System.out.println(repository.findByQuestionContainingIgnoreCase("Hello"));

    }
}