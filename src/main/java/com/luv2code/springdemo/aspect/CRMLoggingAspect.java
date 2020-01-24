package com.luv2code.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class CRMLoggingAspect {
	
	//setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	//setup pointcut declarations
	//scan all controller class/methods
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	private void forControllerPackage() { }
	
	//scan all controller class/methods
	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	private void forServicePackage() { }
	
	//scan all controller class/methods
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	private void forDaoPackage() { }
	
	//Pointcut all together
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {	}
	
	//add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		//display method we are calling
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====> in @Before: calling method "+theMethod);
		
		//display the arguments to the  method
		Object[] args = theJoinPoint.getArgs();
		
		for (Object object : args) {
			myLogger.info("\n=====> arguments: "+object);
		}
		
	}
	
	//add @AfterReturning advice
	@AfterReturning(pointcut="forAppFlow()",returning="theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		//display method we are returning from 
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n=====> in @AfterReturning: from method "+theMethod);
		
		//Display data returned
		myLogger.info("\\n=====> in @AfterReturning: result: "+ theResult);
	}

}
