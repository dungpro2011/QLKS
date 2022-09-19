/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlks.DTO;

import java.util.ArrayList;
import qlks.BUS.KhachHangBUS;

/**
 *
 * @author admin
 */
public class KhachHangDTO {
    private ArrayList<KhachHang> dskh;
    private KhachHangBUS khBUS;
    
    public KhachHangDTO(){
        khBUS = new KhachHangBUS();
        dskh = khBUS.docDanhSachKhachHang();
    }
    
    public ArrayList<KhachHang> docDanhSachKhachHang(){
        return dskh;
    }
    
    public KhachHang getKhachHang(int vitri){
        return dskh.get(vitri);
    }
    
    public void themKhachHang(KhachHang kh){
        dskh.add(kh);
    }
    
    public void suaKhachHang(KhachHang kh, int vitri){
        dskh.set(vitri, kh);
    }
    
    public void xoaKhachHang(int vitri){
        dskh.get(vitri).setXoa(true);
    }
    
    public ArrayList<KhachHang> timKhachHang(KhachHang kh){
        ArrayList<KhachHang> dstkh = new ArrayList<>();
        for(KhachHang kht: dskh){
            if(kht.getMaKhachHang().compareTo(kh.getMaKhachHang())==0){
                dstkh.add(kht);
            }else{
                if(kht.getHo().compareTo(kh.getHo())==0){
                    dstkh.add(kht);
                }else{
                    if(kht.getTen().compareTo(kh.getTen())==0){
                        dstkh.add(kht);
                    }else{
                            if(kht.getGioiTinh().compareTo(kh.getGioiTinh())==0){
                                dstkh.add(kht);
                            }else{
                                if(kht.getDiaChi().compareTo(kh.getDiaChi())==0){
                                    dstkh.add(kht);
                                }else{
                                    if(kht.getCMND().compareTo(kh.getCMND())==0){
                                        dstkh.add(kht);
                                    }else{
                                        if(kht.getDienThoai().compareTo(kh.getDienThoai())==0){
                                            dstkh.add(kht);
                                        }
                                    }
                                }
                            }
                    }
                }
            }
        }
        return dstkh;
    }
}
