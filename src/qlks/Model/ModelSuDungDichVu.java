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
import qlks.DTO.DichVuDTO;
import qlks.DTO.SuDungDichVu;

/**
 *
 * @author admin
 */
public class ModelSuDungDichVu {
    private DefaultTableModel model;
    
    public ModelSuDungDichVu(ArrayList<SuDungDichVu> dssddv){
        Vector vt = new Vector();
        String tdv = "";
        vt.add("Số hợp đồng");
        vt.add("Dịch vụ");
        vt.add("Đơn giá");
        vt.add("Số lượng");
        vt.add("Thành tiền");
        model = new DefaultTableModel(vt,0);
        DichVuDTO dvDTO = new DichVuDTO();
        for(SuDungDichVu sddvt: dssddv){
            vt = new Vector();
            vt.add(sddvt.getSoHopDongTHuePhong());
            for(DichVu dvt: dvDTO.docDanhSachDichVu()){
                if(sddvt.getMaDichVu().compareTo(dvt.getMaDichVu())==0){
                    tdv = dvt.getTenDichVu();
                    break;
                }
            }
            vt.add(tdv);
            vt.add(sddvt.getDonGia());
            vt.add(sddvt.getSoLuong());
            vt.add(sddvt.getThanhTien());
            model.addRow(vt);
        }
    }
    
    public DefaultTableModel getModel(){
        return model;
    }
}
