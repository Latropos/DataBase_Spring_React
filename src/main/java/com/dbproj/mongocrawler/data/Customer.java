package com.dbproj.mongocrawler.data;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Customers")
public class Customer {

    @Id
    public String id;

    public String firstName;
    public String lastName;

    public String answerA = "Init A";
    public String answerB;
    public String answerC;
    public String answerD;
    public String answerE;



  /*  public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
*/


    public Customer(String firstName, String lastName, String answerA, String answerB, String answerC, String answerD, String answerE) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.answerA = answerA;
        this.answerB = answerB;
        this.answerC = answerC;
        this.answerD = answerD;
        this.answerE = answerE;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

}