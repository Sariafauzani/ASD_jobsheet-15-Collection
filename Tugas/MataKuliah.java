package Tugas;

public class MataKuliah {
    String kode;
    String nmMk;
    int sks;
    
    public MataKuliah(String kode, String nama, int sks) {
        this.kode = kode;
        this.nmMk = nama;
        this.sks = sks;
    }
    
    public String toString() {
        return String.format("%s\t%-40s%s", kode, nmMk, sks);
    } 
}