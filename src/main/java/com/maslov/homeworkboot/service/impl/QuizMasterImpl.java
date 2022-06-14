package com.maslov.homeworkboot.service.impl;

import com.maslov.homeworkboot.domain.Quiz;
import com.maslov.homeworkboot.service.ExaminatorQuiz;
import com.maslov.homeworkboot.service.QuestionList;
import com.maslov.homeworkboot.service.QuizMaster;
import com.maslov.homeworkboot.service.StudentQuiz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class QuizMasterImpl implements QuizMaster {

    private final QuestionList questionDao;
    private final ExaminatorQuiz examinator;
    private final StudentQuiz student;

    private int counter;

    public QuizMasterImpl(QuestionList questionList, ExaminatorQuiz examinator, StudentQuiz student) {
        this.questionDao = questionList;
        this.examinator = examinator;
        this.student = student;
    }

    @Override
    public void startQuiz() {
        List<Quiz> resList = questionDao.getQuiz();

        do {
            examinator.askFirstName();
            student.setFirstName();
        } while (student.getFirstName().isEmpty());

        do {
            examinator.askLastName();
            student.setLastName();
        } while (student.getLastName().isEmpty());

        String firstName = student.getFirstName().equals("") ? "defaultFirstName" : student.getFirstName();
        String lastName = student.getLastName().equals("") ? "defaultLastName" : student.getLastName();
        for (var el : resList) {
            examinator.askQuestion(el);

            int res = student.getAnswer();

            if (examinator.checkAnswer(res, el)) {
                counter++;
            }
        }
        System.out.println(examinator.getResult(firstName, lastName, counter));
        log.info("Student {} {} has {} right result", firstName, lastName, counter);
    }
}
