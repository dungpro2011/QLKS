    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlks.DTO;

import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import qlks.BUS.NhanVienBUS;

/**
 *
 * @author admin
 */
public class NhanVienDTO {
    private ArrayList<NhanVien> dsnv;
    private NhanVienBUS nvBUS;
    
    public NhanVienDTO(){
        nvBUS = new NhanVienBUS();
        dsnv = nvBUS.docDanhSachNhanVien();
    }
    
    public ArrayList<NhanVien> docDanhSachNhanVien(){
        return dsnv;
    }
    
    public void themNhanVien(NhanVien nv){
        dsnv.add(nv);
    }
    
    //Lay nhan vien theo vi tri
    public NhanVien getNhanVien(int vitri){
        return dsnv.get(vitri);
    }
    
    //Lay nhan vien theo ma nhan vien
    public NhanVien getNhanVien(String mnv){
        for(NhanVien nv: dsnv){
            if(nv.getMaNhanVien().compareTo(mnv)==0){
                return nv;
            }
        }
        return null;
    }
    
    public void suaNhanVien(NhanVien nv, int vitri){
        dsnv.set(vitri, nv);
    }
    
    //Chi cap nhat lai Xoa = true chu ko xoa
    public void xoaNhanVien(int vitri){
        dsnv.get(vitri).setXoa(true);
    }
    
    public void doiMatKhau(String mnv, String mk){
        for(int i=0;i<dsnv.size();i++){
            if(dsnv.get(i).getMaNhanVien().compareTo(mnv)==0){
                dsnv.get(i).setMatKhau(mk);
            }
        }
    }
    
    public ArrayList<NhanVien> timNhanVienTheoMuc(NhanVien nv){
        ArrayList<NhanVien> dstnv = new ArrayList<>();
        for(NhanVien nvt: dsnv){
            if(nvt.getMaNhanVien().compareTo(nv.getMaNhanVien())==0){
                dstnv.add(nvt);
            }else{
                if(nvt.getHo().compareTo(nv.getHo())==0){
                    dstnv.add(nvt);
                }else{
                    if(nvt.getTen().compareTo(nv.getTen())==0){
                        dstnv.add(nvt);
                    }else{
                        if(nvt.getNgaySinh().compareTo(nv.getNgaySinh())==0){
                            dstnv.add(nvt);
                        }else{
                            if(nvt.getGioiTinh().compareTo(nv.getGioiTinh())==0){
                                dstnv.add(nvt);
                            }else{
                                if(nvt.getDiaChi().compareTo(nv.getDiaChi())==0){
                                    dstnv.add(nvt);
                                }else{
                                    if(nvt.getCMMD().compareTo(nv.getCMMD())==0){
                                        dstnv.add(nvt);
                                    }else{
                                        if(nvt.getDienThoai().compareTo(nv.getDienThoai())==0){
                                            dstnv.add(nvt);
                                        }else{
                                            if(nvt.getNgayVaoLam().compareTo(nv.getNgayVaoLam())==0){
                                                dstnv.add(nvt);
                                            }else{
                                                if(nvt.getLuongThang()==nv.getLuongThang()){
                                                    dstnv.add(nvt);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return dstnv;
    }
    
    public ArrayList<NhanVien> timNhanVienChichXac(NhanVien nv){
        ArrayList<NhanVien> dstnv = dsnv;
        ArrayList<NhanVien> t = new ArrayList<>();
        
        if(nv.getMaNhanVien().compareTo("")!=0){
            for(NhanVien nvt: dstnv){
                if(nvt.getMaNhanVien().compareTo(nv.getMaNhanVien())==0){
                    t.add(nvt);
                }
            }
            dstnv = t;
        }
        
        if(nv.getHo().compareTo("")!=0){
            for(NhanVien nvt: dstnv){
                if(nvt.getHo().compareTo(nv.getHo())==0){
                    t.add(nvt);
                }
            }
            dstnv = t;
        }
        
        if(nv.getTen().compareTo("")!=0){
            t = new ArrayList<>();
            for(NhanVien nvt: dstnv){
                if(nvt.getTen().compareTo(nv.getTen())==0){
                    t.add(nvt);
                }
            }
            dstnv = t;
        }
        
        if(nv.getNgaySinh().compareTo("")!=0){
            t = new ArrayList<>();
            for(NhanVien nvt: dstnv){
                if(nvt.getNgaySinh().compareTo(nv.getNgaySinh())==0){
                    t.add(nvt);
                }
            }
            dstnv = t;
        }
        
        if(nv.getGioiTinh().compareTo("")!=0){
            t = new ArrayList<>();
            for(NhanVien nvt: dstnv){
                if(nvt.getGioiTinh().compareTo(nv.getGioiTinh())==0){
                    t.add(nvt);
                }
            }
            dstnv = t;
        }
        
        if(nv.getDiaChi().compareTo("")!=0){
            t = new ArrayList<>();
            for(NhanVien nvt: dstnv){
                if(nvt.getDiaChi().compareTo(nv.getDiaChi())==0){
                    t.add(nvt);
                }
            }
            dstnv = t;
        }
        
        if(nv.getCMMD().compareTo("")!=0){
            t = new ArrayList<>();
            for(NhanVien nvt: dstnv){
                if(nvt.getCMMD().compareTo(nv.getCMMD())==0){
                    t.add(nvt);
                }
            }
            dstnv = t;
        }
        
        if(nv.getDienThoai().compareTo("")!=0){
            t = new ArrayList<>();
            for(NhanVien nvt: dstnv){
                if(nvt.getDienThoai().compareTo(nv.getDienThoai())==0){
                    t.add(nvt);
                }
            }
            dstnv = t;
        }
        
        if(nv.getNgayVaoLam().compareTo("")!=0){
            t = new ArrayList<>();
            for(NhanVien nvt: dstnv){
                if(nvt.getNgayVaoLam().compareTo(nv.getNgayVaoLam())==0){
                    t.add(nvt);
                }
            }
            dstnv = t;
        }
        
        if(nv.getLuongThang()!=-1){
            t = new ArrayList<>();
            for(NhanVien nvt: dstnv){
                if(nvt.getLuongThang()==nv.getLuongThang()){
                    t.add(nvt);
                }
            }
            dstnv = t;
        }
        
        return dstnv;
    }
//    public ArrayList<NhanVien> tim(ArrayList<)
}
