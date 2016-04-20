package com.mpewpazi.android.awaljunisidang.Form;

import android.support.v4.app.Fragment;

import com.mpewpazi.android.awaljunisidang.model.KualifikasiSurvey;

/**
 * Created by mpewpazi on 3/31/16.
 */
public class SingleForm {
    protected String mNamaForm;
    protected Fragment mFragment;
    protected KualifikasiSurvey mKualifikasiSurvey;

    public KualifikasiSurvey getKualifikasiSurvey() {
        return mKualifikasiSurvey;
    }

    public void setKualifikasiSurvey(KualifikasiSurvey kualifikasiSurvey) {
        mKualifikasiSurvey = kualifikasiSurvey;
    }

    public String getNamaForm() {
        return mNamaForm;
    }

    public Fragment getFragment() {
        return mFragment;
    }
}
