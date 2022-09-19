/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package qlks.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import qlks.DTO.Phong;

/**
 *
 * @author admin
 */
public class PhongDAO {
    private MyConnection connection;
    
    public PhongDAO(){
        connection = null;
    }
    
    public ArrayList<Phong> docDanhSachPhong(){
        connection = new MyConnection();
        ArrayList<Phong> dsp = new ArrayList<>();
        Phong p;
        try{
            ResultSet resultSet = connection.executeQuery("select * from DanhMucPhong");
            while(resultSet.next()){
                p = new Phong();
                p.setMaPhong(resultSet.getString(1));
                p.setTenPhong(resultSet.getString(2));
                p.setMaLoaiPhong(resultSet.getString(3));
                p.setTinhTrang(resultSet.getString(4));
                dsp.add(p);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "p1 "+e);
        }
        connection.close();
        return dsp; 
    }
    
    public boolean suaPhong(Phong p){
        connection = new MyConnection();
        connection.executeUpdate("update DanhMucPhong set TenPhong = '"+p.getTenPhong()+"', "
                + "MaLoaiPhong = '"+p.getMaLoaiPhong()+"', TinhTrang = '"+p.getTinhTrang()+"'\n" +
                "where MaPhong = '"+p.getMaPhong()+"'");
        connection.close();
        return true;
    }
}
