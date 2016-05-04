package com.mpewpazi.android.awaljunisidang.dummy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.mpewpazi.android.awaljunisidang.Form.FormGalpal1;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal3;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal4;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal6;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal6List;
import com.mpewpazi.android.awaljunisidang.Form.SingleForm;
import com.mpewpazi.android.awaljunisidang.database.BaseDBHelper;
import com.mpewpazi.android.awaljunisidang.database.CursorWrapperGal;
import com.mpewpazi.android.awaljunisidang.database.DhSchema;
import com.mpewpazi.android.awaljunisidang.model.KualifikasiSurvey;
import com.mpewpazi.android.awaljunisidang.model.PeriodeSurvey;
import com.mpewpazi.android.awaljunisidang.model.Perusahaan;
import com.mpewpazi.android.awaljunisidang.model.SurveyAssignSurveyor;
import com.mpewpazi.android.awaljunisidang.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FG1PerusahaanIdentitasTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FG3GalanganKapalTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FG4TinjauanAreaTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FG6PeralatanKerjaLuarCraneTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.KualifikasiSurveyTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.PeriodeSurveyTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.PerusahaanTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.SurveyAssignSurveyorTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.UserTable;



/**
 * Created by mpewpazi on 4/19/16.
 */
public class DummyMaker {
    private Context mContext;

    private SQLiteDatabase mDatabase;

    private static DummyMaker sDummyMaker;



    public static DummyMaker get(Context context){
        if(sDummyMaker ==null){
            sDummyMaker =new DummyMaker(context);
        }
        return sDummyMaker;
    }

    private DummyMaker(Context context){
        mContext=context.getApplicationContext();
        mDatabase=new BaseDBHelper(mContext).getWritableDatabase();

        User user=new User();
        user.setUserId("mpewpazi");
        user.setFullName("Peri Nurpazri");
        user.setEmail("a");
        user.setAnswerSecretQuestion("a");
        user.setCodeId("a");
        user.setPassword("a");
        user.setSecurityCode("a");
        user.setType("a");
        user.setCompanyName(1);

        User user1=new User();
        user1.setUserId("perinurpazri");
        user1.setFullName("Mpew Nurpazri");
        user1.setEmail("a");
        user1.setAnswerSecretQuestion("a");
        user1.setCodeId("a");
        user1.setPassword("a");
        user1.setSecurityCode("a");
        user1.setType("a");
        user1.setCompanyName(1);
        user1.setCompanyName(1);
        addUser(user);
        addUser(user1);

        PeriodeSurvey periodeSurvey1=new PeriodeSurvey();
        periodeSurvey1.setPeriodeSurveyId(2014);
        periodeSurvey1.setTahunKualifikasi("2014");
        periodeSurvey1.setActivePeriode(1);
        addPeriodeSurvey(periodeSurvey1);

        Perusahaan perusahaan1=new Perusahaan();
        perusahaan1.setId(1);
        perusahaan1.setNamaPerusahaan("PT ABC");
        perusahaan1.setIndustri("Galangan Kapal");
        perusahaan1.setActive(1);

        Perusahaan perusahaan2=new Perusahaan();
        perusahaan2.setId(2);
        perusahaan2.setNamaPerusahaan("PT EFG");
        perusahaan2.setIndustri("Galangan Kapal");
        perusahaan2.setActive(1);

        Perusahaan perusahaan3=new Perusahaan();
        perusahaan3.setId(3);
        perusahaan3.setNamaPerusahaan("PT ASP");
        perusahaan3.setIndustri("Galangan Kapal");
        perusahaan3.setActive(1);

        Perusahaan perusahaan4=new Perusahaan();
        perusahaan4.setId(4);
        perusahaan4.setNamaPerusahaan("PT ASFP");
        perusahaan4.setIndustri("Galangan Kapal");
        perusahaan4.setActive(1);
        addPerusahaan(perusahaan1);
        addPerusahaan(perusahaan2);
        addPerusahaan(perusahaan3);
        addPerusahaan(perusahaan4);


        //take it into account -----------------------------------------------------


        KualifikasiSurvey kualifikasiSurvey=new KualifikasiSurvey();
        kualifikasiSurvey.setKualifikasiSurveyId(1);
        kualifikasiSurvey.setPerusahaanId(1);
        kualifikasiSurvey.setPeriodeSurveyId(2014);
        kualifikasiSurvey.setGalanganKapalId(1);
        addGalpalForms(1,kualifikasiSurvey.getKualifikasiSurveyId(),"4862bf0a-110b-11e6-a148-3e1d05defe78");
       // makeKompalForms(kualifikasiSurvey,1);

        KualifikasiSurvey kualifikasiSurvey1=new KualifikasiSurvey();
        kualifikasiSurvey1.setKualifikasiSurveyId(2);
        kualifikasiSurvey1.setPerusahaanId(2);
        kualifikasiSurvey1.setPeriodeSurveyId(2014);
        kualifikasiSurvey1.setGalanganKapalId(1);
        addGalpalForms(2,kualifikasiSurvey1.getKualifikasiSurveyId(),"4862c1c6-110b-11e6-a148-3e1d05defe78");
        //makeKompalForms(kualifikasiSurvey1,2);

        KualifikasiSurvey kualifikasiSurvey2=new KualifikasiSurvey();
        kualifikasiSurvey2.setKualifikasiSurveyId(3);
        kualifikasiSurvey2.setPerusahaanId(3);
        kualifikasiSurvey2.setPeriodeSurveyId(2014);
        kualifikasiSurvey2.setGalanganKapalId(1);
        addGalpalForms(3,kualifikasiSurvey2.getKualifikasiSurveyId(),"4862c3ec-110b-11e6-a148-3e1d05defe78");
        //makeKompalForms(kualifikasiSurvey2,3);

        KualifikasiSurvey kualifikasiSurvey3=new KualifikasiSurvey();
        kualifikasiSurvey3.setKualifikasiSurveyId(4);
        kualifikasiSurvey3.setPerusahaanId(4);
        kualifikasiSurvey3.setPeriodeSurveyId(2014);
        kualifikasiSurvey3.setGalanganKapalId(1);
        addGalpalForms(4,kualifikasiSurvey3.getKualifikasiSurveyId(),"4862c5b8-110b-11e6-a148-3e1d05defe78");
       // makeKompalForms(kualifikasiSurvey3,4);

        addKualifikasiSurvey(kualifikasiSurvey);
        addKualifikasiSurvey(kualifikasiSurvey1);
        addKualifikasiSurvey(kualifikasiSurvey2);
        addKualifikasiSurvey(kualifikasiSurvey3);

        SurveyAssignSurveyor surveyAssignSurveyor=new SurveyAssignSurveyor();
        surveyAssignSurveyor.setSurveyAssignSurveyorId(1);
        surveyAssignSurveyor.setUserId("mpewpazi");
        surveyAssignSurveyor.setKualifikasiSurveyId(1);

        SurveyAssignSurveyor surveyAssignSurveyor1=new SurveyAssignSurveyor();
        surveyAssignSurveyor1.setSurveyAssignSurveyorId(2);
        surveyAssignSurveyor1.setUserId("perinurpazri");
        surveyAssignSurveyor1.setKualifikasiSurveyId(2);

        SurveyAssignSurveyor surveyAssignSurveyor2=new SurveyAssignSurveyor();
        surveyAssignSurveyor2.setSurveyAssignSurveyorId(3);
        surveyAssignSurveyor2.setUserId("perinurpazri");
        surveyAssignSurveyor2.setKualifikasiSurveyId(3);

        SurveyAssignSurveyor surveyAssignSurveyor3=new SurveyAssignSurveyor();
        surveyAssignSurveyor3.setSurveyAssignSurveyorId(4);
        surveyAssignSurveyor3.setUserId("mpewpazi");
        surveyAssignSurveyor3.setKualifikasiSurveyId(4);
        addSurveyAssignSurveyor(surveyAssignSurveyor);
        addSurveyAssignSurveyor(surveyAssignSurveyor1);
        addSurveyAssignSurveyor(surveyAssignSurveyor2);
        addSurveyAssignSurveyor(surveyAssignSurveyor3);



    }

