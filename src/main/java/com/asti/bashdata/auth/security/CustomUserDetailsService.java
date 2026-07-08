package com.asti.bashdata.auth.security;

import com.asti.bashdata.common.codes.BusinessError;
import com.asti.bashdata.common.exception.BusinessException;
import com.asti.bashdata.user.entity.User;
import com.asti.bashdata.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

/**
 * Loads users for Spring Security authentication.
 */
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) {

        User user = userRepository

                .findByEmailIgnoreCaseAndDeletedAtIsNull(email)

                .orElseThrow(() ->
                        new BusinessException(
                                BusinessError.INVALID_CREDENTIALS
                        )
                );

        return new SecurityUser(user);

    }

}