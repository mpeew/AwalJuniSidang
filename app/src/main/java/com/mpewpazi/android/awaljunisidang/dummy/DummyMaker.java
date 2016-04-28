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
import com.mpewpazi.android.awaljunisidang.model.GalanganKapal;
import com.mpewpazi.android.awaljunisidang.model.KualifikasiSurvey;
import com.mpewpazi.android.awaljunisidang.model.PeriodeSurvey;
import com.mpewpazi.android.awaljunisidang.model.Perusahaan;
import com.mpewpazi.android.awaljunisidang.model.SurveyAssignSurveyor;
import com.mpewpazi.android.awaljunisidang.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.mpewpazi.android.awaljunisidang.database.DhSchema.*;

/**
 * Created by mpewpazi on 4/19/16.
 */
public class DummyMaker {
    private Context mContext;
    private int galpalSize=0;
    private int kompalSize=0;

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




        makeUser();
        makePeriodeSurvey();
        makePerusahaan();
        makeGalanganKapal();

        makeKualifikasiSurvey();
        makeSurveyAssignSurveyor();



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
        CursorWrapperGal cursor=query(PerusahaanIdentitasTable.NAME,PerusahaanIdentitasTable.Cols.ID_KUALIFIKASI_SURVEY+ "=?",
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

    public List<SingleForm> getGalpalForms(int kualifikasiSurveyId) {
        List<SingleForm> galpalForms=new ArrayList<>();
        galpalForms.add(getFormGalpal1(kualifikasiSurveyId));

        return galpalForms;
    }
    public List<SingleForm> getKompalForms(int kualifikasiSurveyId) {
        List<SingleForm> kompalForms=new ArrayList<>();
        //belum ada
        return kompalForms;
    }


    /*public GalanganKapal getGalanganKapal(int id){
        for (GalanganKapal galanganKapal:mGalanganKapals){
            if(galanganKapal.getGalanganKapalId()==id){
                return galanganKapal;
            }
        }
        return null;
    }*/

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
        makeGalpalForms(kualifikasiSurvey,1);
        makeKompalForms(kualifikasiSurvey,1);
        mKualifikasiSurveys.add(kualifikasiSurvey);

        KualifikasiSurvey kualifikasiSurvey1=new KualifikasiSurvey();
        kualifikasiSurvey1.setKualifikasiSurveyId(2);
        kualifikasiSurvey1.setPerusahaan(getPerusahaan(2));
        kualifikasiSurvey1.setPeriodeSurvey(getPeriodeSurvey(2014));
        kualifikasiSurvey1.setGalanganKapal(getGalanganKapal(1));
        makeGalpalForms(kualifikasiSurvey1,2);
        makeKompalForms(kualifikasiSurvey1,2);
        mKualifikasiSurveys.add(kualifikasiSurvey1);

        KualifikasiSurvey kualifikasiSurvey2=new KualifikasiSurvey();
        kualifikasiSurvey2.setKualifikasiSurveyId(3);
        kualifikasiSurvey2.setPerusahaan(getPerusahaan(3));
        kualifikasiSurvey2.setPeriodeSurvey(getPeriodeSurvey(2014));
        kualifikasiSurvey2.setGalanganKapal(getGalanganKapal(1));
        makeGalpalForms(kualifikasiSurvey2,3);
        makeKompalForms(kualifikasiSurvey2,3);
        mKualifikasiSurveys.add(kualifikasiSurvey2);

        KualifikasiSurvey kualifikasiSurvey3=new KualifikasiSurvey();
        kualifikasiSurvey3.setKualifikasiSurveyId(4);
        kualifikasiSurvey3.setPerusahaan(getPerusahaan(4));
        kualifikasiSurvey3.setPeriodeSurvey(getPeriodeSurvey(2014));
        kualifikasiSurvey3.setGalanganKapal(getGalanganKapal(1));
        makeGalpalForms(kualifikasiSurvey3,4);
        makeKompalForms(kualifikasiSurvey3,4);
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









    private void makeGalpalForms(KualifikasiSurvey kualifikasiSurvey,int id){
        FormGalpal1 formGalpal1=new FormGalpal1();
        formGalpal1.setIdentitasPerusahaanId(id);
        FormGalpal3 formGalpal3=new FormGalpal3();
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
        galpalSize=mGalpalForms.size();



    }

    private void makeKompalForms(KualifikasiSurvey kualifikasiSurvey,int id){
        FormGalpal4 formGalpal4=new FormGalpal4();
        formGalpal4.setTinjauanWilayahMaritimId(id);
        mKompalForms.add(formGalpal4);
        for(int y=kompalSize;y<mKompalForms.size();y++){
            mKompalForms.get(y).setKualifikasiSurvey(kualifikasiSurvey);
        }
        kompalSize=mKompalForms.size();

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
        values.put(SurveyAssignSurveyorTable.Cols.ASSIGN_DATE, surveyAssignSurveyor.getAssignDate().getTime());
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
        contentValues.put(PerusahaanIdentitasTable.Cols.ID_PERUSAHAAN_IDENTITAS, formGalpal1.getIdentitasPerusahaanId());
        contentValues.put(PerusahaanIdentitasTable.Cols.ID_PERUSAHAAN, formGalpal1.getPerusahaanId());
        contentValues.put(PerusahaanIdentitasTable.Cols.ID_KUALIFIKASI_SURVEY, formGalpal1.getKualifikasiSurveyId());
        contentValues.put(PerusahaanIdentitasTable.Cols.STATUS_KEPEMILIKAN_USAHA, formGalpal1.getStatusKepemilikanUsaha());
        contentValues.put(PerusahaanIdentitasTable.Cols.TELEPON_PERUSAHAAN, formGalpal1.getNomorTelepon());
        contentValues.put(PerusahaanIdentitasTable.Cols.FAX_PERUSAHAAN, formGalpal1.getFax());
        contentValues.put(PerusahaanIdentitasTable.Cols.ALAMAT_PERUSAHAAN, formGalpal1.getAlamat());
        contentValues.put(PerusahaanIdentitasTable.Cols.KELURAHAN_PERUSAHAAN, formGalpal1.getKelurahan());
        contentValues.put(PerusahaanIdentitasTable.Cols.KECAMATAN_PERUSAHAAN, formGalpal1.getKecamatan());
        contentValues.put(PerusahaanIdentitasTable.Cols.ID_PROPINSI_PERUSAHAAN, formGalpal1.getPropinsi());
        contentValues.put(PerusahaanIdentitasTable.Cols.ID_KABUPATEN_PERUSAHAAN, formGalpal1.getKebupaten_kota());
        contentValues.put(PerusahaanIdentitasTable.Cols.KODE_POS_PERUSAHAAN, formGalpal1.getKodePos());
        contentValues.put(PerusahaanIdentitasTable.Cols.ANGGOTA_ASOSIASI, formGalpal1.getAnggotaAsosiasi());
        contentValues.put(PerusahaanIdentitasTable.Cols.KATEGORI_PERUSAHAAN, formGalpal1.getKategoriPerusahaan());
        contentValues.put(PerusahaanIdentitasTable.Cols.CP_NAMA, formGalpal1.getContactPerson());
        contentValues.put(PerusahaanIdentitasTable.Cols.CP_NO, formGalpal1.getNomorCp());
        contentValues.put(PerusahaanIdentitasTable.Cols.CP_JABATAN, formGalpal1.getJabatan());
        contentValues.put(PerusahaanIdentitasTable.Cols.CP_EMAIL, formGalpal1.getEmail());
        contentValues.put(PerusahaanIdentitasTable.Cols.WEBSITE, formGalpal1.getWebsite());


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
