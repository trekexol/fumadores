/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vendedor;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Usuario
 */
public class Vendedor {
    public static void main(String args[]) throws IOException{

    int puerto_vendedor = 4449;
   
    
    PonerEnMesa envi = new PonerEnMesa();
    envi.enviar();
    
    
    Socket s=null;
    ServerSocket ss2=null;
    System.out.println("Vendedor escuchando ...");
    
    
    
    try{
        ss2 = new ServerSocket(puerto_vendedor); // can also use static final PORT_NUM , when defined

    }
    catch(IOException e){
    e.printStackTrace();
    System.out.println("Server error");

    }

    while(true){
        try{
            s= ss2.accept();
            System.out.println("Escuchando nueva Peticion");
            ServerThread st=new ServerThread(s);
            st.start();

        }

    catch(Exception e){
        e.printStackTrace();
        System.out.println("Connection Error");

    }
    }

}
}



class ServerThread extends Thread{  

    String mensaje_recibido=null;
    BufferedReader  is = null;
    PrintWriter os=null;
    Socket s=null;
    
  
    
    public ServerThread(Socket s){
        this.s=s;
    }

    public void run() {
    try{
        is= new BufferedReader(new InputStreamReader(s.getInputStream()));
        os=new PrintWriter(s.getOutputStream());

    }catch(IOException e){
        System.out.println("IO error in server thread");
    }

    try {
        mensaje_recibido=is.readLine();
        while(mensaje_recibido.compareTo("QUIT")!=0){
            
            
            /*ENVIAR RESPUESTA -----------------------------------------------*/
            PonerEnMesa envi = new PonerEnMesa();
            envi.enviar();
            /*---------------------------------------------------------*/
            mensaje_recibido=is.readLine();
        }   
    } catch (IOException e) {

        mensaje_recibido=this.getName(); //reused String line for getting thread name
        System.out.println("IO Error/ Client "+mensaje_recibido+" terminated abruptly");
    }
    catch(NullPointerException e){
        mensaje_recibido=this.getName(); //reused String line for getting thread name
        System.out.println("Client "+mensaje_recibido+" Closed");
    }

    finally{    
    try{
        System.out.println("Connection Closing..");
        if (is!=null){
            is.close(); 
            System.out.println(" Socket Input Stream Closed");
        }

        if(os!=null){
            os.close();
            System.out.println("Socket Out Closed");
        }
        if (s!=null){
        s.close();
        System.out.println("Socket Closed");
        }

        }
    catch(IOException ie){
        System.out.println("Socket Close Error");
    }
    }//end finally
    }
}