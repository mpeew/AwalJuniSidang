package com.mpewpazi.android.awaljunisidang.Form;

import com.mpewpazi.android.awaljunisidang.Fragment.ListFormKompal3bFragment;
import com.mpewpazi.android.awaljunisidang.Fragment.SingleFragment;

import java.util.UUID;

/**
 * Created by mpewpazi on 5/6/16.
 */
public class FormKompal3b extends SingleForm {

    private UUID idjumlahProduksi;
    private int idPeriode;
    private int jenisProdukId;
    private int jumlahProdThn1;
    private int jumlahProdThn2;
    private int jumlahProdThn3;
    private int jumlahProdThn4;
    private int satuanId;
    private double nilaiProduksiThn1;
    private double nilaiProduksiThn2;
    private double nilaiProduksiThn3;
    private double nilaiProduksiThn4;
    private String keterangan;
    private String note;

    public static final int kode=5;
    public static final String kodeAsync="FK3b";


    @Override
    public int getKodeForm() {
        return kode;
    }

    @Override
    public String getKodeAsync() {
        return kodeAsync;
    }

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

    public int getJenisProdukId() {
        return jenisProdukId;
    }

    public void setJenisProdukId(int jenisProdukId) {
        this.jenisProdukId = jenisProdukId;
    }

    public UUID getIdjumlahProduksi() {
        return idjumlahProduksi;
    }

    public void setIdjumlahProduksi(UUID idjumlahProduksi) {
        this.idjumlahProduksi = idjumlahProduksi;
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

    public int getSatuanId() {
        return satuanId;
    }

    public void setSatuanId(int satuanId) {
        this.satuanId = satuanId;
    }

    public double getNilaiProduksiThn1() {
        return nilaiProduksiThn1;
    }

    public void setNilaiProduksiThn1(double nilaiProduksiThn1) {
        this.nilaiProduksiThn1 = nilaiProduksiThn1;
    }

    public double getNilaiProduksiThn2() {
        return nilaiProduksiThn2;
    }

    public void setNilaiProduksiThn2(double nilaiProduksiThn2) {
        this.nilaiProduksiThn2 = nilaiProduksiThn2;
    }

    public double getNilaiProduksiThn3() {
        return nilaiProduksiThn3;
    }

    public void setNilaiProduksiThn3(double nilaiProduksiThn3) {
        this.nilaiProduksiThn3 = nilaiProduksiThn3;
    }

    public double getNilaiProduksiThn4() {
        return nilaiProduksiThn4;
    }

    public void setNilaiProduksiThn4(double nilaiProduksiThn4) {
        this.nilaiProduksiThn4 = nilaiProduksiThn4;
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
