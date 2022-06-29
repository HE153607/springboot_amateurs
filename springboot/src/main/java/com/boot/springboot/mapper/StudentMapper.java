package com.boot.springboot.mapper;

import com.boot.springboot.controller.dto.StudentResponse;
import com.boot.springboot.model.Student;

public final class StudentMapper {
    public static StudentResponse toStudentResponse(Student entity) {
        if (entity == null) {
            return new StudentResponse();
        }

        com.boot.springboot.model.Class aClass = entity.getaClass();

        return StudentResponse.builder()
                .studentId(String.valueOf(entity.getSid()))
                .name(entity.getName())
                .classRoom(aClass == null ? "" : aClass.getRoom())
                .build();
    }
}
