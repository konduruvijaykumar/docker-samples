/**
 * 
 */
package org.pjay.student.converter;

import org.pjay.student.entity.Student;
import org.pjay.student.model.StudentInfo;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author vijayk
 *
 */
@Component
public class StudentToStudentInfo implements Converter<Student, StudentInfo>{

	@Override
	public StudentInfo convert(Student student) {
		StudentInfo studentInfo = new StudentInfo();
		studentInfo.setStudentId(student.getStudentId());
		studentInfo.setAge(student.getAge());
		studentInfo.setCourse(student.getCourse());
		studentInfo.setEmail(student.getEmail());
		studentInfo.setFirstName(student.getFirstName());
		studentInfo.setLastName(student.getLastName());
		return studentInfo;
	}

}
