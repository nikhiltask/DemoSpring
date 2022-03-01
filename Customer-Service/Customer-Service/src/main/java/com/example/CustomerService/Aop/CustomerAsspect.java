package com.example.CustomerService.Aop;

import com.example.CustomerService.Exceptions.CustomerAlreadyExistsException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@Aspect
@Configuration
public class CustomerAsspect {

    private final Logger log = LoggerFactory.getLogger(CustomerAsspect.class);
    @Before(value = "execution(* com.example.CustomerService.Controller.*.*(..))")
    public void logStatementBefore(JoinPoint joinPoint) {
        log.info("Executing controller {}", joinPoint);
    }
    @Before(value = "execution(* com.example.customer.Service.*.*(..))")
    public void logStatementBeforeService(JoinPoint joinPoint) {
        log.info("Executing service {}", joinPoint);
    }
    @After(value = "execution(* com.example.CustomerService.Controller.*.*(..))")
    public void logStatementAfter(JoinPoint joinPoint) {
        log.info("Complete exception of controller {}", joinPoint);
    }
    @AfterReturning(value = "execution(* com.example.CustomerService.Controller.*.*(..))",
            returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        log.info("{} returned with value {}", joinPoint, result);
    }
    @Around(value = "execution(* com.example.CustomerService.Service.*.*(..))")
    public Object taskHandler(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            Object obj = joinPoint.proceed();
            return obj;
        } catch (CustomerAlreadyExistsException  e) {
            log.info(" CustomerException StatusCode {}", HttpStatus.NOT_FOUND);
            log.info("CustomerException Message {}", e.getMessage());
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }
}
