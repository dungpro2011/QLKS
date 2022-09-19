/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlks.DTO;

import java.util.ArrayList;
import qlks.BUS.HoaDonBUS;
import qlks.BUS.ThongKeBUS;

/**
 *
 * @author admin
 */
public class ThongKeDTO {
    private ArrayList<HoaDon> dstk;
    private ThongKeBUS tkBUS;

    public ThongKeDTO() {
        tkBUS = new ThongKeBUS();
    }
    
    public ArrayList<HoaDon> thongKe(){
        return tkBUS.thongKe();
    }
    
    public ArrayList<HoaDon> thongKeNgayThanhToan(String tu, String den){ 
        dstk = tkBUS.thongKeNgayThanhToan(tu, den);
        return dstk;
    }
    
    public ArrayList<HoaDon> thongKeNgayThue(String tu, String den){ 
        dstk = tkBUS.thongKeNgayThue(tu, den);
        return dstk;
    }
    
    public ArrayList<HoaDon> thongKeNhanVien(String mnv){ 
        dstk  = new ArrayList<>();
        for(HoaDon hd: tkBUS.thongKe()){
            if(hd.getMaNhanVien().compareTo(mnv)==0){
                dstk.add(hd);
            }
        }
        return dstk;
    }
    
    public ArrayList<HoaDon> thongKekhachHang(String mkh){ 
        dstk  = new ArrayList<>();
        for(HoaDon hd: tkBUS.thongKe()){
            if(hd.getMaKhachHang().compareTo(mkh)==0){
                dstk.add(hd);
            }
        }
        return dstk;
    }
    
    public ArrayList<HoaDon> thongKeNhanVienKhachhachHang(String mnv, String mkh){ 
        dstk  = new ArrayList<>();
        for(HoaDon hd: tkBUS.thongKe()){
            if(hd.getMaKhachHang().compareTo(mkh)==0&&hd.getMaNhanVien().compareTo(mnv)==0){
                dstk.add(hd);
            }
        }
        return dstk;
    }
    
    public ArrayList<HoaDon> gomMaNhanVien(){ 
        int t = 0;
        boolean TimMaNhanVien = false;
        dstk  = new ArrayList<>();
        ArrayList<HoaDon> dst = tkBUS.thongKe();
        dst.get(0).setSoHoaDon("-");
        dst.get(0).setMaKhachHang("-");
        dst.get(0).setNgayThue("-");
        dst.get(0).setNgayThanhToan("-");
        dstk.add(dst.get(0));
        for(int i=1;i<dst.size();i++){
            for(int j=0;j<dstk.size();j++){
                if(dst.get(i).getMaNhanVien().compareTo(dstk.get(j).getMaNhanVien())==0){
                    t = dstk.get(j).getTongTien();
                    dstk.get(j).setTongTien(t+dst.get(i).getTongTien());
                    TimMaNhanVien = true;
                    break;
                }
            }
            if(TimMaNhanVien){
                TimMaNhanVien = false;
            }else{
                dst.get(i).setSoHoaDon("-");
                dst.get(i).setMaKhachHang("-");
                dst.get(i).setNgayThue("-");
                dst.get(i).setNgayThanhToan("-");
                dstk.add(dst.get(i));
            }
        }
        
        return dstk;
    }
    
    public ArrayList<HoaDon> gomMaKhachHang(){ 
        int t = 0;
        boolean TimMaKhachHang = false;
        dstk  = new ArrayList<>();
        ArrayList<HoaDon> dst = tkBUS.thongKe();
        dst.get(0).setSoHoaDon("-");
        dst.get(0).setMaNhanVien("-");
        dst.get(0).setNgayThue("-");
        dst.get(0).setNgayThanhToan("-");
        dstk.add(dst.get(0));
        for(int i=1;i<dst.size();i++){
            for(int j=0;j<dstk.size();j++){
                if(dst.get(i).getMaKhachHang().compareTo(dstk.get(j).getMaKhachHang())==0){
                    t = dstk.get(j).getTongTien();
                    dstk.get(j).setTongTien(t+dst.get(i).getTongTien());
                    TimMaKhachHang = true;
                    break;
                }
            }
            if(TimMaKhachHang){
                TimMaKhachHang = false;
            }else{
                dst.get(i).setSoHoaDon("-");
                dst.get(i).setMaNhanVien("-");
                dst.get(i).setNgayThue("-");
                dst.get(i).setNgayThanhToan("-");
                dstk.add(dst.get(i));
            }
        }
        return dstk;
    }
    
    public ArrayList<HoaDon> gomChuoiNgayThangNam(int vitri, int soluong){ 
        int t = 0;
        boolean TimNam = false;
        dstk  = new ArrayList<>();
        ArrayList<HoaDon> dst = tkBUS.thongKe();
        dst.get(0).setSoHoaDon("-");
        dst.get(0).setMaNhanVien("-");
        dst.get(0).setMaKhachHang("-");
        dst.get(0).setNgayThue("-");
        dst.get(0).setNgayThanhToan(dst.get(0).getNgayThanhToan().substring(vitri, soluong));
        dstk.add(dst.get(0));
        for(int i=1;i<dst.size();i++){
            for(int j=0;j<dstk.size();j++){
                if(dst.get(i).getNgayThanhToan().substring(vitri, soluong).compareTo(dstk.get(j).getNgayThanhToan().substring(vitri, soluong))==0){
                    t = dstk.get(j).getTongTien();
                    dstk.get(j).setTongTien(t+dst.get(i).getTongTien());
                    TimNam = true;
                    break;
                }
            }
            if(TimNam){
                TimNam = false;
            }else{
                dst.get(i).setSoHoaDon("-");
                dst.get(i).setMaNhanVien("-");
                dst.get(i).setMaKhachHang("-");
                dst.get(i).setNgayThue("-");
                dst.get(i).setNgayThanhToan(dst.get(i).getNgayThanhToan().substring(vitri, soluong));
                dstk.add(dst.get(i));
            }
        }
        return dstk;
    }
    
}
