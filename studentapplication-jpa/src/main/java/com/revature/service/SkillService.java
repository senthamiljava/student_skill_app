package com.revature.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.model.Skill;
import com.revature.repository.SkillRepository;

@Service
public class SkillService {

	@Autowired
	private SkillRepository skillRepository;

	public void save(Skill skill) {
		skillRepository.save(skill);
	}

	public List<Skill> findAll() {
		return skillRepository.findAll();
	}

	public Skill findById(Integer id) {
		return skillRepository.findOne(id);
	}
}
