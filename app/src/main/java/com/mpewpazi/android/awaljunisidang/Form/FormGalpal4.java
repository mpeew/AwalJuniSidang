package com.mpewpazi.android.awaljunisidang.Form;

import com.mpewpazi.android.awaljunisidang.Fragment.FormGalpal4Fragment;
import com.mpewpazi.android.awaljunisidang.Fragment.SingleFragment;

/**
 * Created by mpewpazi on 4/20/16.
 */
public class FormGalpal4 extends SingleForm {
    private int tinjauanWilayahMaritimId;
    private int jarakKedalaman;
    private int AirPelayaran;
    private int pasangSurutPerairan;
    private int arus;
    private int gelombang;
    private int panjangWaterfront;
    private int luasLahan;
    private String ketersediaanLahan;
    private String lahanProduktif;
    private String lahanPemukiman;
    private String pasangSurutDaratan;
    private String dayaDukung;
    private String kelandaian;
    private String dekatJalan;
    private String kota;
    private String interkoneksiAngkutan;
    private String nilaiEkonomi;
    private String perkembanganWilayah;
    private String rutrw;

    public static final String kode="FG4";


    @Override
    public String getKodeForm() {
        return kode;
    }

    @Override
    public String getNamaForm() {
        return "Tinjauan Wilayah Maritim";
    }

    @Override
    public SingleFragment getFragment() {
        return new FormGalpal4Fragment();
    }

    public int getTinjauanWilayahMaritimId() {
        return tinjauanWilayahMaritimId;
    }

    public void setTinjauanWilayahMaritimId(int tinjauanWilayahMaritimId) {
        this.tinjauanWilayahMaritimId = tinjauanWilayahMaritimId;
    }


    public int getJarakKedalaman() {
        return jarakKedalaman;
    }

    public void setJarakKedalaman(int jarakKedalaman) {
        this.jarakKedalaman = jarakKedalaman;
    }

    public int getAirPelayaran() {
        return AirPelayaran;
    }

    public void setAirPelayaran(int airPelayaran) {
        AirPelayaran = airPelayaran;
    }

    public int getPasangSurutPerairan() {
        return pasangSurutPerairan;
    }

    public void setPasangSurutPerairan(int pasangSurutPerairan) {
        this.pasangSurutPerairan = pasangSurutPerairan;
    }

    public int getArus() {
        return arus;
    }

    public void setArus(int arus) {
        this.arus = arus;
    }

    public int getGelombang() {
        return gelombang;
    }

    public void setGelombang(int gelombang) {
        this.gelombang = gelombang;
    }

    public int getPanjangWaterfront() {
        return panjangWaterfront;
    }

    public void setPanjangWaterfront(int panjangWaterfront) {
        this.panjangWaterfront = panjangWaterfront;
    }

    public int getLuasLahan() {
        return luasLahan;
    }

    public void setLuasLahan(int luasLahan) {
        this.luasLahan = luasLahan;
    }

    public String getPasangSurutDaratan() {
        return pasangSurutDaratan;
    }

    public void setPasangSurutDaratan(String pasangSurutDaratan) {
        this.pasangSurutDaratan = pasangSurutDaratan;
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
