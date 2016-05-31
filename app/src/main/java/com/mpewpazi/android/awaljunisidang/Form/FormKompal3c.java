package com.mpewpazi.android.awaljunisidang.Form;

import com.mpewpazi.android.awaljunisidang.Fragment.ListFormKompal3cFragment;
import com.mpewpazi.android.awaljunisidang.Fragment.SingleFragment;

import java.util.UUID;

/**
 * Created by mpewpazi on 5/6/16.
 */
public class FormKompal3c extends SingleForm {
    private UUID idSistemBerproduksi;
    private int idPeriode;
    private String namaProduk="-";
    private int jenisProduksi;
    private int sistemProduksi;
    private int jumlahProduksiThn1;
    private int jumlahProduksiThn2;
    private int jumlahProduksiThn3;
    private int jumlahProduksiThn4;


    public static final int kode=6;
    public static final String kodeAsync="FK3c";


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
        return "Sistem Berproduksi";
    }

    @Override
    public SingleFragment getFragment() {
        return new ListFormKompal3cFragment();
    }


    public FormKompal3c(){
        this(UUID.randomUUID());
    }

    public FormKompal3c(UUID id){
        idSistemBerproduksi=id;
    }

    public UUID getIdSistemBerproduksi() {
        return idSistemBerproduksi;
    }

    public void setIdSistemBerproduksi(UUID idSistemBerproduksi) {
        this.idSistemBerproduksi = idSistemBerproduksi;
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) {
        this.namaProduk = namaProduk;
    }

    public int getJenisProduksi() {
        return jenisProduksi;
    }

    public void setJenisProduksi(int jenisProduksi) {
        this.jenisProduksi = jenisProduksi;
    }

    public int getSistemProduksi() {
        return sistemProduksi;
    }

    public void setSistemProduksi(int sistemProduksi) {
        this.sistemProduksi = sistemProduksi;
    }

    public int getJumlahProduksiThn1() {
        return jumlahProduksiThn1;
    }

    public void setJumlahProduksiThn1(int jumlahProduksiThn1) {
        this.jumlahProduksiThn1 = jumlahProduksiThn1;
    }

    public int getJumlahProduksiThn2() {
        return jumlahProduksiThn2;
    }

    public void setJumlahProduksiThn2(int jumlahProduksiThn2) {
        this.jumlahProduksiThn2 = jumlahProduksiThn2;
    }

    public int getJumlahProduksiThn3() {
        return jumlahProduksiThn3;
    }

    public void setJumlahProduksiThn3(int jumlahProduksiThn3) {
        this.jumlahProduksiThn3 = jumlahProduksiThn3;
    }

    public int getJumlahProduksiThn4() {
        return jumlahProduksiThn4;
    }

    public void setJumlahProduksiThn4(int jumlahProduksiThn4) {
        this.jumlahProduksiThn4 = jumlahProduksiThn4;
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
}
