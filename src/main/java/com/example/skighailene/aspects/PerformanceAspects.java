package com.example.skighailene.aspects;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
@Slf4j
public class PerformanceAspects {

    @Around("execution(public * com.example.skighailene.services..*.*(..))")
    public Object executionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object object=proceedingJoinPoint.proceed();
        stopWatch.stop();
        log.info("execution time of {} is {}", proceedingJoinPoint.getSignature().getName() , stopWatch.getTotalTimeMillis());

        return object;

    }
}
