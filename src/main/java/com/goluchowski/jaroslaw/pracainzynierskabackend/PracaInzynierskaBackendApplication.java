package com.goluchowski.jaroslaw.pracainzynierskabackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PracaInzynierskaBackendApplication {

	@GetMapping("/")
	public String helloWorld(){
		return "Backendowa aplikacja na pracę inżynierską";
	}

	public static void main(String[] args) {
		SpringApplication.run(PracaInzynierskaBackendApplication.class, args);
	}

}
