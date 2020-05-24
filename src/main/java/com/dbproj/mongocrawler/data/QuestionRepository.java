package com.dbproj.mongocrawler.data;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface QuestionRepository extends MongoRepository<Questi, String> {

    public List<Questi> findByQuestionContainingIgnoreCase(String question);

}
