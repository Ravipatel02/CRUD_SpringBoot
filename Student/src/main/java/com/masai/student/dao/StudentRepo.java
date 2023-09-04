package com.masai.student.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.student.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
