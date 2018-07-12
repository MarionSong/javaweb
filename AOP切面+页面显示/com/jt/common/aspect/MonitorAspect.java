package com.jt.common.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

/**
 * 监控方法开始执行时间和结束执行时间
 * @author cgb1803
 *
 */
@Order(2)
@Aspect
@Service
public class MonitorAspect {
	private Logger log=Logger.getLogger(MonitorAspect.class.getName());
	/**
	 * 定义切入点Pointcut（在当前应用中指对哪些方法的执行，进行业务监控）
	 * bean为AOP中的一个切入点表达式
	 */
	//@Pointcut("bean(sysConfigServiceImpl)")
	@Pointcut("bean(*ServiceImpl)")
	public void monitorPointCut() {}
	/**
	 * 切入点方法执行之前
	 */
	@Before("monitorPointCut()")
	public void beforeMethod(JoinPoint joinPoint) {
		
		//System.out.println(name+"."+methodName+"method start:"+System.nanoTime());
		log.info(doGetClassMethodInfo(joinPoint)+"start");
	}
	/**
	 * 通知（方法正常结束时执行）
	 * @param joinPoint
	 */
	@AfterReturning("monitorPointCut()")
	public void afterReturnMethod(JoinPoint joinPoint) {
		log.info(doGetClassMethodInfo(joinPoint)+"returning");
	}
	/**
	 * 通知（方法出现异常时执行）
	 * @param joinPoint
	 */
	@AfterThrowing("monitorPointCut()")
	public void afterThrowingMethod(JoinPoint joinPoint) {
		log.info(doGetClassMethodInfo(joinPoint)+"throwing exception");

	}
	
	/**
	 * 切入点方法执行之后
	 */
	@After("monitorPointCut()")
	public void afterMethod(JoinPoint joinPoint) {
		
		log.info(doGetClassMethodInfo(joinPoint)+"end");
	}
	
	private String doGetClassMethodInfo(JoinPoint joinPoint) {
		MethodSignature signature =(MethodSignature) joinPoint.getSignature();
		String name = joinPoint.getTarget().getClass().getName();
		String methodName=signature.getName();
		return name+"."+methodName;
		
	}
	
	
	


	
	
	
	
	
	
	
	
}