    public Perusahaan getPerusahaan(int idPerusahaan){
        CursorWrapperGal cursor=query(PerusahaanTable.NAME,PerusahaanTable.Cols.ID_PERUSAHAAN+ "=?",
                new String[] {String.valueOf(idPerusahaan)});
        try{
            if(cursor.getCount()==0){
                return null;
            }

            cursor.moveToFirst();
            return cursor.getPerusahaan();
        }finally {
            cursor.close();
        }
    }

    public PeriodeSurvey getPeriodeSurvey(int idPeriode){
        CursorWrapperGal cursor=query(PeriodeSurveyTable.NAME,PeriodeSurveyTable.Cols.ID_PERIODE+ "=?",
                new String[] {String.valueOf(idPeriode)});
        try{
            if(cursor.getCount()==0){
                return null;
            }

            cursor.moveToFirst();
            return cursor.getPeriodeSurvey();
        }finally {
            cursor.close();
        }
    }

    public User getUser(String userId){
        CursorWrapperGal cursor=query(UserTable.NAME,UserTable.Cols.USERID+ "=?",
                new String[] {userId});
        try{
            if(cursor.getCount()==0){
                return null;
            }

            cursor.moveToFirst();
            return cursor.getUser();
        }finally {
            cursor.close();
        }
    }

    public List<User> getUsers(){
        List<User> users=new ArrayList<>();
        CursorWrapperGal cursor=query(UserTable.NAME,null,null);
        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                users.add(cursor.getUser());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        return users;
    }

    public SurveyAssignSurveyor getSurveyAssignSurveyor(int idSurveyAssign){
        CursorWrapperGal cursor=query(SurveyAssignSurveyorTable.NAME,SurveyAssignSurveyorTable.Cols.ID_SURVEY_ASSIGN_SURVEYOR+ "=?",
                new String[] {String.valueOf(idSurveyAssign)});
        try{
            if(cursor.getCount()==0){
                return null;
            }

            cursor.moveToFirst();
            return cursor.getSurveyAssignSurveyor();
        }finally {
            cursor.close();
        }
    }

    public List<SurveyAssignSurveyor> getSurveyAssignSurveyors(){
        List<SurveyAssignSurveyor> surveyAssignSurveyors=new ArrayList<>();
        CursorWrapperGal cursor=query(SurveyAssignSurveyorTable.NAME,null,null);
        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                surveyAssignSurveyors.add(cursor.getSurveyAssignSurveyor());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        return surveyAssignSurveyors;
    }

    //untuk get yang memiliki user id tertentu
    public List<SurveyAssignSurveyor> getSurveyAssignSurveyors(String userid){
        List<SurveyAssignSurveyor> surveyAssignSurveyors=new ArrayList<>();
        CursorWrapperGal cursor=query(SurveyAssignSurveyorTable.NAME,SurveyAssignSurveyorTable.Cols.USERID+ "=?",
                new String[] {String.valueOf(userid)});
        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                surveyAssignSurveyors.add(cursor.getSurveyAssignSurveyor());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        return surveyAssignSurveyors;
    }



    public KualifikasiSurvey getKualifikasiSurvey(int idKualifikasi){
        CursorWrapperGal cursor=query(KualifikasiSurveyTable.NAME,KualifikasiSurveyTable.Cols.ID_KUALIFIKASI_SURVEY+ "=?",
                new String[] {String.valueOf(idKualifikasi)});
        try{
            if(cursor.getCount()==0){
                return null;
            }

            cursor.moveToFirst();
            return cursor.getKualifikasiSurvey();
        }finally {
            cursor.close();
        }
    }

