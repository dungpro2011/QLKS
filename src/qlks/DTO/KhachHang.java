
package qlks.DTO;


public class KhachHang {
    private String MaKhachHang;
    private String Ho;
    private String Ten;
    private String GioiTinh;
    private String DiaChi;
    private String CMND;
    private String DienThoai;
    private boolean Xoa;

    public KhachHang() {
        this.MaKhachHang = "";
        this.Ho = "";
        this.Ten = "";
        this.GioiTinh = "";
        this.DiaChi = "";
        this.CMND = "";
        this.DienThoai = "";
        this.Xoa = false;
    }

    public String getMaKhachHang() {
        return MaKhachHang;
    }

    public void setMaKhachHang(String MaKhachHang) {
        this.MaKhachHang = MaKhachHang;
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

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getDienThoai() {
        return DienThoai;
    }

    public void setDienThoai(String DienThoai) {
        this.DienThoai = DienThoai;
    }

    public boolean isXoa() {
        return Xoa;
    }

    public void setXoa(boolean Xoa) {
        this.Xoa = Xoa;
    }

    
}
