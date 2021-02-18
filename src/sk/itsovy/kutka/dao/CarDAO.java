package sk.itsovy.kutka.dao;

import org.springframework.stereotype.Component;
import sk.itsovy.kutka.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarDAO {

    List<Car> cars = new ArrayList<>();

    public void addCar(String model) {
        System.out.println("Adding Car: " + model);
    }


    public List<Car> findCars() {

        Car car1 = new Car("Ford Mustang", "Gasoline");
        Car car2 = new Car("Honda Civic", "Gasoline");

        cars.add(car2);
        cars.add(car1);

         return cars;
    }

    public List<Car> findCars(boolean tripWire) {
        if (tripWire) {
            throw new RuntimeException("You ran out of gas.");
        }

        Car car3 = new Car("Hyundai i30", "Diesel");
        Car car4 = new Car("Pontiac GTO", "LPG");

        cars.add(car3);
        cars.add(car4);

        return cars;
    }
}
