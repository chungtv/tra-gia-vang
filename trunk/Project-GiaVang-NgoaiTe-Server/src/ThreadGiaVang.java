

//nvnamsh
public class ThreadGiaVang extends Thread {
    private JfrMain jM;
    public ThreadGiaVang(JfrMain j){
        jM=j;
    }

    public void run(){
        while(true)
        try {
            Thread.sleep(300000);            
            jM.getInfor1();
            jM.getInfor();
            
        } catch (Exception ex) {
            System.out.print(ex);
        }


    }

}
