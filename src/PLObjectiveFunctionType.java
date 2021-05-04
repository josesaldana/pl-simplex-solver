public enum PLObjectiveFunctionType {
    MAXIMIZE(1), MINIMMIZE(2);

    final int type;

    PLObjectiveFunctionType(int type) {
        this.type = type;
    }

    public static PLObjectiveFunctionType fromType(int type) {
        for (PLObjectiveFunctionType objectiveFunctionType : PLObjectiveFunctionType.values()) {
            if (objectiveFunctionType.type == type) {
                return objectiveFunctionType;
            }
        }

        return null;
    }
}
