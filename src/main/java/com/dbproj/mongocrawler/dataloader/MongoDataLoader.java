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
        repository.save(new Question("What is your name?", 2, "Dave", "Not Dave"));
        repository.save(new Question("How are you?", 3, "Fine", "Fine", "Fine"));
        repository.save(new Question("How do we sleep while our beds are burning?", 2, "How can we dance when our earth is turning?", "How can we dance when our earth is turning?"));
        repository.save(new Question("Where did You Sleep Last Night'?", 3, "In the pines, in the pines", "Where the sun don't ever shine", "Where the cold wind blows"));
        repository.save(new Question("Hello, I love you\n" +
                "Won't you tell me your name?", 5, "Anabelle", "Mary", "Beatrice", "Georgia", "Stefan"));
        repository.save(new Question("Ile było dni?", 3, "Do utraty sił", "Do utaty tchu", "Tyle było dni"));

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