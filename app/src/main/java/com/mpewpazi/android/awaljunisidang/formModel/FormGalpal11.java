package com.mpewpazi.android.awaljunisidang.formModel;

import com.mpewpazi.android.awaljunisidang.fragment.ListFormGalpal11Fragment;
import com.mpewpazi.android.awaljunisidang.fragment.SingleFragment;

import java.util.UUID;

/**
 * Created by mpewpazi on 5/27/16.
 */
public class FormGalpal11 extends SingleForm {
    private UUID idPeralatanKerjaProdPengecatan;
    private int idPeriode;
    private String jenisMesin;
    private int tahunPembuatan;
    private String merek;
    private int kapasitasTerpasang;
    private String satuanKapastiasTerpasang="-";
    private int kapasitasTerpakai;
    private String satuanKapasitasTerpakai="-";
    private String dimensi;
    private int jumlah;
    private String kondisi;
    private String lokasi;
    private String status;


    public static final int kode=12;
    public static final String kodeAsync="FG11";

    @Override
    public int getKodeForm() {
        return kode;
    }

    @Override
    public String getKodeAsync() {
        return kodeAsync;
    }

    @Override
    public SingleFragment getFragment() {
        return new ListFormGalpal11Fragment();
    }

    @Override
    public String getNamaForm() {
        return "Peralatan Kerja Produksi Pengecatan";
    }

    public FormGalpal11(){
        this(UUID.randomUUID());
    }

    public FormGalpal11(UUID id){
        idPeralatanKerjaProdPengecatan=id;
    }

    public int getIdPeriode() {
        return idPeriode;
    }

    public void setIdPeriode(int idPeriode) {
        this.idPeriode = idPeriode;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public UUID getIdPeralatanKerjaProdPengecatan() {
        return idPeralatanKerjaProdPengecatan;
    }

    public String getJenisMesin() {
        return jenisMesin;
    }

    public void setJenisMesin(String jenisMesin) {
        this.jenisMesin = jenisMesin;
    }

    public int getTahunPembuatan() {
        return tahunPembuatan;
    }

    public void setTahunPembuatan(int tahunPembuatan) {
        this.tahunPembuatan = tahunPembuatan;
    }

    public String getMerek() {
        return merek;
    }

    public void setMerek(String merek) {
        this.merek = merek;
    }

    public int getKapasitasTerpasang() {
        return kapasitasTerpasang;
    }

    public void setKapasitasTerpasang(int kapasitasTerpasang) {
        this.kapasitasTerpasang = kapasitasTerpasang;
    }

    public String getSatuanKapastiasTerpasang() {
        return satuanKapastiasTerpasang;
    }

    public void setSatuanKapastiasTerpasang(String satuanKapastiasTerpasang) {
        this.satuanKapastiasTerpasang = satuanKapastiasTerpasang;
    }

    public int getKapasitasTerpakai() {
        return kapasitasTerpakai;
    }

    public void setKapasitasTerpakai(int kapasitasTerpakai) {
        this.kapasitasTerpakai = kapasitasTerpakai;
    }

    public String getSatuanKapasitasTerpakai() {
        return satuanKapasitasTerpakai;
    }

    public void setSatuanKapasitasTerpakai(String satuanKapasitasTerpakai) {
        this.satuanKapasitasTerpakai = satuanKapasitasTerpakai;
    }

    public String getDimensi() {
        return dimensi;
    }

    public void setDimensi(String dimensi) {
        this.dimensi = dimensi;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public String getKondisi() {
        return kondisi;
    }

    public void setKondisi(String kondisi) {
        this.kondisi = kondisi;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
