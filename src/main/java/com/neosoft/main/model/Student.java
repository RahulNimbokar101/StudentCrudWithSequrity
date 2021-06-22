package com.neosoft.main.model;



import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;

import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Entity
public class Student {
    @Id
    @NotBlank(message = "StudentId is Missing")
	@Size(max = 10)
	@Setter @Getter
	private String studentId;
    @NotBlank(message = "StudentFirstName is Missing")
	@Size(max = 16)
	private String studentFirstName;
    @NotBlank(message = "StudentLastName is Missing")
	@Size(max = 16)
	private String studentLastName;
    @NotBlank(message = "StudentMobileNo is Missing")
	@Size(max = 13)
	private String studentMobileNo;
    @NotBlank(message = "StudentEmailAddress is Missing")
	private String studentEmailAddress;
    @Lob
    private byte[] photoupload;
    
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "STU")
	private Set<Project> projects=new HashSet<Project>();
	
	
	//private Collection<Project> projects;
    
	/*
	 * public Collection<Project> getProjects() { return projects; }
	 * 
	 * 
	 * 
	 * public void addProject(Project project) { if (projects==null) { projects =
	 * new ArrayList<Project>(); } if (!projects.contains(project)) {
	 * projects.add(project); } }
	 */


	public Set<Project> getProjects() {
		return projects;
	}



	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}



	public Student()
   	{
   		
   	}

	

	public byte[] getPhotoupload() {
		return photoupload;
	}

	public void setPhotoupload(byte[] photoupload) {
		this.photoupload = photoupload;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentFirstName() {
		return studentFirstName;
	}

	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}

	public String getStudentLastName() {
		return studentLastName;
	}

	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}

	public String getStudentMobileNo() {
		return studentMobileNo;
	}

	public void setStudentMobileNo(String studentMobileNo) {
		this.studentMobileNo = studentMobileNo;
	}


	public String getStudentEmailAddress() {
		return studentEmailAddress;
	}

	public void setStudentEmailAddress(String studentEmailAddress) {
		this.studentEmailAddress = studentEmailAddress;
	}

	 

	
}
