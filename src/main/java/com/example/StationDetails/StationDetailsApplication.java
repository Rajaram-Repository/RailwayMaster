package com.example.StationDetails;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class StationDetailsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StationDetailsApplication.class, args);
	}

}
