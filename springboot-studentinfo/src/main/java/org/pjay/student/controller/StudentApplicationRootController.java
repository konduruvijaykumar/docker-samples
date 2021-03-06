/**
 * 
 */
package org.pjay.student.controller;

import org.pjay.student.model.Results;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author vijayk
 *
 */
// https://www.baeldung.com/spring-boot-favicon
@RestController
public class StudentApplicationRootController {

	@GetMapping(value = { "", "/" })
	public ResponseEntity<Results> welcome() {
		Results results = new Results();
		results.setResult("Welcome to student web service, this service is working");
		return new ResponseEntity<>(results, HttpStatus.OK);
	}

}
