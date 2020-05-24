package com.dbproj.mongocrawler.data;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface QuestionRepository extends MongoRepository<Question, String> {

    public List<Question> findByQuestion(String question);
    public List<Question> findByQuestionContainingIgnoreCase(String question);
    public List<Question> findAll();

}