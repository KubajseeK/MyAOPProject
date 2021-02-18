package sk.itsovy.kutka.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class WeatherFortuneService {

    public String getFortune() {

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Expect heavy snowing.";
    }

    public String getFortune(boolean tripWire) {
        if (tripWire) {
            throw new RuntimeException("Roads too slippery. All Drivers beware.");
        }
        return getFortune();
    }
}
