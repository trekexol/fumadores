package Fumadores;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

public class Conexion2 {

    public static synchronized String buscarEnMesa2(int fumador,String le_falta)throws IOException, InterruptedException{
      
        String address="localhost";//"192.168.1.68"; //ip del server donde corren las mesas se cambia por la ip publica de la pc donde corre el server
        Socket s2=null;
        String mensaje= "Fumador "+fumador;
        BufferedReader br=null;
        BufferedReader is=null;
        PrintWriter os=null;

        try {
            s2=new Socket(address, 4447); // You can use static final constant PORT_NUM
            br= new BufferedReader(new InputStreamReader(System.in));
            is=new BufferedReader(new InputStreamReader(s2.getInputStream()));
            os= new PrintWriter(s2.getOutputStream());

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

        }
        catch(IOException e){
            e.printStackTrace();
        System.out.println("Socket read Error");
        }
        finally{
            is.close();os.close();br.close();s2.close();
            return response;
        }
    }

    public static synchronized String buscarEnMesa3(int fumador,String le_falta)throws IOException, InterruptedException{

        String address="localhost";//"192.168.1.68"; //ip del server donde corren las mesas se cambia por la ip publica de la pc donde corre el server
        Socket s3=null;
        String mensaje= "Fumador "+fumador;
        BufferedReader br=null;
        BufferedReader is=null;
        PrintWriter os=null;

        try {
            s3=new Socket(address, 4448); // You can use static final constant PORT_NUM
            br= new BufferedReader(new InputStreamReader(System.in));
            is=new BufferedReader(new InputStreamReader(s3.getInputStream()));
            os= new PrintWriter(s3.getOutputStream());

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

        }
        catch(IOException e){
            e.printStackTrace();
        System.out.println("Socket read Error");
        }
        finally{
            is.close();os.close();br.close();s3.close();
            return response;
        }
    }
}
