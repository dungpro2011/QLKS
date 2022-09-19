/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlks.DTO;

import java.util.ArrayList;
import qlks.BUS.LoaiPhongBUS;

/**
 *
 * @author admin
 */
public class LoaiPhongDTO {
    private ArrayList<LoaiPhong> dslp;
    private LoaiPhongBUS lpBUS;
    
    public LoaiPhongDTO(){
        lpBUS = new LoaiPhongBUS();
        dslp = lpBUS.docDanhSachLoaiPhong();
    }
    
    public ArrayList<LoaiPhong> docDanhSachLoaiPhong(){
        return dslp;
    }
    
    public void themLoaiPhong(LoaiPhong lp){
        dslp.add(lp);
    }
    
    public void suaLoaiPhong(LoaiPhong lp, int vitri){
        dslp.set(vitri, lp);
    }
    
    public void xoaLoaiPhong(int vitri){
        dslp.remove(vitri);
    }
    
    //Lay nhan vien theo vi tri
    public LoaiPhong getLoaiPhong(int vitri){
        return dslp.get(vitri);
    }
}
