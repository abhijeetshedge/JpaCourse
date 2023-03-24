package com.learn.datajpa.service;

import java.util.List;

import com.learn.datajpa.model.Student;


public interface StudentService {
	
	public Student saveStudent(Student student);
	
	public Student getStudent(long id);
	
	public List<Student> getAllStudent();

	public Student updateStudent(long id, Student student);

	public String deleteStudent(long id);
}
