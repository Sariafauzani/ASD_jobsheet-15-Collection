package Tugas;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class NilaiMain {
    String kodeNilai;
    Mahasiswa mahasiswa;
    MataKuliah mataKuliah;
    double nilai;

    public NilaiMain(String kodeNilai, Mahasiswa mahasiswa, MataKuliah mataKuliah, double nilai) {
        this.kodeNilai = kodeNilai;
        this.mahasiswa = mahasiswa;
        this.mataKuliah = mataKuliah;
        this.nilai = nilai;
    }

    List<Mahasiswa> mhs = new ArrayList<>();
    List<MataKuliah> matkul1 = new ArrayList<>();

    public void tambahMahasiswa(Mahasiswa... mahasiswa) {
        mhs.addAll(Arrays.asList(mahasiswa));
    }

    public void tambahMatkul(MataKuliah... matkul) {
        matkul1.addAll(Arrays.asList(matkul));
    }

    public void tampilMahasiswa() {
        mhs.stream().forEach(mhs -> {
            System.out.println(mhs);
        });
    }

    public void tampilMatkul() {
        matkul1.stream().forEach(mk -> {
            System.out.println(mk);
        });
    }

    public int linearSearchMhs(String nim) {
        for (int i = 0; i < mhs.size(); i++) {
            if (nim.equals(mhs.get(i).nim)) {
                return i;
            }
        }
        return -1;
    }

    public int linearSearchMatkul(String matkul) {
        for (int i = 0; i < matkul1.size(); i++) {
            if (matkul.equals(matkul1.get(i).kode)) {
                return i;
            }
        }
        return -1;
    }

    Mahasiswa cariMahasiswa(String nim) {
        for (int i = 0; i < mhs.size(); i++) {
            if (nim.equals(mhs.get(i).nim)) {
                return mhs.get(i);
            }
        }
        return null;
    }

    MataKuliah cariMatkul(String matkul) {
        for (int i = 0; i < matkul1.size(); i++) {
            if (matkul.equals(matkul1.get(i).kode)) {
                return matkul1.get(i);
            }
        }
        return null;
    }

    public String toString(int idx1, int idx2) {
        return mhs.get(idx1).nim + "\t" + mhs.get(idx1).nama + "\t" + matkul1.get(idx2).nmMk + "\t"
                + matkul1.get(idx2).sks + "\t";
    }

    static Comparator<NilaiMain> CompNilai = (n1, n2) -> {
        if (n1.nilai < n2.nilai) {
            return -1;
        } else if (n1.nilai > n2.nilai) {
            return 1;
        } else {
            return 0;
        }
    };

    public static void main(String[] args) {
        Scanner sc26 = new Scanner(System.in);
        Scanner sd26 = new Scanner(System.in);
        Scanner sb26 = new Scanner(System.in);

        List<NilaiMain> nill = new ArrayList<>();
        NilaiMain n = new NilaiMain("", null, null, 0);

        Mahasiswa m1 = new Mahasiswa("20001", "Rafly", "021xxx");
        Mahasiswa m2 = new Mahasiswa("20002", "Melati", "021xxx");
        Mahasiswa m3 = new Mahasiswa("20003", "Wanda", "021xxx");
        Mahasiswa m4 = new Mahasiswa("20004", "Putra", "021xxx");
        Mahasiswa m5 = new Mahasiswa("20005", "Tiara", "021xxx");
        Mahasiswa m6 = new Mahasiswa("20006", "Selvina", "021xxx");

        n.tambahMahasiswa(m1, m2, m3, m4, m5, m6);

        MataKuliah mk1 = new MataKuliah("0001", "Internet of Things", 3);
        MataKuliah mk2 = new MataKuliah("0002", "Algoritma dan Struktur Data", 2);
        MataKuliah mk3 = new MataKuliah("0003", "Algoritma dan Pemrograman", 2);
        MataKuliah mk4 = new MataKuliah("0004", "Praktikum Algoritma dan Struktur Data", 3);
        MataKuliah mk5 = new MataKuliah("0005", "Algoritma dan Struktur Data", 3);

        n.tambahMatkul(mk1, mk2, mk3, mk4, mk5);

        NilaiMain n1 = null;
        String nimMhs, mkMhs;

        int Menu = 0;
        do {
            System.out.println("||===================================================||");
            System.out.println("|   SISTEM PENGOLAHAN DATA NILAI MAHASISWA SEMESTER   |");
            System.out.println("||===================================================||");
            System.out.println(" 1. Input Nilai");
            System.out.println(" 2. Tampil Nilai");
            System.out.println(" 3. Mencari Nilai Mahasiswa");
            System.out.println(" 4. Urut Data Nilai");
            System.out.println(" 5. Keluar");
            System.out.println("|-----------------------------------------------------|");
            System.out.print("Pilih    : ");
            Menu = sd26.nextInt();
            System.out.println("");

            switch (Menu) {
                case 1:
                    System.out.print("Kode Nilai\t\t\t: ");
                    String kd = sc26.nextLine();
                    System.out.print("Nilai\t\t\t\t: ");
                    double nilMhs = sb26.nextDouble();
                    System.out.println("");

                    System.out.println("                   DAFTAR MAHASISWA                 ");
                    System.out.println("====================================================");
                    System.out.println("NIM\tNama\t\tNo Telp");
                    n.tampilMahasiswa();
                    System.out.println("----------------------------------------------------");
                    System.out.print("Pilih Mahasiswa by nim\t\t: ");
                    nimMhs = sc26.nextLine();
                    Mahasiswa mahasiswas;
                    mahasiswas = n.cariMahasiswa(nimMhs);

                    System.out.println("");
                    System.out.println("                  DAFTAR MATA KULIAH                ");
                    System.out.println("====================================================");
                    System.out.println("Kode\tMata Kuliah\t\t\t\tSKS");
                    n.tampilMatkul();
                    System.out.println("---------------------------------------------------");
                    System.out.print("Pilih MK by Kode\t:");
                    mkMhs = sc26.nextLine();
                    MataKuliah mataKuliahs;
                    mataKuliahs = n.cariMatkul(mkMhs);

                    n1 = new NilaiMain(kd, mahasiswas, mataKuliahs, nilMhs);

                    nill.add(n1);
                    System.out.println("");
                    break;

                case 2:
                    System.out.println("                  DAFTAR NILAI MAHASISWA            ");
                    System.out.println("====================================================");
                    System.out.println("NIM\tNama\tMata Kuliah\t\tSKS\tNilai");
                    for (int i = 0; i < nill.size(); i++) {
                        n.linearSearchMhs(nill.get(i).mahasiswa.nim);
                        n.linearSearchMatkul(nill.get(i).mataKuliah.kode);
                        System.out.println(n.toString(n.linearSearchMhs(nill.get(i).mahasiswa.nim),
                                n.linearSearchMatkul(nill.get(i).mataKuliah.kode)) + nill.get(i).nilai);
                    }
                    System.out.println("");
                    break;

                case 3:
                    System.out.println("                  DAFTAR NILAI MAHASISWA            ");
                    System.out.println("====================================================");
                    System.out.println("NIM\tNama\tMata Kuliah\t\tSKS\tNilai");
                    int sks = 0;
                    for (int i = 0; i < nill.size(); i++) {
                        n.linearSearchMhs(nill.get(i).mahasiswa.nim);
                        n.linearSearchMatkul(nill.get(i).mataKuliah.kode);
                        System.out.println(n.toString(n.linearSearchMhs(nill.get(i).mahasiswa.nim),
                                n.linearSearchMatkul(nill.get(i).mataKuliah.kode)) + nill.get(i).nilai);
                    }
                    System.out.println("---------------------------------------------------");
                    System.out.print("Masukkan Data Mahasiswa NIM\t\t: ");
                    String input = sc26.nextLine();
                    System.out.println("");
                    for (int i = 0; i < nill.size(); i++) {
                        if (input.equalsIgnoreCase(nill.get(i).mahasiswa.nim)) {
                            sks += nill.get(i).mataKuliah.sks;
                            n.linearSearchMhs(nill.get(i).mahasiswa.nim);
                            n.linearSearchMatkul(nill.get(i).mataKuliah.kode);
                            System.out.println(n.toString(n.linearSearchMhs(nill.get(i).mahasiswa.nim),
                                    n.linearSearchMatkul(nill.get(i).mataKuliah.kode)) + nill.get(i).nilai);
                        }
                    }
                    System.out.println("---------------------------------------------------");
                    System.out.println("Total SKS " + sks + " Telah Diambil");
                    System.out.println("");
                    break;

                case 4:
                    System.out.println("                  DAFTAR MAHASISWA                  ");
                    System.out.println("====================================================");
                    System.out.println("NIM\tNama\tMata Kuliah\t\tSKS\tNilai");
                    nill.sort(CompNilai);
                    for (int i = 0; i < nill.size(); i++) {
                        n.linearSearchMhs(nill.get(i).mahasiswa.nim);
                        n.linearSearchMatkul(nill.get(i).mataKuliah.kode);
                        System.out.println(n.toString(n.linearSearchMhs(nill.get(i).mahasiswa.nim),
                                n.linearSearchMatkul(nill.get(i).mataKuliah.kode)) + nill.get(i).nilai);
                    }
                    System.out.println("");
                    break;

                case 5:
                    System.out.println("||==================================================||");
                    System.out.println("|                     Terima Kasih                   |");
                    System.out.println("||==================================================||");
                    break;
            }
        } while (Menu < 5 && Menu > 0);
    }
}
