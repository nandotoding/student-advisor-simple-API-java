package com.example.myproject.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "academic_advisors")
@Data
public class AcademicAdvisor {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(name = "academic_adv_id")
    private String academicAdvId;
    @Column(name = "academic_adv_name")
    private String academicAdvName;
}
