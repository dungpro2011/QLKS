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
import qlks.DTO.PhieuNhapHang;

/**
 *
 * @author admin
 */
public class PhieuNhapHangDAO {
    private MyConnection connection;
    
    public PhieuNhapHangDAO(){
        connection = null;
    }
    
    public ArrayList<PhieuNhapHang> docDanhSachPhieuNhapHang(){
        connection = new MyConnection();
        ArrayList<PhieuNhapHang> dsp = new ArrayList<>();
        PhieuNhapHang pnh;
        try{
            ResultSet resultSet = connection.executeQuery("select * from PhieuNhapHang");
            while(resultSet.next()){
                pnh = new PhieuNhapHang();
                pnh.setMaPhieuNhapHang(resultSet.getString(1));
                pnh.setMaNhanVien(resultSet.getString(2));
                pnh.setNgayNhapHang(resultSet.getString(3));
                pnh.setNhaCungCap(resultSet.getString(4));
                pnh.setTongTien(resultSet.getInt(5));
                dsp.add(pnh);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "pnh 1"+e);
        }
        connection.close();
        return dsp; 
    }
    
    public ArrayList<PhieuNhapHang> danhSachNgayNhap(String tu, String den){
        connection = new MyConnection();
        ArrayList<PhieuNhapHang> dsp = new ArrayList<>();
        PhieuNhapHang pnh;
        try{
            ResultSet resultSet = connection.executeQuery("select * from PhieuNhapHang where NgayNhapHang between '"+tu+"' and '"+den+"'");
            while(resultSet.next()){
                pnh = new PhieuNhapHang();
                pnh.setMaPhieuNhapHang(resultSet.getString(1));
                pnh.setMaNhanVien(resultSet.getString(2));
                pnh.setNgayNhapHang(resultSet.getString(3));
                pnh.setNhaCungCap(resultSet.getString(4));
                pnh.setTongTien(resultSet.getInt(5));
                dsp.add(pnh);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "pnh 2"+e);
        }
        connection.close();
        return dsp; 
    }
    
    public boolean themPhieuNhapHang(PhieuNhapHang pnh){
        connection = new MyConnection();
        connection.executeUpdate("insert into PhieuNhapHang(MaPhieuNhapHang,MaNhanVien,NgayNhapHang,NhaCungCap,TongTien)\n" +
                "value ('"+pnh.getMaPhieuNhapHang()+"','"+pnh.getMaNhanVien()+"','"+pnh.getNgayNhapHang()+"',"
                        + "'"+pnh.getNhaCungCap()+"',"+pnh.getTongTien()+")");
        connection.close();
        return true;
    }
    
    public boolean suaPhieuNhapHang(PhieuNhapHang pnh){
        connection = new MyConnection();
        connection.executeUpdate("update PhieuNhapHang set MaNhanVien = '"+pnh.getMaNhanVien()+"', "
                + "NgayNhapHang = '"+pnh.getNgayNhapHang()+"', NhaCungCap = '"+pnh.getNhaCungCap()+"', TongTien = "+pnh.getTongTien()+"\n" +
                "where MaPhieuNhapHang = '"+pnh.getMaPhieuNhapHang()+"'");
        connection.close();
        return true;
    }
    
    public boolean xoaPhieuNhapHang(String mpnh){
        connection = new MyConnection();
        connection.executeUpdate("delete from PhieuNhapHang where MaPhieuNhapHang = '"+mpnh+"'");
        connection.close();
        return true;
    }
}
