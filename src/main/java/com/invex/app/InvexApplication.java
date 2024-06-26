package com.invex.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class InvexApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvexApplication.class, args);
	}

}
