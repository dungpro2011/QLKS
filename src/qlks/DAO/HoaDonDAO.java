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
import qlks.DTO.HoaDon;

/**
 *
 * @author admin
 */
public class HoaDonDAO {
    private MyConnection connection;
    
    public HoaDonDAO(){
        connection = null;
    }
    
    public ArrayList<HoaDon>  docDanhSachHoaDon(){
        connection = new MyConnection();
        HoaDon hd;
        ArrayList<HoaDon> dshd = new ArrayList<>();
        try{
            ResultSet resultSet = connection.executeQuery("select * from HoaDonThanhToan");
            while(resultSet.next()){
                hd = new HoaDon();
                hd.setSoHoaDon(resultSet.getString(1));
                hd.setSoHopDongThuePhong(resultSet.getString(2));
                hd.setMaNhanVien(resultSet.getString(3));
                hd.setNgayThanhToan(resultSet.getString(4));
                hd.setTienThuePhong(resultSet.getInt(5));
                hd.setTienDichVu(resultSet.getInt(6));
                hd.setTienKhuyenMai(resultSet.getInt(7));
                hd.setThue(resultSet.getInt(8));
                hd.setTongTien(resultSet.getInt(9));
                dshd.add(hd);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        connection.close();
        return dshd;
    }
    
    public boolean themHoaDon(HoaDon hd){
        connection = new MyConnection();
        connection.executeUpdate("insert into HoaDonThanhToan(SoHoaDon,SoHopDongThuePhong,MaNhanVien,"
                + "NgayThanhToan,TienThuePhong,TienDichVu,TienKhuyenMai,Thue,TongTien)\n" +
                "value ('"+hd.getSoHoaDon()+"','"+hd.getSoHopDongThuePhong()+"','"+hd.getMaNhanVien()+"','"+hd.getNgayThanhToan()+"'"
                + ","+hd.getTienThuePhong()+","+hd.getTienDichVu()+","+hd.getTienKhuyenMai()+","+hd.getThue()+","+hd.getTongTien()+");");
        connection.close();
        return true;
    }
        
    public boolean suaHoaDon(HoaDon hd, String shd){
        connection = new MyConnection();
        connection.executeUpdate("update HoaDonThanhToan set SoHopDongThuePhong = '"+hd.getSoHopDongThuePhong()+"', "
                + "MaNhanVien = '"+hd.getMaNhanVien()+"', NgayThanhToan = '"+hd.getNgayThanhToan()+"',\n" 
                + "TienThuePhong = "+hd.getTienThuePhong()+", TienDichVu = "+hd.getTienDichVu()+", "
                + "TienKhuyenMai = "+hd.getTienKhuyenMai()+", Thue = "+hd.getThue()+", TongTien = "+hd.getTongTien()+"\n" +
                "where SoHoaDon = '"+shd+"'");
        connection.close();
        return true;
    }
    
    public boolean xoaHoaDon(String shd){
        connection = new MyConnection();
        connection.executeUpdate("delete from HoaDonThanhToan where SoHoaDon = '"+shd+"'");
        connection.close();
        return true;
    }
}
