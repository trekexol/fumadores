/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mesa2;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Mesa2 {
    public static void main(String args[]){

    int puerto_mesa2 = 4447;
   
    Socket s=null;
    ServerSocket ss2=null;
    System.out.println("Mesa 2 escuchando ...");
    
    
    
    try{
        ss2 = new ServerSocket(puerto_mesa2); // can also use static final PORT_NUM , when defined

    }
    catch(IOException e){
    e.printStackTrace();
    System.out.println("Server error");

    }

    while(true){
        try{
            s= ss2.accept();
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
    String mensaje_respuesta="";
    BufferedReader  is = null;
    PrintWriter os=null;
    Socket s=null;
    
    
    String ingrediente = "";  
    
        
    
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
            
            
            if(mensaje_recibido.substring(0, 8).equals("Vendedor")){
                ingrediente = mensaje_recibido.substring(9);
                System.out.println("Ingrediente Recibido: "+ingrediente);
                mensaje_respuesta = "";
            }
            if(mensaje_recibido.substring(0, 7).equals("Fumador")){
                System.out.println("El fumador busca: "+mensaje_recibido.substring(9)+" y la mesa tiene "+ingrediente);
                 if(mensaje_recibido.substring(9).contains(ingrediente)){
                    mensaje_respuesta = ingrediente;
                    ingrediente = "";
                }else{
                    mensaje_respuesta = "Sigue Buscando";
                    
                }
                
            }
            
            os.println(mensaje_respuesta);
            os.flush();
            mensaje_recibido=is.readLine();
        }   
    } catch (IOException e) {

        mensaje_recibido=this.getName(); //reused String line for getting thread name
      //  System.out.println("IO Error/ Client "+mensaje_recibido+" terminated abruptly");
    }
    catch(NullPointerException e){
        mensaje_recibido=this.getName(); //reused String line for getting thread name
      //  System.out.println("Client "+mensaje_recibido+" Closed");
    }  
    finally{    
    try{
       
        if (is!=null){
            is.close(); 
           // System.out.println(" Socket Input Stream Closed");
        }

        if(os!=null){
            os.close();
           // System.out.println("Socket Out Closed");
        }
        if (s!=null){
        s.close();
        //System.out.println("Socket Closed");
        }

        }
    catch(IOException ie){
       // System.out.println("Socket Close Error");
    }
    }//end finally
    }
}