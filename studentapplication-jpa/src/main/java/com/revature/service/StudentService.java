
package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Student;
import com.revature.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	public void save(Student student) {
		studentRepository.save(student);
	}

	public List<Student> findAll() {
		return studentRepository.findAll();
	}

	public Student findById(Integer id) {
		return studentRepository.findOne(id);
	}

	public Student findByEmailIdAndPassword(String email, String password) {
		return studentRepository.findByEmailIdAndPassword(email, password);
	}
}
