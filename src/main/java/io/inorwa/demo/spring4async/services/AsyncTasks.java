package io.inorwa.demo.spring4async.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class AsyncTasks {

	@Async
	public void calculate(){
		log.info("start async in thread " + Thread.currentThread().getName());
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.info("end async in thread " + Thread.currentThread().getName());
	}
}
