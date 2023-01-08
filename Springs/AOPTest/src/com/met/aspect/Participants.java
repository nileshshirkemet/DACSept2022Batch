package com.met.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class Participants {

	//In this class we will specify about Point cut and advises
	
	//@Pointcut("execution(* com.met.model.Trainer.train(..))")
	
	@Pointcut("execution(* *.train(..))")	//first * -> any accessifier
	public void training() {}				//second * -> train method can be presnt in any class
											// .. -> can have any number of arguements

	/*
	 * @Before("training()") public void beforeTraining() {
	 * 
	 * System.out.println("Participants should take seats");
	 * System.out.println("Participants should mute their mobile phones");
	 * 
	 * }
	 * 
	 * @After("training()") public void trainingCompleted() {
	 * 
	 * System.out.println("Training is completed");
	 * 
	 * }
	 * 
	 * @AfterThrowing("training()") public void trainingFailure() {
	 * System.out.println("Training is failure"); }
	 * 
	 * @AfterReturning("training()") public void trainingSucess() {
	 * 
	 * System.out.println("Training is success");
	 * 
	 * }
	 */
	
	//@Around -> @Before + @After + @AfterThrowing + @AfterReturning
	
	
	@Around("training()")
	public void aroundTraining(ProceedingJoinPoint pjp) {
		
		try {
			System.out.println("Participants should take seats");				//open db conn
			System.out.println("Participants should mute their mobile phones");	//creating pstmt
			
			//invoke business logic
			pjp.proceed();
						
			System.out.println("Training is success");						//commit
			
		} catch (Throwable e) {
			System.out.println("Training is failure");						//rollback tx
			
		}finally {
			System.out.println("Training is completed");					//close the resources
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
