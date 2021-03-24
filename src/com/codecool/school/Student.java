package com.codecool.school;

import java.util.Objects;

public class Student extends Person{
    private Module moduleLearning;
    private int progress;

    public Student(String name, String phoneNumber, String birthDate) {
        super(name, phoneNumber, birthDate);
    }


    public Module getModuleLearning() {
        return moduleLearning;
    }

    public int getProgress() {
        return progress;
    }

    public void setModuleLearning(Module moduleLearning) {
        this.moduleLearning = moduleLearning;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }


    @Override
    public void update() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return progress == student.progress && moduleLearning == student.moduleLearning;
    }

    @Override
    public int hashCode() {
        return Objects.hash(moduleLearning, progress);
    }
}
