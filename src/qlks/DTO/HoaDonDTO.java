/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlks.DTO;

import java.util.ArrayList;
import qlks.BUS.HoaDonBUS;

/**
 *
 * @author admin
 */
public class HoaDonDTO {
    private ArrayList<HoaDon> dshd;
    private HoaDonBUS hdBUS;

    public HoaDonDTO() {
        hdBUS = new HoaDonBUS();
        dshd = hdBUS.docDanhSachHoaDon();
    }
    
    public ArrayList<HoaDon> docDanhSachHoaDon(){  
        return dshd;
    }  
    
    public HoaDon getHoaDon(int vitri){
        return dshd.get(vitri);
    }
    
    public void themHoaDon(HoaDon hd){
        dshd.add(hd);
    }
    
    public void suaHoaDon(HoaDon hd, int vitri){
        dshd.set(vitri, hd);
    }
    
    public void xoaHoaDon(int vitri){
        dshd.remove(vitri);
    }
    
    public  ArrayList<HoaDon> timHoaDon(HoaDon hd){
        ArrayList<HoaDon> dst = new ArrayList<>();
        for(HoaDon hdt: dshd){
            if(hd.getSoHoaDon().compareTo(hdt.getSoHoaDon())==0 ||
                    hd.getSoHopDongThuePhong().compareTo(hdt.getSoHopDongThuePhong())==0 ||
                    hd.getMaNhanVien().compareTo(hdt.getMaNhanVien())==0 ||
                    hd.getNgayThanhToan().compareTo(hdt.getNgayThanhToan())==0 ||
                    hd.getTienThuePhong()==hdt.getTienThuePhong() ||
                    hd.getTienDichVu()==hdt.getTienDichVu() ||
                    hd.getThue()==hdt.getThue() ||
                    hd.getTienKhuyenMai()==hdt.getTienKhuyenMai() ||
                    hd.getTongTien()==hdt.getTongTien()){
                dst.add(hdt);
            }
        }
        return dst;
    }
}