    public List<KualifikasiSurvey> getKualifikasiSurveys(){
        List<KualifikasiSurvey> kualifikasiSurveys=new ArrayList<>();
        CursorWrapperGal cursor=query(KualifikasiSurveyTable.NAME,null,null);
        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                kualifikasiSurveys.add(cursor.getKualifikasiSurvey());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        return kualifikasiSurveys;

    }

    //memunculkan kualifikasi survey yang hanya bersangkutan dengan userId
    public List<KualifikasiSurvey> getKualifikasiSurveys(String usernameId){
        List<KualifikasiSurvey> kualifikasiSurveys=new ArrayList<>();
        List<SurveyAssignSurveyor> surveyAssignSurveyors=getSurveyAssignSurveyors(usernameId);
        for(SurveyAssignSurveyor surveyAssignSurveyor:surveyAssignSurveyors){
            if(surveyAssignSurveyor.getUserId().equals(usernameId)){
                kualifikasiSurveys.add(getKualifikasiSurvey(surveyAssignSurveyor.
                        getKualifikasiSurveyId()));
            }
        }
        return kualifikasiSurveys;
    }

    public FormGalpal1 getFormGalpal1(int idKualifikasiSurvey){
        CursorWrapperGal cursor=query(FG1PerusahaanIdentitasTable.NAME,FG1PerusahaanIdentitasTable.Cols.ID_KUALIFIKASI_SURVEY+ "=?",
                new String[] {String.valueOf(idKualifikasiSurvey)});
        try{
            if(cursor.getCount()==0){
                return null;
            }

            cursor.moveToFirst();
            return cursor.getFormGalpal1();
        }finally {
            cursor.close();
        }
    }

    public FormGalpal3 getFormGalpal3(int idKualifikasiSurvey){
        CursorWrapperGal cursor=query(FG3GalanganKapalTable.NAME,FG3GalanganKapalTable.Cols.ID_KUALIFIKASI_SURVEY+ "=?",
                new String[] {String.valueOf(idKualifikasiSurvey)});
        try{
            if(cursor.getCount()==0){
                return null;

            }

            cursor.moveToFirst();
            return cursor.getFormGalpal3();
        }finally {
            cursor.close();
        }
    }

    public FormGalpal4 getFormGalpal4(int idKualifikasiSurvey){
        CursorWrapperGal cursor=query(FG4TinjauanAreaTable.NAME,FG4TinjauanAreaTable.Cols.ID_KUALIFIKASI_SURVEY+ "=?",
                new String[] {String.valueOf(idKualifikasiSurvey)});
        try{
            if(cursor.getCount()==0){
                return null;

            }

            cursor.moveToFirst();
            return cursor.getFormGalpal4();
        }finally {
            cursor.close();
        }
    }

    public FormGalpal6 getFormGalpal6(UUID idFormGalpal6){
        CursorWrapperGal cursor=query(FG6PeralatanKerjaLuarCraneTable.NAME,FG6PeralatanKerjaLuarCraneTable.Cols.ID_F1_PERALATAN_KERJA_LR_CRANE+ "=?",
                new String[] {idFormGalpal6.toString()});
        try{
            if(cursor.getCount()==0){
                return null;

            }

            cursor.moveToFirst();
            return cursor.getFormGalpal6();
        }finally {
            cursor.close();
        }
    }

    public List<FormGalpal6> getFormGalpal6s(){
        List<FormGalpal6> formGalpal6s=new ArrayList<>();
        CursorWrapperGal cursor=query(FG6PeralatanKerjaLuarCraneTable.NAME,null,null);
        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                formGalpal6s.add(cursor.getFormGalpal6());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        return formGalpal6s;
    }

    public List<FormGalpal6> getFormGalpal6s(int kualifikasisurveyid){
        List<FormGalpal6> formGalpal6s=getFormGalpal6s();
        List<FormGalpal6> formGalpal6s1=new ArrayList<>();
        for(FormGalpal6 formGalpal6:formGalpal6s){
            if(formGalpal6.getKualifikasiSurveyId()==kualifikasisurveyid){
                formGalpal6s1.add(formGalpal6);
            }
        }
        return formGalpal6s1;
    }



    public List<SingleForm> getGalpalForms(int kualifikasiSurveyId) {
        List<SingleForm> galpalForms=new ArrayList<>();
        galpalForms.add(getFormGalpal1(kualifikasiSurveyId));
        galpalForms.add(getFormGalpal3(kualifikasiSurveyId));
        galpalForms.add(getFormGalpal4(kualifikasiSurveyId));
        FormGalpal6List formGalpal6=new FormGalpal6List();
        galpalForms.add(formGalpal6);


        return galpalForms;
    }
    public List<SingleForm> getKompalForms(int kualifikasiSurveyId) {
        List<SingleForm> kompalForms=new ArrayList<>();
        //belum ada
        return kompalForms;
    }




    private void addSurveyAssignSurveyor(SurveyAssignSurveyor surveyAssignSurveyor) {
        ContentValues values=getSurveyAssignSurveyorContentValues(surveyAssignSurveyor);
        int idSurveyAssignSurveyor=surveyAssignSurveyor.getSurveyAssignSurveyorId();

        CursorWrapperGal cursor=query(SurveyAssignSurveyorTable.NAME,SurveyAssignSurveyorTable.Cols.ID_SURVEY_ASSIGN_SURVEYOR+ "=?",
                new String[] {String.valueOf(idSurveyAssignSurveyor)});
        try{
            if(cursor.getCount()==0){
                mDatabase.insert(SurveyAssignSurveyorTable.NAME,null,values);
            }else{
                mDatabase.update(SurveyAssignSurveyorTable.NAME,values,SurveyAssignSurveyorTable.Cols.ID_SURVEY_ASSIGN_SURVEYOR+" = ?",new String[]{String.valueOf(idSurveyAssignSurveyor)});
            }

        }finally {
            cursor.close();
        }
    }

