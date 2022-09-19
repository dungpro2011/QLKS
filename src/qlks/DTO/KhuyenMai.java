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
public class KhuyenMai {
    private String MaChuongTrinhKhuyenMai;
    private String TenChuongTrinhKhuyenMai;
    private String ThoiGianBatDau;
    private String THoiGianKetThuc;
    private int GiamGia;
    private boolean Xoa;

    public KhuyenMai() {
        this.MaChuongTrinhKhuyenMai = "";
        this.TenChuongTrinhKhuyenMai = "";
        this.ThoiGianBatDau = "";
        this.THoiGianKetThuc = "";
        this.GiamGia = 0;
        this.Xoa = false;
    }

    public String getMaChuongTrinhKhuyenMai() {
        return MaChuongTrinhKhuyenMai;
    }

    public void setMaChuongTrinhKhuyenMai(String MaChuongTrinhKhuyenMai) {
        this.MaChuongTrinhKhuyenMai = MaChuongTrinhKhuyenMai;
    }

    public String getTenChuongTrinhKhuyenMai() {
        return TenChuongTrinhKhuyenMai;
    }

    public void setTenChuongTrinhKhuyenMai(String TenChuongTrinhKhuyenMai) {
        this.TenChuongTrinhKhuyenMai = TenChuongTrinhKhuyenMai;
    }

    public String getThoiGianBatDau() {
        return ThoiGianBatDau;
    }

    public void setThoiGianBatDau(String ThoiGianBatDau) {
        this.ThoiGianBatDau = ThoiGianBatDau;
    }
    
    public boolean setThoiGianBatDauKT(String ThoiGianBatDau) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        formatter.setLenient(false);
        try {
            formatter.parse(ThoiGianBatDau);
            this.ThoiGianBatDau = ThoiGianBatDau;
            return true;
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Thời gian bắt đầu YYYY-MM-DD");
            return false;
        }
    }

    public String getTHoiGianKetThuc() {
        return THoiGianKetThuc;
    }

    public void setTHoiGianKetThuc(String THoiGianKetThuc) {
        this.THoiGianKetThuc = THoiGianKetThuc;
    }
    
    public boolean setTHoiGianKetThucKT(String THoiGianKetThuc, String ThoiGianBatDau) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        formatter.setLenient(false);
        try {
            Date kt = formatter.parse(THoiGianKetThuc);
            Date bd = formatter.parse(ThoiGianBatDau);
            if(bd.after(kt)){
                JOptionPane.showMessageDialog(null, "Kiểm tra lại thời gian bắt đầu và kết thúc");
                return false;
            }
            
            this.THoiGianKetThuc = THoiGianKetThuc;
            return true;
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Thời gian kết thúc YYYY-MM-DD");
            return false;
        }
    }

    public int getGiamGia() {
        return GiamGia;
    }

    public void setGiamGia(int GiamGia) {
        this.GiamGia = GiamGia;
    }

    public boolean setGiamGia(String GiamGia) {
        try{
            this.GiamGia = Integer.parseInt(GiamGia);
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Giảm giá là số");
            return false;
        }
    }
    
    public boolean isXoa() {
        return Xoa;
    }

    public void setXoa(boolean Xoa) {
        this.Xoa = Xoa;
    }
    
    
}
