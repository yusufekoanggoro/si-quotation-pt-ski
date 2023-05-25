package application.models;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class EmployeeTableModel extends AbstractTableModel {
    List<EmployeeModel> employes;
    
    public EmployeeTableModel(List<EmployeeModel> employes) {
        this.employes = employes;
    }

    @Override
    public int getRowCount() {
        return employes.size();
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Role Name";
            case 2:
                return "Name";
            case 3:
                return "Gender";
            default:
                return null;
        }
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return employes.get(row).getId();
            case 1:
                return employes.get(row).getRoleName();
            case 2:
                return employes.get(row).getName();
            case 3:
                return employes.get(row).getGender();
            default:
                return null;
        }
    }
}
