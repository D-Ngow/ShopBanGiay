/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ENTITY.Giohang;
import ENTITY.spgia;
import UTILS.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class GiohangDAO {

    public void insert(Giohang k1) {
        String sql = "insert into chitietdonhang values (?,?,?,?,?)";
        XJdbc.update(sql, k1.getMgh(), k1.getMsp(), k1.getTsp(), k1.getGia(), k1.getSoluong());
    }

    public void update(Giohang k1) {
        String sql = "Update chitietdonhang set masp=?,soluong=? where mahoadon=?";
        XJdbc.update(sql, k1.getMsp(),k1.getSoluong(), k1.getMgh());
    }
    
    public void delete (Giohang k1){
    String sql = "delete from chitietdonhang where mahoadon=? and masp=?";
    XJdbc.update(sql,k1.getMgh(),k1.getMsp());
    }
    
    public void deletegh(Giohang k1){
    String sql = "delete from chitietdonhang where mahoadon=?";
    XJdbc.update(sql, k1.getMgh());
    }
    
    public void deletehd (Giohang k1){
    String sql = "delete from hoadonxuat where mahoadon=?";
    XJdbc.update(sql,k1.getMgh());
    }
    
    public spgia timtengia(int msp){
     String sql = "select tensp,gia from sanpham where masp=?";
     spgia spg1= new spgia();
        try {
            ResultSet rs = XJdbc.query(sql,msp);
            if(rs.next()){
            spg1.setGia(rs.getDouble(2));
            spg1.setTsp(rs.getString(1));
            }
        } catch (Exception e) {
        }
        return spg1;
    }
    
    public List<Giohang> timtong(String mhd){
     String sql = "select gia,soluong from chitietdonhang where mahoadon=?";
     Giohang gh = new Giohang();
     List<Giohang> list = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql,mhd);
            while(rs.next()){
            gh.setGia(rs.getInt(1));
            gh.setSoluong(rs.getInt(2));
            list.add(gh);
            }
        } catch (Exception e) {
        }
        return list;
    }
    
    public List<Giohang> selectall() {
        String sql = "select * from chitietdonhang";
        return selectbysql(sql);
    }

    public List<Giohang> selectbysql(String sql, Object... args) {
        List<Giohang> list1 = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while(rs.next()){
            Giohang sp1 = new Giohang();
            sp1.setMgh(rs.getString(1));
            sp1.setMsp(rs.getInt(2));
            sp1.setTsp(rs.getString(3));
            sp1.setGia(rs.getDouble(4));
            sp1.setSoluong(rs.getInt(5));
            list1.add(sp1);
            }
        } catch (Exception e) {
        }
        return list1;
    }
}

