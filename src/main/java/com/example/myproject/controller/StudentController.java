package com.example.myproject.controller;

import com.example.myproject.model.Student;
import com.example.myproject.model.request.StudentRequest;
import com.example.myproject.model.response.SuccessResponse;
import com.example.myproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UrlMappings.STUDENT_URL)
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("S00", "success", "successfully get all student data", students));
    }

    @PostMapping
    public ResponseEntity addStudent(@RequestBody StudentRequest studentRequest) {
        Student student = studentService.addStudent(studentRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<>("S01", "success", "successfully add student data", student));
    }

    @GetMapping("/{id}")
    public ResponseEntity getStudentById(@PathVariable("id") String id) {
        Student student = studentService.getStudentById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("S03", "success", "successfully get student data", student));
    }
}
