package com.mpewpazi.android.awaljunisidang.Form;

import android.support.v4.app.Fragment;

/**
 * Created by mpewpazi on 3/31/16.
 */
public class SingleForm {
    protected String mNamaForm;
    protected boolean isSend=false;
    protected Fragment mFragment;
    protected int mKualifikasiSurveyId;

    public boolean isSend() {
        return isSend;
    }

    public void setNamaForm(String namaForm) {
        mNamaForm = namaForm;
    }

    public void setFragment(Fragment fragment) {
        mFragment = fragment;
    }

    public void setSend(boolean send) {
        isSend = send;
    }

    public int getKualifikasiSurveyId() {
        return mKualifikasiSurveyId;
    }

    public void setKualifikasiSurveyId(int kualifikasiSurveyId) {
        mKualifikasiSurveyId = kualifikasiSurveyId;
    }

    public String getNamaForm() {
        return mNamaForm;
    }

    public Fragment getFragment() {
        return mFragment;
    }
}