    private void addKualifikasiSurvey(KualifikasiSurvey kualifikasiSurvey) {
        ContentValues values=getKualifikasiSurveyContentValues(kualifikasiSurvey);
        int idKualifikasiSurvey=kualifikasiSurvey.getKualifikasiSurveyId();

        CursorWrapperGal cursor=query(KualifikasiSurveyTable.NAME,KualifikasiSurveyTable.Cols.ID_KUALIFIKASI_SURVEY+ "=?",
                new String[] {String.valueOf(idKualifikasiSurvey)});
        try{
            if(cursor.getCount()==0){
                mDatabase.insert(KualifikasiSurveyTable.NAME,null,values);
            }else{
                mDatabase.update(KualifikasiSurveyTable.NAME,values,KualifikasiSurveyTable.Cols.ID_KUALIFIKASI_SURVEY+" = ?",new String[]{String.valueOf(idKualifikasiSurvey)});
            }

        }finally {
            cursor.close();
        }
    }

    private void addUser(User user){
        ContentValues values=getUserContentValues(user);
        String userId=user.getUserId();

        CursorWrapperGal cursor=query(UserTable.NAME,UserTable.Cols.USERID+ "=?",
                new String[] {userId});
        try{
            if(cursor.getCount()==0){
                mDatabase.insert(UserTable.NAME,null,values);
            }else{
                mDatabase.update(UserTable.NAME,values,UserTable.Cols.USERID+" = ?",new String[]{userId});
            }

        }finally {
            cursor.close();
        }
    }

    private void addPeriodeSurvey(PeriodeSurvey periodeSurvey){
        ContentValues values=getPeriodeSurveyContentValues(periodeSurvey);
        String idPeriodeSurvey=String.valueOf(periodeSurvey.getPeriodeSurveyId());

        CursorWrapperGal cursor=query(PeriodeSurveyTable.NAME,PeriodeSurveyTable.Cols.ID_PERIODE+ "=?",
                new String[] {idPeriodeSurvey});
        try{
            if(cursor.getCount()==0){
                mDatabase.insert(PeriodeSurveyTable.NAME,null,values);
            }else{
                mDatabase.update(PeriodeSurveyTable.NAME,values,PeriodeSurveyTable.Cols.ID_PERIODE+" = ?",new String[]{idPeriodeSurvey});
            }

        }finally {
            cursor.close();
        }

    }

    private void addPerusahaan(Perusahaan perusahaan){
        ContentValues values=getPerusahaanContentValues(perusahaan);
        String idPerusahaan=String.valueOf(perusahaan.getId());

        CursorWrapperGal cursor=query(PerusahaanTable.NAME,PerusahaanTable.Cols.ID_PERUSAHAAN+ "=?",
                new String[] {idPerusahaan});
        try{
            if(cursor.getCount()==0){
                mDatabase.insert(PerusahaanTable.NAME,null,values);
            }else{
                mDatabase.update(PerusahaanTable.NAME,values,PerusahaanTable.Cols.ID_PERUSAHAAN+" = ?",new String[]{idPerusahaan});
            }

        }finally {
            cursor.close();
        }
    }

    public void addFormGalpal1(FormGalpal1 formGalpal1){
        ContentValues values=getFormGalpal1ContentValues(formGalpal1);
        String formGalpal1Id=String.valueOf(formGalpal1.getIdentitasPerusahaanId());

        CursorWrapperGal cursor=query(FG1PerusahaanIdentitasTable.NAME,FG1PerusahaanIdentitasTable.Cols.ID_PERUSAHAAN_IDENTITAS+ "=?",
                new String[] {formGalpal1Id});
        try{
            if(cursor.getCount()==0){
                mDatabase.insert(FG1PerusahaanIdentitasTable.NAME,null,values);
            }else{
                mDatabase.update(FG1PerusahaanIdentitasTable.NAME,values,FG1PerusahaanIdentitasTable.Cols.ID_PERUSAHAAN_IDENTITAS+" = ?",new String[]{formGalpal1Id});
            }

        }finally {
            cursor.close();
        }
    }

    //sementara sebelum ada data dari server
    public void addFormGalpal1a(FormGalpal1 formGalpal1){
        ContentValues values=getFormGalpal1ContentValues(formGalpal1);
        String formGalpal1Id=String.valueOf(formGalpal1.getIdentitasPerusahaanId());

        CursorWrapperGal cursor=query(FG1PerusahaanIdentitasTable.NAME,FG1PerusahaanIdentitasTable.Cols.ID_PERUSAHAAN_IDENTITAS+ "=?",
                new String[] {formGalpal1Id});
        try{
            if(cursor.getCount()==0){
                mDatabase.insert(FG1PerusahaanIdentitasTable.NAME,null,values);
            }else{
                //mDatabase.update(FG1PerusahaanIdentitasTable.NAME,values,FG1PerusahaanIdentitasTable.Cols.ID_PERUSAHAAN_IDENTITAS+" = ?",new String[]{formGalpal1Id});
            }

        }finally {
            cursor.close();
        }
    }



    public void addFormGalpal3(FormGalpal3 formGalpal3){
        ContentValues values=getFormGalpal3ContentValues(formGalpal3);
        String formGalpal3Id=String.valueOf(formGalpal3.getIdentitasUmumGalanganId());

        CursorWrapperGal cursor=query(FG3GalanganKapalTable.NAME,FG3GalanganKapalTable.Cols.ID_GALANGAN_KAPAL+ "=?",
                new String[] {formGalpal3Id});
        try{
            if(cursor.getCount()==0){
                mDatabase.insert(FG3GalanganKapalTable.NAME,null,values);
            }else{

                mDatabase.update(FG3GalanganKapalTable.NAME,values,FG3GalanganKapalTable.Cols.ID_GALANGAN_KAPAL+" = ?",new String[]{formGalpal3Id});
            }

        }finally {
            cursor.close();
        }
    }

