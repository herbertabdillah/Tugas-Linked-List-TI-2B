/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppdbSma;

import java.sql.Connection;

/**
 *
 * @author Lenovo
 */
public class Admin {
    
    public static void gantiKuota(int kodeSma, int kuotaBaru){
        try {
            String sql = "update sekolah set kuota=" + kuotaBaru + " where kodeSekolah =" + kodeSma;
            System.out.println(sql);
            java.sql.Connection conn = (Connection)SqlConnection.SqlConnectionDB();
            java.sql.Statement stm = conn.createStatement();
            int executeUpdate = stm.executeUpdate(sql);
        } catch(Exception e) {
            System.out.println(e.toString());
        }
    }
    
}
