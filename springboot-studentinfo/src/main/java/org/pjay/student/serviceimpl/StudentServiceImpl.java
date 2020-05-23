/**
 * 
 */
package org.pjay.student.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.pjay.student.entity.Student;
import org.pjay.student.exception.StudentNotFoundException;
import org.pjay.student.repository.StudentRepository;
import org.pjay.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author vijayk
 *
 */
@Service
public class StudentServiceImpl implements StudentService {

	// @PersistenceContext -- not working received below error
	// Specified field type [interface
	// org.pjay.student.repository.StudentRepository] is incompatible with resource
	// type [javax.persistence.EntityManager]
	@Autowired
	StudentRepository studentRepository;

	@Override
	public Student getStudentById(Long studentId) {
		// return studentRepository.getOne(studentId);
		Optional<Student> findById = studentRepository.findById(studentId);
		return findById.isPresent() ? findById.get() : null;
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

	// Better implement only deleteById, this is causing unnecessary confusion
	@Override
	public boolean deleteStudent(Student student) {
		if (null == student.getStudentId()) {
			throw new StudentNotFoundException();
		}
		Optional<Student> findById = studentRepository.findById(student.getStudentId());
		if (findById.isPresent()) {
			try {
				// Note: delete(T entity) method in repository works when id is present else
				// delete will not happen. Please verify delete(T entity) method implementation
				// in SimpleJpaRepository.
				studentRepository.delete(student);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				// Do nothing
			}
		}
		return false;
	}

	@Override
	public boolean deleteStudentById(Long studentId) {
		Optional<Student> findById = studentRepository.findById(studentId);
		if (findById.isPresent()) {
			try {
				studentRepository.deleteById(studentId);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				// Do nothing
			}
		}
		return false;
	}

}
