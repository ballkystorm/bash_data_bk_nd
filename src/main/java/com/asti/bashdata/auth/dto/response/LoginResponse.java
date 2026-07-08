package com.asti.bashdata.auth.dto.response;

import com.asti.bashdata.user.enums.AccountStatus;
import com.asti.bashdata.user.enums.Role;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Represents the response returned after a successful login.
 */
public record LoginResponse(

        UUID id,

        String userCode,

        String fullName,

        String firstName,

        String lastName,

        String email,

        String phoneNumber,

        Role role,

        AccountStatus accountStatus,

        boolean emailVerified,

        boolean phoneVerified,

        String accessToken,

        String tokenType,

        LocalDateTime loginAt

) {
}