/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ENTITY.Donhang;
import UTILS.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class DonhangDAO {
   public void insert(Donhang dh){
   String sql ="insert into hoadonxuat values (?,?,?,?)";
       XJdbc.update(sql,dh.getMhd(),dh.getNgayxuat(),dh.getMnv(),dh.getMak());
   }
   public void update(Donhang dh){
   String sql="update hoadonxuat set ngayxuat=?,manv=?,makhach=? where mahoadon=?";
   XJdbc.update(sql, dh.getNgayxuat(),dh.getMnv(),dh.getMak(),dh.getMhd());
   }
   public void delete(String mhd){
   String sql1 = "delete chitietdonhang where mahoadon=?";
   String sql2 = "delete hoadonxuat where mahoadon=?";
   XJdbc.update(sql1,mhd);
   XJdbc.update(sql2, mhd);
   }
   
   public List<Donhang> seachmonth(int mon){
   String sql ="select * from hoadonxuat where month(ngayxuat)=?";
   List<Donhang> list1 = new ArrayList<>();
       try {
           ResultSet rs = XJdbc.query(sql,mon);
           while (rs.next()) {               
            Donhang dh = new Donhang();
            dh.setMhd(rs.getString(1));
            dh.setNgayxuat(rs.getDate(2));
            dh.setMnv(rs.getInt(3));
            dh.setMak(rs.getInt(4));  
            list1.add(dh);
           }
       } catch (Exception e) {
       }
       return list1;
   }
   
    public List<Donhang> selectall() {
        String sql = "select * from hoadonxuat";
        return selectbysql(sql);
    }

    public List<Donhang> selectbysql(String sql, Object... args) {
        List<Donhang> list1 = new ArrayList<>();
        try {
            ResultSet rs = XJdbc.query(sql, args);
            while(rs.next()){
            Donhang dh = new Donhang();
            dh.setMhd(rs.getString(1));
            dh.setNgayxuat(rs.getDate(2));
            dh.setMnv(rs.getInt(3));
            dh.setMak(rs.getInt(4));
            list1.add(dh);
            }
        } catch (Exception e) {
        }
        return list1;
    }
}
