package com.asti.bashdata.user.repository;

import com.asti.bashdata.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * Repository for managing User entities.
 */
public interface UserRepository extends JpaRepository<User, UUID> {

    /**
     * Finds a user by email address.
     *
     * @param email user's email address
     * @return optional user
     */
    Optional<User> findByEmail(String email);

    /**
     * Finds a user by phone number.
     *
     * @param phoneNumber user's phone number
     * @return optional user
     */
    Optional<User> findByPhoneNumber(String phoneNumber);

    /**
     * Finds a user by user code.
     *
     * @param userCode unique user code
     * @return optional user
     */
    Optional<User> findByUserCode(String userCode);

    /**
     * Checks whether an email already exists.
     *
     * @param email email address
     * @return true if found
     */
    boolean existsByEmail(String email);

    /**
     * Checks whether a phone number already exists.
     *
     * @param phoneNumber phone number
     * @return true if found
     */
    boolean existsByPhoneNumber(String phoneNumber);

    /**
     * Checks whether a user code already exists.
     *
     * @param userCode user code
     * @return true if found
     */
    boolean existsByUserCode(String userCode);

}