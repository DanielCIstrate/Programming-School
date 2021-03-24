package com.codecool.school;

public enum Module {
    ADVANCED(Language.JAVA_EE) {
        @Override
        public Module nextModule() {
            return null;
        }
    },
    OOP(Language.JAVA_SE) {
        @Override
        public Module nextModule() {
            return Module.ADVANCED;
        }
    },
    WEB(Language.WEB) {
        @Override
        public Module nextModule() {
            return Module.OOP;
        }
    } ,

    PB(Language.PYTHON) {
        @Override
        public Module nextModule() {
            return Module.WEB;
        }
    };


    public Language language;

    Module(Language language) {
        this.language = language;
    }

    public abstract Module nextModule ();

    public Language getLanguage() {
        return language;
    }
}

