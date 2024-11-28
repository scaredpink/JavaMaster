package com.i.love.wsq.metrics;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author baitao05
 */
@Aspect
@Component
public class MetricAspect {
    @Around("@annotation(metricTime)")
    public Object metric(ProceedingJoinPoint pjp, MetricTime metricTime) throws Throwable {
        String name = metricTime.value();
        Long start = System.currentTimeMillis();
        try {
            return pjp.proceed();
        } finally {
            Long end = System.currentTimeMillis();
            Long time = end - start;
            System.err.println("[Metrics]" + name + ": " + time + "ms");
        }
    }
}
