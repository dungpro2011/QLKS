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
import qlks.DTO.LoaiPhongDTO;
import qlks.DTO.Phong;

/**
 *
 * @author admin
 */
public class ModelPhong {
    private DefaultTableModel model;
    
    public ModelPhong(ArrayList<Phong> dsp){
        Vector vt = new Vector();
        String tlp = "";
        vt.add("Mã phòng");
        vt.add("Tên phòng");
        vt.add("Loại phòng");
        vt.add("Trạng thái");
        model = new DefaultTableModel(vt,0);
        LoaiPhongDTO lpDTO = new LoaiPhongDTO();
        for(Phong p: dsp){
            vt = new Vector();
            vt.add(p.getMaPhong());
            vt.add(p.getTenPhong());
            for(LoaiPhong lp: lpDTO.docDanhSachLoaiPhong()){
                if(p.getMaLoaiPhong().compareTo(lp.getMaLoaiPhong())==0){
                    tlp = lp.getTenLoaiPhong();
                    break;
                }
            }
            vt.add(tlp);
            vt.add(p.getTinhTrang());
            model.addRow(vt);
        }
    }
    
    public DefaultTableModel getModel(){
        return model;
    }
}
