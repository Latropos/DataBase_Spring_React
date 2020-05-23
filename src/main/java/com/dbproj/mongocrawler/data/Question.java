package com.dbproj.mongocrawler.data;

import org.springframework.data.annotation.Id;

public class Question {

    @Id
    public String id;

    public String question;
    public int NoAnswers;

    public String AnswerA;
    public String AnswerB;
    public String AnswerC;
    public String AnswerD;
    public String AnswerE;

    public Question(String question, int noAnswers) {
        this.question = question;
        NoAnswers = noAnswers;
    }

    public Question(String question, String noAnswers) {
        this.question = question;
        NoAnswers = 7;
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