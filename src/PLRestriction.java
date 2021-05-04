import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PLRestriction {
    private int index;
    private List<BigDecimal> variablesValue;
    private PLUnequalityType unequalityType;
    private BigDecimal resourceLimit;

    public PLRestriction(int index) {
        this.index = index;
        this.variablesValue = new ArrayList<BigDecimal>();
    }

    public int getIndex() {
        return index;
    }

    public List<BigDecimal> getVariablesValue() {
        return this.variablesValue;
    }

    public BigDecimal getResourceLimit() {
        return this.resourceLimit;
    }

    public PLUnequalityType getUnequalityType() {
        return unequalityType;
    }

    public void addVariableValue(BigDecimal variableValue) {
        this.variablesValue.add(variableValue);
    }

    public void setUnequalityType(PLUnequalityType unequalityType) {
        this.unequalityType = unequalityType;
    }

    public void setResourceLimit(BigDecimal resourceLimit) {
        this.resourceLimit = resourceLimit;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < this.variablesValue.size(); i++) {
            sb.append("X")
                    .append(i + 1)
                    .append("=")
                    .append(this.getVariablesValue().get(i).doubleValue())
                    .append("\t");
        }

        return sb.toString();
    }
}