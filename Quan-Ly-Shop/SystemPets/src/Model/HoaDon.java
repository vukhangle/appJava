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
public class HoaDon {
    String MaNV,SDT,GhiChu;
    Date NgayTao;

    public HoaDon() {
    }

    public HoaDon(String MaNV, String SDT, String GhiChu, Date NgayTao) {
        this.MaNV = MaNV;
        this.SDT = SDT;
        this.GhiChu = GhiChu;
        this.NgayTao = NgayTao;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }

   
}
