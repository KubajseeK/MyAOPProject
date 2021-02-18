package sk.itsovy.kutka;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sk.itsovy.kutka.dao.CarDAO;
import sk.itsovy.kutka.service.WeatherFortuneService;

import java.util.List;

public class MainAround {

    public static void main(String[] args) {
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

	WeatherFortuneService fortuneService = context.getBean("weatherFortuneService", WeatherFortuneService.class);

	System.out.println("Calling getFortune");

	String data = fortuneService.getFortune();

	System.out.println("Fortune for the day is: " + data);

	context.close();

    }
}
