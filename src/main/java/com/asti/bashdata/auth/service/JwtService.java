package com.asti.bashdata.auth.service;

import com.asti.bashdata.user.entity.User;
import io.jsonwebtoken.Claims;

import java.util.UUID;

/**
 * Service responsible for JWT operations.
 */
public interface JwtService {

    /**
     * Generates an access token.
     *
     * @param user authenticated user
     * @return JWT access token
     */
    String generateAccessToken(User user);

    /**
     * Extracts all claims from the JWT.
     *
     * @param token JWT
     * @return claims
     */
    Claims extractClaims(String token);

    /**
     * Extracts the user identifier.
     *
     * @param token JWT
     * @return user id
     */
    default UUID extractUserId(String token) {

        return UUID.fromString(
                extractClaims(token)
                        .getSubject()
        );

    }

    /**
     * Extracts the user's email.
     *
     * @param token JWT
     * @return email
     */
    default String extractEmail(String token) {

        return extractClaims(token)
                .get("email", String.class);

    }

    /**
     * Extracts the user's role.
     *
     * @param token JWT
     * @return role
     */
    default String extractRole(String token) {

        return extractClaims(token)
                .get("role", String.class);

    }

    /**
     * Determines whether the token is valid.
     *
     * @param token JWT
     * @return true if valid
     */
    boolean isTokenValid(String token);

    /**
     * Determines whether the token has expired.
     *
     * @param token JWT
     * @return true if expired
     */
    boolean isTokenExpired(String token);


    String extractUsername(String token);



}