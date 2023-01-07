package com.met.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.met.config.TrainingConfiguration;
import com.met.model.JavaTrainer;
import com.met.model.Trainer;
import com.met.model.TrainingCompany;
import com.met.model.Workshop;

public class SpringTrainingTest {

	public static void main(String[] args) {

		//ApplicationContext context = new ClassPathXmlApplicationContext("training.xml");
		
		ApplicationContext context = new AnnotationConfigApplicationContext(TrainingConfiguration.class);

		System.out.println("***************Post Initialization***************");

		// JavaTrainer javaTrainer = context.getBean("javaTrainer", JavaTrainer.class);
		/*
		 * Trainer javaTrainer = context.getBean("javaTrainer", Trainer.class);
		 * 
		 * 
		 * System.out.println(javaTrainer); javaTrainer.train();
		 * 
		 * 
		 * TrainingCompany trainingCompany = context.getBean("metSolutions",
		 * TrainingCompany.class); System.out.println(trainingCompany);
		 * trainingCompany.conductTraining();
		 */
		
		Workshop workshop = context.getBean("trainingWorkshop", Workshop.class);
		workshop.conductWorkshop();
		

	}

}
