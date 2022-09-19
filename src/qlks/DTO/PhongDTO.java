/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlks.DTO;

import java.util.ArrayList;
import qlks.BUS.PhongBUS;

/**
 *
 * @author admin
 */
public class PhongDTO {
    private ArrayList<Phong> dsp;
    private PhongBUS pBUS;
    
    public PhongDTO(){
        pBUS = new PhongBUS();
        dsp = pBUS.docDanhSachPhong();
    }
    
    public ArrayList<Phong> docDanhSachPhong(){
        return dsp;
    }
    
    public Phong getPhong(int row){
        return dsp.get(row);
    }
    
    public Phong getPhong(String mp){
        for(Phong pt: dsp){
            if(pt.getMaPhong().compareTo(mp)==0){
                return pt;
            }
        }
        return null;
    }
    
    public ArrayList<Phong> danhSachMaLoaiPhong(String mlp){
        ArrayList<Phong> ds = new ArrayList<>();
        for(Phong p: dsp){
            if(p.getMaLoaiPhong().compareTo(mlp)==0){
                ds.add(p);
            }
        }
        return ds;
    }
    
    public void suaPhong(Phong p, int vitri){
        dsp.set(vitri, p);
    }
    
    public void suaPhong(Phong p){
        for(int i=0;i<dsp.size();i++){
            if(p.getMaPhong().compareTo(dsp.get(i).getMaPhong())==0){
                dsp.set(i, p);
            }
        }
    }
    
    public ArrayList<Phong> danhSachTinhTrangPhong(int index, String ml){
        ArrayList<Phong> ds = new ArrayList<>();
        for(Phong p: dsp){
            if(ml.compareTo("0")==0){
                if(index==0&&p.getTinhTrang().compareTo("Trống")==0){
                    ds.add(p);
                }else{
                    if(index==1&&p.getTinhTrang().compareTo("Đã dùng")==0){
                        ds.add(p);
                    }else{
                        if(index==2&&p.getTinhTrang().compareTo("Bảo trì")==0){
                            ds.add(p);
                        }
                    }
                }
            }else{
                if(index==0&&p.getTinhTrang().compareTo("Trống")==0&&ml.compareTo(p.getMaLoaiPhong())==0){
                    ds.add(p);
                }else{
                    if(index==1&&p.getTinhTrang().compareTo("Đã dùng")==0&&ml.compareTo(p.getMaLoaiPhong())==0){
                        ds.add(p);
                    }else{
                        if(index==2&&p.getTinhTrang().compareTo("Bảo trì")==0&&ml.compareTo(p.getMaLoaiPhong())==0){
                            ds.add(p);
                        }
                    }
                }
            }
        }
        return ds;
    }
    
}
