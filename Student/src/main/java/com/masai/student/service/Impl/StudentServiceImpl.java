package com.masai.student.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.student.dao.StudentRepo;
import com.masai.student.entity.Student;
import com.masai.student.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentRepo studentRepo;

	@Override
	public Student saveStudent(Student student) {
		
		return studentRepo.save(student);
	}

	@Override
	public List<Student> fetchAllStudent() {
		List<Student> allStudent = studentRepo.findAll();
		return allStudent ;
	}
	@Override
	public Student getStdentById(Integer id) {
		Optional<Student> findById = studentRepo.findById(id);
		if(findById.isPresent()) {
			return findById.get();
		}
		return null;
	}

	@Override
	public Student updateStudentById(Integer id, Student student) {
		Optional<Student> stu = studentRepo.findById(id);
		if(stu.isPresent()) {
			Student student2 = stu.get();
			student2.setName(student.getName());
			student2.setEmail(student.getEmail());
			student2.setCity(student.getCity());
			
			Student save = studentRepo.save(student2);
			
			
			return save;
		}
		return null;
	}

	@Override
	public String deleteStudentById(Integer id) {
		Optional<Student> findById = studentRepo.findById(id);
		if(findById.isPresent()) {
			studentRepo.delete(findById.get());
			return "delete successfully !";
		}
		return "data not parsent";
	}

}
