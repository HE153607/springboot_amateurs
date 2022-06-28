package com.boot.springboot.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Entity
//@Data
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sid;
    private String name;
    @ManyToOne(fetch = FetchType.LAZY)
//    @JsonBackReference
    @JoinColumn(name = "class_id",referencedColumnName = "cid")
    Class aClass;

    public Student(String name) {
        this.name=name;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }
}
