/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ENTITY.sanpham;
import UTILS.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class SanphamDAO {
       public void insert (sanpham sp1){
    String sql = "insert into sanpham values (?,?,?,?,?,?,?)";
        XJdbc.update(sql,sp1.getMsp(),sp1.getTsp(),sp1.getGia(),sp1.getMota(),sp1.getSoluong(),sp1.getHinhanh(),sp1.trangthai);
    }
    public void update(sanpham sp1){
    String sql = "Update sanpham set tensp=?,gia=?,mota=?,soluong=?,hinhanh=?,trangthai=? where masp=?";
   XJdbc.update(sql,sp1.getTsp(),sp1.getGia(),sp1.getMota(),sp1.getSoluong(),sp1.getHinhanh(),sp1.trangthai,sp1.getMsp());
    }
    public void delete(String msp){
    String sql = "delete from sanpham where masp=?";
    XJdbc.update(sql, msp);
    }
    
    public List<sanpham> selectall(){
 String sql = "select * from sanpham";
     return selectbysql(sql);
 }
 public List<sanpham> selectbysql(String sql,Object...args){
 List<sanpham> list1 = new ArrayList<>();
     try {
         ResultSet rs =  XJdbc.query(sql, args);
         while (rs.next()) {             
             sanpham sp1 = new sanpham();
             sp1.setMsp(rs.getString(1));
             sp1.setTsp(rs.getString(2));
             sp1.setGia(rs.getDouble(3));
             sp1.setMota(rs.getString(4));
             sp1.setSoluong(rs.getInt(5));
             sp1.setHinhanh(rs.getString(6));
             sp1.setTrangthai(rs.getBoolean(7));
             list1.add(sp1);
         }
         
     } catch (Exception e) {
     }
     return list1;
 }
}
