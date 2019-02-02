package com.dev.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.dev")
@EntityScan("com.dev")
@EnableJpaRepositories("com.dev")
public class SpringBootStarter extends SpringBootServletInitializer{
	public static void main(String[] args) {
		SpringApplication.run(SpringBootStarter.class, args);
	}
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	      return application.sources(SpringBootStarter.class);
	   }
}
