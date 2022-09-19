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
import qlks.DTO.KhuyenMai;

/**
 *
 * @author admin
 */
public class KhuyenMaiDAO {
    private MyConnection connection;
    
    public KhuyenMaiDAO(){
        connection = null;
    }
    
    public ArrayList<KhuyenMai> docDanhSachKhuyenMai(){
        connection = new MyConnection();
        ArrayList<KhuyenMai> dskm = new ArrayList<>();
        KhuyenMai km;
        try{
            ResultSet resultSet = connection.executeQuery("select * from ChuongTrinhKhuyenMai");
            while(resultSet.next()){
                km = new KhuyenMai();
                km.setMaChuongTrinhKhuyenMai(resultSet.getString(1));
                km.setTenChuongTrinhKhuyenMai(resultSet.getString(2));
                km.setThoiGianBatDau(resultSet.getString(3));
                km.setTHoiGianKetThuc(resultSet.getString(4));
                km.setGiamGia(resultSet.getInt(5));
                km.setXoa(Boolean.valueOf(resultSet.getString(6)));
                dskm.add(km);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "km1 "+e);
        }
        connection.close();
        return dskm; 
    }
    
    public boolean themKhuyenMai(KhuyenMai km){
        connection = new MyConnection();
        connection.executeUpdate("insert into ChuongTrinhKhuyenMai(MaChuongTrinhKhuyenMai,TenChuongTrinhKhuyenMai,"
                + "ThoiGianBatDau,THoiGianKetThuc,GiamGia,Xoa)\n" 
                + "value ('"+km.getMaChuongTrinhKhuyenMai()+"','"+km.getTenChuongTrinhKhuyenMai()+"',"
                + "'"+km.getThoiGianBatDau()+"','"+km.getTHoiGianKetThuc()+"',"+km.getGiamGia()+",'"+km.isXoa()+"')");
        connection.close();
        return true;
    }
    
    public boolean suaKhuyenMai(KhuyenMai km){
        connection = new MyConnection();
        connection.executeUpdate("update ChuongTrinhKhuyenMai set TenChuongTrinhKhuyenMai = '"+km.getTenChuongTrinhKhuyenMai()+"', "
                + "ThoiGianBatDau = '"+km.getThoiGianBatDau()+"', \n" 
                + "THoiGianKetThuc = '"+km.getTHoiGianKetThuc()+"', GiamGia = "+km.getGiamGia()+", Xoa = '"+km.isXoa()+"'\n" 
                + "where MaChuongTrinhKhuyenMai = '"+km.getMaChuongTrinhKhuyenMai()+"'");
        connection.close();
        return true;
    }
    
    public boolean xoaKhuyenMai(String mkm){
        connection = new MyConnection();
        connection.executeUpdate("update ChuongTrinhKhuyenMai set Xoa = 'true'\n" 
                + "where MaChuongTrinhKhuyenMai = '"+mkm+"'");
        connection.close();
        return true;
    }
}
