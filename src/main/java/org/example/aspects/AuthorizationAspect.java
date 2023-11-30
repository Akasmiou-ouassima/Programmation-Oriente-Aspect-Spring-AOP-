package org.example.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Component
@Aspect
@EnableAspectJAutoProxy
public class AuthorizationAspect {
    @Around(value = "@annotation(securedByAspect)",argNames = "proceedingJoinPoint,securedByAspect")
    public Object secure(ProceedingJoinPoint proceedingJoinPoint, SecuredByAspect securedByAspect) throws Throwable {
        String[] roles = securedByAspect.roles();
        boolean isAuthorized = false;
        for (String role : roles) {
            if (SecurityContext.hasRole(role)) {
                isAuthorized = true;
                break;
            }
        }
        if (isAuthorized) {
            return proceedingJoinPoint.proceed();
        }
            throw new RuntimeException("Unauthorized=>403 to access "+proceedingJoinPoint.getSignature().getName());

    }
    /*@AfterThrowing()
    public void logException(Exception e){

    }*/
}


