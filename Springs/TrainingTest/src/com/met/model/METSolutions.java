package com.met.model;

public class METSolutions implements TrainingCompany{

	private Trainer trainer;
	
	public METSolutions() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("Default constructor for METSolutions invoked...");
	}

	public METSolutions(Trainer trainer) {
		super();
		this.trainer = trainer;
		System.out.println("Paramaterized constructor for METSolutions invoked...");
	}

	public Trainer getTrainer() {
		return trainer;
	}

	public void setTrainer(Trainer trainer) {
		this.trainer = trainer;
	}

	@Override
	public void conductTraining() {
		
		System.out.println("METSolutions :: conductTraining()");
		trainer.train();
		
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "METSolutions is a TrainingCompany";
	}
	
}
