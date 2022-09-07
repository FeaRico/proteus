package ru.makhach.proteus.core.log;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@Log4j2
public class LogAnnotationHandler {
    @Around("@annotation(logAnnotation)")
    public Object handleLog(ProceedingJoinPoint joinPoint, Log logAnnotation) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        log.debug(methodName);

        String loggingString = getLogString(joinPoint);

        log.debug(String.join(" ", methodName, loggingString));
        return joinPoint.proceed();
    }

    private String getLogString(ProceedingJoinPoint joinPoint) {
        Object[] argsArray = joinPoint.getArgs();
        StringBuilder builder = new StringBuilder("log");
        for (Object arg : argsArray) {
            if (arg instanceof HttpServletRequest) {
                HttpServletRequest request = (HttpServletRequest) arg;
                builder.append("request: name = ");
                builder.append(request.getRemoteUser());
                builder.append(" address = ");
                builder.append(request.getRemoteAddr());
            } else {
                builder.append(" param = ");
                builder.append(arg.toString());
            }
        }
        return builder.toString();
    }
}
