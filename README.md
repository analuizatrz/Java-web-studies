# Spring development Process

1. Condigure Spring Beans
2. Create Spring Container
3. Retrieve Beans from Spring Container

## XML
Spring container is a application Context
````xml
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
		<property name="emailAdress" value="ana@oi"/>
		<property name="teams" value="opas"/>
	</bean>
````