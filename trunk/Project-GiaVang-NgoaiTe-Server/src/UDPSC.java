/*
 * author Nguyen Pham Hoai An
        */
/*
 * author Nguyen Pham Hoai An
        */
import java.io.*;
import java.net.*;
class UDPSC extends Thread
{
    private UDPSC_Thread thread1;
    public UDPSC() {

    }
    public void run()
    {
        try{
            int port = 2812;
            // tao datagramsocket
            DatagramSocket socket;
            DatagramPacket packet;
            while(true)
            {
                byte []data;
                socket = new DatagramSocket(port);
                data = new byte[1024];
                packet = new DatagramPacket(data,data.length);
                // nhan goi du lieu goi tu may client;
                socket.receive(packet);
                System.out.println("nguyen pham hoai an");
                thread1 =new UDPSC_Thread(packet,socket);
                thread1.start();
                //socket.close();
            }
        }
        catch(Exception e){

         }

      }

     

}
