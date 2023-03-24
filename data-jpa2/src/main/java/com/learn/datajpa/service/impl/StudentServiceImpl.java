package com.learn.datajpa.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.datajpa.dao.StudentRepository;
import com.learn.datajpa.exception.ResourceNotFoundException;
import com.learn.datajpa.model.Student;
import com.learn.datajpa.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentRepository repository;

	@Override
	public Student saveStudent(Student student) {
		
		repository.save(student);
		return student; 
	}

	@Override
	public Student getStudent(long id) {
		
		 return repository.findById(id).
				orElseThrow(()-> new ResourceNotFoundException("Employee", "Id", id));
		
	}

	@Override
	public List<Student> getAllStudent() {
		
		return repository.findAll();
	}

	@Override
	public Student updateStudent(long id, Student student) {
		
		Student existingStudent = repository.findById(id).
				orElseThrow(()-> new ResourceNotFoundException("Employee", "Id", id));
		
		existingStudent.setName(student.getName());
		existingStudent.setEmail(student.getEmail());
		
		repository.save(existingStudent);
		
		return existingStudent;
		
		
	}

	@Override
	public String deleteStudent(long id) {
	
	  Optional<Student> Student = repository.findById(id);
	  
	  if(Student.isPresent()) {
		  repository.deleteById(id);
		  return "deleted student with Id "+ id;
	  }
	  else {
		  throw new ResourceNotFoundException("Resource", "Id", "id");
	  }
	}

}
