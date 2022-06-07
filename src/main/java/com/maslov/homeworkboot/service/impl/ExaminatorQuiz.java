package com.maslov.homeworkboot.service.impl;

import com.maslov.homeworkboot.domain.Quiz;
import com.maslov.homeworkboot.service.Examinator;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class ExaminatorQuiz implements Examinator {

    MessageSource messages;

    private static final String FIRST_NAME= "properties.name";
    private static final String LAST_NAME = "properties.lastName";

    public ExaminatorQuiz(MessageSource messages) {
        this.messages = messages;
    }

    @Override
    public void askQuestion(Quiz quiz) {
        System.out.println(quiz.getQuestion());
        System.out.println(quiz.getAnswer1());
        System.out.println(quiz.getAnswer2());
        System.out.println(quiz.getAnswer3());
    }

    @Override
    public void askFirstName() {
        System.out.println(getMessage(FIRST_NAME));
    }

    @Override
    public void askLastName() {
        System.out.println(getMessage(LAST_NAME));
    }

    @Override
    public boolean checkAnswer(int guess, Quiz quiz) {
        return guess == quiz.getRightValue();
    }

    @Override
    public String getResult(String name, String lastName, int res) {
        return getMessage("student") + " " + name + " " + lastName + " " + getMessage("rightAnswers") +  " " + res;
    }

    private String getMessage(String key) {
        return messages.getMessage(key, null, Locale.getDefault());
    }
}
