/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlks.Model;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import qlks.DTO.PhieuNhapHang;

/**
 *
 * @author admin
 */
public class ModelPhieuNhapHang {
    private DefaultTableModel model;
    
    public ModelPhieuNhapHang(ArrayList<PhieuNhapHang> dspnh){
        Vector vt = new Vector();
        vt.add("Mã phiếu nhập hàng");
        vt.add("Mã nhân viên");
        vt.add("Ngày nhập hàng");
        vt.add("Nhà cung cấp");
        vt.add("Tổng tiền");
        model = new DefaultTableModel(vt,0);
        for(PhieuNhapHang pnht: dspnh){
            vt = new Vector();
            vt.add(pnht.getMaPhieuNhapHang());
            vt.add(pnht.getMaNhanVien());
            vt.add(pnht.getNgayNhapHang());
            vt.add(pnht.getNhaCungCap());
            vt.add(pnht.getTongTien());
            model.addRow(vt);
        }
    }
    
    public DefaultTableModel getModel(){
        return model;
    }
}
