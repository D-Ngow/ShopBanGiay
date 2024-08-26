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
public class khachhang {
    public String makhach;
    public String tenkhach;
    public String diachi;
    public String sdt;
    public String email;

    public khachhang() {
    }

    public khachhang(String makhach, String tenkhach, String diachi, String sdt, String email) {
        this.makhach = makhach;
        this.tenkhach = tenkhach;
        this.diachi = diachi;
        this.sdt = sdt;
        this.email = email;
    }

    public String getMakhach() {
        return makhach;
    }

    public String getTenkhach() {
        return tenkhach;
    }

    public String getDiachi() {
        return diachi;
    }

    public String getSdt() {
        return sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setMakhach(String makhach) {
        this.makhach = makhach;
    }

    public void setTenkhach(String tenkhach) {
        this.tenkhach = tenkhach;
    }

    public void setDiachi(String diachi) {
        this.diachi = diachi;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public void setEmail(String email) {
        this.email = email;
    }

   
}
