/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Fumadores;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 *
 * @author Usuario
 */
public class Fumador {
    
    
public static void main(String args[]) throws IOException{

    int puerto_vendedor = 4449;

    InetAddress address=InetAddress.getLocalHost();
    Socket s1=null;
    String mensaje= "Fumador1";
    BufferedReader br=null;
    BufferedReader is=null;
    PrintWriter os=null;
    
    String componente_infinito = "Tabaco";
    
    String le_falta = "Fosforo";

    try {
        s1=new Socket(address, puerto_vendedor); // You can use static final constant PORT_NUM
        br= new BufferedReader(new InputStreamReader(System.in));
        is=new BufferedReader(new InputStreamReader(s1.getInputStream()));
        os= new PrintWriter(s1.getOutputStream());
    }
    catch (IOException e){
        e.printStackTrace();
        System.err.print("IO Exception");
    }

   
    String response=null;
    try{
       
        while(mensaje.compareTo("QUIT")!=0){
                os.println(mensaje+" "+le_falta);
                os.flush();
                response=is.readLine();
                System.out.println("La mesa Responde : "+response);
                mensaje=br.readLine();

            }



    }
    catch(IOException e){
        e.printStackTrace();
    System.out.println("Socket read Error");
    }
    finally{

        is.close();os.close();br.close();s1.close();
                System.out.println("Connection Closed");

    }

}
}
