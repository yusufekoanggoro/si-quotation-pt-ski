/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.models;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author athal
 */
public class TransactionTableModel  extends AbstractTableModel {
     List<TransactionModel> trx;
    
    public TransactionTableModel(List<TransactionModel> trx) {
        this.trx = trx;
    }

    @Override
    public int getRowCount() {
        return trx.size();
    }
    
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "No. Ref";
            case 2:
                return "Nama Pengirim";
            case 3:
                return "Pelanggan";
            case 4:
                return "Item";
            case 5:
                return "Qty";
            case 6:
                return "Total";
            case 7:
                return "Status";
            case 8:
                return "Date";
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
                return trx.get(row).getId();
            case 1:
                return trx.get(row).getQuoteNumber();
            case 2:
                return trx.get(row).getSenderName();
            case 3:
                return trx.get(row).getCustomer();
            case 4:
                return trx.get(row).getItem();
            case 5:
                return trx.get(row).getQty();
            case 6:
                return trx.get(row).getTotal();
            case 7:
                return trx.get(row).getStatus();
            case 8:
                return trx.get(row).getCustomDate(); 
            default:
                return null;
        }
    }
}
