package utils;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public final class NumberFormatter {

    private static final DecimalFormat DECIMAL_FORMATTER = new DecimalFormat("#.##");

    static {
        DECIMAL_FORMATTER.setRoundingMode(RoundingMode.CEILING);
    }

    public static String convertToString(double number) {
        return DECIMAL_FORMATTER.format(number);
    }
}
