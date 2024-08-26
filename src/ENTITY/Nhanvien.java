/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ENTITY;

import java.sql.Date;

/**
 *
 * @author LENOVO
 */
public class Nhanvien {
 public String mnv;
 public String ho;
 public String ten;
 public String email;
 public String sdt;
 public boolean gioitinh;
 public String diachi;
 public boolean trangthai;
 public Date ngaybatdau;
 public Date ngayketthuc;

    public Nhanvien() {
    }

    public Nhanvien(String mnv, String ho, String ten, String email, String sdt, boolean gioitinh, String diachi, boolean trangthai, Date ngaybatdau, Date ngayketthuc) {
        this.mnv = mnv;
        this.ho = ho;
        this.ten = ten;
        this.email = email;
        this.sdt = sdt;
        this.gioitinh = gioitinh;
        this.diachi = diachi;
        this.trangthai = trangthai;
        this.ngaybatdau = ngaybatdau;
        this.ngayketthuc = ngayketthuc;
    }

    public Date getNgaybatdau() {
        return ngaybatdau;
    }

    public Date getNgayketthuc() {
        return ngayketthuc;
    }

    public void setNgaybatdau(Date ngaybatdau) {
        this.ngaybatdau = ngaybatdau;
    }

    public void setNgayketthuc(Date ngayketthuc) {
        this.ngayketthuc = ngayketthuc;
    }

    

    public String getMnv() {
        return mnv;
    }

    public String getHo() {
        return ho;
    }

    public String getTen() {
        return ten;
    }

    public String getEmail() {
        return email;
    }

    public String getSdt() {
        return sdt;
    }

    public boolean isGioitinh() {
        return gioitinh;
    }

    public String getDiachi() {
        return diachi;
    }

    public boolean isTrangthai() {
        return trangthai;
    }

    public void setMnv(String mnv) {
        this.mnv = mnv;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setGioitinh(boolean gioitinh) {
        this.gioitinh = gioitinh;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public void setTrangthai(boolean trangthai) {
        this.trangthai = trangthai;
    }
 
    
}
