package com.region20.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBException;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.region20.model.FileUpload;
import com.region20.model.Student;
import com.region20.service.StudentService;
import com.region20.service.UserService;
import com.region20.validator.FileValidator;

@Controller
public class StudentController {
	@Autowired
	FileValidator fileValidator;
	
	@Autowired
	private StudentService studentService;
	
	
	@RequestMapping("/index")
	public String setupForm(Map<String, Object> map) {
		Student student = new Student();
		map.put("student", student);
		map.put("studentList", studentService.getAllStudent());
		return "student";
	}
	
//	@RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
//	public String doUpload(@ModelAttribute("formUpload") FileUpload fileUpload, BindingResult result) throws IOException, JAXBException{
//		//Validate
//		fileValidator.validate(fileUpload,result);
//		if(result.hasErrors()) {
//			return "uploadPage";
//		}else {
//			uploadAndImportDb(fileUpload);
//			return "redirect:/student";
//		}
//	}
	@RequestMapping(value="/fileupload", method=RequestMethod.POST)
	public String processUpload(@RequestParam MultipartFile file) throws IOException {
		if(!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();
				String completeData = new String(bytes);
				String[] rows = completeData.split("#");
				String[] columns = rows[0].split(",");
				System.out.println("Row Info: "+ rows);
				System.out.println("Column Info: "+columns);
			}finally {
				
			}
		}
		String content = new String(file.getBytes(),"UTF-8");
		
	        // process your file
		return content;
	}
	
	@RequestMapping(value="/student.do", method=RequestMethod.POST)
	public String doActions(@ModelAttribute Student student, BindingResult result, @RequestParam String action, Map<String, Object> map) {
		Student studentResult = new Student();
		switch(action.toLowerCase()) { //Java 7: put a string in switch
		case "add":
			studentService.add(student);
			studentResult = student;
			break;
		case "edit":
			studentService.edit(student);
			studentResult = student;
			break;
		case "delete":
			studentService.delete(student.getId());
			studentResult = new Student();
			break;
		case "search":
			Student searchedStudent = studentService.getStudent(student.getId());
			studentResult = searchedStudent != null ? searchedStudent : new Student();
			break;
		}
		map.put("student", studentResult);
		map.put("studentList", studentService.getAllStudent());
		return "student";
	}
	
	private List<String> uploadAndImportDb(FileUpload fileUpload) throws IOException, JAXBException {
		List<String> fileNames = new ArrayList<String>();
		List<String> paths = new ArrayList<String>();

		CommonsMultipartFile[] commonsMultipartFiles = fileUpload.getFiles();

		String filePath = null;

		for (CommonsMultipartFile multipartFile : commonsMultipartFiles) {
			filePath = "C:\\my_upload\\" + multipartFile.getOriginalFilename();
			File file = new File(filePath);

			// Copy files
			FileCopyUtils.copy(multipartFile.getBytes(), file);
			fileNames.add(multipartFile.getOriginalFilename());

			paths.add(filePath);
		}
//		userService.process(paths);
		return fileNames;
	}
}
