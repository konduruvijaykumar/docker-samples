/**
 * 
 */
package org.pjay.student.exception;

/**
 * @author vijayk
 *
 */
// Might not be used, but keeping a template class for understanding
public class UserDefinedException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5634025071046505584L;

	public UserDefinedException() {
		super();
	}

	public UserDefinedException(String message) {
		super(message);
	}

	public UserDefinedException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserDefinedException(Throwable cause) {
		super(cause);
	}

}
