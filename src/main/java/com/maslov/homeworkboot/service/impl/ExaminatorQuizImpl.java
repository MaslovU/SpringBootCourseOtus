package com.maslov.homeworkboot.service.impl;

import com.maslov.homeworkboot.domain.Quiz;
import com.maslov.homeworkboot.service.ExaminatorQuiz;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class ExaminatorQuizImpl implements ExaminatorQuiz {

    MessageSource messages;

    private static final String FIRST_NAME= "properties.name";
    private static final String LAST_NAME = "properties.lastName";

    public ExaminatorQuizImpl(MessageSource messages) {
        this.messages = messages;
    }

    @Override
    public void askQuestion(Quiz quiz) {
        System.out.println(getQuestion(quiz));
        System.out.println(getAnswer1(quiz));
        System.out.println(getAnswer2(quiz));
        System.out.println(getAnswer3(quiz));
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

    private String getQuestion(Quiz quiz) {
        return quiz.getQuestion();
    }

    private String getAnswer1(Quiz quiz) {
        return quiz.getAnswer1();
    }

    private String getAnswer2(Quiz quiz) {
        return quiz.getAnswer2();
    }

    private String getAnswer3(Quiz quiz) {
        return quiz.getAnswer3();
    }
}
