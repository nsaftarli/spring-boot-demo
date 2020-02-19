package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * This is the main application class.
 * Spring Boot will autoconfigure and inject dependencies into
 * the application context from here.
 */

@SpringBootApplication
@ComponentScan({"com.example.demo.rest", "com.example.demo.repos", "com.example.demo.security"})
public class DemoApplication {

	/**
	 * Tells Spring Boot to bootstrap the application and run it.
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
