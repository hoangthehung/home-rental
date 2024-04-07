package com.hunghoang.homerental.util.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.function.ServerRequest;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class LoggingHelperUtil {

    public static Object logAdvice(ProceedingJoinPoint joinPoint) throws Throwable {

        Object result;
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        String className = methodSignature.getDeclaringTypeName();
        Method method = methodSignature.getMethod();
        String methodName = methodSignature.getName();
        Loggable loggable = method.getAnnotation(Loggable.class);
        try {
            logMethodEntry(loggable, className, methodName, joinPoint.getArgs());
            long start = System.currentTimeMillis();
            result = joinPoint.proceed();
            if (result instanceof Exception) {

                logException(loggable, className, methodName, (Throwable) result);
            }else {
                            long end = System.currentTimeMillis();
                            logMethodExit(loggable, className, methodName, end - start);
                        }
        } catch (Exception e) {
            logException(loggable, className, methodName, e);
            throw e;
        }
        return result;
    }

    public static void logMethodEntry(Loggable loggable, String className, String methodName, Object[] args) {

        String logStr = String.format("[Method : %s]", methodName);
        if (loggable.withInputArgs()) {
            logStr = String.format("%s [Arguments : %s]", logStr, argumentToString(args,loggable));
        }
        getLogMethod(loggable.level(), className).apply("Entry -> {}", logStr);
    }

    private static String argumentToString(Object[] args, Loggable loggable) {
        if (Objects.nonNull(args) && args.length > 0 && args[0] instanceof ServerRequest) {
            ServerRequest request = (ServerRequest) args[0];
            return String.format("Request[Header : %s, Params: %s, PathVars : %s]",
                    request.headers().toString(),
                    request.params().toString(),
                    request.pathVariables().toString());
        }
        maskArgs(args, loggable);
        return Arrays.toString(args);
    }

    private static void maskArgs(Object[] args, Loggable loggable) {
        int [] maskInput = loggable.maskInputArg();
        String maskValue = loggable.maskValue();
        boolean maskAllInput = loggable.maskAllInput();
        if(Objects.nonNull(args) && (maskAllInput || maskInput.length >0)) {
            Set<Integer> maskInputset = Arrays.stream(maskInput).boxed().collect(Collectors.toSet());
            for( int i =0 ; i< args.length; i++) {
                maskSpecificInput(args, maskValue, maskAllInput, maskInputset, i);

            }
        }
    }

    private static void maskSpecificInput(Object[] args, String maskValue, boolean maskAllInput, Set<Integer> maskInputset, int i) {
        if(maskAllInput || maskInputset.contains(i+1)) {
            if(args[i] instanceof Collection) {
                args[i] = ((Collection<?>)args[i]).stream()
                        .map(o -> MaskingUtil.mask(String.valueOf(o),maskValue))
                        .collect(Collectors.toSet());
            } else {
                String value = String.valueOf(args[i]);
                String prefix = "";
                args[i] = prefix + MaskingUtil.mask(value, maskValue);
            }
        }
    }

    private static void logMethodExit(Loggable loggable, String className, String methodName, long timeInMilliseconds) {
        String logStr = String.format("[Method : %s]", methodName);
        if (loggable.withExecutionTime()) {
            logStr = String.format("%s [Executed In : %sms]", logStr, timeInMilliseconds);
        }
        getLogMethod(loggable.level(), className).apply("Exit -> {}", logStr);
    }

    private static void logException(Loggable loggable, String className, String methodName, Throwable throwable) {
        Logger logger = LoggerFactory.getLogger(className);
        if (isLoggable(loggable.level(), Level.DEBUG)) {
            logger.error("Error -> [Method : {}] [Exception : {}]", methodName, throwable.getMessage(), throwable);
        } else {
            logger.error("Error -> [Method : {}] [Exception : {}]", methodName, throwable.getMessage());
        }
    }

    private static boolean isLoggable(Level requesterLevel, Level methodLevel) {
        return requesterLevel.getLevelAsInt() >= methodLevel.getLevelAsInt();
    }

    private static BiFunction<String, String, Void> getLogMethod(Level requesterLevel, String className) {
        Logger logger = LoggerFactory.getLogger(className);

        switch (requesterLevel) {
            case INFO:
                return (format, args) -> {
                    logger.info(format, args);
                    return null;
                };
            case DEBUG:
                return (format, args) -> {
                    logger.debug(format, args);
                    return null;
                };
            default:
                return (format, args) -> {
                    logger.trace(format, args);
                    return null;
                };
        }

    }

}
