package qlks.GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class MENUFORM extends javax.swing.JFrame {
    static JPanel jchild;
    static ArrayList<JButton> bt = new ArrayList<>();
    
    
    //Cac bien static
    static String dlMaKhachHang = "";
    static boolean khMaKhachHang = false;
    static boolean pMaKhachHang = false;
    static String maNhanVien = "";
    static boolean dongUngDung = false;
    
    public MENUFORM() {
        initComponents();
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        bt.add(btNhanVien);
        bt.add(btKhachHang);
        bt.add(btDVKM);
        bt.add(btPhong);
        bt.add(btHoaDon);
        bt.add(btNhapHang);
        bt.add(btThongKe);
        bt.add(btTaiKhoan);
        
        //Quyen
        if(maNhanVien.compareTo("000")==0){
            btNhanVien.setEnabled(true);
        }else{
            btNhanVien.setEnabled(false);
        }       
        
        //Dong ho
        SimpleDateFormat sdfNgay = new SimpleDateFormat("dd-MM-yyyy");
        SimpleDateFormat sdfDongHo = new SimpleDateFormat("hh:mm:ss");
        lbNgay.setText(sdfNgay.format(new Date()));
        Timer time = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lbDongHo.setText(sdfDongHo.format(new Date()));
                if(dongUngDung){
                    dongUngDung = false;
                    dispose();
                }
            }
        });
        time.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jPanel2 = new javax.swing.JPanel();
        btNhanVien = new javax.swing.JButton();
        btKhachHang = new javax.swing.JButton();
        btDVKM = new javax.swing.JButton();
        btPhong = new javax.swing.JButton();
        btHoaDon = new javax.swing.JButton();
        btNhapHang = new javax.swing.JButton();
        btTaiKhoan = new javax.swing.JButton();
        btThongKe = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanelChane = new javax.swing.JPanel();
        lbNgay = new javax.swing.JLabel();
        lbDongHo = new javax.swing.JLabel();
        jLabelAnhnen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(86, 60, 98));

        jDesktopPane1.setBackground(new java.awt.Color(204, 204, 204));

        btNhanVien.setBackground(new java.awt.Color(255, 255, 255));
        btNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlks/hinh/enploy.png"))); // NOI18N
        btNhanVien.setText("Nhân Viên                           ");
        btNhanVien.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(255, 51, 102), null, null));
        btNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNhanVienActionPerformed(evt);
            }
        });

        btKhachHang.setBackground(new java.awt.Color(255, 255, 255));
        btKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlks/hinh/Khachhang.png"))); // NOI18N
        btKhachHang.setText("Khách Hàng                         ");
        btKhachHang.setAlignmentX(0.1F);
        btKhachHang.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(255, 51, 102), null, null));
        btKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btKhachHangActionPerformed(evt);
            }
        });

        btDVKM.setBackground(new java.awt.Color(255, 255, 255));
        btDVKM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlks/hinh/DV.png"))); // NOI18N
        btDVKM.setText("Dịch Vụ - Khuyến mãi             ");
        btDVKM.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(255, 51, 102), null, null));
        btDVKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDVKMActionPerformed(evt);
            }
        });

        btPhong.setBackground(new java.awt.Color(255, 255, 255));
        btPhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlks/hinh/p.png"))); // NOI18N
        btPhong.setText("Phòng                                    ");
        btPhong.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(255, 51, 102), null, null));
        btPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPhongActionPerformed(evt);
            }
        });

        btHoaDon.setBackground(new java.awt.Color(255, 255, 255));
        btHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlks/hinh/nhaphang.jpg"))); // NOI18N
        btHoaDon.setText("Hóa đơn                                 ");
        btHoaDon.setToolTipText("");
        btHoaDon.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(255, 51, 102), null, null));
        btHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btHoaDonActionPerformed(evt);
            }
        });

        btNhapHang.setBackground(new java.awt.Color(255, 255, 255));
        btNhapHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlks/hinh/nhap.png"))); // NOI18N
        btNhapHang.setText("Nhập hàng                             ");
        btNhapHang.setToolTipText("");
        btNhapHang.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(255, 0, 102), null, null));
        btNhapHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNhapHangActionPerformed(evt);
            }
        });

        btTaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlks/hinh/icon3.png"))); // NOI18N
        btTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTaiKhoanActionPerformed(evt);
            }
        });

        btThongKe.setBackground(new java.awt.Color(255, 255, 255));
        btThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlks/hinh/seo-report (1).png"))); // NOI18N
        btThongKe.setText("Thống kê");
        btThongKe.setToolTipText("");
        btThongKe.setActionCommand("Thống kê                                        ");
        btThongKe.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(255, 0, 102), null, null));
        btThongKe.setHideActionText(true);
        btThongKe.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThongKeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btKhachHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btDVKM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btNhapHang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btTaiKhoan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(btTaiKhoan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btNhanVien)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btKhachHang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btDVKM, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btPhong)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btNhapHang, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("QUẢN LÝ KHÁCH SẠN");

        jPanelChane.setBackground(new java.awt.Color(102, 102, 255));
        jPanelChane.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jPanelChanePropertyChange(evt);
            }
        });
        jPanelChane.setLayout(new java.awt.BorderLayout());

        lbNgay.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbNgay.setForeground(new java.awt.Color(255, 204, 0));
        lbNgay.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbNgay.setText("Date");

        lbDongHo.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        lbDongHo.setForeground(new java.awt.Color(255, 204, 0));
        lbDongHo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDongHo.setText("Time");

        jLabelAnhnen.setBackground(new java.awt.Color(204, 204, 204));
        jLabelAnhnen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/qlks/hinh/2020-04-05.jpg"))); // NOI18N
        jLabelAnhnen.setMaximumSize(new java.awt.Dimension(1080, 619));
        jLabelAnhnen.setMinimumSize(new java.awt.Dimension(1080, 619));
        jLabelAnhnen.setPreferredSize(new java.awt.Dimension(1080, 619));

        jDesktopPane1.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jPanelChane, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lbNgay, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(lbDongHo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPane1.setLayer(jLabelAnhnen, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanelChane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelAnhnen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbDongHo, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(82, 82, 82)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jDesktopPane1Layout.createSequentialGroup()
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1)
                                    .addComponent(lbDongHo))))
                        .addGap(18, 18, 18)
                        .addGroup(jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanelChane, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                                .addComponent(jLabelAnhnen, javax.swing.GroupLayout.PREFERRED_SIZE, 609, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        jDesktopPane1.getAccessibleContext().setAccessibleParent(this);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNhanVienActionPerformed

        formatButton(0);
    }//GEN-LAST:event_btNhanVienActionPerformed
    
    private void btKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btKhachHangActionPerformed

        formatButton(1);
    }//GEN-LAST:event_btKhachHangActionPerformed

    private void btPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPhongActionPerformed

        formatButton(3);
    }//GEN-LAST:event_btPhongActionPerformed

    private void btHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btHoaDonActionPerformed

        formatButton(4);
    }//GEN-LAST:event_btHoaDonActionPerformed

    private void btNhapHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNhapHangActionPerformed

        formatButton(5);
    }//GEN-LAST:event_btNhapHangActionPerformed

    private void btDVKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDVKMActionPerformed

        formatButton(2);
    }//GEN-LAST:event_btDVKMActionPerformed

    private void jPanelChanePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jPanelChanePropertyChange
        
    }//GEN-LAST:event_jPanelChanePropertyChange

    private void btThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThongKeActionPerformed

        formatButton(6);
    }//GEN-LAST:event_btThongKeActionPerformed

    private void btTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTaiKhoanActionPerformed
        formatButton(7);
    }//GEN-LAST:event_btTaiKhoanActionPerformed

    /**
     * @param args the command line arguments
     */
    
    static void formatButton(int index){
        for(int i=0;i<bt.size();i++){
            bt.get(i).setBackground(Color.WHITE);
        }
        bt.get(index).setBackground(Color.YELLOW);
        switch(index){
            case 0: jchild = new nhanvien(); break;
            case 1: jchild = new khachhang(); break;
            case 2: jchild = new dichvu(); break;
            case 3: jchild = new phong(); break;
            case 4: jchild = new hoadon(); break;
            case 5: jchild = new nhaphang(); break;
            case 6: jchild = new thongke(); break;
            case 7: jchild = new TaiKhoan();break;
        }
        jPanelChane.removeAll();
        jPanelChane.add(jchild);
        jPanelChane.validate();
    }
    
    public static void main(String args[]) {
        
        
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MENUFORM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MENUFORM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MENUFORM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MENUFORM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MENUFORM().setVisible(true);
                

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    static javax.swing.JButton btDVKM;
    static javax.swing.JButton btHoaDon;
    static javax.swing.JButton btKhachHang;
    static javax.swing.JButton btNhanVien;
    static javax.swing.JButton btNhapHang;
    static javax.swing.JButton btPhong;
    private javax.swing.JButton btTaiKhoan;
    static javax.swing.JButton btThongKe;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelAnhnen;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    static javax.swing.JPanel jPanelChane;
    private javax.swing.JLabel lbDongHo;
    private javax.swing.JLabel lbNgay;
    // End of variables declaration//GEN-END:variables
}
