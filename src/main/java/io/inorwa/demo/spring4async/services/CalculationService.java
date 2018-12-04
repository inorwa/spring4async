package io.inorwa.demo.spring4async.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CalculationService {


	@Autowired
	AsyncTasks asyncTasks;

	public void calculate(){
		log.info("start calculate in thread " + Thread.currentThread().getName());
		asyncTasks.calculate();
		log.info("end calculate in thread " + Thread.currentThread().getName());
	}
}
