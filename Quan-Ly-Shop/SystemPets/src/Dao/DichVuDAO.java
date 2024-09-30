/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import JdbcConnection.JdbcHelper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.DichVu;

/**
 *
 * @author TechCare
 */
public class DichVuDAO {

  public ArrayList<DichVu> getDichVu(JdbcHelper connect) {
    ArrayList<DichVu> list = new ArrayList<>();
    try {
      Statement st = connect.getConnect().createStatement();
      ResultSet rs = st.executeQuery("SELECT * FROM dbo.DICHVU");
      while (rs.next()) {
        DichVu dv = new DichVu(rs.getString(1), rs.getString(2), rs.getString(4), rs.getString(3));
        list.add(dv);
      }
      st.close();
      rs.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return list;
  }
  
  public ArrayList<DichVu> getDichVuByMaLH(JdbcHelper connect, String maLH) {
    ArrayList<DichVu> list = new ArrayList<>();
    try {
      PreparedStatement ps = connect.getConnect().prepareStatement("SELECT * FROM dbo.DICHVU where MALH = ?");
      ps.setString(1, maLH);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        DichVu dv = new DichVu(rs.getString(1), rs.getString(2), rs.getString(4), rs.getString(3));
        list.add(dv);
      }
      ps.close();
      rs.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return list;
  }

  public DichVu findByMaDV(String MaDV, JdbcHelper connect) {
    DichVu dv = new DichVu();
    dv = null;
    try {
      PreparedStatement ps = connect.getConnect().prepareStatement("SELECT * FROM dbo.DICHVU WHERE MADV=?");
      ps.setString(1, MaDV);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        dv = new DichVu(rs.getString(1), rs.getString(2), rs.getString(4), rs.getString(3));
      }
      ps.close();
      rs.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return dv;
  }

  public ArrayList<DichVu> getDichVubyMaDV(String MaDV, JdbcHelper connect) {
    ArrayList<DichVu> list = new ArrayList<>();
    try {
      Statement st = connect.getConnect().createStatement();
      ResultSet rs = st.executeQuery("SELECT * FROM dbo.DICHVU WHERE MADV LIKE '%" + MaDV + "%'");
      while (rs.next()) {
        DichVu dv = new DichVu(rs.getString(1), rs.getString(2), rs.getString(4), rs.getString(3));
        list.add(dv);
      }
      st.close();
      rs.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return list;
  }

  public int insertDV(DichVu dv, JdbcHelper connect) {
    int i = 0;
    try {
      PreparedStatement ps = connect.getConnect().prepareStatement("INSERT INTO dbo.DICHVU\n"
              + "        ( MADV, TENDV, GHICHU, MALH )\n"
              + "VALUES  ( ?, -- MADV - nchar(10)\n"
              + "          ?, -- TENDV - nvarchar(50)\n"
              + "          ?, -- GHICHU - nvarchar(100)\n"
              + "          ?  -- MALH - nvarchar(7))\n"
              + "          )");
      ps.setString(1, dv.getMaDV());
      ps.setString(2, dv.getTenDV());
      ps.setString(3, dv.getGhiChu());
      ps.setString(4, dv.getMaLH());
      i = ps.executeUpdate();
      ps.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return i;
  }

  public int updateDV(String MaDV, String TenDV, String GhiChu, String MaLH, JdbcHelper connect) {
    int i = 0;
    try {
      PreparedStatement ps = connect.getConnect().prepareStatement("UPDATE dbo.DICHVU SET TENDV=?,GHICHU=?,MALH=? WHERE MADV=?");
      ps.setString(1, TenDV);
      ps.setString(2, GhiChu);
      ps.setString(3, MaLH);
      ps.setString(4, MaDV);
      i = ps.executeUpdate();
      ps.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return i;
  }

  public int deleteDV(String MaDV, JdbcHelper connect) {
    int i = 0;
    try {
      PreparedStatement ps = connect.getConnect().prepareStatement("DELETE FROM dbo.DICHVU WHERE MADV=?");
      ps.setString(1, MaDV);
      i = ps.executeUpdate();
      ps.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return i;
  }

  public int deleteDVByMaLH(String MaLH, JdbcHelper connect) {
    int i = 0;
    try {
      PreparedStatement ps = connect.getConnect().prepareStatement("DELETE FROM dbo.DICHVU WHERE MALH=?");
      ps.setString(1, MaLH);
      i = ps.executeUpdate();
      ps.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return i;
  }
}
