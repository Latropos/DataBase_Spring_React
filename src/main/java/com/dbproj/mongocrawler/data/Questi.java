package com.dbproj.mongocrawler.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Questions")
public class Questi {

    @Id
    public String id;

    public String firstName;
    public String question;
    public int NoAnswers;

    public String AnswerA;
    public String AnswerB;
    public String AnswerC;
    public String AnswerD;
    public String AnswerE;

    private List<String> AnswerList;

    public Questi(String firstName, String noAnswers) {
        this.firstName = firstName;
        NoAnswers = 7;
    }
/*
    public Question(String question, int noAnswers) {
        this.question = question;
        NoAnswers = noAnswers;
    }

    public Question(String question, int noAnswers, String answerA, String answerB, String answerC, String answerD, String answerE) {
        this.question = question;
        NoAnswers = noAnswers;
        AnswerA = answerA;
        AnswerB = answerB;
        AnswerC = answerC;
        AnswerD = answerD;
        AnswerE = answerE;
    }
*/
    public String getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public int getNoAnswers() {
        return NoAnswers;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id='" + id + '\'' +
                ", question='" + question + '\'' +
                ", NoAnswers=" + NoAnswers +
                ", AnswerA='" + AnswerA + '\'' +
                ", AnswerB='" + AnswerB + '\'' +
                ", AnswerC='" + AnswerC + '\'' +
                ", AnswerD='" + AnswerD + '\'' +
                ", AnswerE='" + AnswerE + '\'' +
                '}';
    }
}