package com.prime.booking.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class StringUtils {
    private static final String ENTRY_FORMAT = "%%%s%%";

    public String formatEntryString(String s) {
        return String.format(ENTRY_FORMAT, s);
    }
}
