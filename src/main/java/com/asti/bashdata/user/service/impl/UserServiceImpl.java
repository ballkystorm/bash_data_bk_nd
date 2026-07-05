package com.asti.bashdata.user.service.impl;

import com.asti.bashdata.user.constants.UserConstants;
import com.asti.bashdata.user.dto.request.RegisterUserRequest;
import com.asti.bashdata.user.dto.response.UserResponse;
import com.asti.bashdata.user.entity.User;
import com.asti.bashdata.user.generator.UserCodeGenerator;
import com.asti.bashdata.user.mapper.UserMapper;
import com.asti.bashdata.user.repository.UserRepository;
import com.asti.bashdata.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;

/**
 * Default implementation of UserService.
 */
@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    private final UserCodeGenerator userCodeGenerator;

    @Override
    public UserResponse registerUser(RegisterUserRequest request) {

        validatePasswordConfirmation(request);

        String email = normalizeEmail(request.email());
        String phoneNumber = normalizePhoneNumber(request.phoneNumber());

        validateEmailUniqueness(email);
        validatePhoneNumberUniqueness(phoneNumber);

        User user = userMapper.toEntity(request);

        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setUserCode(userCodeGenerator.generate());
        user.setPasswordHash(passwordEncoder.encode(request.password()));
        user.setRole(UserConstants.DEFAULT_ROLE);
        user.setAccountStatus(UserConstants.DEFAULT_ACCOUNT_STATUS);

        User savedUser = userRepository.save(user);

        return userMapper.toResponse(savedUser);
    }

    private void validatePasswordConfirmation(RegisterUserRequest request) {

        if (!request.password().equals(request.confirmPassword())) {
            throw new IllegalArgumentException("Password confirmation does not match.");
        }
    }

    private void validateEmailUniqueness(String email) {

        if (userRepository.existsByEmailIgnoreCaseAndDeletedAtIsNull(email)) {
            throw new IllegalArgumentException("Email address already exists.");
        }
    }

    private void validatePhoneNumberUniqueness(String phoneNumber) {

        if (userRepository.existsByPhoneNumberAndDeletedAtIsNull(phoneNumber)) {
            throw new IllegalArgumentException("Phone number already exists.");
        }
    }

    private String normalizeEmail(String email) {

        return email.trim().toLowerCase(Locale.ROOT);
    }

    private String normalizePhoneNumber(String phoneNumber) {

        return "+234" + phoneNumber.substring(1);
    }

}