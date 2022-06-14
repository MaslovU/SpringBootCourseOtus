package com.maslov.homeworkboot;

import com.maslov.homeworkboot.service.QuizMaster;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class OtusSpringBootHomeApplication {

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext application = SpringApplication.run(OtusSpringBootHomeApplication.class, args);
        application.getBean(QuizMaster.class).startQuiz();
    }

}
