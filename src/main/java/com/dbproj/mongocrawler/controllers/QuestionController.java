package com.dbproj.mongocrawler.controllers;
import com.dbproj.mongocrawler.data.Question;
import com.dbproj.mongocrawler.data.QuestionRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/questions")
public class QuestionController {

    @Autowired
    private QuestionRepository questions;

    @GetMapping(path = "/", produces = "application/json")
    public ResponseEntity<List<Question>> findAllQuestions(
            @RequestParam(required = false) String question
    ) {
        if (!Strings.isBlank(question)) {
            return ResponseEntity.ok(questions.findByQuestion(question));
        }
        return ResponseEntity.ok(questions.findAll());
    }

    @PostMapping(path = "/", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Question> createQuestion(
            @RequestBody Question questionToCreate
    ) {
        Question saved = questions.save(questionToCreate);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping(path = "/", produces = "application/json")
    public ResponseEntity<String> deleteQuestion(
            @RequestParam String id
    ) {
        questions.deleteById(id);
        return ResponseEntity.ok("Success");
    }

}

/*package com.dbproj.mongocrawler.controllers;


import com.dbproj.mongocrawler.data.Questi;
import com.dbproj.mongocrawler.data.QuestionRepository;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/questions")
public class QuestionController {

    @Autowired
    private QuestionRepository questions;

    @GetMapping(path = "/", produces = "application/json")
    public ResponseEntity<List<Questi>> findAllCustomers(
            @RequestParam(required = false) String firstName
    ) {
        if (!Strings.isBlank(firstName)) {
            return ResponseEntity.ok(questions.findByQuestionContainingIgnoreCase(firstName));
        }
        return ResponseEntity.ok(questions.findAll());
    }

    @PostMapping(path = "/", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Questi> createCustomer(
            @RequestBody Questi customerToCreate
    ) {
        Questi saved = questions.save(customerToCreate);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping(path = "/", produces = "application/json")
    public ResponseEntity<String> deleteCustomer(
            @RequestParam String id
    ) {
        questions.deleteById(id);
        return ResponseEntity.ok("Success");
    }

}*/