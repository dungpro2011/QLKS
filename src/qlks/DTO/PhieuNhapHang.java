/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlks.DTO;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class PhieuNhapHang {
    private String MaPhieuNhapHang;
    private String MaNhanVien;
    private String NgayNhapHang;
    private String NhaCungCap;
    private int TongTien;

    public PhieuNhapHang() {
        this.MaPhieuNhapHang = "";
        this.MaNhanVien = "";
        this.NgayNhapHang = "";
        this.NhaCungCap = "";
        this.TongTien = 0;
    }

    public String getMaPhieuNhapHang() {
        return MaPhieuNhapHang;
    }

    public void setMaPhieuNhapHang(String MaPhieuNhapHang) {
        this.MaPhieuNhapHang = MaPhieuNhapHang;
    }

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public String getNgayNhapHang() {
        return NgayNhapHang;
    }

    public void setNgayNhapHang(String NgayNhapHang) {
        this.NgayNhapHang = NgayNhapHang;
    }
    
    public boolean setNgayNhapHangKT(String NgayNhapHang) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        formatter.setLenient(false);
        try {
            formatter.parse(NgayNhapHang);
            this.NgayNhapHang = NgayNhapHang;
            return true;
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Ngày nhập hàng YYYY-MM-DD");
            return false;
        }
    }

    public String getNhaCungCap() {
        return NhaCungCap;
    }

    public void setNhaCungCap(String NhaCungCap) {
        this.NhaCungCap = NhaCungCap;
    }

    public int getTongTien() {
        return TongTien;
    }

    public void setTongTien(int TongTien) {
        this.TongTien = TongTien;
    }
    
    public boolean setTongTien(String TongTien) {
        try{
            this.TongTien = Integer.parseInt(TongTien);
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Tổng tiền là số");
            return false;
        }
    }
}
