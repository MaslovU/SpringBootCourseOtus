package com.maslov.homeworkboot.service;

import com.maslov.homeworkboot.domain.Quiz;
import com.maslov.homeworkboot.service.impl.ExaminatorQuizImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Description;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import javax.annotation.Resource;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringJUnitConfig(ExaminatorQuizImpl.class)
class ExaminatorQuizImplTest {

    @MockBean
    private Quiz quiz;

    @MockBean
    private MessageSource messageSource;

    @Autowired
    private ExaminatorQuiz examinatorQuiz;

    @Test
    @Description("check quiz methods call")
    void test1() {

        examinatorQuiz.askQuestion(quiz);

        verify(quiz, Mockito.times(1)).getQuestion();
        verify(quiz, Mockito.times(1)).getAnswer1();
        verify(quiz, Mockito.times(1)).getAnswer2();
        verify(quiz, Mockito.times(1)).getAnswer3();
    }

    @Test
    @Description("check getResult methods")
    void test2() {

        String expString = "Y U";

        when(messageSource.getMessage("student", null, Locale.ENGLISH)).thenReturn("Student");
        when(messageSource.getMessage("rightAnswers", null, Locale.getDefault())).thenReturn("Student");

        String res = examinatorQuiz.getResult("Y", "M", 3);

        assertEquals(res, expString);
    }
}
