package com.mpewpazi.android.awaljunisidang.Form;

import com.mpewpazi.android.awaljunisidang.Fragment.ListFormKompal3aFragment;
import com.mpewpazi.android.awaljunisidang.Fragment.SingleFragment;

import java.util.UUID;

/**
 * Created by mpewpazi on 5/6/16.
 */
public class FormKompal3a extends SingleForm {
    private UUID idJenisKapasitasProduksi;
    private int idKualifikasiSurvey;
    private String jenisProduksi;
    private int kapasitasProduksi;
    private int satuan;

    @Override
    public SingleFragment getFragment() {
        return new ListFormKompal3aFragment();
    }

    @Override
    public String getNamaForm() {
        return "Jenis dan Kapasitas Produksi";
    }

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

    public int getKapasitasProduksi() {
        return kapasitasProduksi;
    }

    public void setKapasitasProduksi(int kapasitasProduksi) {
        this.kapasitasProduksi = kapasitasProduksi;
    }

    public int getSatuan() {
        return satuan;
    }

    public void setSatuan(int satuan) {
        this.satuan = satuan;
    }
}
