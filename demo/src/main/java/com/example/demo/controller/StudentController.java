package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ResponseDetails;
import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentservice ;
	

@PostMapping("/insertstudent")	
public ResponseEntity  insertStudent(@RequestBody Student student) {
	
	ResponseDetails res = new ResponseDetails();
	
	String s1 = studentservice.insertStudent(student);
	
	if(s1.equals("inserted")) {
		res.setStatus(HttpStatus.CREATED);
		res.setSuccessMessage("data inserted successfully");
		
		return new ResponseEntity (res,HttpStatus.CREATED) ;
	}
	else if(s1.equals("emailid already exist")) {
		res = new ResponseDetails();
		res.setErrorMessage("emailid already exist");
		res.setStatus(HttpStatus.NOT_ACCEPTABLE);
		return new ResponseEntity (res,HttpStatus.NOT_ACCEPTABLE) ;
	}
	else {
		res = new ResponseDetails();
		res.setErrorMessage("not inserted");
		res.setStatus(HttpStatus.NOT_ACCEPTABLE);
		return new ResponseEntity (res,HttpStatus.NOT_ACCEPTABLE) ;	
	}
	
}

@GetMapping("/fetchstudent")
public ResponseEntity fetchStudent(@RequestParam("emailid") String emailId) {
	
	Student student = studentservice.fetchStudent(emailId);
	if(student!=null) {
		ResponseDetails res = new ResponseDetails();
		res.setStatus(HttpStatus.FOUND);
		res.setSuccessMessage("student details found");
	    res.setO1(student);
	    return new ResponseEntity (res ,HttpStatus.FOUND) ;
	}
	else {
		
		ResponseDetails res = new ResponseDetails();
		res.setErrorMessage("student not found");
		res.setStatus(HttpStatus.NOT_FOUND);
		return new ResponseEntity(res,HttpStatus.NOT_FOUND);
	}
}

@PutMapping("/updatestudent")
public ResponseEntity updateStudent(@RequestBody Student student) {
	
	String s1 =studentservice.updatestudent(student);
	if(s1.equals("not found student for given email id in database")) {
		ResponseDetails res = new ResponseDetails();
		res.setErrorMessage(s1);
		res.setStatus(HttpStatus.NOT_ACCEPTABLE);
		return new ResponseEntity (res , HttpStatus.NOT_ACCEPTABLE);
	}
	else {
		ResponseDetails res = new ResponseDetails();
		res.setSuccessMessage("Updated Successfully");
		res.setStatus(HttpStatus.ACCEPTED);
		return new ResponseEntity (res ,HttpStatus.ACCEPTED);	
	}
	
	
}


}
