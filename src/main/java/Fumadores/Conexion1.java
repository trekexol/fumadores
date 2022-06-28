package Fumadores;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Conexion1 {

    
    public static synchronized String buscarEnMesa1(int fumador,String le_falta)throws IOException, InterruptedException {
        
        String address="localhost";//"192.168.1.68"; //ip del server donde corren las mesas se cambia por la ip publica de la pc donde corre el server
        Socket s1=null;
        String mensaje= "Fumador "+fumador;
        BufferedReader br=null;
        BufferedReader is=null;
        PrintWriter os=null;

        try {
            s1=new Socket(address, 4446); // You can use static final constant PORT_NUM
            br= new BufferedReader(new InputStreamReader(System.in));
            TimeUnit.SECONDS.sleep(2);
            is=new BufferedReader(new InputStreamReader(s1.getInputStream()));
            os= new PrintWriter(s1.getOutputStream());

        }
        catch (IOException e){
            e.printStackTrace();
            System.err.print("IO Exception");
        }
        String response=null;
        try{
            TimeUnit.SECONDS.sleep(2);
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
            TimeUnit.SECONDS.sleep(2);
            is.close();os.close();br.close();s1.close();
            return response;
        }
    }
    
  //  public static synchronized String ponerEnMesa(int mesa, String le_falta)th

public synchronized static void enviarIngrediente() throws IOException, InterruptedException{

InetAddress address=InetAddress.getLocalHost();
Socket s1=null;
BufferedReader br=null;
BufferedReader is=null;
PrintWriter os=null;
  String line = "";
String[] ingredientes = new String[]{"Tabaco","Papel","Fosforos"};  

Random azar = new Random();

try {
    s1=new Socket(address, 4446); // You can use static final constant PORT_NUM
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


}
    