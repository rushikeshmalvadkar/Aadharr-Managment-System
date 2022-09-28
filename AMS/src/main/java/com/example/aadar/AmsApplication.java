package com.example.aadar;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class AmsApplication implements ApplicationRunner  {
    
	public static void main(String[] args) {
		SpringApplication.run(AmsApplication.class, args);
		
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
	}
	
	

}
