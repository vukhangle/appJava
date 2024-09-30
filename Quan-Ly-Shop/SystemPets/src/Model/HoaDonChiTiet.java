/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author TechCare
 */
public class HoaDonChiTiet {

  int SoLuongMua;
  String MaHD, MaDV, MaSP;
  double Gia;

  public HoaDonChiTiet() {
  }

  public HoaDonChiTiet(int SoLuongMua, String MaHD, String MaDV, String MaSP, double Gia) {
    this.SoLuongMua = SoLuongMua;
    this.MaHD = MaHD;
    this.MaDV = MaDV;
    this.MaSP = MaSP;
    this.Gia = Gia;
  }

  public int getSoLuongMua() {
    return SoLuongMua;
  }

  public void setSoLuongMua(int SoLuongMua) {
    this.SoLuongMua = SoLuongMua;
  }

  public String getMaHD() {
    return MaHD;
  }

  public void setMaHD(String MaHD) {
    this.MaHD = MaHD;
  }

  public String getMaDV() {
    return MaDV;
  }

  public void setMaDV(String MaDV) {
    this.MaDV = MaDV;
  }

  public String getMaSP() {
    return MaSP;
  }

  public void setMaSP(String MaSP) {
    this.MaSP = MaSP;
  }

  public double getGia() {
    return Gia;
  }

  public void setGia(double Gia) {
    this.Gia = Gia;
  }

}
