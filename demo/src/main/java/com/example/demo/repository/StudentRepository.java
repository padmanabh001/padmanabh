package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    
	@Query(value="select * from home.student where emailid =?1" , nativeQuery=true)
	Student findByEmailid(String emailid);

}
