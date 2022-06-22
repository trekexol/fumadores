/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mesas.Mesa1;

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
public class ResponderFumador {
    
    int puerto = 4445;
     
    public void enviar() throws IOException{
         InetAddress address=InetAddress.getLocalHost();
    Socket s1=null;
    String line="mensaje mesa1";
    BufferedReader br=null;
    BufferedReader is=null;
    PrintWriter os=null;
    
    int count=1;
    try {
        s1=new Socket(address, puerto); // You can use static final constant PORT_NUM
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
       
        line+= count; 
        os.println(line);
        os.flush();
        response=is.readLine();
        System.out.println("Server Response : "+response);
        line=br.readLine();

       
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
