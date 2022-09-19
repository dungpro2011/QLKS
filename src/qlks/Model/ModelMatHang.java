/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlks.Model;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import qlks.DTO.MatHang;

/**
 *
 * @author admin
 */
public class ModelMatHang {
    private DefaultTableModel model;
    
    public ModelMatHang(ArrayList<MatHang> dsmh){
        Vector vt = new Vector();
        vt.add("Mã hàng hóa");
        vt.add("Tên hàng");
        vt.add("Số lượng");
        vt.add("Giá bán");
        model = new DefaultTableModel(vt,0);
        for(MatHang mh: dsmh){
            if(mh.isXoa()==false){
                vt = new Vector();
                vt.add(mh.getMaMatHang());
                vt.add(mh.getTenMatHang());
                vt.add(mh.getSoLuong());
                vt.add(mh.getDonGia());
                model.addRow(vt);
            }
        }
    }
    
    public DefaultTableModel getModel(){
        return model;
    }
}
