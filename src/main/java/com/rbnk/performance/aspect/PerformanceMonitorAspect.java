package com.rbnk.performance.aspect;

import com.rbnk.performance.properties.PerformanceMonitorProperties;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerformanceMonitorAspect {

    private final PerformanceMonitorProperties properties;

    public PerformanceMonitorAspect(PerformanceMonitorProperties properties) {
        this.properties = properties;
    }

    @Around("@annotation(com.rbnk.performance.annotation.MonitorPerformance)")
    public Object monitorPerformance(ProceedingJoinPoint joinPoint) throws Throwable {
        if (!properties.isEnabled()) {
            return joinPoint.proceed();
        }
        long startTime = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - startTime;
        if (executionTime >= properties.getMinExecutionTime()) {
            System.out.printf("%n<<<Method [%s] Executed in [%d] ms>>>%n",
                    joinPoint.getSignature().toShortString(), executionTime);
        }
        return result;
    }
}
