/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlks.Model;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import qlks.DTO.HopDongThuePhong;
import qlks.DTO.KhachHang;
import qlks.DTO.KhachHangDTO;
import qlks.DTO.NhanVien;
import qlks.DTO.NhanVienDTO;
import qlks.DTO.Phong;
import qlks.DTO.PhongDTO;

/**
 *
 * @author admin
 */
public class ModelHopDongThuePhong {
    private DefaultTableModel model;
    
    public ModelHopDongThuePhong(ArrayList<HopDongThuePhong> dshdp){
        Vector vt = new Vector();
        vt.add("Số hợp đồng thuê phòng");
        vt.add("Tên nhân viên");
        vt.add("Tên phòng");
        vt.add("Tên khách hàng");
        vt.add("Tiền phòng");
        vt.add("Ngày thuê");
        vt.add("Ngày trả");
        vt.add("Trạng thái");
        vt.add("Ghi chú");
        String tkh = "";
        KhachHangDTO khDTO = new KhachHangDTO();
        model = new DefaultTableModel(vt,0);
        for(HopDongThuePhong hdpt: dshdp){
            if(hdpt.isXoa()==false){
                vt = new Vector();
                vt.add(hdpt.getSoHopDongThuePhong());
                vt.add(hdpt.getMaNhanVien());
                vt.add(hdpt.getMaPhong());
                for(KhachHang kht: khDTO.docDanhSachKhachHang()){
                    if(kht.getMaKhachHang().compareTo(hdpt.getMaKhachHang())==0){
                        tkh = kht.getHo()+" "+kht.getTen();
                    }
                }
                vt.add(tkh);
                vt.add(hdpt.getTienPhong());
                vt.add(hdpt.getNgayThue());
                vt.add(hdpt.getNgayTra());
                vt.add(hdpt.getTrangThai());
                vt.add(hdpt.getGhiChu());
                model.addRow(vt);
            }
        }
    }
    
    public DefaultTableModel getModel(){
        return model;
    }
}
