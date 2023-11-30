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

public class GameServer {

        private List<Socket> allClient = new ArrayList<>();

    public GameServer(int port){

         try {
            ServerSocket ss = new ServerSocket(port);
            System.out.println("Le serveur est ouvert !");
            System.out.println(ss.toString());
            Thread sender = new Thread(new Sender(this));
            sender.start();
            while(true){
              Socket   sock =  ss.accept();
              allClient.add(sock);

                 Thread listener =new Thread(new ServerListener(sock,this));
                 

                  System.out.println("Le joueur "+allClient.size()+"a rejoint la partie");
                  sendToAllClient("il y a actuellement "+allClient.size()+"joueurs connectés");
                    System.out.println(sock.toString());
                 
                    
                     listener.start();
                     
                }
            
           


         

                

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
        

    }

   public void sendToAllClient(String s) throws IOException{
    
    for (Socket sock :   this.allClient) {

            OutputStream output = sock.getOutputStream();
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(output)); 
            bw.write(s+ "[envoyé à "+this.allClient.size()+" clients]");
            bw.newLine();
            bw.flush();
            bw.close();
       
    }

   }

   public boolean deleteClient(Socket s){
    return this.allClient.remove(s);
   }

    

    public static void main(String[] args) {
        new GameServer( Integer.parseInt(args[0]));
    }
    
}
class ServerListener implements Runnable{

    private Socket sock;
    private GameServer server;

    public ServerListener(Socket s, GameServer server){
        this.sock = s;
        this.server = server;

    }

    @Override
    public void run() {


        try {
         
            System.out.println("La connexion avec le client est établie ");
            System.out.println(this.sock.toString());

            InputStream input = this.sock.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(input));


            String line ="";

            while((line=br.readLine())!= null){
                System.out.println(line);
                System.out.println("blabla");

            }
        
        br.close();
        this.sock.close();
        } catch (IOException e) {
           System.out.println("Un joueur c'est déconnecté");
          System.out.println(this.server.deleteClient(sock));
            
           //e.printStackTrace();
        }
       
    
    }
}


class Sender implements Runnable{

    private GameServer server;


    public Sender(GameServer server){
        this.server = server;


    }


     public void run() {

        try {

            InputStreamReader Is = new InputStreamReader(System.in);
            BufferedReader  bf = new BufferedReader(Is);
            
                    String s = "";
                    
System.out.println("le serveur peut maitenant écrire");
                     

                    while(((s = bf.readLine())) != null){            
                            server.sendToAllClient("Serveur: "+s);

                    }
        } catch (IOException e) {
           
            e.printStackTrace();
        }
        
         
    
    }




}




