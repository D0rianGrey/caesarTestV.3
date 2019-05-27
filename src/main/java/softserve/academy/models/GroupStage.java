package softserve.academy.models;

public enum GroupStage {

    PLANNED("planned"),
    BOARDING("boarding"),
    BEFORE("before-start"),
    IN_PROGRESS("in-process"),
    OFFERING("offering"),
    FINISHED("finished");

    private String value;

    private GroupStage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}