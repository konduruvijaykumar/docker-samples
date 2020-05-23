/**
 * 
 */
package org.pjay.student.controller;

import java.net.URI;
import java.util.List;

import org.pjay.student.converter.StudentInfoToStudent;
import org.pjay.student.converter.StudentToStudentInfo;
import org.pjay.student.entity.Student;
import org.pjay.student.model.Results;
import org.pjay.student.model.StudentInfo;
import org.pjay.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

/**
 * @author vijayk
 *
 */
@RestController
@RequestMapping("/students")
public class StudentApplicationController {

	@Autowired
	StudentService studentService;

	@Autowired
	StudentToStudentInfo studentToStudentInfo;

	@Autowired
	StudentInfoToStudent studentInfoToStudent;

	@GetMapping("/{studentId}")
	public ResponseEntity<Results> getStudentById(@PathVariable("studentId") Long studentId) {
		Student student = studentService.getStudentById(studentId);
		Results results = new Results();
		if (null != student) {
			StudentInfo studentInfo = studentToStudentInfo.convert(student);
			results.setResult(studentInfo);
			return new ResponseEntity<>(results, HttpStatus.OK);
		}
		return new ResponseEntity<>(results, HttpStatus.OK);
	}

	@GetMapping(value = { "", "/" })
	public ResponseEntity<Results> getAllStudents() {
		List<Student> allStudents = studentService.getAllStudents();
		Results results = new Results();
		results.setResult(allStudents);
		return new ResponseEntity<>(results, HttpStatus.OK);
	}

	@PostMapping(value = { "", "/" })
	public ResponseEntity<Results> addStudent(@RequestBody Student student) {
		Results results = new Results();
		Student createdStudent = studentService.createStudent(student);
		/* fromCurrentContextPath() */
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{studentId}")
				.buildAndExpand(createdStudent.getStudentId()).toUri();
		results.setResult(uri);
		return new ResponseEntity<>(results, HttpStatus.CREATED);
	}

}
