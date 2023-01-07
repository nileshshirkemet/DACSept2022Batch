package com.met.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*<bean id="trainingWorkshop" class="com.met.model.TrainingWorkshop">  -> @Conponent
	
	</bean>*/

/*autowire="constructor" -> @Autowired*/


@Component
public class TrainingWorkshop implements Workshop {

	private TrainingCompany trainingCompany;
	
	public TrainingWorkshop() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("Default constructor for TrainingWorkshop invoked...");
	}

	@Autowired
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
