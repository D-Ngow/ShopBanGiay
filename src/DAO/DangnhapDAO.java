/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import ENTITY.tkmk;
import UTILS.XJdbc;
import java.sql.ResultSet;
/**
 *
 * @author LENOVO
 */
public class DangnhapDAO {
   public tkmk timtk(String taikhoan){
    String sql = "Select taikhoan,matkhau,vaitro from taikhoan where taikhoan=?";
    tkmk t1 = new tkmk();
       try {
           ResultSet rs = XJdbc.query(sql,taikhoan);
           if(rs.next()){
            t1.setTk(rs.getString(1));
            t1.setMk(rs.getString(2));
            t1.setVaitro(rs.getBoolean(3));
           }
       } catch (Exception e) {
       }
       return t1;
   }
}
