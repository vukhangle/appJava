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
import model.SanPham;

/**
 *
 * @author TechCare
 */
public class SanPhamDAO {

  public ArrayList<SanPham> getSanPham(JdbcHelper connect) {
    ArrayList<SanPham> list = new ArrayList<>();
    try {
      Statement st = connect.getConnect().createStatement();
      ResultSet rs = st.executeQuery("SELECT * FROM dbo.SANPHAM");
      while (rs.next()) {
        SanPham sp = new SanPham(rs.getString(1), rs.getString(2), rs.getString(5), rs.getInt(3), rs.getDouble(4), rs.getDouble(7), rs.getDate(6));
        list.add(sp);
      }
      st.close();
      rs.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return list;
  }

  public SanPham findByMaSP(String MaSP, JdbcHelper connect) {
    SanPham sp = new SanPham();
    sp = null;
    try {
      PreparedStatement ps = connect.getConnect().prepareStatement("SELECT * FROM dbo.SANPHAM WHERE MASP = ?");
      ps.setString(1, MaSP);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        sp = new SanPham(rs.getString(1), rs.getString(2), rs.getString(5), rs.getInt(3), rs.getDouble(4), rs.getDouble(7), rs.getDate(6));
      }
      ps.close();
      rs.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return sp;
  }

  public ArrayList<SanPham> getSanPhamOnlyNVbyMaSP(String maSP, JdbcHelper connect) {
    ArrayList<SanPham> list = new ArrayList<>();
    try {
      Statement st = connect.getConnect().createStatement();
      ResultSet rs = st.executeQuery("SELECT * FROM dbo.SANPHAM WHERE MASP like '%" + maSP + "%'");
      while (rs.next()) {
        SanPham sp = new SanPham(rs.getString(1), rs.getString(2), rs.getString(5), rs.getInt(3), rs.getDouble(4), rs.getDouble(7), rs.getDate(6));
        list.add(sp);
      }
      st.close();
      rs.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return list;
  }

  public int insertSP(SanPham sp, JdbcHelper connect) {
    int i = 0;
    try {
      PreparedStatement ps = connect.getConnect().prepareStatement("INSERT INTO dbo.SANPHAM\n"
              + "        ( MASP ,\n"
              + "          TENSP ,\n"
              + "          SOLUONG ,\n"
              + "          GIANHAP ,\n"
              + "          GHICHU ,\n"
              + "          NGAYNHAPKHO ,\n"
              + "          GIABAN\n"
              + "        )\n"
              + "VALUES  ( ? , -- MASP - nchar(10)\n"
              + "          ? , -- TENSP - nvarchar(50)\n"
              + "          ? , -- SOLUONG - int\n"
              + "          ? , -- GIANHAP - float\n"
              + "          ? , -- GHICHU - nvarchar(100)\n"
              + "          ? , -- NGAYNHAPKHO - date\n"
              + "          ?  -- GIABAN - float\n"
              + "        )");
      ps.setString(1, sp.getMaSP());
      ps.setString(2, sp.getTenSP());
      ps.setInt(3, sp.getSoLuong());
      ps.setDouble(4, sp.getGiaNhap());
      ps.setString(5, sp.getGhiChu());
      ps.setDate(6, DateHelper.toSQL(sp.getNgayNhapKho()));
      ps.setDouble(7, sp.getGiaBan());
      i = ps.executeUpdate();
      ps.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return i;
  }

  public int updateSP(String MaSP, String TenSP, String GhiChu, int SoLuong, double GiaNhap, double GiaBan, Date NgayNhapKho, JdbcHelper connect) {
    int i = 0;
    try {
      PreparedStatement ps = connect.getConnect().prepareStatement("UPDATE dbo.SANPHAM SET TENSP=?,SOLUONG=?,GIANHAP=?,GHICHU=?,NGAYNHAPKHO=?,GIABAN=? WHERE MASP=?");
      ps.setString(1, TenSP);
      ps.setInt(2, SoLuong);
      ps.setDouble(3, GiaNhap);
      ps.setString(4, GhiChu);
      ps.setDate(5, DateHelper.toSQL(NgayNhapKho));
      ps.setDouble(6, GiaBan);
      ps.setString(7, MaSP);

      i = ps.executeUpdate();
      ps.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return i;
  }

  public int updateSLSP(String MaSP, int SoLuong, JdbcHelper connect) {
    int i = 0;
    try {
      PreparedStatement ps = connect.getConnect().prepareStatement("update sanpham set SOLUONG = SOLUONG + ? where MASP = ?");
      ps.setInt(1, SoLuong);
      ps.setString(2, MaSP);
      i = ps.executeUpdate();
      ps.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return i;
  }

  public int deleteSP(String maSP, JdbcHelper connect) {
    int i = 0;
    try {
      PreparedStatement ps = connect.getConnect().prepareStatement("DELETE FROM dbo.SANPHAM WHERE MASP =?");
      ps.setString(1, maSP);
      i = ps.executeUpdate();
      ps.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return i;
  }
}
