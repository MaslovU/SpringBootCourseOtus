package com.maslov.homeworkboot.service.impl;

import com.maslov.homeworkboot.exceptions.StupidUserException;
import com.maslov.homeworkboot.service.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
@Slf4j
public class StudentQuiz implements Student {

    private String name;
    private String lastName;

    @Override
    public int getAnswer() throws NumberFormatException {
        while (true) {
            try {
                System.out.println("Enter your answer: ");
                return Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
            } catch (NumberFormatException e) {
                System.out.println("Enter number, please. Try again");
            } catch (IOException e) {
                log.warn("Could not get data from user");
            }
        }
    }

    public String getFirstName() {
        return name;
    }

    public void setFirstName() {
        try {
            this.name = new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
            log.warn("Could not get firstName from user! Try again");
            throw new StupidUserException("Could not get firstName from user");
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName() {
        try {
            this.lastName = new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
            log.warn("Could not get lastName from user");
            throw new StupidUserException("Could not get lastName from user");
        }
    }
}
