package com.met.nonspring.test;

import java.util.ArrayList;
import java.util.List;

import com.met.model.JavaTrainer;
import com.met.model.METSolutions;
import com.met.model.Trainer;
import com.met.model.TrainingWorkshop;
import com.met.model.Workshop;

public class NonSpringTrainingTest {

	public static void main(String[] args) {
		
		/*
		 * List<String> subjects = new ArrayList<>(4); subjects.add("OOPS");
		 * subjects.add("JDBC"); subjects.add("Collections"); subjects.add("Lambda");
		 * 
		 * Trainer javaTrainer = new JavaTrainer("Ajay", subjects);
		 */
		
		List<String> subjects = new ArrayList<>(4);
		subjects.add("RMI");
		subjects.add("Servlets");
		subjects.add("JSP");
		subjects.add("WebServices");
		
		Trainer advJavaTrainer = new JavaTrainer("Ramesh", subjects);
		
		//javaTrainer.train();
		
		METSolutions metSolutions = new METSolutions();
		metSolutions.setTrainer(advJavaTrainer);
		
		//metSolutions.conductTraining();
		
		
		Workshop tw = new TrainingWorkshop(metSolutions);
		tw.conductWorkshop();
		
		
		
	}
	
}
