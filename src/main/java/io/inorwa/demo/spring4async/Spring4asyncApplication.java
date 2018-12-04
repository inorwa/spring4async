package io.inorwa.demo.spring4async;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class Spring4asyncApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring4asyncApplication.class, args);
	}
}
