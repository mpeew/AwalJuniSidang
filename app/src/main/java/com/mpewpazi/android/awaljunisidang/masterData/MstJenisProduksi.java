package com.mpewpazi.android.awaljunisidang.masterData;

/**
 * Created by mpewpazi on 5/20/16.
 */
public class MstJenisProduksi extends SingleMaster {
    private String kki;
    public static final String kode="jenisProduksi";

    public String getKki() {
        return kki;
    }

    public void setKki(String kki) {
        this.kki = kki;
    }


    @Override
    public String getKodeMst() {
        return kode;
    }
}
