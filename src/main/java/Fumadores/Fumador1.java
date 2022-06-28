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
import Fumadores.Conexion;
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
        Boolean txt = JOptionPane.showConfirmDialog(null, "Quieres buscar ingredientes?","Fumador 1",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
        if(!txt){
            System.out.println("No fumo");
            break;
        }
    //buscar en mesa 1
        System.out.println("busca en mesa "+(contador_intentos+1));
        //Conexion c = new Conexion();
        respuesta_mesa = Conexion.buscarEnMesa1(1,le_falta);
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
        if(respuesta_mesa.equals("") || respuesta_mesa.equals("Sigue Buscando")){
            contador_respuestas_vacias ++;
            if(contador_respuestas_vacias == 2){
                PedirAlVendedor(puerto_vendedor);
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
        respuesta_mesa = Conexion.buscarEnMesa2(1,le_falta);
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
                PedirAlVendedor(puerto_vendedor);
                 System.out.println("Fumador1: Ya le pedi al vendedor");
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
        respuesta_mesa = Conexion.buscarEnMesa3(1,le_falta);
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
                PedirAlVendedor(puerto_vendedor);
                 System.out.println("Fumador1: Ya le pedi al vendedor");
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





//deberiamos poner esto tambien en conexion? 

public static void PedirAlVendedor(int vendedor)throws IOException, InterruptedException{
   
    //String address="127.0.0.1"; //ip del server donde corren las mesas se cambia por la ip publica de la pc donde corre el server
    String address="25.82.105.42";
    Socket s1=null;
    String mensaje= "Fumador1";
    BufferedReader br=null;
    BufferedReader is=null;
    PrintWriter os=null;
    
    
    try {
        s1=new Socket(address, vendedor); // You can use static final constant PORT_NUM
        br= new BufferedReader(new InputStreamReader(System.in));
        is=new BufferedReader(new InputStreamReader(s1.getInputStream()));
        os= new PrintWriter(s1.getOutputStream());
        
    }
    catch (IOException e){
        e.printStackTrace();
        System.err.print("IO Exception");
    }

   
    String response=null;
    os.println(mensaje); 
    os.flush();
    
    is.close();
    os.close();
    br.close();
    s1.close();
}





}
