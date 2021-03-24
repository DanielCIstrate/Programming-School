package com.codecool.school;

import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

public class Student extends Person{
    private Module moduleLearning;
    private int progress;

    public Student(String name, String phoneNumber, String birthDate) {
        super(name, phoneNumber, birthDate);
        this.moduleLearning = Module.PB;
        this.progress = 0;
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
        if (progress < 100) {
            setProgress(progress + 20);
        } else {
            Optional<Module> studentStatus = Optional.ofNullable(moduleLearning);
            studentStatus.ifPresentOrElse(
                    (studyingModule)
                            -> {
                        moduleLearning.nextModule();
                    },

                    ()
                            -> {
                        System.out.println(getName() + " has finished school.");
                    });

        }

    }

    @Override
    public String toString() {
        return "Student{" + "Name=" + this.getName() +
                ", birthDate=" + this.getBirthDate() +
                ", phoneNumber= " + this.getPhoneNumber() +
                ", moduleLearning=" + ((moduleLearning != null) ? moduleLearning : "graduated" ) +
                ", progress=" + progress +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return progress == student.progress && moduleLearning == student.moduleLearning;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), moduleLearning, progress);
    }
}

