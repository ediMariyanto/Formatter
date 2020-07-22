package com.edimariyanto.formatter;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class ThousandSeparator {
    public static String GET_FORMAT_THOUSAND_SEPARATOR(Double value) {
        if (value == null || value.isNaN())
            return "0.0";
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat formatter = new DecimalFormat("#,###,###.##", symbols);
        return formatter.format(value);
    }

    public static String GET_FORMAT_THOUSAND_SEPARATOR(Integer value) {
        if (value == null)
            return "0";
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat formatter = new DecimalFormat("#,###,###.##", symbols);
        return formatter.format(value);
    }

    public static String GET_FORMAT_THOUSAND_SEPARATOR(Float value) {
        if (value == null)
            return "0";
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat formatter = new DecimalFormat("#,###,###.##", symbols);
        return formatter.format(value);
    }

    public static String GET_FORMAT_THOUSAND_SEPARATOR(Long value) {
        if (value == null)
            return "0";
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
        DecimalFormat formatter = new DecimalFormat("#,###,###.##", symbols);
        return formatter.format(value);
    }

    public static String GET_UNFORMAT_THOUSAND_SEPARATOR(String value) {
        String val = value;
        if (value != null) {
            if (value.equals("") || value.equals("-")) {
                val = "0";
            } else {
                val = val.replaceAll(",", "");
            }
        }
        return val;
    }

}
