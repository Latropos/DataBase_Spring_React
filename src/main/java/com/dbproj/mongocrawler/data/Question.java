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

    public void answer(String letter){
        System.out.println("!!!!!!!!!!         !!!!!!!!!!");
        if(letter.equals("a")) {
            this.aCount++;
            System.out.println("!!!!!!!!!!         !!!!!!!!!!"+this.aCount);
        }
        if(letter.equals("b")) this.bCount++;
        if(letter.equals("c")) this.cCount++;
        if(letter.equals("d")) this.dCount++;
        if(letter.equals("e")) this.eCount++;
    }

    public int plusAnswer(String answer){
        if(answer.length()>0) return 1;
        return 0;
    }

    public void countAnswers(){
        this.noAnswers=plusAnswer(this.answerA);
        this.noAnswers+=plusAnswer(this.answerB);
        this.noAnswers+=plusAnswer(this.answerC);
        this.noAnswers+=plusAnswer(this.answerD);
        this.noAnswers+=plusAnswer(this.answerE);
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