package com.mpewpazi.android.awaljunisidang.masterData;

/**
 * Created by mpewpazi on 5/20/16.
 */
public class MstAirPelayaran extends SingleMaster {
    private int idMstAirPelayaran;
    private String airPelayaran;
    public static final String kode="airPelayaran";



    public int getIdMstAirPelayaran() {
        return idMstAirPelayaran;
    }

    public void setIdMstAirPelayaran(int idMstAirPelayaran) {
        this.idMstAirPelayaran = idMstAirPelayaran;
    }

    public String getAirPelayaran() {
        return airPelayaran;
    }

    public void setAirPelayaran(String airPelayaran) {
        this.airPelayaran = airPelayaran;
    }

    @Override
    public String getKodeMst() {
        return kode;
    }
}
