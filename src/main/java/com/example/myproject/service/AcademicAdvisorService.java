package com.example.myproject.service;

import com.example.myproject.model.AcademicAdvisor;
import com.example.myproject.model.request.AcademicAdvisorRequest;

import java.util.List;

public interface AcademicAdvisorService {
    List<AcademicAdvisor> getAllAcademicAdv();
    AcademicAdvisor addAcademicAdv(AcademicAdvisorRequest academicAdvisorRequest);
    AcademicAdvisor getAcademicAdvById(String id);
}
