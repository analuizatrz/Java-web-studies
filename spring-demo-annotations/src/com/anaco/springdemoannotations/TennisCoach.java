package com.anaco.springdemoannotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("thatSillyCoach")
//@Component // uses id as tennisCoach
public class TennisCoach implements Coach {
	
	@Autowired
	@Qualifier("fileFortuneService")
	private FortuneService fortuneService;

	@Override
	public String getDailyWorkout() {
		return "Practice tennis";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
