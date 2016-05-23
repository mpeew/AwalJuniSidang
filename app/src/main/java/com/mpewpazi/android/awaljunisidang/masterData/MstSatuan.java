package com.mpewpazi.android.awaljunisidang.masterData;

/**
 * Created by mpewpazi on 5/20/16.
 */
public class MstSatuan extends SingleMaster{
    private int idMstSatuan;
    private String satuan;
    public static final String kode="satuan";

    public int getIdMstSatuan() {
        return idMstSatuan;
    }

    public void setIdMstSatuan(int idMstSatuan) {
        this.idMstSatuan = idMstSatuan;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    @Override
    public String getKodeMst() {
        return kode;
    }
}
