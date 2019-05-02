package com.software.test.generatingexam.bean;

public class Choice {

    private String label;
    private String content;
    private boolean correct;

    public String getLabel() {
        return label;
    }

    public String getContent() {
        return content;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    @Override
    public String toString() {
        return "Choice{" +
                "label='" + label + '\'' +
                ", content='" + content + '\'' +
                ", correct=" + correct +
                '}';
    }
}
