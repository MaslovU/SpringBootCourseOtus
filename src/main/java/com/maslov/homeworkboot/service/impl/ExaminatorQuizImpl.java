package com.maslov.homeworkboot.service.impl;

import com.maslov.homeworkboot.domain.Quiz;
import com.maslov.homeworkboot.service.ExaminatorQuiz;
import com.maslov.homeworkboot.service.MessageService;
import com.maslov.homeworkboot.service.QuizService;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

@Service
public class ExaminatorQuizImpl implements ExaminatorQuiz {

    MessageService messageService;
    QuizService quizService;

    private static final String FIRST_NAME= "properties.name";
    private static final String LAST_NAME = "properties.lastName";

    public ExaminatorQuizImpl(MessageService messageService, QuizService quizService) {
        this.messageService = messageService;
        this.quizService = quizService;
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
        return messageService.getMessage(key);
    }

    private String getQuestion(Quiz quiz) {
        return quizService.getQuestion(quiz);
    }

    private String getAnswer1(Quiz quiz) {
        return quizService.getAnswer1(quiz);
    }

    private String getAnswer2(Quiz quiz) {
        return quizService.getAnswer2(quiz);
    }

    private String getAnswer3(Quiz quiz) {
        return quizService.getAnswer3(quiz);
    }
}
