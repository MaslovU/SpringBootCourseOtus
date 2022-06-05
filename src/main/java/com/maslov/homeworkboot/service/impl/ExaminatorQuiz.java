package com.maslov.homeworkboot.service.impl;

import com.maslov.homeworkboot.domain.Quiz;
import com.maslov.homeworkboot.service.Examinator;
import org.springframework.stereotype.Service;

@Service
public class ExaminatorQuiz implements Examinator {

    @Override
    public void askQuestion(Quiz quiz) {
        System.out.println(quiz.getQuestion());
        System.out.println(quiz.getAnswer1());
        System.out.println(quiz.getAnswer2());
        System.out.println(quiz.getAnswer3());
    }

    @Override
    public void askFirstName() {
        System.out.println("What is your firstName?");
    }

    @Override
    public void askLastName() {
        System.out.println("What is your lastName?");
    }

    @Override
    public boolean checkAnswer(int guess, Quiz quiz) {
        return guess == quiz.getRightValue();
    }

    @Override
    public String getResult(String name, String lastName, int res) {
        return "Student " + name + " " + lastName + " has " + res + " right answers";
    }
}
