
package qlks.DTO;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class HoaDon {
    private String SoHoaDon;
    private String SoHopDongThuePhong;
    private String MaNhanVien;
    private String MaKhachHang;
    private String NgayThue;
    private String NgayThanhToan;
    private int TienThuePhong;
    private int TienDichVu;
    private int TienKhuyenMai;
    private int Thue;
    private int TongTien;

    public HoaDon() {
        this.SoHoaDon = "";
        this.SoHopDongThuePhong = "";
        this.MaNhanVien = "";
        this.MaKhachHang = "";
        this.NgayThue = "";
        this.NgayThanhToan = "";
        this.TienThuePhong = 0;
        this.TienDichVu = 0;
        this.TienKhuyenMai = 0;
        this.Thue = 0;
        this.TongTien = 0;
    }

    public String getSoHoaDon() {
        return SoHoaDon;
    }

    public void setSoHoaDon(String SoHoaDon) {
        this.SoHoaDon = SoHoaDon;
    }
    
    public boolean setSoHoaDonKT(String SoHoaDon) {
        try{
            Integer.parseInt(SoHoaDon);
            this.SoHoaDon = SoHoaDon;
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Số hóa đơn là số");
            return false;
        }
    }

    public String getSoHopDongThuePhong() {
        return SoHopDongThuePhong;
    }

    public void setSoHopDongThuePhong(String SoHopDongThuePhong) {
        this.SoHopDongThuePhong = SoHopDongThuePhong;
    }

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public String getNgayThanhToan() {
        return NgayThanhToan;
    }

    public void setNgayThanhToan(String NgayThanhToan) {
        this.NgayThanhToan = NgayThanhToan;
    }
    
    public boolean setNgayThanhToanKT(String NgayThanhToan, String NgayThue) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        formatter.setLenient(false);
        try {
            Date ngayThanhToan = formatter.parse(NgayThanhToan);
            Date ngayThue = formatter.parse(NgayThue);
            if(ngayThanhToan.before(ngayThue)){
                JOptionPane.showMessageDialog(null, "Ngày thanh toán phải sau ngày thuê");
                return false;
            }
            this.NgayThanhToan = NgayThanhToan;
            return true;
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Nhập ngày thuê YYYY-MM-DD");
            return false;
        }
    }

    public int getTienThuePhong() {
        return TienThuePhong;
    }

    public void setTienThuePhong(int TienThuePhong) {
        this.TienThuePhong = TienThuePhong;
    }
    
    public boolean setTienThuePhong(String TienThuePhong) {
        try{
            this.TienThuePhong = Integer.parseInt(TienThuePhong);
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Tiền thuê phòng là số");
            return false;
        }
    }

    public int getTienDichVu() {
        return TienDichVu;
    }

    public void setTienDichVu(int TienDichVu) {
        this.TienDichVu = TienDichVu;
    }
    
    public boolean setTienDichVu(String TienDichVu) {
        try{
            this.TienDichVu = Integer.parseInt(TienDichVu);
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Tiền dịch vụ là số");
            return false;
        }
    }

    public int getTienKhuyenMai() {
        return TienKhuyenMai;
    }

    public void setTienKhuyenMai(int TienKhuyenMai) {
        this.TienKhuyenMai = TienKhuyenMai;
    }
    
    public boolean setTienKhuyenMai(String TienKhuyenMai) {
        try{
            this.TienKhuyenMai = Integer.parseInt(TienKhuyenMai);
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Tiền khuyến mãi là số");
            return false;
        }
    }

    public int getThue() {
        return Thue;
    }

    public void setThue(int Thue) {
        this.Thue = Thue;
    }
    
    public boolean setThue(String Thue) {
        try{
            this.Thue = Integer.parseInt(Thue);
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Thuế là số");
            return false;
        }
    }

    public int getTongTien() {
        return TongTien;
    }

    public void setTongTien(int TongTien) {
        this.TongTien = TongTien;
    }
    
    public boolean setTongTien(String TongTien) {
        try{
            this.TongTien = Integer.parseInt(TongTien);
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Tổng tiền là số");
            return false;
        }
    }

    public String getNgayThue() {
        return NgayThue;
    }

    public void setNgayThue(String NgayThue) {
        this.NgayThue = NgayThue;
    }

    public String getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(String MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
    }

}
