package ppdbSma;

import java.util.*;

public class MainLogic {
    private static List<Sekolah> listSemuaSekolah;
    public static void proses(){
        ProsesSeleksi prosesSeleksi = new ProsesSeleksi();

        prosesSeleksi.seleksi();
        prosesSeleksi.tampilkan();
        listSemuaSekolah = prosesSeleksi.getListSekolah();
    }
    public static String getOutput(){
        String output = "";
        for(int i = 0; i < listSemuaSekolah.size(); i++) {
            Sekolah sekolah = listSemuaSekolah.get(i);
            output = output + sekolah.getNamaSekolah() + "\n";
            for(int k = 0; k < sekolah.listTerima.size(); k++) {
                NodeSiswaSekolah nodeCmJurusan = sekolah.listTerima.get(k);
                output = output + nodeCmJurusan.getSiswa().getNama() + "\n";
            }
            output = output + "___________\n";
        }
        return output;
    }
//    public static void main(String[] args) {
//        System.out.println("TEST");
////        Randomizer.generateSma();
////        SqlConnection.setDB("jdbc:mysql://localhost:9993/ppdbSmanDepok");
////        SqlConnection.setUser("herbiejago");
////        SqlConnection.setPass("sudo");
//        ProsesSeleksi prosesSeleksi = new ProsesSeleksi();
//
//        prosesSeleksi.seleksi();
//        prosesSeleksi.tampilkan();
//          
//    }
    
}
