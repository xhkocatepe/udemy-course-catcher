package com.iztech.udemycoursecatcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class UdemyCourseCatcherApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(UdemyCourseCatcherApplication.class, args);
	}

	public static ApplicationContext getAppContextForLambda() {
		SpringApplication application = new SpringApplication(UdemyCourseCatcherApplication.class);
		application.setWebApplicationType(WebApplicationType.NONE);

		return application.run();
	}

}
