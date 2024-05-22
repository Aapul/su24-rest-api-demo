package com.csc340.restapidemo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    @Query(value = "select s from students s where gpa > ?1", nativeQuery = true)
    public List<Student> getHonorsStudents(double gpa);
}
