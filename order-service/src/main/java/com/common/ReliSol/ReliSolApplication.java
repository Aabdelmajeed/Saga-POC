package com.common.ReliSol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class ReliSolApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReliSolApplication.class, args);
	}

}
