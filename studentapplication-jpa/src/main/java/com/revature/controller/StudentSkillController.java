package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.revature.model.Skill;
import com.revature.model.Student;
import com.revature.model.StudentSkill;
import com.revature.service.SkillService;
import com.revature.service.StudentService;
import com.revature.service.StudentSkillService;

@CrossOrigin
@Controller
@RequestMapping("/skill")
public class StudentSkillController {
	@Autowired
	StudentSkillService studentSkillService;
	@Autowired
	SkillService skillService;
	@Autowired
	StudentService studentService;

	@GetMapping("/studentskill")
	public String findById(HttpServletRequest request, HttpSession session, ModelMap modelMap) throws Exception {
		Student student = (Student) session.getAttribute("logged_in_user");
		System.out.println(student);
		List<StudentSkill> list = studentSkillService.findById(student.getId());
		modelMap.addAttribute("skill_list", list);
		System.out.println("skill list for controller"+list);
		return "skill_user";
	}

	@GetMapping("/update")
	public String update(@RequestParam("id") Integer id, @RequestParam("scale") String scale, ModelMap modelMap,
			HttpSession session) {
		System.out.println("methodddd invokkkk");
		Student student = (Student) session.getAttribute("logged_in_user");
		Skill skill = skillService.findById(id);
		StudentSkill studentSkill = new StudentSkill();
		studentSkill.setScale(scale);
		studentSkill.setStudent(student);
		studentSkill.setSkill(skill);
		System.out.println(skill + "update skill");
		System.out.println(student + "update student");
		System.out.println(studentSkill + "update studentskill");
		studentSkillService.save(studentSkill);
		System.out.println("successfully updated");
		return "index";
	}

}
