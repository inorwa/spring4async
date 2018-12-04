package io.inorwa.demo.spring4async.config;


import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
public class ThreadPollConfig implements AsyncConfigurer {

	@Override
	public Executor getAsyncExecutor() {

		ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();

		threadPoolTaskExecutor.setThreadNamePrefix("SAMPLE -");
		threadPoolTaskExecutor.setCorePoolSize(10);
		threadPoolTaskExecutor.setMaxPoolSize(20);
		threadPoolTaskExecutor.setQueueCapacity(10);
		threadPoolTaskExecutor.setKeepAliveSeconds(10);
		threadPoolTaskExecutor.initialize();
		return threadPoolTaskExecutor;
	}

	@Override
	public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
		return null;
	}

}
