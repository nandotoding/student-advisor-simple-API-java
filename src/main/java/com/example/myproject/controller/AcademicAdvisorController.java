package com.example.myproject.controller;

import com.example.myproject.model.AcademicAdvisor;
import com.example.myproject.model.request.AcademicAdvisorRequest;
import com.example.myproject.model.response.SuccessResponse;
import com.example.myproject.service.AcademicAdvisorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(UrlMappings.ACADEMIC_ADV_URL)
public class AcademicAdvisorController {
    private final AcademicAdvisorService academicAdvisorService;

    public AcademicAdvisorController(AcademicAdvisorService academicAdvisorService) {
        this.academicAdvisorService = academicAdvisorService;
    }

    @GetMapping
    public ResponseEntity getAllAcademicAdv() {
        List<AcademicAdvisor> academicAdvisors = academicAdvisorService.getAllAcademicAdv();
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("S00", "success", "successfully get all advisor data", academicAdvisors));
    }

    @PostMapping
    public ResponseEntity addAcademicAdvisor(@RequestBody AcademicAdvisorRequest academicAdvisorRequest) {
        AcademicAdvisor academicAdvisor = academicAdvisorService.addAcademicAdv(academicAdvisorRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse<>("S01", "success", "successfully add advisor data", academicAdvisor));
    }

    @GetMapping("/{id}")
    public ResponseEntity getAcademicAdvById(@PathVariable("id") String id) {
        AcademicAdvisor academicAdvisor = academicAdvisorService.getAcademicAdvById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse<>("S03", "success", "successfully get advisor data", academicAdvisor));
    }
}
