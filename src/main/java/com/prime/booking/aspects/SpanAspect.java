package com.prime.booking.aspects;

import java.lang.reflect.Method;

import com.prime.booking.annotations.CustomSpan;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import io.micrometer.tracing.Span;
import io.micrometer.tracing.Tracer;
import lombok.RequiredArgsConstructor;


@Aspect
@Component
@RequiredArgsConstructor
public class SpanAspect {

    private final Tracer tracer;


    @Around("@annotation(com.prime.booking.annotations.CustomSpan)")
    public Object createSpan(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        CustomSpan annotation = method.getAnnotation(CustomSpan.class);

        String spanName = annotation.value()
                .isEmpty() ? method.getName() : annotation.value();

        Span start = tracer.nextSpan()
                .name(spanName)
                .start();

        try (Tracer.SpanInScope scope = tracer.withSpan(start)) {
            return joinPoint.proceed();
        } finally {
            start.end();
        }
    }

}
