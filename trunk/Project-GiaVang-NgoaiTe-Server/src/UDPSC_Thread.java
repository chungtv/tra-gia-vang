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
            String kq = XuLy(st);
            //fgfgf

            data = kq.getBytes();
            packet = new DatagramPacket(data,data.length,ipC,portC);
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
        
        if(st.charAt(0)=='1')
        {
            
            st = st.substring(1);
            claUrl url=new claUrl("http://www.sjc.com.vn/ajax_vang.php");
            String[][] sb=url.ArrShowGiaVang();
            StringBuilder tam = new StringBuilder();
            
            if(st.equals("TPHCM")){
                
                for (int i=0;i<9;i++){
                    tam.append("TPHCM");
                    tam.append("+");
                    tam.append(sb[i][0]);
                    tam.append("+");
                    tam.append(sb[i][1]);
                    tam.append("+");
                    tam.append(sb[i][2]);
                    tam.append("+");
                }
            }
            if(st.equals("Hà Nội")){
                System.out.println("dgđfdfdfdfd");
                    tam.append("Hà Nội");
                    tam.append("+");
                    tam.append(sb[9][0]);
                    tam.append("+");
                    tam.append(sb[9][1]);
                    tam.append("+");
                    tam.append(sb[9][2]);
                    tam.append("+");

            }
            if(st.equals("Đà Nẵng")){
                    tam.append("Đà Nẵng");
                    tam.append("+");
                    tam.append(sb[10][0]);
                    tam.append("+");
                    tam.append(sb[10][1]);
                    tam.append("+");
                    tam.append(sb[10][2]);
                    tam.append("+");

            }
            if(st.equals("Nha Trang")){
                    tam.append("Nha Trang");
                    tam.append("+");
                    tam.append(sb[11][0]);
                    tam.append("+");
                    tam.append(sb[11][1]);
                    tam.append("+");
                    tam.append(sb[11][2]);
                    tam.append("+");

            }
            if(st.equals("Cần Thơ")){
                    tam.append("Cần Thơ");
                    tam.append("+");
                    tam.append(sb[12][0]);
                    tam.append("+");
                    tam.append(sb[12][1]);
                    tam.append("+");
                    tam.append(sb[12][2]);
                    tam.append("+");

            }
            return tam.toString();
            
            
        }
        return null;


    }



}
