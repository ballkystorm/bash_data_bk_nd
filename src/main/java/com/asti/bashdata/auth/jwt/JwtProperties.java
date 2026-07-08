package com.asti.bashdata.auth.jwt;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.time.Duration;

/**
 * JWT configuration properties.
 */
@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "application.security.jwt")
public class JwtProperties {

    /**
     * Secret key used to sign JWTs.
     */
    private String secretKey;

    /**
     * Token issuer.
     */
    private String issuer;

    /**
     * Access token validity period.
     */
    private Duration accessTokenExpiration;

    /**
     * Refresh token validity period.
     *
     * This will be used in Sprint 6.
     */
    private Duration refreshTokenExpiration;

}