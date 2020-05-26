/**
 * 
 */
package org.pjay.student.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author vijayk
 *
 */
@Controller
public class SpringbootMvcStudentinfoController {

	@GetMapping({ "", "/", "/welcome" })
	// @RequestMapping(value = { "", "/", "/welcome" }, method = RequestMethod.GET)
	public String welcomePage() {
		return "welcome";
	}

	@GetMapping("/testmessage")
	// @RequestMapping(value = "/testmessage", method = RequestMethod.GET)
	public String addStudent(Model model) {
		model.addAttribute("message", "Hello from server...");
		return "testmessage";
	}

}
