package com.asti.bashdata.common.util;

import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * Utility component for normalizing email addresses.
 */
@Component
public final class EmailNormalizer {

    /**
     * Normalizes an email address by trimming whitespace
     * and converting it to lowercase.
     *
     * @param email email address
     * @return normalized email address
     */
    public String normalize(String email) {

        if (email == null) {
            return null;
        }

        return email
                .replaceAll("\\s+", "")
                .toLowerCase(Locale.ROOT);
    }

}