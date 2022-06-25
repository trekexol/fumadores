/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mesa1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EjecutarMesa {
    
    public String ingrediente = "";

    public EjecutarMesa() {
    }

    public String getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(String ingrediente) {
        this.ingrediente = ingrediente;
    }
    
    
    
    
public  void ejecutar(Socket s) {

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
            
            
            if(mensaje_recibido.substring(0, 8).equals("Vendedor")){
                ingrediente = mensaje_recibido.substring(9);
                System.out.println("Ingrediente Recibido: "+ingrediente);
                log("vendedor envio ingrediente: "+ingrediente+" a mesa 1");
                mensaje_respuesta = "";
            }
            if(mensaje_recibido.substring(0, 7).equals("Fumador")){
                System.out.println("El fumador busca: "+mensaje_recibido.substring(9)+" y la mesa tiene "+ingrediente);
                log("fumador busca: "+mensaje_recibido.substring(9)+" y la mesa tiene "+ingrediente);
                 if(mensaje_recibido.substring(9).contains(ingrediente)){
                    mensaje_respuesta = ingrediente;
                    ingrediente = "";
                }else{
                    mensaje_respuesta = "Sigue Buscando";
                    
                }
                
            }
            
            os.println(mensaje_respuesta);
            os.flush();
            mensaje_recibido=is.readLine();
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

  public void  log(String mensaje){
    try {
        BufferedWriter myWriter =  new BufferedWriter (new FileWriter("logMesa1.txt",true));
        java.util.Date date = new java.util.Date();
        myWriter.append(date +" "+ mensaje + "\n");
        myWriter.close();
}catch (IOException e) {
    System.out.println("An error occurred.");
    e.printStackTrace();
}
}
}
