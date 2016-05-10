package com.mpewpazi.android.awaljunisidang.Form;

import android.support.v4.app.Fragment;

/**
 * Created by mpewpazi on 3/31/16.
 */
public class SingleForm {
    protected String mNamaForm;
    protected boolean mSend;
    protected Fragment mFragment;
    protected int mKualifikasiSurveyId;

    public boolean isSend() {
        return mSend;
    }

    public void setSend(boolean send) {
        mSend = send;
    }

    public int getKualifikasiSurveyId() {
        return mKualifikasiSurveyId;
    }

    public void setKualifikasiSurveyId(int kualifikasiSurveyId) {
        mKualifikasiSurveyId = kualifikasiSurveyId;
    }

    public void setNamaForm(String namaForm) {
        mNamaForm = namaForm;
    }

    public void setFragment(Fragment fragment) {
        mFragment = fragment;
    }

    public String getNamaForm() {
        return mNamaForm;
    }

    public Fragment getFragment() {
        return mFragment;
    }
}
