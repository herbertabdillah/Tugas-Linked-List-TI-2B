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
public class Randomizer {
    private static String DB;
    private static String user;
    private static String pass;
    public static void generateSma(){
        String namaSma;
        for(int i =1; i < 14; i++){
            namaSma = "SMA Negeri " + (i+1) + " Depok";
            try {
                String sql = "insert into sekolah values(" + i + ", '" + namaSma + "', 400)";
                System.out.println(sql);
                java.sql.Connection conn = (Connection)SqlConnection.SqlConnectionDB();
                java.sql.Statement stm = conn.createStatement();
                int executeUpdate = stm.executeUpdate(sql);
            } catch(Exception e) {
                System.out.println(e.toString());
            }
        }
    }
    public static void generateSiswa(){
        int nisn;
        String nama;
        double nilai;
        String password;
        Random rand = new Random();
        for(int i = 0; i < 10000; i++) {
//            nisn = 9990000000 + i;
            nisn = i;
            nama = "kosong";
            nilai = rand.nextInt(40) + rand.nextDouble();
            password = Integer.toString(nisn);
        }
    }
}
