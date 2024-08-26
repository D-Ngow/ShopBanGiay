/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ENTITY.calam;
import UTILS.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class CalamDAO {
     public void insert (calam nv1){
    String sql = "insert into calam values (?,?)";
        XJdbc.update(sql,nv1.getCalam(),nv1.getMnv());
    }
    public void update(calam nv1){
    String sql = "Update calam set thoigian=? where manv=?";
   XJdbc.update(sql,nv1.getCalam(),nv1.getMnv());
    }
    
    public void delete(calam nv1){
    String sql ="delete from calam where thoigian=?,manv=? ";
    XJdbc.update(sql, nv1.getCalam(),nv1.getMnv());
    }
    
    public List<calam> selectall(){
 String sql = "select * from calam";
     return selectbysql(sql);
 }
 public List<calam> selectbysql(String sql,Object...args){
 List<calam> list1 = new ArrayList<>();
     try {
         ResultSet rs =  XJdbc.query(sql, args);
         while (rs.next()) {             
             calam c1 = new calam();
             c1.setCalam(rs.getDate(1));
             c1.setMnv(rs.getInt(2));
             list1.add(c1);
         }
         
     } catch (Exception e) {
     }
     return list1;
 }
}
