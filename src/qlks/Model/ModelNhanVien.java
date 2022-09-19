/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlks.Model;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import qlks.DTO.NhanVien;

/**
 *
 * @author admin
 */
public class ModelNhanVien {
    private DefaultTableModel model;
    
    public ModelNhanVien(ArrayList<NhanVien> dsnv){
        Vector vt = new Vector();
        vt.add("Mã nhân viên");
        vt.add("Họ");
        vt.add("Tên");
        vt.add("Ngày sinh");
        vt.add("Giới tính");
        vt.add("Địa chỉ");
        vt.add("CMND");
        vt.add("Điện thoại");
        vt.add("Ngày vào làm");
        vt.add("Lương tháng");
        model = new DefaultTableModel(vt,0);
        
        //Chi hien len nhung nhan vien ko xoa (Xoa = false) con lai thi an di (xoa = true)
        for(NhanVien nv: dsnv){
            if(nv.isXoa()==false){
                vt = new Vector();
                vt.add(nv.getMaNhanVien());
                vt.add(nv.getHo());
                vt.add(nv.getTen());
                vt.add(nv.getNgaySinh());
                vt.add(nv.getGioiTinh());
                vt.add(nv.getDiaChi());
                vt.add(nv.getCMMD());
                vt.add(nv.getDienThoai());
                vt.add(nv.getNgayVaoLam());
                vt.add(nv.getLuongThang());
                model.addRow(vt);
            }
        }
    }
    
    public DefaultTableModel getModel(){
        return model;
    }
}
