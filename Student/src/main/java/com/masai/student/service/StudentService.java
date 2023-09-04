package com.masai.student.service;

import java.util.List;

import com.masai.student.entity.Student;

public interface StudentService {
	
	Student saveStudent(Student student);
	
	List<Student> fetchAllStudent();
	
	Student getStdentById(Integer id);
	
	Student updateStudentById(Integer id , Student student);
	
	String deleteStudentById(Integer id);

}
