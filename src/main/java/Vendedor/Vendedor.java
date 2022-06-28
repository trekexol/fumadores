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
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class Vendedor {
    public static void main(String args[]) throws IOException, InterruptedException{

    int puerto_vendedor = 4450;
   
    
    PonerEnMesa envi = new PonerEnMesa();
    envi.enviar();
    
    
    Socket s=null;
    ServerSocket ss2=null;
    System.out.println("Vendedor escuchando ...");
    
     EjecutarVendedor ejecutar_vendedor = new EjecutarVendedor();
    
    
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
            System.out.println("Escuchando nueva Peticiones");
             ejecutar_vendedor.ejecutar(s);
          /*  ServerThread st=new ServerThread(s);
            st.start();*/

        }

    catch(Exception e){
        e.printStackTrace();
        System.out.println("Connection Error");

    }
    }

}
}

