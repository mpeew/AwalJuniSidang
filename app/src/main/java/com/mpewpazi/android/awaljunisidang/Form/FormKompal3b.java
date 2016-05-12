package com.mpewpazi.android.awaljunisidang.Form;

import com.mpewpazi.android.awaljunisidang.Fragment.ListFormKompal3bFragment;
import com.mpewpazi.android.awaljunisidang.Fragment.SingleFragment;

import java.util.UUID;

/**
 * Created by mpewpazi on 5/6/16.
 */
public class FormKompal3b extends SingleForm {
    private UUID idjumlahProduksi;
    private int idKualifikasiSurvey;
    private String jenisProduk;
    private int jumlahProdThn1;
    private int jumlahProdThn2;
    private int jumlahProdThn3;
    private int jumlahProdThn4;
    private String satuan;
    private int nilaiProduksiThn1;
    private int nilaiProduksiThn2;
    private int nilaiProduksiThn3;
    private int nilaiProduksiThn4;
    private String keterangan;

    @Override
    public String getNamaForm() {
        return "Jumlah dan Nilai Produksi 4 Tahun Terakhir";
    }

    @Override
    public SingleFragment getFragment() {
        return new ListFormKompal3bFragment();
    }

    public FormKompal3b(){
        this(UUID.randomUUID());
    }

    public FormKompal3b(UUID id){
        idjumlahProduksi=id;
    }

    public String getJenisProduk() {
        return jenisProduk;
    }

    public void setJenisProduk(String jenisProduk) {
        this.jenisProduk = jenisProduk;
    }

    public UUID getIdjumlahProduksi() {
        return idjumlahProduksi;
    }

    public void setIdjumlahProduksi(UUID idjumlahProduksi) {
        this.idjumlahProduksi = idjumlahProduksi;
    }

    public int getIdKualifikasiSurvey() {
        return idKualifikasiSurvey;
    }

    public void setIdKualifikasiSurvey(int idKualifikasiSurvey) {
        this.idKualifikasiSurvey = idKualifikasiSurvey;
    }

    public int getJumlahProdThn1() {
        return jumlahProdThn1;
    }

    public void setJumlahProdThn1(int jumlahProdThn1) {
        this.jumlahProdThn1 = jumlahProdThn1;
    }

    public int getJumlahProdThn2() {
        return jumlahProdThn2;
    }

    public void setJumlahProdThn2(int jumlahProdThn2) {
        this.jumlahProdThn2 = jumlahProdThn2;
    }

    public int getJumlahProdThn3() {
        return jumlahProdThn3;
    }

    public void setJumlahProdThn3(int jumlahProdThn3) {
        this.jumlahProdThn3 = jumlahProdThn3;
    }

    public int getJumlahProdThn4() {
        return jumlahProdThn4;
    }

    public void setJumlahProdThn4(int jumlahProdThn4) {
        this.jumlahProdThn4 = jumlahProdThn4;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public int getNilaiProduksiThn1() {
        return nilaiProduksiThn1;
    }

    public void setNilaiProduksiThn1(int nilaiProduksiThn1) {
        this.nilaiProduksiThn1 = nilaiProduksiThn1;
    }

    public int getNilaiProduksiThn2() {
        return nilaiProduksiThn2;
    }

    public void setNilaiProduksiThn2(int nilaiProduksiThn2) {
        this.nilaiProduksiThn2 = nilaiProduksiThn2;
    }

    public int getNilaiProduksiThn3() {
        return nilaiProduksiThn3;
    }

    public void setNilaiProduksiThn3(int nilaiProduksiThn3) {
        this.nilaiProduksiThn3 = nilaiProduksiThn3;
    }

    public int getNilaiProduksiThn4() {
        return nilaiProduksiThn4;
    }

    public void setNilaiProduksiThn4(int nilaiProduksiThn4) {
        this.nilaiProduksiThn4 = nilaiProduksiThn4;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}