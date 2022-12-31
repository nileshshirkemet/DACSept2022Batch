package com.met.model;

public class Stage {

	private static Stage stage = null;
	
	
	public static Stage getStage() {
		
		if(stage == null)
			stage = new Stage();
		
		return stage;
		
	}
	
	private Stage() {
		
		System.out.println("Private Stage Constructor invoked.......");
		
	}
	
}
