package ppdbSma;

import java.sql.Connection;
import java.util.*;

public class ProsesSeleksi {
    private List<Sekolah> listSemuaSekolah;
    private List<Siswa> listSemuaSiswa;
    public HashMap<Integer, Siswa> mapSiswa;
    ProsesSeleksi(){
        listSemuaSekolah = new ArrayList<>();
        listSemuaSiswa = new ArrayList<>();
        mapSiswa = new HashMap<>();
        imporDb();
    }
    //Method impor data database mysql
    public void imporDb(){
        imporDbSekolah();
        imporDbSiswa();
        imporDbSiswaSekolah();
    }
    public void imporDbSekolah(){
        try {
            String sql = "select * from sekolah";
            java.sql.Connection conn = (Connection)SqlConnection.SqlConnectionDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while(res.next()) {
                masukanSekolah(res.getInt(1), res.getString(2), res.getInt(3));
            }
        } catch(Exception e) {

        }
    }
    public void imporDbSiswa(){
        try {
            String sql = "select nisn, nama, nilai from siswa";
            java.sql.Connection conn = (Connection)SqlConnection.SqlConnectionDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while(res.next()) {
                masukanSiswa(res.getInt(1), res.getString(2), res.getDouble(3));
            }
        } catch(Exception e) {

        }
    }
    public void imporDbSiswaSekolah(){
        try {
            String sql = "select * from siswaSekolah";
            java.sql.Connection conn = (Connection)SqlConnection.SqlConnectionDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while(res.next()) {
                masukanNodeSiswaSekolah(res.getInt(1), res.getInt(2), res.getInt(3));
            }
        } catch(Exception e) {
                
        }
    }
    //Method buat seleksi
    public void masukanSekolah(int kodeSekolah, String namaSekolah, int kuota){
        Sekolah sekolahBaru = new Sekolah(kodeSekolah, namaSekolah, kuota);
        listSemuaSekolah.add(sekolahBaru);
    }
    public void masukanSiswa(int nisn, String nama, double nilai){
        Siswa siswaBaru =  new Siswa(nisn, nama, nilai);
        listSemuaSiswa.add(siswaBaru);
        mapSiswa.put(nisn, siswaBaru);
    }
    public void masukanNodeSiswaSekolah(int nisn, int kodeSekolah, int prioritas){
        NodeSiswaSekolah nodeBaru = new NodeSiswaSekolah(mapSiswa.get(nisn), listSemuaSekolah.get(kodeSekolah), prioritas);
    }
    public void kurangiPrioritas(NodeSiswaSekolah siswaSekolah, Sekolah sekolah){
        List<NodeSiswaSekolah> listSiswaSekolah = siswaSekolah.getSiswa().getListPilihanSekolah();
        for(int k = 0; k < listSiswaSekolah.size(); k++){
            NodeSiswaSekolah nodeYangAkanDikurangi = listSiswaSekolah.get(k);
            if(nodeYangAkanDikurangi.getPrioritas() > siswaSekolah.getPrioritas()) {
                nodeYangAkanDikurangi.setPrioritas(nodeYangAkanDikurangi.getPrioritas() - 1);
            }
        }
    }
    //Method seleksi
    public void seleksi(){
        //Tahap 1
        Collections.sort(listSemuaSiswa);
        for(int i = 0; i < listSemuaSiswa.size(); i++) {
            Siswa siswa = listSemuaSiswa.get(i);
            for(int k = 0; k < siswa.getListPilihanSekolah().size(); k++) {
                NodeSiswaSekolah nodeAkanDimasukanKeSekolah = siswa.getListPilihanSekolah().get(k);
                Sekolah sekolahYangAkanDimasukan = listSemuaSekolah.get(nodeAkanDimasukanKeSekolah.getKodeSekolah());
                sekolahYangAkanDimasukan.tambahBelakang(nodeAkanDimasukanKeSekolah);                    
            }
        }
        //Tahap 2
        while(true){
            Boolean apakahSelesai = true;
            for(int i = 0; i < listSemuaSekolah.size(); i++){
                Sekolah sekolah = listSemuaSekolah.get(i);
                NodeSiswaSekolah nodeSiswaSekolah = sekolah.head;
                //Jika sekolah tersebut sudah penuh kuotanya atau tidak ada yang daftar di sekolah tersebut.
                if(nodeSiswaSekolah == null){
                    continue;
                }
                else if(nodeSiswaSekolah.getPrioritas() == 1){
                    //Jika kuota sekolah tersebut belum penuh
                    if(sekolah.listTerima.size() < sekolah.getKuota()){
                        //Menambah ke daftar yang sudah diterima
                        sekolah.listTerima.add(nodeSiswaSekolah);
                        //Menghapus semua node siswa yang sudah keteria
                        List<NodeSiswaSekolah> listNodeSiswaSekolah = nodeSiswaSekolah.getSiswa().getListPilihanSekolah();
                        while(listNodeSiswaSekolah.isEmpty() == false) {
                            listNodeSiswaSekolah.get(0).hapus();
                        }
                        //Jika kuota sekolah menjadi penuh
                        if(sekolah.listTerima.size() == sekolah.getKuota()){
                           nodeSiswaSekolah = nodeSiswaSekolah.next;
                           while(sekolah.head != null && nodeSiswaSekolah != null) {
                               kurangiPrioritas(nodeSiswaSekolah, sekolah);
                               nodeSiswaSekolah.hapus();
                               nodeSiswaSekolah.before = null;
                               nodeSiswaSekolah.next = null;
                               nodeSiswaSekolah = sekolah.head;
                           }
                        }
                    }
                } else{
                    continue;
                }
                apakahSelesai = false;
            }
            if(apakahSelesai) {
                break;
            }
        }
    }
    public Siswa getSiswa(int index){
        return listSemuaSiswa.get(index);
    }
    public Sekolah getSekolah(int index){
        return listSemuaSekolah.get(index);
    }
    public void tampilkan(){
        for(int i = 0; i < listSemuaSekolah.size(); i++) {
            Sekolah sekolah = listSemuaSekolah.get(i);
            System.out.println(sekolah.getNamaSekolah());
            for(int k = 0; k < sekolah.listTerima.size(); k++) {
                NodeSiswaSekolah nodeCmJurusan = sekolah.listTerima.get(k);
                System.out.println(nodeCmJurusan.getSiswa().getNama());
            }
            System.out.println("___________");
            System.out.println("___________");
        }
    }
    public void exporHasilKeDb(){
         for(int i =0; i < listSemuaSekolah.size(); i++){
            Sekolah sekolah = listSemuaSekolah.get(i);
            for(int k = 0; k < sekolah.listTerima.size(); k++) {
                NodeSiswaSekolah siswaSekolahKeterima = sekolah.listTerima.get(k);
                System.out.println(siswaSekolahKeterima.getSiswa().getNama());
                try {
                    String sql = "insert into sekolahTerima values(" +
                        sekolah.getKodeSekolah() +
                        ", " + siswaSekolahKeterima.getSiswa().getNisn() + ")";
                    System.out.println(sql);
                    java.sql.Connection conn = (Connection)SqlConnection.SqlConnectionDB();
                    java.sql.Statement stm = conn.createStatement();
                    int executeUpdate = stm.executeUpdate(sql);
                } catch(Exception e) {
                    System.out.println(e.toString());
                }
            }
            
        }
    }
    public List<Sekolah> getListSekolah(){
        return listSemuaSekolah;
    }
}
