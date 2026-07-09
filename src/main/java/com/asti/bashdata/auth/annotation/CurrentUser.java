package com.asti.bashdata.auth.annotation;

import java.lang.annotation.*;

/**
 * Injects the currently authenticated user
 * into a controller method parameter.
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrentUser {
}