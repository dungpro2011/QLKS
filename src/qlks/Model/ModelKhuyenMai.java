/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlks.Model;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import qlks.DTO.KhuyenMai;

/**
 *
 * @author admin
 */
public class ModelKhuyenMai {
        private DefaultTableModel model;
    
    public ModelKhuyenMai(ArrayList<KhuyenMai> dskm){
        Vector vt = new Vector();
        vt.add("Mã khuyến mãi");
        vt.add("Tên khuyến mãi");
        vt.add("Thời gian bắt đầu");
        vt.add("Thời gian kết thúc");
        vt.add("Giảm (%)");
        model = new DefaultTableModel(vt,0);
        for(KhuyenMai km: dskm){
            if(km.isXoa()==false){
                vt = new Vector();
                vt.add(km.getMaChuongTrinhKhuyenMai());
                vt.add(km.getTenChuongTrinhKhuyenMai());
                vt.add(km.getThoiGianBatDau());
                vt.add(km.getTHoiGianKetThuc());
                vt.add(km.getGiamGia());
                model.addRow(vt);
            }
        }
    }
    
    public DefaultTableModel getModel(){
        return model;
    }
}
