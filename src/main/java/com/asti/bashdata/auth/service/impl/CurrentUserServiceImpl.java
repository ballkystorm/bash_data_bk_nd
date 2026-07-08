package com.asti.bashdata.auth.service.impl;

import com.asti.bashdata.auth.security.SecurityUser;
import com.asti.bashdata.auth.service.CurrentUserService;
import com.asti.bashdata.common.codes.BusinessError;
import com.asti.bashdata.common.exception.BusinessException;
import com.asti.bashdata.user.entity.User;
import com.asti.bashdata.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CurrentUserServiceImpl implements CurrentUserService {

    private final UserService userService;

    @Override
    public User getCurrentUser() {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated()) {
            throw new BusinessException(
                    BusinessError.INVALID_CREDENTIALS
            );
        }

        SecurityUser securityUser =
                (SecurityUser) authentication.getPrincipal();

        return userService.findByEmail(
                securityUser.getUsername()
        );

    }

}