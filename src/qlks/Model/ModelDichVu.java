/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlks.Model;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import qlks.DTO.DichVu;

/**
 *
 * @author admin
 */
public class ModelDichVu {
    private DefaultTableModel model;
    
    public ModelDichVu(ArrayList<DichVu> dsdv){    
        Vector vt = new Vector();
        vt.add("Mã dịch vụ");
        vt.add("Tên dịch vụ");
        vt.add("Đơn giá");
        vt.add("Mã mặt hàng");

        model = new DefaultTableModel(vt,0);
        
        for(DichVu dv: dsdv){
            if(dv.isXoa()==false){
                vt = new Vector();
                vt.add(dv.getMaDichVu());
                vt.add(dv.getTenDichVu());
                vt.add(dv.getDonGia());
                vt.add(dv.getMatHang());
                model.addRow(vt);
            }
        }
    }
    
    public DefaultTableModel getModel(){
        return model;
    }    
}
