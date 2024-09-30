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
import model.LoaiHinhDichVu;

/**
 *
 * @author TechCare
 */
public class LoaiHinhDAO {

  public ArrayList<LoaiHinhDichVu> getLoaiHinhDichVu(JdbcHelper connect) {
    ArrayList<LoaiHinhDichVu> list = new ArrayList<>();
    try {
      Statement st = connect.getConnect().createStatement();
      ResultSet rs = st.executeQuery("SELECT * FROM dbo.LOAIHINH_DICHVU");
      while (rs.next()) {
        LoaiHinhDichVu lh = new LoaiHinhDichVu(rs.getString(1), rs.getString(2), rs.getString(3));
        list.add(lh);
      }
      st.close();
      rs.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return list;

  }

  public LoaiHinhDichVu findByMaLH(String MaLH, JdbcHelper connect) {
    LoaiHinhDichVu lh = new LoaiHinhDichVu();
    lh = null;
    try {
      PreparedStatement ps = connect.getConnect().prepareStatement("SELECT * FROM dbo.LOAIHINH_DICHVU WHERE MALH = ?");
      ps.setString(1, MaLH);
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        lh = new LoaiHinhDichVu(rs.getString(1), rs.getString(2), rs.getString(3));
      }
      ps.close();
      rs.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return lh;
  }

  public ArrayList<LoaiHinhDichVu> getLoaiHinhDichVubyMaLH(String maLH, JdbcHelper connect) {
    ArrayList<LoaiHinhDichVu> list = new ArrayList<>();
    try {
      Statement st = connect.getConnect().createStatement();
      ResultSet rs = st.executeQuery("SELECT * FROM dbo.LOAIHINH_DICHVU WHERE MALH like '%" + maLH + "%'");
      while (rs.next()) {
        LoaiHinhDichVu lh = new LoaiHinhDichVu(rs.getString(1), rs.getString(2), rs.getString(3));
        list.add(lh);
      }
      st.close();
      rs.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return list;
  }

  public int insertLH(LoaiHinhDichVu lh, JdbcHelper connect) {
    int i = 0;
    try {
      PreparedStatement ps = connect.getConnect().prepareStatement("INSERT INTO dbo.LOAIHINH_DICHVU\n"
              + "        ( MALH, TENLH, GhiChu )\n"
              + "VALUES  ( ?, -- MALH - nvarchar(7)\n"
              + "          ?, -- TENLH - nvarchar(50)\n"
              + "          ?  -- GhiChu - nvarchar(255)\n"
              + "          )");
      ps.setString(1, lh.getMaLH());
      ps.setString(2, lh.getTenLH());
      ps.setString(3, lh.getGhiChu());
      i = ps.executeUpdate();
      ps.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return i;
  }

  public int updateLH(String MaLH, String TenLH, String GhiChu, JdbcHelper connect) {
    int i = 0;
    try {
      PreparedStatement ps = connect.getConnect().prepareStatement("UPDATE dbo.LOAIHINH_DICHVU SET TENLH =?,GhiChu=? WHERE MALH=?");
      ps.setString(1, TenLH);
      ps.setString(2, GhiChu);
      ps.setString(3, MaLH);
      i = ps.executeUpdate();
      ps.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return i;
  }

  public int deleteLH(String maLH, JdbcHelper connect) {
    int i = 0;
    try {
      PreparedStatement ps = connect.getConnect().prepareStatement("DELETE FROM dbo.LOAIHINH_DICHVU WHERE MALH=?");
      ps.setString(1, maLH);
      i = ps.executeUpdate();
      ps.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return i;
  }
}
