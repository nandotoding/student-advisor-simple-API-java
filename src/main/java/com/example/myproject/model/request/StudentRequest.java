package com.example.myproject.model.request;

import lombok.Data;

@Data
public class StudentRequest {
    private String studentName;
    private String studentMajor;
    private Integer studentAge;
    private String academicAdvId;
}
