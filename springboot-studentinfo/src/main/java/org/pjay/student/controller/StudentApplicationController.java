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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
// TODO: converting Student to StudentInfo object while sending to UI
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
	public ResponseEntity<Results> addStudent(@RequestBody StudentInfo studentInfo) {
		Results results = new Results();
		Student student = studentInfoToStudent.convert(studentInfo);
		Student createdStudent = studentService.createStudent(student);
		/* fromCurrentContextPath() */
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{studentId}")
				.buildAndExpand(createdStudent.getStudentId()).toUri();
		results.setResult(uri);
		return new ResponseEntity<>(results, HttpStatus.CREATED);
	}

	@PutMapping(value = { "", "/" })
	public ResponseEntity<Results> updateStudent(@RequestBody StudentInfo studentInfo) {
		Results results = new Results();
		Student student = studentInfoToStudent.convert(studentInfo);
		Student updatedStudent = studentService.updateStudent(student);
		results.setResult(updatedStudent);
		return new ResponseEntity<>(results, HttpStatus.OK);
	}

	@DeleteMapping(value = { "", "/" })
	public ResponseEntity<Results> deleteStudent(@RequestBody StudentInfo studentInfo) {
		Results results = new Results();
		// if (null == studentInfo.getStudentId()) {
		// results.setResult("Student Info does not contain studentId.");
		// return new ResponseEntity<>(results, HttpStatus.NOT_FOUND);
		// }
		Student student = studentInfoToStudent.convert(studentInfo);
		boolean isStudentDeleted = studentService.deleteStudent(student);
		if (isStudentDeleted) {
			results.setResult("Delete completed successfully");
			return new ResponseEntity<>(results, HttpStatus.NO_CONTENT);
		}
		results.setResult("Delete not successful, as no student found with input data provided");
		return new ResponseEntity<>(results, HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{studentId}")
	public ResponseEntity<Results> deleteStudentById(@PathVariable("studentId") Long studentId) {
		Results results = new Results();
		boolean isStudentDeleted = studentService.deleteStudentById(studentId);
		if (isStudentDeleted) {
			results.setResult("Delete completed successfully");
			return new ResponseEntity<>(results, HttpStatus.NO_CONTENT);
		}
		results.setResult("Delete not successful, as no student found with input data provided");
		return new ResponseEntity<>(results, HttpStatus.NOT_FOUND);
	}

}
