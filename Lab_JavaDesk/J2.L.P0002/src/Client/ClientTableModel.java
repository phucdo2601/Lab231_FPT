/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import DTO.ArmorDTO;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ASUS
 */
public class ClientTableModel<E> extends AbstractTableModel{
    String [] header;
    int [] indexes;
    Vector<ArmorDTO> data;

    public ClientTableModel(String[] header, int[] indexes) {
        this.header = new String[header.length];
        for (int i = 0; i < header.length; i++) {
            this.header[i] = header[i];
        }
        this.indexes = indexes;
        for (int i = 0; i < indexes.length; i++) {
            this.indexes[i] = indexes[i];
        }
        this.data = new Vector<ArmorDTO>();
    }
    
    public Vector<ArmorDTO> getData(){
        return data;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }
    
    @Override
    public String getColumnName(int column){
        return (column >= 0 && column < header.length)? header[column]:"";
    }

    @Override
    public Object getValueAt(int row, int column) {
        if (row < 0 || row >= data.size() || column <=0 || column>=header.length) {
            return null;
        }
        ArmorDTO emp = data.get(row);
        switch(indexes[column]){
            case 0: return emp.getArmorID();
            case 1: return emp.getClassification();
            case 2: return emp.getDescription();
            case 3: return emp.get;
            case 4: return emp.isSex();
            case 5: return emp.getRoleID();
            case 6: return emp.getSalary();
        }
        return null;
    }
    
}
