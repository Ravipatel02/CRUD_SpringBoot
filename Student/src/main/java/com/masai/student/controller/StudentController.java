package com.masai.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.student.entity.Student;
import com.masai.student.service.Impl.StudentServiceImpl;

@RestController
public class StudentController {
	
	@Autowired
	private StudentServiceImpl stu;
	
	@PostMapping("/student")
	public Student saveStudents(@RequestBody Student student) {
		
		Student saveStudent = stu.saveStudent(student);
		return saveStudent;
		
	}
	
	@GetMapping("/student")
	public List<Student> getAllStudent(){
		List<Student> fetchAllStudent = stu.fetchAllStudent();
		return fetchAllStudent;
	}
	
	@GetMapping("/student/{id}")
	public Student getStudent(@PathVariable("id") Integer id) {
		Student student = stu.getStdentById(id);
		return student;
	}
	
	@PutMapping("/student/{id}")
	public Student updateStudents(@PathVariable Integer id , @RequestBody Student student) {
		return stu.updateStudentById(id, student);
	}
	
	@DeleteMapping("/student/{id}")
	public String deleteStudent(@PathVariable Integer id) {
		return stu.deleteStudentById(id);
	}

}
