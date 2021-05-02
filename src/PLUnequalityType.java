public enum PLUnequalityType {
    LESS_OR_EQUAL_THAN("<="),
    GREATER_OR_EQUAL_THAN(">="),
    EQUAL("=");

    public final String value;

    PLUnequalityType(String value) {
        this.value = value;
    }

    public static PLUnequalityType fromString(String text) {
        for (PLUnequalityType unequalityType : PLUnequalityType.values()) {
            if (unequalityType.value.equalsIgnoreCase(text)) {
                return unequalityType;
            }
        }

        return null;
    }
}
