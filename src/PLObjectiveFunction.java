import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PLObjectiveFunction {
    private List<BigDecimal> variableValues;
    private PLObjectiveFunctionType type;

    public PLObjectiveFunction() {
        this.variableValues = new ArrayList<BigDecimal>();
    }

    public void addVariableValue(BigDecimal variableValue) {
        this.variableValues.add(variableValue);
    }

    public List<BigDecimal> getVariableValues() {
        return variableValues;
    }

    public PLObjectiveFunctionType getType() {
        return type;
    }

    public void setType(PLObjectiveFunctionType type) {
        this.type = type;
    }
}
