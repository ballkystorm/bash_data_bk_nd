package com.asti.bashdata.user.entity;

import com.asti.bashdata.common.audit.AuditableEntity;
import com.asti.bashdata.common.constants.database.DatabaseConstraints;
import com.asti.bashdata.user.enums.AccountStatus;
import com.asti.bashdata.user.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

/**
 * Represents an application user.
 */
@Getter
@Setter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(
        name = "users",
        indexes = {
                @Index(name = "idx_user_email", columnList = "email"),
                @Index(name = "idx_user_phone", columnList = "phone_number"),
                @Index(name = "idx_user_code", columnList = "user_code")
        }
)
public class User extends AuditableEntity {

    @Column(
            name = "user_code",
            nullable = false,
            unique = true,
            length = DatabaseConstraints.USER_CODE_LENGTH
    )
    private String userCode;

    @Column(
            name = "first_name",
            nullable = false,
            length = DatabaseConstraints.NAME_LENGTH
    )
    private String firstName;

    @Column(
            name = "last_name",
            nullable = false,
            length = DatabaseConstraints.NAME_LENGTH
    )
    private String lastName;

    @Column(
            name = "email",
            nullable = false,
            unique = true,
            length = DatabaseConstraints.EMAIL_LENGTH
    )
    private String email;

    @Column(
            name = "phone_number",
            nullable = false,
            unique = true,
            length = DatabaseConstraints.PHONE_NUMBER_LENGTH
    )
    private String phoneNumber;

    @Column(
            name = "password_hash",
            nullable = false,
            length = DatabaseConstraints.PASSWORD_HASH_LENGTH
    )
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_status", nullable = false)
    private AccountStatus accountStatus;

    @Column(name = "email_verified_at")
    private LocalDateTime emailVerifiedAt;

    @Column(name = "phone_verified_at")
    private LocalDateTime phoneVerifiedAt;

    @Column(name = "password_changed_at")
    private LocalDateTime passwordChangedAt;

    @Column(name = "last_login_at")
    private LocalDateTime lastLoginAt;



}