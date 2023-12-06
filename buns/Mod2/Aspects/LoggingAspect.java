package com.example.Buns.Mod2.Aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class LoggingAspect {
    @Before("com.example.Buns.Mod2.Aspects.MyPointcuts.allAddMethods().MyPointcuts.allAddMethods() || mod2.aspects.MyPointcuts.allGetMethods() || mod2.aspects.MyPointcuts.allReturnMethods()")
    public void beforeLibraryMethodAdvice(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("Preparing to execute method: " + methodName + " with params: " + Arrays.toString(args));
    }

    @Around("com.example.Buns.Mod2.Aspects.MyPointcuts.allAddMethods().MyPointcuts.allAddMethods() || mod2.aspects.MyPointcuts.allGetMethods() || mod2.aspects.MyPointcuts.allReturnMethods()")
    public Object aroundLibraryMethodAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        String methodName = proceedingJoinPoint.getSignature().getName();
        Object[] args = proceedingJoinPoint.getArgs();
        System.out.println("Executing method: " + methodName + " with params: " + Arrays.toString(args));

        Object result;
        try {
            result = proceedingJoinPoint.proceed();
            System.out.println("Method " + methodName + " completed with result: " + result);
        } catch (Exception e) {
            System.out.println("Exception in method: " + methodName + ": " + e.getMessage());
            throw e;
        }

        long executionTime = System.currentTimeMillis() - start;
        System.out.println("Execution time of method " + methodName + ": " + executionTime + "ms");

        return result;
    }
}