    private void addFormGalpal3a(FormGalpal3 formGalpal3){
        ContentValues values=getFormGalpal3ContentValues(formGalpal3);
        String formGalpal3Id=String.valueOf(formGalpal3.getIdentitasUmumGalanganId());

        CursorWrapperGal cursor=query(FG3GalanganKapalTable.NAME,FG3GalanganKapalTable.Cols.ID_GALANGAN_KAPAL+ "=?",
                new String[] {formGalpal3Id});
        try{
            if(cursor.getCount()==0){
                mDatabase.insert(FG3GalanganKapalTable.NAME,null,values);
            }else{
                //mDatabase.update(FG3GalanganKapalTable.NAME,values,FG3GalanganKapalTable.Cols.ID_GALANGAN_KAPAL+" = ?",new String[]{formGalpal3Id});
            }

        }finally {
            cursor.close();
        }
    }

    public void addFormGalpal4(FormGalpal4 formGalpal4){
        ContentValues values=getFormGalpal4ContentValues(formGalpal4);
        String formGalpal4Id=String.valueOf(formGalpal4.getTinjauanWilayahMaritimId());

        CursorWrapperGal cursor=query(FG4TinjauanAreaTable.NAME,FG4TinjauanAreaTable.Cols.ID_F1_TINJAUAN_AREA+ "=?",
                new String[] {formGalpal4Id});
        try{
            if(cursor.getCount()==0){
                mDatabase.insert(FG4TinjauanAreaTable.NAME,null,values);
            }else{
                mDatabase.update(FG4TinjauanAreaTable.NAME,values,FG4TinjauanAreaTable.Cols.ID_F1_TINJAUAN_AREA+" = ?",new String[]{formGalpal4Id});
            }

        }finally {
            cursor.close();
        }
    }

    private void addFormGalpal4a(FormGalpal4 formGalpal4){
        ContentValues values=getFormGalpal4ContentValues(formGalpal4);
        String formGalpal4Id=String.valueOf(formGalpal4.getTinjauanWilayahMaritimId());

        CursorWrapperGal cursor=query(FG4TinjauanAreaTable.NAME,FG4TinjauanAreaTable.Cols.ID_F1_TINJAUAN_AREA+ "=?",
                new String[] {formGalpal4Id});
        try{
            if(cursor.getCount()==0){
                mDatabase.insert(FG4TinjauanAreaTable.NAME,null,values);
            }else{
                //mDatabase.update(FG4TinjauanAreaTable.NAME,values,FG4TinjauanAreaTable.Cols.ID_F1_TINJAUAN_AREA+" = ?",new String[]{formGalpal4Id});
            }

        }finally {
            cursor.close();
        }
    }

    public void addFormGalpal6(FormGalpal6 formGalpal6){
        ContentValues values=getFormGalpal6ContentValues(formGalpal6);
        String formGalpal6Id=String.valueOf(formGalpal6.getIdPeralatanKerjaCrane());

        CursorWrapperGal cursor=query(FG6PeralatanKerjaLuarCraneTable.NAME,FG6PeralatanKerjaLuarCraneTable.Cols.ID_F1_PERALATAN_KERJA_LR_CRANE+ "=?",
                new String[] {formGalpal6Id});
        try{
            if(cursor.getCount()==0){
                mDatabase.insert(FG6PeralatanKerjaLuarCraneTable.NAME,null,values);
            }else{
                mDatabase.update(FG6PeralatanKerjaLuarCraneTable.NAME,values,FG6PeralatanKerjaLuarCraneTable.Cols.ID_F1_PERALATAN_KERJA_LR_CRANE+" = ?",new String[]{formGalpal6Id});
            }

        }finally {
            cursor.close();
        }
    }

    private void addFormGalpal6a(FormGalpal6 formGalpal6){
        ContentValues values=getFormGalpal6ContentValues(formGalpal6);
        String formGalpal6Id=String.valueOf(formGalpal6.getIdPeralatanKerjaCrane());

        CursorWrapperGal cursor=query(FG6PeralatanKerjaLuarCraneTable.NAME,FG6PeralatanKerjaLuarCraneTable.Cols.ID_F1_PERALATAN_KERJA_LR_CRANE+ "=?",
                new String[] {formGalpal6Id});
        try{
            if(cursor.getCount()<=0){
                mDatabase.insert(FG6PeralatanKerjaLuarCraneTable.NAME,null,values);
            }else{
                //mDatabase.update(FG6PeralatanKerjaLuarCraneTable.NAME,values,FG6PeralatanKerjaLuarCraneTable.Cols.ID_F1_PERALATAN_KERJA_LR_CRANE+" = ?",new String[]{formGalpal6Id});
            }

        }finally {
            cursor.close();
        }
    }

