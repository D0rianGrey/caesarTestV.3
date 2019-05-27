

package softserve.academy.models;

import java.util.HashMap;

public enum Location {

    DNIPRO("Dnipro", "DP"),
    LVIV("Lviv", "LV"),
    CHERNIVTSY("Chernivtsy", "CH"),
    KYIV("Kyiv", "KV"),
    RIVNE("Rivne", "RV"),
    SOFIA("Sofia", "SF"),
    IVANO_FRANKIVSK("Ivano-Frankivsk", "IF");


    public static final HashMap<String, String> cityToIndicatorMap = new HashMap<>();

    static {
        for (Location location : values()) {
            cityToIndicatorMap.put(location.value, location.indicator);
        }
    }

    private String value;
    private String indicator;

    public String getValue() {
        return value;
    }

    Location(String value, String indicator) {
        this.value = value;
        this.indicator = indicator;
    }

    public static String get(String value) {
        return cityToIndicatorMap.get(value);
    }
    public String getIndicator() {
        return indicator;
    }}

