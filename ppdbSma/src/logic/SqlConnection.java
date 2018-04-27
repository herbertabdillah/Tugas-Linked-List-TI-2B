package logic;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnection { // SqlConnection ke database
    private static Connection mysqlkonek;
    private static String DB;
    private static String user;
    private static String pass;
   
    public static Connection SqlConnectionDB() throws SQLException {
        if(mysqlkonek==null){
            try {
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                mysqlkonek = (Connection) DriverManager.getConnection(getDB(), getUser(), getPass());
            } catch (Exception e) {
                
            }
        }
        return mysqlkonek;
    }
//        public static void ExecuteQuery(String sql){
//        try {
//            SqlConnection.setLogin("jdbc:mysql://localhost:9993/ppdbSmanDepok", "herbiejago", "sudo");
//       
//            java.sql.Connection conn = (Connection)SqlConnection.SqlConnectionDB();
//            java.sql.Statement stm = conn.createStatement();
//            java.sql.ResultSet res = stm.executeQuery(sql);
//            while(res.next()) {
//                res.getString(1);
//            }
//        } catch(Exception e) {
//
//        }
//    }
    public static void setLogin(String DB, String user, String pass) {
        setDB(DB);
        setUser(user);
        setPass(pass);
    }

    /**
     * @return the DB
     */
    public static String getDB() {
        return DB;
    }

    /**
     * @param aDB the DB to set
     */
    public static void setDB(String aDB) {
        DB = aDB;
    }

    /**
     * @return the user
     */
    public static String getUser() {
        return user;
    }

    /**
     * @param aUser the user to set
     */
    public static void setUser(String aUser) {
        user = aUser;
    }

    /**
     * @return the pass
     */
    public static String getPass() {
        return pass;
    }

    /**
     * @param aPass the pass to set
     */
    public static void setPass(String aPass) {
        pass = aPass;
    }
}
