package com.asti.bashdata.user.dto.response;

import com.asti.bashdata.user.enums.AccountStatus;
import com.asti.bashdata.user.enums.Role;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Represents user information returned to API consumers.
 */
public record UserResponse(

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

        LocalDateTime createdAt

) {
}