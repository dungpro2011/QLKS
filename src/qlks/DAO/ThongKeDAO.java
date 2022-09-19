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
public class ThongKeDAO {
    private MyConnection connection;
    
    public ThongKeDAO(){
        connection = null;
    }
    
    public ArrayList<HoaDon>  thongKe(){
        connection = new MyConnection();
        HoaDon hd;
        ArrayList<HoaDon> dshd = new ArrayList<>();
        try{
            ResultSet resultSet = connection.executeQuery("select hdtt.SoHoaDon,hdtt.MaNhanVien,hdtp.MaKhachHang,hdtp.NgayThue,hdtt.NgayThanhToan,hdtt.TongTien\n" +
                    "from HoaDonThanhToan hdtt left join HopDongThuePhong hdtp on \n" +
                    "hdtt.SoHopDongThuePhong = hdtp.SoHopDongThuePhong");
            while(resultSet.next()){
                hd = new HoaDon();
                hd.setSoHoaDon(resultSet.getString(1));
                hd.setMaNhanVien(resultSet.getString(2));
                hd.setMaKhachHang(resultSet.getString(3));
                hd.setNgayThue(resultSet.getString(4));
                hd.setNgayThanhToan(resultSet.getString(5));
                hd.setTongTien(resultSet.getInt(6));
                dshd.add(hd);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        connection.close();
        return dshd;
    }
    
    public ArrayList<HoaDon>  thongKeNgayThanhToan(String tu, String den){
        connection = new MyConnection();
        HoaDon hd;
        ArrayList<HoaDon> dshd = new ArrayList<>();
        try{
            ResultSet resultSet = connection.executeQuery("select hdtt.SoHoaDon,hdtt.MaNhanVien,hdtp.MaKhachHang,hdtp.NgayThue,hdtt.NgayThanhToan,hdtt.TongTien\n" +
                    "from HoaDonThanhToan hdtt left join HopDongThuePhong hdtp on \n" +
                    "hdtt.SoHopDongThuePhong = hdtp.SoHopDongThuePhong\n" +
                    "where hdtt.NgayThanhToan between '"+tu+"' and '"+den+"'");
            while(resultSet.next()){
                hd = new HoaDon();
                hd.setSoHoaDon(resultSet.getString(1));
                hd.setMaNhanVien(resultSet.getString(2));
                hd.setMaKhachHang(resultSet.getString(3));
                hd.setNgayThue(resultSet.getString(4));
                hd.setNgayThanhToan(resultSet.getString(5));
                hd.setTongTien(resultSet.getInt(6));
                dshd.add(hd);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        connection.close();
        return dshd;
    }
    
    public ArrayList<HoaDon>  thongKeNgayThue(String tu, String den){
        connection = new MyConnection();
        HoaDon hd;
        ArrayList<HoaDon> dshd = new ArrayList<>();
        try{
            ResultSet resultSet = connection.executeQuery("select hdtt.SoHoaDon,hdtt.MaNhanVien,hdtp.MaKhachHang,hdtp.NgayThue,hdtt.NgayThanhToan,hdtt.TongTien\n" +
                    "from HoaDonThanhToan hdtt left join HopDongThuePhong hdtp on \n" +
                    "hdtt.SoHopDongThuePhong = hdtp.SoHopDongThuePhong\n" +
                    "where hdtp.NgayThue between '"+tu+"' and '"+den+"'");
            while(resultSet.next()){
                hd = new HoaDon();
                hd.setSoHoaDon(resultSet.getString(1));
                hd.setMaNhanVien(resultSet.getString(2));
                hd.setMaKhachHang(resultSet.getString(3));
                hd.setNgayThue(resultSet.getString(4));
                hd.setNgayThanhToan(resultSet.getString(5));
                hd.setTongTien(resultSet.getInt(6));
                dshd.add(hd);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        connection.close();
        return dshd;
    }
}
