package com.izmaylov.hw16.model;

public enum Subject {
    BIOLOGY("Биология"), HISTORY("История"), CHEMISTRY("Химия"), MATHEMATICS("Математика"),
    FOREIGN_LANGUAGE("Иностранный язык");


    private String subjectName;


    Subject(String subjectName){
        this.subjectName = subjectName;
    }


    @Override
    public String toString() {
        return subjectName;
    }
}
