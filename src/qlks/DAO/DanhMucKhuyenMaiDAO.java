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
import qlks.DTO.DanhMucKhuyenMai;

/**
 *
 * @author admin
 */
public class DanhMucKhuyenMaiDAO {
    private MyConnection connection;
    
    public DanhMucKhuyenMaiDAO(){
        connection = null;
    }
    
    public ArrayList<DanhMucKhuyenMai>  docDanhSachDanhMucKhuyenMai(){
        connection = new MyConnection();
        DanhMucKhuyenMai dmkm;
        ArrayList<DanhMucKhuyenMai> dsdmkm = new ArrayList<>();
        try{
            ResultSet resultSet = connection.executeQuery("select * from ChiTietKhuyenMai;");
            while(resultSet.next()){
                dmkm = new DanhMucKhuyenMai();
                dmkm.setSoHopDongThuePhong(resultSet.getString(1));
                dmkm.setMaChuongTrinhKhuyenMai(resultSet.getString(2));
                dmkm.setLoaiKhuyenMai(resultSet.getString(3));
                dmkm.setNgayKhuyenMai(resultSet.getString(4));
                dmkm.setNoiDunngKhuyenMai(resultSet.getString(5));
                dmkm.setGiamGia(resultSet.getInt(6));
                dsdmkm.add(dmkm);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        connection.close();
        return dsdmkm;
    }
    
    public boolean themDanhMucKhuyenMai(DanhMucKhuyenMai dmkm){
        connection = new MyConnection();
        connection.executeUpdate("insert into ChiTietKhuyenMai(SoHopDongThuePhong,MaChuongTrinhKhuyenMai,LoaiKhuyenMai,NgayKhuyenMai,NoiDunngKhuyenMai,GiamGia)\n" +
                "value ('"+dmkm.getSoHopDongThuePhong()+"','"+dmkm.getMaChuongTrinhKhuyenMai()+"','"+dmkm.getLoaiKhuyenMai()+"',"
                + "'"+dmkm.getNgayKhuyenMai()+"','"+dmkm.getNoiDunngKhuyenMai()+"',"+dmkm.getGiamGia()+")");
        connection.close();
        return true;
    }
    
    public boolean suaDanhMucKhuyenMai(DanhMucKhuyenMai dmkm){
        connection = new MyConnection();
        connection.executeUpdate("update ChiTietKhuyenMai set LoaiKhuyenMai = '"+dmkm.getLoaiKhuyenMai()+"', NgayKhuyenMai = '"+dmkm.getNgayKhuyenMai()+"',\n" +
                "NoiDunngKhuyenMai = '"+dmkm.getNoiDunngKhuyenMai()+"',GiamGia = '"+dmkm.getGiamGia()+"'\n" +
                "where SoHopDongThuePhong = '"+dmkm.getSoHopDongThuePhong()+"' and MaChuongTrinhKhuyenMai = '"+dmkm.getMaChuongTrinhKhuyenMai()+"'");
        connection.close();
        return true;
    }
    
    public boolean xoaDanhMucKhuyenMai(String shdtp, String mctkm){
        connection = new MyConnection();
        connection.executeUpdate("delete from ChiTietKhuyenMai where SoHopDongThuePhong = '"+shdtp+"' and MaChuongTrinhKhuyenMai = '"+mctkm+"'");
        connection.close();
        return true;
    }
}
