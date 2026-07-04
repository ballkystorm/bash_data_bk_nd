package com.asti.bashdata.common.validation.annotation;

import com.asti.bashdata.common.constants.validation.ValidationMessages;
import com.asti.bashdata.common.validation.validator.PhoneNumberValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Validates Nigerian mobile phone numbers.
 */
@Documented
@Constraint(validatedBy = PhoneNumberValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidPhoneNumber {

    String message() default ValidationMessages.INVALID_PHONE;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}