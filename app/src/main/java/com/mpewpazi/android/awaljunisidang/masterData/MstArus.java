package com.mpewpazi.android.awaljunisidang.masterData;

/**
 * Created by mpewpazi on 5/20/16.
 */
public class MstArus extends SingleMaster{
    private int idMstArus;
    private String arus;
    public static final String kode="arus";

    public int getIdMstArus() {
        return idMstArus;
    }

    public void setIdMstArus(int idMstArus) {
        this.idMstArus = idMstArus;
    }

    public String getArus() {
        return arus;
    }

    public void setArus(String arus) {
        this.arus = arus;
    }

    @Override
    public String getKodeMst() {
        return kode;
    }
}
