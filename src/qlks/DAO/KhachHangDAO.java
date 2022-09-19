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
import qlks.DTO.KhachHang;

/**
 *
 * @author admin
 */
public class KhachHangDAO {
    private MyConnection connection;
    
    public KhachHangDAO(){
        connection = null;
    }
    
    public ArrayList<KhachHang> docDanhSachKhachHang(){
        connection = new MyConnection();
        ArrayList<KhachHang> dskh = new ArrayList<>();
        KhachHang kh;
        try{
            ResultSet resultSet = connection.executeQuery("select * from KhachHang");
            while(resultSet.next()){
                kh = new KhachHang();
                kh.setMaKhachHang(resultSet.getString(1));
                kh.setHo(resultSet.getString(2));
                kh.setTen(resultSet.getString(3));
                kh.setGioiTinh(resultSet.getString(4));
                kh.setDiaChi(resultSet.getString(5));
                kh.setCMND(resultSet.getString(6));
                kh.setDienThoai(resultSet.getString(7));
                kh.setXoa(Boolean.valueOf(resultSet.getString(8)));
                dskh.add(kh);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "kh1 "+e);
        }
        connection.close();
        return dskh; 
    }
    
    public boolean themKhachHang(KhachHang kh){
        connection = new MyConnection();
        connection.executeUpdate("insert into KhachHang(MaKhachHang,Ho,Ten,GioiTinh,DiaChi,CMND,DienThoai,Xoa)\n" +
                "value ('"+kh.getMaKhachHang()+"','"+kh.getHo()+"','"+kh.getTen()+"','"+kh.getGioiTinh()+"',"
                + "'"+kh.getDiaChi()+"','"+kh.getCMND()+"','"+kh.getDienThoai()+"','"+kh.isXoa()+"')");
        connection.close();
        return true;
    }
    
    public boolean suaKhachHang(KhachHang kh){
        connection = new MyConnection();
        connection.executeUpdate("update KhachHang set Ho = '"+kh.getHo()+"', Ten = '"+kh.getTen()+"', GioiTinh = '"+kh.getGioiTinh()+"',\n" +
                "DiaChi = '"+kh.getDiaChi()+"', CMND = '"+kh.getCMND()+"', DienThoai = '"+kh.getDienThoai()+"', Xoa = '"+kh.isXoa()+"'\n" +
                "where MaKhachHang = '"+kh.getMaKhachHang()+"'");
        connection.close();
        return true;
    }
    
    public boolean xoaKhachHang(String mkh){
        connection = new MyConnection();
        connection.executeUpdate("update KhachHang set Xoa = 'true'\n" +
                "where MaKhachHang = '"+mkh+"'");
        connection.close();
        return true;
    }
}
