
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import Dola.PhanTich.GiaDoLa;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JfrMain.java
 *
 * Created on Oct 20, 2010, 6:34:38 PM
 */

/**
 *
 * @author nvnamsh
 */
public class JfrMain extends javax.swing.JFrame {

    /** Creates new form JfrMain */
    public JfrMain() {
         try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");

            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");

            } catch (Exception e) {
            e.printStackTrace();
            }
        initComponents();
        url=new claUrl("http://www.sjc.com.vn/ajax_vang.php");
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("Tra Gia Vang Va Gia NGoai Te"); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridLayout());

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "NGUỒN CTY SJC VIỆT NAM", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Khu Vực", "Loại Vàng", "Giá Bán", "Giá Mua"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tỉ Giá Ngoại Tệ Nguồn NH-Ngoại Thương", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã", "Tên Ngoại tệ", "Mua tiền mặt", "Mua chuyển khoản", "Bán"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);
        jTable2.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTable2.getColumnModel().getColumn(1).setPreferredWidth(120);
        jTable2.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTable2.getColumnModel().getColumn(3).setPreferredWidth(100);
        jTable2.getColumnModel().getColumn(4).setPreferredWidth(100);

        getContentPane().add(jScrollPane2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            // TODO add your handling code here:
            this.getInfor();
            this.getInfor1();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        tgv=new ThreadGiaVang(this);
        tgv.start();
        server = new UDPSC();
        server.start();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        tgv.stop();
    }//GEN-LAST:event_formWindowClosing

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JfrMain().setVisible(true);
            }
        });
    }
    //xuat thong tin vao table
        public void getInfor() throws IOException{
            String[][] sb=url.ArrShowGiaVang();
            DefaultTableModel mode = new javax.swing.table.DefaultTableModel(
                    new Object [][] {

                    },
                    new String [] {
                        "Khu Vực", "Loại Vàng", "Giá Bán", "Giá Mua"
                    }
                );
            jTable1.setModel(mode);

            for (int i=0;i<9;i++)
                mode.addRow(new Object[]{"TPHCM",sb[i][0],sb[i][1],sb[i][2]});
            mode.addRow(new Object[]{"Hà Nội",sb[9][0],sb[9][1],sb[9][2]});
            mode.addRow(new Object[]{"Đà Nẵng",sb[10][0],sb[10][1],sb[10][2]});
            mode.addRow(new Object[]{"Nha Trang",sb[11][0],sb[11][1],sb[11][2]});
            mode.addRow(new Object[]{"Cần Thơ",sb[12][0],sb[12][1],sb[12][2]});

        }
        public void getInfor1() throws IOException, Exception{
             //System.out.println("haiaoa");
            GiaDoLa dola = new GiaDoLa();
            ArrayList a = dola.layGiaDoLa();
            Object[][] obj = new Object[dola.size()][5];
            obj[0][0]=a.get(0);
            for(int i=0;i<dola.size();++i)
                for(int j=0;j<5;++j)
                {
                    System.out.println("haiaoabgggggggggggggggggg");
                    obj[i][j]= a.get(i*5+j);
                    //System.out.println(a.get(i*5+j));
                }
            jTable2.setModel(new javax.swing.table.DefaultTableModel(
            obj,
            new String [] {
                "Mã", "Tên Ngoại tệ", "Mua tiền mặt", "Mua chuyển khoản", "Bán"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });


    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
    private claUrl url;
    private ThreadGiaVang tgv;
    private UDPSC server;
}
