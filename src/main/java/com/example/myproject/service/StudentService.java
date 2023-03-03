package com.example.myproject.service;

import com.example.myproject.model.Student;
import com.example.myproject.model.request.StudentRequest;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();
    Student addStudent(StudentRequest studentRequest);
    Student getStudentById(String id);
}
