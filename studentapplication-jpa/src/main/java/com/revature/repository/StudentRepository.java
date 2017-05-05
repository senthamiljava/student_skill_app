package com.revature.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;

import com.revature.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	@Query(name = "select id,name,email_id from students where email_id = ?1 and password=?2", nativeQuery = true)
	public Student findByEmailIdAndPassword(String email, String password);
}
