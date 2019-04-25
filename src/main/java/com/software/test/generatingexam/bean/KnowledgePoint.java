package com.software.test.generatingexam.bean;

public class KnowledgePoint {

    private int id;
    private String number;
    private int score;
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "KnowledgePoint{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", score=" + score +
                ", title='" + title + '\'' +
                '}';
    }
}
