package io.inorwa.demo.spring4async.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class CalculationService {


	@Autowired
	AsyncTasks asyncTasks;

	public List<Long> calculate(){
		log.info("start calculate in thread " + Thread.currentThread().getName());
		Future<Long> calculateFuture1 = asyncTasks.calculate(10);
		Future<Long> calculateFuture2 = asyncTasks.calculate(20);
		while (!calculateFuture1.isDone() && !calculateFuture1.isDone()){
			try {
				TimeUnit.MILLISECONDS.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		log.info("end calculate in thread " + Thread.currentThread().getName());
		try {
			return  Arrays.asList(calculateFuture1.get(),calculateFuture2.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

	public List<Long> calculate2(){
		log.info("start calculate in thread " + Thread.currentThread().getName());
		CompletableFuture<Long> calculateFuture1 = asyncTasks.calculateCompletable(10);
		CompletableFuture<Long> calculateFuture2 = asyncTasks.calculateCompletable(20);

		CompletableFuture.allOf(calculateFuture1,calculateFuture2).join();

		log.info("end calculate in thread " + Thread.currentThread().getName());
		try {
			return  Arrays.asList(calculateFuture1.get(),calculateFuture2.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return new ArrayList<>();
	}
}
