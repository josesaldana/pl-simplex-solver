import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PLRestriction {
    private int index;
    private List<BigDecimal> variableValues;
    private PLUnequalityType unequalityType;
    private BigDecimal resourceLimit;

    public PLRestriction(int index, PLUnequalityType unequalityType) {
        this.index = index;
        this.unequalityType = unequalityType;
        this.variableValues = new ArrayList<BigDecimal>();
    }

    public int getIndex() {
        return index;
    }

    public List<BigDecimal> getVariableValues() {
        return this.variableValues;
    }

    public BigDecimal getResourceLimit() {
        return this.resourceLimit;
    }

    public void addVariableValue(BigDecimal variableValue) {
        this.variableValues.add(variableValue);
    }

    public void setResourceLimit(BigDecimal resourceLimit) {
        this.resourceLimit = resourceLimit;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < this.variableValues.size(); i++) {
            sb.append("X").append(i + 1).append("=").append(this.getVariableValues().get(i).doubleValue()).append("\t");
        }

        return sb.toString();
    }
}