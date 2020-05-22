/**
 * 
 */
package org.pjay.student.service;

import java.util.List;

import org.pjay.student.entity.Student;

/**
 * @author vijayk
 *
 */
public interface StudentService {

	Student getStudentById(Long studentId);

	List<Student> getAllStudents();

	Student createStudent(Student student);

	Student updateStudent(Student student);

	boolean deleteStudent(Student student);

	boolean deleteStudentById(Long studentId);

}
