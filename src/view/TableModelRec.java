/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import domain.Prevod;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lenovo
 */
public class TableModelRec extends AbstractTableModel {
    List<Prevod> listaPrevoda=new ArrayList<>();
    private final String[] kolona={"prevod"};
    
    public TableModelRec(List<Prevod> p)
    {
        this.listaPrevoda=p;
    }
    
    @Override
    public int getRowCount() {
        return listaPrevoda.size();
    }

    @Override
    public int getColumnCount() {
        return kolona.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Prevod p=listaPrevoda.get(rowIndex);
        return switch(columnIndex){
            case 0-> p.getRec();
            default -> "N/A";
        };
    }

    @Override
    public String getColumnName(int column) {
        return kolona[column];
    }    
}
