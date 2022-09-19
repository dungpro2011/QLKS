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
import qlks.DTO.HopDongThuePhong;

/**
 *
 * @author admin
 */
public class HopDongThuePhongDAO {
    private MyConnection connection;
    
    public HopDongThuePhongDAO(){
        connection = null;
    }
    
    public ArrayList<HopDongThuePhong>  docDanhSachHopDongThuePhong(){
        connection = new MyConnection();
        HopDongThuePhong hdtp;
        ArrayList<HopDongThuePhong> dsHDTP = new ArrayList<>();
        try{
            ResultSet resultSet = connection.executeQuery("select * from HopDongThuePhong;");
            while(resultSet.next()){
                hdtp = new HopDongThuePhong();
                hdtp.setSoHopDongThuePhong(resultSet.getString(1));
                hdtp.setMaNhanVien(resultSet.getString(2));
                hdtp.setMaPhong(resultSet.getString(3));
                hdtp.setMaKhachHang(resultSet.getString(4));
                hdtp.setTienPhong(resultSet.getInt(5));
                hdtp.setNgayThue(resultSet.getString(6));
                hdtp.setNgayTra(resultSet.getString(7));
                hdtp.setTrangThai(resultSet.getString(8));
                hdtp.setGhiChu(resultSet.getString(9));
                hdtp.setXoa(Boolean.valueOf(resultSet.getString(10)));
                dsHDTP.add(hdtp);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        connection.close();
        return dsHDTP;
    }
    
    public boolean themHopDongThuePhong(HopDongThuePhong hdtp){
        connection = new MyConnection();
        connection.executeUpdate("insert into HopDongThuePhong(SoHopDongThuePhong,MaNhanVien,MaPhong,MaKhachHang,"
                + "TienPhong,NgayThue,NgayTra,TrangThai,GhiChu,Xoa)\n" 
                + "value ('"+hdtp.getSoHopDongThuePhong()+"','"+hdtp.getMaNhanVien()+"','"+hdtp.getMaPhong()+"',"
                + "'"+hdtp.getMaKhachHang()+"',"+hdtp.getTienPhong()+",'"+hdtp.getNgayThue()+"','"+hdtp.getNgayTra()+"',"
                + "'"+hdtp.getTrangThai()+"','"+hdtp.getGhiChu()+"','"+hdtp.isXoa()+"')");
        connection.close();
        return true;
    }
    
    public boolean suaHopDongThuePhong(HopDongThuePhong hdtp){
        connection = new MyConnection();
        connection.executeUpdate("update HopDongThuePhong set MaNhanVien = '"+hdtp.getMaNhanVien()+"', "
                + "MaPhong = '"+hdtp.getMaPhong()+"', MaKhachHang = '"+hdtp.getMaKhachHang()+"', TienPhong = "
                + ""+hdtp.getTienPhong()+", NgayThue = '"+hdtp.getNgayThue()+"', NgayTra = '"+hdtp.getNgayTra()+"', \n" 
                + "TrangThai = '"+hdtp.getTrangThai()+"', GhiChu = '"+hdtp.getGhiChu()+"', Xoa = '"+hdtp.isXoa()+"'\n" 
                + "where SoHopDongThuePhong = '"+hdtp.getSoHopDongThuePhong()+"'");
        connection.close();
        return true;
    }
    
    public boolean xoaHopDongThuePhong(String shdtp){
        connection = new MyConnection();
        connection.executeUpdate("update HopDongThuePhong set Xoa = 'true'\n" 
                + "where SoHopDongThuePhong = '"+shdtp+"'");
        connection.close();
        return true;
    }
}
