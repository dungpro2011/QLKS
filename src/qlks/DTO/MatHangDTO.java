/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlks.DTO;

import java.util.ArrayList;
import qlks.BUS.MatHangBUS;

/**
 *
 * @author admin
 */
public class MatHangDTO {
    private ArrayList<MatHang> dsmh;
    private MatHangBUS mhBUS;
    
    public MatHangDTO(){
        mhBUS = new MatHangBUS();
        dsmh = mhBUS.docDanhSachMatHang();
    }
    
    public ArrayList<MatHang> docDanhSachMatHang(){
        return dsmh;
    }
    
    public void themMatHang(MatHang mh){
        dsmh.add(mh);
    }
    
    public void suaMatHang(MatHang mh, int vitri){
        dsmh.set(vitri, mh);
    }
    
    public void xoaMatHang(String mmh, int vitri){
        dsmh.get(vitri).setXoa(true);
    }
    
    public MatHang getMaMatHang(String mmh){
        for(MatHang mh: dsmh){
            if(mh.getMaMatHang().compareTo(mmh)==0){
                return mh;
            }
        }
        return null;
    }
    
    public void suaSoLuong(MatHang mh){
        for(int i=0;i<dsmh.size();i++){
            if(mh.getMaMatHang().compareTo(dsmh.get(i).getMaMatHang())==0){
                dsmh.set(i, mh);
                return;
            }
        }
    }
    
    public ArrayList<MatHang> timMatHang(MatHang mh){
        ArrayList<MatHang> dst = new ArrayList<>();
        for(MatHang mht: dsmh){
            if(mht.getMaMatHang().compareTo(mh.getMaMatHang())==0 ||
                    mht.getTenMatHang().compareTo(mh.getTenMatHang())==0 ||
                    mht.getSoLuong() == mh.getSoLuong() ||
                    mht.getDonGia() == mh.getDonGia()){
                dst.add(mht);
            }
        }
        return dst;
    }
}
