package com.dbproj.mongocrawler.data;

import org.springframework.data.annotation.Id;

public class Question {

    @Id
    public String id;

    public String question;
    public int noAnswers;

    public String answerA;
    public String answerB;
    public String answerC;
    public String answerD;
    public String answerE;

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
    public void answersInit(){
        this.answerA = "";
        this.answerB = "";
        this.answerC = "";
        this.answerD = "";
        this.answerE = "";
    }

    public void countAnswers(){
        this.noAnswers=this.aCount+this.bCount+this.cCount+this.dCount+this.eCount;
    }

    public Question() {
    }

    public Question(String question, int noAnswers, String answerA, String answerB, String answerC, String answerD, String answerE) {
        this.question = question;
        this.noAnswers = noAnswers;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.answerE = answerE;
        this.zeroCount();
        this.countAnswers();
    }
    public Question(String question, int noAnswers, String answerA, String answerB, String answerC, String answerD) {
        this.question = question;
        this.noAnswers = noAnswers;
        this.answersInit();
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.zeroCount();
        this.countAnswers();
    }
    public Question(String question, int noAnswers, String answerA, String answerB, String answerC) {
        this.question = question;
        this.noAnswers = noAnswers;
        this.answersInit();
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.zeroCount();
        this.countAnswers();
    }
    public Question(String question, int noAnswers, String answerA, String answerB) {
        this.question = question;
        this.noAnswers = noAnswers;
        this.answersInit();
        this.answerA = answerA;
        this.answerB = answerB;
        this.zeroCount();
        this.countAnswers();
    }
    @Override
    public String toString() {
        return "Question{" +
                "id='" + id + '\'' +
                ", question='" + question + '\'' +
                ", noAnswers='" + noAnswers + '\'' +
                ", answerA='" + answerA + '\'' +
                ", answerB='" + answerB + '\'' +
                ", answerC='" + answerC + '\'' +
                ", answerD='" + answerD + '\'' +
                ", answerE='" + answerE + '\'' +
                '}';
    }
}