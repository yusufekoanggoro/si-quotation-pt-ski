package main.java.models;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class CustomerTableModel extends AbstractTableModel {
    List<CustomerModel> customers;
    
    public CustomerTableModel(List<CustomerModel> customers) {
        this.customers = customers;
    }

    @Override
    public int getRowCount() {
        return customers.size();
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Nama";
            case 2:
                return "Nama Segment";
            case 3:
                return "Nama PIC";
            case 4:
                return "No. Telp";
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
                return customers.get(row).getId();
            case 1:
                return customers.get(row).getName();
            case 2:
                return customers.get(row).getSegmentName();
            case 3:
                return customers.get(row).getPersonInCharge();
            case 4:
                return customers.get(row).getPhoneNumber();
            default:
                return null;
        }
    }
}
