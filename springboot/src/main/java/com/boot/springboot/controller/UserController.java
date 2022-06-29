package com.boot.springboot.controller;

import com.boot.springboot.mapper.StudentMapper;
import com.boot.springboot.model.Class;
import com.boot.springboot.repo.ClassRepository;
import com.boot.springboot.repo.UserRespository;
import com.boot.springboot.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@PropertySource("classpath:application.properties")
public class UserController {

    private List<Student> l=new ArrayList<>();
    @GetMapping("/home")
    public ResponseEntity<?> get(){

       l=userRespository.findAll();
        return ResponseEntity.ok(l);
    }
    @Autowired
    private UserRespository userRespository;
    @Autowired
    ClassRepository classRepository;
    @GetMapping("/save")
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<?> gsave() {
        Class c=new Class("C");
        Student s=new Student("hoang cau");
        Set<Student> set=new HashSet<>();
        set.add(s);
        c.setStudents(set);
        s.setaClass(c);
        classRepository.save(c);
        List<Student> students = userRespository.findAll();
        return ResponseEntity.ok().body(students.stream()
                .map(StudentMapper::toStudentResponse)
                .collect(Collectors.toList()));
    }
    @Value("${spring.datasource.username}")
    String user ;
    @PostConstruct
    public String post(){
        System.out.println("post contruct   "+user);
        return "home";
    }

    @PreDestroy
    public String destroy(){
        System.out.println("destroy");
        return "index";
    }
    @PostMapping("/home")
    public String POST(Model m){
        System.out.println(m.getAttribute("name"));
        return "index";
    }
}
