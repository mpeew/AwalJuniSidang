package com.mpewpazi.android.awaljunisidang.model;

/**
 * Created by mpewpazi on 4/19/16.
 */
public class Perusahaan {
    int id;
    String namaPerusahaan;
    String industri;
    int isActive;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNamaPerusahaan() {
        return namaPerusahaan;
    }

    public void setNamaPerusahaan(String namaPerusahaan) {
        this.namaPerusahaan = namaPerusahaan;
    }

    public String getIndustri() {
        return industri;
    }

    public void setIndustri(String industri) {
        this.industri = industri;
    }

    public int isActive() {
        return isActive;
    }

    public void setActive(int active) {
        isActive = active;
    }
}
