package com.anaco.springdemoannotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("thatSillyCoach")
//@Scope("prototype")
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
//	@PostConstruct
//	public void DoMyStartUpStuff() {
//		System.out.println("Inside do my start up stuff");
//	}
//	@PreDestroy
//	public void DoMyCleanupStuff() {
//		System.out.println("Inside do my start up stuff");
//	}

}
