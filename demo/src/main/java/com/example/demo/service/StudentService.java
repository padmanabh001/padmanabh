package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentrepo ;
	
	
	public String insertStudent(Student student) {
		
		Student student1 = studentrepo.findByEmailid(student.getEmailid());
		if(student1==null) {
			
			return studentrepo.save(student).getId()!=null ? "inserted" : "not inserted";
			
			
		}
		else {
		
		return "emailid already exist" ;
		}
		}


	public Student fetchStudent(String emailId) {
		// TODO Auto-generated method stub
	
		return studentrepo.findByEmailid(emailId);
	}


	public String updatestudent(Student student) {
		// TODO Auto-generated method stub
		Student stu = studentrepo.findByEmailid(student.getEmailid());
		if(stu==null) return "not found student for given email id in database" ;
		else {
			
			if(student.getName()!=null) {
				stu.setName(student.getName());
				
			}
			if(student.getLastname()!=null) {
				stu.setLastname(student.getLastname());
			}
			if(student.getAddress()!=null) {
				stu.setAddress(student.getAddress());
			}
			
			studentrepo.save(stu);
			return "updated successfully";
			
		}
	
	
	}
	
}
