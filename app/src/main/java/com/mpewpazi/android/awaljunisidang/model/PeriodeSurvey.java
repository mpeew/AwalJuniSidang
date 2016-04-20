package com.mpewpazi.android.awaljunisidang.model;

/**
 * Created by mpewpazi on 4/19/16.
 */
public class PeriodeSurvey {
    private int periodeSurveyId;
    private String tahunKualifikasi;
    private int isActivePeriode;
    private int isDone;
    private String keterangan;

    public int getPeriodeSurveyId() {
        return periodeSurveyId;
    }

    public void setPeriodeSurveyId(int periodeSurveyId) {
        this.periodeSurveyId = periodeSurveyId;
    }

    public String getTahunKualifikasi() {
        return tahunKualifikasi;
    }

    public void setTahunKualifikasi(String tahunKualifikasi) {
        this.tahunKualifikasi = tahunKualifikasi;
    }

    public int isActivePeriode() {
        return isActivePeriode;
    }

    public void setActivePeriode(int activePeriode) {
        isActivePeriode = activePeriode;
    }

    public int isDone() {
        return isDone;
    }

    public void setDone(int done) {
        isDone = done;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
}




