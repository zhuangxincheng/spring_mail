package com;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@ComponentScan("com.demo")
@EnableAsync //开启异步任务支持
class TaskPoolConfig implements AsyncConfigurer{
	
	 private static final Logger log = LoggerFactory.getLogger(TaskPoolConfig.class);

	 @Override
	    public Executor getAsyncExecutor() {//实现AsyncConfigurer接口并重写getAsyncExecutor方法，并返回一个ThreadPoolTaskExecutor，这样我们就获得了一个基于线程池TaskExecutor
	        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
	        taskExecutor.setCorePoolSize(10);
	        taskExecutor.setMaxPoolSize(80);
	        taskExecutor.setQueueCapacity(100);
	        taskExecutor.initialize();
	        return taskExecutor;
	    }

	 @Override
	    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
	         return new MyAsyncExceptionHandler();  
	    }

	    /**
	     * 自定义异常处理类
	     * @author hry
	     *
	     */
	    class MyAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {  

	        @Override  
	        public void handleUncaughtException(Throwable throwable, Method method, Object... obj) {  
	            log.info("Exception message - " + throwable.getMessage());  
	            log.info("Method name - " + method.getName());  
	            for (Object param : obj) {  
	                log.info("Parameter value - " + param);  
	            }  
	        }  

	    } 

}