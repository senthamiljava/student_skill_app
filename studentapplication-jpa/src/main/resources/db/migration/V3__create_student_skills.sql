

CREATE TABLE student_skills(id INT PRIMARY KEY AUTO_INCREMENT,student_id INT,skill_id INT,
scale VARCHAR(20)DEFAULT 'YET_TO_LEARN',
CONSTRAINT def_scale  CHECK(scale IN('YET_TO_LEARN','BEGINNER','INTERMEDIATE','EXPERT')) ,
CONSTRAINT fk_student_id FOREIGN KEY(student_id) REFERENCES students(id),
CONSTRAINT fk_skill_id FOREIGN KEY(skill_id) REFERENCES skills(id));

INSERT INTO student_skills(student_id,skill_id)(SELECT stu.id ,skill.id FROM students stu,skills skill);

ALTER TABLE student_skills ADD COLUMN(created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP);

ALTER TABLE student_skills ADD COLUMN(modified_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP);