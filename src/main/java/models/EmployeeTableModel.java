package main.java.models;

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
                return "Nama";
            case 2:
                return "Jabatan";
            case 3:
                return "Jenis Kelamin";
            case 4:
                return "Tmp Lahir";
            case 5:
                return "Tgl Lahir";
            case 6:
                return "No. Telp";
            case 7:
                return "Alamat";
            case 8:
                return "Bergabung";
            default:
                return null;
        }
    }

    @Override
    public int getColumnCount() {
        return 9;
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return employes.get(row).getId();
            case 1:
                return employes.get(row).getName();
            case 2:
                return employes.get(row).getRoleName();
            case 3:
                return employes.get(row).getGender();
            case 4:
                return employes.get(row).getPlaceOfBirth();
            case 5:
                return employes.get(row).getDateOfBirth();
            case 6:
                return employes.get(row).getPhoneNumber();
            case 7:
                return employes.get(row).getAddress();
            case 8:
                return employes.get(row).getJoinDate();
            default:
                return null;
        }
    }
}
