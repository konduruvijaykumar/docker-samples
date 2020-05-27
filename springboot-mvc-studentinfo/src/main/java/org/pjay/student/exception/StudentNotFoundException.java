/**
 * 
 */
package org.pjay.student.exception;

/**
 * @author vijayk
 *
 */
// https://spring.io/blog/2013/11/01/exception-handling-in-spring-mvc
// @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Student not found")
// above annotation not working
public class StudentNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1953757896678184254L;

	public StudentNotFoundException() {
		super();
	}

	public StudentNotFoundException(String message) {
		super(message);
	}

	public StudentNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public StudentNotFoundException(Throwable cause) {
		super(cause);
	}

}
