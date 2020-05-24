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
            return ResponseEntity.ok(questions.findByQuestionContainingIgnoreCase(question));
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

    @PutMapping(path = "/", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Question> updateQuestion(
            @RequestParam("id") String id , @RequestParam("letter") String letter
    ) {
        System.out.println("???????????           ???????????");
        Question questionToEdit = questions.findById(id).orElse(null);
        Question saved = null;
        if(questionToEdit!=null) {
            questionToEdit.answer(letter);
            saved = questions.save(questionToEdit);
        }
        return ResponseEntity.ok(saved);
    }
    @PutMapping(path = "/", produces = "application/json")
    public ResponseEntity<Question> updateQuestion2(
            @RequestParam("id") String id , @RequestParam("letter") String letter
    ) {
        Question questionToEdit = questions.findById(id).orElse(null);
        Question saved = null;
        if(questionToEdit!=null) {
            questionToEdit.answer(letter);
            saved = questions.save(questionToEdit);
        }
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