import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PLFuncionObjetivo {
    private List<BigDecimal> variableValues;

    public PLFuncionObjetivo() {
        this.variableValues = new ArrayList<BigDecimal>();
    }

    public void addVariableValue(BigDecimal variableValue) {
        this.variableValues.add(variableValue);
    }

    public List<BigDecimal> getVariableValues() {
        return variableValues;
    }
}
