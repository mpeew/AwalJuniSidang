package com.mpewpazi.android.awaljunisidang.Form;

import com.mpewpazi.android.awaljunisidang.Fragment.ListFormKompal3aFragment;
import com.mpewpazi.android.awaljunisidang.Fragment.SingleFragment;

import java.util.UUID;

/**
 * Created by mpewpazi on 5/6/16.
 */
public class FormKompal3a extends SingleForm {
    private int idJenisKapasitasProduksiServer;
    private UUID idJenisKapasitasProduksi;
    private int idPeriode;
    private String jenisProduksi;
    private int kapasitasProduksi;
    private int satuan;
    private String note;

    public static final int kode=4;

    public int getIdJenisKapasitasProduksiServer() {
        return idJenisKapasitasProduksiServer;
    }

    public void setIdJenisKapasitasProduksiServer(int idJenisKapasitasProduksiServer) {
        this.idJenisKapasitasProduksiServer = idJenisKapasitasProduksiServer;
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

    @Override
    public SingleFragment getFragment() {
        return new ListFormKompal3aFragment();
    }

    @Override
    public int getKodeForm() {
        return kode;
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
