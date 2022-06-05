package com.maslov.homeworkboot.domain;

public class Quiz {

    private final Long id;
    private final String question;
    private final String answer1;
    private final String answer2;
    private final String answer3;
    private final int rightValue;

    public Quiz(Long id, String question, String answer1, String answer2, String answer3, int rightValue) {
        this.id = id;
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.rightValue = rightValue;
    }

    public Long getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer1() {
        return answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public int getRightValue() {
        return rightValue;
    }

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