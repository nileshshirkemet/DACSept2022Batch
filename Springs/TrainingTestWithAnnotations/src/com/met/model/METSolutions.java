package com.met.model;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/*<bean id="metSolutions" class="com.met.model.METSolutions">   -> @COmponent
	
	</bean>
*/

/*autowire="byType" -> @Autowired*/


@Component
public class METSolutions implements TrainingCompany{

	/*
	 * @Autowired //@Qualifier("javaTrainer") private Trainer trainer;
	 * 
	 * @Autowired(required = false) private DataSource dataSource;
	 * 
	 * public METSolutions() { super(); // TODO Auto-generated constructor stub
	 * System.out.println("Default constructor for METSolutions invoked..."); }
	 * 
	 * public METSolutions(Trainer trainer) { super(); this.trainer = trainer;
	 * System.out.println("Paramaterized constructor for METSolutions invoked...");
	 * }
	 * 
	 * public Trainer getTrainer() { return trainer; }
	 * 
	 * public void setTrainer(Trainer trainer) { this.trainer = trainer; }
	 * 
	 * @Override public void conductTraining() {
	 * 
	 * System.out.println("METSolutions :: conductTraining()"); trainer.train();
	 * 
	 * }
	 * 
	 * @Override public String toString() { // TODO Auto-generated method stub
	 * return "METSolutions is a TrainingCompany"; }
	 */
	
	@Autowired
	private List<Trainer> trainers;
	
	public METSolutions() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("Default constructor for METSolutions invoked...");
	}

	public METSolutions(List<Trainer> trainers) {
		super();
		this.trainers = trainers;
		System.out.println("Paramaterized constructor for METSolutions invoked...");
	}

	public List<Trainer> getTrainer() {
		return trainers;
	}

	public void setTrainer(List<Trainer> trainers) {
		this.trainers = trainers;
	}

	@Override
	public void conductTraining() {
		
		System.out.println("METSolutions :: conductTraining()");
		//trainer.train();
		
		for(Trainer trainer: trainers) {
			trainer.train();
		}
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "METSolutions is a TrainingCompany";
	}
	
	
}
