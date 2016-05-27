package com.mpewpazi.android.awaljunisidang.model;

/**
 * Created by mpewpazi on 5/11/16.
 */
public class MenuCheckingKompal extends SingleMenuChecking {
    public static final String kodeAsync="MCKompal";
    private int idMenuCheckingKompal;


    public int getIdMenuCheckingKompal() {
        return idMenuCheckingKompal;
    }

    public void setIdMenuCheckingKompal(int idMenuCheckingKompal) {
        this.idMenuCheckingKompal = idMenuCheckingKompal;
    }

    @Override
    public String kodeAsync() {
        return kodeAsync;
    }
}
