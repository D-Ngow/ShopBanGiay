/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ENTITY;

/**
 *
 * @author LENOVO
 */
public class sanpham {
    public String msp;
    public String tsp;
    public double gia;
    public String mota;
    public int soluong;
    public String hinhanh;
    public boolean trangthai;

    public sanpham() {
    }

    public sanpham(String msp, String tsp, double gia, String mota, int soluong, String hinhanh, boolean trangthai) {
        this.msp = msp;
        this.tsp = tsp;
        this.gia = gia;
        this.mota = mota;
        this.soluong = soluong;
        this.hinhanh = hinhanh;
        this.trangthai = trangthai;
    }

    public void setMsp(String msp) {
        this.msp = msp;
    }

    public void setTsp(String tsp) {
        this.tsp = tsp;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public void setTrangthai(boolean trangthai) {
        this.trangthai = trangthai;
    }

    public String getMsp() {
        return msp;
    }

    public String getTsp() {
        return tsp;
    }

    public double getGia() {
        return gia;
    }

    public String getMota() {
        return mota;
    }

    public int getSoluong() {
        return soluong;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public boolean isTrangthai() {
        return trangthai;
    }

}
