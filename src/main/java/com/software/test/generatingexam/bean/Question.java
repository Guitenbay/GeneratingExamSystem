package com.software.test.generatingexam.bean;

import java.util.List;

public class Question {

    private int id;
    private String stem;
    private int difficulty;
    private int score;
    private Status status;  // 联表
    private Type type;    // 联表
    private List<Choice> choices; // 联表

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStem() {
        return stem;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public int getScore() {
        return score;
    }

    public Status getStatus() {
        return status;
    }

    public Type getType() {
        return type;
    }

    public void setStem(String stem) {
        this.stem = stem;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    public List<Choice> getChoices() {
        return choices;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", stem='" + stem + '\'' +
                ", difficulty=" + difficulty +
                ", score=" + score +
                ", status=" + status +
                ", type=" + type +
                ", choices=" + choices +
                '}';
    }
}
