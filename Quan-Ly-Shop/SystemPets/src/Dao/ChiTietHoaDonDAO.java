/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import JdbcConnection.JdbcHelper;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.HoaDonChiTiet;

/**
 *
 * @author Thinkpad
 */
public class ChiTietHoaDonDAO {
  public int insertCTHDSP(HoaDonChiTiet hdct, JdbcHelper connect) {
    int i = 0;
    try {
      PreparedStatement ps = connect.getConnect().prepareStatement("insert HOADON_CHITIET values (?,?,?,?,?)");
      ps.setString(1, hdct.getMaHD());
      ps.setString(2, hdct.getMaSP());
      ps.setString(3, hdct.getMaDV());
      ps.setInt(4, hdct.getSoLuongMua());
      ps.setDouble(5, hdct.getGia());
      i = ps.executeUpdate();
      ps.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return i;
  }
  
  public ArrayList<HoaDonChiTiet> getHDCT(JdbcHelper connect, String maHD) {
    ArrayList<HoaDonChiTiet> list = new ArrayList<>();
    try {
      PreparedStatement ps = connect.getConnect().prepareStatement("select * from HOADON_CHITIET where MAHD = ?");
      ps.setString(1, maHD);
      ResultSet rs = ps.executeQuery();
      while(rs.next()) {
        HoaDonChiTiet hdct = new HoaDonChiTiet(rs.getInt(5), rs.getString(2), rs.getString(4), rs.getString(3), rs.getDouble(6));
        list.add(hdct);
      }
      ps.close();
      rs.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return list;
  }
}
