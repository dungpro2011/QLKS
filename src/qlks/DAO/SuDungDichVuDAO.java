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
import qlks.DTO.SuDungDichVu;

/**
 *
 * @author admin
 */
public class SuDungDichVuDAO {
    private MyConnection connection;
    
    public SuDungDichVuDAO(){
        connection = null;
    }
    
    public ArrayList<SuDungDichVu> docDanhSachSuDungDichVu(){
        connection = new MyConnection();
        ArrayList<SuDungDichVu> dssddv = new ArrayList<>();
        SuDungDichVu sddv;
        try{
            ResultSet resultSet = connection.executeQuery("select * from SuDungDichVu");
            while(resultSet.next()){
                sddv = new SuDungDichVu();
                sddv.setSoHopDongTHuePhong(resultSet.getString(1));
                sddv.setMaDichVu(resultSet.getString(2));
                sddv.setDonGia(resultSet.getInt(3));
                sddv.setSoLuong(resultSet.getInt(4));
                sddv.setThanhTien(resultSet.getInt(5));
                dssddv.add(sddv);
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "p1 "+e);
        }
        connection.close();
        return dssddv; 
    }
    
    public boolean themSuDungDichVu(SuDungDichVu sddv){
        connection = new MyConnection();
        connection.executeUpdate("insert into SuDungDichVu(SoHopDongThuePhong,MaDichVu,DonGia,SoLuong,ThanhTien)\n" +
                "value ('"+sddv.getSoHopDongTHuePhong()+"','"+sddv.getMaDichVu()+"',"+sddv.getDonGia()+","+sddv.getSoLuong()+","+sddv.getThanhTien()+")");
        connection.close();
        return true;
    }
    
    public boolean suaSuDungDichVu(SuDungDichVu sddv){
        connection = new MyConnection();
        connection.executeUpdate("update SuDungDichVu set DonGia = "+sddv.getDonGia()+", SoLuong = "+sddv.getSoLuong()+", ThanhTien = "+sddv.getThanhTien()+"\n" +
                "where SoHopDongThuePhong = '"+sddv.getSoHopDongTHuePhong()+"' and MaDichVu = '"+sddv.getMaDichVu()+"'");
        connection.close();
        return true;
    }
    
    public boolean xoaSuDungDichVu(String shdp, String mdv){
        connection = new MyConnection();
        connection.executeUpdate("delete from SuDungDichVu where SoHopDongTHuePhong = '"+shdp+"' and MaDichVu = '"+mdv+"'");
        connection.close();
        return true;
    }
}
