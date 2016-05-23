package com.mpewpazi.android.awaljunisidang.masterData;

/**
 * Created by mpewpazi on 5/20/16.
 */
public class MstJarakKedalaman extends SingleMaster {
    private int idMstJarakKedalaman;
    private String jarakKedalaman;
    public static final String kode="jarakKedalaman";

    public int getIdMstJarakKedalaman() {
        return idMstJarakKedalaman;
    }

    public void setIdMstJarakKedalaman(int idMstJarakKedalaman) {
        this.idMstJarakKedalaman = idMstJarakKedalaman;
    }

    public String getJarakKedalaman() {
        return jarakKedalaman;
    }

    public void setJarakKedalaman(String jarakKedalaman) {
        this.jarakKedalaman = jarakKedalaman;
    }

    @Override
    public String getKodeMst() {
        return kode;
    }
}
