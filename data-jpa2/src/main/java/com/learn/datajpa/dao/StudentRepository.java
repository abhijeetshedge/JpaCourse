package com.learn.datajpa.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.datajpa.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