    private void addGalpalForms(int formGalpalId,int kualifikasiSurveyId, String id6){
        FormGalpal1 formGalpal1=new FormGalpal1();
        formGalpal1.setIdentitasPerusahaanId(formGalpalId);
        formGalpal1.setKualifikasiSurveyId(kualifikasiSurveyId);

        FormGalpal3 formGalpal3=new FormGalpal3();
        formGalpal3.setIdentitasUmumGalanganId(formGalpalId+100);
        formGalpal3.setKualifikasiSurveyId(kualifikasiSurveyId);

        FormGalpal4 formGalpal4=new FormGalpal4();
        formGalpal4.setTinjauanWilayahMaritimId(formGalpalId+1000);
        formGalpal4.setKualifikasiSurveyId(kualifikasiSurveyId);

        FormGalpal6 formGalpal6=new FormGalpal6(UUID.fromString(id6));
        formGalpal6.setKualifikasiSurveyId(kualifikasiSurveyId);
        formGalpal6.setJenisMesin("Inas Nisrina");
        formGalpal6.setTahunPembuatan(2004);

        addFormGalpal1a(formGalpal1);
        addFormGalpal3a(formGalpal3);
        addFormGalpal4a(formGalpal4);
        addFormGalpal6a(formGalpal6);


        /*FormGalpal3 formGalpal3=new FormGalpal3();
        formGalpal3.setIdentitasUmumGalanganId(id);
        FormGalpal6List formGalpal6List=new FormGalpal6List();

        FormGalpal6 formGalpal6=new FormGalpal6();
        formGalpal6.setId(1);
        formGalpal6.setJenisMesin("Mesin Gergaji");
        formGalpal6.setTahunPembuatan(1994);

        FormGalpal6 formGalpal61=new FormGalpal6();
        formGalpal61.setId(2);
        formGalpal61.setJenisMesin("Mesin Bla");
        formGalpal61.setTahunPembuatan(1994);

        formGalpal6List.addFormGalpal6(formGalpal61,kualifikasiSurvey);
        formGalpal6List.addFormGalpal6(formGalpal6,kualifikasiSurvey);
        mGalpalForms.add(formGalpal1);
        mGalpalForms.add(formGalpal3);
        mGalpalForms.add(formGalpal6List);
        for(int y=galpalSize;y<mGalpalForms.size();y++){
            mGalpalForms.get(y).setKualifikasiSurvey(kualifikasiSurvey);
        }
        galpalSize=mGalpalForms.size();*/


    }
    private void makeKompalForms(KualifikasiSurvey kualifikasiSurvey,int id){
        /*FormGalpal4 formGalpal4=new FormGalpal4();
        formGalpal4.setTinjauanWilayahMaritimId(id);
        mKompalForms.add(formGalpal4);
        for(int y=kompalSize;y<mKompalForms.size();y++){
            mKompalForms.get(y).setKualifikasiSurvey(kualifikasiSurvey);
        }
        kompalSize=mKompalForms.size();*/

    }






    private static ContentValues getUserContentValues(User user){
        ContentValues values=new ContentValues();
        values.put(UserTable.Cols.USERID, user.getUserId());
        values.put(UserTable.Cols.CODE_ID,user.getCodeId());
        values.put(UserTable.Cols.TYPE,user.getType());
        values.put(UserTable.Cols.FULL_NAME, user.getFullName());
        values.put(UserTable.Cols.COMPANY_NAME, user.getCompanyName());
        values.put(UserTable.Cols.EMAIL, user.getEmail());
        values.put(UserTable.Cols.PASSWORD, user.getPassword());
        values.put(UserTable.Cols.SECURITY_CODE, user.getSecurityCode());

        return values;
    }

    private static ContentValues getSurveyAssignSurveyorContentValues(SurveyAssignSurveyor surveyAssignSurveyor){
        ContentValues values=new ContentValues();
        values.put(SurveyAssignSurveyorTable.Cols.ID_SURVEY_ASSIGN_SURVEYOR, surveyAssignSurveyor.getKualifikasiSurveyId());
        values.put(SurveyAssignSurveyorTable.Cols.ID_KUALIFIKASI_SURVEY, surveyAssignSurveyor.getKualifikasiSurveyId());
        values.put(SurveyAssignSurveyorTable.Cols.USERID, surveyAssignSurveyor.getUserId());
//        values.put(SurveyAssignSurveyorTable.Cols.ASSIGN_DATE, surveyAssignSurveyor.getAssignDate().getTime());
        values.put(SurveyAssignSurveyorTable.Cols.ASSIGN_BY, surveyAssignSurveyor.getAssignByUserId());

        return values;
    }

    private static ContentValues getPeriodeSurveyContentValues(PeriodeSurvey periodeSurvey){
        ContentValues values=new ContentValues();
        values.put(PeriodeSurveyTable.Cols.ID_PERIODE, periodeSurvey.getPeriodeSurveyId());
        values.put(PeriodeSurveyTable.Cols.TAHUN_KUALIFIKASI, periodeSurvey.getTahunKualifikasi());
        values.put(PeriodeSurveyTable.Cols.IS_ACTIVE_PERIOD, periodeSurvey.isActivePeriode());
        values.put(PeriodeSurveyTable.Cols.IS_DONE, periodeSurvey.isDone());
        values.put(PeriodeSurveyTable.Cols.KETERANGAN, periodeSurvey.getKeterangan());


        return values;
    }

    private static ContentValues getPerusahaanContentValues(Perusahaan perusahaan){
        ContentValues values=new ContentValues();
        values.put(PerusahaanTable.Cols.ID_PERUSAHAAN, perusahaan.getId());
        values.put(PerusahaanTable.Cols.NAMA_PERUSAHAAN, perusahaan.getNamaPerusahaan());
        values.put(PerusahaanTable.Cols.INDUSTRI, perusahaan.getIndustri());
        values.put(PerusahaanTable.Cols.IS_ACTIV, perusahaan.isActive());

        return values;
    }

    private static ContentValues getKualifikasiSurveyContentValues(KualifikasiSurvey kualifikasiSurvey){
        ContentValues values=new ContentValues();
        values.put(KualifikasiSurveyTable.Cols.ID_KUALIFIKASI_SURVEY, kualifikasiSurvey.getKualifikasiSurveyId());
        values.put(KualifikasiSurveyTable.Cols.ID_PERUSAHAAN, kualifikasiSurvey.getPerusahaanId());
        values.put(KualifikasiSurveyTable.Cols.ID_PERIODE, kualifikasiSurvey.getPeriodeSurveyId());
        values.put(KualifikasiSurveyTable.Cols.ID_GALANGAN_KAPAL, kualifikasiSurvey.getGalanganKapalId());


        return values;
    }

