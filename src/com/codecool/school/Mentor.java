package com.codecool.school;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Mentor extends Staff {
    private final Set<Language> languages = new HashSet<>();
    private Module moduleTeaching;

    public Mentor(String name, String phoneNumber, String birthDate) {
        super(name, phoneNumber, birthDate);
        this.setSalary(3000.0);
    }


    public void addLanguage(Language newLanguage) {
        languages.add(newLanguage);

    }

    public boolean knowsLanguage(Language language) {
        return languages.contains(language);
    }

    public boolean assignToModule(Module module) {
        if (knowsLanguage(module.getLanguage())){
            this.moduleTeaching = module;
            System.out.println(this.getName() + " was successfully assigned to " + moduleTeaching);
            return true;
        } else {
            System.out.println("Oops. We cannot assign " + this.getName() + " to " + module);
            return false;
        }
    }

    @Override
    public void update() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mentor)) return false;
        if (!super.equals(o)) return false;
        Mentor mentor = (Mentor) o;
        return Objects.equals(languages, mentor.languages) && moduleTeaching == mentor.moduleTeaching;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), languages, moduleTeaching);
    }
}
