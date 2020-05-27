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
public class StudentInfoToStudent implements Converter<StudentInfo, Student> {

	@Override
	public Student convert(StudentInfo studentInfo) {
		Student student = new Student();
		student.setStudentId(studentInfo.getStudentId());
		student.setAge(studentInfo.getAge());
		student.setCourse(studentInfo.getCourse());
		student.setEmail(studentInfo.getEmail());
		student.setFirstName(studentInfo.getFirstName());
		student.setLastName(studentInfo.getLastName());
		return student;
	}

}
