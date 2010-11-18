/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Dola.PhanTich;

/**
 *
 * @author WELLCOME
 */


import javax.xml.parsers.*;
import org.w3c.dom.*;
import java.io.File;

class DOMUtil
{
   public static Element getFirstElement( Element element, String name ) {
      NodeList nl = element.getElementsByTagName( name );
      if ( nl.getLength() < 1 )
         throw new RuntimeException(
            "Element: "+element+" does not contain: "+name);
      return (Element)nl.item(0);
   }

   public static String getSimpleElementText( Element node, String name )
   {
      Element namedElement = getFirstElement( node, name );
      return getSimpleElementText( namedElement );
   }

   public static String getSimpleElementText( Element node )
   {
      StringBuilder sb = new StringBuilder();
      NodeList children = node.getChildNodes();
      for(int i=0; i<children.getLength(); i++) {
         Node child = children.item(i);
         if ( child instanceof Text )
            sb.append( child.getNodeValue() );
      }
      return sb.toString();
   }
}
public class PhanTichFile
{
   public java.util.ArrayList parserFileDola( ) throws Exception
   {
   	  java.util.ArrayList values = new  java.util.ArrayList();
   	  File f = new File("Data\\file.xml");
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

      DocumentBuilder parser = factory.newDocumentBuilder();
      Document document = parser.parse( f );
      Element table = document.getDocumentElement();
      NodeList tr = table.getElementsByTagName("tr");
      for( int i=1; i<tr.getLength(); i++ ) {
		   NodeList td = ((Element)tr.item(i)).getElementsByTagName("td");
      	   for(int j=0; j<td.getLength(); j++)
           		values.add(DOMUtil.getSimpleElementText( (Element)td.item(j) ) .trim());

      }
      return values;

   }
}
