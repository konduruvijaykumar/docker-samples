package org.pjay.student;

import org.h2.server.web.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * @author vijayk
 *
 */
@SpringBootApplication
public class SpringbootStudentinfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootStudentinfoApplication.class, args);
	}
	
	// https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html
	// Register the h2 database servlet to start or run for accessing the DB console
	// https://github.com/spring-projects/spring-boot/commit/ec8b94f13cdd8e31bf8de7489eba26438b352ab5
	// https://github.com/thewca/tnoodle/issues/86
	// http://stackoverflow.com/questions/17803718/view-content-of-embedded-h2-database-started-by-spring
	@Bean
	public ServletRegistrationBean<WebServlet> h2ServletRegistration() {
		ServletRegistrationBean<WebServlet> servletRegistrationBean = new ServletRegistrationBean<WebServlet>(new WebServlet());
		// servletRegistrationBean.setServlet(new WebServlet());
		servletRegistrationBean.addUrlMappings("/h2-console/*");
		servletRegistrationBean.addInitParameter("webAllowOthers", "true");
		return servletRegistrationBean;
	}

}
