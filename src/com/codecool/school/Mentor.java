package com.codecool.school;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Mentor extends Staff {
    private final Set<Language> languages = new HashSet<>();
    private Module moduleTeaching;
    private List<Language> availableLanguages;

    public Mentor(String name, String phoneNumber, String birthDate) {
        super(name, phoneNumber, birthDate);
        this.setSalary(3000.0);
        this.availableLanguages = new ArrayList<>() {{
           addLanguage(Language.PYTHON);
           addLanguage(Language.WEB);
           addLanguage(Language.JAVA_SE);
           addLanguage(Language.JAVA_EE);
        }};

    }


    private Language getRandomLanguage(){
        int setSize = availableLanguages.size();
        if (setSize != 0) {
            int itemIndex = ThreadLocalRandom.current().nextInt(setSize);
            Language language = availableLanguages.get(itemIndex);
            availableLanguages.remove(language);

            return language;
        }

        return null;
    }

    private Module getRandomModule(){
        int itemIndex = ThreadLocalRandom.current().nextInt(Module.values().length);

        return Module.values()[itemIndex];
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
        // 8% chance to have finished learning a new language
        boolean learnNewLanguage = ThreadLocalRandom.current().nextInt(25) <= 0;
        Language newLanguage = getRandomLanguage();
        Module newModule = getRandomModule();

        if(learnNewLanguage && newLanguage != null) {
            languages.add(newLanguage);
        }
        assignToModule(newModule);
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
