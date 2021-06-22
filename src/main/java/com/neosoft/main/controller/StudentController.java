package com.neosoft.main.controller;



import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.List;


import javax.servlet.http.HttpServletRequest;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.neosoft.main.model.Project;
import com.neosoft.main.model.Student;
import com.neosoft.main.serviceI.StudentServiceI;

@RestController
@RequestMapping("/student-portal/api")
public class StudentController {
	
	@Value("${upoadDir}")
    private String uploadFolder;
	
	@Autowired
	StudentServiceI servicei;
	
	private static final Logger log = LoggerFactory.getLogger(StudentController.class);
	
		
	//for compress byte
	
	@PostMapping("/Add")
	public @ResponseBody ResponseEntity<?> createEmployee(@RequestParam("studentId") String studentId,@RequestParam("studentFirstName") String studentFirstName,
			@RequestParam("studentLastName") String studentLastName, @RequestParam("studentMobileNo") String studentMobileNo,@RequestParam("studentEmailAddress")String studentEmailAddress,@RequestParam("projectId")  String projectId,@RequestParam("projectName") String projectName, Model model, HttpServletRequest request
			,final @RequestParam("photoupload") MultipartFile file) {
		try {
			//String uploadDirectory = System.getProperty("user.dir") + uploadFolder;
			String uploadDirectory = request.getServletContext().getRealPath(uploadFolder);
			log.info("uploadDirectory:: " + uploadDirectory);
			String fileName = file.getOriginalFilename();
			String filePath = Paths.get(uploadDirectory, fileName).toString();
			log.info("FileName: " + file.getOriginalFilename());
			if (fileName == null || fileName.contains("..")) {
				model.addAttribute("invalid", "Sorry! Filename contains invalid path sequence \" + fileName");
				return new ResponseEntity<>("Sorry! Filename contains invalid path sequence " + fileName, HttpStatus.BAD_REQUEST);
			}
			String[] id=studentId.split(",");
			String[] Firstname = studentFirstName.split(",");
			String[] Lastname = studentLastName.split(",");
			String[] Mobileno = studentMobileNo.split(",");
			String[] Emailaddress = studentEmailAddress.split(",");
			String[] proid=projectId.split(",");
			String[] proname=projectName.split(",");
			
			log.info("StudentId: " + id[0]);
			log.info("StudentFirstName: " + Firstname[0]+" "+filePath);
			log.info("StudentLastName: " + Lastname[0]);
			log.info("StudentMobileNo: " + Mobileno[0]);
			log.info("StudentEmailAddress: " + Emailaddress[0]);
			log.info("projetcID:"+proid[0]);
			
			try {
				File dir = new File(uploadDirectory);
				if (!dir.exists()) {
					log.info("Folder Created");
					dir.mkdirs();
				}
				// Save the file locally
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
				stream.write(file.getBytes());
				stream.close();
			} catch (Exception e) {
				log.info("in catch");
				e.printStackTrace();
			}
			byte[] imageData = file.getBytes();
			
			Project pro=new Project();
			pro.setProjectId(proid[0]);
			pro.setProjectName(proname[0]);
			
			Student student=new Student();
			student.setStudentId(id[0]);
			student.setStudentFirstName(Firstname[0]);
			student.setStudentLastName(Lastname[0]);
			student.setStudentMobileNo(Mobileno[0]);
			student.setStudentEmailAddress(Emailaddress[0]);
			student.setPhotoupload(imageData);
			pro.setSTU(student);
			student.getProjects().add(pro);
			

			servicei.SaveStudent(student);
			log.info("HttpStatus===" + new ResponseEntity<>(HttpStatus.OK));
			return new ResponseEntity<>("Student Saved With File - " + fileName, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			log.info("Exception: " + e);
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	//get specific data
	@GetMapping("/get/{studentId}")
	public ResponseEntity<Object> getStudent(@PathVariable String studentId)
	{
		log.info("***************************"+"Specific DATA"+"******************");
		
        Student stu=servicei.SingleResult(studentId);	
        log.info("data");
		if(stu !=null)
		{
			return new  ResponseEntity<Object>(stu,HttpStatus.OK);
					
		}
		return new ResponseEntity<Object> ("student:"+studentId+"does not exits!",HttpStatus.NOT_FOUND);
			
		}
	//Get all data
		@GetMapping("AllGet")
		public ResponseEntity<List<Student>> getAllStudent()
		{
			log.info("***************************"+"Get DATA"+"******************");
			
	List<Student> student=servicei.ListOFStudent();
				

	return new ResponseEntity<List<Student>>(student,HttpStatus.OK);
			}
		
	
}
