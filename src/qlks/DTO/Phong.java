
package qlks.DTO;


public class Phong {
    private String MaPhong;
    private String TenPhong;
    private String MaLoaiPhong;
    private String TinhTrang;

    public Phong() {
        this.MaPhong = "";
        this.TenPhong = "";
        this.MaLoaiPhong = "";
        this.TinhTrang = "";
    }

    public String getMaPhong() {
        return MaPhong;
    }

    public void setMaPhong(String MaPhong) {
        this.MaPhong = MaPhong;
    }

    public String getTenPhong() {
        return TenPhong;
    }

    public void setTenPhong(String TenPhong) {
        this.TenPhong = TenPhong;
    }

    public String getMaLoaiPhong() {
        return MaLoaiPhong;
    }

    public void setMaLoaiPhong(String MaLoaiPhong) {
        this.MaLoaiPhong = MaLoaiPhong;
    }

    public String getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(String TinhTrang) {
        this.TinhTrang = TinhTrang;
    }
}
    

