package com.mpewpazi.android.awaljunisidang.modelExtras;

/**
 * Created by mpewpazi on 4/19/16.
 */
public class Perusahaan {
    int id;
    String namaPerusahaan;
    String industri;
    boolean isActive;
    public static final String industriGalpal="GALANGAN KAPAL";
    public static final String industriKompal="KOMPONEN";

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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
