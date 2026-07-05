package com.asti.bashdata.user.generator;

import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * Generates unique user codes.
 */
@Component
public class UserCodeGenerator {

    private static final String PREFIX = "USR-";

    /**
     * Generates a unique user code.
     *
     * @return generated user code
     */
    public String generate() {

        return PREFIX +
                UUID.randomUUID()
                        .toString()
                        .replace("-", "")
                        .substring(0, 8)
                        .toUpperCase();
    }

}