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
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Usuario
 */
public class Fumador1 {
    
     
public static void main(String args[]) throws IOException, InterruptedException{

    int puerto_vendedor = 4449;
    int[] puerto_mesa = {4446,4447,4448};
    
    int contador_intentos = 0;
    String componente_infinito = "Tabaco";
    
    String le_falta = "Papel-Fosforos";
    
    String respuesta_mesa = "";
    
    while(true){
        System.out.println("busca en mesa "+(contador_intentos+1));
        respuesta_mesa = buscarEnMesas(puerto_mesa[contador_intentos],le_falta);
        
        System.out.println("respuesta de la mesa :"+respuesta_mesa);
        
        if(respuesta_mesa.equals("Papel")){
              if(le_falta.equals("Papel")){
                System.out.println("Completo todos los Ingredientes, empieza a fumar");
                //ya fumo y se reinicia
                le_falta = "Papel-Fosforos";
            }else{
                 le_falta = "Fosforos";
            }

        }
        if(respuesta_mesa.equals("Fosforos")){
            if(le_falta.equals("Fosforos")){
                System.out.println("Completo todos los Ingredientes, empieza a fumar");
                le_falta = "Papel-Fosforos";
            }else{
                 le_falta = "Papel";
            }
        }
        
        contador_intentos += 1;
        TimeUnit.SECONDS.sleep(5);

        if(contador_intentos == 3){
            contador_intentos = 0;
        }
       
    }
  
   
}


public static String buscarEnMesas(int mesa,String le_falta)throws IOException, InterruptedException{
   
    InetAddress address=InetAddress.getLocalHost();
    Socket s1=null;
    String mensaje= "Fumador1";
    BufferedReader br=null;
    BufferedReader is=null;
    PrintWriter os=null;
    
    String componente_infinito = "Tabaco";
    
   
    
    try {
        s1=new Socket(address, mesa); // You can use static final constant PORT_NUM
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
       
        
        os.println(mensaje+" "+le_falta);
        os.flush();
        response=is.readLine();
        System.out.println("La mesa Responde : "+response);
        
      
        //mensaje=br.readLine();


    }
    catch(IOException e){
        e.printStackTrace();
    System.out.println("Socket read Error");
    }
    finally{

        is.close();os.close();br.close();s1.close();
        return response;
    }
}



}
