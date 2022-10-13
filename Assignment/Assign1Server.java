package Comp.Assignment;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Assign1Server {
    Map m= new HashMap<>();
    String isi = "";
    public String loadData(String fileName) {
        try {
            FileReader fr = new FileReader("C:\\Users\\BTPNSSHIFTED\\Task\\subtask\\Week02Day09FTP\\file\\" + fileName + ".txt");
            BufferedReader br = new BufferedReader(fr);
            int i = 0;
            while ((i = br.read()) != -1) {
                this.isi = isi + (char) i;
            }
            System.out.println(isi);
        } catch (Exception e) {
            System.out.println(e);
        }
        return isi;
    }

    public static void main(String args[]){
        Assign1Server assign1Server = new Assign1Server();
        try{
            String msgGet = "";
            ServerSocket ss = null;
            Socket s = null;
            String chtServer="";
            DataOutputStream dout= null;
            Scanner input= new Scanner(System.in);
            Assign1Server assign1 = new Assign1Server();

            //Server Socket Up
            ss=new ServerSocket(6666);
            s=ss.accept();//establishes connection
            DataInputStream dis=new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());

            while(!msgGet.equalsIgnoreCase("EXIT")){

                String  str=(String)dis.readUTF();
                System.out.println("message= "+str);

/*                System.out.println("Masukkan pesan");
                chtServer = input.nextLine();
                System.out.println(chtServer);*/

                String pesan = assign1Server.loadData(str);

                dout.writeUTF(pesan);
                dout.flush();


            }
            //Server Socket Down
            s.close();
            ss.close();
        }catch(Exception e){System.out.println(e);}
    }
}
