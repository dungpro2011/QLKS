/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlks.DTO;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class HopDongThuePhong {
    private String SoHopDongThuePhong;
    private String MaNhanVien;
    private String MaPhong;
    private String MaKhachHang;
    private int TienPhong;
    private String NgayThue;
    private String NgayTra;
    private String TrangThai;
    private String GhiChu;
    private boolean Xoa;

    public HopDongThuePhong() {
        this.SoHopDongThuePhong = "";
        this.MaNhanVien = "";
        this.MaPhong = "";
        this.MaKhachHang = "";
        this.TienPhong = 0;
        this.NgayThue = "";
        this.NgayTra = "";
        this.TrangThai = "";
        this.GhiChu = "";
        this.Xoa = false;
    }

    public String getSoHopDongThuePhong() {
        return SoHopDongThuePhong;
    }

    public void setSoHopDongThuePhong(String SoHopDongThuePhong) {
        this.SoHopDongThuePhong = SoHopDongThuePhong;
    }
    
    public boolean setSoHopDongThuePhongKT(String SoHopDongThuePhong) {
        try{
            Integer.parseInt(SoHopDongThuePhong);
            this.SoHopDongThuePhong = SoHopDongThuePhong;
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Số hợp đồng là số");
            return false;
        }
    }

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public String getMaPhong() {
        return MaPhong;
    }

    public void setMaPhong(String MaPhong) {
        this.MaPhong = MaPhong;
    }

    public String getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(String MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

    public int getTienPhong() {
        return TienPhong;
    }

    public void setTienPhong(int TienPhong) {
        this.TienPhong = TienPhong;
    }
    
    public boolean setTienPhong(String TienPhong) {
        try{
            this.TienPhong = Integer.parseInt(TienPhong);
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Tiền phòng là số");
            return false;
        }
    }

    public String getNgayThue() {
        return NgayThue;
    }

    public void setNgayThue(String NgayThue) {
        this.NgayThue = NgayThue;
    }
    
    public boolean setNgayThueKT(String NgayThue) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        formatter.setLenient(false);
        try {
            formatter.parse(NgayThue);
            this.NgayThue = NgayThue;
            return true;
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Nhập ngày thuê YYYY-MM-DD");
            return false;
        }
    }

    public String getNgayTra() {
        return NgayTra;
    }

    public void setNgayTra(String NgayTra) {
        this.NgayTra = NgayTra;
    }
    
    public boolean setNgayTraKT(String NgayTra, String NgayThue) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        formatter.setLenient(false);
        try {
            Date ngayTra = formatter.parse(NgayTra);
            Date ngayThue = formatter.parse(NgayThue);
            if(ngayTra.before(ngayThue)){
                JOptionPane.showMessageDialog(null, "Ngày trả sau ngày thuê");
                return false;
            }
            this.NgayTra = NgayTra;
            return true;
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Nhập ngày trả YYYY-MM-DD");
            return false;
        }
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public boolean isXoa() {
        return Xoa;
    }

    public void setXoa(boolean Xoa) {
        this.Xoa = Xoa;
    }
    
    
}
