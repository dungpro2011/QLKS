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
import qlks.DTO.MatHang;

/**
 *
 * @author admin
 */
public class MatHangDAO {
    private MyConnection connection;
    
    public MatHangDAO(){
        connection = null;
    }
    
    public ArrayList<MatHang> docDanhSachMatHang(){
        connection = new MyConnection();
        ArrayList<MatHang> dsmh = new ArrayList<>();
        MatHang mh;
        try{
            ResultSet resultSet = connection.executeQuery("select * from MatHang");
            while(resultSet.next()){
                mh = new MatHang();
                mh.setMaMatHang(resultSet.getString(1));
                mh.setTenMatHang(resultSet.getString(2));
                mh.setSoLuong(resultSet.getInt(3));
                mh.setDonGia(resultSet.getInt(4));
                mh.setXoa(Boolean.valueOf(resultSet.getString(5)));
                dsmh.add(mh);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "mh "+e);
        }
        connection.close();
        return dsmh; 
    }
    
    public boolean themMatHang(MatHang mh){
        connection = new MyConnection();
        connection.executeUpdate("insert into MatHang(MaMatHang,TenMatHang,SoLuong,DonGia,Xoa)\n" +
                "value ('"+mh.getMaMatHang()+"','"+mh.getTenMatHang()+"',"+mh.getSoLuong()+","+mh.getDonGia()+",'"+mh.isXoa()+"')");
        connection.close();
        return true;
    }
    
    public boolean suaMatHang(MatHang mh){
        connection = new MyConnection();
        connection.executeUpdate("update MatHang set TenMatHang = '"+mh.getTenMatHang()+"', "
                + "SoLuong = "+mh.getSoLuong()+", DonGia = "+mh.getDonGia()+", Xoa = '"+mh.isXoa()+"'\n" +
                "where MaMatHang = '"+mh.getMaMatHang()+"'");
        connection.close();
        return true;
    }
    
    public boolean xoaMatHang(String mmh){
        connection = new MyConnection();
        connection.executeUpdate("update MatHang set Xoa = 'true'\n" +
                "where MaMatHang = '"+mmh+"'");
        connection.close();
        return true;
    }
}
