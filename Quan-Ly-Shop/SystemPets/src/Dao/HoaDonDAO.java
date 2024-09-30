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
import model.HoaDon;

/**
 *
 * @author Thinkpad
 */
public class HoaDonDAO {
  public int insertHD(HoaDon hd, JdbcHelper connect) {
    int i = 0;
    try {
      PreparedStatement ps = connect.getConnect().prepareStatement("insert HOADON values (?,?,?,?)");
      ps.setString(1, hd.getMaNV());
      ps.setString(2, hd.getSDT());
      ps.setDate(3, DateHelper.toSQL(hd.getNgayTao()));
      ps.setString(4, hd.getGhiChu());
      i = ps.executeUpdate();
      ps.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return i;
  }
  
  public String getMaHD(JdbcHelper connect) {
    String maHD = null;
    try {
      Statement st = connect.getConnect().createStatement();
      ResultSet rs = st.executeQuery("select MAX(mahd) from HOADON");
      while(rs.next()) {
        maHD = rs.getString(1);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return maHD;
  }
}
