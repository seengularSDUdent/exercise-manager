package org.example.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.logging.Logger;

@Aspect
public class LogAspect {

    Logger logger = Logger.getLogger(LogAspect.class.getName());

    @Around("execution(* org.example.service.ExercisePerform.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        logger.info("Method start to execution - " + methodName);
        Object returned = null;
        try {
            returned = joinPoint.proceed();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        logger.info("Method executed and returned - " + args[0].toString());

        return returned;
    }
}
