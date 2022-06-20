package com.maslov.homeworkboot.service.impl;

import com.maslov.homeworkboot.domain.Quiz;
import com.maslov.homeworkboot.service.QuizService;
import org.springframework.stereotype.Service;

@Service
public class QuizServiceImpl implements QuizService {
    @Override
    public String getQuestion(Quiz quiz) {
        return quiz.getQuestion();
    }

    @Override
    public String getAnswer1(Quiz quiz) {
        return quiz.getAnswer1();
    }

    @Override
    public String getAnswer2(Quiz quiz) {
        return quiz.getAnswer2();
    }

    @Override
    public String getAnswer3(Quiz quiz) {
        return quiz.getAnswer3();
    }

    @Override
    public int getRightValue(Quiz quiz) {
        return quiz.getRightValue();
    }
}
