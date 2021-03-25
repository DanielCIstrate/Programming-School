package com.codecool.school;

import java.util.concurrent.ThreadLocalRandom;

public class SalesPerson extends Staff {


    public SalesPerson(String name, String phoneNumber, String birthDate) {
        super(name, phoneNumber, birthDate);
    }

    @Override
    public void update() {
        // 0.8% chance of salary increase :D
        // boolean salaryIncrease = ThreadLocalRandom.current().nextInt(125) == 0;
        School.STUDENTS.forEach(this::offerJob);
    }

    private void offerJob(Student student) {
        if (student.getModuleLearning() == null)
            System.out.println("SalesPerson " + this.getName() + " says: " +"Student " + student.getName() + " will be offered a job as " +
                    "a Junior Developer with a company");
    }
}
