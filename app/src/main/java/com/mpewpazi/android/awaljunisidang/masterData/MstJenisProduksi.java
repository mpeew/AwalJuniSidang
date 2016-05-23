package com.mpewpazi.android.awaljunisidang.masterData;

/**
 * Created by mpewpazi on 5/20/16.
 */
public class MstJenisProduksi extends SingleMaster {
    private int idMstJenisProduksi;
    private String kki;
    private String jenisProduksi;
    public static final String kode="jenisProduksi";

    public int getIdMstJenisProduksi() {
        return idMstJenisProduksi;
    }

    public void setIdMstJenisProduksi(int idMstJenisProduksi) {
        this.idMstJenisProduksi = idMstJenisProduksi;
    }

    public String getKki() {
        return kki;
    }

    public void setKki(String kki) {
        this.kki = kki;
    }

    public String getJenisProduksi() {
        return jenisProduksi;
    }

    public void setJenisProduksi(String jenisProduksi) {
        this.jenisProduksi = jenisProduksi;
    }


    @Override
    public String getKodeMst() {
        return kode;
    }
}
