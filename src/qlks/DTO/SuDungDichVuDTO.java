/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlks.DTO;

import java.util.ArrayList;
import qlks.BUS.SuDungDichVuBUS;

/**
 *
 * @author admin
 */
public class SuDungDichVuDTO {
    private ArrayList<SuDungDichVu> dssddv;
    private SuDungDichVuBUS sddvBUS;
    
    public SuDungDichVuDTO(){
        sddvBUS = new SuDungDichVuBUS();
        dssddv = sddvBUS.docDanhSachSuDungDichVu();
    }
    
    public ArrayList<SuDungDichVu> docDanhSachSuDungDichVu(){
        return dssddv;
    }
    
    public ArrayList<SuDungDichVu> danhSachMaDichVu(String mdv){
        ArrayList<SuDungDichVu> dst = new ArrayList<>();
        for(SuDungDichVu sddv: dssddv){
            if(mdv.compareTo(sddv.getMaDichVu())==0){
                dst.add(sddv);
            }
        }
        return dst;
    }
    
    public void themSuDungDichVu(SuDungDichVu sddv){
        dssddv.add(sddv);
    }
    
    public void suaSuDungDichVu(SuDungDichVu sddv, int vitri){
        dssddv.set(vitri, sddv);
    }
    
    public void xoaSuDungDichVu(int vtitri){
        dssddv.remove(vtitri);
    }
    
    public ArrayList<SuDungDichVu> timSuDungDichVu(SuDungDichVu sddv){
        ArrayList<SuDungDichVu> dst = new ArrayList<>();
        for(SuDungDichVu sddvt: dssddv){
            if(sddvt.getSoHopDongTHuePhong().compareTo(sddv.getSoHopDongTHuePhong())==0 || 
                    sddvt.getMaDichVu().compareTo(sddv.getMaDichVu())==0 ||
                    sddvt.getDonGia() == sddv.getDonGia() ||
                    sddvt.getSoLuong() == sddv.getSoLuong() ||
                    sddvt.getThanhTien() == sddv.getThanhTien()){
                dst.add(sddvt);
            }
        }
        return dst;
    }
}
