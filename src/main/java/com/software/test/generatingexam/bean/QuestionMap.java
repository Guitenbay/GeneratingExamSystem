package com.software.test.generatingexam.bean;

public class QuestionMap {

    private int number;
    private int QuestionId;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getQuestionId() {
        return QuestionId;
    }

    public void setQuestionId(int questionId) {
        QuestionId = questionId;
    }

    @Override
    public String toString() {
        return "QuestionMap{" +
                "number=" + number +
                ", QuestionId=" + QuestionId +
                '}';
    }
}
