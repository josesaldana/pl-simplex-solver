import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

public class PLSimpleXTable {
    public List<PLSimpleXTableItem> items;

    public PLSimpleXTable() {
        this.items = new ArrayList<>();
    }

    public void addItem(PLSimpleXTableItem item) {
        this.items.add(item);
    }

    public List<PLSimpleXTableItem> getItems() {
        return items;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < this.items.size(); i++) {
            PLSimpleXTableItem item = this.items.get(i);

            if (i == 0) {
                sb.append("Z: ");
            } else {
                sb.append("S").append(i).append(": ");
            }

            sb.append("Z=").append(item.getzValue()).append(", ");

            for(int j = 0; j < item.getDecisionVariableValues().size(); j++) {
                BigDecimal decisionVariableValue = item.getDecisionVariableValues().get(j);
                sb.append("X").append(j + 1).append("=").append(decisionVariableValue).append(", ");
            }

            for(int j = 0; j < item.getSlackVariables().size(); j++) {
                BigDecimal slackVariableValue = item.getSlackVariables().get(j);
                sb.append("S").append(j + 1).append("=").append(slackVariableValue).append(", ");

                if (j < (item.getSlackVariables().size() - 1)) {
                    sb.append(", ");
                }
            }

            sb.append("Solution=").append(item.getSolutionValue());

            sb.append("\n");
        }

        return sb.toString();
    }
}
