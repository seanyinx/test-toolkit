package io.seanyinx.github.unit.scaffolding;

import static org.junit.Assert.fail;

public class AssertUtils {
    private AssertUtils() {
    }

    public static void expectFailing(Class<?> exceptionClass) {
        fail(exceptionClass + " expected, but none thrown");
    }
}
