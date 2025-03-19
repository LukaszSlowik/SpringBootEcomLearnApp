package com.lukasz2.SpringBootEcomLearnApp.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    @Pointcut("@within(com.lukasz2.demoApp.service.EcomProductService")
    //@Pointcut("execution(* com.lukasz2.demoApp.service.EcomProductService.*(..))") the same as @within but without * .*(..)
    private void ecomProductServicePointcat(){};

    @Around("ecomProductServicePointcat()") //"execution(* com.lukasz2.demoApp.service.EcomProductService.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable{
        System.out.println("Aspect log called before " + joinPoint.getSignature().getName());
        Object result = joinPoint.proceed();
        System.out.println("Aspect after log called");
        return result;
    }
}
