/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlks.DTO;

import java.util.ArrayList;
import qlks.BUS.PhieuNhapHangBUS;

/**
 *
 * @author admin
 */
public class PhieuNhapHangDTO {
    private ArrayList<PhieuNhapHang> dspnh;
    private PhieuNhapHangBUS pnhBUS;

    public PhieuNhapHangDTO() {
        pnhBUS = new PhieuNhapHangBUS();
        dspnh  = pnhBUS.docDanhSachPhieuNhapHang();
    }  
    
    public ArrayList<PhieuNhapHang> danhSachNgayNhap(String tu,String den){  
        return pnhBUS.danhSachNgayNhap(tu, den);
    }
    
    public ArrayList<PhieuNhapHang> docDanhSachPhieuNhapHang(){  
        return dspnh;
    }
    
    public void themPhieuNhapHang(PhieuNhapHang pnh){
        dspnh.add(pnh);
    }
    
    public void suaPhieuNhapHang(PhieuNhapHang pnh, int vitri){
        dspnh.set(vitri, pnh);
    }
    
    public void xoaPhieuNhapHang(int vitri){
        dspnh.remove(vitri);
    }
    
    public PhieuNhapHang getMaPhieuNhapHang(String mpnh){
        for(PhieuNhapHang pnh: dspnh){
            if(pnh.getMaPhieuNhapHang().compareTo(mpnh)==0){
                return pnh;
            }
        }
        return null;
    }
    
    public ArrayList<PhieuNhapHang> getNhanVien(String mnv){  
        ArrayList<PhieuNhapHang> dst = new ArrayList<>();
        for(PhieuNhapHang pnh: dspnh){
            if(pnh.getMaNhanVien().compareTo(mnv)==0){
                dst.add(pnh);
            }
        }
        return dst;
    }
    
    public ArrayList<PhieuNhapHang> gomMaNhanVien(){ 
        int t = 0;
        boolean TimMaNhanVien = false;
        ArrayList<PhieuNhapHang> dspnht  = new ArrayList<>();
        ArrayList<PhieuNhapHang> dst = pnhBUS.docDanhSachPhieuNhapHang();
        dst.get(0).setNgayNhapHang("-");
        dspnht.add(dst.get(0));
        for(int i=1;i<dst.size();i++){
            for(int j=0;j<dspnht.size();j++){
                if(dst.get(i).getMaNhanVien().compareTo(dspnht.get(j).getMaNhanVien())==0){
                    t = dspnht.get(j).getTongTien();
                    dspnht.get(j).setTongTien(t+dst.get(i).getTongTien());
                    TimMaNhanVien = true;
                    break;
                }
            }
            if(TimMaNhanVien){
                TimMaNhanVien = false;
            }else{
                dst.get(i).setNgayNhapHang("-");
                dspnht.add(dst.get(i));
            }
        }
        return dspnht;
    }
    
    public ArrayList<PhieuNhapHang> gomChuoiNgayThangNam(int vitri, int soluong){ 
        int t = 0;
        boolean TimNam = false;
        ArrayList<PhieuNhapHang> dspnht  = new ArrayList<>();
        ArrayList<PhieuNhapHang> dst = pnhBUS.docDanhSachPhieuNhapHang();
        dst.get(0).setMaNhanVien("-");
        dst.get(0).setNgayNhapHang(dst.get(0).getNgayNhapHang().substring(vitri, soluong));
        dspnht.add(dst.get(0));
        for(int i=1;i<dst.size();i++){
            for(int j=0;j<dspnht.size();j++){
                if(dst.get(i).getNgayNhapHang().substring(vitri, soluong).compareTo(dspnht.get(j).getNgayNhapHang().substring(vitri, soluong))==0){
                    t = dspnht.get(j).getTongTien();
                    dspnht.get(j).setTongTien(t+dst.get(i).getTongTien());
                    TimNam = true;
                    break;
                }
            }
            if(TimNam){
                TimNam = false;
            }else{
                dst.get(i).setMaNhanVien("-");
                dst.get(i).setNgayNhapHang(dst.get(i).getNgayNhapHang().substring(vitri, soluong));
                dspnht.add(dst.get(i));
            }
        }
        return dspnht;
    }
    
    public ArrayList<PhieuNhapHang> timPhieuNhapHang(PhieuNhapHang pnh){
        ArrayList<PhieuNhapHang> dst = new ArrayList<>();
        for(PhieuNhapHang pnht: dspnh){
            if(pnht.getMaPhieuNhapHang().compareTo(pnh.getMaPhieuNhapHang())==0 ||
                    pnht.getMaNhanVien().compareTo(pnh.getMaNhanVien())==0 ||
                    pnht.getNgayNhapHang().compareTo(pnh.getNgayNhapHang())==0 ||
                    pnht.getNhaCungCap().compareTo(pnh.getNhaCungCap())==0 ||
                    pnht.getTongTien() == pnh.getTongTien()){
                dst.add(pnht);
            }
        }
        return dst;
    }
}
