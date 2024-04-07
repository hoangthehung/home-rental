package com.hunghoang.homerental.util.logging;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MaskingUtil {
    private static final String MASKING_STR = "*";
    private static final String BIG_MASKING_STR = "*---*";
    private static int MAX_LENGTH = 5;
    private static int MIN_LENGTH = 4;

    public static String mask(String input, String maskString) {
        if (StringUtils.isBlank(input)){
            return input;
        }
        int length = input.length();
        if (length > 20){
            return StringUtils.overlay(input, BIG_MASKING_STR, MAX_LENGTH, length - MAX_LENGTH);
        } else if (length > MIN_LENGTH){
            int reqLength = length - MIN_LENGTH;
            return StringUtils.overlay(input, maskString == null ? MASKING_STR.repeat(reqLength) : maskString.repeat(reqLength), 0, reqLength);
        }
        return input;
    }

    public static String mask(String input) {
        return mask(input, MASKING_STR);
    }

    /**
     * Mask string which is having very large length. First and last 3 characters will not be masked.
     * @param input input parameter
     * @return masked string
     */
    public static String maskBigString(String input) {
        return StringUtils.isBlank(input) ? input : StringUtils.overlay(input, BIG_MASKING_STR, MAX_LENGTH, input.length() - MAX_LENGTH);
    }

    public static String maskMsisdn(String input) {
       return mask(input, MASKING_STR);
    }

}
