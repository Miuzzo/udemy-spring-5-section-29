package com.luv2code.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(exclude=HibernateJpaAutoConfiguration.class)
@ImportResource({ "classpath:hibernate.cfg.xml" })
public class WebCustomerTrackerApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(WebCustomerTrackerApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(WebCustomerTrackerApplication.class);
	}

}
