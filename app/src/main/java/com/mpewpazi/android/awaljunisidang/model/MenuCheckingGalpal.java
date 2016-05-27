package com.mpewpazi.android.awaljunisidang.model;

/**
 * Created by mpewpazi on 5/11/16.
 */
public class MenuCheckingGalpal extends SingleMenuChecking{

    public static final String kodeAsync="MCGalpal";
    private int idMenuCheckingGalpal;

    public int getIdMenuCheckingGalpal() {
        return idMenuCheckingGalpal;
    }

    public void setIdMenuCheckingGalpal(int idMenuCheckingGalpal) {
        this.idMenuCheckingGalpal = idMenuCheckingGalpal;
    }

    @Override
    public String kodeAsync() {
        return kodeAsync;
    }
}
