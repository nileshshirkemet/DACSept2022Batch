package com.met.model;

import java.util.List;

public class JavaDotNetTrainer {

	private String name;
	private List<String> subjects;
	
	public JavaDotNetTrainer(String name, List<String> subjects) {
		super();
		this.name = name;
		this.subjects = subjects;
		System.out.println("Paramaterized constructor for JavaDotNetTrainer invoked...");
	}

	public JavaDotNetTrainer() {
		super();
		// TODO Auto-generated constructor stub
		
		System.out.println("Default constructor for JavaDotNetTrainer invoked...");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<String> subjects) {
		this.subjects = subjects;
	}

	public void train() {
		// TODO Auto-generated method stub
		System.out.println("JavaTrainer :: train()");
		
		/*
		 * System.out.println("Participants should take seats");
		 * System.out.println("Participants should mute their mobile phones");
		 */
		System.out.println(name + " is teaching on JavaDotNet Subjects " + subjects);
		
		/* System.out.println("Training is completed"); */
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name + " is a JavaDotNetTrainer";
	}
}



