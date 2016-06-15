package com.mpewpazi.android.awaljunisidang.formModel;

import com.mpewpazi.android.awaljunisidang.fragment.SingleFragment;

/**
 * Created by mpewpazi on 3/31/16.
 */
public abstract class SingleForm {
    protected String mNamaForm;
    protected boolean mSend;
    protected SingleFragment mFragment;
    protected int mKualifikasiSurveyId;
    protected int mFormServerId;
    protected String note;
    protected String mModifyDate;

    public String getModifyDate() {
        return mModifyDate;
    }

    public void setModifyDate(String modifyDate) {
        mModifyDate = modifyDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getFormServerId() {
        return mFormServerId;
    }

    public void setFormServerId(int formServerId) {
        mFormServerId = formServerId;
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
    public abstract String getKodeAsync();



}
