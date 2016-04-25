package com.mpewpazi.android.awaljunisidang.Form;

import android.support.v4.app.Fragment;

import com.mpewpazi.android.awaljunisidang.Fragment.ListFormGalpal6Fragment;
import com.mpewpazi.android.awaljunisidang.model.KualifikasiSurvey;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mpewpazi on 4/22/16.
 */
public class FormGalpal6List extends SingleForm {
    List<FormGalpal6> mFormGalpal6s=new ArrayList<>();

    @Override
    public void setKualifikasiSurvey(KualifikasiSurvey kualifikasiSurvey) {
        for(int y=0;y<mFormGalpal6s.size();y++){
            mFormGalpal6s.get(y).setKualifikasiSurvey(kualifikasiSurvey);
        }
        mKualifikasiSurvey=kualifikasiSurvey;
    }

    @Override
    public KualifikasiSurvey getKualifikasiSurvey() {
        return super.getKualifikasiSurvey();
    }

    @Override
    public String getNamaForm() {
        return "Peralatan Ruang Kerja Luar Ruang Cranes";
    }

    @Override
    public Fragment getFragment() {
        return new ListFormGalpal6Fragment();
    }

    public List<FormGalpal6> getFormGalpal6s() {
        return mFormGalpal6s;
    }

    public void addFormGalpal6(FormGalpal6 formGalpal6) {
        mFormGalpal6s.add(formGalpal6);
    }
}
