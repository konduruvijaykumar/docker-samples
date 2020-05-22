/**
 * 
 */
package org.pjay.student.model;

import org.springframework.stereotype.Component;

/**
 * @author vijayk
 *
 */
@Component
// Wrapping object for all results sent via web services
public class Results {

	private Object result;

	public Results() {
	}

	public Results(Object result) {
		this.result = result;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((this.result == null) ? 0 : this.result.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Results)) {
			return false;
		}
		Results other = (Results) obj;
		if (result == null) {
			if (other.result != null) {
				return false;
			}
		} else if (!result.equals(other.result)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Results [result=" + result + "]";
	}

}
