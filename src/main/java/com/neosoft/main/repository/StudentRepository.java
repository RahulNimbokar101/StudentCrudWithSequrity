package com.neosoft.main.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.neosoft.main.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student,String> {

}
