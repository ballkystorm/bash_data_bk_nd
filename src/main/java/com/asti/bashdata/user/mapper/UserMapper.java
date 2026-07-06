package com.asti.bashdata.user.mapper;

import com.asti.bashdata.user.dto.request.RegisterUserRequest;
import com.asti.bashdata.user.dto.response.UserResponse;
import com.asti.bashdata.user.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

/**
 * Maps between User entity and DTOs.
 */
@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR
)
public interface UserMapper {

    /**
     * Converts a registration request into a User entity.
     *
     * @param request registration request
     * @return user entity
     */
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userCode", ignore = true)
    @Mapping(target = "passwordHash", ignore = true)
    @Mapping(target = "role", ignore = true)
    @Mapping(target = "accountStatus", ignore = true)
    @Mapping(target = "emailVerifiedAt", ignore = true)
    @Mapping(target = "phoneVerifiedAt", ignore = true)
    @Mapping(target = "passwordChangedAt", ignore = true)
    @Mapping(target = "lastLoginAt", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    @Mapping(target = "createdBy", ignore = true)
    @Mapping(target = "updatedBy", ignore = true)
    @Mapping(target = "deletedAt", ignore = true)
    User toEntity(RegisterUserRequest request);

    /**
     * Converts a User entity into a response DTO.
     *
     * @param user user entity
     * @return user response
     */
    @Mapping(
            target = "fullName",
            expression = "java(user.getFirstName() + \" \" + user.getLastName())"
    )
    @Mapping(
            target = "emailVerified",
            expression = "java(user.getEmailVerifiedAt() != null)"
    )
    @Mapping(
            target = "phoneVerified",
            expression = "java(user.getPhoneVerifiedAt() != null)"
    )
    UserResponse toResponse(User user);

}