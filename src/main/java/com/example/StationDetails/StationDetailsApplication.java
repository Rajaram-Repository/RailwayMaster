package com.example.StationDetails;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class StationDetailsApplication {

	// @GetMapping
    // public String welcome(){
    //     return "welcome";
    // }
    // @GetMapping("/user")
    // public Principal user(Principal principal){
    //     System.out.println("username    :      "+principal.getName());
    //     return principal;
    // }
	public static void main(String[] args) {
		SpringApplication.run(StationDetailsApplication.class, args);
	}

}