    private static ContentValues getFormGalpal1ContentValues(FormGalpal1 formGalpal1){
        ContentValues contentValues=new ContentValues();
        contentValues.put(FG1PerusahaanIdentitasTable.Cols.ID_PERUSAHAAN_IDENTITAS, formGalpal1.getIdentitasPerusahaanId());
        contentValues.put(FG1PerusahaanIdentitasTable.Cols.ID_PERUSAHAAN, formGalpal1.getPerusahaanId());
        contentValues.put(FG1PerusahaanIdentitasTable.Cols.ID_KUALIFIKASI_SURVEY, formGalpal1.getKualifikasiSurveyId());
        contentValues.put(FG1PerusahaanIdentitasTable.Cols.STATUS_KEPEMILIKAN_USAHA, formGalpal1.getStatusKepemilikanUsaha());
        contentValues.put(FG1PerusahaanIdentitasTable.Cols.TELEPON_PERUSAHAAN, formGalpal1.getNomorTelepon());
        contentValues.put(FG1PerusahaanIdentitasTable.Cols.FAX_PERUSAHAAN, formGalpal1.getFax());
        contentValues.put(FG1PerusahaanIdentitasTable.Cols.ALAMAT_PERUSAHAAN, formGalpal1.getAlamat());
        contentValues.put(FG1PerusahaanIdentitasTable.Cols.KELURAHAN_PERUSAHAAN, formGalpal1.getKelurahan());
        contentValues.put(FG1PerusahaanIdentitasTable.Cols.KECAMATAN_PERUSAHAAN, formGalpal1.getKecamatan());
        contentValues.put(FG1PerusahaanIdentitasTable.Cols.ID_PROPINSI_PERUSAHAAN, formGalpal1.getPropinsi());
        contentValues.put(FG1PerusahaanIdentitasTable.Cols.ID_KABUPATEN_PERUSAHAAN, formGalpal1.getKebupaten_kota());
        contentValues.put(FG1PerusahaanIdentitasTable.Cols.KODE_POS_PERUSAHAAN, formGalpal1.getKodePos());
        contentValues.put(FG1PerusahaanIdentitasTable.Cols.ANGGOTA_ASOSIASI, formGalpal1.getAnggotaAsosiasi());
        contentValues.put(FG1PerusahaanIdentitasTable.Cols.KATEGORI_PERUSAHAAN, formGalpal1.getKategoriPerusahaan());
        contentValues.put(FG1PerusahaanIdentitasTable.Cols.CP_NAMA, formGalpal1.getContactPerson());
        contentValues.put(FG1PerusahaanIdentitasTable.Cols.CP_NO, formGalpal1.getNomorCp());
        contentValues.put(FG1PerusahaanIdentitasTable.Cols.CP_JABATAN, formGalpal1.getJabatan());
        contentValues.put(FG1PerusahaanIdentitasTable.Cols.CP_EMAIL, formGalpal1.getEmail());
        contentValues.put(FG1PerusahaanIdentitasTable.Cols.WEBSITE, formGalpal1.getWebsite());
        return contentValues;
    }

    private static ContentValues getFormGalpal3ContentValues(FormGalpal3 formGalpal3){
        ContentValues contentValues=new ContentValues();
        contentValues.put(FG3GalanganKapalTable.Cols.ID_GALANGAN_KAPAL, formGalpal3.getIdentitasUmumGalanganId());
        contentValues.put(FG3GalanganKapalTable.Cols.ID_PERUSAHAAN, formGalpal3.getPerusahaanId());
        contentValues.put(FG3GalanganKapalTable.Cols.ID_KUALIFIKASI_SURVEY, formGalpal3.getKualifikasiSurveyId());
        contentValues.put(FG3GalanganKapalTable.Cols.NAMA_GALANGAN, formGalpal3.getNamaGalangan());
        contentValues.put(FG3GalanganKapalTable.Cols.NOMOR_DOCK, formGalpal3.getNomorDock());
        contentValues.put(FG3GalanganKapalTable.Cols.TELEPON_GALANGAN, formGalpal3.getNomorTelepon());
        contentValues.put(FG3GalanganKapalTable.Cols.FAX_GALANGAN, formGalpal3.getFax());
        contentValues.put(FG3GalanganKapalTable.Cols.ALAMAT_GALANGAN, formGalpal3.getAlamat());
        contentValues.put(FG3GalanganKapalTable.Cols.KELURAHAN_GALANGAN, formGalpal3.getKelurahan());
        contentValues.put(FG3GalanganKapalTable.Cols.KECAMATAN_GALANGAN, formGalpal3.getKecamatan());
        contentValues.put(FG3GalanganKapalTable.Cols.ID_PROPINSI_GALANGAN,formGalpal3.getPropinsi());
        contentValues.put(FG3GalanganKapalTable.Cols.ID_KABUPATEN_GALANGAN, formGalpal3.getKebupaten_kota());
        contentValues.put(FG3GalanganKapalTable.Cols.KODE_POS_GALANGAN, formGalpal3.getKodePos());
        contentValues.put(FG3GalanganKapalTable.Cols.LATITUDE, formGalpal3.getLatitude());
        contentValues.put(FG3GalanganKapalTable.Cols.LONGITUDE, formGalpal3.getLongitude());
        contentValues.put(FG3GalanganKapalTable.Cols.KATEGORI_GALANGAN, formGalpal3.getKategoriGalangan());
        contentValues.put(FG3GalanganKapalTable.Cols.CP_NAMA, formGalpal3.getContactPerson());
        contentValues.put(FG3GalanganKapalTable.Cols.CP_NO, formGalpal3.getNomorCp());
        contentValues.put(FG3GalanganKapalTable.Cols.CP_JABATAN, formGalpal3.getJabatan());
        contentValues.put(FG3GalanganKapalTable.Cols.CP_EMAIL, formGalpal3.getEmail());
        return contentValues;
    }

