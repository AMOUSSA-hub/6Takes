package fr.amoussa.SixTakes.Server;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    private Socket sock;


    public Client(String address,int port){

         try {
             sock = new Socket(address,port);

            System.out.println("La connexion est établie");
            System.out.println(sock.toString());

            
                           
                    Thread t =new Thread(new Receiver(sock));
                    sendMessage("1er connexion");

                     t.start();
                

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
        

    }

    public void sendMessage(String msg) throws IOException{

        OutputStream output = this.sock.getOutputStream();

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(output)); 


                            bw.write(msg);
                            bw.newLine();
                            bw.flush();

                            bw.close();
                            output.close();


    }

    public static void main(String[] args) {
        new Client(args[0], Integer.parseInt(args[1]));
    }
    
}
class Receiver implements Runnable{

    private Socket sock;

    public Receiver(Socket s){
        this.sock = s;

    }

    @Override
    public void run() {
        


        try {
         

            InputStream input = this.sock.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(input));


            String line ="";

            while((line=br.readLine())!= null){
                if(line != null){System.out.println(line);}

            }
            System.out.println("connexion fermé");
        
        br.close();
        this.sock.close();
        } catch (IOException e) {
           System.out.println("Vous avez été déconnecté du serveur !");
           // e.printStackTrace();
        }
    
    }
}