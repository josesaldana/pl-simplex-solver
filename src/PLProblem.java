import java.util.*;

public class PLProblem {
    private int amountOfVariables;
    private List<PLRestriction> restrictions;
    private PLFuncionObjetivo funcionObjetivo;

    public PLProblem(int amountOfVariables) {
        this.amountOfVariables = amountOfVariables;
        this.restrictions = new ArrayList<PLRestriction>(this.amountOfVariables);
    }

    public void addRestriction(PLRestriction restriction) {
        this.restrictions.add(restriction);
    }

    public int getAmountOfVariables() {
        return this.amountOfVariables;
    }

    public List<PLRestriction> getRestrictions() {
        return this.restrictions;
    }

    public PLFuncionObjetivo getFuncionObjetivo() {
        return funcionObjetivo;
    }

    public void setFuncionObjetivo(PLFuncionObjetivo funcionObjetivo) {
        this.funcionObjetivo = funcionObjetivo;
    }

    public PLSimpleXTable getSimpleXTable() {
        PLSimpleXTable table = new PLSimpleXTable();

        table.addItem(PLSimpleXTableItem.fromFuncionObjetivo(this.funcionObjetivo));

        for(PLRestriction restriction : this.restrictions) {
            table.addItem(PLSimpleXTableItem.fromRestriction(restriction));
        }

        return table;
    }
}
