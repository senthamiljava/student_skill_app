package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.model.Skill;

public interface SkillRepository extends JpaRepository<Skill, Integer> {

}
