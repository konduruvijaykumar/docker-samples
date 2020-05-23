/**
 * 
 */
package org.pjay.student;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author vijayk
 *
 */
// https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api
// https://dzone.com/articles/spring-boot-restful-api-documentation-with-swagger
// http://www.springboottutorial.com/spring-boot-swagger-documentation-for-rest-services
// https://github.com/springfox/springfox-demos/tree/master/spring-java-swagger
@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("org.pjay.student.controller")).paths(PathSelectors.any())
				.build();
	}

}
