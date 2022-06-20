package com.maslov.homeworkboot.service;

import com.maslov.homeworkboot.domain.Quiz;

public interface QuizService {

    String getQuestion(Quiz quiz);
    String getAnswer1(Quiz quiz);
    String getAnswer2(Quiz quiz);
    String getAnswer3(Quiz quiz);

}
