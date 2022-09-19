/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlks.DTO;

import java.util.ArrayList;
import qlks.BUS.DanhMucKhuyenMaiBUS;

/**
 *
 * @author admin
 */
public class DanhMucKhuyenMaiDTO {
    private ArrayList<DanhMucKhuyenMai> dsdmkm;
    private DanhMucKhuyenMaiBUS dvBUS;

    public DanhMucKhuyenMaiDTO() {
        dvBUS = new DanhMucKhuyenMaiBUS();
        dsdmkm  = dvBUS.docDanhSachDanhMucKhuyenMai();
    }  
    
    public ArrayList<DanhMucKhuyenMai> docDanhSachDanhMucKhuyenMai(){  
        return dsdmkm;
    }
    
    public ArrayList<DanhMucKhuyenMai> getMaKhuyenMai(String mkm){
        ArrayList<DanhMucKhuyenMai> dsdmkmt = new ArrayList<>();
        for(DanhMucKhuyenMai dmkmt: dsdmkm){
            if(dmkmt.getMaChuongTrinhKhuyenMai().compareTo(mkm)==0)
                dsdmkmt.add(dmkmt);
        }
        return dsdmkmt;
    }
    
    public void themDanhMucKhuyenMai(DanhMucKhuyenMai dmkm){
        dsdmkm.add(dmkm);
    }
    
    public void suaDanhMucKhuyenMai(DanhMucKhuyenMai dmkm, int vitri){
        dsdmkm.set(vitri, dmkm);
    }
    
    public void xoaDanhMucKhuyenMai(int vitri){
        dsdmkm.remove(vitri);
    }
    
    public ArrayList<DanhMucKhuyenMai> locLoaiKhuyenMai(String lkm){
        ArrayList<DanhMucKhuyenMai> dst = new ArrayList<>();
        for(DanhMucKhuyenMai dmkmt: dsdmkm){
            if(dmkmt.getLoaiKhuyenMai().compareTo(lkm)==0){
                dst.add(dmkmt);
            }
        }
        return dst;
    }
}
