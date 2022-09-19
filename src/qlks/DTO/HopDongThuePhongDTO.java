/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlks.DTO;

import java.util.ArrayList;
import qlks.BUS.HopDongThuePhongBUS;

/**
 *
 * @author admin
 */
public class HopDongThuePhongDTO {
    private ArrayList<HopDongThuePhong> dshdtp;
    private HopDongThuePhongBUS hdtpBUS;

    public HopDongThuePhongDTO() {
        hdtpBUS = new HopDongThuePhongBUS();
        dshdtp = hdtpBUS.docDanhSachHopDongThuePhong();
    }
    
    public ArrayList<HopDongThuePhong> docDanhSachHopDongThuePhong(){  
        return dshdtp;
    }
    
    public HopDongThuePhong getHopDongThuePhong(int index){
        return dshdtp.get(index);
    }
    
    public void themHopDongThuePhong(HopDongThuePhong hdtp){
        dshdtp.add(hdtp);
    }
    
    public void suaHopDongThuePhong(HopDongThuePhong hdtp, int vitri){
        dshdtp.set(vitri, hdtp);
    }
    
    public void xoaHopDongThuePhong(String shdtp, int vitri){
        dshdtp.get(vitri).setXoa(true);
    }
    
    public void suaHopDongThuePhong(HopDongThuePhong hdtp){
        for(int i=0;i<dshdtp.size();i++){
            if(hdtp.getSoHopDongThuePhong().compareTo(dshdtp.get(i).getSoHopDongThuePhong())==0){
                dshdtp.set(i, hdtp);
            }
        }

    }
    
    public ArrayList<HopDongThuePhong> timHopDongThuePhong(HopDongThuePhong hdtp){
        ArrayList<HopDongThuePhong> dst = new ArrayList<>();
        for(HopDongThuePhong hdtpt: dshdtp){
            if(hdtpt.getSoHopDongThuePhong().compareTo(hdtp.getSoHopDongThuePhong())==0 ||
                hdtpt.getMaNhanVien().compareTo(hdtp.getMaNhanVien())==0 ||
                hdtpt.getMaPhong().compareTo(hdtp.getMaPhong())==0 ||
                hdtpt.getMaKhachHang().compareTo(hdtp.getMaKhachHang())==0 ||
                hdtpt.getTienPhong()==hdtp.getTienPhong() ||
                hdtpt.getNgayThue().compareTo(hdtp.getNgayThue())==0 ||
                hdtpt.getNgayTra().compareTo(hdtp.getNgayTra())==0 ||
                hdtpt.getTrangThai().compareTo(hdtp.getTrangThai())==0 ||
                hdtpt.getGhiChu().compareTo(hdtp.getGhiChu())==0){
                    dst.add(hdtpt);
            }
        }
        return dst;
    }
}
