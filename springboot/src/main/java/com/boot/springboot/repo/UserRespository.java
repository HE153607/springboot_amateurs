package com.boot.springboot.repo;

import com.boot.springboot.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface UserRespository extends JpaRepository<Student, Long> {
    @Override
    List<Student> findAll();

    @Override
    <S extends Student> S save(S entity);
    @Modifying
@Query(value = "delete from Student where name=:name")
    void deleteByName(String name);
    @Override
    void delete(Student entity);
    @Query(value = "select * from student where name=:name",nativeQuery = true)
Iterable<Student> selectByName(String name);
    @Override
    <S extends Student> List<S> saveAllAndFlush(Iterable<S> entities);
}
