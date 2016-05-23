package com.mpewpazi.android.awaljunisidang.masterData;

/**
 * Created by mpewpazi on 5/20/16.
 */
public class MstGelombang extends SingleMaster{
    private int idMstGelombang;
    private String mstGelombang;
    public static final String kode="gelombang";

    public int getIdMstGelombang() {
        return idMstGelombang;
    }

    public void setIdMstGelombang(int idMstGelombang) {
        this.idMstGelombang = idMstGelombang;
    }

    public String getMstGelombang() {
        return mstGelombang;
    }

    public void setMstGelombang(String mstGelombang) {
        this.mstGelombang = mstGelombang;
    }

    @Override
    public String getKodeMst() {
        return kode;
    }
}
