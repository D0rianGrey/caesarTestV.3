package softserve.academy.models;

public enum Expert {
        NOTAPPROVED ("Not approved"),
        CUSTUM ("Custom"),
    I_KOHUT("I. Kohut"),
    KARASIK("Karasik"),
    RYBAKOV("Rybakov");

        private String value;

        private Expert (String  value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

}