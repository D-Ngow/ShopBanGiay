/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ENTITY.khachhang;
import UTILS.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class KhachHangDAO {
    public void insert (khachhang k1){
    String sql = "insert into khach values (?,?,?,?,?)";
        XJdbc.update(sql,k1.getMakhach(),k1.getTenkhach(),k1.getDiachi(),k1.getSdt(),k1.email);
    }
    public void update(khachhang k1){
    String sql = "Update khach set tenkhach=?,diachi=?,phone=?,email=? where makhach=?";
    XJdbc.update(sql,k1.getTenkhach(),k1.getDiachi(),k1.getSdt(),k1.email,k1.getMakhach());
    }
    public void delete(String mkh){
    String sql ="Delete from khach where makhach=?";
    XJdbc.update(sql, mkh);
    }
    
    public List<khachhang> selectall(){ 
 String sql = "select * from khach";
     return selectbysql(sql);
 }
 public List<khachhang> selectbysql(String sql,Object...args){
 List<khachhang> list1 = new ArrayList<>();
     try {
         ResultSet rs =  XJdbc.query(sql, args);
         while (rs.next()) {             
             khachhang k1 = new khachhang();
             k1.setMakhach(rs.getString(1));
             k1.setTenkhach(rs.getString(2));
             k1.setDiachi(rs.getString(3));
             k1.setSdt(rs.getString(4));
             k1.setEmail(rs.getString(5));
             list1.add(k1);
         }
         
     } catch (Exception e) {
     }
     return list1;
 }
}
