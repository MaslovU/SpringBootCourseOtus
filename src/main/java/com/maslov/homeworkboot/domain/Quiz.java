package com.maslov.homeworkboot.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class Quiz {

    private final Long id;
    private final String question;
    private final String answer1;
    private final String answer2;
    private final String answer3;
    private final int rightValue;

    @Override
    public String toString() {
        return "Quiz{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answer1='" + answer1 + '\'' +
                ", answer2='" + answer2 + '\'' +
                ", answer3='" + answer3 + '\'' +
                ", rightValue=" + rightValue +
                '}';
    }
}
