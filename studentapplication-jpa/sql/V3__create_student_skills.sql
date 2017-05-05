DROP TABLE student_skills;

CREATE TABLE student_skills(id INT PRIMARY KEY AUTO_INCREMENT,student_id INT,skill_id INT,
scale VARCHAR(20) CHECK(scale IN('YET TO LEARN','BEGINER','INTERMEDIATE','EXPERT')),
CONSTRAINT fk_student_id FOREIGN KEY(student_id) REFERENCES students(id),
CONSTRAINT fk_skill_id FOREIGN KEY(skill_id) REFERENCES skills(id));

INSERT INTO student_skills(student_id,skill_id)(SELECT stu.id ,skill.id FROM students stu,skills skill);