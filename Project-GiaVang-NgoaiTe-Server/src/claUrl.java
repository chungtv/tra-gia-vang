/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author nvnamsh
 */
public class claUrl {
   private URL url;
   //khoi tao url full
   public claUrl(String url){
       try{
           this.url=new URL(url);
       }catch(MalformedURLException e){
           System.err.println(e);
       }
   }
   //khoi tao url chi tiet
   public claUrl(String prot , String host, String port, String file){
       try{
           if(port.length()>0)
            this.url=new URL(prot,host,Integer.valueOf(port),file);
           else
              this.url=new URL(prot,host,file);
       }catch(MalformedURLException e){
           System.err.println(e);
       }
   }
   //kiem tra xem thu url da dc xac dinh chua
   public boolean isURL(){
       if(url==null)
           return false;
       return true;
   }
   //xuat protocol
   public String getProtocol(){
       return url.getProtocol();
   }
   //xuat port
   public int getPort(){
       int i=url.getPort();
       if(i==-1)
           i=url.getDefaultPort();
       return i;
   }
   //xuat host
   public String getHost(){
       return url.getHost();
   }
   //xuat file name
   public String getFile(){
       return url.getFile();
   }
   //xuat duong dan

   public String getPath(){
       return url.getPath();
   }
   //xuat url
   public String getURL(){
       return this.getProtocol()+"://"+
               this.getHost()+
               this.getFile()+":"+String.valueOf(this.getPort());               
   }

   //xuat thong tin ra file nhi phan
   
    public StringBuffer viewSource() throws IOException{
        StringBuffer sb=new StringBuffer();
        DataInputStream dis=new DataInputStream(url.openStream());
        String st=new String();
        try {
            while ((st = dis.readLine()) != null) {
                sb.append(st);
                sb.append("\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        return sb;
    }
    
     public StringBuffer ShowGiaVang() throws IOException{
        StringBuffer sb=new StringBuffer();
        DataInputStream dis=new DataInputStream(url.openStream());
        String st=new String();
        try {
            while ((st = dis.readLine()) != null) {
                if(this.xuLyChuoi(st)!=null){
                    sb.append(this.xuLyChuoi(st));
                sb.append("\n");
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        return sb;
    }
     
     public String xuLyChuoi(String s){
         char nhay=34;
         String x= String.valueOf(nhay);
         String dau="<td width="+x+"38%"+x+" align="+x+"right"+x+" class="+x+"text_tgvang_chitiet"+x+"><strong>";
         String cuoi="</strong>";
         if(s.lastIndexOf(dau)>-1){
                 s=s.substring(s.lastIndexOf(dau)+dau.length());
                 s=s.substring(0,s.indexOf(cuoi));
                 return s;
         }
         dau="<td width="+x+"25%"+x+" align="+x+"right"+x+" class="+x+"text_tgvang_chitiet"+x+">";
         cuoi="</td>";
         if(s.lastIndexOf(dau)>-1){
                 s=s.substring(s.lastIndexOf(dau)+dau.length());
                 s=s.substring(0,s.indexOf(cuoi));
                 return s;
         }

         dau="<td width="+x+"28%"+x+" align="+x+"right"+x+" class="+x+"text_tgvang_chitiet"+x+">";
         cuoi="&nbsp;";
         if(s.lastIndexOf(dau)>-1){
                 s=s.substring(s.lastIndexOf(dau)+dau.length());
                 s=s.substring(0,s.indexOf(cuoi));
                 return s;
         }
         return null;
     }

      public String[][] ArrShowGiaVang(){
        String[][] sb=new String[13][3];
        DataInputStream dis=null;
        try {
            dis = new DataInputStream(url.openStream());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        if(dis==null){
            sb[0][0]="Not connect Internet!";
            return sb;
        }
        String st=new String();
        int i=0;
        try {
            while ((st = dis.readLine()) != null) {
                if(this.xuLyChuoi(st)!=null){
                    sb[i/3][i%3]=this.xuLyChuoi(st);
                    i++;
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
        return sb;
    }
}
