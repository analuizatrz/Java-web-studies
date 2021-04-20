package com.anaco.springdemoannotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.anaco.springdemoannotations")
public class SportConfig {
	// define bean for sad fortune service
	@Bean
	public FortuneService sadFortuneService() {
		return new SadFortuneService();
	}
	// define bean for swim coach
	@Bean
	public Coach swimCoach() {
		return new SwimCoach(sadFortuneService());
	}

}
