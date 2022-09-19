
package qlks.DTO;

import javax.swing.JOptionPane;


public class DichVu {
    private String MaDichVu;
    private String TenDichVu;
    private int DonGia;
    private String MatHang;
    private boolean Xoa;

    public DichVu() {
        this.MaDichVu = "";
        this.TenDichVu = "";
        this.DonGia = 0;
        this.MatHang = "";
        this.Xoa = false;
    }

    public String getMaDichVu() {
        return MaDichVu;
    }

    public void setMaDichVu(String MaDichVu) {
        this.MaDichVu = MaDichVu;
    }

    public String getTenDichVu() {
        return TenDichVu;
    }

    public void setTenDichVu(String TenDichVu) {
        this.TenDichVu = TenDichVu;
    }

    public int getDonGia() {
        return DonGia;
    }

    public void setDonGia(int DonGia) {
        this.DonGia = DonGia;
    }
    
    public boolean setDonGia(String DonGia) {
        try{
            this.DonGia = Integer.parseInt(DonGia);
            return true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Giá dịch vụ là số");
            return false;
        } 
    }

    public String getMatHang() {
        return MatHang;
    }

    public void setMatHang(String MatHang) {
        this.MatHang = MatHang;
    }

    public boolean isXoa() {
        return Xoa;
    }

    public void setXoa(boolean Xoa) {
        this.Xoa = Xoa;
    }
    
    

}
