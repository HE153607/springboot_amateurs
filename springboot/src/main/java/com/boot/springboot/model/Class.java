package com.boot.springboot.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="class")
//@Data
@NoArgsConstructor
@AllArgsConstructor
public class Class {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cid;
    private String room;
   @OneToMany(mappedBy = "aClass",cascade = CascadeType.ALL)
//   @JsonManagedReference
    private Set<Student> students;

    public Class( String room) {
        this.room=room;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
