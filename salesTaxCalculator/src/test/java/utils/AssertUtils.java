package utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AssertUtils {

    public static void assertEqualsDoubles(double expected, double actual) {
        assertEquals(expected, actual, 0.01d);
    }
}
