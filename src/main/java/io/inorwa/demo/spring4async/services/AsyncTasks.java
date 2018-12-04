package io.inorwa.demo.spring4async.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class AsyncTasks {

	@Async
	public Future<Long> calculate(long number){
		log.info("start async in thread " + Thread.currentThread().getName());
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.info("end async in thread " + Thread.currentThread().getName());
		return new AsyncResult<>(fibonacci(number));
	}

	public static long fibonacci(long n) {
		if (n <= 1) return n;
		else return fibonacci(n-1) + fibonacci(n-2);
	}

	@Async
	public CompletableFuture<Long> calculateCompletable(long number){
		log.info("start async in thread " + Thread.currentThread().getName());
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.info("end async in thread " + Thread.currentThread().getName());
		return CompletableFuture.completedFuture(fibonacci(number));
	}

}
