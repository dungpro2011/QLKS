/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlks.GUI;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;
import java.awt.Graphics2D;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import qlks.BUS.HoaDonBUS;
import qlks.BUS.HopDongThuePhongBUS;
import qlks.BUS.PhongBUS;
import qlks.DTO.HoaDon;
import qlks.DTO.HoaDonDTO;
import qlks.DTO.HopDongThuePhong;
import qlks.DTO.HopDongThuePhongDTO;
import qlks.DTO.Phong;
import qlks.DTO.PhongDTO;
import qlks.Model.ModelPhong;

/**
 *
 * @author admin
 */
public class PhieuThanhToan extends javax.swing.JFrame {
    private Date date = new Date();
    private HoaDon hd;
    private HoaDonBUS hdBUS;
    private HoaDonDTO hdDTO;
    int shd = 0;
    int khuyenMaiPhong = 0;
    int khuyenMaiDichVu = 0;
    int thuePhanTram = 0;
    
    //Cac bien static
    static String pSoHopDong = "";
    static String pMaNhanVien = "";
    static int pPhong = 0;
    static int pDichVu = 0;
    int pThue = 0;
    static int pKhuyenMaiPhong = 0;
    static int pKhuyenMaiDichVu = 0;
    int pTong = 0;
    int tongTien = 0;
    /**
     * Creates new form PhieuThanhToan
     */
    public PhieuThanhToan() {
        initComponents();
        
        this.setLocationRelativeTo(null);
        
        HoaDonDTO hdDTO = new HoaDonDTO();
        int sizeHD = hdDTO.docDanhSachHoaDon().size();
        shd = (sizeHD <=0 ? 0 : Integer.valueOf(hdDTO.docDanhSachHoaDon().get(sizeHD-1).getSoHoaDon())+1);
        
        tfHDTTsohoadon.setText(shd+"");
        tfHDTTsohopdong.setText(pSoHopDong);
        tfHDTTmanhanvien.setText(pMaNhanVien);
        tfHDTTphong.setText(pPhong+"");
        tfHDTTdichvu.setText(pDichVu+"");
        
        khuyenMaiPhong = pKhuyenMaiPhong*pPhong/100;
        khuyenMaiDichVu = pKhuyenMaiDichVu*pDichVu/100;
        
        tfHDTTkhuyenmai.setText((khuyenMaiPhong+khuyenMaiDichVu)+"");
        pTong = pPhong+pDichVu-(khuyenMaiPhong+khuyenMaiDichVu);
        
        try{
            thuePhanTram = Integer.parseInt(tfThue.getText());
        }catch(Exception e){
        }
        pThue = pTong*thuePhanTram/100;
        tfHDTTthue.setText(pThue+"");
        
        tongTien = pTong + pThue;
        tfHDTTtong.setText(tongTien+"");
        
        tfHDTTngay.setText(new SimpleDateFormat("yyyy-MM-dd").format(date));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnHD = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfHDTTsohoadon = new javax.swing.JLabel();
        tfHDTTsohopdong = new javax.swing.JLabel();
        tfHDTTmanhanvien = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        tfHDTTphong = new javax.swing.JLabel();
        tfHDTTdichvu = new javax.swing.JLabel();
        tfHDTTthue = new javax.swing.JLabel();
        tfHDTTkhuyenmai = new javax.swing.JLabel();
        tfHDTTtong = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        tfHDTTngay = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btIn = new javax.swing.JButton();
        btPTHHuy = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        tfThue = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        pnHD.setBackground(new java.awt.Color(255, 255, 255));
        pnHD.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("GROUP SEVEN HOTEL");

        jLabel2.setText("Java t5-8910 nhom 7");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("HOA ??ON THANH TOAN");

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("---o0o---");

        jLabel5.setText("So hoa don");

        jLabel6.setText("So hop dong");

        jLabel7.setText("Ma nhan vien");

        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tfHDTTsohoadon.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tfHDTTsohoadon.setText("1");
        tfHDTTsohoadon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        tfHDTTsohopdong.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tfHDTTsohopdong.setText("2");

        tfHDTTmanhanvien.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tfHDTTmanhanvien.setText("3");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel9.setText("Don gia");

        jLabel10.setText("Phong");

        jLabel11.setText("Dich vu");

        jLabel12.setText("Thue");

        jLabel13.setText("Khuyen mai");

        jLabel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel16.setText("Tong");

        tfHDTTphong.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tfHDTTphong.setText("4");

        tfHDTTdichvu.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tfHDTTdichvu.setText("5");

        tfHDTTthue.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tfHDTTthue.setText("6");

        tfHDTTkhuyenmai.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tfHDTTkhuyenmai.setText("7");

        tfHDTTtong.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tfHDTTtong.setText("8");

        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Tran trong cam on quy khach");

        jLabel24.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel17.setText("Ngay");

        tfHDTTngay.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        tfHDTTngay.setText("9");

        javax.swing.GroupLayout pnHDLayout = new javax.swing.GroupLayout(pnHD);
        pnHD.setLayout(pnHDLayout);
        pnHDLayout.setHorizontalGroup(
            pnHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHDLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnHDLayout.createSequentialGroup()
                        .addGroup(pnHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tfHDTTsohoadon, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                            .addComponent(tfHDTTsohopdong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tfHDTTmanhanvien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnHDLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfHDTTthue, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnHDLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfHDTTtong, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnHDLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfHDTTphong, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnHDLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfHDTTdichvu, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnHDLayout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
                        .addComponent(tfHDTTngay, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnHDLayout.createSequentialGroup()
                        .addGroup(pnHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnHDLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tfHDTTkhuyenmai, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnHDLayout.setVerticalGroup(
            pnHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnHDLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(pnHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfHDTTsohoadon))
                .addGap(18, 18, 18)
                .addGroup(pnHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(tfHDTTsohopdong))
                .addGap(18, 18, 18)
                .addGroup(pnHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tfHDTTmanhanvien))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addGap(18, 18, 18)
                .addGroup(pnHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(tfHDTTphong))
                .addGap(18, 18, 18)
                .addGroup(pnHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(tfHDTTdichvu))
                .addGap(18, 18, 18)
                .addGroup(pnHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(tfHDTTkhuyenmai))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(tfHDTTthue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addGroup(pnHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(tfHDTTtong))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel24)
                .addGap(18, 18, 18)
                .addGroup(pnHDLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(tfHDTTngay))
                .addGap(18, 18, 18)
                .addComponent(jLabel23)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        btIn.setText("In");
        btIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btInActionPerformed(evt);
            }
        });

        btPTHHuy.setText("H???y");
        btPTHHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPTHHuyActionPerformed(evt);
            }
        });

        jLabel18.setText("Thu???(%)");

        tfThue.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfThue.setText("1");
        tfThue.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tfThueFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfThueFocusLost(evt);
            }
        });
        tfThue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tfThueMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tfThueMouseExited(evt);
            }
        });
        tfThue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfThueActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addGap(18, 18, 18)
                .addComponent(tfThue, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btPTHHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btIn, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btIn)
                    .addComponent(btPTHHuy)
                    .addComponent(jLabel18)
                    .addComponent(tfThue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(pnHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setBounds(0, 0, 411, 658);
    }// </editor-fold>//GEN-END:initComponents

    private void btPTHHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPTHHuyActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btPTHHuyActionPerformed

    private void btInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btInActionPerformed
 
        //print the panel to pdf
        Document document = new Document();
        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D:/QLKS/HD"+shd+".pdf"));
            document.open();
            PdfContentByte contentByte = writer.getDirectContent();
            PdfTemplate template = contentByte.createTemplate(400, 700);
            Graphics2D g2 = template.createGraphics(400, 700);
            Font font = new Font("Verdana", Font.PLAIN, 24); 
            pnHD.print(g2);
            g2.dispose();
            contentByte.addTemplate(template, 90, 100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            if(document.isOpen()){
                document.close();
            }
        }
        
        // Them hoa don moi
        hd = new HoaDon();
        hd.setSoHoaDon(tfHDTTsohoadon.getText());
        hd.setSoHopDongThuePhong(tfHDTTsohopdong.getText());
        hd.setMaNhanVien(tfHDTTmanhanvien.getText());
        hd.setNgayThanhToan(new SimpleDateFormat("yyyy-MM-dd").format(date));
        hd.setTienThuePhong(Integer.valueOf(tfHDTTphong.getText()));
        hd.setTienDichVu(Integer.valueOf(tfHDTTdichvu.getText()));
        hd.setTienKhuyenMai(Integer.valueOf(tfHDTTkhuyenmai.getText()));
        hd.setThue(Integer.valueOf(tfHDTTthue.getText()));
        hd.setTongTien(Integer.valueOf(tfHDTTtong.getText()));
        
        hdBUS = new HoaDonBUS();
        hdDTO = new HoaDonDTO();
        hdBUS.themHoaDon(hdDTO, hd);
        
                HopDongThuePhongDTO hdtpDTO = phong.hdpDTO;
                HopDongThuePhong hdtp = null;
                for(HopDongThuePhong hdtpt: hdtpDTO.docDanhSachHopDongThuePhong()){
                    if(hd.getSoHopDongThuePhong().compareTo(hdtpt.getSoHopDongThuePhong())==0){
                        hdtp = hdtpt;
                        break;
                    }
                }
                
                hdtp.setTrangThai("???? thanh to??n");
                HopDongThuePhongBUS hdtpBUS = new HopDongThuePhongBUS();
                hdtpBUS.suaHopDongThuePhongTuHoaDon(hdtp);
                hdtpDTO.suaHopDongThuePhong(hdtp);
                
                PhongDTO pDTO = phong.pDTO;
                Phong p = null;
                for(Phong pt: pDTO.docDanhSachPhong()){
                    if(pt.getMaPhong().compareTo(hdtp.getMaPhong())==0){
                        p = pt;
                        break;
                    }
                }
                p.setTinhTrang("Tr???ng");
                PhongBUS pBUS = new PhongBUS();
                pBUS.suaPhongTuHoaDon(p);
                pDTO.suaPhong(p);
                
                phong.tbP.setModel(new ModelPhong(phong.pDTO.docDanhSachPhong()).getModel());
                
        this.setVisible(false);

    }//GEN-LAST:event_btInActionPerformed

    private void tfThueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfThueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfThueActionPerformed

    private void tfThueFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfThueFocusLost
        try{
            thuePhanTram = Integer.parseInt(tfThue.getText());
            
            pThue = pTong*thuePhanTram/100;
            tfHDTTthue.setText(pThue+"");

            tongTien = pTong + pThue;
            tfHDTTtong.setText(tongTien+"");
        }catch(Exception e){
            thuePhanTram = 0;
            
            pThue = pTong*thuePhanTram/100;
            tfHDTTthue.setText(pThue+"");

            tongTien = pTong + pThue;
            tfHDTTtong.setText(tongTien+"");
        }
    }//GEN-LAST:event_tfThueFocusLost

    private void tfThueFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfThueFocusGained

    }//GEN-LAST:event_tfThueFocusGained

    private void tfThueMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfThueMouseExited
        try{
            thuePhanTram = Integer.parseInt(tfThue.getText());
            
            pThue = pTong*thuePhanTram/100;
            tfHDTTthue.setText(pThue+"");

            tongTien = pTong + pThue;
            tfHDTTtong.setText(tongTien+"");
        }catch(Exception e){
            thuePhanTram = 0;
            
            pThue = pTong*thuePhanTram/100;
            tfHDTTthue.setText(pThue+"");

            tongTien = pTong + pThue;
            tfHDTTtong.setText(tongTien+"");
        }
    }//GEN-LAST:event_tfThueMouseExited

    private void tfThueMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tfThueMouseEntered
        try{
            thuePhanTram = Integer.parseInt(tfThue.getText());
            
            pThue = pTong*thuePhanTram/100;
            tfHDTTthue.setText(pThue+"");

            tongTien = pTong + pThue;
            tfHDTTtong.setText(tongTien+"");
        }catch(Exception e){
            thuePhanTram = 0;
            
            pThue = pTong*thuePhanTram/100;
            tfHDTTthue.setText(pThue+"");

            tongTien = pTong + pThue;
            tfHDTTtong.setText(tongTien+"");
        }
    }//GEN-LAST:event_tfThueMouseEntered

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(PhieuThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PhieuThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PhieuThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PhieuThanhToan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PhieuThanhToan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btIn;
    private javax.swing.JButton btPTHHuy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel pnHD;
    private javax.swing.JLabel tfHDTTdichvu;
    private javax.swing.JLabel tfHDTTkhuyenmai;
    private javax.swing.JLabel tfHDTTmanhanvien;
    private javax.swing.JLabel tfHDTTngay;
    private javax.swing.JLabel tfHDTTphong;
    private javax.swing.JLabel tfHDTTsohoadon;
    private javax.swing.JLabel tfHDTTsohopdong;
    private javax.swing.JLabel tfHDTTthue;
    private javax.swing.JLabel tfHDTTtong;
    private javax.swing.JTextField tfThue;
    // End of variables declaration//GEN-END:variables
}
