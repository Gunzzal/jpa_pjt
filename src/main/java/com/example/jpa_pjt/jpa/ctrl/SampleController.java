package com.example.jpa_pjt.jpa.ctrl;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa_pjt.jpa.domain.entity.SampleEntity;
import com.example.jpa_pjt.jpa.service.SampleService;

import lombok.RequiredArgsConstructor;




@RestController
@RequestMapping("/api/jpa")
@RequiredArgsConstructor
public class SampleController {
    
    private final SampleService sampleService;
    
    @PostMapping("/save")
    public ResponseEntity<SampleEntity> save(@RequestBody SampleEntity params) {
        System.out.println("client endpoint : /api/jpa/save : " + sampleService);
        System.out.println("params = " + params);
        SampleEntity result = sampleService.save(params);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
    @GetMapping("/list")
    public ResponseEntity<List<SampleEntity>> list() {
        System.out.println("client endpoint : /api/jpa/list : " + sampleService);
        List<SampleEntity> list = sampleService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity<Object> find(@RequestParam(name="id") Integer key) {
        System.out.println("client endpoint : /api/jpa/find : " + sampleService);
        Optional<SampleEntity> entity = sampleService.find(key);
        
        if(entity.isPresent()){
            return new ResponseEntity<>(entity.get(),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete (@PathVariable(name = "id") Integer id){
        System.out.println("client endpoint : /api/jpa/delete : " + sampleService);
        sampleService.delete(id);
        return new ResponseEntity<>(id+"삭제 완료!!",HttpStatus.OK);
    }
    
    @PutMapping("/update")
    public ResponseEntity<SampleEntity> update(@RequestBody SampleEntity params) {
        System.out.println("client endpoint : /api/jpa/update : " + sampleService);
        System.out.println("params = " + params);
        SampleEntity result = sampleService.update(params);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
