package com.mpewpazi.android.awaljunisidang.model;

/**
 * Created by mpewpazi on 4/19/16.
 */
public class KualifikasiSurvey {
    private int kualifikasiSurveyId;
    private int perusahaanId;
    private int periodeSurveyId;
    private int galanganKapalId;
    private int progress;

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public int getKualifikasiSurveyId() {
        return kualifikasiSurveyId;
    }

    public void setKualifikasiSurveyId(int kualifikasiSurveyId) {
        this.kualifikasiSurveyId = kualifikasiSurveyId;
    }

    public int getPerusahaanId() {
        return perusahaanId;
    }

    public void setPerusahaanId(int perusahaanId) {
        this.perusahaanId = perusahaanId;
    }

    public int getPeriodeSurveyId() {
        return periodeSurveyId;
    }

    public void setPeriodeSurveyId(int periodeSurveyId) {
        this.periodeSurveyId = periodeSurveyId;
    }

    public int getGalanganKapalId() {
        return galanganKapalId;
    }

    public void setGalanganKapalId(int galanganKapalId) {
        this.galanganKapalId = galanganKapalId;
    }
}
