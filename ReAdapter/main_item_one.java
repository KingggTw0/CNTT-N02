package com.example.admin.kiemtrab.ReAdapter;

public class main_item_one {
    String tensp,loaisp,masp,mahang,taikhoan,matkhau;
    int gia,id,img,level;

    public main_item_one(int id, String tensp, String loaisp, int gia, int img) {
        this.id=id;
        this.tensp = tensp;
        this.loaisp = loaisp;
        this.gia = gia;
        this.img = img;
    }

    public main_item_one(int id, String taikhoan, String matkhau, int level) {
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
        this.id = id;
        this.level = level;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public main_item_one(int id, String tensp, String loaisp, String masp, String mahang, int gia) {
        this.id=id;
        this.tensp = tensp;
        this.loaisp = loaisp;
        this.masp = masp;
        this.mahang = mahang;
        this.gia = gia;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getMahang() {
        return mahang;
    }

    public void setMahang(String mahang) {
        this.mahang = mahang;
    }

    public main_item_one(int id,String tensp, int gia) {
        this.id=id;
        this.tensp = tensp;
        this.gia = gia;
    }

    public String getLoaisp() {
        return loaisp;
    }

    public void setLoaisp(String loaisp) {
        this.loaisp = loaisp;
    }

    public int getGia() { return gia; }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return tensp;
    }

    public void setText(String text) {
        this.tensp = text;
    }
}
