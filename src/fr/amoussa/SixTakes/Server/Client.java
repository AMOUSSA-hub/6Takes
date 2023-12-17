package fr.amoussa.SixTakes.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    private Socket sock;
    private String server_id;


    public Client(String address,int port){

         try {
             sock = new Socket(address,port);

            System.out.println("La connexion est établie");
            System.out.println(sock.toString());

            
                           
                    Thread t =new Thread(new Receiver(this));
                    t.start();
                    sendMessage("1er connexion");

                     
                    
                

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
    private Client c;

    public Receiver(Client c){
        this.c = c;
    }


    @Override
    public void run() {
        


        try {
         
            ServerSocket ss = new ServerSocket(2023);
           


            String line ="";
            while(true){
                Socket sock = ss.accept();
                  BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
                    System.out.println("blabla");
                        while((line=br.readLine())!= null){
                            if(line != null){System.out.println(line);}

                        }
                        System.out.println("connexion fermé");
                    
                    br.close();
                    sock.close();
            }
        } catch (IOException e) {
            
           System.out.println("Vous avez été déconnecté du serveur !");
        }
        finally{
            System.out.println("blabla");
        }
    
    }
}