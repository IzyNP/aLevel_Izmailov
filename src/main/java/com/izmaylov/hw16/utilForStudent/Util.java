package com.izmaylov.hw16.utilForStudent;

import com.izmaylov.hw16.model.Grade;
import com.izmaylov.hw16.model.Student;

import java.util.List;

public class Util {
    public static int averageGrade(Student student){
        int averageGrade = 0;
        for (Grade o : student.getGrades()) {
            averageGrade += o.getGradeNumber();
        }
        return averageGrade/student.getGrades().size();
    }

    public static void printStudent(List<Student> students, int course){
        for (Student student : students) {
            if((student.isExpelled() || student.isGraduate()) && student.getCourse() == course){
                System.out.println(student);
            }
        }
    }
}
