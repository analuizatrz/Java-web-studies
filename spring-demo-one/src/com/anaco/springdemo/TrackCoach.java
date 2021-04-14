package com.anaco.springdemo;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	
	public TrackCoach() {
		System.out.println("parameterless ctor");
	}

	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("Setting fortune service");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		return "Calling fortunee..."+fortuneService.getFortune();
	}

}
