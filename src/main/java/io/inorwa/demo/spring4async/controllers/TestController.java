package io.inorwa.demo.spring4async.controllers;

import io.inorwa.demo.spring4async.services.CalculationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class TestController {

	@Autowired
	private CalculationService calculationService;

	@GetMapping("/test")
	public String test(){
		calculationService.calculate();
		return "OK " + LocalDate.now().toString();
	}
}
