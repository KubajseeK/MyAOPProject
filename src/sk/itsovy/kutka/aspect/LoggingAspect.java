package sk.itsovy.kutka.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import sk.itsovy.kutka.Car;

import java.util.List;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(public void addCar(*))")
    public void beforeAdvice() {
        System.out.println("@Before on Add Car");
    }


    @AfterReturning(pointcut = "execution(* sk.itsovy.kutka.dao.CarDAO.findCars(..))", returning = "result")
    public void afterReturningAdvice(List<Car> result) {

        System.out.println("@After Returning");
        System.out.println(result);
    }

    @AfterThrowing(pointcut = "execution(* sk.itsovy.kutka.dao.CarDAO.findCars(..))", throwing = "exception")
    public void afterThrowingAdvice(Throwable exception) {

        System.out.println("@After Throwing: " + exception);

    }

    @After("execution(* sk.itsovy.kutka.dao.CarDAO.findCars(..))")
    public void afterAdvice(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("@After Finally: " + method);
    }

    @Around("execution(* sk.itsovy.kutka.service.*.getFortune(..))")
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {

        String method = joinPoint.getSignature().toShortString();
        System.out.println("@Around: " + method);

        long begin = System.currentTimeMillis();

        Object result = null;
        try {
        result = joinPoint.proceed();
        } catch (Exception e) {
            throw e;
        }

        long end = System.currentTimeMillis();

        long duration = end - begin;
        System.out.println("Duration: " + duration/1000.0 + "seconds");

        return result;
    }
}
