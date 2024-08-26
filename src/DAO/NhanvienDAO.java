/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import ENTITY.Nhanvien;
import UTILS.XJdbc;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class NhanvienDAO {
     public void insert (Nhanvien nv1){
    String sql = "insert into nhanvien values (?,?,?,?,?,?,?,?,?,?)";
        XJdbc.update(sql,nv1.getMnv(),nv1.getHo(),nv1.getTen(),nv1.getEmail(),nv1.getSdt(),nv1.gioitinh,nv1.getDiachi(),nv1.trangthai,nv1.getNgaybatdau(),nv1.getNgayketthuc());
    }
    public void update(Nhanvien nv1){
    String sql = "Update nhanvien set ho=?,ten=?,email=?,sdt=?,gioitinh=?,diachi=?,trangthai=?,thoigianbatdau=?,thoigianketthuc=? where manv=?";
   XJdbc.update(sql,nv1.getHo(),nv1.getTen(),nv1.getEmail(),nv1.getSdt(),nv1.gioitinh,nv1.getDiachi(),nv1.trangthai,nv1.getNgaybatdau(),nv1.getNgayketthuc(),nv1.getMnv());
    }
    
    public void delete(String mnv){
    String sql ="delete from nhanvien where manv=?";
    XJdbc.update(sql, mnv);
    }
    
    public List<Nhanvien> selectall(){
 String sql = "select * from nhanvien";
     return selectbysql(sql);
 }
 public List<Nhanvien> selectbysql(String sql,Object...args){
 List<Nhanvien> list1 = new ArrayList<>();
     try {
         ResultSet rs =  XJdbc.query(sql, args);
         while (rs.next()) {             
             Nhanvien nv1 = new Nhanvien();
             nv1.setMnv(rs.getString(1));
             nv1.setHo(rs.getString(2));
             nv1.setTen(rs.getString(3));
             nv1.setEmail(rs.getString(4));
             nv1.setSdt(rs.getString(5));
             nv1.setGioitinh(rs.getBoolean(6));
             nv1.setDiachi(rs.getString(7));
             nv1.setTrangthai(rs.getBoolean(8));
             nv1.setNgaybatdau(rs.getDate(9));
             nv1.setNgayketthuc(rs.getDate(10));
             list1.add(nv1);
         }
         
     } catch (Exception e) {
     }
     return list1;
 }
}
