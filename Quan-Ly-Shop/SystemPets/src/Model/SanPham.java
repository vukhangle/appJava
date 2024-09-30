/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author TechCare
 */
public class SanPham {

  String MaSP, TenSP, GhiChu;
  int SoLuong;
  double GiaNhap, GiaBan;
  Date NgayNhapKho;

  public SanPham() {
  }

  public SanPham(String MaSP, String TenSP, String GhiChu, int SoLuong, double GiaNhap, double GiaBan, Date NgayNhapKho) {
    this.MaSP = MaSP;
    this.TenSP = TenSP;
    this.GhiChu = GhiChu;
    this.SoLuong = SoLuong;
    this.GiaNhap = GiaNhap;
    this.GiaBan = GiaBan;
    this.NgayNhapKho = NgayNhapKho;
  }

  public String getMaSP() {
    return MaSP;
  }

  public void setMaSP(String MaSP) {
    this.MaSP = MaSP;
  }

  public String getTenSP() {
    return TenSP;
  }

  public void setTenSP(String TenSP) {
    this.TenSP = TenSP;
  }

  public String getGhiChu() {
    return GhiChu;
  }

  public void setGhiChu(String GhiChu) {
    this.GhiChu = GhiChu;
  }

  public int getSoLuong() {
    return SoLuong;
  }

  public void setSoLuong(int SoLuong) {
    this.SoLuong = SoLuong;
  }

  public double getGiaNhap() {
    return GiaNhap;
  }

  public void setGiaNhap(double GiaNhap) {
    this.GiaNhap = GiaNhap;
  }

  public double getGiaBan() {
    return GiaBan;
  }

  public void setGiaBan(double GiaBan) {
    this.GiaBan = GiaBan;
  }

  public Date getNgayNhapKho() {
    return NgayNhapKho;
  }

  public void setNgayNhapKho(Date NgayNhapKho) {
    this.NgayNhapKho = NgayNhapKho;
  }

}
