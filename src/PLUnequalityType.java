public enum PLUnequalityType {
    LESS_OR_EQUAL_THAN(1),
    GREATER_OR_EQUAL_THAN(2),
    EQUAL(3);

    public final int value;

    PLUnequalityType(int value) {
        this.value = value;
    }

    public static PLUnequalityType fromValue(int value) {
        for (PLUnequalityType unequalityType : PLUnequalityType.values()) {
            if (unequalityType.value == value) {
                return unequalityType;
            }
        }

        return null;
    }
}
