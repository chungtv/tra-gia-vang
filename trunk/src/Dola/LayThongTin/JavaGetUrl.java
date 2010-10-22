package Dola.LayThongTin;

//------------------------------------------------------------//
//  JavaGetUrl.java:                                          //


import java.io.*;
import java.net.*;

public class JavaGetUrl {

    public JavaGetUrl()
    {

    }
   public void taoFileXML (String tenFile,String url) {

      //-----------------------------------------------------//
      //  Step 1:  Start creating a few objects we'll need.
      //-----------------------------------------------------//

      URL u;
      InputStream is = null;
      DataInputStream dis;
      BufferedReader br;
      String s;

      try {

         //------------------------------------------------------------//
         // Step 2:  Create the URL.                                   //
         //------------------------------------------------------------//
         // Note: Put your real URL here, or better yet, read it as a  //
         // command-line arg, or read it from a file.                  //
         //------------------------------------------------------------//

         u = new URL(url);

         //----------------------------------------------//
         // Step 3:  Open an input stream from the url.  //
         //----------------------------------------------//

         is = u.openStream();         // throws an IOException

         //-------------------------------------------------------------//
         // Step 4:                                                     //
         //-------------------------------------------------------------//
         // Convert the InputStream to a buffered DataInputStream.      //
         // Buffering the stream makes the reading faster; the          //
         // readLine() method of the DataInputStream makes the reading  //
         // easier.                                                     //
         //-------------------------------------------------------------//

         dis = new DataInputStream(new BufferedInputStream(is));
	 br=new BufferedReader(new InputStreamReader(dis,"utf-8"));
         //------------------------------------------------------------//
         // Step 5:                                                    //
         //------------------------------------------------------------//
         // Now just read each record of the input stream, and print   //
         // it out.  Note that it's assumed that this problem is run   //
         // from a command-line, not from an application or applet.    //
         //------------------------------------------------------------//
	FileOutputStream fos=new FileOutputStream(tenFile);
	DataOutputStream dos=new DataOutputStream(fos);
	BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(dos,"utf-8"));
	boolean flag=false;
        while ((s = br.readLine()) != null) {
        	if(s.trim().startsWith("<table"))
        			flag = true;
        	if(flag)
        	{
            	System.out.println(s);
            	bw.write(s+"\n");
				bw.flush();
        	}
        	if(s.trim().startsWith("</table"))
        	{
        		break;
        	}
        }

      }	catch (MalformedURLException mue) {

         System.out.println("Ouch - a MalformedURLException happened.");
         mue.printStackTrace();
         System.exit(1);

      } catch (IOException ioe) {

         System.out.println("Oops- an IOException happened.");
         ioe.printStackTrace();
         System.exit(1);

      } finally {

         //---------------------------------//
         // Step 6:  Close the InputStream  //
         //---------------------------------//

         try {
            is.close();
         } catch (IOException ioe) {
            // just going to ignore this one
         }

      } // end of 'finally' clause


   }

   	

} // end of class definitio