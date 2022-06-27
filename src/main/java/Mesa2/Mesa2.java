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
    
   
    public static void  main(String args[]){

    int puerto_mesa2 = 4447;
   
    Socket s=null;
    ServerSocket ss2=null;
    System.out.println("Mesa 2 escuchando ...");
    
    EjecutarMesa ejecutar_mesa = new EjecutarMesa();
    
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
           ejecutar_mesa.ejecutar(s);
          /*  ServerThread st=new ServerThread(s);
            st.start();*/
       // ejecutar_mesa.wait();
        }

    catch(Exception e){
        e.printStackTrace();
        System.out.println("Connection Error");

    }
    }

}
}
