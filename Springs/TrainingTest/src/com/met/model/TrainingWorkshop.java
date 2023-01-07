package com.met.model;

public class TrainingWorkshop implements Workshop {

	private TrainingCompany trainingCompany;
	
	public TrainingWorkshop() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("Default constructor for TrainingWorkshop invoked...");
	}

	public TrainingWorkshop(TrainingCompany trainingCompany) {
		super();
		this.trainingCompany = trainingCompany;
		System.out.println("Paramaterized constructor for TrainingWorkshop invoked...");
	}

	public TrainingCompany getTrainingCompany() {
		return trainingCompany;
	}

	public void setTrainingCompany(TrainingCompany trainingCompany) {
		this.trainingCompany = trainingCompany;
	}

	@Override
	public void conductWorkshop() {
		
		System.out.println("TrainingWorkshop :: conductWorkshop()");
		trainingCompany.conductTraining();
		
	}

}
