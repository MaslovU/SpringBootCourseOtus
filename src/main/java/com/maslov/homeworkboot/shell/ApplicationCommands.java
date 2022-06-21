package com.maslov.homeworkboot.shell;

import com.maslov.homeworkboot.service.QuizMaster;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@RequiredArgsConstructor
public class ApplicationCommands {

    private final QuizMaster master;


    @ShellMethod(value = "Start quiz", key = {"s", "start"})
    public void startQuiz() {;
        master.startQuiz();
    }

    @ShellMethod(value = "GetResult for student", key = {"r", "res", "result"})
    public void getResult() {
        master.getResult();
    }
}
