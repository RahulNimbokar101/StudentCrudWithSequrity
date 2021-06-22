package com.neosoft.main.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.neosoft.main.model.Student;
import com.neosoft.main.repository.StudentRepository;
import com.neosoft.main.serviceI.StudentServiceI;

@Service
public class StudentServiceImpl implements StudentServiceI {
	
	@Autowired
	StudentRepository repo;

	@Override
	public String SaveStudent(Student stu) {
		// TODO Auto-generated method stub
		
		repo.save(stu);
		return "Student Data Successfully";
	}

	@Override
	public List<Student> ListOFStudent() {
		List<Student>list=(List<Student>) repo.findAll();
		return list;
	}

	@Override
	public Student SingleResult(String studentId) {
		Optional<Student>stu=repo.findById(studentId);
		if(stu.isPresent())
		{
			return stu.get();
		}
		return null;
	}

}
