package com.maslov.homeworkboot.shell;

import com.maslov.homeworkboot.service.QuizMaster;
import com.maslov.homeworkboot.service.StudentQuiz;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;

@ShellComponent
@RequiredArgsConstructor
public class ApplicationCommands {

    private final QuizMaster master;
    private final StudentQuiz student;


    @ShellMethod(value = "Start quiz", key = {"s", "start"})
    public void startQuiz() {
        master.startQuiz();
    }

    @ShellMethod(value = "GetResult for student", key = {"r", "res", "result"})
    @ShellMethodAvailability(value = "hasName")
    public void getResult() {
        master.getResult();
    }

    private Availability hasName() {
        return student.getFirstName() == null ?
                Availability.unavailable("Enter your name and start quiz before get result") :
                Availability.available();
    }
}
