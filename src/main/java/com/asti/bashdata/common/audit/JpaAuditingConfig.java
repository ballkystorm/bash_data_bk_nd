package com.asti.bashdata.common.audit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;
import java.util.UUID;

/**
 * Enables JPA auditing for the application.
 */
@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JpaAuditingConfig {

    /**
     * Provides the current authenticated user's identifier.
     *
     * For now, no authenticated user exists,
     * so an empty Optional is returned.
     *
     * This will be pdated after JWT authentication
     * is implemented.
     *
     * @return current auditor
     */
    @Bean
    public AuditorAware<UUID> auditorProvider() {

        return Optional::empty;

    }

}