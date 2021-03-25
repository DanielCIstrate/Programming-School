package com.codecool.school;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Staff extends Person {
    private double salary;

    public Staff(String name, String phoneNumber, String birthDate) {
        super(name, phoneNumber, birthDate);
        this.setSalary(2500.0);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Staff)) return false;
        if (!super.equals(o)) return false;
        Staff staff = (Staff) o;
        return Double.compare(staff.salary, salary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), salary);
    }

}

