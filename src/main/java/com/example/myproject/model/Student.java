package com.example.myproject.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "students")
@Data
public class Student {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "student_id")
    private String studentId;
    @Column(name = "student_name")
    private String studentName;
    @Column(name = "student_major")
    private String studentMajor;
    @Column(name = "student_age")
    private Integer studentAge;
    @ManyToOne
    @JoinColumn(name = "academic_adv", referencedColumnName = "academic_adv_id")
    private AcademicAdvisor academicAdvisor;
}
