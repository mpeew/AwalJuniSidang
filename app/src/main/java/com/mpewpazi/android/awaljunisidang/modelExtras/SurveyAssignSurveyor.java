package com.mpewpazi.android.awaljunisidang.modelExtras;

import java.util.Date;

/**
 * Created by mpewpazi on 4/19/16.
 */
public class SurveyAssignSurveyor {
    private int surveyAssignSurveyorId;
    private int kualifikasiSurveyId;
    private String userId;
    private Date assignDate;
    private int assignByUserId;

    public int getSurveyAssignSurveyorId() {
        return surveyAssignSurveyorId;
    }

    public void setSurveyAssignSurveyorId(int surveyAssignSurveyorId) {
        this.surveyAssignSurveyorId = surveyAssignSurveyorId;
    }

    public int getKualifikasiSurveyId() {
        return kualifikasiSurveyId;
    }

    public void setKualifikasiSurveyId(int kualifikasiSurveyId) {
        this.kualifikasiSurveyId = kualifikasiSurveyId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getAssignDate() {
        return assignDate;
    }

    public void setAssignDate(Date assignDate) {
        this.assignDate = assignDate;
    }

    public int getAssignByUserId() {
        return assignByUserId;
    }

    public void setAssignByUserId(int assignByUserId) {
        this.assignByUserId = assignByUserId;
    }
}
