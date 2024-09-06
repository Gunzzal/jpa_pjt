package com.example.jpa_pjt.jpa.domain.entity;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity(name="TB_JPA_SAMPLE")
@Data
@DynamicUpdate
public class SampleEntity {
    
    @Id
    @Column(name="seq")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seq;
    @Column
    private String id;
    @Column
    private String pwd;
    @Column
    private String name;
}




