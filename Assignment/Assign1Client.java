package Comp.Assignment;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

import java.io.*;
import java.net.Socket;
import java.util.*;

class MultiThread1 extends Thread{
    String serverMsg = "";
    MultiThread1(String serverMsg){
        this.serverMsg = serverMsg;
    }

    public void run() {
        try {
            System.out.println(""+this.serverMsg);
            System.out.println("==========");
            /*System.out.println(""+assign1Client);*/
            String[] parsedMsg = this.serverMsg.trim().split("\n");

            for (int i = 0; i < parsedMsg.length; i++) {
                String [] parsedComma= parsedMsg[i].trim().split(",");
                System.out.println("Nama: " + parsedComma[0]);
                System.out.println("Nilai Fisika: " + parsedComma[1]);
                System.out.println(("Nilai Kimia: " + parsedComma[2]));
                System.out.println(("Nilai Biologi: " + parsedComma[3]));
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Success...");
    }

}
class MultiThread2 extends Thread{
    Assign1Client assign1Client = new Assign1Client();

    public void run() {
        String server = "ftp.dharmakertamandiri.co.id";
        int port = 21;
        String user = "adikbtpns@demo.dharmakertamandiri.co.id";
        String pass = "Shifted12345";
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect(server, port);
            ftpClient.login(user, pass);
            ftpClient.enterLocalPassiveMode();

            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

            FileWriter fw = new FileWriter("C:\\Users\\BTPNSSHIFTED\\Task\\subtask\\Week02Day09FTP\\file\\filecoba.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            String[] parsedMsg = assign1Client.serverMsg.trim().split("\n");

            for (int i = 0; i < parsedMsg.length; i++) {
                String [] parsedComma = parsedMsg[i].trim().split(",");
                String nama = parsedComma[0];
                int fis = Integer.parseInt(parsedComma[1]);
                int bio = Integer.parseInt(parsedComma[2]);
                int kim = Integer.parseInt(parsedComma[3]);
                int rata= (fis+kim+bio)/3;
                bw.write((i+1) +","+nama+","+rata);
            }
            bw.close();
            // APPROACH #1: uploads first file using an InputStream
            /*File firstLocalFile = new File("C:\\Users\\BTPNSSHIFTED\\Task\\subtask\\Week02Day09FTP\\file\\filecoba.txt");

            String firstRemoteFile = "filecoba.txt";
            InputStream inputStream = new FileInputStream(firstLocalFile);

            System.out.println("Start uploading first file");
            boolean done = ftpClient.storeFile(firstRemoteFile, inputStream);
            inputStream.close();
            if (done) {
                System.out.println("The first file is uploaded successfully.");
            }*/
        }
        catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("Success Load Rata2...");
    }
}
public class Assign1Client {
    Map m = new HashMap<>();
    String serverMsg="";
    public void getDataServer(){
        String [] parsedMsg = serverMsg.trim().split("\n");

        for (int i = 0; i < parsedMsg.length; i++) {
            int id = i+1;
            String nama = parsedMsg[0];
            int fis = Integer.parseInt(parsedMsg[1]);
            int bio = Integer.parseInt(parsedMsg[2]);
            int kim = Integer.parseInt(parsedMsg[3]);
            ArrayList<Integer> alNilai = new ArrayList<>();
            for (int j = 0; j < 3; j++) {
                if (i == 0){
                    alNilai.add(fis);
                }else if (i == 1){
                    alNilai.add(bio);
                }else if (i == 2) {
                    alNilai.add(kim);
                }
            }
            m.put(id, new Model1(id, nama, alNilai));
        }
    }
    public void viewDataServer() {
        try {
            FileWriter fw = new FileWriter("C:\\Users\\BTPNSSHIFTED\\Task\\subtask\\Week02Day09FTP\\file\\ahmdfaris.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            String[] parsedMsg = serverMsg.trim().split("\n");

            for (int i = 0; i < parsedMsg.length; i++) {
                String [] parsedComma= parsedMsg[i].trim().split(",");
                System.out.println("Nama: " + parsedComma[0]);
                System.out.println("Nilai Fisika: " + parsedComma[1]);
                System.out.println(("Nilai Kimia: " + parsedComma[2]));
                System.out.println(("Nilai Biologi: " + parsedComma[3]));
                bw.write("===========================\n");
                bw.write("Nama: " + parsedComma[0]+"\n");
                bw.write("Nilai Fisika: " + parsedComma[1]+"\n");
                bw.write("Nilai Kimia: " + parsedComma[2]+"\n");
                bw.write("Nilai Biologi: " + parsedComma[3]+"\n");
            }
            bw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    public static void main(String args[]) throws IOException {
        Assign1Client assign1 = new Assign1Client();
        Scanner input = new Scanner(System.in);
        Socket s = null;
        DataOutputStream dout = null;
        DataInputStream dis = null;

        String strGet = "data";

        try{
            //Load Config
/*            Properties prop = new Properties();
            String propFileName = "config.properties";
            FileInputStream inputStream = new FileInputStream(propFileName);
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            // get the property value and print it out
            int port = Integer.parseInt(prop.getProperty("PORT"));
            String host = prop.getProperty("HOST");*/

            int pil = 0;

            while (pil != 7){
                System.out.println("MENU");
                System.out.println("1. Connect Socket");
                System.out.println("2. Send Data");
                System.out.println("3. Close Socket");
                System.out.print("Input :");
                pil = input.nextInt();

                switch (pil){
                    case 1:
                        //Socket Client Connect
                        s=new Socket("localhost",6666);
                        break;
                    case 2:
                        //Socket Client Send Data
                        dout=new DataOutputStream(s.getOutputStream());
                        dout.writeUTF(strGet);
                        dout.flush();
                        break;
                    case 3 :
                        dout.writeUTF("EXIT");
                        dout.flush();

                        //Socket and Stream Close
                        dout.close();
                        s.close();
                        break;
                    case 4:
                        dis = new DataInputStream(s.getInputStream());
                        assign1.serverMsg= (String) dis.readUTF();
                        System.out.println(assign1.serverMsg);
                        break;
                    case 5:
                        System.out.println();
                        assign1.viewDataServer();
                        break;
                    case 6:

                        MultiThread1 t1 = new MultiThread1(assign1.serverMsg);
                        MultiThread2 t2 = new MultiThread2();
                        t1.start();
                        t2.start();
                        break;
                }
            }
        }catch(Exception e){System.out.println(e);}

    }
}