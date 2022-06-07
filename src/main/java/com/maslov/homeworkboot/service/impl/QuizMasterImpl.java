package com.maslov.homeworkboot.service.impl;

import com.maslov.homeworkboot.domain.Quiz;
import com.maslov.homeworkboot.service.Examinator;
import com.maslov.homeworkboot.service.QuestionList;
import com.maslov.homeworkboot.service.QuizMaster;
import com.maslov.homeworkboot.service.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class QuizMasterImpl implements QuizMaster {

    private final QuestionList questionDao;
    private final Examinator examinator;
    private final Student student;

    private int counter;

    public QuizMasterImpl(QuestionList questionList, Examinator examinator, Student student) {
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
