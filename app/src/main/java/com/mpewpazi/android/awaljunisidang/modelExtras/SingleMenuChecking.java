package com.mpewpazi.android.awaljunisidang.modelExtras;

/**
 * Created by mpewpazi on 5/12/16.
 */
public abstract class SingleMenuChecking {
    private int idKualifikasiSurvey;
    private int idMenu;
    private boolean fill;
    private boolean complete;
    private boolean verified;
    private int idMenuCheckingServer;

    public int getIdMenuCheckingServer() {
        return idMenuCheckingServer;
    }

    public void setIdMenuCheckingServer(int idMenuCheckingServer) {
        this.idMenuCheckingServer = idMenuCheckingServer;
    }

    public int getIdKualifikasiSurvey() {
        return idKualifikasiSurvey;
    }

    public void setIdKualifikasiSurvey(int idKualifikasiSurvey) {
        this.idKualifikasiSurvey = idKualifikasiSurvey;
    }

    public int getIdMenu() {
        return idMenu;
    }

    public void setIdMenu(int idMenu) {
        this.idMenu = idMenu;
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

    public abstract String kodeAsync();
}
