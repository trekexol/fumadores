/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vendedor;

import Mesa3.*;
import Mesa1.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EjecutarVendedor {
    
  
    public EjecutarVendedor() {
    }

    
    
public  void ejecutar(Socket s) throws InterruptedException {

    String mensaje_recibido=null;
    String mensaje_respuesta="";
    BufferedReader  is = null;
    PrintWriter os=null;
    //Socket s=null;
    
    
    //String ingrediente = "";  
    
   
    try{
        is= new BufferedReader(new InputStreamReader(s.getInputStream()));
        os=new PrintWriter(s.getOutputStream());

    }catch(IOException e){
        System.out.println("IO error in server thread");
    }

    try {
        mensaje_recibido=is.readLine();
        while(mensaje_recibido.compareTo("QUIT")!=0){
            
             while(mensaje_recibido.compareTo("QUIT")!=0){
            
            System.out.println("enviando por peticion de fumador");
            /*ENVIAR RESPUESTA -----------------------------------------------*/
            PonerEnMesa envi = new PonerEnMesa();
            envi.enviar();
            /*---------------------------------------------------------*/
            mensaje_recibido=is.readLine();
        }   
        }   
    } catch (IOException e) {

       // mensaje_recibido=this.getName(); //reused String line for getting thread name
      //  System.out.println("IO Error/ Client "+mensaje_recibido+" terminated abruptly");
    }
    catch(NullPointerException e){
       // mensaje_recibido=this.getName(); //reused String line for getting thread name
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
