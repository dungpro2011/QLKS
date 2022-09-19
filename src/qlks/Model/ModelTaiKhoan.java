/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlks.Model;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import qlks.DTO.NhanVien;

/**
 *
 * @author admin
 */
public class ModelTaiKhoan {
    private DefaultTableModel model;
    
    public ModelTaiKhoan(ArrayList<NhanVien> dsnv){
        Vector vt = new Vector();
        vt.add("Nhân viên");
        vt.add("Tài khoản");
        vt.add("Mật khẩu");
        model = new DefaultTableModel(vt,0);
        for(NhanVien nv: dsnv){
            if(nv.isXoa()==false){
                vt = new Vector();
                vt.add(nv.getHo()+" "+nv.getTen());
                vt.add(nv.getMaNhanVien());
                vt.add(nv.getMatKhau());
                model.addRow(vt);
            }
        }
    }
    
    public DefaultTableModel getModel(){
        return model;
    }
}
