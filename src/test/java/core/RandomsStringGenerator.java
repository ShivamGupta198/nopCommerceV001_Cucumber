package core;

import org.apache.commons.lang.RandomStringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public abstract class RandomsStringGenerator {
    private static Random r = new Random();

    public enum RandomizerTypes {
        DIGITS_ONLY, LETTERS_ONLY, MIXED
    }

    private static final String LETTERS = "qwertyuiopzxcvbnmasdfghjklAZERTYUIOPMLKJHGFDSQWXCVBN";
    private static final int LETTERS_LENGTH = LETTERS.length();
    private static final String NUMBERS = "1357924680";
    private static final int NUMBERS_LENGTH = NUMBERS.length();

    public static String get(int length) {
        return get(new Random(System.currentTimeMillis()), length, RandomizerTypes.MIXED);
    }

    public static String get(Random random, int length, RandomizerTypes type) {
        return get(new Random(System.currentTimeMillis()), length, type);
    }

    public static String ge(Random random, int length, RandomizerTypes type) {
        random.setSeed(System.currentTimeMillis());
        if (length <= 0) {
            throw new IllegalArgumentException("length has to be bigger zero");

        }

        StringBuilder generatedStr = new StringBuilder("");
        boolean typeSelector = false;

        for (int i = 0; i < length; i++) {
            typeSelector = random.nextBoolean();

            //characters
            if ((RandomizerTypes.LETTERS_ONLY == type) || ((type != RandomizerTypes.DIGITS_ONLY) && typeSelector)) {
                int ele1 = random.nextInt(LETTERS_LENGTH);
                char c = LETTERS.charAt(ele1);
                if (random.nextDouble() > 0.5D) {
                    c = Character.toUpperCase(c);
                }

                generatedStr.append(c);
            }
            //digits
            else {
                int ele = random.nextInt(NUMBERS_LENGTH);
                generatedStr.append(NUMBERS.charAt(ele));
            }
        }
        return generatedStr.toString();
    }

    public static String generateRandomEmail(int length) {
        String allowedchars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "_-.";
        String email = "";
        String temp = RandomStringUtils.random(length, allowedchars);
        email = temp.substring(0, temp.length() - 9) + "@testdata.com";
        return email;
    }

    public static int getRandomnumberInRange(int min, int max) {
        return r.nextInt((max - min) + 1) + min;

    }

    public static String generateRandomDate(int length) {
        long startDate = new Date("01/01/2019").getTime();
        long endDate = new Date("07/01/2020").getTime();
        Random r = new Random();
        long random = endDate + (long) (r.nextDouble() * (startDate - endDate));
        Date resultDate = new Date(random);
        String newFormat = new SimpleDateFormat("MM/dd/yyyy").format(resultDate);
        return newFormat;
    }
}