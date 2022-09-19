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
public class DanhMucKhuyenMai {
    private String SoHopDongThuePhong;
    private String MaChuongTrinhKhuyenMai;
    private String LoaiKhuyenMai;
    private String NgayKhuyenMai;
    private String NoiDunngKhuyenMai;
    private int GiamGia; 

    public DanhMucKhuyenMai() {
        this.SoHopDongThuePhong = "";
        this.MaChuongTrinhKhuyenMai = "";
        this.LoaiKhuyenMai = "";
        this.NgayKhuyenMai = "";
        this.NoiDunngKhuyenMai = "";
        this.GiamGia = 0;
    }

    public String getSoHopDongThuePhong() {
        return SoHopDongThuePhong;
    }

    public void setSoHopDongThuePhong(String SoHopDongThuePhong) {
        this.SoHopDongThuePhong = SoHopDongThuePhong;
    }

    public String getMaChuongTrinhKhuyenMai() {
        return MaChuongTrinhKhuyenMai;
    }

    public void setMaChuongTrinhKhuyenMai(String MaChuongTrinhKhuyenMai) {
        this.MaChuongTrinhKhuyenMai = MaChuongTrinhKhuyenMai;
    }

    public String getLoaiKhuyenMai() {
        return LoaiKhuyenMai;
    }

    public void setLoaiKhuyenMai(String LoaiKhuyenMai) {
        this.LoaiKhuyenMai = LoaiKhuyenMai;
    }

    public String getNgayKhuyenMai() {
        return NgayKhuyenMai;
    }

    public void setNgayKhuyenMai(String NgayKhuyenMai) {
        this.NgayKhuyenMai = NgayKhuyenMai;
    }
    
    public boolean setNgayKhuyenMaiKT(String NgayKhuyenMai, String ThoiGianBatDau, String ThoiGianKetThuc) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        formatter.setLenient(false);
        try {
            Date nkm = formatter.parse(NgayKhuyenMai);
            Date bd = formatter.parse(ThoiGianBatDau);
            Date kt = formatter.parse(ThoiGianKetThuc);
            if(nkm.before(bd)){
                JOptionPane.showMessageDialog(null, "Khuyến mãi chưa bắt đầu");
                return false;
            }
            if(nkm.after(kt)){
                JOptionPane.showMessageDialog(null, "Khuyến mãi đã kết thúc");
                return false;
            }
            this.NgayKhuyenMai = NgayKhuyenMai;
            return true;
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Ngày khuyến mãi YYYY-MM-DD");
            return false;
        }
    }

    public String getNoiDunngKhuyenMai() {
        return NoiDunngKhuyenMai;
    }

    public void setNoiDunngKhuyenMai(String NoiDunngKhuyenMai) {
        this.NoiDunngKhuyenMai = NoiDunngKhuyenMai;
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
}
