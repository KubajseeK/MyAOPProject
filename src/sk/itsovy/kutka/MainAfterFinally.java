package sk.itsovy.kutka;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sk.itsovy.kutka.dao.CarDAO;

import java.util.List;

public class MainAfterFinally {

    public static void main(String[] args) {
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

	CarDAO carDAO = context.getBean("carDAO", CarDAO.class);
	List<Car> cars = null;

	try {
		boolean tripWire = true;
		 cars = carDAO.findCars(tripWire);
	} catch (Exception e) {
		e.printStackTrace();
	}

	System.out.println("After Finally Main");

	System.out.println(cars);



	context.close();

    }
}
