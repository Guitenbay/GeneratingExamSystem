package com.software.test.generatingexam.bean;

public class Syllabus {

    private int id;
    private boolean disabled;
    private String level;
    private String version;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Syllabus{" +
                "id=" + id +
                ", disabled=" + disabled +
                ", level='" + level + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
