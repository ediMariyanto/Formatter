package com.edimariyanto.formatter;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class CurrencyFormatter {
    private static final NavigableMap<Long, String> suffixes = new TreeMap<>();

    static {
        suffixes.put(1_000L, "K");
        suffixes.put(1_000_000L, "M");
        suffixes.put(1_000_000_000L, "B");
        suffixes.put(1_000_000_000_000L, "T");
    }

    public static String GET_FORMAT_CURRENCY_SHORT(long value) {
        //Long.MIN_VALUE == -Long.MIN_VALUE so we need an adjustment here
        if (value == Long.MIN_VALUE) return GET_FORMAT_CURRENCY_SHORT(Long.MIN_VALUE + 1);
        if (value < 0) return "-" + GET_FORMAT_CURRENCY_SHORT(-value);
        if (value < 1000) return Long.toString(value); //deal with easy case

        Map.Entry<Long, String> e = suffixes.floorEntry(value);
        Long divideBy = null;
        if (e != null) {
            divideBy = e.getKey();
        }
        String suffix = null;
        if (e != null) {
            suffix = e.getValue();
        }

        long truncated = value / (divideBy / 10); //the number part of the output times 10
        boolean hasDecimal = truncated < 100 && (truncated / 10d) != (truncated / 10);
        return hasDecimal ? (truncated / 10d) + suffix : (truncated / 10) + suffix;
    }

    public static String GET_FORMAT_CURRENCY_K_ONLY(Long value) {
        String result;
        if (value >= 1000) {
            result = ThousandSeparator.GET_FORMAT_THOUSAND_SEPARATOR(value / 1000);
        } else {
            result = ThousandSeparator.GET_FORMAT_THOUSAND_SEPARATOR(value);
        }
        return result;
    }
}
