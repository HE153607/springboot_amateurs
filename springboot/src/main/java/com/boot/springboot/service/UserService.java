package com.boot.springboot.service;

import com.boot.springboot.model.Student;

import java.util.List;

public interface UserService{
    public List<Student> findAll();
}