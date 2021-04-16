package com.anaco.springdemoannotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("thatSillyCoach")
//@Component // uses id as tennisCoach
public class TennisCoach implements Coach {

	FortuneService fortuneService;
	
	@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	/*
	@Autowired
	public TennisCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	*/
	@Override
	public String getDailyWorkout() {
		return "Practice tennis";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
