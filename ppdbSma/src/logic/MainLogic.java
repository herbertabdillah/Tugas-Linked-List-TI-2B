package logic;

import java.util.*;

public class MainLogic {
    private static List<Sekolah> listSemuaSekolah;
    public static void proses(){
        ProsesSeleksi prosesSeleksi = new ProsesSeleksi();

        prosesSeleksi.seleksi();
        prosesSeleksi.tampilkan();
        listSemuaSekolah = prosesSeleksi.getListSekolah();
        prosesSeleksi.exporHasilKeDb();
    }
    public static String getProsesOutput(){
        String output = "";
        for(int i = 0; i < listSemuaSekolah.size(); i++) {
            Sekolah sekolah = listSemuaSekolah.get(i);
            output = output + sekolah.getNamaSekolah() + 
                    "\nNISN\tNama\n";
            for(int k = 0; k < sekolah.listTerima.size(); k++) {
                NodeSiswaSekolah nodeSiswaSekolah = sekolah.listTerima.get(k);
                output = output + 
                        nodeSiswaSekolah.getSiswa().getNisn() + "\t" +
                        nodeSiswaSekolah.getSiswa().getNama() + "\n";
            }
            output = output + "____________________________\n";
        }
        return output;
    }
}
