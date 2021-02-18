package sk.itsovy.kutka;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import sk.itsovy.kutka.dao.CarDAO;

public class MainBefore {

    public static void main(String[] args) {
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
	CarDAO carDAO = context.getBean("carDAO", CarDAO.class);

	carDAO.addCar("Mustang");


	context.close();

    }
}
