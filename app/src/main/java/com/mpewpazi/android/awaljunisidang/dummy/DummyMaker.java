package com.mpewpazi.android.awaljunisidang.dummy;

import android.content.Context;

import com.mpewpazi.android.awaljunisidang.Form.FormGalpal1;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal3;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal4;
import com.mpewpazi.android.awaljunisidang.Form.SingleForm;
import com.mpewpazi.android.awaljunisidang.model.GalanganKapal;
import com.mpewpazi.android.awaljunisidang.model.KualifikasiSurvey;
import com.mpewpazi.android.awaljunisidang.model.PeriodeSurvey;
import com.mpewpazi.android.awaljunisidang.model.Perusahaan;
import com.mpewpazi.android.awaljunisidang.model.SurveyAssignSurveyor;
import com.mpewpazi.android.awaljunisidang.model.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mpewpazi on 4/19/16.
 */
public class DummyMaker {
    private Context mContext;

    private static DummyMaker sDummyMaker;

    private List<KualifikasiSurvey> mKualifikasiSurveys;
    private List<User> mUsers;
    private List<PeriodeSurvey> mPeriodeSurveys;
    private List<Perusahaan> mPerusahaans;
    private List<GalanganKapal> mGalanganKapals;
    private List<SurveyAssignSurveyor> mSurveyAssignSurveyors;

    public static List<SingleForm> mGalpalForms;
    public static List<SingleForm> mKompalForms;

    public static DummyMaker get(Context context){
        if(sDummyMaker ==null){
            sDummyMaker =new DummyMaker(context);
        }
        return sDummyMaker;
    }

    private DummyMaker(Context context){
        mContext=context.getApplicationContext();

        makeGalpalForms();
        makeKompalForms();

        makeUser();
        makePeriodeSurvey();
        makePerusahaan();
        makeGalanganKapal();

        makeKualifikasiSurvey();
        makeSurveyAssignSurveyor();



    }

    private void makeSurveyAssignSurveyor() {
        mSurveyAssignSurveyors=new ArrayList<>();
        SurveyAssignSurveyor surveyAssignSurveyor=new SurveyAssignSurveyor();
        surveyAssignSurveyor.setSurveyAssignSurveyorId(1);
        surveyAssignSurveyor.setUser(getUser("mpewpazi"));
        surveyAssignSurveyor.setKualifikasiSurvey(getKualifikasiSurvey(1));
        mSurveyAssignSurveyors.add(surveyAssignSurveyor);

        SurveyAssignSurveyor surveyAssignSurveyor1=new SurveyAssignSurveyor();
        surveyAssignSurveyor1.setSurveyAssignSurveyorId(2);
        surveyAssignSurveyor1.setUser(getUser("perinurpazri"));
        surveyAssignSurveyor1.setKualifikasiSurvey(getKualifikasiSurvey(2));
        mSurveyAssignSurveyors.add(surveyAssignSurveyor1);

        SurveyAssignSurveyor surveyAssignSurveyor2=new SurveyAssignSurveyor();
        surveyAssignSurveyor2.setSurveyAssignSurveyorId(3);
        surveyAssignSurveyor2.setUser(getUser("perinurpazri"));
        surveyAssignSurveyor2.setKualifikasiSurvey(getKualifikasiSurvey(3));
        mSurveyAssignSurveyors.add(surveyAssignSurveyor2);

        SurveyAssignSurveyor surveyAssignSurveyor3=new SurveyAssignSurveyor();
        surveyAssignSurveyor3.setSurveyAssignSurveyorId(4);
        surveyAssignSurveyor3.setUser(getUser("mpewpazi"));
        surveyAssignSurveyor3.setKualifikasiSurvey(getKualifikasiSurvey(4));
        mSurveyAssignSurveyors.add(surveyAssignSurveyor3);
    }

