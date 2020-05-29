/**
 * 
 */
package org.pjay.student.controller;

import java.util.List;
import java.util.Map;

import org.pjay.student.converter.StudentInfoToStudent;
import org.pjay.student.converter.StudentToStudentInfo;
import org.pjay.student.entity.Student;
import org.pjay.student.model.StudentInfo;
import org.pjay.student.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author vijayk
 *
 */
@Controller
// TODO: converting Student to StudentInfo object while sending to UI
public class SpringbootMvcStudentinfoController {

	@Autowired
	StudentService studentService;

	@Autowired
	StudentInfoToStudent studentInfoToStudent;

	@Autowired
	StudentToStudentInfo studentToStudentInfo;

	@GetMapping({ "", "/", "/welcome", "/home" })
	// @RequestMapping(value = { "", "/", "/welcome" }, method = RequestMethod.GET)
	public String welcomePage() {
		return "welcome";
	}

	@GetMapping("/testmessage")
	// @RequestMapping(value = "/testmessage", method = RequestMethod.GET)
	public String testMessage(Model model) {
		model.addAttribute("message", "Hello from server...");
		return "testmessage";
	}

	@GetMapping("/addstudent")
	public String showStudentAddPage(Map<String, Object> model) {
		StudentInfo studentInfo = new StudentInfo();
		model.put("student", studentInfo);
		return "addstudent";
	}

	@PostMapping("/addstudent")
	public ModelAndView addStudent(@ModelAttribute() StudentInfo studentInfo) {
		ModelAndView modelAndView = new ModelAndView("showstudent");
		Student createdStudent = studentService.createStudent(studentInfoToStudent.convert(studentInfo));
		modelAndView.addObject("student", createdStudent);
		return modelAndView;
	}

	@GetMapping("/showallstudents")
	public ModelAndView showAllStudents() {
		ModelAndView modelAndView = new ModelAndView("showallstudents");
		List<Student> allStudents = studentService.getAllStudents();
		modelAndView.addObject("students", allStudents);
		return modelAndView;
	}

}
