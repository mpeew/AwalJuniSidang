package com.mpewpazi.android.awaljunisidang.masterDataModel;

/**
 * Created by asputra on 5/24/16.
 */
public abstract class Menu {
    protected String number;
    protected String namaMenu;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNamaMenu() {
        return namaMenu;
    }

    public void setNamaMenu(String namaMenu) {
        this.namaMenu = namaMenu;
    }

    public abstract String getKodeAsync();
}