    private void makeKualifikasiSurvey() {
        mKualifikasiSurveys=new ArrayList<>();
        KualifikasiSurvey kualifikasiSurvey=new KualifikasiSurvey();
        kualifikasiSurvey.setKualifikasiSurveyId(1);
        kualifikasiSurvey.setPerusahaan(getPerusahaan(1));
        kualifikasiSurvey.setPeriodeSurvey(getPeriodeSurvey(2014));
        kualifikasiSurvey.setGalanganKapal(getGalanganKapal(1));
        setKualifikasiSurveyForms(kualifikasiSurvey);
        mKualifikasiSurveys.add(kualifikasiSurvey);

        KualifikasiSurvey kualifikasiSurvey1=new KualifikasiSurvey();
        kualifikasiSurvey1.setKualifikasiSurveyId(2);
        kualifikasiSurvey1.setPerusahaan(getPerusahaan(2));
        kualifikasiSurvey1.setPeriodeSurvey(getPeriodeSurvey(2014));
        kualifikasiSurvey1.setGalanganKapal(getGalanganKapal(1));
        setKualifikasiSurveyForms(kualifikasiSurvey1);
        mKualifikasiSurveys.add(kualifikasiSurvey1);

        KualifikasiSurvey kualifikasiSurvey2=new KualifikasiSurvey();
        kualifikasiSurvey2.setKualifikasiSurveyId(3);
        kualifikasiSurvey2.setPerusahaan(getPerusahaan(3));
        kualifikasiSurvey2.setPeriodeSurvey(getPeriodeSurvey(2014));
        kualifikasiSurvey2.setGalanganKapal(getGalanganKapal(1));
        setKualifikasiSurveyForms(kualifikasiSurvey2);
        mKualifikasiSurveys.add(kualifikasiSurvey2);

        KualifikasiSurvey kualifikasiSurvey3=new KualifikasiSurvey();
        kualifikasiSurvey3.setKualifikasiSurveyId(4);
        kualifikasiSurvey3.setPerusahaan(getPerusahaan(4));
        kualifikasiSurvey3.setPeriodeSurvey(getPeriodeSurvey(2014));
        kualifikasiSurvey3.setGalanganKapal(getGalanganKapal(1));
        setKualifikasiSurveyForms(kualifikasiSurvey3);
        mKualifikasiSurveys.add(kualifikasiSurvey3);

    }


    private void makeUser(){
        mUsers=new ArrayList<>();
        User user=new User();
        user.setUserId("mpewpazi");
        user.setFullName("Peri Nurpazri");
        mUsers.add(user);

        User user1=new User();
        user1.setUserId("perinurpazri");
        user1.setFullName("Mpew Nurpazri");
        mUsers.add(user1);
    }

    private void makePeriodeSurvey(){
        mPeriodeSurveys=new ArrayList<>();
        PeriodeSurvey periodeSurvey1=new PeriodeSurvey();
        periodeSurvey1.setPeriodeSurveyId(2014);
        periodeSurvey1.setTahunKualifikasi("2014");
        periodeSurvey1.setActivePeriode(1);
        mPeriodeSurveys.add(periodeSurvey1);
    }

    private void makePerusahaan(){
        mPerusahaans=new ArrayList<>();
        Perusahaan perusahaan1=new Perusahaan();
        perusahaan1.setId(1);
        perusahaan1.setNamaPerusahaan("PT ABC");
        perusahaan1.setIndustri("Galangan Kapal");
        perusahaan1.setActive(1);
        mPerusahaans.add(perusahaan1);

        Perusahaan perusahaan2=new Perusahaan();
        perusahaan2.setId(2);
        perusahaan2.setNamaPerusahaan("PT EFG");
        perusahaan2.setIndustri("Galangan Kapal");
        perusahaan2.setActive(1);
        mPerusahaans.add(perusahaan2);

        Perusahaan perusahaan3=new Perusahaan();
        perusahaan3.setId(3);
        perusahaan3.setNamaPerusahaan("PT ASP");
        perusahaan3.setIndustri("Galangan Kapal");
        perusahaan3.setActive(1);
        mPerusahaans.add(perusahaan3);

        Perusahaan perusahaan4=new Perusahaan();
        perusahaan4.setId(4);
        perusahaan4.setNamaPerusahaan("PT ASFP");
        perusahaan4.setIndustri("Galangan Kapal");
        perusahaan4.setActive(1);
        mPerusahaans.add(perusahaan4);
    }

