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
import qlks.DTO.HoaDonDTO;

/**
 *
 * @author admin
 */
public class ModelHoaDon {
    private DefaultTableModel model;
    
    public ModelHoaDon(ArrayList<HoaDon> dshd){
        Vector vt = new Vector();
        vt.add("Số hóa đơn");
        vt.add("Số hợp đồng thuê phòng");
        vt.add("Mã nhân viên");
        vt.add("Ngày thanh toán");
        vt.add("Tiền thuê phòng");
        vt.add("Tiền dịch vụ");
        vt.add("Tiền khuyến mãi");
        vt.add("Thuế");
        vt.add("Tổng tiền");
        model = new DefaultTableModel(vt,0);
        
        for(HoaDon hd: dshd){
            vt = new Vector();
            vt.add(hd.getSoHoaDon());
            vt.add(hd.getSoHopDongThuePhong());
            vt.add(hd.getMaNhanVien());
            vt.add(hd.getNgayThanhToan());
            vt.add(hd.getTienThuePhong());
            vt.add(hd.getTienDichVu());
            vt.add(hd.getTienKhuyenMai());
            vt.add(hd.getThue());
            vt.add(hd.getTongTien());
            model.addRow(vt);
        }
    }
    
    public DefaultTableModel getModel(){
        return model;
    }
}
