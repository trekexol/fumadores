package Fumadores;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ConexionV {
    public static void PedirAlVendedor(int fumador)throws IOException, InterruptedException{

        String address="127.0.0.1";//"192.168.1.68"; //ip del server donde corren las mesas se cambia por la ip publica de la pc donde corre el server
        Socket s1=null;
        String mensaje= "fumador"+fumador;
        BufferedReader br=null;
        BufferedReader is=null;
        PrintWriter os=null;

        try {
            s1=new Socket(address, 4450); // You can use static final constant PORT_NUM
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

