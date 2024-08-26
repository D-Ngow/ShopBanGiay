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
public class Giohang {
    public String mgh;
    public int msp;
    public String tsp;
    public double gia;
    public int soluong;


    public Giohang() {
    }

    public Giohang(String mgh, int msp, String tsp, double gia, int soluong) {
        this.mgh = mgh;
        this.msp = msp;
        this.tsp = tsp;
        this.gia = gia;
        this.soluong = soluong;
    }

    public String getMgh() {
        return mgh;
    }

    public int getMsp() {
        return msp;
    }

    public String getTsp() {
        return tsp;
    }

    public double getGia() {
        return gia;
    }

    public int getSoluong() {
        return soluong;
    }

    public void setMgh(String mgh) {
        this.mgh = mgh;
    }

    public void setMsp(int msp) {
        this.msp = msp;
    }

    public void setTsp(String tsp) {
        this.tsp = tsp;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }
    
    
}
