/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import JdbcConnection.JdbcHelper;
import Utils.DateHelper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import model.NhanVien;

/**
 *
 * @author Thinkpad
 */
public class NhanVienDao {
  public ArrayList<NhanVien> getNhanVien(JdbcHelper connect) {
    ArrayList<NhanVien> list = new ArrayList<>();
    try {
      Statement st = connect.getConnect().createStatement();
      ResultSet rs = st.executeQuery("select * from NHANVIEN where TRANGTHAI = 1");
      while(rs.next()) {
        NhanVien nv = new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(5), rs.getString(6), rs.getString(7),
                rs.getString(10), rs.getBoolean(11), rs.getDate(4), rs.getDate(8), rs.getDouble(9), rs.getBoolean(12));
        list.add(nv);
      }
      st.close();
      rs.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return list;
  }
  
  public ArrayList<NhanVien> getNhanVienOnlyNV(JdbcHelper connect) {
    ArrayList<NhanVien> list = new ArrayList<>();
    try {
      Statement st = connect.getConnect().createStatement();
      ResultSet rs = st.executeQuery("select * from NHANVIEN where VAITRO = 0 and TRANGTHAI = 1");
      while(rs.next()) {
        NhanVien nv = new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(5), rs.getString(6), rs.getString(7),
                rs.getString(10), rs.getBoolean(11), rs.getDate(4), rs.getDate(8), rs.getDouble(9), rs.getBoolean(12));
        list.add(nv);
      }
      st.close();
      rs.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return list;
  }
  
  public ArrayList<NhanVien> getNhanVienOnlyNVbyMaNV(String maNV, JdbcHelper connect) {
    ArrayList<NhanVien> list = new ArrayList<>();
    try {
      Statement st = connect.getConnect().createStatement();
      ResultSet rs = st.executeQuery("select * from NHANVIEN where VAITRO = 0 and maNV like "+"'%"+maNV+"%'"+" and TRANGTHAI = 1");
      while(rs.next()) {
        NhanVien nv = new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(5), rs.getString(6), rs.getString(7),
                rs.getString(10), rs.getBoolean(11), rs.getDate(4), rs.getDate(8), rs.getDouble(9), rs.getBoolean(12));
        list.add(nv);
      }
      st.close();
      rs.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return list;
  }

  public NhanVien findByMaNV(String MaNV, JdbcHelper connect) {
    NhanVien nv = new NhanVien();
    nv = null;
    try {
      PreparedStatement ps = connect.getConnect().prepareStatement("select * from NHANVIEN where MANV = ?");
      ps.setString(1, MaNV);
      ResultSet rs = ps.executeQuery();
      while(rs.next()) {
        nv = new NhanVien(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(5), rs.getString(6), rs.getString(7),
                rs.getString(10), rs.getBoolean(11), rs.getDate(4), rs.getDate(8), rs.getDouble(9), rs.getBoolean(12));
      }
      ps.close();
      rs.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return nv;
  }
  
  public int updateNV(String MaNV, String MatKhau, JdbcHelper connect) {
    int i = 0;
    try {
      PreparedStatement ps = connect.getConnect().prepareStatement("update NHANVIEN set MATKHAU = ? where MANV = ?");
      ps.setString(1, MatKhau);
      ps.setString(2, MaNV);
      i = ps.executeUpdate();
      ps.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return i;
  }
  
  public int insertNV(NhanVien nv, JdbcHelper connect) {
    int i = 0;
    try {
      PreparedStatement ps = connect.getConnect().prepareStatement("insert NHANVIEN values (?,?,?,?,?,?,?,?,?,?,?, ?)");
      ps.setString(1, nv.getMaNV());
      ps.setString(2, nv.getTenNV());
      ps.setString(3, nv.getMatKhau());
      ps.setDate(4, DateHelper.toSQL(nv.getNgaySinh()));
      ps.setString(5, nv.getDiaChi());
      ps.setString(6, nv.getEmail());
      ps.setString(7, nv.getSDT());
      ps.setDate(8, DateHelper.toSQL(nv.getNgayVaoLam()));
      ps.setDouble(9, nv.getLuong());
      ps.setString(10, nv.getHinhAnh());
      ps.setBoolean(11, nv.isVaiTro());
      ps.setBoolean(12, true);
      i = ps.executeUpdate();
      ps.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return i;
  }
  
  public int updateNV(String hoTen, Date ngaySinh, String diaChi, String email, String SDT, double luong, String maNV,JdbcHelper connect) {
    int i = 0;
    try {
      PreparedStatement ps = connect.getConnect().prepareStatement("update NHANVIEN set TENNV = ?, NGAYSINH = ?, DIACHI = ?, EMAIL = ?, "
              + "SDT = ?, LUONG = ? where MANV = ?");
      ps.setString(1, hoTen);
      ps.setDate(2, DateHelper.toSQL(ngaySinh));
      ps.setString(3, diaChi);
      ps.setString(4, email);
      ps.setString(5, SDT);
      ps.setDouble(6, luong);
      ps.setString(7, maNV);
      i = ps.executeUpdate();
      ps.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return i;
  }
  
  public int deleteNV(String maNV, JdbcHelper connect) {
    int i = 0;
    try {
      PreparedStatement ps = connect.getConnect().prepareStatement("delete from NHANVIEN where MANV = ?");
      ps.setString(1, maNV);
      i = ps.executeUpdate();
      ps.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return i;
  }
  
  public int nvOff(String maNV, JdbcHelper connect) {
    int i = 0;
    try {
      PreparedStatement ps = connect.getConnect().prepareStatement("update NHANVIEN set TRANGTHAI = 0 where MANV = ?");
      ps.setString(1, maNV);
      i = ps.executeUpdate();
      ps.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return i;
  }
  
  public NhanVien findSDT(String sdt, JdbcHelper connect) {
    NhanVien nv = new NhanVien();
    try {
      PreparedStatement ps = connect.getConnect().prepareStatement("select * from NHANVIEN where SDT = ?");
      ps.setString(1, sdt);
      ResultSet rs = ps.executeQuery();
      while(rs.next()) {
        nv.setMaNV(rs.getString(1));
      }
      ps.close();
      rs.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return nv;
  }
  
  public NhanVien findMail(String mail, JdbcHelper connect) {
    NhanVien nv = new NhanVien();
    try {
      PreparedStatement ps = connect.getConnect().prepareStatement("select * from NHANVIEN where EMAIL = ?");
      ps.setString(1, mail);
      ResultSet rs = ps.executeQuery();
      while(rs.next()) {
        nv.setMaNV(rs.getString(1));
      }
      ps.close();
      rs.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return nv;
  }
}
