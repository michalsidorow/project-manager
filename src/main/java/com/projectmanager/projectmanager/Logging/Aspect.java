package com.projectmanager.projectmanager.Logging;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

@org.aspectj.lang.annotation.Aspect
public class Aspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("within(com.projectmanager.projectmanager.Controllers..*)")
    public void definePackagePointCuts(){
    }

    @After("definePackagePointCuts()")
    public void logAfter(JoinPoint joinPoint){
        System.out.println("-----------------");
        System.out.println(joinPoint.getSignature().getDeclaringTypeName());
        System.out.println(joinPoint.getSignature().getName());
        System.out.println(Arrays.toString(joinPoint.getArgs()));
    }
}
