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
import qlks.DTO.ChiTietNhapHang;

/**
 *
 * @author admin
 */
public class ChiTietNhapHangDAO {
    private MyConnection connection;
    
    public ChiTietNhapHangDAO(){
        connection = null;
    }
    
    public ArrayList<ChiTietNhapHang>  docDanhSachChiTietNhapHang(){
        connection = new MyConnection();
        ChiTietNhapHang ctnh;
        ArrayList<ChiTietNhapHang> dsctnh = new ArrayList<>();
        try{
            ResultSet resultSet = connection.executeQuery("select * from ChiTietPhieuNhapHang");
            while(resultSet.next()){
                ctnh = new ChiTietNhapHang();
                ctnh.setMaPhieuNhapHang(resultSet.getString(1));
                ctnh.setMaMatHang(resultSet.getString(2));
                ctnh.setDonGia(resultSet.getInt(3));
                ctnh.setSoLuong(resultSet.getInt(4));
                ctnh.setThanhTien(resultSet.getInt(5));
                dsctnh.add(ctnh);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        connection.close();
        return dsctnh;
    }
    
    public boolean themChiTietNhapHang(ChiTietNhapHang ctnh){
        connection = new MyConnection();
        connection.executeUpdate("insert into ChiTietPhieuNhapHang(MaPhieuNhapHang,MaMatHang,DonGia,SoLuong,ThanhTien)\n" +
                "value ('"+ctnh.getMaPhieuNhapHang()+"','"+ctnh.getMaMatHang()+"',"+ctnh.getDonGia()+","+ctnh.getSoLuong()+","+ctnh.getThanhTien()+")");
        connection.close();
        return true;
    }
    
    public boolean suaChiTietNhapHang(ChiTietNhapHang ctnh){
        connection = new MyConnection();
        connection.executeUpdate("update ChiTietPhieuNhapHang set DonGia = "+ctnh.getDonGia()+", SoLuong = "+ctnh.getSoLuong()+", ThanhTien = "+ctnh.getThanhTien()+"\n" +
                "where MaPhieuNhapHang = '"+ctnh.getMaPhieuNhapHang()+"' and MaMatHang = '"+ctnh.getMaMatHang()+"'");
        connection.close();
        return true;
    }
    
    public boolean xoaChiTietNhapHang(String mpn, String mmh){
        connection = new MyConnection();
        connection.executeUpdate("delete from ChiTietPhieuNhapHang where MaPhieuNhapHang = '"+mpn+"' and MaMatHang = '"+mmh+"'");
        connection.close();
        return true;
    }
}
