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
        this.NoAnswers = noAnswers;
    }

    public Question() {
        this.question = question;
        this.NoAnswers = 0;
        this.AnswerA = "";
        this.AnswerB = "";
        this.AnswerC = "";
        this.AnswerD = "";
        this.AnswerE = "";
    }

    public Question(String question, String noAnswers) {
        this.question = question;
        this.NoAnswers = 7;
    }

    public Question(String question, int noAnswers, String answerA, String answerB, String answerC, String answerD, String answerE) {
        this.question = question;
        this.NoAnswers = noAnswers;
        this.AnswerA = answerA;
        this.AnswerB = answerB;
        this.AnswerC = answerC;
        this.AnswerD = answerD;
        this.AnswerE = answerE;
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