package com.studentCrud.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentCrud.model.Students;
import com.studentCrud.repository.StudentRepository;

@RestController  		//This annotation is used at the class level and allows the class to handle the requests made by the client. 
@RequestMapping("/api")  // map a method or a class to a specific URL or URI endpoint.
public class StudentsController {
	
	@Autowired     //Automatically creates objects
	StudentRepository studentRepository;
	
	@PostMapping("/students")  //using to store data in table or database
	public String createStudents(@RequestBody Students students) {
		studentRepository.save(students);
		return "Student Data stored in database.....";
	}
	
	//------------------------------------------------------------------------
	
	@GetMapping("/students")  //retrive data from database
	public ResponseEntity<List<Students>> getAllStudents(){
		List<Students> stdList = new ArrayList<>();
		studentRepository.findAll().forEach(stdList::add);
		return new ResponseEntity<List<Students>>(stdList,HttpStatus.OK);
	}
	
	@GetMapping("/students/{stdid}")  //retrive and cheack data present or not
	public ResponseEntity<Students> getAllStudentsById(@PathVariable long stdid){
		Optional<Students> std = studentRepository.findById(stdid);  //Optional is not contain null value avoid exceptions
		if(std.isPresent()) {
			return new ResponseEntity<Students>(std.get(),HttpStatus.FOUND);
		}else {
			return new ResponseEntity<Students>(HttpStatus.NOT_FOUND);
		}
	}
	
	//------------------------------------------------------------------------------------
	
	@PutMapping("/students/{stdid}")   //Update data 
	public String updateStudentById(@PathVariable long stdid,@RequestBody Students student) {
		Optional<Students> std= studentRepository.findById(stdid);
		if(std.isPresent()) {
			Students existStd = std.get();
			existStd.setStd_name(student.getStd_name());
			existStd.setStd_phone(student.getStd_phone());
			existStd.setStd_age(student.getStd_age());
			existStd.setStd_city(student.getStd_city());
			studentRepository.save(existStd);
			
			return " Student Details against Id "+stdid+" Updated";
		}else {
			return " Student Details Does Not Exist for employee id : "+stdid;

		}
	}
	
	

	//----------------------------------------------------------------------------------------
	
	
	@DeleteMapping("/students/{stdid}")  //Delete by id 
	public String deleteStudentById(@PathVariable Long stdid) {
		studentRepository.deleteById(stdid);
		return "Student Deleted SuccesssFully...";
	}
	
	
	@DeleteMapping("/students")  //Delete All Data 
	public String deleteAllStudents() {
		studentRepository.deleteAll();
		return "All Student Deleted SuccesssFully...";
	}
	
}
