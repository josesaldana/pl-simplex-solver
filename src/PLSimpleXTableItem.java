import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

public class PLSimpleXTableItem {
    private BigDecimal zValue;
    private List<BigDecimal> decisionVariableValues;
    private List<BigDecimal> slackVariables;
    private BigDecimal solutionValue;

    public static PLSimpleXTableItem fromRestriction(PLRestriction restriction) {
        return new PLSimpleXTableItem(restriction);
    }

    public static PLSimpleXTableItem fromObjectiveFunction(PLObjectiveFunction funcionObjetivo) {
        return new PLSimpleXTableItem(funcionObjetivo);
    }

    private PLSimpleXTableItem(PLRestriction restriction) {
        this.zValue = new BigDecimal("0");
        this.decisionVariableValues = restriction.getVariablesValue();
        this.slackVariables = this.getSlackVariablesForRestriction(restriction);
        this.solutionValue = restriction.getResourceLimit();
    }

    private PLSimpleXTableItem(PLObjectiveFunction objectiveFunction) {
        this.zValue = new BigDecimal("1");
        this.decisionVariableValues = getDecisionVariableValuesFromObjectiveFunction(objectiveFunction);
        this.slackVariables = this.getSlackVariablesForObjectiveFunction(objectiveFunction);
        this.solutionValue = new BigDecimal("0");
    }

    private List<BigDecimal> getDecisionVariableValuesFromObjectiveFunction(PLObjectiveFunction objectiveFunction) {
        List<BigDecimal> variableValues = new ArrayList<>(objectiveFunction.getVariableValues().size());

        for(BigDecimal variableValue : objectiveFunction.getVariableValues()) {
            if (objectiveFunction.getType().equals(PLObjectiveFunctionType.MAXIMIZE)) {
                variableValues.add(variableValue.negate());
            } else if (objectiveFunction.getType().equals(PLObjectiveFunctionType.MINIMMIZE)) {
                variableValues.add(variableValue.abs());
            } else {
                throw new RuntimeException("Invalid objective function type detected");
            }
        }

        return variableValues;
    }

    private List<BigDecimal> getSlackVariablesForRestriction(PLRestriction restriction) {
        List<BigDecimal> slackVariables = new ArrayList<>();

        for(int i = 0; i < restriction.getVariablesValue().size(); i++) {
            BigDecimal slackVariableValue =
                    restriction.getIndex() == i ?
                            new BigDecimal("1") :
                            new BigDecimal("0");

            if (restriction.getUnequalityType().equals(PLUnequalityType.GREATER_OR_EQUAL_THAN)) {
                slackVariables.add(slackVariableValue.negate());
            } else if (restriction.getUnequalityType().equals(PLUnequalityType.LESS_OR_EQUAL_THAN)) {
                slackVariables.add(slackVariableValue.abs());
            } else if (restriction.getUnequalityType().equals(PLUnequalityType.EQUAL)) {
                slackVariables.add(new BigDecimal("0"));
            }
        }

        return slackVariables;
    }

    private List<BigDecimal> getSlackVariablesForObjectiveFunction(PLObjectiveFunction funcionObjetivo) {
        List<BigDecimal> slackVariables = new ArrayList<>();
        for(int i = 0; i < funcionObjetivo.getVariableValues().size(); i++) {
            slackVariables.add(new BigDecimal("0"));
        }
        return slackVariables;
    }

    public BigDecimal getzValue() {
        return zValue;
    }

    public List<BigDecimal> getDecisionVariableValues() {
        return decisionVariableValues;
    }

    public List<BigDecimal> getSlackVariables() {
        return slackVariables;
    }

    public BigDecimal getSolutionValue() {
        return solutionValue;
    }
}