    private void makeGalanganKapal(){
        mGalanganKapals=new ArrayList<>();
        GalanganKapal galanganKapal1=new GalanganKapal();
        galanganKapal1.setGalanganKapalId(1);
        galanganKapal1.setNamaGalangan("aman Sejahtera");
        mGalanganKapals.add(galanganKapal1);

    }

    public Perusahaan getPerusahaan(int id){
        for(Perusahaan perusahaan:mPerusahaans){
            if(perusahaan.getId()==id){
                return perusahaan;
            }
        }

        return null;
    }

    public PeriodeSurvey getPeriodeSurvey(int id){
        for(PeriodeSurvey periodeSurvey:mPeriodeSurveys){
            if(periodeSurvey.getPeriodeSurveyId()==id){
                return periodeSurvey;
            }
        }

        return null;
    }

    public User getUser(String id){
        for(User user:mUsers){
            if(user.getUserId().equals(id)){
                return user;
            }
        }
        return null;
    }

    public GalanganKapal getGalanganKapal(int id){
        for (GalanganKapal galanganKapal:mGalanganKapals){
            if(galanganKapal.getGalanganKapalId()==id){
                return galanganKapal;
            }
        }
        return null;
    }

    public KualifikasiSurvey getKualifikasiSurvey(int id){
        for(KualifikasiSurvey kualifikasiSurvey:mKualifikasiSurveys){
            if(kualifikasiSurvey.getKualifikasiSurveyId()==id){
                return kualifikasiSurvey;
            }
        }
        return null;
    }

    public List<KualifikasiSurvey> getKualifikasiSurveys(String usernameId){
        List<KualifikasiSurvey> kualifikasiSurveys=new ArrayList<>();
        for(SurveyAssignSurveyor surveyAssignSurveyor:mSurveyAssignSurveyors){
            if(surveyAssignSurveyor.getUser().getUserId().equals(usernameId)){
                kualifikasiSurveys.add(surveyAssignSurveyor.getKualifikasiSurvey());
            }
        }
        return kualifikasiSurveys;
    }

    public List<SurveyAssignSurveyor> getSurveyAssignSurveyors() {
        return mSurveyAssignSurveyors;
    }



    private void makeGalpalForms(){
        mGalpalForms=new ArrayList<>();
        FormGalpal1 formGalpal1=new FormGalpal1();
        FormGalpal3 formGalpal3=new FormGalpal3();
        mGalpalForms.add(formGalpal1);
        mGalpalForms.add(formGalpal3);
    }

    private void makeKompalForms(){
        mKompalForms=new ArrayList<>();
        FormGalpal4 formGalpal4=new FormGalpal4();
        mKompalForms.add(formGalpal4);
    }

    //untuk mempersingkat doang setting setiap kualifikasi survey formnya
    private void setKualifikasiSurveyForms(KualifikasiSurvey kualifikasiSurvey){
        for(SingleForm singleForm:mGalpalForms){
            singleForm.setKualifikasiSurvey(kualifikasiSurvey);
        }
        for(SingleForm singleForm:mKompalForms){
            singleForm.setKualifikasiSurvey(kualifikasiSurvey);
        }
    }

    public List<SingleForm> getGalpalForms(int kualifikasiSurveyId) {
        List<SingleForm> galpalForms=new ArrayList<>();
        for(SingleForm singleForm:mGalpalForms){
            if(singleForm.getKualifikasiSurvey().getKualifikasiSurveyId()==kualifikasiSurveyId){
                galpalForms.add(singleForm);
            }
        }
        return galpalForms;
    }

    public List<SingleForm> getKompalForms(int kualifikasiSurveyId) {
        List<SingleForm> kompalForms=new ArrayList<>();
        for(SingleForm singleForm:mKompalForms){
            if(singleForm.getKualifikasiSurvey().getKualifikasiSurveyId()==kualifikasiSurveyId){
                kompalForms.add(singleForm);
            }
        }
        return kompalForms;
    }
}
