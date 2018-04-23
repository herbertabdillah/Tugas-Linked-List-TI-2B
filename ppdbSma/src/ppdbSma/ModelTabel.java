/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppdbSma;

import java.sql.Connection;
import javax.swing.table.AbstractTableModel;
import java.util.*;
/**
 *
 * @author Lenovo
 */
public class ModelTabel extends AbstractTableModel{
    List<List<String>> arraySekolah = new ArrayList<>();
    ModelTabel(){
        imporDbSekolah();
    }
    public void imporDbSekolah(){
        try {
//            SqlConnection.setLogin("jdbc:mysql://localhost:9993/ppdbSmanDepok", "herbiejago", "sudo");
            String sql = "select * from sekolah";
            java.sql.Connection conn = (Connection)SqlConnection.SqlConnectionDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while(res.next()) {
                List<String> sekolah = new ArrayList<>();
                sekolah.add(res.getString(1));
                sekolah.add(res.getString(2));
                sekolah.add(res.getString(3));
                arraySekolah.add(sekolah);
            }
        } catch(Exception e) {

        }
    }
    @Override
    public int getRowCount() {
        return arraySekolah.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }
    public void setValueAt(String value, int row, int col) {
        fireTableCellUpdated(row, col);
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return arraySekolah.get(rowIndex).get(columnIndex);
    }
    public void updateRow(int index, String[] values) {
        for(int i = 0; i < values.length; i++) {
            setValueAt(values[i], index, i);
        }
    }
    public boolean isCellEditable(int row, int col) {
//        if(col == 2) return true;
        return false;
    }
    public void updateKuota(int kodeSekolah, int kuotaBaru){
        Admin.gantiKuota(kodeSekolah, kuotaBaru);
        arraySekolah.clear();
        imporDbSekolah();
        fireTableDataChanged();
        
    }
}
