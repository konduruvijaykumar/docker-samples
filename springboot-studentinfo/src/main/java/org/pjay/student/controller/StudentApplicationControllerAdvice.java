/**
 * 
 */
package org.pjay.student.controller;

import javax.servlet.http.HttpServletRequest;

import org.pjay.student.exception.StudentNotFoundException;
import org.pjay.student.exception.UserDefinedException;
import org.pjay.student.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author vijayk
 *
 */
// https://spring.io/blog/2013/11/01/exception-handling-in-spring-mvc
@RestControllerAdvice
public class StudentApplicationControllerAdvice {

	@ExceptionHandler(value = { Exception.class })
	public ResponseEntity<Error> handleAllApplicationExceptions(HttpServletRequest request, Throwable ex) {
		HttpStatus status = getStatus(request);
		return new ResponseEntity<>(new Error(status.value(), ex.getMessage()), status);
	}

	@ExceptionHandler(value = { UserDefinedException.class })
	public ResponseEntity<Error> handleCustomException(UserDefinedException exception) {
		return new ResponseEntity<>(new Error(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage()),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Student not found")
	@ExceptionHandler(value = { StudentNotFoundException.class })
	public void handleStudentNotFoundException() {
		// Nothing to do
	}

	private HttpStatus getStatus(HttpServletRequest request) {
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		if (statusCode == null) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return HttpStatus.valueOf(statusCode);
	}

}
