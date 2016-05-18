package com.mpewpazi.android.awaljunisidang.masterData;

/**
 * Created by mpewpazi on 5/16/16.
 */
public class Kabupaten {
    private int id;
    private String nama;
    private String ibuKota;
    private int id_propinsi;
    private int ibuKotaPropinsi;
    private int jumlahPenduduk;
    private int kodebps;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getIbuKota() {
        return ibuKota;
    }

    public void setIbuKota(String ibuKota) {
        this.ibuKota = ibuKota;
    }

    public int getId_propinsi() {
        return id_propinsi;
    }

    public void setId_propinsi(int id_propinsi) {
        this.id_propinsi = id_propinsi;
    }

    public int getIbuKotaPropinsi() {
        return ibuKotaPropinsi;
    }

    public void setIbuKotaPropinsi(int ibuKotaPropinsi) {
        this.ibuKotaPropinsi = ibuKotaPropinsi;
    }

    public int getJumlahPenduduk() {
        return jumlahPenduduk;
    }

    public void setJumlahPenduduk(int jumlahPenduduk) {
        this.jumlahPenduduk = jumlahPenduduk;
    }

    public int getKodebps() {
        return kodebps;
    }

    public void setKodebps(int kodebps) {
        this.kodebps = kodebps;
    }
}
