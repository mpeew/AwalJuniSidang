package com.mpewpazi.android.awaljunisidang.masterData;

/**
 * Created by mpewpazi on 5/20/16.
 */
public class MstPasangSurut extends SingleMaster {
    private int idMstPasangSurut;
    private String pasangSurut;
    public static final String kode="pasangSurut";

    public int getIdMstPasangSurut() {
        return idMstPasangSurut;
    }

    public void setIdMstPasangSurut(int idMstPasangSurut) {
        this.idMstPasangSurut = idMstPasangSurut;
    }

    public String getPasangSurut() {
        return pasangSurut;
    }

    public void setPasangSurut(String pasangSurut) {
        this.pasangSurut = pasangSurut;
    }

    @Override
    public String getKodeMst() {
        return pasangSurut;
    }
}
