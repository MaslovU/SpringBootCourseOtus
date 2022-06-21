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

        for (var el : resList) {
            examinator.askQuestion(el);

            int res = student.getAnswer();

            if (examinator.checkAnswer(res, el)) {
                counter++;
            }
        }
        System.out.println("If you want get your result enter command: res");
    }

    @Override
    public void getResult() {
        String firstName = student.getFirstName();
        String lastName = student.getLastName();
        System.out.println(examinator.getResult(firstName, lastName, counter));
        log.info("Student {} {} has {} right result", firstName, lastName, counter);
        System.out.println("If you want start new quiz enter command s");
    }
}
