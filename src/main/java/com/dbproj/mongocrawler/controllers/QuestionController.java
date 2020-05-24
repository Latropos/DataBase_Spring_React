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
            @RequestParam(required = false) String questionText
    ) {
        if (!Strings.isBlank(questionText)) {
            return ResponseEntity.ok(questions.findByQuestionTextContainingIgnoreCase(questionText));
        }
        return ResponseEntity.ok(questions.findAll());
    }

    @PostMapping(path = "/", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Question> createQuestion(
            @RequestBody Question customerToCreate
    ) {
        Question saved = questions.save(customerToCreate);
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