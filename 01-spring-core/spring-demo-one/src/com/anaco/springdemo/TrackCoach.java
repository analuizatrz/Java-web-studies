package com.anaco.springdemo;

public class TrackCoach implements Coach {

	private FortuneService fortuneService;
	private String emailAdress;
	private String teams;
	public void setTeams(String teams) {
		System.out.println("Setting teams");
		this.teams = teams;
	}

	public TrackCoach() {
		System.out.println("parameterless ctor");
	}
	public String getEmailAdress() {
		return emailAdress;
	}
	public String getTeams() {
		return teams;
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

	public void setEmailAdress(String emailAdress) {
		System.out.println("Setting email");
		this.emailAdress = emailAdress;
	}

}
