package com.asti.bashdata.common.validation.validator;

import com.asti.bashdata.common.validation.annotation.ValidPhoneNumber;
import com.asti.bashdata.common.validation.pattern.ValidationPatterns;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

/**
 * Validates Nigerian mobile phone numbers.
 */
public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, String> {

    private static final Pattern PHONE_PATTERN =
            Pattern.compile(ValidationPatterns.NIGERIAN_PHONE);

    @Override
    public boolean isValid(String phoneNumber,
                           ConstraintValidatorContext context) {

        if (phoneNumber == null || phoneNumber.isBlank()) {
            return false;
        }

        return PHONE_PATTERN.matcher(phoneNumber).matches();
    }

}