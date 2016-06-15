package com.mpewpazi.android.awaljunisidang.masterDataModel;

/**
 * Created by mpewpazi on 4/12/16.
 */
public class MstPropinsi extends SingleMaster {
    int kodeBps;
    String kodeiso;
    String ibukota;
    String pulau;
    public static final String kode="propinsi";


    public int getKodeBps() {
        return kodeBps;
    }

    public void setKodeBps(int kodeBps) {
        this.kodeBps = kodeBps;
    }

    public String getKodeiso() {
        return kodeiso;
    }

    public void setKodeiso(String kodeiso) {
        this.kodeiso = kodeiso;
    }

    public String getIbukota() {
        return ibukota;
    }

    public void setIbukota(String ibukota) {
        this.ibukota = ibukota;
    }

    public String getPulau() {
        return pulau;
    }

    public void setPulau(String pulau) {
        this.pulau = pulau;
    }

    @Override
    public String getKodeMst() {
        return kode;
    }
}
