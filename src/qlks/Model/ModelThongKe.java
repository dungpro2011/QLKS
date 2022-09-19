/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlks.Model;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import qlks.DTO.HoaDon;
import qlks.DTO.PhieuNhapHang;

/**
 *
 * @author admin
 */
public class ModelThongKe {
    private DefaultTableModel model;
    
    public ModelThongKe(){
        model = null;
    }
    
    public DefaultTableModel getModelhd(ArrayList<HoaDon> dshd){
        Vector vt = new Vector();
        vt.add("Số hóa đơn");
        vt.add("Mã nhân viên");
        vt.add("Mã khách hàng");
        vt.add("Ngày thuê");
        vt.add("Ngày thanh toán");
        vt.add("Tổng tiền");
        model = new DefaultTableModel(vt,0);
        
        for(HoaDon hd: dshd){
            vt = new Vector();
            vt.add(hd.getSoHoaDon());
            vt.add(hd.getMaNhanVien());
            vt.add(hd.getMaKhachHang());
            vt.add(hd.getNgayThue());
            vt.add(hd.getNgayThanhToan());
            vt.add(hd.getTongTien());
            model.addRow(vt);
        }
        return model;
    }
    
    public DefaultTableModel getModelpnh(ArrayList<PhieuNhapHang> dspnh){
        Vector vt = new Vector();
        vt.add("Mã nhân viên");
        vt.add("Ngày nhập");
        vt.add("Tổng tiền");
        model = new DefaultTableModel(vt,0);
        
        for(PhieuNhapHang pnh: dspnh){
            vt = new Vector();
            vt.add(pnh.getMaNhanVien());
            vt.add(pnh.getNgayNhapHang());
            vt.add(pnh.getTongTien());
            model.addRow(vt);
        }
        return model;
    }
}
