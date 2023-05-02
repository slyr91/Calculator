/*
Arouchian, Daryl
9/30/2018
*/
package com.example.calculator.logic;

public class SimpleAnswer implements Answer {
    private double answer;

    public SimpleAnswer(double answer) {
        this.answer = answer;
    }

    @Override
    public double getAnswer() {
        return answer;
    }
}
