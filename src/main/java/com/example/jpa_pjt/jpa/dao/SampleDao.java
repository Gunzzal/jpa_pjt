package com.example.jpa_pjt.jpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.jpa_pjt.jpa.domain.entity.SampleEntity;

import jakarta.transaction.Transactional;

@Repository
public interface SampleDao extends JpaRepository<SampleEntity, Integer>{
    // 사용자정의 추상메서드 추가 가능
    // JpQL = query
    
    @Transactional
    @Modifying
    @Query("UPDATE TB_JPA_SAMPLE U "
            +"SET U.id = :id , U.pwd = :pwd , U.name = :name "
            +"WHERE U.seq = :seq")
    public void updateRow(  @Param("id") String id,
                            @Param("pwd") String pwd,
                            @Param("name") String name,
                            @Param("seq") Integer seq);

} 

