package com.mpewpazi.android.awaljunisidang.Form;

import android.support.v4.app.Fragment;

import com.mpewpazi.android.awaljunisidang.Fragment.FormGalpal3Fragment;

/**
 * Created by mpewpazi on 3/31/16.
 */
public class FormGalpal3 extends SingleForm {

    private int identitasUmumGalanganId;
    private int perusahaanId;
    private String namaGalangan;
    private String nomorDock;
    private String nomorTelepon;
    private String fax;
    private String alamat;
    private String kelurahan;
    private String kecamatan;
    private String propinsi;
    private String kebupaten_kota;
    private String kodePos;
    private String kategoriGalangan;
    private String longitude;
    private String latitude;
    private String contactPerson;
    private String nomorCp;
    private String jabatan;
    private String email;




    @Override
    public String getNamaForm() {
        return "Identitas Umum Galangan";
    }

    @Override
    public Fragment getFragment() {
        return new FormGalpal3Fragment();
    }

    public int getIdentitasUmumGalanganId() {
        return identitasUmumGalanganId;
    }

    public void setIdentitasUmumGalanganId(int identitasUmumGalanganId) {
        this.identitasUmumGalanganId = identitasUmumGalanganId;
    }

    public int getPerusahaanId() {
        return perusahaanId;
    }

    public void setPerusahaanId(int perusahaanId) {
        this.perusahaanId = perusahaanId;
    }

    public String getNamaGalangan() {
        return namaGalangan;
    }

    public void setNamaGalangan(String namaGalangan) {
        this.namaGalangan = namaGalangan;
    }

    public String getNomorDock() {
        return nomorDock;
    }

    public void setNomorDock(String nomorDock) {
        this.nomorDock = nomorDock;
    }

    public String getNomorTelepon() {
        return nomorTelepon;
    }

    public void setNomorTelepon(String nomorTelepon) {
        this.nomorTelepon = nomorTelepon;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getKelurahan() {
        return kelurahan;
    }

    public void setKelurahan(String kelurahan) {
        this.kelurahan = kelurahan;
    }

    public String getKecamatan() {
        return kecamatan;
    }

    public void setKecamatan(String kecamatan) {
        this.kecamatan = kecamatan;
    }

    public String getPropinsi() {
        return propinsi;
    }

    public void setPropinsi(String propinsi) {
        this.propinsi = propinsi;
    }

    public String getKebupaten_kota() {
        return kebupaten_kota;
    }

    public void setKebupaten_kota(String kebupaten_kota) {
        this.kebupaten_kota = kebupaten_kota;
    }

    public String getKodePos() {
        return kodePos;
    }

    public void setKodePos(String kodePos) {
        this.kodePos = kodePos;
    }

    public String getKategoriGalangan() {
        return kategoriGalangan;
    }

    public void setKategoriGalangan(String kategoriGalangan) {
        this.kategoriGalangan = kategoriGalangan;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getNomorCp() {
        return nomorCp;
    }

    public void setNomorCp(String nomorCp) {
        this.nomorCp = nomorCp;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
