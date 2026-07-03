package com.asti.bashdata.common.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class AuditorAwareImpl implements AuditorAware<UUID> {

    @Override
    public Optional<UUID> getCurrentAuditor() {

        /*
         * JWT authentication is not implemented yet.
         *
         * Later we'll obtain the logged-in user's UUID
         * from Spring Security's SecurityContextHolder.
         */

        return Optional.empty();
    }

}