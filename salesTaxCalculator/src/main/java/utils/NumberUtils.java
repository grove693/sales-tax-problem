package utils;

public class NumberUtils {

    public static final double ROUNDUP_FACTOR = 0.05d;

    public static double roundUpDouble(double d) {
        return Math.ceil(d / ROUNDUP_FACTOR) * ROUNDUP_FACTOR;
    }
}
