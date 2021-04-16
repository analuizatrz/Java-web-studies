# Spring development Process

1. Condigure Spring Beans
2. Create Spring Container
3. Retrieve Beans from Spring Container

## Scopes

Singleton (default)
	init and destroy, manages the bean so it can be handed to other services

Once loaded into memory all classes will shared the bean reference

Prototype
	init only, and sended to requestors to manage

Create a new instace each request for bean

## XML
Spring container is a application Context
````xml
	<!-- load the properties file: sport.properties -->
	<context:property-placeholder location="classpath:sport.properties"/>
	
    <!-- Define your beans here -->
    <bean id="myFortune" class="com.anaco.springdemo.HappyFortuneService">	</bean>
    <bean id="myCoach" class="com.anaco.springdemo.BaseballCoach">
		<!-- set up constructor injection-->
		<constructor-arg ref="myFortune"/>
	</bean>
	<bean id="myTrackCoach" class="com.anaco.springdemo.TrackCoach">	
		<!-- set up property injection-->
		<property name="fortuneService" ref="myFortune"/>
		<!-- inject literal values-->
		<!--<property name="emailAdress" value="ana@oi"/>-->
		<!--<property name="teams" value="opas"/>-->
		
		<property name="emailAdress" value="${foo.email}" />
		<property name="teams" value="${foo.team}" />
````

## Anotations
Component id = "the silly coach"
constructor, setter, field injections.

### Constructor injection
The Component annotation tells spring that the class is a bean, and could be get from the context/container
````xml
	<!-- add entry to enable project scanning -->
	<context:component-scan base-package="com.anaco.springdemoannotations"/>
````
````java
package com.anaco.springdemoannotations;

import org.springframework.stereotype.Component;

@Component("thatSillyCoach") // or @Component, so de default id is the class name slithery, tennisCoach
public class TennisCoach implements Coach {

	@Override
	public String getDailyWorkout() {
		return "Practice tennis";
	}

}

````
````java
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	//var oi = context.getBean("tennisCoach", TennisCoach.class);
	var oi = context.getBean("thatSillyCoach", TennisCoach.class);
	System.out.println(oi.getDailyWorkout());
	context.close();

````