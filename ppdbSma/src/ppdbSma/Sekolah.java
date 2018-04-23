package ppdbSma;
import java.util.*;

public class Sekolah {
    private int kodeSekolah;
    private String namaSekolah;
    private int kuota;
//    private int ukuran;
    public NodeSiswaSekolah head;
    public NodeSiswaSekolah tail;
    public List<NodeSiswaSekolah> listTerima;
    Sekolah(int kodeSekolah, String namaSekolah, int kuota){
        listTerima = new ArrayList<>();
        setKodeSekolah(kodeSekolah);
        setNamaSekolah(namaSekolah);
        setKuota(kuota);
        head = null;
        tail = null;
//        ukuran = 0;
    }

    /**
     * @return the kodeJurusan
     */
    public int getKodeSekolah() {
        return kodeSekolah;
    }

    /**
     * @param kodeSekolah the kodeJurusan to set
     */
    public void setKodeSekolah(int kodeSekolah) {
        this.kodeSekolah = kodeSekolah;
    }

    /**
     * @return the namaJurusan
     */
    public String getNamaSekolah() {
        return namaSekolah;
    }

    /**
     * @param namaSekolah the namaJurusan to set
     */
    public void setNamaSekolah(String namaSekolah) {
        this.namaSekolah = namaSekolah;
    }

    /**
     * @return the kuota
     */
    public int getKuota() {
        return kuota;
    }

    /**
     * @param kuota the kuota to set
     */
    public void setKuota(int kuota) {
        this.kuota = kuota;
    }
    public void hapus(NodeSiswaSekolah nodeSiswaSekolah){
        NodeSiswaSekolah kiri = nodeSiswaSekolah.before;
        NodeSiswaSekolah kanan = nodeSiswaSekolah.next;
        if(kiri != null && kanan != null) {
            kiri.next = kanan;
            kanan.before = kiri;
        }
        else if(kiri == null && kanan != null) {
            kanan.before = null;
            head = kanan;            
        }
        else if(kiri != null && kanan == null) {
            tail = tail.before;
            tail.next = null;
        }
        else{
            head = null;
            tail = null;
        }
        List<NodeSiswaSekolah> listSiswaSekolahHapus = nodeSiswaSekolah.getSiswa().getListPilihanSekolah();
        listSiswaSekolahHapus.remove(nodeSiswaSekolah);
//        setUkuran(getUkuran() - 1);
    }
    public NodeSiswaSekolah getFirst(){
        return head;
    }
    public void tambahBelakang(NodeSiswaSekolah nodeSiswaSekolah) {
        if(head == null){
            head = nodeSiswaSekolah;
            tail = nodeSiswaSekolah;
        } else {
            nodeSiswaSekolah.before = tail;
            tail.next = nodeSiswaSekolah;
            tail = nodeSiswaSekolah;
        }
//        setUkuran(getUkuran() + 1);
    }
    /**
     * @return the ukuran
     */
//    public int getUkuran() {
//        return ukuran;
//    }

    /**
     * @param ukuran the ukuran to set
     */
//    public void setUkuran(int ukuran) {
//        this.ukuran = ukuran;
//    }
}
