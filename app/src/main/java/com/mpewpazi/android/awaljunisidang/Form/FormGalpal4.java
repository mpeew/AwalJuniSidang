package com.mpewpazi.android.awaljunisidang.Form;

import android.support.v4.app.Fragment;

import com.mpewpazi.android.awaljunisidang.Fragment.FormGalpal3Fragment;
import com.mpewpazi.android.awaljunisidang.Fragment.FormGalpal4Fragment;

/**
 * Created by mpewpazi on 4/20/16.
 */
public class FormGalpal4 extends SingleForm {
    private int tinjauanWilayahMaritimId;
    private String jarakKedalaman;
    private String AirPelayaran;
    private String pasangSurut;
    private String arus;
    private String gelombang;
    private String panjangWaterfront;
    private String luasLahan;
    private String ketersediaanLahan;
    private String lahanProduktif;
    private String lahanPemukiman;
    private String dayaDukung;
    private String kelandaian;
    private String dekatJalan;
    private String kota;
    private String interkoneksiAngkutan;
    private String nilaiEkonomi;
    private String perkembanganWilayah;
    private String rutrw;


    @Override
    public String getNamaForm() {
        return "Tinjauan Wilayah Maritim";
    }

    @Override
    public Fragment getFragment() {
        return new FormGalpal4Fragment();
    }

    public int getTinjauanWilayahMaritimId() {
        return tinjauanWilayahMaritimId;
    }

    public void setTinjauanWilayahMaritimId(int tinjauanWilayahMaritimId) {
        this.tinjauanWilayahMaritimId = tinjauanWilayahMaritimId;
    }

    public String getJarakKedalaman() {
        return jarakKedalaman;
    }

    public void setJarakKedalaman(String jarakKedalaman) {
        this.jarakKedalaman = jarakKedalaman;
    }

    public String getAirPelayaran() {
        return AirPelayaran;
    }

    public void setAirPelayaran(String airPelayaran) {
        AirPelayaran = airPelayaran;
    }

    public String getPasangSurut() {
        return pasangSurut;
    }

    public void setPasangSurut(String pasangSurut) {
        this.pasangSurut = pasangSurut;
    }

    public String getArus() {
        return arus;
    }

    public void setArus(String arus) {
        this.arus = arus;
    }

    public String getGelombang() {
        return gelombang;
    }

    public void setGelombang(String gelombang) {
        this.gelombang = gelombang;
    }

    public String getPanjangWaterfront() {
        return panjangWaterfront;
    }

    public void setPanjangWaterfront(String panjangWaterfront) {
        this.panjangWaterfront = panjangWaterfront;
    }

    public String getLuasLahan() {
        return luasLahan;
    }

    public void setLuasLahan(String luasLahan) {
        this.luasLahan = luasLahan;
    }

    public String getKetersediaanLahan() {
        return ketersediaanLahan;
    }

    public void setKetersediaanLahan(String ketersediaanLahan) {
        this.ketersediaanLahan = ketersediaanLahan;
    }

    public String getLahanProduktif() {
        return lahanProduktif;
    }

    public void setLahanProduktif(String lahanProduktif) {
        this.lahanProduktif = lahanProduktif;
    }

    public String getLahanPemukiman() {
        return lahanPemukiman;
    }

    public void setLahanPemukiman(String lahanPemukiman) {
        this.lahanPemukiman = lahanPemukiman;
    }

    public String getDayaDukung() {
        return dayaDukung;
    }

    public void setDayaDukung(String dayaDukung) {
        this.dayaDukung = dayaDukung;
    }

    public String getKelandaian() {
        return kelandaian;
    }

    public void setKelandaian(String kelandaian) {
        this.kelandaian = kelandaian;
    }

    public String getDekatJalan() {
        return dekatJalan;
    }

    public void setDekatJalan(String dekatJalan) {
        this.dekatJalan = dekatJalan;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getInterkoneksiAngkutan() {
        return interkoneksiAngkutan;
    }

    public void setInterkoneksiAngkutan(String interkoneksiAngkutan) {
        this.interkoneksiAngkutan = interkoneksiAngkutan;
    }

    public String getNilaiEkonomi() {
        return nilaiEkonomi;
    }

    public void setNilaiEkonomi(String nilaiEkonomi) {
        this.nilaiEkonomi = nilaiEkonomi;
    }

    public String getPerkembanganWilayah() {
        return perkembanganWilayah;
    }

    public void setPerkembanganWilayah(String perkembanganWilayah) {
        this.perkembanganWilayah = perkembanganWilayah;
    }

    public String getRutrw() {
        return rutrw;
    }

    public void setRutrw(String rutrw) {
        this.rutrw = rutrw;
    }
}
