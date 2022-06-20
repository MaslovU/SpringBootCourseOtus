package com.maslov.homeworkboot.service.impl;

import com.maslov.homeworkboot.dao.impl.DataHandlerImpl;
import com.maslov.homeworkboot.domain.Quiz;
import com.maslov.homeworkboot.service.QuestionList;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@Slf4j
public class QuestionListImpl implements QuestionList {

    private final DataHandlerImpl handler;

    public QuestionListImpl(DataHandlerImpl handler) {
        this.handler = handler;
    }

    @Override
    public List<Quiz> getQuiz() {

        List<Quiz> queue = new LinkedList<>();
        try {
            List<String[]> dataGetter = handler.getResourceAsStream();
            for (var el : dataGetter) {
                queue.add(new Quiz(
                        Long.parseLong(el[0]), el[1], el[2], el[3], el[4], Integer.parseInt(el[5].trim())));
            }
        } catch (NullPointerException e) {
            log.error("Got null classPath for csvPath");
        }
        return queue;
    }
}

