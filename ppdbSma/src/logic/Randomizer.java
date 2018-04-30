/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.sql.Connection;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

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
        int ar[] = {0, 1, 2, 3, 4, 5, 6, 7, 8,9, 10, 11,12,13};
        int nisn;
        String nama;
        double nilai;
        String password;
        Random rand = new Random();
        for(int i = 0; i < 10000; i++) {
            shuffleArray(ar);
            nisn = i;
            nama = Integer.toString(nisn);
            nilai = 15 + rand.nextInt(25) + rand.nextDouble();
            nilai = Math.round(nilai * 100d) / 100d;
            password = Integer.toString(nisn);
            try {
                String sql = "insert into siswa values(" + nisn + ", " + 
                        nama + ", " + nilai + ", " + "-1, " + password + ")";
//                System.out.println(sql);
                java.sql.Connection conn = (Connection)SqlConnection.SqlConnectionDB();
                java.sql.Statement stm = conn.createStatement();
                int executeUpdate = stm.executeUpdate(sql);
            } catch(Exception e) {
                System.out.println(e.toString());
            }
            for(int k = 0; k < 3; k++){
                try {
                String sql = "insert into siswaSekolah values(" + nisn + ", " + 
                        ar[k] + ", " + (k + 1) + ")";
//                System.out.println(sql);
                java.sql.Connection conn = (Connection)SqlConnection.SqlConnectionDB();
                java.sql.Statement stm = conn.createStatement();
                int executeUpdate = stm.executeUpdate(sql);
                } catch(Exception e) {
                    System.out.println(e.toString());
                }
            }
        }
    }
    public static void shuffleArray(int[] ar) {
            // If running on Java 6 or older, use `new Random()` on RHS here
            Random rnd = ThreadLocalRandom.current();
            for (int i = ar.length - 1; i > 0; i--) {
                int index = rnd.nextInt(i + 1);
                // Simple swap
                int a = ar[index];
                ar[index] = ar[i];
                ar[i] = a;
            }
    }
    public static void main(String[] args){
        SqlConnection.setLogin("jdbc:mysql://localhost:9993/ppdbSmanDepok", "herbiejago", "sudo");
        generateSiswa();
    }
}
    
