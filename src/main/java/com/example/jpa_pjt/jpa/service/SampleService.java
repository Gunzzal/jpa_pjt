package com.example.jpa_pjt.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jpa_pjt.jpa.dao.SampleDao;
import com.example.jpa_pjt.jpa.domain.entity.SampleEntity;


@Service
public class SampleService {
    
    @Autowired
    private SampleDao sampleDao;

    public SampleEntity save(SampleEntity params) {
        System.out.println("service save : " + params);
        sampleDao.save(params);
        return params;
    }

    public List<SampleEntity> list() {
        System.out.println("service list" );
        return sampleDao.findAll();
    }

    public Optional<SampleEntity> find(Integer id) {
        System.out.println("service find" );
        Optional<SampleEntity> optional = sampleDao.findById(id);
        return optional;
    }

    public void delete(Integer id) {
        System.out.println("service delete" );
        sampleDao.deleteById(id);
    }    

    // update case 01,
    // public SampleEntity update(SampleEntity params) {
    //     System.out.println("service update : " + params);
    //     sampleDao.save(params);
    //     return params;
    // }

    // update case 02,
    // Dirty Checking
    // @Transactional
    // public SampleEntity update(SampleEntity params) {
    //     System.out.println("service update : " + params);
    //     Optional<SampleEntity> entity = sampleDao.findById(params.getSeq());
    //     entity.ifPresent(obj -> obj.setId(params.getId()));
    //     entity.ifPresent(obj -> obj.setName(params.getName()));
    //     entity.ifPresent(obj -> obj.setPwd(params.getPwd()));
        
    //     return params;
    // }

    //  update case 03,
    public SampleEntity update(SampleEntity params){
        System.out.println("service update : " + params);
        sampleDao.updateRow(params.getId(), params.getPwd(), params.getName(), params.getSeq());
        return params;
    }
}
