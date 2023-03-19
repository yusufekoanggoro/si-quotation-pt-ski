package initialproject.models;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class UserTableModel extends AbstractTableModel {
    List<User> users;
    
    public UserTableModel(List<User> users) {
        this.users = users;
    }

    @Override
    public int getRowCount() {
        return users.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return users.get(row).getName();
            case 1:
                return users.get(row).getAge();
            default:
                return null;
        }
    }
}
