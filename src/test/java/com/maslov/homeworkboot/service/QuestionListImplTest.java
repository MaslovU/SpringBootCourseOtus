package com.maslov.homeworkboot.service;

import com.maslov.homeworkboot.dao.impl.DataHandlerImpl;
import com.maslov.homeworkboot.domain.Quiz;
import com.maslov.homeworkboot.service.impl.QuestionListImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.when;

@SpringJUnitConfig(QuestionListImpl.class)
class QuestionListImplTest {

    @MockBean
    private DataHandlerImpl handler;

    @Autowired
    private QuestionList questionList;

    @Test
    void checkFirstId() {
        ArrayList<String[]> testQuiz = new ArrayList<>();
        testQuiz.add(new String[]{"1", "who is elephant?", "1 animal", "2 car", "3 house", "1"});
        testQuiz.add(new String[]{"2","who is eagle?","1 car","2 bird","3 house","2"});
        testQuiz.add(new String[]{"3","that is tower?","1 building","2 car","3 fish","1"});
        testQuiz.add(new String[]{"4","who is shark?","1 car","2 house","3 fish","3"});
        testQuiz.add(new String[]{"5","who is java?","1 car","2 language","3 house","2"});

        when(handler.getResourceAsStream()).thenReturn(testQuiz);
        List<Quiz> list = questionList.getQuiz();
        assert list.get(0).getId() == 1;
        assert list.get(1).getQuestion().equals("who is eagle?");
    }

    @Test
    void checkFirstQuestion() {
        List<Quiz> list = questionList.getQuiz();
        assertNotEquals("", list.get(0).getQuestion());
    }
}
