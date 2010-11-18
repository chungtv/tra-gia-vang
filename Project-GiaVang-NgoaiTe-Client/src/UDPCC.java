/*
 * author Nguyen Pham Hoai An
        */
import java.io.*;
import java.net.*;
import java.util.ArrayList;
class UDPCC
{
	public ArrayList ketNoi(String st) throws Exception
	{
            /// tao goi datagramSocket
		DatagramSocket socket = new DatagramSocket();
		DatagramPacket packet;
		byte []data;
            //

		InetAddress ipS = InetAddress.getByName("localhost");
		int portS = 2812;
            // nhap chuoi bat ky tu ban phim;
		data = st.getBytes();
             // goi packet den may chu;
		packet = new DatagramPacket(data,data.length,ipS,portS);
		socket.send(packet);
             // nhan packet tu may chu ;
		data = new byte[1024];
		packet = new DatagramPacket(data,data.length);
                System.out.println("assfddf");
		socket.receive(packet);
             // in ra console
		String kq = new String(packet.getData(),0,packet.getLength());

		System.out.println("Chuoi Ket Qua Tu May Chu : " + kq);
              // dong socket
		socket.close();
                int tam = 0;
                ArrayList a = new ArrayList();
                for(int i=0;i<kq.length();++i)
                {
                    if(kq.charAt(i)== '+') {
                        
                        System.out.println(kq.substring(tam, i-1));
                        a.add(kq.substring(tam, i-1));
                        tam = i+1;
                    }
                }
                return a;

	}
}