package softserve.academy.models;

public enum Role {


    ADMIN("Administrator"),
    TEACHER("Teacher"),
    COORDINATOR("Coordinator");

    private String value;

    private Role(String  value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}




