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
public class DichVu {
   String MaDV,TenDV,MaLH,GhiChu;

    public DichVu(String MaDV, String TenDV, String MaLH, String GhiChu) {
        this.MaDV = MaDV;
        this.TenDV = TenDV;
        this.MaLH = MaLH;
        this.GhiChu = GhiChu;
    }

    public DichVu() {
    }

    public String getMaDV() {
        return MaDV;
    }

    public void setMaDV(String MaDV) {
        this.MaDV = MaDV;
    }

    public String getTenDV() {
        return TenDV;
    }

    public void setTenDV(String TenDV) {
        this.TenDV = TenDV;
    }

    public String getMaLH() {
        return MaLH;
    }

    public void setMaLH(String MaLH) {
        this.MaLH = MaLH;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }
   
   
}
