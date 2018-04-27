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
public class LFSiswa {
    public static String apakahLulus(String nisn){
        String kodeSekolahTerima = "-1";
        try {
            String sql = "select kodeSekolahTerima FROM siswa where nisn=" + nisn;
            java.sql.Connection conn = (Connection)SqlConnection.SqlConnectionDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while(res.next()) {
                kodeSekolahTerima = res.getString(1);
            }
        } catch(Exception e) {

        }
        if("-1".equals(kodeSekolahTerima)){
            return "-1";
        }
        try {
            String sql = "select namaSekolah FROM sekolah where kodeSekolah=" + kodeSekolahTerima;
            java.sql.Connection conn = (Connection)SqlConnection.SqlConnectionDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while(res.next()) {
                kodeSekolahTerima = res.getString(1);
            }
        } catch(Exception e) {

        }
        return kodeSekolahTerima;
    }
}
