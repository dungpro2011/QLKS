/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlks.DTO;

import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class LoaiPhong {
    private String MaLoaiPhong;
    private String TenLoaiPhong;
    private int SoNguoi;
    private int GiaTien;

    public LoaiPhong() {
        this.MaLoaiPhong = "";
        this.TenLoaiPhong = "";
        this.SoNguoi = 0;
        this.GiaTien = 0;
    }

    public String getMaLoaiPhong() {
        return MaLoaiPhong;
    }

    public void setMaLoaiPhong(String MaLoaiPhong) {
        this.MaLoaiPhong = MaLoaiPhong;
    }

    public String getTenLoaiPhong() {
        return TenLoaiPhong;
    }

    public void setTenLoaiPhong(String TenLoaiPhong) {
        this.TenLoaiPhong = TenLoaiPhong;
    }

    public int getSoNguoi() {
        return SoNguoi;
    }

    public void setSoNguoi(int SoNguoi) {
        this.SoNguoi = SoNguoi;
    }
    
    public boolean setSoNguoi(String SoNguoi) {
        try{
            this.SoNguoi = Integer.parseInt(SoNguoi);
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Số người là số");
            return false;
        }
    }

    public int getGiaTien() {
        return GiaTien;
    }

    public void setGiaTien(int GiaTien) {
        this.GiaTien = GiaTien;
    }
    
    public boolean setGiaTien(String GiaTien) {
        try{
            this.GiaTien = Integer.parseInt(GiaTien);
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Giá tiền là số");
            return false;
        }
    }
}
