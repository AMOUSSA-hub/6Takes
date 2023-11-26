package fr.amoussa.SixTakes.Server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {

        private List<BufferedWriter> allClient = new ArrayList<>();

    public ChatServer(int port){

         try {
            ServerSocket ss = new ServerSocket(port);
            System.out.println("Le serveur est ouvert !");
            System.out.println(ss.toString());
    
            while(true){
              Socket   sock =  ss.accept();

              OutputStream output = sock.getOutputStream();
              BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(output)); 
              allClient.add(bf);

                 Thread listener =new Thread(new ServerListener(sock));
                 Thread sender = new Thread(new Sender(this));

                  System.out.println("Nouveau client sur le serveur");
                    System.out.println(sock.toString());
                 
                    sender.start();
                     listener.start();
                     
                }
            
           


         

                

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
        

    }

   public void sendToAllClient(String s){
    
    for (BufferedWriter bw :   this.allClient) {

        try {
            bw.write(s+ "[envoyé à "+this.allClient.size()+" clients]");
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

   }

    

    public static void main(String[] args) {
        new ChatServer( Integer.parseInt(args[0]));
    }
    
}
class ServerListener implements Runnable{

    private Socket sock;

    public ServerListener(Socket s){
        this.sock = s;

    }

    @Override
    public void run() {


        try {
         
            System.out.println("La connexion avec le client est établie ");
            System.out.println(this.sock.toString());

            InputStream input = this.sock.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(input));


            String line ="";

            while((line=br.readLine())!= "-1"){
                if(line != null){System.out.println(line);}

            }
        
        br.close();
        this.sock.close();
        } catch (IOException e) {
           System.out.println("Un joueur c'est déconnecté");
           //e.printStackTrace();
        }
       
    
    }
}


class Sender implements Runnable{

    private ChatServer server;


    public Sender(ChatServer server){
        this.server = server;


    }


     public void run() {

        try {

            InputStreamReader Is = new InputStreamReader(System.in);
            BufferedReader  bf = new BufferedReader(Is);
            
                    String s = "";
                    
System.out.println("le serveur peut maitenant écrire");
                     

                    while(((s = bf.readLine())) != "done"){              
                            System.out.println("message envoyé");
                            server.sendToAllClient("Serveur: "+s);
                    }
        } catch (IOException e) {
           
            e.printStackTrace();
        }
        
         
    
    }




}




