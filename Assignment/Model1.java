package Comp.Assignment;

import java.util.ArrayList;

public class Model1 {
    int id;
    String nama;
    ArrayList<Integer> alNilai = new ArrayList<>();
    public Model1(int id, String nama, ArrayList<Integer> alNilai){
        this.id = id;
        this.nama = nama;
        this.alNilai =alNilai;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public ArrayList<Integer> getAlNilai() {
        return alNilai;
    }

    public void setAlNilai(ArrayList<Integer> alNilai) {
        this.alNilai = alNilai;
    }
}
