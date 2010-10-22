/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Dola.PhanTich;
import Dola.LayThongTin.JavaGetUrl;
import java.util.ArrayList;
/**
 *
 * @author WELLCOME
 */
public class GiaDoLa {

    public GiaDoLa() throws Exception
    {
        JavaGetUrl tao = new JavaGetUrl();
        tao.taoFileXML("Data\\file.xml", "http://www.vietcombank.com.vn/ExchangeRates");
        PhanTichFile phanTich = new PhanTichFile();
        giaDoLa = phanTich.parserFileDola();
    }
    public ArrayList layGiaDoLa()
    {

        return giaDoLa;
    }
    public int size()
    {
        //
        return giaDoLa.size()/5;
    }
    // biến giaDoLa chứa mã ,tên ,giá bán,mua tiền mặt ,mua chuyển khoản ,bán
    // của các loại ngoại tệ
    private ArrayList giaDoLa;


}
