package com.codecool.school;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Mentor extends Staff {
    private final Set<Language> languages = new HashSet<>();
    private Module moduleTeaching;

    public Mentor() {}

    public void addLanguage(Language newLanguage) {
        languages.add(newLanguage);

    }

    public boolean knowsLanguage(Language language) {
        return languages.contains(language);
    }

    public boolean assignToModule(Module module) {
        if (knowsLanguage(module.getLanguage())){
            this.moduleTeaching = module;
            return true;
        } else {
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
