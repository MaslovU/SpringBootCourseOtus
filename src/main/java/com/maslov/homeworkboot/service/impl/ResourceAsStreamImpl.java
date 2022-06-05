package com.maslov.homeworkboot.service.impl;

import com.maslov.homeworkboot.service.ResourceAsStream;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Scanner;

@Component
public class ResourceAsStreamImpl implements ResourceAsStream {
    @Override
    public Scanner getResourceAsStream(String csvPath) {
        return new Scanner(Objects.requireNonNull(
                this.getClass().getClassLoader().getResourceAsStream(csvPath)));
    }
}