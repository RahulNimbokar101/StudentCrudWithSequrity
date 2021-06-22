package com.neosoft.main.serviceI;

import com.neosoft.main.model.Student;

import antlr.collections.List;



public interface StudentServiceI {
	public String SaveStudent(Student stu);
	public List<Student> ListOFStudent();
	public Student SingleResult(String studentId);

}
