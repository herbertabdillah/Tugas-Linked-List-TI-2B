/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.sql.Connection;

/**
 *
 * @author Ade
 */
public class LFLogin {
    public static String login(String user, String pass){
        if(user.equals("admin")){
            if(pass.equals("admin")) return "admin";
        } else {
            String passDb = "";
            try {
                String sql = "select password FROM siswa where nisn=" + user;
                java.sql.Connection conn = (Connection)SqlConnection.SqlConnectionDB();
                java.sql.Statement stm = conn.createStatement();
                java.sql.ResultSet res = stm.executeQuery(sql);
                while(res.next()) {
                    passDb = res.getString(1);
                }
            } catch(Exception e) {

            }
            if(pass.equals(passDb)){
                return user;
            }
        }
        return "gagal";
    }
}
