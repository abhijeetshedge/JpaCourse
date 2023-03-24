package com.learn.datajpa.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learn.datajpa.model.Student;
import com.learn.datajpa.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping
	public ResponseEntity<Student> addStudent(@RequestBody Student student) {
		
		return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED);
		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Student> getStudent(@PathVariable("id") long id ){
		
		return new ResponseEntity<Student>(studentService.getStudent(id), HttpStatus.OK);
		
	}
	
	@GetMapping
	public ResponseEntity<List<Student>> getAllStudent(){
		
		return new ResponseEntity<List<Student>>(studentService.getAllStudent(),HttpStatus.OK);
		
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") long id,
			                                      @RequestBody Student student){
		
		return new ResponseEntity<Student>(studentService.updateStudent(id, student), HttpStatus.OK);
		
	}
	
	@DeleteMapping("{id}")
	public String deleteStudent(@PathVariable("id") long id) {
		
		return studentService.deleteStudent(id);
		
	}
	
	
	
	

}
