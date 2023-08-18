package com.system.blaze;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource(value = {"classpath:customCode.properties"})
public class BlazeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlazeApplication.class, args);
	}

}
