
package qlks.DTO;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class NhanVien {
    private String MaNhanVien;
    private String Ho;
    private String Ten;
    private String NgaySinh;
    private String GioiTinh;
    private String DiaChi;
    private String CMMD;
    private String DienThoai;
    private String NgayVaoLam;
    private int LuongThang;
    private String MatKhau;
    private boolean Xoa;
    
    public NhanVien() {
        this.MaNhanVien = "";
        this.Ho = "";
        this.Ten = "";
        this.NgaySinh = null;
        this.GioiTinh = "";
        this.DiaChi = "";
        this.CMMD = "";
        this.DienThoai = "";
        this.NgayVaoLam = null;
        this.LuongThang = 0;
        this.MatKhau = "123";
        this.Xoa = false;
    }

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String MaNhanVien) {
        this.MaNhanVien = MaNhanVien;
    }

    public String getHo() {
        return Ho;
    }

    public void setHo(String Ho) {
        this.Ho = Ho;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }
    
    public boolean setNgaySinhKT(String NgaySinh) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        formatter.setLenient(false);
        try {
            formatter.parse(NgaySinh);
            this.NgaySinh = NgaySinh;
            return true;
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Nhập ngày sinh YYYY-MM-DD");
            return false;
        }
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getCMMD() {
        return CMMD;
    }

    public void setCMMD(String CMMD) {
        this.CMMD = CMMD;
    }

    public String getDienThoai() {
        return DienThoai;
    }

    public void setDienThoai(String DienThoai) {
        this.DienThoai = DienThoai;
    }

    public String getNgayVaoLam() {
        return NgayVaoLam;
    }

    public void setNgayVaoLam(String NgayVaoLam) {
        this.NgayVaoLam = NgayVaoLam;
    }

    public boolean setNgayVaoLamKT(String NgayVaoLam) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        formatter.setLenient(false);
        try {
            formatter.parse(NgayVaoLam);
            this.NgayVaoLam = NgayVaoLam;
            return true;
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Nhập ngày vào làm YYYY-MM-DD");
            return false;
        }
    }

    public int getLuongThang() {
        return LuongThang;
    }

    public boolean setLuongThang(String LuongThang) {
        try{
            this.LuongThang = Integer.parseInt(LuongThang);
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Lương tháng là số");
            return false;
        }
    }
    
    public void setLuongThang(int LuongThang) {
        this.LuongThang = LuongThang;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public boolean isXoa() {
        return Xoa;
    }

    public void setXoa(boolean Xoa) {
        this.Xoa = Xoa;
    }
    
    
}