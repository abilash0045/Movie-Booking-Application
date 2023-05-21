package com.AccioJob.MovieBookingApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class MovieBookingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieBookingAppApplication.class, args);
		ExtractEndpoints extractEndpoints = new ExtractEndpoints();
		extractEndpoints.fun();
	}

}
