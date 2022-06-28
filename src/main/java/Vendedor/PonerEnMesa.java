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
import Fumadores.Conexion1;
import Fumadores.Conexion2;
import Fumadores.Conexion3;


/**
 *
 * @author Usuario
 */
public class PonerEnMesa {
    
    int[] puerto_mesa = {4446,4447,4448};

    public void enviar() throws IOException, InterruptedException{
        int numero_aleatorio = -1;
        int numero_anterior = -1;
         Random azar = new Random();
        for(int i =0; i< 2; i++){
            //este ciclo es para no repetir 2 veces la misma mesa
            while(numero_aleatorio == numero_anterior){
                numero_aleatorio = azar.nextInt(3);
            }
            numero_anterior =  numero_aleatorio;
            switch(numero_aleatorio){
                case 0:
                Conexion1.enviarIngrediente();
                break;
                case 1:
                Conexion2.enviarIngrediente();
                break;
                case 2:
                Conexion3.enviarIngrediente();
                break;

            }
            //enviarIngrediente(puerto_mesa[numero_aleatorio]);
            System.out.println("Ingrediente Entregado mesa "+(numero_aleatorio+1));
            log("ingrediente entregado mesa "+(numero_aleatorio+1));
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
