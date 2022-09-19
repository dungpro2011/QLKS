/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlks.Model;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import qlks.DTO.DanhMucKhuyenMai;
import qlks.DTO.KhuyenMai;
import qlks.DTO.KhuyenMaiDTO;

/**
 *
 * @author admin
 */
public class ModelDanhMucKhuyenMai {
    private DefaultTableModel model;
    
    public ModelDanhMucKhuyenMai(ArrayList<DanhMucKhuyenMai> dsdmkm){    
        Vector vt = new Vector();
        vt.add("Số hợp đồng");
        vt.add("Tên khuyến mãi");
        vt.add("Loại khuyến mãi");
        vt.add("Ngày khuyến mãi");
        vt.add("Giảm (%)");
        vt.add("Nội dung");

        model = new DefaultTableModel(vt,0);
        
        for(DanhMucKhuyenMai dmkm: dsdmkm){
            vt = new Vector();
            vt.add(dmkm.getSoHopDongThuePhong());
            vt.add(dmkm.getMaChuongTrinhKhuyenMai());
            vt.add(dmkm.getLoaiKhuyenMai());
            vt.add(dmkm.getNgayKhuyenMai());
            vt.add(dmkm.getGiamGia());
            vt.add(dmkm.getNoiDunngKhuyenMai());
            
            model.addRow(vt);
        }
    }
    
    public DefaultTableModel getModel(){
        return model;
    }  
}
