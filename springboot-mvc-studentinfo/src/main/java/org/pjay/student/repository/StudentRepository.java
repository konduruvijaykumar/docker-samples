/**
 * 
 */
package org.pjay.student.repository;

import org.pjay.student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author vijayk
 *
 */
public interface StudentRepository extends JpaRepository<Student, Long>{

}
