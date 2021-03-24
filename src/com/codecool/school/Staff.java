package com.codecool.school;

import java.util.Objects;

public abstract class Staff extends Person{
    private double salary;

    public Staff(String name, String phoneNumber, String birthDate) {
        super(name, phoneNumber, birthDate);
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


    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}