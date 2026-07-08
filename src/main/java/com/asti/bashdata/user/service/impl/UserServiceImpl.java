package com.asti.bashdata.user.service.impl;

import com.asti.bashdata.common.codes.BusinessError;
import com.asti.bashdata.common.exception.BusinessException;
import com.asti.bashdata.common.util.EmailNormalizer;
import com.asti.bashdata.common.util.PhoneNumberNormalizer;
import com.asti.bashdata.user.constants.UserConstants;
import com.asti.bashdata.user.dto.request.RegisterUserRequest;
import com.asti.bashdata.user.dto.response.UserResponse;
import com.asti.bashdata.user.entity.User;
import com.asti.bashdata.user.generator.UserCodeGenerator;
import com.asti.bashdata.user.mapper.UserMapper;
import com.asti.bashdata.user.repository.UserRepository;
import com.asti.bashdata.user.service.UserService;
import com.asti.bashdata.user.validator.RegistrationValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Default implementation of UserService.
 */
@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;

    private final UserCodeGenerator userCodeGenerator;

    private final EmailNormalizer emailNormalizer;

    private final PhoneNumberNormalizer phoneNumberNormalizer;

    private final RegistrationValidator registrationValidator;

    @Override
    public UserResponse registerUser(RegisterUserRequest request) {

        String email = emailNormalizer.normalize(request.email());

        String phoneNumber =
                phoneNumberNormalizer.normalize(request.phoneNumber());

        registrationValidator.validate(
                request,
                email,
                phoneNumber
        );

        User user = buildUser(
                request,
                email,
                phoneNumber
        );

        User savedUser = userRepository.save(user);

        log.info(
                "User registered successfully. UserCode: {}, Email: {}",
                savedUser.getUserCode(),
                savedUser.getEmail()
        );

        return userMapper.toResponse(savedUser);

    }

    @Override
    public User findByEmail(String email) {

        return userRepository
                .findByEmailIgnoreCaseAndDeletedAtIsNull(email)
                .orElseThrow(() ->
                        new BusinessException(
                                BusinessError.USER_NOT_FOUND
                        )
                );

    }

    /**
     * Builds a new user entity from the registration request.
     *
     * @param request registration request
     * @param email normalized email
     * @param phoneNumber normalized phone number
     * @return user entity
     */
    private User buildUser(
            RegisterUserRequest request,
            String email,
            String phoneNumber) {

        User user = userMapper.toEntity(request);

        user.setEmail(email);

        user.setPhoneNumber(phoneNumber);

        user.setUserCode(
                userCodeGenerator.generate()
        );

        user.setPasswordHash(
                passwordEncoder.encode(request.password())
        );

        user.setRole(
                UserConstants.DEFAULT_ROLE
        );

        user.setAccountStatus(
                UserConstants.DEFAULT_ACCOUNT_STATUS
        );

        return user;

    }

}