package com.mpewpazi.android.awaljunisidang.model;

/**
 * Created by mpewpazi on 5/11/16.
 */
public class MenuCheckingGalpal {
    private int idMenuCheckingGalpal;
    private int idKualifikasiSurvey;
    private int idMenuGalpal;
    private boolean fill;
    private boolean complete;
    private boolean verified;

    public int getIdMenuCheckingGalpal() {
        return idMenuCheckingGalpal;
    }

    public void setIdMenuCheckingGalpal(int idMenuCheckingGalpal) {
        this.idMenuCheckingGalpal = idMenuCheckingGalpal;
    }

    public int getIdKualifikasiSurvey() {
        return idKualifikasiSurvey;
    }

    public void setIdKualifikasiSurvey(int idKualifikasiSurvey) {
        this.idKualifikasiSurvey = idKualifikasiSurvey;
    }

    public int getIdMenuGalpal() {
        return idMenuGalpal;
    }

    public void setIdMenuGalpal(int idMenuGalpal) {
        this.idMenuGalpal = idMenuGalpal;
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
