package com;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import com.alibaba.fastjson.JSON;

@Aspect
@Configuration
public class LoggerAopConfig {
	 private static final Logger log = LoggerFactory.getLogger(LoggerAopConfig.class);

	    // 只关注方法名为find前缀的
	    @Pointcut("execution(* com.demo..*.*(..))")
	    public void executeService() {}


	    @Before("executeService()")
	    public void invokeBefore(JoinPoint point) {
	        String realClassName = getRealClassName(point);
	        Object a = point.getArgs()[0];
	        log.info("调用-----"+ realClassName + " 执行 " + getMethodName(point) + " 方法之前"+"--参数"+JSON.toJSONString(a));
	    }

	    
	    @After("executeService()")
	    public void invokeAfter(JoinPoint point) {
	        String realClassName = getRealClassName(point);
	        log.info("调用-----"+ realClassName + " 执行 " + getMethodName(point) + " 方法之后");
	    }


	    /**
	     * 获取被代理对象的真实类全名
	     * @param point 连接点对象
	     * @return 类全名
	     */
	    private String getRealClassName(JoinPoint point) {
	        return point.getTarget().getClass().getName();
	    }

	    /**
	     * 获取代理执行的方法名
	     * @param point 连接点对象
	     * @return 调用方法名
	     */
	    private String getMethodName(JoinPoint point) {
	        return point.getSignature().getName();
	    }
}
