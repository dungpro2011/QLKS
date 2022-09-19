/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlks.Model;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import qlks.DTO.LoaiPhong;

/**
 *
 * @author admin
 */
public class ModelLoaiPhong {
    private DefaultTableModel model;
    
    public ModelLoaiPhong(ArrayList<LoaiPhong> dslp){
        Vector vt = new Vector();
        vt.add("Mã loại phòng");
        vt.add("Tên loại phòng");
        vt.add("Số người");
        vt.add("Giá tiền");
        model = new DefaultTableModel(vt,0);
        for(LoaiPhong lp: dslp){
            vt = new Vector();
            vt.add(lp.getMaLoaiPhong());
            vt.add(lp.getTenLoaiPhong());
            vt.add(lp.getSoNguoi());
            vt.add(lp.getGiaTien());
            model.addRow(vt);
        }
    }
    
    public DefaultTableModel getModel(){
        return model;
    }
}
