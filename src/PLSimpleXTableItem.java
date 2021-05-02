import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

public class PLSimpleXTableItem {
    private BigDecimal zValue;
    private List<BigDecimal> desicionVariableValues;
    private List<BigDecimal> slackVariables;
    private BigDecimal solutionValue;

    private PLSimpleXTableItem(PLRestriction restriction) {
        this.zValue = new BigDecimal("0");
        this.desicionVariableValues = restriction.getVariableValues();
        this.slackVariables = this.getSlackVariablesForRestriction(restriction);
        this.solutionValue = restriction.getResourceLimit();
    }

    private PLSimpleXTableItem(PLFuncionObjetivo funcionObjetivo) {
        this.zValue = new BigDecimal("0");
        this.desicionVariableValues = funcionObjetivo.getVariableValues();
        this.slackVariables = this.getSlackVariablesForFuncionObjetivo(funcionObjetivo);
        this.solutionValue = new BigDecimal("-1");
    }

    public static PLSimpleXTableItem fromRestriction(PLRestriction restriction) {
        return new PLSimpleXTableItem(restriction);
    }

    public static PLSimpleXTableItem fromFuncionObjetivo(PLFuncionObjetivo funcionObjetivo) {
        return new PLSimpleXTableItem(funcionObjetivo);
    }

    private List<BigDecimal> getSlackVariablesForRestriction(PLRestriction restriction) {
        List<BigDecimal> slackVariables = new ArrayList<>();

        for(int i = 0; i < restriction.getVariableValues().size(); i++) {
            if (restriction.getIndex() == i) {
                slackVariables.add(new BigDecimal("1"));
            } else {
                slackVariables.add(new BigDecimal("0"));
            }
        }

        return slackVariables;
    }

    private List<BigDecimal> getSlackVariablesForFuncionObjetivo(PLFuncionObjetivo funcionObjetivo) {
        List<BigDecimal> slackVariables = new ArrayList<>();
        for(int i = 0; i < funcionObjetivo.getVariableValues().size(); i++) {
            slackVariables.add(new BigDecimal("0"));
        }
        return slackVariables;
    }

    public BigDecimal getzValue() {
        return zValue;
    }

    public List<BigDecimal> getDesicionVariableValues() {
        return desicionVariableValues;
    }

    public List<BigDecimal> getSlackVariables() {
        return slackVariables;
    }

    public BigDecimal getSolutionValue() {
        return solutionValue;
    }
}
