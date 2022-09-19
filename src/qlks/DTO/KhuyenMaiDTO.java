/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlks.DTO;

import java.util.ArrayList;
import qlks.BUS.KhuyenMaiBUS;

/**
 *
 * @author admin
 */
public class KhuyenMaiDTO {
    private ArrayList<KhuyenMai> dskm;
    private KhuyenMaiBUS kmBUS;
    
    public KhuyenMaiDTO(){
        kmBUS = new KhuyenMaiBUS();
        dskm = kmBUS.docDanhSachKhuyenMai();
    }
    
    public ArrayList<KhuyenMai> docDanhSachKhuyenMai(){
        return dskm;
    }
    
    public void themKhuyenMai(KhuyenMai km){
        dskm.add(km);
    }
    
    public void suaKhuyenMai(KhuyenMai km, int vitri){
        dskm.set(vitri, km);
    }
    
    public void xoaKhuyenMai(String mkm, int vitri){
        dskm.get(vitri).setXoa(true);
    }
    
    public ArrayList<KhuyenMai> timKhuyenMai(KhuyenMai km){
        ArrayList<KhuyenMai> dst = new ArrayList<>();
        for(KhuyenMai kmt: dskm){
            if(kmt.getMaChuongTrinhKhuyenMai().compareTo(km.getMaChuongTrinhKhuyenMai())==0 ||
                    kmt.getTenChuongTrinhKhuyenMai().compareTo(km.getTenChuongTrinhKhuyenMai())==0 ||
                    kmt.getThoiGianBatDau().compareTo(km.getThoiGianBatDau())==0 ||
                    kmt.getTHoiGianKetThuc().compareTo(km.getTHoiGianKetThuc())==0 ||
                    kmt.getGiamGia() == km.getGiamGia()){
                dst.add(kmt);
            }
        }
        return dst;
    }
}
