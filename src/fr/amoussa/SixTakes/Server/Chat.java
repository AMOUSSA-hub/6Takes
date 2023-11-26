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

public class Chat {


    public Chat(String address,int port){

         try {
            Socket sock = new Socket(address,port);

            System.out.println("La connexion est établie");
            System.out.println(sock.toString());

            OutputStream output = sock.getOutputStream();

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(output));

            InputStreamReader Is = new InputStreamReader(System.in);
            BufferedReader  bf = new BufferedReader(Is);
            

                    String s = "";

                    

                     Thread t =new Thread(new ServerListener(sock));

                     t.start();

                    while(((s = bf.readLine())) != "done"){
                            
                            bw.write(s);
                            bw.newLine();
                            bw.flush();
                           

                    }
                     sock.close();

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
        

    }

    public static void main(String[] args) {
        new Chat(args[0], Integer.parseInt(args[1]));
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
         

            InputStream input = this.sock.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(input));


            String line ="";

            while(!(line=br.readLine()).equals("-1") ){
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



