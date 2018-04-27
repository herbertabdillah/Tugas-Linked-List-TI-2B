package logic;

public class NodeSiswaSekolah{
    private int kodeSekolah;
    private Sekolah sekolah;
    private Siswa siswa;
    private int prioritas;
    public NodeSiswaSekolah next;
    public NodeSiswaSekolah before;
    
    NodeSiswaSekolah(Siswa siswa, Sekolah sekolah, int prioritas){
        setKodeSekolah(sekolah.getKodeSekolah());
        setSekolah(sekolah);
        setSiswa(siswa);
        setPrioritas(prioritas);
        siswa.getListPilihanSekolah().add(this);
        next = null;
        before = null;
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
     * @return the jurusan
     */
    public Sekolah getSekolah() {
        return sekolah;
    }

    /**
     * @param sekolah the jurusan to set
     */
    public void setSekolah(Sekolah sekolah) {
        this.sekolah = sekolah;
    }

    /**
     * @return the calonMahasiswa
     */
    public Siswa getSiswa() {
        return siswa;
    }

    /**
     * @param siswa the calonMahasiswa to set
     */
    public void setSiswa(Siswa siswa) {
        this.siswa = siswa;
    }

    /**
     * @return the prioritas
     */
    public int getPrioritas() {
        return prioritas;
    }

    /**
     * @param prioritas the prioritas to set
     */
    public void setPrioritas(int prioritas) {
        this.prioritas = prioritas;
    }
    public void hapus(){
        getSekolah().hapus(this);
    }
}
