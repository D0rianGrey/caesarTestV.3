package softserve.academy.models;

import java.util.HashMap;
import java.util.Map;

public enum EnglishLevel {

    ELEMENTARY("Elementary"),
    PRE_INTERMEDIATE_LOW("Pre-intermediate low"),
    PRE_INTERMEDIATE("Pre-intermediate"),
    PRE_INTERMEDIATE_STRONG("Pre-intermediate strong"),
    INTERMEDIATE_LOW("Intermediate low"),
    INTERMEDIATE("Intermediate"),
    INTERMEDIATE_STRONG("Intermediate strong"),
    UPPER_INTERMEDIATE_LOW("Upper-intermediate low"),
    UPPER_INTERMEDIATE("Upper-intermediate"),
    UPPER_INTERMEDIATE_STRONG("Upper-intermediate strong"),
    ADVANCED("Advanced");

    private final static Map<String, Integer> levelToNum = new HashMap<>();

    static {
        final EnglishLevel[] values = EnglishLevel.values();
        for (int i = 0; i < values.length; i++) {
            levelToNum.put(values[i].getValue(), i);
        }
    }

    private String value;

    EnglishLevel(String value) {
        this.value = value;
    }

    public static int getLevelInNum(String level) {
        return levelToNum.get(level);
    }

    public String getValue() {
        return value;
    }

}