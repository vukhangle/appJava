/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import JdbcConnection.JdbcHelper;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Thinkpad
 */
public class ThongKeDAO {
  public ArrayList<Object[]> getKhoHang(JdbcHelper connect) {
    ArrayList<Object[]> list = new ArrayList<>();
    try {
      CallableStatement cs = connect.getConnect().prepareCall("{call [sp.KhoHang]}");
      ResultSet rs = cs.executeQuery();
      while(rs.next()) {
        Object[] model = {
          rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)
        };
        list.add(model);
      }
      cs.close();
      rs.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return list;
  }
  
  public ArrayList<Object[]> getKhachHang(JdbcHelper connect) {
    ArrayList<Object[]> list = new ArrayList<>();
    try {
      CallableStatement cs = connect.getConnect().prepareCall("{call [sp.KhachHang]}");
      ResultSet rs = cs.executeQuery();
      while(rs.next()) {
        Object[] model = {
          rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)
        };
        list.add(model);
      }
      cs.close();
      rs.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return list;
  }
  
  public ArrayList<Object[]> getHoaDon(JdbcHelper connect) {
    ArrayList<Object[]> list = new ArrayList<>();
    try {
      CallableStatement cs = connect.getConnect().prepareCall("{call [sp.HoaDon_ALL]}");
      ResultSet rs = cs.executeQuery();
      while(rs.next()) {
        Object[] model = {
          rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)
        };
        list.add(model);
      }
      cs.close();
      rs.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return list;
  }
  
  public ArrayList<Object[]> getHoaDonByMaHD(JdbcHelper connect, int maHD) {
    ArrayList<Object[]> list = new ArrayList<>();
    try {
      CallableStatement cs = connect.getConnect().prepareCall("{call [sp.HoaDon](?)}");
      cs.setInt(1, maHD);
      ResultSet rs = cs.executeQuery();
      while(rs.next()) {
        Object[] model = {
          rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)
        };
        list.add(model);
      }
      cs.close();
      rs.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return list;
  }
  
  public ArrayList<Object[]> getDoanhThuHD(JdbcHelper connect, String sql) {
    ArrayList<Object[]> list = new ArrayList<>();
    try {
      CallableStatement cs = connect.getConnect().prepareCall(sql);
      ResultSet rs = cs.executeQuery();
      while(rs.next()) {
        Object[] model = {
          rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)
        };
        list.add(model);
      }
      cs.close();
      rs.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return list;
  }
  
  public ArrayList<Object[]> getDoanhThuHD(JdbcHelper connect, String sql, int time) {
    ArrayList<Object[]> list = new ArrayList<>();
    try {
      CallableStatement cs = connect.getConnect().prepareCall(sql);
      cs.setInt(1, time);
      ResultSet rs = cs.executeQuery();
      while(rs.next()) {
        Object[] model = {
          rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)
        };
        list.add(model);
      }
      cs.close();
      rs.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return list;
  }
}
