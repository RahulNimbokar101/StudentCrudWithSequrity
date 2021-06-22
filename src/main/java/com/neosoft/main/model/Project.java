package com.neosoft.main.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Project {
	@Id
	private String projectId;
	private String projectName;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Student STU;
	
 
	public Student getSTU() {
		return STU;
	}
	public void setSTU(Student sTU) {
		STU = sTU;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
}
