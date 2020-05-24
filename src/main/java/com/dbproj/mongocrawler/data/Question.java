package com.dbproj.mongocrawler.data;

import org.springframework.data.annotation.Id;

public class Question {

    @Id
    public String id;

    public String question;
    public int noAnswers;

    public String AnswerA;
    public String AnswerB;
    public String AnswerC;
    public String AnswerD;
    public String AnswerE;

    public int aCount;
    public int bCount;
    public int cCount;
    public int dCount;
    public int eCount;

    public void zeroCount(){
        this.aCount=57;
        this.bCount=30;
        this.cCount=2;
        this.dCount=100;
        this.eCount=9;
    }
    public Question(String question, int noAnswers) {
        this.question = question;
        this.noAnswers = noAnswers;
        this.zeroCount();
        this.countAnswers();
    }


    public Question() {
        this.question = question;
        this.noAnswers = 0;
        this.AnswerA = "";
        this.AnswerB = "";
        this.AnswerC = "";
        this.AnswerD = "";
        this.AnswerE = "";
        this.zeroCount();
        this.countAnswers();
    }

    public Question(String question, String noAnswers) {
        this.question = question;
        this.noAnswers = 5;
        this.zeroCount();
        this.countAnswers();
    }

    public void countAnswers(){
        this.noAnswers=this.aCount+this.bCount+this.cCount+this.dCount+this.eCount;
    }

    public Question(String question, int noAnswers, String answerA, String answerB, String answerC, String answerD, String answerE) {
        this.question = question;
        this.noAnswers = noAnswers;
        this.AnswerA = answerA;
        this.AnswerB = answerB;
        this.AnswerC = answerC;
        this.AnswerD = answerD;
        this.AnswerE = answerE;
        this.zeroCount();
        this.countAnswers();
    }
    @Override
    public String toString() {
        return "Question{" +
                "id='" + id + '\'' +
                ", question='" + question + '\'' +
                ", noAnswers=" + noAnswers +
                ", AnswerA='" + AnswerA + '\'' +
                ", AnswerB='" + AnswerB + '\'' +
                ", AnswerC='" + AnswerC + '\'' +
                ", AnswerD='" + AnswerD + '\'' +
                ", AnswerE='" + AnswerE + '\'' +
                '}';
    }
}