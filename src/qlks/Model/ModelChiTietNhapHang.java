/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlks.Model;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import qlks.DTO.ChiTietNhapHang;

/**
 *
 * @author admin
 */
public class ModelChiTietNhapHang {
    private DefaultTableModel model;
    
    public ModelChiTietNhapHang(ArrayList<ChiTietNhapHang> dsctnh){    
        Vector vt = new Vector();
        vt.add("Mã phiếu nhập");
        vt.add("Mã hàng hóa");
        vt.add("Đơn giá");
        vt.add("Số lượng");
        vt.add("Thành tiền");

        model = new DefaultTableModel(vt,0);
        
        for(ChiTietNhapHang ctnh: dsctnh){
            vt = new Vector();
            vt.add(ctnh.getMaPhieuNhapHang());
            vt.add(ctnh.getMaMatHang());
            vt.add(ctnh.getDonGia());
            vt.add(ctnh.getSoLuong());
            vt.add(ctnh.getThanhTien());
            
            model.addRow(vt);
        }
    }
    
    public DefaultTableModel getModel(){
        return model;
    }  
}
