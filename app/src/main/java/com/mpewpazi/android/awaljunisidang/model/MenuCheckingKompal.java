package com.mpewpazi.android.awaljunisidang.model;

/**
 * Created by mpewpazi on 5/11/16.
 */
public class MenuCheckingKompal {
    private int idMenuCheckingKompal;
    private int idKualifikasiSurvey;
    private int idMenuKompal;
    private boolean fill;
    private boolean complete;
    private boolean verified;

    public int getIdMenuCheckingKompal() {
        return idMenuCheckingKompal;
    }

    public void setIdMenuCheckingKompal(int idMenuCheckingKompal) {
        this.idMenuCheckingKompal = idMenuCheckingKompal;
    }

    public int getIdKualifikasiSurvey() {
        return idKualifikasiSurvey;
    }

    public void setIdKualifikasiSurvey(int idKualifikasiSurvey) {
        this.idKualifikasiSurvey = idKualifikasiSurvey;
    }

    public int getIdMenuKompal() {
        return idMenuKompal;
    }

    public void setIdMenuKompal(int idMenuKompal) {
        this.idMenuKompal = idMenuKompal;
    }

    public boolean isFill() {
        return fill;
    }

    public void setFill(boolean fill) {
        this.fill = fill;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public boolean isVerified() {
        return verified;
    }

    public void setVerified(boolean verified) {
        this.verified = verified;
    }
}
