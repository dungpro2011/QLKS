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
import qlks.DTO.DichVu;

/**
 *
 * @author admin
 */
public class DichVuDAO {
    private MyConnection connection;
    
    public DichVuDAO(){
        connection = null;
    }
    
    public ArrayList<DichVu>  docDanhSachDichVu(){
        connection = new MyConnection();
        DichVu dv;
        ArrayList<DichVu> dsdv = new ArrayList<>();
        try{
            ResultSet resultSet = connection.executeQuery("select * from DichVu;");
            while(resultSet.next()){
                dv = new DichVu();
                dv.setMaDichVu(resultSet.getString(1));
                dv.setTenDichVu(resultSet.getString(2));
                dv.setDonGia(resultSet.getInt(3));
                dv.setMatHang(resultSet.getString(4));
                dv.setXoa(Boolean.valueOf(resultSet.getString(5)));
                dsdv.add(dv);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        }
        connection.close();
        return dsdv;
    }
    
    public boolean themDichVu(DichVu dv){
        connection = new MyConnection();
        connection.executeUpdate("insert into DichVu(MaDichVu,TenDichVu,DonGia,MatHang,Xoa)\n" +
                "value ('"+dv.getMaDichVu()+"','"+dv.getTenDichVu()+"',"+dv.getDonGia()+",'"+dv.getMatHang()+"','"+dv.isXoa()+"')");
        connection.close();
        return true;
    }
    
    public boolean suaDichVu(DichVu dv){
        connection = new MyConnection();
        connection.executeUpdate("update DichVu set TenDichVu = '"+dv.getTenDichVu()+"', DonGia = "+dv.getDonGia()+", "
                + "MatHang = '"+dv.getMatHang()+"', Xoa = '"+dv.isXoa()+"'\n" +
                "where MaDichVu = '"+dv.getMaDichVu()+"'");
        connection.close();
        return true;
    }
    
    public boolean xoaDichVu(String mdv){
        connection = new MyConnection();
        connection.executeUpdate("update DichVu set Xoa = 'true'" +
                "where MaDichVu = '"+mdv+"'");
        connection.close();
        return true;
    }
}
