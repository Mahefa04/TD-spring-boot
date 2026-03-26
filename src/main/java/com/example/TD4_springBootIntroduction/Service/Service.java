package com.example.TD4_springBootIntroduction.Service;

import com.example.TD4_springBootIntroduction.Entity.Student;

import java.util.ArrayList;
import java.util.List;

public class Service {

    private List<Student> students = new ArrayList<>();
    public List<Student> addStudent(List<Student> studentsList) {
        students.addAll(studentsList);
        return students;
    }

    public List<Student> getStudents() {
        return students;
    }
}
