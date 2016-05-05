package com.mpewpazi.android.awaljunisidang.Form;

import java.util.UUID;

/**
 * Created by mpewpazi on 4/18/16.
 */
public class FormGalpal6   {
    private UUID idPeralatanKerjaCrane;
    private int kualifikasiSurveyId;
    private String jenisMesin;
    private int tahunPembuatan;
    private String merek;
    private int kapasitasTerpasang;
    private String satuanKapastiasTerpasang;
    private int kapasitasTerpakai;
    private String satuanKapasitasTerpakai;
    private String dimensi;
    private int jumlah;
    private String kondisi;
    private String lokasi;
    private String status;

    public FormGalpal6(){
        this(UUID.randomUUID());
    }

    public FormGalpal6(UUID id){
        idPeralatanKerjaCrane=id;
    }

    public UUID getIdPeralatanKerjaCrane() {
        return idPeralatanKerjaCrane;
    }

    public void setIdPeralatanKerjaCrane(UUID idPeralatanKerjaCrane) {
        this.idPeralatanKerjaCrane = idPeralatanKerjaCrane;
    }

    public int getKualifikasiSurveyId() {
        return kualifikasiSurveyId;
    }

    public void setKualifikasiSurveyId(int kualifikasiSurveyId) {
        this.kualifikasiSurveyId = kualifikasiSurveyId;
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
