/**
 * 
 */
package org.pjay.student.serviceimpl;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.pjay.student.entity.Student;
import org.pjay.student.repository.StudentRepository;
import org.pjay.student.service.StudentService;
import org.springframework.stereotype.Service;

/**
 * @author vijayk
 *
 */
@Service
public class StudentServiceImpl implements StudentService {

	// @Autowired
	@PersistenceContext
	StudentRepository studentRepository;

	@Override
	public Student getStudentById(Long studentId) {
		return studentRepository.getOne(studentId);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public boolean deleteStudent(Student student) {
		try {
			studentRepository.delete(student);
			return true;
		} catch (Exception e) {
			// e.printStackTrace();
			// Do nothing
		}
		return false;
	}

	@Override
	public boolean deleteStudentById(Long studentId) {
		try {
			studentRepository.deleteById(studentId);
			return true;
		} catch (Exception e) {
			// e.printStackTrace();
			// Do nothing
		}
		return false;
	}

}
