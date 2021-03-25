package com.codecool.school;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class School {
    private Set<Staff> employees = new HashSet<>();
    public static Set<Student> STUDENTS = new HashSet<>();

    public static void main (String[] args) {
        School codecool = new School();



        //Adding students
        Student danny = new Student("Daniel Istrate", "0755 000 000", "15.10.1991");
        Student stefan = new Student("Stefan Craciun", "0723 111 111", "05.01.1991");
        Student gica = new Student("Gica Nustiuescu", "0733 222 222", "11.01.2001");

        //Tweaking two students
        stefan.setModuleLearning(Module.OOP);
        danny.setModuleLearning(Module.OOP);

        //Adding students to school
        codecool.addStudent(stefan);
        codecool.addStudent(danny);
        codecool.addStudent(gica);

        System.out.println("School started");

        //Adding adam - MENTOR
        Mentor adam = new Mentor("Adam Altar","0720 000 000", "25.03.1990");
        adam.addLanguage(Language.JAVA_SE);
        adam.addLanguage(Language.JAVA_EE);
        codecool.hireEmployee(adam);

        //Adding Ana - SALESPERSON
        SalesPerson ana = new SalesPerson("Ana Paraschiv","021 444 5555","30.05.1997");
        codecool.hireEmployee(ana);


        codecool.simulateForPeriodOfMonths(12);


    }

    public void listStudentsInModule(Module module) {
        STUDENTS.forEach(student -> {
            if (student.getModuleLearning().equals(module))
                System.out.println(student.toString());
        });
    }

    public void addStudent(Student newStudent) {
        if (newStudent != null)
            STUDENTS.add(newStudent);
    }

    public void hireEmployee(Staff newEmployee) {
        if (newEmployee != null) {
            employees.add(newEmployee);
            System.out.println(newEmployee.getName() + " was hired");
        }
    }

    private void simulateForPeriodOfMonths(int monthNumber) {


        Set<Mentor> mentors = new HashSet<>();
        Set<SalesPerson> salesPeople = new HashSet<>();
        employees.forEach(employee -> {
            if (employee instanceof SalesPerson)
                salesPeople.add((SalesPerson) employee);
            else if (employee instanceof Mentor)
                mentors.add((Mentor) employee);
        });


        for (int i = 0; i < monthNumber;i++) {
            System.out.println("Month " + (i+1));
            STUDENTS.forEach(Student::update);
            mentors.forEach(Mentor::update);
            salesPeople.forEach(SalesPerson::update);
            System.out.println("============//============//============");
        }
    }

}
