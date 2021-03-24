package com.codecool.school;

import java.util.HashSet;
import java.util.Set;

public class School {
    private Set<Staff> employees = new HashSet<>();
    private Set<Mentor> mentors = new HashSet<>();
    private Set<Student> students = new HashSet<>();

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

        //Testing correct assignment of Adam
        adam.assignToModule(Module.OOP);
        adam.assignToModule(Module.ADVANCED);

        //Testing failed assignment to Web
        adam.assignToModule(Module.WEB);


        //Show students in OOP
        codecool.listStudentsInModule(Module.OOP);


    }

    public void listStudentsInModule(Module module) {
        students.forEach(student -> {
            if (student.getModuleLearning().equals(module))
                System.out.println(student.toString());
        });
    }

    public void addStudent(Student newStudent) {
        if (newStudent != null)
            students.add(newStudent);
    }

    public void hireEmployee(Staff newEmployee) {
        if (newEmployee != null) {
            employees.add(newEmployee);
            System.out.println(newEmployee.getName() + " was hired");
        }
    }

}
