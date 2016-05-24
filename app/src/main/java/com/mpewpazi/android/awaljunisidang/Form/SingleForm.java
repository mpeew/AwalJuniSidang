package com.mpewpazi.android.awaljunisidang.Form;

import com.mpewpazi.android.awaljunisidang.Fragment.SingleFragment;

/**
 * Created by mpewpazi on 3/31/16.
 */
public abstract class SingleForm {
    protected String mNamaForm;
    protected boolean mSend;
    protected SingleFragment mFragment;
    protected int mKualifikasiSurveyId;




    public int getKualifikasiSurveyId() {
        return mKualifikasiSurveyId;
    }

    public void setKualifikasiSurveyId(int kualifikasiSurveyId) {
        mKualifikasiSurveyId = kualifikasiSurveyId;
    }

    public void setNamaForm(String namaForm) {
        mNamaForm = namaForm;
    }

    public void setFragment(SingleFragment fragment) {
        mFragment = fragment;
    }

    public String getNamaForm() {
        return mNamaForm;
    }

    public SingleFragment getFragment() {
        return mFragment;
    }

    public abstract int getKodeForm();



}
