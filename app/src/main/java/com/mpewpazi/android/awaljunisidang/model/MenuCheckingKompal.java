package com.mpewpazi.android.awaljunisidang.model;

import java.util.UUID;

/**
 * Created by mpewpazi on 5/11/16.
 */
public class MenuCheckingKompal {
    private UUID idMenuCheckingKompal;
    private int idKualifikasiSurvey;
    private int idMenuKompal;
    private boolean fill;
    private boolean complete;
    private boolean verified;

    public UUID getIdMenuCheckingKompal() {
        return idMenuCheckingKompal;
    }

    public MenuCheckingKompal(){
       idMenuCheckingKompal=UUID.randomUUID();
   }

    public MenuCheckingKompal(UUID uuid){
        idMenuCheckingKompal=uuid;
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
