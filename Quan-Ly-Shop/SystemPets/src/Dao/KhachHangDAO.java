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
import model.KhachHang;

/**
 *
 * @author TechCare
 */
public class KhachHangDAO {

  public ArrayList<KhachHang> getKhachHang(JdbcHelper connect) {
    ArrayList<KhachHang> list = new ArrayList<>();
    try {
      Statement st = connect.getConnect().createStatement();
      ResultSet rs = st.executeQuery("SELECT * FROM dbo.KHACHHANG");
      while (rs.next()) {
        KhachHang kh = new KhachHang(rs.getString(2), rs.getString(3), rs.getString(1), rs.getString(4), rs.getBoolean(5));
        list.add(kh);
      }
      st.close();
      rs.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return list;
  }

  public KhachHang findBySDT(String SDT, JdbcHelper connect) {
    KhachHang kh = new KhachHang();
    kh = null;
    try {
      PreparedStatement ps = connect.getConnect().prepareStatement("SELECT * FROM dbo.KHACHHANG WHERE SDT=?");
      ps.setString(1, SDT);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        kh = new KhachHang(rs.getString(2), rs.getString(3), rs.getString(1), rs.getString(4), rs.getBoolean(5));
      }
      ps.close();
      rs.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return kh;
  }

  public ArrayList<KhachHang> getKhachHangbySDT(String SDT, JdbcHelper connect) {
    ArrayList<KhachHang> list = new ArrayList<>();
    try {
      Statement st = connect.getConnect().createStatement();
      ResultSet rs = st.executeQuery("SELECT * FROM dbo.KHACHHANG WHERE SDT LIKE '%" + SDT + "%'");
      while (rs.next()) {
        KhachHang kh = new KhachHang(rs.getString(2), rs.getString(3), rs.getString(1), rs.getString(4), rs.getBoolean(5));
        list.add(kh);
      }
      st.close();
      rs.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return list;
  }

  public int insertKH(KhachHang kh, JdbcHelper connect) {
    int i = 0;
    try {
      PreparedStatement ps = connect.getConnect().prepareStatement("INSERT dbo.KHACHHANG\n"
              + "        ( SDT ,\n"
              + "          TENKH ,\n"
              + "          DIACHI ,\n"
              + "          EMAIL ,\n"
              + "          GIOITINH\n"
              + "        )\n"
              + "VALUES  ( ? , -- SDT - char(10)\n"
              + "          ? , -- TENKH - nvarchar(50)\n"
              + "          ? , -- DIACHI - nvarchar(100)\n"
              + "          ?, -- EMAIL - nvarchar(100)\n"
              + "          ? -- GIOITINH - bit\n"
              + "        )");
      ps.setString(1, kh.getSDT());
      ps.setString(2, kh.getTenKH());
      ps.setString(3, kh.getDiaChi());
      ps.setString(4, kh.getEmail());
      ps.setBoolean(5, kh.isGioiTinh());
      i = ps.executeUpdate();
      ps.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return i;
  }

  public int updateKH(String SDT, String TenKH, String Email, String DiaChi, boolean GioiTinh, JdbcHelper connect) {
    int i = 0;
    try {
      PreparedStatement ps = connect.getConnect().prepareStatement("UPDATE dbo.KHACHHANG SET TENKH =?,DIACHI=?,EMAIL=?,GIOITINH=? WHERE SDT =?");
      ps.setString(1, TenKH);
      ps.setString(2, DiaChi);
      ps.setString(3, Email);
      ps.setBoolean(4, GioiTinh);
      ps.setString(5, SDT);
      i = ps.executeUpdate();
      ps.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return i;
  }

  public int deleteKH(String SDT, JdbcHelper connect) {
    int i = 0;
    try {
      PreparedStatement ps = connect.getConnect().prepareStatement("DELETE FROM dbo.KHACHHANG WHERE SDT=?");
      ps.setString(1, SDT);
      i = ps.executeUpdate();
      ps.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return i;
  }
}
