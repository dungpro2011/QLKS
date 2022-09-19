/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlks.DTO;

import java.util.ArrayList;
import qlks.BUS.ChiTietNhapHangBUS;

/**
 *
 * @author admin
 */
public class ChiTietNhapHangDTO {
    private ArrayList<ChiTietNhapHang> dsctnh;
    private ChiTietNhapHangBUS ctnhBUS;

    public ChiTietNhapHangDTO() {
        ctnhBUS = new ChiTietNhapHangBUS();
        dsctnh  = ctnhBUS.docDanhSachChiTietNhapHang();
    }  
    
    public ArrayList<ChiTietNhapHang> docDanhSachChiTietNhapHang(){  
        return dsctnh;
    }
    
    public ArrayList<ChiTietNhapHang> getMaHangHoa(String mhh){
        ArrayList<ChiTietNhapHang> dsctnht  = new ArrayList<>();
        for(ChiTietNhapHang ctnht: dsctnh){
            if(ctnht.getMaMatHang().compareTo(mhh)==0){
                dsctnht.add(ctnht);
            }
        }
        return dsctnht;
    }
    
    public void themChiTietNhapHang(ChiTietNhapHang ctnh){
        dsctnh.add(ctnh);
    }
    
    public void suaChiTietNhapHang(ChiTietNhapHang ctnh, int vitri){
        dsctnh.set(vitri, ctnh);
    }
    
    public void xoaChiTietNhapHang(int vitri){
        dsctnh.remove(vitri);
    }
    
    public ArrayList<ChiTietNhapHang> timChiTietNhapHang(ChiTietNhapHang ctnh){
        ArrayList<ChiTietNhapHang> dst = new ArrayList<>();
        for(ChiTietNhapHang ctnht: dsctnh){
            if(ctnht.getMaPhieuNhapHang().compareTo(ctnh.getMaPhieuNhapHang())==0 ||
                    ctnht.getMaMatHang().compareTo(ctnh.getMaMatHang())==0 ||
                    ctnht.getDonGia() == ctnh.getDonGia() ||
                    ctnht.getSoLuong() == ctnh.getSoLuong() ||
                    ctnht.getThanhTien() == ctnh.getThanhTien()){
                dst.add(ctnht);
            }
        }
        return dst;
    }
}
