/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author WELLCOME
 */
import Dola.PhanTich.GiaDoLa;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UDPSC_Thread extends Thread {
    private DatagramPacket packet;
    private DatagramSocket socket;
    public UDPSC_Thread(DatagramPacket packet,DatagramSocket socket) {

        this.packet = packet;
        this.socket = socket;
    }
    public void run() {

        try {
            String st = new String(packet.getData(),0,packet.getLength());
            byte []data;
            // tao goi du lieu chay tu
            InetAddress ipC = packet.getAddress();
            int portC = packet.getPort();
            /// goi ham XuLy
            System.out.println("tien su ly");
            String kq = XuLy(st);

            data = kq.getBytes();
            packet = new DatagramPacket(data,data.length,ipC,portC);
            System.out.println("tien goi");
            socket.send(packet);
            System.out.println();
        }
        catch(Exception e)
        {}
       }

    private String XuLy(String st) throws Exception {
        if(st.charAt(0) == '0')
        {

            st = st.substring(1);
            GiaDoLa dola = new GiaDoLa();
            ArrayList a = dola.layGiaDoLa();
            StringBuilder tam = new StringBuilder();
            for(int i=0;i<dola.size();++i)
            {
                System.out.println(a.get(i*5+1).toString());
                if(st.equals(a.get(i*5+1).toString()))
                {

                    for(int j=0;j<5;++j)
                    {

                       tam.append(a.get(i*5+j));
                       tam.append("+");
                            //System.out.println(a.get(i*5+j));
                    }
                    return tam.toString();
                }
            }

        }
        return null;


    }



}
