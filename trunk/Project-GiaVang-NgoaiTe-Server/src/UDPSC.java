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
    DatagramSocket socket;
    public UDPSC() {

    }
    public void run()
    {
        try{
            int port = 2812;
            // tao datagramsocket
            
            DatagramPacket packet;
            socket = new DatagramSocket(port);
            while(true)
            {
                byte []data;
                
                data = new byte[1024];
                packet = new DatagramPacket(data,data.length);
                // nhan goi du lieu goi tu may client;
                socket.receive(packet);
                System.out.println("nguyen pham hoai an");
                thread1 =new UDPSC_Thread(packet,socket);
                thread1.start();    
            }

        }

        catch(Exception e){

         }

      }

    public void stops()
    {
        socket.close();
    }

     

}
