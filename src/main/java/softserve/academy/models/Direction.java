package softserve.academy.models;

public enum Direction {
    WEBUI("WebUI"),
    JS("JavaScript(UI)"),
    LAMP("LAMP"),
    JAVA("Java"),
    IOS("iOS"),
    MQC("MQC"),
    ATQC("ATQC"),
    ISTQB("ISTQB");


    private String value;

    private Direction(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}