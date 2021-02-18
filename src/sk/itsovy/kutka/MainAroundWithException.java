package sk.itsovy.kutka;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sk.itsovy.kutka.service.WeatherFortuneService;

public class MainAroundWithException {

    public static void main(String[] args) {
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

	WeatherFortuneService fortuneService = context.getBean("weatherFortuneService", WeatherFortuneService.class);

	System.out.println("Calling getFortune");

	boolean tripWire = true;
	String data = fortuneService.getFortune(tripWire);

	System.out.println("Fortune for the day is: " + data);

	context.close();

    }
}
