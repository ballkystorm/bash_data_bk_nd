package com.asti.bashdata.auth.service.impl;

import com.asti.bashdata.auth.dto.request.LoginRequest;
import com.asti.bashdata.auth.dto.response.LoginResponse;
import com.asti.bashdata.auth.jwt.JwtProperties;
import com.asti.bashdata.auth.service.AuthService;
import com.asti.bashdata.auth.service.JwtService;
import com.asti.bashdata.user.dto.request.RegisterUserRequest;
import com.asti.bashdata.user.dto.response.UserResponse;
import com.asti.bashdata.user.entity.User;
import com.asti.bashdata.user.service.UserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class JwtServiceImpl implements JwtService {

    private final JwtProperties jwtProperties;

    /**
     * Returns the signing key.
     */
    private SecretKey getSigningKey() {

        return Keys.hmacShaKeyFor(
                jwtProperties
                        .getSecretKey()
                        .getBytes(StandardCharsets.UTF_8)
        );

    }

    @Override
    public String generateAccessToken(User user) {

        Instant now = Instant.now();

        Instant expiry = now.plus(
                jwtProperties.getAccessTokenExpiration()
        );

        return Jwts.builder()

                .subject(
                        user.getId().toString()
                )

                .issuer(
                        jwtProperties.getIssuer()
                )

                .issuedAt(
                        Date.from(now)
                )

                .expiration(
                        Date.from(expiry)
                )

                .claim(
                        "email",
                        user.getEmail()
                )

                .claim(
                        "role",
                        user.getRole().name()
                )

                .signWith(
                        getSigningKey()
                )

                .compact();

    }

    @Override
    public Claims extractClaims(String token) {

        return Jwts.parser()

                .verifyWith(
                        getSigningKey()
                )

                .build()

                .parseSignedClaims(token)

                .getPayload();

    }

    @Override
    public boolean isTokenValid(String token) {

        try {

            extractClaims(token);

            return true;

        } catch (Exception ex) {

            return false;

        }

    }

    @Override
    public boolean isTokenExpired(String token) {

        return extractClaims(token)

                .getExpiration()

                .before(new Date());

    }

    @Override
    public String extractUsername(String token) {

        return extractClaims(token)
                .getSubject();

    }


}