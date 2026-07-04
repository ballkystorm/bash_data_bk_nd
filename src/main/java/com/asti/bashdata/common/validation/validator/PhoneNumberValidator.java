package com.asti.bashdata.common.validation.validator;

import com.asti.bashdata.common.validation.annotation.ValidPhoneNumber;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

/**
 * Validates Nigerian phone numbers.
 */
public class PhoneNumberValidator
        implements ConstraintValidator<ValidPhoneNumber, String> {

    private static final Pattern PHONE_PATTERN =
            Pattern.compile("^(070|080|081|090|091)\\d{8}$");

    @Override
    public boolean isValid(String phoneNumber,
                           ConstraintValidatorContext context) {

        if (phoneNumber == null) {
            return false;
        }

        return PHONE_PATTERN.matcher(phoneNumber).matches();
    }

}