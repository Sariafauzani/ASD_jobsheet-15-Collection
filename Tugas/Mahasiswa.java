package Tugas;

public class Mahasiswa {
    String nim;
    String nama;
    String notelp;
    
    public Mahasiswa() {
    }
    
    public Mahasiswa(String nim, String nama, String notelp){
        this.nim = nim;
        this.nama = nama;
        this.notelp = notelp;
    }
    
    public String toString(){
        return String.format("%s\t%-15s\t%s", nim, nama, notelp);
    }
}