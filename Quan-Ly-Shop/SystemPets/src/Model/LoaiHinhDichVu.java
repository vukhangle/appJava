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
public class LoaiHinhDichVu {
    String MaLH,TenLH,GhiChu;

    public LoaiHinhDichVu() {
    }

    public LoaiHinhDichVu(String MaLH, String TenLH, String GhiChu) {
        this.MaLH = MaLH;
        this.TenLH = TenLH;
        this.GhiChu = GhiChu;
    }

    public String getMaLH() {
        return MaLH;
    }

    public void setMaLH(String MaLH) {
        this.MaLH = MaLH;
    }

    public String getTenLH() {
        return TenLH;
    }

    public void setTenLH(String TenLH) {
        this.TenLH = TenLH;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

   
}
