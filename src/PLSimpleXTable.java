import java.util.ArrayList;
import java.util.List;

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
            // TODO: Print
        }

        return sb.toString();
    }
}
