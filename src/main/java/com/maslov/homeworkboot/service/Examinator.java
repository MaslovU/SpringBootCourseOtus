package com.maslov.homeworkboot.service;

import com.maslov.homeworkboot.domain.Quiz;

public interface Examinator {
    void askQuestion(Quiz resList);

    void askFirstName();

    void askLastName();

    boolean checkAnswer(int guess, Quiz quiz);

    String getResult(String name, String lastName, int res);
}

