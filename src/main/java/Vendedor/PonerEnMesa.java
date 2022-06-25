/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vendedor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Usuario
 */
public class PonerEnMesa {
    
    int[] puerto_mesa = {4446,4447,4448};
    
     
    public synchronized void enviar() throws IOException, InterruptedException{
        int numero_aleatorio = -1;
        int numero_anterior = -1;
         Random azar = new Random();
        for(int i =0; i< 2; i++){
            //este ciclo es para no repetir 2 veces la misma mesa
            while(numero_aleatorio == numero_anterior){
                numero_aleatorio = azar.nextInt(3);
            }
            numero_anterior =  numero_aleatorio;
            enviarIngrediente(puerto_mesa[numero_aleatorio]);
            System.out.println("Ingrediente Entregado mesa "+(numero_aleatorio+1));
            log("ingrediente entregado mesa "+(numero_aleatorio+1));
        }
        
        
    }    
    public static void enviarIngrediente(int puerto) throws IOException, InterruptedException{
            
         InetAddress address=InetAddress.getLocalHost();
    Socket s1=null;
    BufferedReader br=null;
    BufferedReader is=null;
    PrintWriter os=null;
      String line = "";
    String[] ingredientes = new String[]{"Tabaco","Papel","Fosforos"};  
    
    Random azar = new Random();

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
       
        os.println("Vendedor "+ingredientes[azar.nextInt(3)]);
        os.flush();
        response=is.readLine();
        
        //System.out.println("Server Response : "+response);
        //line=br.readLine();
        is.close();os.close();br.close();s1.close();
      
    }
    catch(IOException e){
        e.printStackTrace();
    
    }
    finally{

        is.close();os.close();br.close();s1.close();
                

    }
    }

    public void  log(String mensaje){
        try {
            BufferedWriter myWriter =  new BufferedWriter (new FileWriter("logVendedor.txt",true));
            java.util.Date date = new java.util.Date();
            myWriter.append(date +" "+ mensaje + "\n");
            myWriter.close();
    }catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    }
    }    
}
