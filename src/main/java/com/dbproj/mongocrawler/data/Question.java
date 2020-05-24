package com.dbproj.mongocrawler.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Questions")
public class Question {

    @Id
    public String id;

    public String questionText;
    public String noAnswers;

    public String answerA;
    public String answerB;
    public String answerC;
    public String answerD;
    public String answerE;

    public Question(String questionText, String noAnswers, String answerA, String answerB, String answerC, String answerD, String answerE) {
        this.questionText = questionText;
        this.noAnswers = noAnswers;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.answerE = answerE;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id='" + id + '\'' +
                ", questionText='" + questionText + '\'' +
                ", noAnswers='" + noAnswers + '\'' +
                ", answerA='" + answerA + '\'' +
                ", answerB='" + answerB + '\'' +
                ", answerC='" + answerC + '\'' +
                ", answerD='" + answerD + '\'' +
                ", answerE='" + answerE + '\'' +
                '}';
    }
}