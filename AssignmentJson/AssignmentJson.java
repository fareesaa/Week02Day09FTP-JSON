package Comp.AssignmentJson;


import java.awt.image.WritableRaster;
import java.util.ArrayList;
import java.util.Scanner;

abstract class Worker{
    int id;
    String nama="";
    int tnjPulsa;
    int gapok;
    int absen;

}

class Staff extends Worker{
    int tnjMakan;
    ArrayList<String> email = new ArrayList<>();

    Staff(int id, String nama, int tnjPulsa, int gapok, int absen, int tnjMakan, ArrayList<String> email){
        this.id = id;
        this.nama = nama;
        this.tnjPulsa = tnjPulsa;
        this.gapok = gapok;
        this.absen = absen;
        this.tnjMakan = tnjMakan;
        this.email = email;

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

    public int getTnjPulsa() {
        return tnjPulsa;
    }

    public void setTnjPulsa(int tnjPulsa) {
        this.tnjPulsa = tnjPulsa;
    }

    public int getGapok() {
        return gapok;
    }

    public void setGapok(int gapok) {
        this.gapok = gapok;
    }

    public int getAbsen() {
        return absen;
    }

    public void setAbsen(int absen) {
        this.absen = absen;
    }

    public int getTnjMakan() {
        return tnjMakan;
    }

    public void setTnjMakan(int tnjMakan) {
        this.tnjMakan = tnjMakan;
    }

    public ArrayList<String> getEmail() {
        return email;
    }

    public void setEmail(ArrayList<String> email) {
        this.email = email;
    }
}
class Manager extends Worker{
    int tnjTransport;
    int TnjEntertain;
    ArrayList<Integer> telepon = new ArrayList<>();

    Manager(int id, String nama, int tnjPulsa, int gapok, int absen, int tnjTransport,int tnjEntertain, ArrayList<Integer> telepon){
        this.id = id;
        this.nama = nama;
        this.tnjPulsa = tnjPulsa;
        this.gapok = gapok;
        this.absen = absen;
        this.tnjTransport = tnjTransport;
        this.TnjEntertain = tnjEntertain;
        this.telepon = telepon;

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

    public int getTnjPulsa() {
        return tnjPulsa;
    }

    public void setTnjPulsa(int tnjPulsa) {
        this.tnjPulsa = tnjPulsa;
    }

    public int getGapok() {
        return gapok;
    }

    public void setGapok(int gapok) {
        this.gapok = gapok;
    }

    public int getAbsen() {
        return absen;
    }

    public void setAbsen(int absen) {
        this.absen = absen;
    }

    public int getTnjTransport() {
        return tnjTransport;
    }

    public void setTnjTransport(int tnjTransport) {
        this.tnjTransport = tnjTransport;
    }

    public int getTnjEntertain() {
        return TnjEntertain;
    }

    public void setTnjEntertain(int tnjEntertain) {
        TnjEntertain = tnjEntertain;
    }

    public ArrayList<Integer> getTelepon() {
        return telepon;
    }

    public void setTelepon(ArrayList<Integer> telepon) {
        this.telepon = telepon;
    }
}
public class AssignmentJson {
    ArrayList<Staff> alStaff  = new ArrayList<>();
    ArrayList<Manager> alManager = new ArrayList<>();

    public static void main(String args []){
        Scanner input = new Scanner(System.in);

        int id = input.nextInt();
        String nama = input.nextLine();
        int tnjPulsa = input.nextInt();
        int gapok = input.nextInt();
        int absen = input.nextInt();
        int tnjMakan = input.nextInt();
        int tnjTransport = input.nextInt();
        int tnjEmail = input.nextInt();



    }
}
