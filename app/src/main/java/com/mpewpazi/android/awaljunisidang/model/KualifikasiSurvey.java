package com.mpewpazi.android.awaljunisidang.model;

/**
 * Created by mpewpazi on 4/19/16.
 */
public class KualifikasiSurvey {
    private int kualifikasiSurveyId;
    private Perusahaan perusahaan;
    private PeriodeSurvey periodeSurvey;
    private GalanganKapal galanganKapal;

    public int getKualifikasiSurveyId() {
        return kualifikasiSurveyId;
    }

    public void setKualifikasiSurveyId(int kualifikasiSurveyId) {
        this.kualifikasiSurveyId = kualifikasiSurveyId;
    }

    public Perusahaan getPerusahaan() {
        return perusahaan;
    }

    public void setPerusahaan(Perusahaan perusahaan) {
        this.perusahaan = perusahaan;
    }

    public PeriodeSurvey getPeriodeSurvey() {
        return periodeSurvey;
    }

    public void setPeriodeSurvey(PeriodeSurvey periodeSurvey) {
        this.periodeSurvey = periodeSurvey;
    }

    public GalanganKapal getGalanganKapal() {
        return galanganKapal;
    }

    public void setGalanganKapal(GalanganKapal galanganKapal) {
        this.galanganKapal = galanganKapal;
    }
}
