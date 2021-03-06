package com.maslov.homeworkboot.service;

import com.maslov.homeworkboot.domain.Quiz;
import com.maslov.homeworkboot.service.impl.ExaminatorQuizImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.context.MessageSourceAutoConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Description;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ImportAutoConfiguration(MessageSourceAutoConfiguration.class)
@SpringJUnitConfig(ExaminatorQuizImpl.class)
class ExaminatorQuizImplTest {

    private static final String PROPERTIES_MANE = "properties.name";

    @MockBean
    private Quiz quiz;

    @MockBean
    private QuizService quizService;

    @MockBean
    private MessageService messageService;

    @MockBean
    private MessageSource messageSource;

    @Autowired
    private ExaminatorQuiz examinatorQuiz;

    @Test
    @Description("check quiz methods call")
    void test1() {

        examinatorQuiz.askQuestion(quiz);

        verify(quiz, Mockito.times(0)).getQuestion();
        verify(quiz, Mockito.times(0)).getAnswer1();
        verify(quiz, Mockito.times(0)).getAnswer2();
        verify(quiz, Mockito.times(0)).getAnswer3();
    }

    @Test
    @Description("check getResult method")
    void test2() {

        String expString = "студент Y M дал правильных ответов 3";

        when(messageService.getMessage("student")).thenReturn("студент");
        when(messageService.getMessage("rightAnswers")).thenReturn("дал правильных ответов");
        when(messageService.getMessage(anyString(), anyString(), anyString()))
                .thenReturn("студент Y M дал правильных ответов 3");

        String res = examinatorQuiz.getResult("Y", "M", 3);

        assertEquals(res, expString);
    }

    @Test
    @Description("check checkAnswer method true")
    void test3() {

        when(quizService.getRightValue(quiz)).thenReturn(3);

        boolean res = examinatorQuiz.checkAnswer(3, quiz);

        assertTrue(res);
    }

    @Test
    @Description("check checkAnswer method false")
    void test4() {

        when(quiz.getRightValue()).thenReturn(1);

        boolean res = examinatorQuiz.checkAnswer(3, quiz);

        assertFalse(res);
    }

    @Test
    @Description("check getMessage method call")
    void test5() {

        examinatorQuiz.askFirstName();

        verify(messageService, Mockito.times(1)).getMessage(anyString());
        verify(messageSource, Mockito.times(0)).getMessage(PROPERTIES_MANE, null, Locale.getDefault());

    }
}
