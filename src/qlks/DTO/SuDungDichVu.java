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
public class SuDungDichVu {
    private String SoHopDongTHuePhong;
    private String MaDichVu;
    private int DonGia;
    private int SoLuong;
    private int ThanhTien;

    public SuDungDichVu() {
        this.SoHopDongTHuePhong = "";
        this.MaDichVu = "";
        this.DonGia = 0;
        this.SoLuong = 0;
        this.ThanhTien = 0;
    }

    public String getSoHopDongTHuePhong() {
        return SoHopDongTHuePhong;
    }

    public void setSoHopDongTHuePhong(String SoHopDongTHuePhong) {
        this.SoHopDongTHuePhong = SoHopDongTHuePhong;
    }

    public String getMaDichVu() {
        return MaDichVu;
    }

    public void setMaDichVu(String MaDichVu) {
        this.MaDichVu = MaDichVu;
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

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public int getThanhTien() {
        return ThanhTien;
    }

    public void setThanhTien(int ThanhTien) {
        this.ThanhTien = ThanhTien;
    }
    
    
}
