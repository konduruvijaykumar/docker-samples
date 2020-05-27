/**
 * 
 */
package org.pjay.student.controller;

import java.util.Map;

import org.pjay.student.model.StudentInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author vijayk
 *
 */
@Controller
public class SpringbootMvcStudentinfoController {

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
	public String addstudent(Map<String, Object> model) {
		StudentInfo studentInfo = new StudentInfo();
		studentInfo.setFirstName("Vijay");
		model.put("student", studentInfo);
		return "addstudent";
	}

}
