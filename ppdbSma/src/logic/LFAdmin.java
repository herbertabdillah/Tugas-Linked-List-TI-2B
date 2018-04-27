/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.sql.Connection;

/**
 *
 * @author Lenovo
 */
public class LFAdmin {
    
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
    public static String getHasil(){
        String iseng ="";
        try {
            String sql = "SELECT sekolah.namaSekolah, siswa.nisn, siswa.nama FROM sekolahTerima INNER JOIN siswa ON siswa.nisn = sekolahTerima.nisn INNER JOIN sekolah ON sekolah.kodeSekolah = sekolahTerima.kodeSekolah ORDER BY sekolahTerima.kodeSekolah";
            java.sql.Connection conn = (Connection)SqlConnection.SqlConnectionDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while(res.next()) {
                iseng = iseng + res.getString(1) + "\t" + res.getString(2) + "\t"+ res.getString(3) + "\n";
            }
        } catch(Exception e) {

        }
        return iseng;
    }
    
}