    private static ContentValues getFormGalpal4ContentValues(FormGalpal4 formGalpal4){
        ContentValues contentValues=new ContentValues();
        contentValues.put(FG4TinjauanAreaTable.Cols.ID_F1_TINJAUAN_AREA, formGalpal4.getTinjauanWilayahMaritimId());
        contentValues.put(FG4TinjauanAreaTable.Cols.ID_KUALIFIKASI_SURVEY, formGalpal4.getKualifikasiSurveyId());
        contentValues.put(FG4TinjauanAreaTable.Cols.ID_MST_JARAK_KEDALAMAN, formGalpal4.getJarakKedalaman());
        contentValues.put(FG4TinjauanAreaTable.Cols.ID_MST_AIR_PELAYARAN, formGalpal4.getAirPelayaran());
        contentValues.put(FG4TinjauanAreaTable.Cols.ID_MST_PASANG_SURUT, formGalpal4.getPasangSurutPerairan());
        contentValues.put(FG4TinjauanAreaTable.Cols.ID_MST_ARUS, formGalpal4.getArus());
        contentValues.put(FG4TinjauanAreaTable.Cols.ID_MST_GELOMBANG, formGalpal4.getGelombang());
        contentValues.put(FG4TinjauanAreaTable.Cols.PANJANG_WATERFRONT, formGalpal4.getPanjangWaterfront());
        contentValues.put(FG4TinjauanAreaTable.Cols.LUAS_LAHAN, formGalpal4.getLuasLahan());
        contentValues.put(FG4TinjauanAreaTable.Cols.KETERSEDIAAN_LAHAN, formGalpal4.getKetersediaanLahan());
        contentValues.put(FG4TinjauanAreaTable.Cols.LAHAN_PRODUKTIF, formGalpal4.getLahanProduktif());
        contentValues.put(FG4TinjauanAreaTable.Cols.LAHAN_PEMUKIMAN, formGalpal4.getLahanPemukiman());
        contentValues.put(FG4TinjauanAreaTable.Cols.PASANG_SURUT, formGalpal4.getPasangSurutDaratan());
        contentValues.put(FG4TinjauanAreaTable.Cols.DAYA_DUKUNG, formGalpal4.getDayaDukung());
        contentValues.put(FG4TinjauanAreaTable.Cols.KELANDAIAAN, formGalpal4.getKelandaian());
        contentValues.put(FG4TinjauanAreaTable.Cols.DEKAT_JALAN, formGalpal4.getDekatJalan());
        contentValues.put(FG4TinjauanAreaTable.Cols.KOTA, formGalpal4.getKota());
        contentValues.put(FG4TinjauanAreaTable.Cols.INTERKONEKSI_ANGKUTAN, formGalpal4.getInterkoneksiAngkutan());
        contentValues.put(FG4TinjauanAreaTable.Cols.NILAI_EKONOMI, formGalpal4.getNilaiEkonomi());
        contentValues.put(FG4TinjauanAreaTable.Cols.PERKEMBANGAN_WILAYAH, formGalpal4.getPerkembanganWilayah());
        contentValues.put(FG4TinjauanAreaTable.Cols.RUTWR, formGalpal4.getRutrw());
        return contentValues;
    }

    private static ContentValues getFormGalpal6ContentValues(FormGalpal6 formGalpal6){
        ContentValues contentValues=new ContentValues();
        contentValues.put(DhSchema.FG6PeralatanKerjaLuarCraneTable.Cols.ID_F1_PERALATAN_KERJA_LR_CRANE ,formGalpal6.getIdPeralatanKerjaCrane().toString());
        contentValues.put(DhSchema.FG6PeralatanKerjaLuarCraneTable.Cols.ID_KUALIFIKASI_SURVEY ,formGalpal6.getKualifikasiSurveyId());
        contentValues.put(DhSchema.FG6PeralatanKerjaLuarCraneTable.Cols.JENIS_MESIN ,formGalpal6.getJenisMesin());
        contentValues.put(DhSchema.FG6PeralatanKerjaLuarCraneTable.Cols.TAHUN_PEMBUATAN ,formGalpal6.getTahunPembuatan());
        contentValues.put(DhSchema.FG6PeralatanKerjaLuarCraneTable.Cols.MERK ,formGalpal6.getMerek());
        contentValues.put(DhSchema.FG6PeralatanKerjaLuarCraneTable.Cols.KAPASAITAS_TERPASANG ,formGalpal6.getKapasitasTerpasang());
        contentValues.put(DhSchema.FG6PeralatanKerjaLuarCraneTable.Cols.KAPASITAS_TERPAKAI ,formGalpal6.getKapasitasTerpakai());
        contentValues.put(DhSchema.FG6PeralatanKerjaLuarCraneTable.Cols.DIMENSI ,formGalpal6.getDimensi());
        contentValues.put(DhSchema.FG6PeralatanKerjaLuarCraneTable.Cols.JUMLAH ,formGalpal6.getJumlah());
        contentValues.put(DhSchema.FG6PeralatanKerjaLuarCraneTable.Cols.KONDISI ,formGalpal6.getKondisi());
        contentValues.put(DhSchema.FG6PeralatanKerjaLuarCraneTable.Cols.LOKASI ,formGalpal6.getLokasi());
        contentValues.put(DhSchema.FG6PeralatanKerjaLuarCraneTable.Cols.STATUS ,formGalpal6.getStatus());
        contentValues.put(DhSchema.FG6PeralatanKerjaLuarCraneTable.Cols.SATUAN_KAPASITAS_TERPAKAI ,formGalpal6.getSatuanKapasitasTerpakai());
        contentValues.put(DhSchema.FG6PeralatanKerjaLuarCraneTable.Cols.SATUAN_KAPASITAS_TERPASANG ,formGalpal6.getSatuanKapastiasTerpasang());
        return contentValues;
    }


    private CursorWrapperGal query(String tableName, String whereClause, String[] whereArgs){

        Cursor cursor=mDatabase.query(
                tableName,
                null, // select all the column
                whereClause,
                whereArgs,
                null, //group by
                null, //having
                null//order by
        );

        return new CursorWrapperGal(cursor);
    }


}
