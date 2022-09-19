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
public class MatHang {
    private String MaMatHang;
    private String TenMatHang;
    private int SoLuong;
    private int DonGia;
    private boolean Xoa;

    public MatHang() {
        this.MaMatHang = "";
        this.TenMatHang = "";
        this.SoLuong = 0;
        this.DonGia = 0;
        this.Xoa = false;
    }

    public String getMaMatHang() {
        return MaMatHang;
    }

    public void setMaMatHang(String MaMatHang) {
        this.MaMatHang = MaMatHang;
    }

    public String getTenMatHang() {
        return TenMatHang;
    }

    public void setTenMatHang(String TenMatHang) {
        this.TenMatHang = TenMatHang;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }
    
    public boolean setSoLuong(String SoLuong) {
        try{
            this.SoLuong = Integer.parseInt(SoLuong);
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Số lượng là số");
            return false;
        } 
    }

    public int getDonGia() {
        return DonGia;
    }

    public void setDonGia(int DonGia) {
        this.DonGia = DonGia;
    }
    
    public boolean setDonGia(String DonGia) {
        try{
            this.DonGia = Integer.parseInt(DonGia);
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Đơn giá là số");
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
