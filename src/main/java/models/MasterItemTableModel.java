package main.java.models; 

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class MasterItemTableModel extends AbstractTableModel {
     List<ItemModel> items;
    
    public MasterItemTableModel(List<ItemModel> items) {
        this.items = items;
    }

    @Override
    public int getRowCount() {
        return items.size();
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Name";
            case 2:
                return "Price";
            default:
                return null;
        }
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return items.get(row).getId();
            case 1:
                return items.get(row).getName();
            case 2:
                return items.get(row).getPrice(); 
            default:
                return null;
        }
    }
}
