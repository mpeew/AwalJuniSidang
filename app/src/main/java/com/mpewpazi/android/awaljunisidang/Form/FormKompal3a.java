package com.mpewpazi.android.awaljunisidang.Form;

import java.util.UUID;

/**
 * Created by mpewpazi on 5/6/16.
 */
public class FormKompal3a {
    private UUID idJenisKapasitasProduksi;
    private int idKualifikasiSurvey;
    private String jenisProduksi;
    private String kapasitasProduksi;
    private String satuan;

    public FormKompal3a(){
        this(UUID.randomUUID());
    }

    public FormKompal3a(UUID id){
        idJenisKapasitasProduksi=id;
    }

    public UUID getIdJenisKapasitasProduksi() {
        return idJenisKapasitasProduksi;
    }

    public void setIdJenisKapasitasProduksi(UUID idJenisKapasitasProduksi) {
        this.idJenisKapasitasProduksi = idJenisKapasitasProduksi;
    }

    public int getIdKualifikasiSurvey() {
        return idKualifikasiSurvey;
    }

    public void setIdKualifikasiSurvey(int idKualifikasiSurvey) {
        this.idKualifikasiSurvey = idKualifikasiSurvey;
    }

    public String getJenisProduksi() {
        return jenisProduksi;
    }

    public void setJenisProduksi(String jenisProduksi) {
        this.jenisProduksi = jenisProduksi;
    }

    public String getKapasitasProduksi() {
        return kapasitasProduksi;
    }

    public void setKapasitasProduksi(String kapasitasProduksi) {
        this.kapasitasProduksi = kapasitasProduksi;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }
}
