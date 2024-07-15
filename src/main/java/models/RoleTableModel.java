package main.java.models;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class RoleTableModel extends AbstractTableModel {
    List<RoleModel> roles;
    
    public RoleTableModel(List<RoleModel> roles) {
        this.roles = roles;
    }

    @Override
    public int getRowCount() {
        return roles.size();
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Nama";
            case 2:
                return "Periode";
            default:
                return null;
        }
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return roles.get(row).getId();
            case 1:
                return roles.get(row).getName();
            case 2:
                return roles.get(row).getPeriode();
            default:
                return null;
        }
    }
}
