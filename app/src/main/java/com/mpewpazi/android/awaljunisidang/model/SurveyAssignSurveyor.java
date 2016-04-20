package com.mpewpazi.android.awaljunisidang.model;

import java.util.Date;

/**
 * Created by mpewpazi on 4/19/16.
 */
public class SurveyAssignSurveyor {
    private int surveyAssignSurveyorId;
    private KualifikasiSurvey kualifikasiSurvey;
    private User user;
    private Date assignDate;
    private User assignBy;

    public int getSurveyAssignSurveyorId() {
        return surveyAssignSurveyorId;
    }

    public void setSurveyAssignSurveyorId(int surveyAssignSurveyorId) {
        this.surveyAssignSurveyorId = surveyAssignSurveyorId;
    }

    public KualifikasiSurvey getKualifikasiSurvey() {
        return kualifikasiSurvey;
    }

    public void setKualifikasiSurvey(KualifikasiSurvey kualifikasiSurvey) {
        this.kualifikasiSurvey = kualifikasiSurvey;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getAssignDate() {
        return assignDate;
    }

    public void setAssignDate(Date assignDate) {
        this.assignDate = assignDate;
    }

    public User getAssignBy() {
        return assignBy;
    }

    public void setAssignBy(User assignBy) {
        this.assignBy = assignBy;
    }
}
