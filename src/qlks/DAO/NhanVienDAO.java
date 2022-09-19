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
import qlks.DTO.NhanVien;

/**
 *
 * @author admin
 */
public class NhanVienDAO {
    private MyConnection connection;
    
    public NhanVienDAO(){
        connection = null;
    }
    
    public ArrayList<NhanVien> docDanhSachNhanVien(){
        connection = new MyConnection();
        ArrayList<NhanVien> dsnv = new ArrayList<>();
        NhanVien nv;
        try{
            ResultSet resultSet = connection.executeQuery("select * from NhanVien");
            while(resultSet.next()){
                nv = new NhanVien();
                nv.setMaNhanVien(resultSet.getString(1));
                nv.setHo(resultSet.getString(2));
                nv.setTen(resultSet.getString(3));
                nv.setNgaySinh(resultSet.getString(4));
                nv.setGioiTinh(resultSet.getString(5));
                nv.setDiaChi(resultSet.getString(6));
                nv.setCMMD(resultSet.getString(7));
                nv.setDienThoai(resultSet.getString(8));
                nv.setNgayVaoLam(resultSet.getString(9));
                nv.setLuongThang(resultSet.getInt(10));
                nv.setMatKhau(resultSet.getString(11));
                nv.setXoa(Boolean.valueOf(resultSet.getString(12)));
                dsnv.add(nv);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "nv1 "+e);
        }
        connection.close();
        return dsnv; 
    }
    
    public boolean themNhanVien(NhanVien nv){
        connection = new MyConnection();
        connection.executeUpdate("insert into NhanVien(MaNhanVien,Ho,Ten,NgaySinh,GioiTinh,"
                + "DiaChi,CMND,DienThoai,NgayVaoLam,LuongThang,MatKhau,Xoa)\n"
                + "value ('"+nv.getMaNhanVien()+"','"+nv.getHo()+"','"+nv.getTen()+"',"
                        + "'"+nv.getNgaySinh()+"','"+nv.getGioiTinh()+"',"
                        + "'"+nv.getDiaChi()+"','"+nv.getCMMD()+"','"+nv.getDienThoai()+"',"
                        + "'"+nv.getNgayVaoLam()+"',"+nv.getLuongThang()+",'"+nv.getMatKhau()+"','"+nv.isXoa()+"')");
        connection.close();
        return true;
    }
    
    public boolean suaNhanVien(NhanVien nv){
        connection = new MyConnection();
        connection.executeUpdate("update NhanVien set MaNhanVien = '"+nv.getMaNhanVien()+"', Ho = '"+nv.getHo()+"', Ten = '"+nv.getTen()+"',"
                + " NgaySinh = '"+nv.getNgaySinh()+"', GioiTinh = '"+nv.getGioiTinh()+"',\n" 
                + "DiaChi = '"+nv.getDiaChi()+"', CMND = '"+nv.getCMMD()+"', DienThoai = '"+nv.getDienThoai()+"',"
                + " NgayVaoLam = '"+nv.getNgayVaoLam()+"', LuongThang = "+nv.getLuongThang()+","
                + "MatKhau = '"+nv.getMatKhau()+"', Xoa = '"+nv.isXoa()+"'\n" 
                + "where MaNhanVien = '"+nv.getMaNhanVien()+"'");
        connection.close();
        return true;
    }
    
    //Neu xoa thi sua lai thuoc tinh Xoa la true (Mat dinh la false)
    public boolean xoaNhanVien(String mnv){
        connection = new MyConnection();
        connection.executeUpdate("update NhanVien set Xoa = 'true'\n" 
                + "where MaNhanVien = '"+mnv+"'");
        connection.close();
        return true;
    }
    
    public boolean doiMatKhauNhanVien(String mnv, String mk){
        connection = new MyConnection();
        connection.executeUpdate("update NhanVien set MatKhau = '"+mk+"'\n" 
                + "where MaNhanVien = '"+mnv+"'");
        connection.close();
        return true;
    }
}
