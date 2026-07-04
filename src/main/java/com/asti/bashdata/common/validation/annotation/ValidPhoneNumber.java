package com.asti.bashdata.common.validation.annotation;

import com.asti.bashdata.common.validation.validator.PhoneNumberValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

/**
 * Validates Nigerian phone numbers.
 */
@Documented
@Constraint(validatedBy = PhoneNumberValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPhoneNumber {

    String message() default
            "Please provide a valid Nigerian phone number.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}