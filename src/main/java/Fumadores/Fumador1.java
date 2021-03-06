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
import Fumadores.Conexion1;
import Fumadores.Conexion2;
import Fumadores.Conexion3;
import javax.swing.JOptionPane;

/**
 *
 * @author Usuario
 */
public class Fumador1 {

public static void main(String args[]) throws IOException, InterruptedException{

    int puerto_vendedor = 4450;
    //int[] puerto_mesa = {4446,4447,4448};
    int contador_intentos = 0;
    String le_falta = "Papel-Fosforos";
    String respuesta_mesa = "";
    int contador_respuestas_vacias = 0;
    while(true){
        Boolean txt = JOptionPane.showConfirmDialog(null, "Quieres buscar ingredientes?","Fumar",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
        if(!txt){
            System.out.println("No fumo");
            break;
        }
    //buscar en mesa 1
        System.out.println("busca en mesa "+(contador_intentos+1));
        //Conexion c = new Conexion();
        
        respuesta_mesa = Conexion1.buscarEnMesa1(1,le_falta);
        System.out.println("respuesta de la mesa :"+respuesta_mesa);
        if(respuesta_mesa.equals("Papel")){
              if(le_falta.equals("Papel")){
                System.out.println("Completo todos los Ingredientes, empieza a fumar");
                TimeUnit.SECONDS.sleep(50);
                //ya fumo y se reinicia
                le_falta = "Papel-Fosforos";
                contador_respuestas_vacias = 0;
            }else{
                 le_falta = "Fosforos";
            }
        }
        if(respuesta_mesa.equals("Fosforos")){
            if(le_falta.equals("Fosforos")){
                System.out.println("Completo todos los Ingredientes, empieza a fumar");
                TimeUnit.SECONDS.sleep(5);
                //ya fumo y se reinicia
                le_falta = "Papel-Fosforos";
            }else{
                 le_falta = "Papel";
            }
        }
        if(respuesta_mesa.equals("") || respuesta_mesa.equals("Sigue Buscando")){
            contador_respuestas_vacias ++;
            if(contador_respuestas_vacias == 2){
                ConexionV.PedirAlVendedor(1);
                 System.out.println("Fumador1: Ya le pedi al vendedor");
                 contador_respuestas_vacias = 0;
            }

        }
        contador_intentos += 1;
        TimeUnit.SECONDS.sleep(5);

        if(contador_intentos == 3){
            contador_intentos = 0;
        }

        //buscar en mesa 2
        System.out.println("busca en mesa "+(contador_intentos+1));
        if (!Thread.holdsLock(Conexion2.class)) {
            System.out.println("Mesa 2 esta ocupada");
        }
        respuesta_mesa = Conexion2.buscarEnMesa2(1,le_falta);
        System.out.println("respuesta de la mesa :"+respuesta_mesa);
        if(respuesta_mesa.equals("Papel")){
              if(le_falta.equals("Papel")){
                System.out.println("Completo todos los Ingredientes, empieza a fumar");
                TimeUnit.SECONDS.sleep(5);
                //ya fumo y se reinicia
                le_falta = "Papel-Fosforos";
                contador_respuestas_vacias = 0;
            }else{
                 le_falta = "Fosforos";
            }
        }
        if(respuesta_mesa.equals("Fosforos")){
            if(le_falta.equals("Fosforos")){
                System.out.println("Completo todos los Ingredientes, empieza a fumar");
                TimeUnit.SECONDS.sleep(5);
                //ya fumo y se reinicia
                le_falta = "Papel-Fosforos";
            }else{
                 le_falta = "Papel";
            }
        }
        //aqui creo q deberiamos poner un wait, y que el vendedor meta los ingredientes que faltan es esa mesa, y que el fumador1 se quede esperando
        if(respuesta_mesa.equals("") || respuesta_mesa.equals("Sigue Buscando")){
            contador_respuestas_vacias ++;
            if(contador_respuestas_vacias == 2){
                ConexionV.PedirAlVendedor(1);
                 System.out.println("Fumador 1: Ya le pedi al vendedor");
                 contador_respuestas_vacias = 0;
            }

        }
        contador_intentos += 1;
        TimeUnit.SECONDS.sleep(5);

        if(contador_intentos == 3){
            contador_intentos = 0;
        }


        //buscar en mesa 3
        System.out.println("busca en mesa "+(contador_intentos+1));
        
        respuesta_mesa = Conexion3.buscarEnMesa3(1,le_falta);
        System.out.println("respuesta de la mesa :"+respuesta_mesa);
        if(respuesta_mesa.equals("Papel")){
              if(le_falta.equals("Papel")){
                System.out.println("Completo todos los Ingredientes, empieza a fumar");
                TimeUnit.SECONDS.sleep(5);
                //ya fumo y se reinicia
                le_falta = "Papel-Fosforos";
                contador_respuestas_vacias = 0;
            }else{
                 le_falta = "Fosforos";
            }
        }
        if(respuesta_mesa.equals("Fosforos")){
            if(le_falta.equals("Fosforos")){
                System.out.println("Completo todos los Ingredientes, empieza a fumar");
                TimeUnit.SECONDS.sleep(5);
                //ya fumo y se reinicia
                le_falta = "Papel-Fosforos";
            }else{
                 le_falta = "Papel";
            }
        }
        //aqui creo q deberiamos poner un wait, y que el vendedor meta los ingredientes que faltan es esa mesa, y que el fumador1 se quede esperando
        if(respuesta_mesa.equals("") || respuesta_mesa.equals("Sigue Buscando")){
            contador_respuestas_vacias ++;
            if(contador_respuestas_vacias == 2){
                ConexionV.PedirAlVendedor(1);
                 System.out.println("Fumador 1: Ya le pedi al vendedor");
                 contador_respuestas_vacias = 0;
            }

        }
        contador_intentos += 1;
        TimeUnit.SECONDS.sleep(5);

        if(contador_intentos == 3){
            contador_intentos = 0;
        }

    }

}



}
