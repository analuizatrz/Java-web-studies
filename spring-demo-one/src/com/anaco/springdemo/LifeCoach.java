package com.anaco.springdemo;

public class LifeCoach implements Coach {
	@Override
	public String getDailyWorkout() {
		return "Trabalhe enquanto eles dormem rsrs";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return null;
	}
	// add an init method
	public void doMyStartupStuff() {
		System.out.println("LifeCoach: inside method doMyStartupStuff");
	}
	
	// add a destroy method
	public void doMyCleanupStuffYoYo() {
		System.out.println("LifeCoach: inside method doMyCleanupStuffYoYo");		
	}
}
