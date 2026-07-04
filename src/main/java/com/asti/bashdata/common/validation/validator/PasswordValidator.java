package com.asti.bashdata.common.validation.validator;

import com.asti.bashdata.common.validation.annotation.ValidPassword;
import com.asti.bashdata.common.validation.pattern.ValidationPatterns;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

/**
 * Validates passwords against the application's password policy.
 */
public class PasswordValidator implements ConstraintValidator<ValidPassword, String> {

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile(ValidationPatterns.PASSWORD);

    @Override
    public boolean isValid(String password,
                           ConstraintValidatorContext context) {

        if (password == null || password.isBlank()) {
            return false;
        }

        return PASSWORD_PATTERN.matcher(password).matches();
    }

}