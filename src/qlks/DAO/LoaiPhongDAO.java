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
import qlks.DTO.LoaiPhong;

/**
 *
 * @author admin
 */
public class LoaiPhongDAO {
    private MyConnection connection;
    
    public LoaiPhongDAO(){
        connection = null;
    }
    
    public ArrayList<LoaiPhong> docDanhSachLoaiPhong(){
        connection = new MyConnection();
        ArrayList<LoaiPhong> dslp = new ArrayList<>();
        LoaiPhong lp;
        try{
            ResultSet resultSet = connection.executeQuery("select * from LoaiPhong");
            while(resultSet.next()){
                lp = new LoaiPhong();
                lp.setMaLoaiPhong(resultSet.getString(1));
                lp.setTenLoaiPhong(resultSet.getString(2));
                lp.setSoNguoi(resultSet.getInt(3));
                lp.setGiaTien(resultSet.getInt(4));
                dslp.add(lp);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "lp1 "+e);
        }
        connection.close();
        return dslp; 
    }
    
    public boolean themLoaiPhong(LoaiPhong lp){
        connection = new MyConnection();
        connection.executeUpdate("insert into LoaiPhong(MaLoaiPhong,TenLoaiPhong,SoNguoi,GiaTien)\n" +
                "value ('"+lp.getMaLoaiPhong()+"','"+lp.getTenLoaiPhong()+"',"+lp.getSoNguoi()+","+lp.getGiaTien()+")");
        connection.close();
        return true;
    }
    
    public boolean suaLoaiPhong(LoaiPhong lp, String mlp){
        connection = new MyConnection();
        connection.executeUpdate("update LoaiPhong set TenLoaiPhong = '"+lp.getTenLoaiPhong()+"', "
                + "SoNguoi = "+lp.getSoNguoi()+", GiaTien = "+lp.getGiaTien()+"\n" +
                "where MaLoaiPhong = '"+mlp+"'");
        connection.close();
        return true;
    }
    
    public boolean xoaLoaiPhong(String mlp){
        connection = new MyConnection();
        connection.executeUpdate("delete from LoaiPhong where MaLoaiPhong = '"+mlp+"'");
        connection.close();
        return true;
    }
}
