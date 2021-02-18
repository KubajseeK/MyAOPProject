package sk.itsovy.kutka;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sk.itsovy.kutka.dao.CarDAO;

import java.util.List;

public class MainAfterReturning {

    public static void main(String[] args) {
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

	CarDAO carDAO = context.getBean("carDAO", CarDAO.class);
	List<Car> cars = carDAO.findCars();

	System.out.println("After Returning Main");

	System.out.println(cars);

	context.close();

    }
}
