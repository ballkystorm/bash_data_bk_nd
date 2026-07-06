package com.asti.bashdata.common.util;

import com.asti.bashdata.common.codes.BusinessError;
import com.asti.bashdata.common.exception.BusinessException;
import org.springframework.stereotype.Component;

/**
 * Utility component for normalizing Nigerian phone numbers.
 */
@Component
public final class PhoneNumberNormalizer {

    private static final String COUNTRY_CODE = "+234";

    /**
     * Converts a Nigerian local phone number into
     * international format.
     *
     * Examples:
     * 08031234567 -> +2348031234567
     * 09051234567 -> +2349051234567
     *
     * If the number already starts with +234,
     * it is returned unchanged.
     *
     * @param phoneNumber phone number
     * @return normalized phone number
     */
    public String normalize(String phoneNumber) {

        if (phoneNumber == null) {
            return null;
        }

        phoneNumber = phoneNumber
                .replaceAll("[\\s.-]", "")
                .trim();

        if (phoneNumber.startsWith(COUNTRY_CODE)) {
            return phoneNumber;
        }

        if (phoneNumber.startsWith("0")) {
            return COUNTRY_CODE + phoneNumber.substring(1);
        }

        throw new BusinessException(
                BusinessError.INVALID_PHONE_NUMBER
        );
    }

}