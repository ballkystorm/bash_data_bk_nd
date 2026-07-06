package com.asti.bashdata.user.validator;

import com.asti.bashdata.common.codes.BusinessError;
import com.asti.bashdata.common.exception.BusinessException;
import com.asti.bashdata.user.dto.request.RegisterUserRequest;
import com.asti.bashdata.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Performs business validation for user registration.
 */
@Component
@RequiredArgsConstructor
public class RegistrationValidator {

    private final UserRepository userRepository;

    /**
     * Validates the registration request.
     *
     * @param request registration request
     * @param normalizedEmail normalized email
     * @param normalizedPhone normalized phone number
     */
    public void validate(
            RegisterUserRequest request,
            String normalizedEmail,
            String normalizedPhone
    ) {

        validatePasswordConfirmation(request);

        validateEmailUniqueness(normalizedEmail);

        validatePhoneNumberUniqueness(normalizedPhone);

    }

    /**
     * Ensures password and confirm password match.
     */
    private void validatePasswordConfirmation(
            RegisterUserRequest request) {

        if (!request.password().equals(request.confirmPassword())) {

            throw new BusinessException(
                    BusinessError.PASSWORD_MISMATCH
            );
        }

    }

    /**
     * Ensures email does not already exist.
     */
    private void validateEmailUniqueness(String email) {

        if (userRepository.existsByEmailIgnoreCaseAndDeletedAtIsNull(email)) {

            throw new BusinessException(
                    BusinessError.EMAIL_ALREADY_EXISTS
            );
        }

    }

    /**
     * Ensures phone number does not already exist.
     */
    private void validatePhoneNumberUniqueness(String phoneNumber) {

        if (userRepository.existsByPhoneNumberAndDeletedAtIsNull(phoneNumber)) {

            throw new BusinessException(
                    BusinessError.PHONE_NUMBER_ALREADY_EXISTS
            );
        }

    }

}