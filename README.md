# Spring development Process

1. Configure Spring Beans
2. Create Spring Container
3. Retrieve Beans from Spring Container

there are 3 ways:

1. Full XML config
2. XML component scan (one xml to register the project to be scanned)
3. Java configuration class

## Scopes

Singleton (default)
init and destroy, manages the bean so it can be handed to other services

Once loaded into memory all classes will shared the bean reference

Prototype
init only, and sended to requestors to manage

Create a new instace each request for bean

## XML

Spring container is a application Context

```xml
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
```

## Anotations

Component id = "the silly coach"
constructor, setter, field injections.

### Constructor injection

The Component annotation tells spring that the class is a bean, and could be get from the context/container

```xml
	<!-- add entry to enable project scanning -->
	<context:component-scan base-package="com.anaco.springdemoannotations"/>
```

```java
package com.anaco.springdemoannotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("thatSillyCoach") // or @Component, so de default id is the class name slithery, tennisCoach
//@Component // uses id as tennisCoach
public class TennisCoach implements Coach {

	FortuneService fortuneService;
	// the constructor injection
	@Autowired
	public TennisCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	@Override
	public String getDailyWorkout() {
		return "Practice tennis";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}
}

```

```java
package com.anaco.springdemoannotations;

import org.springframework.stereotype.Component;

@Component
public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is your lucky day";
	}
}

```

```java
public class AnnotationDemoApp {

	public static void main(String[] args) {
		// read sprint config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// get the bean from spring container
		var sillyCoach = context.getBean("thatSillyCoach", TennisCoach.class);

		// call a method on the bean
		System.out.println(sillyCoach.getDailyWorkout());

		// call the method to get daily fortune
		System.out.println(sillyCoach.getDailyFortune());

		context.close();
	}
}
```

### Setter injection

```java
package com.anaco.springdemoannotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("thatSillyCoach")
//@Component // uses id as tennisCoach
public class TennisCoach implements Coach {

	FortuneService fortuneService;

	// the setter injection
	@Autowired
	public void setFortuneService(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	/*
	@Autowired // With other names works too
	public void CrasaudiUSHADaksdjnakd(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}*/

	@Override
	public String getDailyWorkout() {
		return "Practice tennis";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
```

### Field injection

```java
package com.anaco.springdemoannotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("thatSillyCoach")
public class TennisCoach implements Coach {
	// field injection, through reflection, all behind the scenes
	@Autowired
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
```

### Qualifier

```java
package com.anaco.springdemoannotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("thatSillyCoach")
public class TennisCoach implements Coach {
	// field injection, through reflection, all behind the scenes
	@Autowired
	@Qualifier("happyFortuneService")// with the id of the specific bean
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
```

### Scopes

`@Scope("prototype")` ou `@Scope("singleton")` (default)

```java
package com.anaco.springdemoannotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("thatSillyCoach")
@Scope("prototype") // defines the scope, which can be singleton or prototype
public class TennisCoach implements Coach {
	// field injection, through reflection, all behind the scenes
	@Autowired
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
```

### Life cycle

@PreDestroy, @PosConstruct

```java
package com.anaco.springdemoannotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
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
	@PostConstruct
	public void DoMyStartUpStuff() {
		System.out.println("Inside do my start up stuff");
	}
	@PreDestroy
	public void DoMyCleanupStuff() {
		System.out.println("Inside do my start up stuff");
	}

}
```

## Annotation only (no XML)

Por meio de scan de projeto. `@Configuration`, `@ComponentScan()` e `new AnnotationConfigApplicationContext()`

```java
package com.anaco.springdemoannotations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.anaco.springdemoannotations")
public class SportConfig {

}

```

```java
package com.anaco.springdemoannotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		// read sprint config file
		//ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		var context = new AnnotationConfigApplicationContext(SportConfig.class);
		// get the bean from spring container
		var sillyCoach = context.getBean("thatSillyCoach", TennisCoach.class);

		// call a method on the bean
		System.out.println(sillyCoach.getDailyWorkout());

		// call the method to get daily fortune
		System.out.println(sillyCoach.getDailyFortune());

		context.close();
	}
}

```

## No config scans

No annotations in the services ! =D

```java
package com.anaco.springdemoannotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
	// define bean for sad fortune service. the name of the function is the name of the bean
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

```

```java
package com.anaco.springdemoannotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		// read sprint config file
		var context = new AnnotationConfigApplicationContext(SportConfig.class);

		// get the bean from spring container
		var sillyCoach = context.getBean("swimCoach", Coach.class);

		// call a method on the bean
		System.out.println(sillyCoach.getDailyWorkout());

		// call the method to get daily fortune
		System.out.println(sillyCoach.getDailyFortune());

		context.close();
	}
}
```

## Add hibernate validation

https://sourceforge.net/projects/hibernate/

##

When delete a instructor, delete a instructorDetail

```java
	@OneToOne(mappedBy="detail", cascade = CascadeType.ALL)
	private Instructor instructor;
```

If delete a course, do not delete a student
If delete a student, do not delete a course

```java
	@ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	@JoinTable(name = "course_student",
				joinColumns = @JoinColumn(name = "student_id"),
				inverseJoinColumns = @JoinColumn(name="course_id"))
	private List<Course> courses;
```

# AOP

Aspect: module of code for a cross cutting concern (logging, security)
Advice: What action is taken and when should be applied
Join Point: When to apply code during program execution
PointCut: A predicate expression for where advice should be applied

Parameter pattern wildcards

-() - method with no arguments
- (*) - method with one argument of any type
- (..) method with 0 or more arguments of any type 
# Maven

dependency manager. It uses a remote repository with jars and checks for the dependencies of the project.
When needed, the required jars are downloaded, and used. They are added to the class path by maven too.
Maven also provides a default project organization wich makes it easier to checkout new projects.

## POM

the pom file is a configuration file. It stands for Project Object Model
project metadata, list of dependencies and plugins.

```xml

```

## GAV

Group Artifact Version
