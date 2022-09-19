/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlks.Model;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import qlks.DTO.KhachHang;

/**
 *
 * @author admin
 */
public class ModelKhachHang {
    private DefaultTableModel model;
    
    public ModelKhachHang(ArrayList<KhachHang> dskh){
        Vector vt = new Vector();
        vt.add("Mã khách hàng");
        vt.add("Họ");
        vt.add("Tên");
        vt.add("Giới tính");
        vt.add("Địa chỉ");
        vt.add("CMND");
        vt.add("Điện thoại");
        model = new DefaultTableModel(vt,0);
        for(KhachHang kh: dskh){
            if(kh.isXoa()==false){
                vt = new Vector();
                vt.add(kh.getMaKhachHang());
                vt.add(kh.getHo());
                vt.add(kh.getTen());
                vt.add(kh.getGioiTinh());
                vt.add(kh.getDiaChi());
                vt.add(kh.getCMND());
                vt.add(kh.getDienThoai());
                model.addRow(vt);
            }
        }
    }
    
    public DefaultTableModel getModel(){
        return model;
    }
}
