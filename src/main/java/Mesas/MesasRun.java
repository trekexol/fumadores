package Mesas;

import java.util.concurrent.ThreadFactory;

import Mesas.Mesa1.Mesa1;

public class MesasRun {
    public static void main(String[] args) 
    {
        Mesa1 []Mesa = new Mesa1[3];  // tres mesas

        System.out.println("Bienvenidos, esta es la zona de fumadores");
        
        Mesa[0] = new Mesa1(4446); 
        Mesa[1] = new Mesa1(4447);
        Mesa[2] = new Mesa1(4448);
        Thread m1 = new Thread(Mesa[0]);
        Thread m2 = new Thread(Mesa[1]);
        //create a virtual thread running Mesa[2]
        Thread m3 = new Thread(Mesa[2]);
        m1.start();
        m2.start();
        m3.start();



    }
}
