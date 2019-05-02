package com.software.test.generatingexam.bean;

public class Status {

    private boolean finished;
    private boolean started;
    private String name;

    public boolean isFinished() {
        return finished;
    }

    public boolean isStart() {
        return started;
    }

    public String getName() {
        return name;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public void setStart(boolean started) {
        this.started = started;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Status{" +
                "finished=" + finished +
                ", start=" + started +
                ", name='" + name + '\'' +
                '}';
    }
}
