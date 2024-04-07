package com.hunghoang.homerental.util.logging;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Loggable {

    /**
     * Acceptable values are "OFF", "ERROR", "WARN", "INFO", "DEBUG" and "TRACE".
     */
    Level level() default Level.OFF;

    boolean withInputArgs() default true;

    boolean withExecutionTime() default true;

    int [] maskInputArg() default {};

    boolean maskAllInput() default false;

    String maskValue() default "*";

}
