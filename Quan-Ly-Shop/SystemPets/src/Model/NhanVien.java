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
public class NhanVien {

  String MaNV, TenNV, MatKhau, DiaChi, Email, SDT, HinhAnh;
  boolean VaiTro;
  Date NgaySinh, NgayVaoLam;
  double Luong;
  boolean trangThai;

  public NhanVien() {
  }

  public NhanVien(String MaNV, String TenNV, String MatKhau, String DiaChi, String Email, String SDT, String HinhAnh, boolean VaiTro, Date NgaySinh, Date NgayVaoLam, double Luong, boolean trangThai) {
    this.MaNV = MaNV;
    this.TenNV = TenNV;
    this.MatKhau = MatKhau;
    this.DiaChi = DiaChi;
    this.Email = Email;
    this.SDT = SDT;
    this.HinhAnh = HinhAnh;
    this.VaiTro = VaiTro;
    this.NgaySinh = NgaySinh;
    this.NgayVaoLam = NgayVaoLam;
    this.Luong = Luong;
    this.trangThai = trangThai;
  }

  public String getMaNV() {
    return MaNV;
  }

  public void setMaNV(String MaNV) {
    this.MaNV = MaNV;
  }

  public String getTenNV() {
    return TenNV;
  }

  public void setTenNV(String TenNV) {
    this.TenNV = TenNV;
  }

  public String getMatKhau() {
    return MatKhau;
  }

  public void setMatKhau(String MatKhau) {
    this.MatKhau = MatKhau;
  }

  public String getDiaChi() {
    return DiaChi;
  }

  public void setDiaChi(String DiaChi) {
    this.DiaChi = DiaChi;
  }

  public String getEmail() {
    return Email;
  }

  public void setEmail(String Email) {
    this.Email = Email;
  }

  public String getSDT() {
    return SDT;
  }

  public void setSDT(String SDT) {
    this.SDT = SDT;
  }

  public String getHinhAnh() {
    return HinhAnh;
  }

  public void setHinhAnh(String HinhAnh) {
    this.HinhAnh = HinhAnh;
  }

  public boolean isVaiTro() {
    return VaiTro;
  }

  public void setVaiTro(boolean VaiTro) {
    this.VaiTro = VaiTro;
  }

  public Date getNgaySinh() {
    return NgaySinh;
  }

  public void setNgaySinh(Date NgaySinh) {
    this.NgaySinh = NgaySinh;
  }

  public Date getNgayVaoLam() {
    return NgayVaoLam;
  }

  public void setNgayVaoLam(Date NgayVaoLam) {
    this.NgayVaoLam = NgayVaoLam;
  }

  public double getLuong() {
    return Luong;
  }

  public void setLuong(double Luong) {
    this.Luong = Luong;
  }

  public boolean isTrangThai() {
    return trangThai;
  }

  public void setTrangThai(boolean trangThai) {
    this.trangThai = trangThai;
  }

}
