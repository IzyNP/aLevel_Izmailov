package com.izmaylov.hw16.model;

import com.izmaylov.hw16.utilForStudent.Util;
import lombok.Getter;

import java.util.*;

@Getter
public class Student {
    private  final String name;
    private final String group;
    private Course course;
    boolean isExpelled;
    boolean isGraduate;
    private Map<Subject, Grade> journal = new HashMap();

    public Student(String name, String group) {
        this.name = name;
        this.group = group;
        course = Course.FIST_COURSE;
    }

    public int getCourse(){
        return course.getCourse();
    }

    public Collection<Grade> getGrades(){
        Collection<Grade> grades = journal.values();
        return grades;
    }

    public void changeCourse(){
        if(Util.averageGrade(this) < 3){
            isExpelled = true;
        }else{
            int course = this.course.getCourse();
            course++;
            nextCourse(course);
        }
    }


    public void addSubjectAndGrade(Subject subject, Grade grade){
        journal.putIfAbsent(subject, grade);
    }

    public void changeGradeForSubject(Subject subject,Grade grade){
        journal.computeIfPresent(subject,((subject1, grade1) -> grade));
    }


    private void nextCourse(int number){
        switch (number){
            case 2:
                this.course = Course.SECOND_COURSE;
                break;
            case 3:
                this.course = Course.THIRD_COURSE;
                break;
            case 4:
                this.course = Course.FOURTH_COURSE;
                break;
            case 5:
                this.course = Course.FIFTH_COURSE;
                break;
            case 6:
                this.course = Course.SIXTH_COURSE;
                break;
            default:
                isGraduate = true;
        }
    }

    @Override
    public String toString() {
        if(isExpelled){
            return "Студент " + name + " отчислен";
        }else if(isGraduate){

            return "Студент " + name + "выпустился";
        }
        return "Студент: " + name + ";\n"
                + "Группа:" + group + ";\n"
                + "Курс: " + course + ";\n"
                + "Оценки: " + journal;
    }
}
