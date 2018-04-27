/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ppdbSma;
import java.util.*;
/**
 *
 * @author Lenovo
 */
public class Siswa implements Comparable<Siswa>{
    private int nisn;
    private String nama;
    private double nilai;
    private List<NodeSiswaSekolah> listPilihanSekolah;
    Siswa(int nisn, String nama, double nilai){
//        setId(id);
        setNisn(nisn);
        setNama(nama);
        setNilai(nilai);
        listPilihanSekolah = new ArrayList<>();
    }

    /**
     * @return the id
     */

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the nilai
     */
    public double getNilai() {
        return nilai;
    }

    /**
     * @param nilai the nilai to set
     */
    public void setNilai(double nilai) {
        this.nilai = nilai;
    }

    /**
     * @return the listCmJurusan
     */
    public List<NodeSiswaSekolah> getListPilihanSekolah() {
        return listPilihanSekolah;
    }
//    @Override
    public int compareTo(Siswa o) {
        return (int)o.getNilai() - (int)this.getNilai();
    }

    /**
     * @return the nisn
     */
    public int getNisn() {
        return nisn;
    }

    /**
     * @param nisn the nisn to set
     */
    public void setNisn(int nisn) {
        this.nisn = nisn;
    }
    
}
