package com.revature.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.StudentSkill;
import com.revature.repository.StudentSkillRepository;

@Service
public class StudentSkillService {

	@Autowired
	private StudentSkillRepository studentSkillRepository;

	public void save(StudentSkill studentSkill) {
		studentSkillRepository.save(studentSkill);
	}

	public List<StudentSkill> findAll() {
		return studentSkillRepository.findAll();
	}

	public List<StudentSkill> findById(Integer id) {
		for (StudentSkill ss : studentSkillRepository.findByStudentId(id)) {
			System.out.println("Student Skill : " + ss);
		}
		return studentSkillRepository.findByStudentId(id);
	}
}
