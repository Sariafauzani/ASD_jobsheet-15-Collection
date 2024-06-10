import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListMahasiswa {
    
    List<Mahasiswa> mahasiswas = new ArrayList<>();

    public void tambah(Mahasiswa... mahasiswa){
        mahasiswas.addAll(Arrays.asList(mahasiswa));
    }

    public void hapus(int index){
        mahasiswas.remove(index);
    }

    public void update(int index, Mahasiswa mhs){
        mahasiswas.set(index, mhs);
    }

    public void tampil(){
        mahasiswas.stream().forEach(mhs -> {
            System.out.println("" + mhs.toString());
        });
    }

    int binarySearch(String nim){
    return Collections.binarySearch(mahasiswas, new Mahasiswa(nim, null, null), new Comparator<Mahasiswa>(){
        public int compare(Mahasiswa mhs1, Mahasiswa mhs2){
            return mhs1.nim.compareTo(mhs2.nim);
        }
    });
    }

    public void SortAscending() {
        Collections.sort(mahasiswas, new Comparator<Mahasiswa>() {
            @Override
            public int compare(Mahasiswa mhs1, Mahasiswa mhs2) {
                return mhs1.nim.compareTo(mhs2.nim);
            }
        });
    }

    public void SortDescending() {
        Collections.reverse(mahasiswas);
    }

    public static void main(String[] args) {
        
    ListMahasiswa lm = new ListMahasiswa();
    Mahasiswa m = new Mahasiswa("201234", "Noureen", "021xx1");
    Mahasiswa m1 = new Mahasiswa("201235", "Akhleema", "021xx2");
    Mahasiswa m2 = new Mahasiswa("201236", "Shannum", "021xx3");
    //menambah objek mahasiswa
    lm.tambah(m, m1, m2);
    //menampilkan list mahasiswa
    lm.tampil();
    //update mahasiswa
    lm.update(lm.binarySearch("201235"), new Mahasiswa("201235", "Akhleema Lela", "021xx2"));
    System.out.println("");
    lm.tampil();
}
}