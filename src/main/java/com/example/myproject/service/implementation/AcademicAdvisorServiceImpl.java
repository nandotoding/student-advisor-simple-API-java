package com.example.myproject.service.implementation;

import com.example.myproject.model.AcademicAdvisor;
import com.example.myproject.model.request.AcademicAdvisorRequest;
import com.example.myproject.repository.AcademicAdvisorRepo;
import com.example.myproject.service.AcademicAdvisorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AcademicAdvisorServiceImpl implements AcademicAdvisorService {
    private final AcademicAdvisorRepo academicAdvisorRepo;
    private final ModelMapper modelMapper;

    @Autowired
    public AcademicAdvisorServiceImpl(AcademicAdvisorRepo academicAdvisorRepo, ModelMapper modelMapper) {
        this.academicAdvisorRepo = academicAdvisorRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<AcademicAdvisor> getAllAcademicAdv() {
        List<AcademicAdvisor> academicAdvisors = academicAdvisorRepo.findAll();
        return academicAdvisors;
    }

    @Override
    public AcademicAdvisor addAcademicAdv(AcademicAdvisorRequest academicAdvisorRequest) {
        AcademicAdvisor academicAdvisor = new AcademicAdvisor();
        academicAdvisor.setAcademicAdvName(academicAdvisorRequest.getAcademicAdvName());
        academicAdvisorRepo.save(academicAdvisor);
        return academicAdvisor;
    }

    @Override
    public AcademicAdvisor getAcademicAdvById(String id) {
        Optional<AcademicAdvisor> academicAdvisor = academicAdvisorRepo.findById(id);
        AcademicAdvisor newAcademicAdvisor = modelMapper.map(academicAdvisor, AcademicAdvisor.class);
        return newAcademicAdvisor;
    }
}
