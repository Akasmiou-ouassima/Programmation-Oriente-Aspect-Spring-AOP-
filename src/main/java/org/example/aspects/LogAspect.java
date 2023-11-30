package org.example.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
@Aspect
@EnableAspectJAutoProxy // To enable AspectJ Auto Proxy Support in Spring Framework (Spring AOP) we need to add @EnableAspectJAutoProxy annotation to our configuration class.
public class LogAspect {
    Logger logger = Logger.getLogger(LogAspect.class.getName());
 //   @Around("execution(* org.example.service.IMetier.*(..))")
    @Around("@annotation(Log)") // @annotation(Log) : This pointcut expression will match all the methods that are annotated with @Log annotation.
    public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long t1 = System.currentTimeMillis();
        logger.info("From Logging Aspect ... Before "+proceedingJoinPoint.getSignature());
        Object result = proceedingJoinPoint.proceed();
        logger.info("From Logging Aspect ... After "+proceedingJoinPoint.getSignature());
        long t2 = System.currentTimeMillis();
        logger.info("Duration : "+(t2-t1));
        return result;
    }
}
