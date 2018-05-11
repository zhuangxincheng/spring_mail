package com.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledService {
	@Value("${spring.time.flag}")
	String falg;
	private static Logger logger = LoggerFactory.getLogger(ScheduledService.class);
//	@Scheduled(cron = "0/5 * * * * *")
//    public void scheduled(){
//		logger.info("=====>>>>>使用cron  {}",System.currentTimeMillis());
//    }
//	@Scheduled(cron = "0/5 * * * * *")
//    public void scheduled2(){
//		logger.info("=====>>>>>使用cron2  {}",System.currentTimeMillis());
//    }
//    @Scheduled(fixedRate = 5000)
//    public void scheduled1() {
//
//    	if("on".equals(falg)) {
//    		logger.info("=====>>>>>使用fixedRate{}", System.currentTimeMillis());
//    	}
//    	
//    }
//    @Scheduled(fixedDelay = 5000)
//    public void scheduled2() {
//    	logger.info("=====>>>>>fixedDelay{}",System.currentTimeMillis());
//    }
}
