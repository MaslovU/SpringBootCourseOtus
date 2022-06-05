package com.maslov.homeworkboot.service.impl;

import com.maslov.homeworkboot.service.Student;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class StudentQuiz implements Student {
    private String name;
    private String lastName;

    @Override
    public int getAnswer() throws IOException, NumberFormatException {
        while (true) {
            try {
                System.out.println("Enter your answer: ");
                return Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());

            } catch (NumberFormatException e) {
                System.out.println("Enter number, please. Try again");
            }
        }
    }

    public String getFirstName() {
        return name;
    }

    public void setFirstName() throws IOException {
        this.name = new BufferedReader(new InputStreamReader(System.in)).readLine();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName() throws IOException {
        this.lastName = new BufferedReader(new InputStreamReader(System.in)).readLine();
    }
}
