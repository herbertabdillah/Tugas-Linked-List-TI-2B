/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.sql.Connection;
import java.util.*;
/**
 *
 * @author Lenovo
 */
public class LFSiswa {
    public static String nisn;
    public static String nilai;
    public static String nama;
    public static String pengumuman;
    public static String namaSekolah;
    public static List<Integer> pilihan = new ArrayList<>();
    public static String apakahLulus(String aNisn){
        nisn = aNisn;
        String kodeSekolahTerima = "-1";
        try {
            String sql = "select kodeSekolahTerima FROM siswa where nisn=" + aNisn;
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
    public static void imporDb(){
        try {
            String sql = "select * FROM siswa where nisn=" + nisn;
            java.sql.Connection conn = (Connection)SqlConnection.SqlConnectionDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while(res.next()) {
                nama = res.getString(2);
                nilai = res.getString(3);
                pengumuman = res.getString(4);
            }
        } catch(Exception e) {

        }
        if(pengumuman.equals("-1")){
            namaSekolah = "maaf anda tidak diterima dimana mana";
        } else if(pengumuman.equals(-2)){
            namaSekolah = "belum pengumuman";
        } else{
            try {
                String sql = "select namaSekolah FROM sekolah where kodeSekolah=" + pengumuman;
                java.sql.Connection conn = (Connection)SqlConnection.SqlConnectionDB();
                java.sql.Statement stm = conn.createStatement();
                java.sql.ResultSet res = stm.executeQuery(sql);
                while(res.next()) {
                    namaSekolah = res.getString(1);
                }
            } catch(Exception e) {
                
            }
        }
        try {
                String sql = "select kodeSekolah from siswaSekolah where nisn=" + nisn + " order by prioritas asc";
                java.sql.Connection conn = (Connection)SqlConnection.SqlConnectionDB();
                java.sql.Statement stm = conn.createStatement();
                java.sql.ResultSet res = stm.executeQuery(sql);
                while(res.next()) {
                    pilihan.add(res.getInt(1));
                }
            } catch(Exception e) {
                
            }
    }
    public static void setPilihan(int pil1, int pil2, int pil3){
        
    }
}
