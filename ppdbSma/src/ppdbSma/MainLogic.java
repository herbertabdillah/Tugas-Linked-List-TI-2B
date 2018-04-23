package ppdbSma;

public class MainLogic {
    
    public static void main(String[] args) {
        System.out.println("TEST");
//        Randomizer.generateSma();
        SqlConnection.setDB("jdbc:mysql://localhost:9993/ppdbSmanDepok");
        SqlConnection.setUser("herbiejago");
        SqlConnection.setPass("sudo");
        ProsesSeleksi prosesSeleksi = new ProsesSeleksi();

        prosesSeleksi.seleksi();
        prosesSeleksi.tampilkan();
          
    }
    
}
