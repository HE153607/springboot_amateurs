package com.boot.springboot.repo;

import com.boot.springboot.model.Class;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassRepository extends JpaRepository<Class,Long> {
    @Override
    <S extends Class> S save(S entity);
    @Override
    List<Class> findAll();

}
