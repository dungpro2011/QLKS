/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlks.DTO;

import java.util.ArrayList;
import qlks.BUS.DichVuBUS;

/**
 *
 * @author admin
 */
public class DichVuDTO {
    private ArrayList<DichVu> dsdv;
    private DichVuBUS dvBUS;

    public DichVuDTO() {
        dvBUS = new DichVuBUS();
        dsdv  = dvBUS.docDanhSachDichVu();
    }  
    
    public ArrayList<DichVu> docDanhSachDichVu(){  
        return dsdv;
    }
    
    public void themDichVu(DichVu dv){
        dsdv.add(dv);
    }
    
    public void suaDichVu(DichVu dv, int vitri){
        dsdv.set(vitri, dv);
    }
    
    public void xoaDichVu(String mdv, int vitri){
        dsdv.get(vitri).setXoa(true);
    }
    
    public ArrayList<DichVu> timDichVu(DichVu dv){
        ArrayList<DichVu> dst = new ArrayList<>();
        for(DichVu dvt: dsdv){
            if(dvt.getMaDichVu().compareTo(dv.getMaDichVu())==0 ||
                    dvt.getTenDichVu().compareTo(dv.getTenDichVu())==0 ||
                    dvt.getDonGia() == dv.getDonGia() ||
                    dvt.getMatHang().compareTo(dv.getMatHang())==0){
                dst.add(dvt);
            }
        }
        return dst;
    }
}
