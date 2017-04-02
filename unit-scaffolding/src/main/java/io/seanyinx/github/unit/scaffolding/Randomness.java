package io.seanyinx.github.unit.scaffolding;

import java.util.Random;

public class Randomness {
    private static final Random random = new Random(System.currentTimeMillis());

    private Randomness() {
    }

    public static String uniquify(String prefix) {
        return prefix + "_" + random.nextInt(10240);
    }

    public static long nextLong() {
        return random.nextLong();
    }

    public static boolean nextBoolean() {
        return random.nextBoolean();
    }

    public static int nextInt() {
        return random.nextInt();
    }

    public static int nextInt(int bound) {
        return random.nextInt(bound);
    }

    public static long nextId() {
        return random.nextInt(Integer.MAX_VALUE) + 1;
    }

    public static double nextDouble() {
        return random.nextDouble();
    }

    public static byte[] someBytes(int size) {
        byte[] bytes = new byte[size];
        random.nextBytes(bytes);
        return bytes;
    }
}
