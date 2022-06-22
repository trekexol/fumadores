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
import java.net.Socket;
import java.util.Random;

/**
 *
 * @author Usuario
 */
public class PonerEnMesa {
    
    int puerto_mesa1 = 4446;
     
    public void enviar() throws IOException{
         InetAddress address=InetAddress.getLocalHost();
    Socket s1=null;
    BufferedReader br=null;
    BufferedReader is=null;
    PrintWriter os=null;
      String line = "";
    String[] ingredientes = new String[]{"Tabaco","Papel","Fosforos"};  
    
    Random azar = new Random();

    try {
        s1=new Socket(address, puerto_mesa1); // You can use static final constant PORT_NUM
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
       
        os.println("Vendedor "+ingredientes[azar.nextInt(3)]);
        os.flush();
        response=is.readLine();
        System.out.println("Ingrediente Entregado");
        //System.out.println("Server Response : "+response);
        //line=br.readLine();

       
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
