package com.example.myproject.service.implementation;

import com.example.myproject.model.AcademicAdvisor;
import com.example.myproject.model.Student;
import com.example.myproject.model.request.StudentRequest;
import com.example.myproject.repository.AcademicAdvisorRepo;
import com.example.myproject.repository.StudentRepo;
import com.example.myproject.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;
    private final AcademicAdvisorRepo academicAdvisorRepo;
    private final ModelMapper modelMapper;

    @Autowired
    public StudentServiceImpl(StudentRepo studentRepo, AcademicAdvisorRepo academicAdvisorRepo, ModelMapper modelMapper) {
        this.studentRepo = studentRepo;
        this.academicAdvisorRepo = academicAdvisorRepo;
        this.modelMapper = modelMapper;
    }


    @Override
    public List<Student> getAllStudents() {
        List<Student> students = studentRepo.findAll();
        return students;
    }

    @Override
    public Student addStudent(StudentRequest studentRequest) {
        Student student = new Student();
        student.setStudentName(studentRequest.getStudentName());
        student.setStudentMajor(studentRequest.getStudentMajor());
        student.setStudentAge(studentRequest.getStudentAge());
        Optional<AcademicAdvisor> academicAdvisor = academicAdvisorRepo.findById(studentRequest.getAcademicAdvId());
        AcademicAdvisor newAcademicAdvisor = modelMapper.map(academicAdvisor, AcademicAdvisor.class);
        student.setAcademicAdvisor(newAcademicAdvisor);
        studentRepo.save(student);
        return student;
    }

    @Override
    public Student getStudentById(String id) {
        Optional<Student> student = studentRepo.findById(id);
        Student newStudent = modelMapper.map(student, Student.class);
        return newStudent;
    }
}
