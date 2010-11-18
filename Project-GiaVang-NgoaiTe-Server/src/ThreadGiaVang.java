
import java.util.logging.Level;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nvnamsh
 */
public class ThreadGiaVang extends Thread {
    private JfrMain jM;
    public ThreadGiaVang(JfrMain j){
        jM=j;
    }

    public void run(){
        while(true)
        try {
            Thread.sleep(300000);
            System.out.println("ssss");
            jM.getInfor1();
            jM.getInfor();
            
        } catch (Exception ex) {
            System.out.print(ex);
        }


    }

}
