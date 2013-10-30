package com.ea.easo.utils;

import java.util.Random;

/**
 * A utility class for generating random numbers, strings
 */
public class RandomUtils
{
    private RandomUtils()
    {
        // prevent creation
    }

    /**
     * @return a random integer
     */
    public static int createInt()
    {
        Random random = new Random();
        return random.nextInt();
    }

    /**
     * @return a random integer less than max (exclusive).
     * @param max
     *            the maximum value, must be greater than zero
     */
    public static int createInt(int max)
    {
        Random random = new Random();
        return random.nextInt(max);
    }

    /**
     * @return a non-negative random integer including zero
     */
    public static int createPositiveInt()
    {
        int result = createInt();
        if (result < 0)
        {
            result = -1 * result;
        }
        return result;
    }

    /**
     * Creates a random integer between 0 (inclusive) and max (exclusive)
     * 
     * @param max
     *            the max bound
     * @return the random integer
     */
    public static int createPositiveInt(int max)
    {
        int result = createInt(max);

        if (result < 0)
        {
            result = -1 * result;
        }

        // once you make it positive, it may be a bigger number than max
        if (result >= max)
        {
            result = result % max;
        }

        return result;
    }

    /**
     * Creates a random integer between min (inclusive) and max (exclusive)
     * 
     * @param min
     *            the min bound
     * @param max
     *            the max bound
     * @return the random positive integer
     */
    public static int createPositiveInt(int min, int max)
    {
        return createPositiveInt(max - min) + min;
    }

    /**
     * Creates a random integer between 0 (inclusive) and max (exclusive)
     * 
     * @param max
     *            the max bound
     * @return the random integer
     */
    public static int createNonZeroPositiveInt(int max)
    {
        int result = createPositiveInt(max);
        while (result == 0)
        {
            result = createPositiveInt(max);
        }
        return result;
    }

    /**
     * @return a random long number
     */
    public static long createLong()
    {
        Random random = new Random();
        return random.nextLong();
    }

    /**
     * @return a random long less than max (exclusive).
     * @param max
     *            the maximum value, must be greater than zero
     */
    public static long createLong(long max)
    {
        if (max <= 0)
        {
            throw new IllegalArgumentException("max must be positive");
        }

        Random random = new Random();
        long result = random.nextLong();

        if (result >= max)
        {
            result = result % max;
        }

        return result;
    }

    /**
     * @return a non-negative random long including zero
     */
    public static long createPositiveLong()
    {
        long result = createLong();
        if (result < 0)
        {
            result = -1 * result;
        }
        return result;
    }

    /**
     * Creates a random long between 0 (inclusive) and max (exclusive)
     * 
     * @param max
     *            the max bound
     * @return the random integer
     */
    public static long createPositiveLong(long max)
    {
        long result = createLong(max);

        if (result < 0)
        {
            result = -1 * result;
        }

        // once you make it positive, it may be a bigger number than max
        if (result >= max)
        {
            result = result % max;
        }

        return result;
    }

    private static char createCharacter()
    {
        Random random = new Random();

        final int char_A = 'A';
        final int char_Z = 'Z';
        final int char_a = 'a';
        final int char_z = 'z';
        final int char_0 = '0';
        final int char_9 = '9';

        int ascii = random.nextInt(128);

        // its ok to loop like this since we capped the random generator
        // to 128, so we have good probability to hit the range after a
        // few iterations
        while ((ascii < char_A || ascii > char_Z)
                && (ascii < char_a || ascii > char_z)
                && (ascii < char_0 || ascii > char_9))
        {
            ascii = random.nextInt(128);
        }

        return (char) ascii;
    }

    /**
     * Creates a random string of a specified length
     * 
     * @param length
     *            the length of the string to create
     * @return the random string
     */
    public static String createString(int length)
    {
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < length; i++)
        {
            char c = createCharacter();
            result.append(c);
        }

        return result.toString();
    }

    /**
     * @return a random boolean
     */
    public static boolean createBoolean()
    {
        Random random = new Random();
        return random.nextBoolean();
    }

    /**
     * Appends a random string to a string
     * 
     * @param the
     *            string to append to
     * @param the
     *            string length
     */
    public static String appendStringTo(String startString, int length)
    {
        StringBuffer result = new StringBuffer(startString);
        String randomString = createString(length);
        result.append(randomString);
        return result.toString();
    }

    public static String createId() {
        int len = createPositiveInt(50, 201);
        return createString(len);
    }

}
