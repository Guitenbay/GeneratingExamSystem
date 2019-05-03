package com.software.test.generatingexam.bean;

import java.util.List;

public class Exam {

    private int id;

    private String name;

    private int userId;

    private List<QuestionMap> questions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public List<QuestionMap> getQuestions() {
        return questions;
    }

    public void setQuestions(List<QuestionMap> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userId=" + userId +
                '}';
    }
}
