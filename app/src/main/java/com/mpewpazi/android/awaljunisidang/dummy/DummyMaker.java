package com.mpewpazi.android.awaljunisidang.dummy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import com.mpewpazi.android.awaljunisidang.Form.FormGalpal1;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal10;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal11;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal3;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal4;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal6;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal7;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal8;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal9;
import com.mpewpazi.android.awaljunisidang.Form.FormKompal3a;
import com.mpewpazi.android.awaljunisidang.Form.FormKompal3b;
import com.mpewpazi.android.awaljunisidang.Form.FormKompal3c;
import com.mpewpazi.android.awaljunisidang.Form.FormKompal3d;
import com.mpewpazi.android.awaljunisidang.Form.SingleForm;
import com.mpewpazi.android.awaljunisidang.MenuF1;
import com.mpewpazi.android.awaljunisidang.MenuF2;
import com.mpewpazi.android.awaljunisidang.database.BaseDBHelper;
import com.mpewpazi.android.awaljunisidang.database.CursorWrapperGal;
import com.mpewpazi.android.awaljunisidang.masterData.MstAirPelayaran;
import com.mpewpazi.android.awaljunisidang.masterData.MstArus;
import com.mpewpazi.android.awaljunisidang.masterData.MstGelombang;
import com.mpewpazi.android.awaljunisidang.masterData.MstJarakKedalaman;
import com.mpewpazi.android.awaljunisidang.masterData.MstJenisProduksi;
import com.mpewpazi.android.awaljunisidang.masterData.MstKabupaten;
import com.mpewpazi.android.awaljunisidang.masterData.MstPasangSurut;
import com.mpewpazi.android.awaljunisidang.masterData.MstPropinsi;
import com.mpewpazi.android.awaljunisidang.masterData.MstSatuan;
import com.mpewpazi.android.awaljunisidang.model.KualifikasiSurvey;
import com.mpewpazi.android.awaljunisidang.model.MenuCheckingGalpal;
import com.mpewpazi.android.awaljunisidang.model.MenuCheckingKompal;
import com.mpewpazi.android.awaljunisidang.model.PeriodeSurvey;
import com.mpewpazi.android.awaljunisidang.model.Perusahaan;
import com.mpewpazi.android.awaljunisidang.model.SingleMenuChecking;
import com.mpewpazi.android.awaljunisidang.model.SurveyAssignSurveyor;
import com.mpewpazi.android.awaljunisidang.model.User;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FG10PeralatanKerjaProduksiElektrikalMekanikal;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FG11PeralatanKerjaProduksiPengecatan;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FG1PerusahaanIdentitasTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FG3GalanganKapalTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FG4TinjauanAreaTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FG6PeralatanKerjaLuarCraneTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FG7PeralatanKerjaLuarTugboatTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FG8PeralatanKerjaProduksiMesinTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FG9PeralatanKerjaProduksiKontruksi;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FK3aJenisKapasitasProduksiTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FK3bJumlahProduksiTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FK3cSistemBerproduksiTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FK3dStandarMutuTableTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.KualifikasiSurveyTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.MenuCheckingGalpalTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.MenuCheckingKompalTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.MenuF1Table;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.MenuF2Table;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.MstAirPelayaranTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.MstArusTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.MstGelombangTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.MstJarakKedalamanTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.MstJenisProduksiTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.MstKabupatenTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.MstPasangSurutTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.MstPropinsiTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.MstSatuanTable;
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

    public List<MstPropinsi> getMstPropinsis(){
        List<MstPropinsi> mstPropinsis =new ArrayList<>();
        CursorWrapperGal cursor=query(MstPropinsiTable.NAME,null,null);
        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                mstPropinsis.add(cursor.getPropinsi());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        return mstPropinsis;
    }

    public List<MstKabupaten> getMstKabupatens(int idPropinsi){
        List<MstKabupaten> mstKabupatens =new ArrayList<>();
        CursorWrapperGal cursor=querya(MstKabupatenTable.NAME,MstKabupatenTable.Cols.ID_PROPINSI+ "=?",
                new String[] {String.valueOf(idPropinsi)},MstKabupatenTable.Cols.NAMA);
        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                mstKabupatens.add(cursor.getKabupaten());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        return mstKabupatens;
    }

    public List<MstAirPelayaran> getMstAirPelayarans(){
        List<MstAirPelayaran> mstAirPelayarans =new ArrayList<>();
        CursorWrapperGal cursor=query(MstAirPelayaranTable.NAME,null,null);
        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                mstAirPelayarans.add(cursor.getAirPelayaran());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        return mstAirPelayarans;
    }

    public List<MstArus> getMstAruss(){
        List<MstArus> mstAruss =new ArrayList<>();
        CursorWrapperGal cursor=query(MstArusTable.NAME,null,null);
        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                mstAruss.add(cursor.getArus());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        return mstAruss;
    }

    public List<MstGelombang> getMstGelombangs(){
        List<MstGelombang> mstGelombangs =new ArrayList<>();
        CursorWrapperGal cursor=query(MstGelombangTable.NAME,null,null);
        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                mstGelombangs.add(cursor.getGelombang());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        return mstGelombangs;
    }

    public List<MstJarakKedalaman> getMstJarakKedalamans(){
        List<MstJarakKedalaman> mstJarakKedalamans =new ArrayList<>();
        CursorWrapperGal cursor=query(MstJarakKedalamanTable.NAME,null,null);
        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                mstJarakKedalamans.add(cursor.getJarakKedalaman());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        return mstJarakKedalamans;
    }

    public List<MstJenisProduksi> getMstJenisProduksis(){
        List<MstJenisProduksi> mstJenisProduksis =new ArrayList<>();
        CursorWrapperGal cursor=query(MstJenisProduksiTable.NAME,null,null);
        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                mstJenisProduksis.add(cursor.getJenisProduksi());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        return mstJenisProduksis;
    }

    public List<MstPasangSurut> getMstPasangSuruts(){
        List<MstPasangSurut> mstPasangSuruts =new ArrayList<>();
        CursorWrapperGal cursor=query(MstPasangSurutTable.NAME,null,null);
        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                mstPasangSuruts.add(cursor.getPasangSurut());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        return mstPasangSuruts;
    }

    public List<MstSatuan> getMstSatuans(){
        List<MstSatuan> mstSatuans =new ArrayList<>();
        CursorWrapperGal cursor=query(MstSatuanTable.NAME,null,null);
        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                mstSatuans.add(cursor.getSatuan());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        return mstSatuans;
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

    public List<FormGalpal1> getFormGalpal1s(){
        List<FormGalpal1> formGalpal1s=new ArrayList<>();
        CursorWrapperGal cursor=query(FG1PerusahaanIdentitasTable.NAME,null,null);
        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                formGalpal1s.add(cursor.getFormGalpal1());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        return formGalpal1s;
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

    public List<FormGalpal3> getFormGalpal3s(){
        List<FormGalpal3> form=new ArrayList<>();
        CursorWrapperGal cursor=query(FG3GalanganKapalTable.NAME,null,null);
        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                form.add(cursor.getFormGalpal3());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        return form;
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

    public List<FormGalpal4> getFormGalpal4s(){
        List<FormGalpal4> form =new ArrayList<>();
        CursorWrapperGal cursor=query(FG4TinjauanAreaTable.NAME,null,null);
        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                form.add(cursor.getFormGalpal4());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        return form;
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
        List<FormGalpal6> form =new ArrayList<>();
        CursorWrapperGal cursor=query(FG6PeralatanKerjaLuarCraneTable.NAME,null,null);
        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                form.add(cursor.getFormGalpal6());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        return form;
    }

    public FormGalpal7 getFormGalpal7(UUID idFormGalpal7){
        CursorWrapperGal cursor=query(FG7PeralatanKerjaLuarTugboatTable.NAME,FG7PeralatanKerjaLuarTugboatTable.Cols.ID_F1_PERALATAN_KERJA_LR_TUG+ "=?",
                new String[] {idFormGalpal7.toString()});
        try{
            if(cursor.getCount()==0){
                return null;
            }
            cursor.moveToFirst();
            return cursor.getFormGalpal7();
        }finally {
            cursor.close();
        }
    }

    public List<FormGalpal7> getFormGalpal7s(){
        List<FormGalpal7> form =new ArrayList<>();
        CursorWrapperGal cursor=query(FG7PeralatanKerjaLuarTugboatTable.NAME,null,null);
        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                form.add(cursor.getFormGalpal7());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        return form;
    }

    public FormGalpal8 getFormGalpal8(UUID idFormGalpal8){
        CursorWrapperGal cursor=query(FG8PeralatanKerjaProduksiMesinTable.NAME,FG8PeralatanKerjaProduksiMesinTable.Cols.ID_F1_PERALATAN_KERJA_PROD_MESIN+ "=?",
                new String[] {idFormGalpal8.toString()});
        try{
            if(cursor.getCount()==0){
                return null;

            }

            cursor.moveToFirst();
            return cursor.getFormGalpal8();
        }finally {
            cursor.close();
        }
    }

    public List<FormGalpal8> getFormGalpal8s(){
        List<FormGalpal8> form =new ArrayList<>();
        CursorWrapperGal cursor=query(FG8PeralatanKerjaProduksiMesinTable.NAME,null,null);
        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                form.add(cursor.getFormGalpal8());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        return form;
    }

    public FormGalpal9 getFormGalpal9(UUID idFormGalpal9){
        CursorWrapperGal cursor=query(FG9PeralatanKerjaProduksiKontruksi.NAME,FG9PeralatanKerjaProduksiKontruksi.Cols.ID_F1_PERALATAN_KERJA_PRODUKSI_KONTRUKSI+ "=?",
                new String[] {idFormGalpal9.toString()});
        try{
            if(cursor.getCount()==0){
                return null;

            }

            cursor.moveToFirst();
            return cursor.getFormGalpal9();
        }finally {
            cursor.close();
        }
    }

    public List<FormGalpal9> getFormGalpal9s(){
        List<FormGalpal9> form =new ArrayList<>();
        CursorWrapperGal cursor=query(FG9PeralatanKerjaProduksiKontruksi.NAME,null,null);
        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                form.add(cursor.getFormGalpal9());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        return form;
    }

    public FormGalpal10 getFormGalpal10(UUID idFormGalpal10){
        CursorWrapperGal cursor=query(FG10PeralatanKerjaProduksiElektrikalMekanikal.NAME,FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.ID_F1_PERALATAN_KERJA_PRODUKSI_ELMEK+ "=?",
                new String[] {idFormGalpal10.toString()});
        try{
            if(cursor.getCount()==0){
                return null;

            }

            cursor.moveToFirst();
            return cursor.getFormGalpal10();
        }finally {
            cursor.close();
        }
    }

    public List<FormGalpal10> getFormGalpal10s(){
        List<FormGalpal10> form =new ArrayList<>();
        CursorWrapperGal cursor=query(FG10PeralatanKerjaProduksiElektrikalMekanikal.NAME,null,null);
        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                form.add(cursor.getFormGalpal10());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        return form;
    }

    public FormGalpal11 getFormGalpal11(UUID idFormGalpal11){
        CursorWrapperGal cursor=query(FG11PeralatanKerjaProduksiPengecatan.NAME,FG11PeralatanKerjaProduksiPengecatan.Cols.ID_F1_PERALATAN_KERJA_PRODUKSI_CAT+ "=?",
                new String[] {idFormGalpal11.toString()});
        try{
            if(cursor.getCount()==0){
                return null;

            }

            cursor.moveToFirst();
            return cursor.getFormGalpal11();
        }finally {
            cursor.close();
        }
    }

    public List<FormGalpal11> getFormGalpal11s(){
        List<FormGalpal11> form =new ArrayList<>();
        CursorWrapperGal cursor=query(FG11PeralatanKerjaProduksiPengecatan.NAME,null,null);
        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                form.add(cursor.getFormGalpal11());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        return form;
    }

    public FormKompal3a getFormKompal3a(UUID idFormKompal3a){
        CursorWrapperGal cursor=query(FK3aJenisKapasitasProduksiTable.NAME,FK3aJenisKapasitasProduksiTable.Cols.ID_F2_JENIS_KAPASITAS_PRODUKSI+ "=?",
                new String[] {idFormKompal3a.toString()});
        try{
            if(cursor.getCount()==0){
                return null;

            }

            cursor.moveToFirst();
            return cursor.getFormKompal3a();
        }finally {
            cursor.close();
        }
    }

    public List<FormKompal3a> getFormKompal3as(){
        List<FormKompal3a> form =new ArrayList<>();
        CursorWrapperGal cursor=query(FK3aJenisKapasitasProduksiTable.NAME,null,null);
        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                form.add(cursor.getFormKompal3a());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        return form;
    }

    public FormKompal3b getFormKompal3b(UUID idFormKompal3b){
        CursorWrapperGal cursor=query(FK3bJumlahProduksiTable.NAME,FK3bJumlahProduksiTable.Cols.ID_F2_JUMLAH_PRODUKSI+ "=?",
                new String[] {idFormKompal3b.toString()});
        try{
            if(cursor.getCount()==0){
                return null;

            }

            cursor.moveToFirst();
            return cursor.getFormKompal3b();
        }finally {
            cursor.close();
        }
    }

    public List<FormKompal3b> getFormKompal3bs(){
        List<FormKompal3b> form =new ArrayList<>();
        CursorWrapperGal cursor=query(FK3bJumlahProduksiTable.NAME,null,null);
        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                form.add(cursor.getFormKompal3b());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        return form;
    }

    public FormKompal3c getFormKompal3c(UUID idFormKompal3c){
        CursorWrapperGal cursor=query(FK3cSistemBerproduksiTable.NAME,FK3cSistemBerproduksiTable.Cols.ID_F2_SISTEM_BERPRODUKSI+ "=?",
                new String[] {idFormKompal3c.toString()});
        try{
            if(cursor.getCount()==0){
                return null;
            }
            cursor.moveToFirst();
            return cursor.getFormKompal3c();
        }finally {
            cursor.close();
        }
    }

    public List<FormKompal3c> getFormKompal3cs(){
        List<FormKompal3c> form =new ArrayList<>();
        CursorWrapperGal cursor=query(FK3cSistemBerproduksiTable.NAME,null,null);
        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                form.add(cursor.getFormKompal3c());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        return form;
    }

    public FormKompal3d getFormKompal3d(UUID idFormKompal3d){
        CursorWrapperGal cursor=query(FK3dStandarMutuTableTable.NAME,FK3dStandarMutuTableTable.Cols.ID_F2_STANDAR_MUTU+ "=?",
                new String[] {idFormKompal3d.toString()});
        try{
            if(cursor.getCount()==0){
                return null;

            }

            cursor.moveToFirst();
            return cursor.getFormKompal3d();
        }finally {
            cursor.close();
        }
    }

    public List<FormKompal3d> getFormKompal3ds(){
        List<FormKompal3d> form =new ArrayList<>();
        CursorWrapperGal cursor=query(FK3dStandarMutuTableTable.NAME,null,null);
        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                form.add(cursor.getFormKompal3d());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        return form;
    }

    public MenuCheckingGalpal getMenuCheckingGalpal(int idKualifikasiSurvey,int idMenu){
        List<SingleMenuChecking> menuCheckingGalpals=getMenuCheckingGalpals(idKualifikasiSurvey);

        for(SingleMenuChecking menuCheckingGalpal:menuCheckingGalpals){
            if(menuCheckingGalpal.getIdMenu()==idMenu){
                return (MenuCheckingGalpal) menuCheckingGalpal;
            }
        }
        return null;
    }

    public MenuCheckingKompal getMenuCheckingKompal(int idKualifikasiSurvey,int idMenu){
        List<SingleMenuChecking> menuCheckingKompals=getMenuCheckingKompals(idKualifikasiSurvey);

        for(SingleMenuChecking menuCheckingKompal:menuCheckingKompals){
            if(menuCheckingKompal.getIdMenu()==idMenu){
                return (MenuCheckingKompal) menuCheckingKompal;
            }
        }
        return null;
    }

    public List<SingleMenuChecking> getMenuCheckingGalpals(int idKualifikasiSurvey){
        List<SingleMenuChecking> menuCheckingGalpals=new ArrayList<>();
        CursorWrapperGal cursor=querya(MenuCheckingGalpalTable.NAME,MenuCheckingGalpalTable.Cols.ID_KUALIFIKASI_SURVEY+"=?"
                ,new String[] {String.valueOf(idKualifikasiSurvey)},MenuCheckingGalpalTable.Cols.ID_MENU_F1);
        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                menuCheckingGalpals.add(cursor.getMenuCheckingGalpal());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        return menuCheckingGalpals;
    }

    public List<SingleMenuChecking> getMenuCheckingKompals(int idKualifikasiSurvey){
        List<SingleMenuChecking> menuCheckingKompals=new ArrayList<>();
        CursorWrapperGal cursor=querya(MenuCheckingKompalTable.NAME,MenuCheckingKompalTable.Cols.ID_KUALIFIKASI_SURVEY+"=?"
                ,new String[] {String.valueOf(idKualifikasiSurvey)},MenuCheckingKompalTable.Cols.ID_MENU_F2);
        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                menuCheckingKompals.add(cursor.getMenuCheckingKompal());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        return menuCheckingKompals;
    }

    public List<MenuCheckingGalpal> getMenuCheckingGalpals(){
        List<MenuCheckingGalpal> menuCheckingGalpals=new ArrayList<>();
        CursorWrapperGal cursor=querya(MenuCheckingGalpalTable.NAME,null,null,null);
        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                menuCheckingGalpals.add(cursor.getMenuCheckingGalpal());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        return menuCheckingGalpals;
    }

    public List<MenuCheckingKompal> getMenuCheckingKompals(){
        List<MenuCheckingKompal> menuCheckingKompals=new ArrayList<>();
        CursorWrapperGal cursor=querya(MenuCheckingKompalTable.NAME,null,null,null);
        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                menuCheckingKompals.add(cursor.getMenuCheckingKompal());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        return menuCheckingKompals;
    }

    //form2 galpal 6 yang memiliki kualifikasi survey id tertentu
    public List<FormGalpal6> getFormGalpal6s(int idKualifikasiSurvey){
        List<FormGalpal6> formGalpal6s=new ArrayList<>();
        CursorWrapperGal cursor=query(FG6PeralatanKerjaLuarCraneTable.NAME,FG6PeralatanKerjaLuarCraneTable.Cols.ID_KUALIFIKASI_SURVEY+"=?"
                ,new String[] {String.valueOf(idKualifikasiSurvey)});
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

    public List<FormGalpal7> getFormGalpal7s(int idKualifikasiSurvey){
        List<FormGalpal7> formGalpal7s=new ArrayList<>();
        CursorWrapperGal cursor=query(FG7PeralatanKerjaLuarTugboatTable.NAME,FG7PeralatanKerjaLuarTugboatTable.Cols.ID_KUALIFIKASI_SURVEY+"=?"
                ,new String[] {String.valueOf(idKualifikasiSurvey)});
        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                formGalpal7s.add(cursor.getFormGalpal7());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        return formGalpal7s;
    }

    public List<FormGalpal8> getFormGalpal8s(int idKualifikasiSurvey){
        List<FormGalpal8> formGalpal8s=new ArrayList<>();
        CursorWrapperGal cursor=query(FG8PeralatanKerjaProduksiMesinTable.NAME,FG8PeralatanKerjaProduksiMesinTable.Cols.ID_KUALIFIKASI_SURVEY+"=?"
                ,new String[] {String.valueOf(idKualifikasiSurvey)});
        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                formGalpal8s.add(cursor.getFormGalpal8());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        return formGalpal8s;
    }

    public List<FormGalpal9> getFormGalpal9s(int idKualifikasiSurvey){
        List<FormGalpal9> formGalpal9s=new ArrayList<>();
        CursorWrapperGal cursor=query(FG9PeralatanKerjaProduksiKontruksi.NAME,FG9PeralatanKerjaProduksiKontruksi.Cols.ID_KUALIFIKASI_SURVEY+"=?"
                ,new String[] {String.valueOf(idKualifikasiSurvey)});
        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                formGalpal9s.add(cursor.getFormGalpal9());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        return formGalpal9s;
    }

    public List<FormGalpal10> getFormGalpal10s(int idKualifikasiSurvey){
        List<FormGalpal10> formGalpal10s=new ArrayList<>();
        CursorWrapperGal cursor=query(FG10PeralatanKerjaProduksiElektrikalMekanikal.NAME,FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.ID_KUALIFIKASI_SURVEY+"=?"
                ,new String[] {String.valueOf(idKualifikasiSurvey)});
        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                formGalpal10s.add(cursor.getFormGalpal10());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        return formGalpal10s;
    }

    public List<FormGalpal11> getFormGalpal11s(int idKualifikasiSurvey){
        List<FormGalpal11> formGalpal11s=new ArrayList<>();
        CursorWrapperGal cursor=query(FG11PeralatanKerjaProduksiPengecatan.NAME,FG11PeralatanKerjaProduksiPengecatan.Cols.ID_KUALIFIKASI_SURVEY+"=?"
                ,new String[] {String.valueOf(idKualifikasiSurvey)});
        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                formGalpal11s.add(cursor.getFormGalpal11());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        return formGalpal11s;
    }

    //form2 kompal 3a yang memiliki kualifikasi survey id tertentu
    public List<FormKompal3a> getFormKompal3as(int idKualifikasiSurvey){
        List<FormKompal3a> formKompal3as=new ArrayList<>();
        CursorWrapperGal cursor=query(FK3aJenisKapasitasProduksiTable.NAME,FK3aJenisKapasitasProduksiTable.Cols.ID_KUALIFIKASI_SURVEY+"=?"
                ,new String[] {String.valueOf(idKualifikasiSurvey)});
        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                formKompal3as.add(cursor.getFormKompal3a());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        return formKompal3as;
    }

    //form2 kompal 3b yang memiliki kualifikasi survey id tertentu
    public List<FormKompal3b> getFormKompal3bs(int idKualifikasiSurvey){
        List<FormKompal3b> formKompal3bs=new ArrayList<>();
        CursorWrapperGal cursor=query(FK3bJumlahProduksiTable.NAME,FK3aJenisKapasitasProduksiTable.Cols.ID_KUALIFIKASI_SURVEY+"=?"
                ,new String[] {String.valueOf(idKualifikasiSurvey)});
        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                formKompal3bs.add(cursor.getFormKompal3b());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        return formKompal3bs;
    }

    //form2 kompal 3c yang memiliki kualifikasi survey id tertentu
    public List<FormKompal3c> getFormKompal3cs(int idKualifikasiSurvey){
        List<FormKompal3c> formKompal3cs=new ArrayList<>();
        CursorWrapperGal cursor=query(FK3cSistemBerproduksiTable.NAME,FK3aJenisKapasitasProduksiTable.Cols.ID_KUALIFIKASI_SURVEY+"=?"
                ,new String[] {String.valueOf(idKualifikasiSurvey)});
        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                formKompal3cs.add(cursor.getFormKompal3c());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        return formKompal3cs;
    }

    //form2 kompal 3d yang memiliki kualifikasi survey id tertentu
    public List<FormKompal3d> getFormKompal3ds(int idKualifikasiSurvey){
        List<FormKompal3d> formKompal3ds=new ArrayList<>();
        CursorWrapperGal cursor=query(FK3dStandarMutuTableTable.NAME,FK3aJenisKapasitasProduksiTable.Cols.ID_KUALIFIKASI_SURVEY+"=?"
                ,new String[] {String.valueOf(idKualifikasiSurvey)});
        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                formKompal3ds.add(cursor.getFormKompal3d());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        return formKompal3ds;
    }

    public List<SingleForm> getGalpalForms() {
        List<SingleForm> galpalForms=new ArrayList<>();
        galpalForms.add(new FormGalpal1());
        galpalForms.add(new FormGalpal3());
        galpalForms.add(new FormGalpal4());
        galpalForms.add(new FormGalpal6());
        galpalForms.add(new FormGalpal7());
        galpalForms.add(new FormGalpal8());
        galpalForms.add(new FormGalpal9());
        galpalForms.add(new FormGalpal10());
        galpalForms.add(new FormGalpal11());
        return galpalForms;
    }

    public List<SingleForm> getKompalForms() {
        List<SingleForm> kompalForms=new ArrayList<>();
        kompalForms.add(new FormKompal3a());
        kompalForms.add(new FormKompal3b());
        kompalForms.add(new FormKompal3c());
        kompalForms.add(new FormKompal3d());
        return kompalForms;
    }

    public void addMstPropinsi(MstPropinsi mstPropinsi){
        ContentValues values=getContentValues(mstPropinsi);
        int idPropinsi= mstPropinsi.getId();

        CursorWrapperGal cursor=query(MstPropinsiTable.NAME,MstPropinsiTable.Cols.ID_PROPINSI+ "=?",
                new String[] {String.valueOf(idPropinsi)});
        try{
            if(cursor.getCount()==0){
                mDatabase.insert(MstPropinsiTable.NAME,null,values);
            }else{
                mDatabase.update(MstPropinsiTable.NAME,values,MstPropinsiTable.Cols.ID_PROPINSI+" = ?",new String[]{String.valueOf(idPropinsi)});
            }

        }finally {
            cursor.close();
        }
    }

    public void addMstKabupaten(MstKabupaten mstKabupaten){
        ContentValues values=getContentValues(mstKabupaten);
        int idKabupaten= mstKabupaten.getId();

        CursorWrapperGal cursor=query(MstKabupatenTable.NAME,MstKabupatenTable.Cols.ID+ "=?",
                new String[] {String.valueOf(idKabupaten)});
        try{
            if(cursor.getCount()==0){
                mDatabase.insert(MstKabupatenTable.NAME,null,values);
            }else{
                mDatabase.update(MstKabupatenTable.NAME,values,MstKabupatenTable.Cols.ID+" = ?",new String[]{String.valueOf(idKabupaten)});
            }

        }finally {
            cursor.close();
        }
    }

    public void addMstAirPelayaran(MstAirPelayaran mstAirPelayaran){
        ContentValues values=getContentValues(mstAirPelayaran);
        int idAirPelayaran= mstAirPelayaran.getIdMstAirPelayaran();

        CursorWrapperGal cursor=query(MstAirPelayaranTable.NAME,MstAirPelayaranTable.Cols.ID_MST_AIR_PELAYARAN+ "=?",
                new String[] {String.valueOf(idAirPelayaran)});
        try{
            if(cursor.getCount()==0){
                mDatabase.insert(MstAirPelayaranTable.NAME,null,values);
            }else{
                mDatabase.update(MstAirPelayaranTable.NAME,values,MstAirPelayaranTable.Cols.ID_MST_AIR_PELAYARAN+" = ?",new String[]{String.valueOf(idAirPelayaran)});
            }
        }finally {
            cursor.close();
        }
    }

    public void addMstArus(MstArus mstArus){
        ContentValues values=getContentValues(mstArus);
        int idArus= mstArus.getIdMstArus();

        CursorWrapperGal cursor=query(MstArusTable.NAME,MstArusTable.Cols.ID_MST_ARUS+ "=?",
                new String[] {String.valueOf(idArus)});
        try{
            if(cursor.getCount()==0){
                mDatabase.insert(MstArusTable.NAME,null,values);
            }else{
                mDatabase.update(MstArusTable.NAME,values,MstArusTable.Cols.ID_MST_ARUS+" = ?",new String[]{String.valueOf(idArus)});
            }
        }finally {
            cursor.close();
        }
    }

    public void addMstGelombang(MstGelombang mstGelombang){
        ContentValues values=getContentValues(mstGelombang);
        int idGelombang= mstGelombang.getIdMstGelombang();

        CursorWrapperGal cursor=query(MstGelombangTable.NAME,MstGelombangTable.Cols.ID_MST_GELOMBANG+ "=?",
                new String[] {String.valueOf(idGelombang)});
        try{
            if(cursor.getCount()==0){
                mDatabase.insert(MstGelombangTable.NAME,null,values);
            }else{
                mDatabase.update(MstGelombangTable.NAME,values,MstGelombangTable.Cols.ID_MST_GELOMBANG+" = ?",new String[]{String.valueOf(idGelombang)});
            }
        }finally {
            cursor.close();
        }
    }

    public void addMstJarakKedalaman(MstJarakKedalaman mstJarakKedalaman){
        ContentValues values=getContentValues(mstJarakKedalaman);
        int idJarakKedalaman= mstJarakKedalaman.getIdMstJarakKedalaman();

        CursorWrapperGal cursor=query(MstJarakKedalamanTable.NAME,MstJarakKedalamanTable.Cols.ID_MST_JARAK_KEDALAMAN+ "=?",
                new String[] {String.valueOf(idJarakKedalaman)});
        try{
            if(cursor.getCount()==0){
                mDatabase.insert(MstJarakKedalamanTable.NAME,null,values);
            }else{
                mDatabase.update(MstJarakKedalamanTable.NAME,values,MstJarakKedalamanTable.Cols.ID_MST_JARAK_KEDALAMAN+" = ?",new String[]{String.valueOf(idJarakKedalaman)});
            }
        }finally {
            cursor.close();
        }
    }

    public void addMstJenisProduksi(MstJenisProduksi mstJenisProduksi){
        ContentValues values=getContentValues(mstJenisProduksi);
        int idJenisProduksi= mstJenisProduksi.getIdMstJenisProduksi();

        CursorWrapperGal cursor=query(MstJenisProduksiTable.NAME,MstJenisProduksiTable.Cols.ID_MST_JENIS_PRODUKSI+ "=?",
                new String[] {String.valueOf(idJenisProduksi)});
        try{
            if(cursor.getCount()==0){
                mDatabase.insert(MstJenisProduksiTable.NAME,null,values);
            }else{
                mDatabase.update(MstJenisProduksiTable.NAME,values,MstJenisProduksiTable.Cols.ID_MST_JENIS_PRODUKSI+" = ?",new String[]{String.valueOf(idJenisProduksi)});
            }
        }finally {
            cursor.close();
        }
    }

    public void addPasangSurut(MstPasangSurut mstPasangSurut){
        ContentValues values=getContentValues(mstPasangSurut);
        int idPasangSurut= mstPasangSurut.getIdMstPasangSurut();

        CursorWrapperGal cursor=query(MstPasangSurutTable.NAME,MstPasangSurutTable.Cols.ID_MST_PASANG_SURUT+ "=?",
                new String[] {String.valueOf(idPasangSurut)});
        try{
            if(cursor.getCount()==0){
                mDatabase.insert(MstPasangSurutTable.NAME,null,values);
            }else{
                mDatabase.update(MstPasangSurutTable.NAME,values,MstPasangSurutTable.Cols.ID_MST_PASANG_SURUT+" = ?",new String[]{String.valueOf(idPasangSurut)});
            }
        }finally {
            cursor.close();
        }
    }

    public void addSatuan(MstSatuan mstSatuan){
        ContentValues values=getContentValues(mstSatuan);
        int idSatuan= mstSatuan.getIdMstSatuan();

        CursorWrapperGal cursor=query(MstSatuanTable.NAME,MstSatuanTable.Cols.ID_MST_SATUAN+ "=?",
                new String[] {String.valueOf(idSatuan)});
        try{
            if(cursor.getCount()==0){
                mDatabase.insert(MstSatuanTable.NAME,null,values);
            }else{
                mDatabase.update(MstSatuanTable.NAME,values,MstSatuanTable.Cols.ID_MST_SATUAN+" = ?",new String[]{String.valueOf(idSatuan)});
            }
        }finally {
            cursor.close();
        }
    }



    private void addSurveyAssignSurveyor(SurveyAssignSurveyor surveyAssignSurveyor) {
        ContentValues values=getContentValues(surveyAssignSurveyor);
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

    public void addKualifikasiSurvey(KualifikasiSurvey kualifikasiSurvey) {
        ContentValues values=getContentValues(kualifikasiSurvey);
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
        ContentValues values=getContentValues(user);
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
        ContentValues values=getContentValues(periodeSurvey);
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

    public void addPerusahaan(Perusahaan perusahaan){
        ContentValues values=getContentValues(perusahaan);
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

    public void addMenuCheckingGalpal(MenuCheckingGalpal menuCheckingGalpal){
        ContentValues values=getContentValues(menuCheckingGalpal);
        String idMenuCheckingGalpal=String.valueOf(menuCheckingGalpal.getIdMenuCheckingGalpal());

        CursorWrapperGal cursor=query(MenuCheckingGalpalTable.NAME,MenuCheckingGalpalTable.Cols.ID_MENU_F1_ENTRY_CHECKING+ "=?",
                new String[] {idMenuCheckingGalpal});
        try{
            if(cursor.getCount()==0){
                mDatabase.insert(MenuCheckingGalpalTable.NAME,null,values);
            }else{
                mDatabase.update(MenuCheckingGalpalTable.NAME,values,MenuCheckingGalpalTable.Cols.ID_MENU_F1_ENTRY_CHECKING+" = ?",new String[]{idMenuCheckingGalpal});
            }

        }finally {
            cursor.close();
        }
    }



    public void addMenuCheckingKompal(MenuCheckingKompal menuCheckingKompal){
        ContentValues values=getContentValues(menuCheckingKompal);
        String idMenuCheckingKompal=String.valueOf(menuCheckingKompal.getIdMenuCheckingKompal());

        CursorWrapperGal cursor=query(MenuCheckingKompalTable.NAME,MenuCheckingKompalTable.Cols.ID_MENU_F2_ENTRY_CHECKING+ "=?",
                new String[] {idMenuCheckingKompal});
        try{
            if(cursor.getCount()==0){
                mDatabase.insert(MenuCheckingKompalTable.NAME,null,values);
            }else{
                mDatabase.update(MenuCheckingKompalTable.NAME,values,MenuCheckingKompalTable.Cols.ID_MENU_F2_ENTRY_CHECKING+" = ?",new String[]{idMenuCheckingKompal});
            }

        }finally {
            cursor.close();
        }
    }



    public void addMenuF1(MenuF1 menuF1){
        ContentValues values=getContentValues(menuF1);
        String menuF1Id=String.valueOf(menuF1.getIdMenuF1());

        CursorWrapperGal cursor=query(MenuF1Table.NAME,MenuF1Table.Cols.ID_MENU_F1+ "=?",
                new String[] {menuF1Id});
        try{
            if(cursor.getCount()==0){
                mDatabase.insert(MenuF1Table.NAME,null,values);
            }else{
                mDatabase.update(MenuF1Table.NAME,values,MenuF1Table.Cols.ID_MENU_F1+" = ?",new String[]{menuF1Id});
            }

        }finally {
            cursor.close();
        }
    }

    public void addMenuF2(MenuF2 menuF2){
        ContentValues values=getContentValues(menuF2);
        String menuF2Id=String.valueOf(menuF2.getIdMenuF2());

        CursorWrapperGal cursor=query(MenuF2Table.NAME,MenuF2Table.Cols.ID_MENU_F2+ "=?",
                new String[] {menuF2Id});
        try{
            if(cursor.getCount()==0){
                mDatabase.insert(MenuF2Table.NAME,null,values);
            }else{
                mDatabase.update(MenuF2Table.NAME,values,MenuF2Table.Cols.ID_MENU_F2+" = ?",new String[]{menuF2Id});
            }

        }finally {
            cursor.close();
        }
    }

    public void addFormGalpal1(FormGalpal1 formGalpal1){
        ContentValues values=getContentValues(formGalpal1);
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



    public void addFormGalpal3(FormGalpal3 formGalpal3){
        ContentValues values=getContentValues(formGalpal3);
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



    public void addFormGalpal4(FormGalpal4 formGalpal4){
        ContentValues values=getContentValues(formGalpal4);
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


    public void addFormGalpal6(FormGalpal6 formGalpal6){
        ContentValues values=getContentValues(formGalpal6);
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

    public void addFormGalpal6Server(FormGalpal6 formGalpal6){
        ContentValues values=getContentValues(formGalpal6);
        String formGalpal6IdServer=String.valueOf(formGalpal6.getFormServerId());

        CursorWrapperGal cursor=query(FG6PeralatanKerjaLuarCraneTable.NAME,FG6PeralatanKerjaLuarCraneTable.Cols.ID_F1_PERALATAN_KERJA_LR_CRANE_SERVER+ "=?",
                new String[] {formGalpal6IdServer});
        try{
            if(cursor.getCount()<=0){
                mDatabase.insert(FG6PeralatanKerjaLuarCraneTable.NAME,null,values);
            }else{
                mDatabase.update(FG6PeralatanKerjaLuarCraneTable.NAME,values,FG6PeralatanKerjaLuarCraneTable.Cols.ID_F1_PERALATAN_KERJA_LR_CRANE_SERVER+" = ?",new String[]{formGalpal6IdServer});
            }

        }finally {
            cursor.close();
        }
    }

    public void addFormGalpal7(FormGalpal7 formGalpal7){
        ContentValues values=getContentValues(formGalpal7);
        String formGalpal6Id=String.valueOf(formGalpal7.getIdPeralatanKerjaTugboat());

        CursorWrapperGal cursor=query(FG7PeralatanKerjaLuarTugboatTable.NAME,FG7PeralatanKerjaLuarTugboatTable.Cols.ID_F1_PERALATAN_KERJA_LR_TUG+ "=?",
                new String[] {formGalpal6Id});
        try{
            if(cursor.getCount()==0){
                mDatabase.insert(FG7PeralatanKerjaLuarTugboatTable.NAME,null,values);
            }else{
                mDatabase.update(FG7PeralatanKerjaLuarTugboatTable.NAME,values,FG7PeralatanKerjaLuarTugboatTable.Cols.ID_F1_PERALATAN_KERJA_LR_TUG+" = ?",new String[]{formGalpal6Id});
            }

        }finally {
            cursor.close();
        }
    }

    public void addFormGalpal7Server(FormGalpal7 formGalpal7){
        ContentValues values=getContentValues(formGalpal7);
        String formGalpal6Id=String.valueOf(formGalpal7.getFormServerId());

        CursorWrapperGal cursor=query(FG7PeralatanKerjaLuarTugboatTable.NAME,FG7PeralatanKerjaLuarTugboatTable.Cols.ID_F1_PERALATAN_KERJA_LR_TUG_SERVER+ "=?",
                new String[] {formGalpal6Id});
        try{
            if(cursor.getCount()==0){
                mDatabase.insert(FG7PeralatanKerjaLuarTugboatTable.NAME,null,values);
            }else{
                mDatabase.update(FG7PeralatanKerjaLuarTugboatTable.NAME,values,FG7PeralatanKerjaLuarTugboatTable.Cols.ID_F1_PERALATAN_KERJA_LR_TUG_SERVER+" = ?",new String[]{formGalpal6Id});
            }

        }finally {
            cursor.close();
        }
    }

    public void addFormGalpal8(FormGalpal8 formGalpal8){
        ContentValues values=getContentValues(formGalpal8);
        String formGalpal8Id=String.valueOf(formGalpal8.getIdPeralatanKerjaProdMesin());

        CursorWrapperGal cursor=query(FG8PeralatanKerjaProduksiMesinTable.NAME,FG8PeralatanKerjaProduksiMesinTable.Cols.ID_F1_PERALATAN_KERJA_PROD_MESIN+ "=?",
                new String[] {formGalpal8Id});
        try{
            if(cursor.getCount()==0){
                mDatabase.insert(FG8PeralatanKerjaProduksiMesinTable.NAME,null,values);
            }else{
                mDatabase.update(FG8PeralatanKerjaProduksiMesinTable.NAME,values,FG8PeralatanKerjaProduksiMesinTable.Cols.ID_F1_PERALATAN_KERJA_PROD_MESIN+" = ?",new String[]{formGalpal8Id});
            }

        }finally {
            cursor.close();
        }
    }

    public void addFormGalpal8Server(FormGalpal8 formGalpal8){
        ContentValues values=getContentValues(formGalpal8);
        String formGalpal8Id=String.valueOf(formGalpal8.getFormServerId());

        CursorWrapperGal cursor=query(FG8PeralatanKerjaProduksiMesinTable.NAME,FG8PeralatanKerjaProduksiMesinTable.Cols.ID_F1_PERALATAN_KERJA_PROD_MESIN_SERVER+ "=?",
                new String[] {formGalpal8Id});
        try{
            if(cursor.getCount()==0){
                mDatabase.insert(FG8PeralatanKerjaProduksiMesinTable.NAME,null,values);
            }else{
                mDatabase.update(FG8PeralatanKerjaProduksiMesinTable.NAME,values,FG8PeralatanKerjaProduksiMesinTable.Cols.ID_F1_PERALATAN_KERJA_PROD_MESIN_SERVER+" = ?",new String[]{formGalpal8Id});
            }

        }finally {
            cursor.close();
        }
    }

    public void addFormGalpal9(FormGalpal9 formGalpal9){
        ContentValues values=getContentValues(formGalpal9);
        String formGalpal9Id=String.valueOf(formGalpal9.getIdPeralatanKerjaProduksiKontruksi());

        CursorWrapperGal cursor=query(FG9PeralatanKerjaProduksiKontruksi.NAME,FG9PeralatanKerjaProduksiKontruksi.Cols.ID_F1_PERALATAN_KERJA_PRODUKSI_KONTRUKSI+ "=?",
                new String[] {formGalpal9Id});
        try{
            if(cursor.getCount()==0){
                mDatabase.insert(FG9PeralatanKerjaProduksiKontruksi.NAME,null,values);
            }else{
                mDatabase.update(FG9PeralatanKerjaProduksiKontruksi.NAME,values,FG9PeralatanKerjaProduksiKontruksi.Cols.ID_F1_PERALATAN_KERJA_PRODUKSI_KONTRUKSI+" = ?",new String[]{formGalpal9Id});
            }

        }finally {
            cursor.close();
        }
    }

    public void addFormGalpal9Server(FormGalpal9 formGalpal9){
        ContentValues values=getContentValues(formGalpal9);
        String formGalpal9Id=String.valueOf(formGalpal9.getFormServerId());

        CursorWrapperGal cursor=query(FG9PeralatanKerjaProduksiKontruksi.NAME,FG9PeralatanKerjaProduksiKontruksi.Cols.ID_F1_PERALATAN_KERJA_PRODUKSI_KONTRUKSI_SERVER+ "=?",
                new String[] {formGalpal9Id});
        try{
            if(cursor.getCount()==0){
                mDatabase.insert(FG9PeralatanKerjaProduksiKontruksi.NAME,null,values);
            }else{
                mDatabase.update(FG9PeralatanKerjaProduksiKontruksi.NAME,values,FG9PeralatanKerjaProduksiKontruksi.Cols.ID_F1_PERALATAN_KERJA_PRODUKSI_KONTRUKSI_SERVER+" = ?",new String[]{formGalpal9Id});
            }

        }finally {
            cursor.close();
        }
    }

    public void addFormGalpal10(FormGalpal10 formGalpal10){
        ContentValues values=getContentValues(formGalpal10);
        String formGalpal10Id=String.valueOf(formGalpal10.getIdPeralatanKerjaProdElektrikal());

        CursorWrapperGal cursor=query(FG10PeralatanKerjaProduksiElektrikalMekanikal.NAME,FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.ID_F1_PERALATAN_KERJA_PRODUKSI_ELMEK+ "=?",
                new String[] {formGalpal10Id});
        try{
            if(cursor.getCount()==0){
                mDatabase.insert(FG10PeralatanKerjaProduksiElektrikalMekanikal.NAME,null,values);
            }else{
                mDatabase.update(FG10PeralatanKerjaProduksiElektrikalMekanikal.NAME,values,FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.ID_F1_PERALATAN_KERJA_PRODUKSI_ELMEK+" = ?",new String[]{formGalpal10Id});
            }

        }finally {
            cursor.close();
        }
    }

    public void addFormGalpal10Server(FormGalpal10 formGalpal10){
        ContentValues values=getContentValues(formGalpal10);
        String formGalpal10Id=String.valueOf(formGalpal10.getFormServerId());

        CursorWrapperGal cursor=query(FG10PeralatanKerjaProduksiElektrikalMekanikal.NAME,FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.ID_F1_PERALATAN_KERJA_PRODUKSI_ELMEK_SERVER+ "=?",
                new String[] {formGalpal10Id});
        try{
            if(cursor.getCount()==0){
                mDatabase.insert(FG10PeralatanKerjaProduksiElektrikalMekanikal.NAME,null,values);
            }else{
                mDatabase.update(FG10PeralatanKerjaProduksiElektrikalMekanikal.NAME,values,FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.ID_F1_PERALATAN_KERJA_PRODUKSI_ELMEK_SERVER+" = ?",new String[]{formGalpal10Id});
            }

        }finally {
            cursor.close();
        }
    }

    public void addFormGalpal11(FormGalpal11 formGalpal11){
        ContentValues values=getContentValues(formGalpal11);
        String formGalpal11Id=String.valueOf(formGalpal11.getIdPeralatanKerjaProdPengecatan());

        CursorWrapperGal cursor=query(FG11PeralatanKerjaProduksiPengecatan.NAME,FG11PeralatanKerjaProduksiPengecatan.Cols.ID_F1_PERALATAN_KERJA_PRODUKSI_CAT+ "=?",
                new String[] {formGalpal11Id});
        try{
            if(cursor.getCount()==0){
                mDatabase.insert(FG11PeralatanKerjaProduksiPengecatan.NAME,null,values);
            }else{
                mDatabase.update(FG11PeralatanKerjaProduksiPengecatan.NAME,values,FG11PeralatanKerjaProduksiPengecatan.Cols.ID_F1_PERALATAN_KERJA_PRODUKSI_CAT+" = ?",new String[]{formGalpal11Id});
            }

        }finally {
            cursor.close();
        }
    }

    public void addFormGalpal11Server(FormGalpal11 formGalpal11){
        ContentValues values=getContentValues(formGalpal11);
        String formGalpal11Id=String.valueOf(formGalpal11.getFormServerId());

        CursorWrapperGal cursor=query(FG11PeralatanKerjaProduksiPengecatan.NAME,FG11PeralatanKerjaProduksiPengecatan.Cols.ID_F1_PERALATAN_KERJA_PRODUKSI_CAT_SERVER+ "=?",
                new String[] {formGalpal11Id});
        try{
            if(cursor.getCount()==0){
                mDatabase.insert(FG11PeralatanKerjaProduksiPengecatan.NAME,null,values);
            }else{
                mDatabase.update(FG11PeralatanKerjaProduksiPengecatan.NAME,values,FG11PeralatanKerjaProduksiPengecatan.Cols.ID_F1_PERALATAN_KERJA_PRODUKSI_CAT_SERVER+" = ?",new String[]{formGalpal11Id});
            }

        }finally {
            cursor.close();
        }
    }





    public void addFormKompal3a(FormKompal3a formKompal3a){
        ContentValues values=getContentValues(formKompal3a);
        String formKompal3aId=formKompal3a.getIdJenisKapasitasProduksi().toString();

        CursorWrapperGal cursor=query(FK3aJenisKapasitasProduksiTable.NAME,FK3aJenisKapasitasProduksiTable.Cols.ID_F2_JENIS_KAPASITAS_PRODUKSI+ "=?",
                new String[] {formKompal3aId});
        try{
            if(cursor.getCount()==0){
                mDatabase.insert(FK3aJenisKapasitasProduksiTable.NAME,null,values);
            }else{
                mDatabase.update(FK3aJenisKapasitasProduksiTable.NAME,values,FK3aJenisKapasitasProduksiTable.Cols.ID_F2_JENIS_KAPASITAS_PRODUKSI+" = ?",new String[]{formKompal3aId});
            }

        }finally {
            cursor.close();
        }
    }

    public void addFormKompal3aServer(FormKompal3a formKompal3a){
        ContentValues values=getContentValues(formKompal3a);
        String formKompal3aIdServer=String.valueOf(formKompal3a.getFormServerId());

        CursorWrapperGal cursor=query(FK3aJenisKapasitasProduksiTable.NAME,FK3aJenisKapasitasProduksiTable.Cols.ID_F2_JENIS_KAPASITAS_PRODUKSI_SERVER+ "=?",
                new String[] {formKompal3aIdServer});
        try{
            if(cursor.getCount()==0){
                mDatabase.insert(FK3aJenisKapasitasProduksiTable.NAME,null,values);
            }else{
                mDatabase.update(FK3aJenisKapasitasProduksiTable.NAME,values,FK3aJenisKapasitasProduksiTable.Cols.ID_F2_JENIS_KAPASITAS_PRODUKSI_SERVER+" = ?",new String[]{formKompal3aIdServer});
            }

        }finally {
            cursor.close();
        }
    }

    public void addFormKompal3b(FormKompal3b formKompal3b){
        ContentValues values=getContentValues(formKompal3b);
        String formKompal3bId=formKompal3b.getIdjumlahProduksi().toString();

        CursorWrapperGal cursor=query(FK3bJumlahProduksiTable.NAME,FK3bJumlahProduksiTable.Cols.ID_F2_JUMLAH_PRODUKSI+ "=?",
                new String[] {formKompal3bId});
        try{
            if(cursor.getCount()==0){
                mDatabase.insert(FK3bJumlahProduksiTable.NAME,null,values);
            }else{
                mDatabase.update(FK3bJumlahProduksiTable.NAME,values,FK3bJumlahProduksiTable.Cols.ID_F2_JUMLAH_PRODUKSI+" = ?",new String[]{formKompal3bId});
            }

        }finally {
            cursor.close();
        }
    }

    public void addFormKompal3bServer(FormKompal3b formKompal3b){
        ContentValues values=getContentValues(formKompal3b);
        String formKompal3bIdServer=String.valueOf(formKompal3b.getFormServerId());

        CursorWrapperGal cursor=query(FK3bJumlahProduksiTable.NAME,FK3bJumlahProduksiTable.Cols.ID_F2_JUMLAH_PRODUKSI_SERVER+ "=?",
                new String[] {formKompal3bIdServer});
        try{
            if(cursor.getCount()==0){
                mDatabase.insert(FK3bJumlahProduksiTable.NAME,null,values);
            }else{
                mDatabase.update(FK3bJumlahProduksiTable.NAME,values,FK3bJumlahProduksiTable.Cols.ID_F2_JUMLAH_PRODUKSI_SERVER+" = ?",new String[]{formKompal3bIdServer});
            }

        }finally {
            cursor.close();
        }
    }

    public void addFormKompal3c(FormKompal3c formKompal3c){
        ContentValues values=getContentValues(formKompal3c);
        String formKompal3cId=formKompal3c.getIdSistemBerproduksi().toString();

        CursorWrapperGal cursor=query(FK3cSistemBerproduksiTable.NAME,FK3cSistemBerproduksiTable.Cols.ID_F2_SISTEM_BERPRODUKSI+ "=?",
                new String[] {formKompal3cId});
        try{
            if(cursor.getCount()==0){
                mDatabase.insert(FK3cSistemBerproduksiTable.NAME,null,values);
            }else{
                mDatabase.update(FK3cSistemBerproduksiTable.NAME,values,FK3cSistemBerproduksiTable.Cols.ID_F2_SISTEM_BERPRODUKSI+" = ?",new String[]{formKompal3cId});
            }

        }finally {
            cursor.close();
        }
    }

    public void addFormKompal3cServer(FormKompal3c formKompal3c){
        ContentValues values=getContentValues(formKompal3c);
        String formKompal3cIdServer=String.valueOf(formKompal3c.getFormServerId());

        CursorWrapperGal cursor=query(FK3cSistemBerproduksiTable.NAME,FK3cSistemBerproduksiTable.Cols.ID_F2_SISTEM_BERPRODUKSI_SERVER+ "=?",
                new String[] {formKompal3cIdServer});
        try{
            if(cursor.getCount()==0){
                mDatabase.insert(FK3cSistemBerproduksiTable.NAME,null,values);
            }else{
                mDatabase.update(FK3cSistemBerproduksiTable.NAME,values,FK3cSistemBerproduksiTable.Cols.ID_F2_SISTEM_BERPRODUKSI_SERVER+" = ?",new String[]{formKompal3cIdServer});
            }

        }finally {
            cursor.close();
        }
    }

    public void addFormKompal3d(FormKompal3d formKompal3d){
        ContentValues values=getContentValues(formKompal3d);
        String formKompal3dId=formKompal3d.getIdStandarMutu().toString();

        CursorWrapperGal cursor=query(FK3dStandarMutuTableTable.NAME,FK3dStandarMutuTableTable.Cols.ID_F2_STANDAR_MUTU+ "=?",
                new String[] {formKompal3dId});
        try{
            if(cursor.getCount()==0){
                mDatabase.insert(FK3dStandarMutuTableTable.NAME,null,values);
            }else{
                mDatabase.update(FK3dStandarMutuTableTable.NAME,values,FK3dStandarMutuTableTable.Cols.ID_F2_STANDAR_MUTU+" = ?",new String[]{formKompal3dId});
            }

        }finally {
            cursor.close();
        }
    }

    public void addFormKompal3dServer(FormKompal3d formKompal3d){
        ContentValues values=getContentValues(formKompal3d);
        String formKompal3dIdServer=String.valueOf(formKompal3d.getFormServerId());

        CursorWrapperGal cursor=query(FK3dStandarMutuTableTable.NAME,FK3dStandarMutuTableTable.Cols.ID_F2_STANDAR_MUTU_SERVER+ "=?",
                new String[] {formKompal3dIdServer});
        try{
            if(cursor.getCount()==0){
                mDatabase.insert(FK3dStandarMutuTableTable.NAME,null,values);
            }else{
                mDatabase.update(FK3dStandarMutuTableTable.NAME,values,FK3dStandarMutuTableTable.Cols.ID_F2_STANDAR_MUTU_SERVER+" = ?",new String[]{formKompal3dIdServer});
            }

        }finally {
            cursor.close();
        }
    }






    public void deleteFormGalpal6(FormGalpal6 formGalpal6){
        String formGalpal6Id=String.valueOf(formGalpal6.getIdPeralatanKerjaCrane());
        mDatabase.delete(FG6PeralatanKerjaLuarCraneTable.NAME,FG6PeralatanKerjaLuarCraneTable.Cols.ID_F1_PERALATAN_KERJA_LR_CRANE+ "=?",
                new String[] {formGalpal6Id});
    }

    public void deleteFormGalpal7(FormGalpal7 formGalpal7){
        String formGalpal7Id=String.valueOf(formGalpal7.getIdPeralatanKerjaTugboat());
        mDatabase.delete(FG7PeralatanKerjaLuarTugboatTable.NAME,FG7PeralatanKerjaLuarTugboatTable.Cols.ID_F1_PERALATAN_KERJA_LR_TUG+ "=?",
                new String[] {formGalpal7Id});
    }

    public void deleteFormGalpal8(FormGalpal8 formGalpal8){
        String formGalpal8Id=String.valueOf(formGalpal8.getIdPeralatanKerjaProdMesin());
        mDatabase.delete(FG8PeralatanKerjaProduksiMesinTable.NAME,FG8PeralatanKerjaProduksiMesinTable.Cols.ID_F1_PERALATAN_KERJA_PROD_MESIN+ "=?",
                new String[] {formGalpal8Id});
    }

    public void deleteFormGalpal9(FormGalpal9 formGalpal9){
        String formGalpal9Id=String.valueOf(formGalpal9.getIdPeralatanKerjaProduksiKontruksi());
        mDatabase.delete(FG8PeralatanKerjaProduksiMesinTable.NAME,FG8PeralatanKerjaProduksiMesinTable.Cols.ID_F1_PERALATAN_KERJA_PROD_MESIN+ "=?",
                new String[] {formGalpal9Id});
    }

    public void deleteFormGalpal10(FormGalpal10 formGalpal10){
        String formGalpal10Id=String.valueOf(formGalpal10.getIdPeralatanKerjaProdElektrikal());
        mDatabase.delete(FG10PeralatanKerjaProduksiElektrikalMekanikal.NAME,FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.ID_F1_PERALATAN_KERJA_PRODUKSI_ELMEK+ "=?",
                new String[] {formGalpal10Id});
    }

    public void deleteFormGalpal11(FormGalpal11 formGalpal11){
        String formGalpal11Id=String.valueOf(formGalpal11.getIdPeralatanKerjaProdPengecatan());
        mDatabase.delete(FG11PeralatanKerjaProduksiPengecatan.NAME,FG11PeralatanKerjaProduksiPengecatan.Cols.ID_F1_PERALATAN_KERJA_PRODUKSI_CAT+ "=?",
                new String[] {formGalpal11Id});
    }

    public void deleteFormKompal3a(FormKompal3a formKompal3a){
        String formKompal3aId=formKompal3a.getIdJenisKapasitasProduksi().toString();
        mDatabase.delete(FK3aJenisKapasitasProduksiTable.NAME,FK3aJenisKapasitasProduksiTable.Cols.ID_F2_JENIS_KAPASITAS_PRODUKSI+ "=?",
                new String[] {formKompal3aId});
    }

    public void deleteFormKompal3b(FormKompal3b formKompal3b){
        String formKompal3bId=formKompal3b.getIdjumlahProduksi().toString();
        mDatabase.delete(FK3bJumlahProduksiTable.NAME,FK3bJumlahProduksiTable.Cols.ID_F2_JUMLAH_PRODUKSI+ "=?",
                new String[] {formKompal3bId});
    }

    public void deleteFormKompal3c(FormKompal3c formKompal3c){
        String formKompal3cId=formKompal3c.getIdSistemBerproduksi().toString();
        mDatabase.delete(FK3cSistemBerproduksiTable.NAME,FK3cSistemBerproduksiTable.Cols.ID_F2_SISTEM_BERPRODUKSI+ "=?",
                new String[] {formKompal3cId});
    }

    public void deleteFormKompal3d(FormKompal3d formKompal3d){
        String formKompal3dId=formKompal3d.getIdStandarMutu().toString();
        mDatabase.delete(FK3dStandarMutuTableTable.NAME,FK3dStandarMutuTableTable.Cols.ID_F2_STANDAR_MUTU+ "=?",
                new String[] {formKompal3dId});
    }

    public void deleteGalpalFormsMenus(){
        mDatabase.delete(FG1PerusahaanIdentitasTable.NAME,null,null);
        mDatabase.delete(FG3GalanganKapalTable.NAME,null,null);
        mDatabase.delete(FG4TinjauanAreaTable.NAME,null,null);
        mDatabase.delete(FG6PeralatanKerjaLuarCraneTable.NAME,null,null);
        mDatabase.delete(FG7PeralatanKerjaLuarTugboatTable.NAME,null,null);
        mDatabase.delete(FG8PeralatanKerjaProduksiMesinTable.NAME,null,null);
        mDatabase.delete(FG9PeralatanKerjaProduksiKontruksi.NAME,null,null);
        mDatabase.delete(FG10PeralatanKerjaProduksiElektrikalMekanikal.NAME,null,null);
        mDatabase.delete(FG11PeralatanKerjaProduksiPengecatan.NAME,null,null);
        mDatabase.delete(MenuCheckingGalpalTable.NAME,null,null);
    }

    public void deleteKompalFormsMenus(){
        mDatabase.delete(FK3aJenisKapasitasProduksiTable.NAME,null,null);
        mDatabase.delete(FK3bJumlahProduksiTable.NAME,null,null);
        mDatabase.delete(FK3cSistemBerproduksiTable.NAME,null,null);
        mDatabase.delete(FK3dStandarMutuTableTable.NAME,null,null);
        mDatabase.delete(MenuCheckingKompalTable.NAME,null,null);
    }







    private static ContentValues getContentValues(User user){
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

    private static ContentValues getContentValues(SurveyAssignSurveyor surveyAssignSurveyor){
        ContentValues values=new ContentValues();
        values.put(SurveyAssignSurveyorTable.Cols.ID_SURVEY_ASSIGN_SURVEYOR, surveyAssignSurveyor.getSurveyAssignSurveyorId());
        values.put(SurveyAssignSurveyorTable.Cols.ID_KUALIFIKASI_SURVEY, surveyAssignSurveyor.getKualifikasiSurveyId());
        values.put(SurveyAssignSurveyorTable.Cols.USERID, surveyAssignSurveyor.getUserId());
//        values.put(SurveyAssignSurveyorTable.Cols.ASSIGN_DATE, surveyAssignSurveyor.getAssignDate().getTime());
        values.put(SurveyAssignSurveyorTable.Cols.ASSIGN_BY, surveyAssignSurveyor.getAssignByUserId());

        return values;
    }

    private static ContentValues getContentValues(PeriodeSurvey periodeSurvey){
        ContentValues values=new ContentValues();
        values.put(PeriodeSurveyTable.Cols.ID_PERIODE, periodeSurvey.getPeriodeSurveyId());
        values.put(PeriodeSurveyTable.Cols.TAHUN_KUALIFIKASI, periodeSurvey.getTahunKualifikasi());
        values.put(PeriodeSurveyTable.Cols.IS_ACTIVE_PERIOD, periodeSurvey.isActivePeriode());
        values.put(PeriodeSurveyTable.Cols.IS_DONE, periodeSurvey.isDone());
        values.put(PeriodeSurveyTable.Cols.KETERANGAN, periodeSurvey.getKeterangan());


        return values;
    }

    private static ContentValues getContentValues(Perusahaan perusahaan){
        ContentValues values=new ContentValues();
        values.put(PerusahaanTable.Cols.ID_PERUSAHAAN, perusahaan.getId());
        values.put(PerusahaanTable.Cols.NAMA_PERUSAHAAN, perusahaan.getNamaPerusahaan());
        values.put(PerusahaanTable.Cols.INDUSTRI, perusahaan.getIndustri());
        values.put(PerusahaanTable.Cols.IS_ACTIV, perusahaan.isActive() ? 1 : 0);

        return values;
    }

    private static ContentValues getContentValues(KualifikasiSurvey kualifikasiSurvey){
        ContentValues values=new ContentValues();
        values.put(KualifikasiSurveyTable.Cols.ID_KUALIFIKASI_SURVEY, kualifikasiSurvey.getKualifikasiSurveyId());
        values.put(KualifikasiSurveyTable.Cols.ID_PERUSAHAAN, kualifikasiSurvey.getPerusahaanId());
        values.put(KualifikasiSurveyTable.Cols.ID_PERIODE, kualifikasiSurvey.getPeriodeSurveyId());
        values.put(KualifikasiSurveyTable.Cols.ID_GALANGAN_KAPAL, kualifikasiSurvey.getGalanganKapalId());
        values.put(KualifikasiSurveyTable.Cols.STATUS,kualifikasiSurvey.getStatus());
        values.put(KualifikasiSurveyTable.Cols.PROGRESS,kualifikasiSurvey.getProgress());
        return values;
    }

    private static ContentValues getContentValues(FormGalpal1 formGalpal1){
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
        contentValues.put(FG1PerusahaanIdentitasTable.Cols.ID_PROPINSI_PERUSAHAAN, formGalpal1.getIdPropinsi());
        contentValues.put(FG1PerusahaanIdentitasTable.Cols.ID_KABUPATEN_PERUSAHAAN, formGalpal1.getIdKabupaten_kota());
        contentValues.put(FG1PerusahaanIdentitasTable.Cols.KODE_POS_PERUSAHAAN, formGalpal1.getKodePos());
        contentValues.put(FG1PerusahaanIdentitasTable.Cols.ANGGOTA_ASOSIASI, formGalpal1.getAnggotaAsosiasi());
        contentValues.put(FG1PerusahaanIdentitasTable.Cols.KATEGORI_PERUSAHAAN, formGalpal1.getKategoriPerusahaan());
        contentValues.put(FG1PerusahaanIdentitasTable.Cols.CP_NAMA, formGalpal1.getContactPerson());
        contentValues.put(FG1PerusahaanIdentitasTable.Cols.CP_NOMOR, formGalpal1.getNomorCp());
        contentValues.put(FG1PerusahaanIdentitasTable.Cols.CP_JABATAN, formGalpal1.getJabatan());
        contentValues.put(FG1PerusahaanIdentitasTable.Cols.CP_EMAIL, formGalpal1.getEmail());
        contentValues.put(FG1PerusahaanIdentitasTable.Cols.WEBSITE, formGalpal1.getWebsite());
        return contentValues;
    }

    private static ContentValues getContentValues(FormGalpal3 formGalpal3){
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
        contentValues.put(FG3GalanganKapalTable.Cols.ID_PROPINSI_GALANGAN,formGalpal3.getPropinsiId());
        contentValues.put(FG3GalanganKapalTable.Cols.ID_KABUPATEN_GALANGAN, formGalpal3.getKebupaten_kotaId());
        contentValues.put(FG3GalanganKapalTable.Cols.KODE_POS_GALANGAN, formGalpal3.getKodePos());
        contentValues.put(FG3GalanganKapalTable.Cols.IMAGE_PATH,formGalpal3.getImagePath());
        contentValues.put(FG3GalanganKapalTable.Cols.LATITUDE, formGalpal3.getLatitude());
        contentValues.put(FG3GalanganKapalTable.Cols.LONGITUDE, formGalpal3.getLongitude());
        contentValues.put(FG3GalanganKapalTable.Cols.KATEGORI_GALANGAN, formGalpal3.getKategoriGalangan());
        contentValues.put(FG3GalanganKapalTable.Cols.CP_NAMA, formGalpal3.getContactPerson());
        contentValues.put(FG3GalanganKapalTable.Cols.CP_NO, formGalpal3.getNomorCp());
        contentValues.put(FG3GalanganKapalTable.Cols.CP_JABATAN, formGalpal3.getJabatan());
        contentValues.put(FG3GalanganKapalTable.Cols.CP_EMAIL, formGalpal3.getEmail());
        return contentValues;
    }

    private static ContentValues getContentValues(FormGalpal4 formGalpal4){
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


    private static ContentValues getContentValues(FormGalpal6 formGalpal6){
        ContentValues contentValues=new ContentValues();
        contentValues.put(FG6PeralatanKerjaLuarCraneTable.Cols.ID_F1_PERALATAN_KERJA_LR_CRANE ,formGalpal6.getIdPeralatanKerjaCrane().toString());
        contentValues.put(FG6PeralatanKerjaLuarCraneTable.Cols.ID_F1_PERALATAN_KERJA_LR_CRANE_SERVER,formGalpal6.getFormServerId());
        contentValues.put(FG6PeralatanKerjaLuarCraneTable.Cols.ID_KUALIFIKASI_SURVEY ,formGalpal6.getKualifikasiSurveyId());
        contentValues.put(FG6PeralatanKerjaLuarCraneTable.Cols.JENIS_MESIN ,formGalpal6.getJenisMesin());
        contentValues.put(FG6PeralatanKerjaLuarCraneTable.Cols.TAHUN_PEMBUATAN ,formGalpal6.getTahunPembuatan());
        contentValues.put(FG6PeralatanKerjaLuarCraneTable.Cols.MERK ,formGalpal6.getMerek());
        contentValues.put(FG6PeralatanKerjaLuarCraneTable.Cols.KAPASAITAS_TERPASANG ,formGalpal6.getKapasitasTerpasang());
        contentValues.put(FG6PeralatanKerjaLuarCraneTable.Cols.KAPASITAS_TERPAKAI ,formGalpal6.getKapasitasTerpakai());
        contentValues.put(FG6PeralatanKerjaLuarCraneTable.Cols.DIMENSI ,formGalpal6.getDimensi());
        contentValues.put(FG6PeralatanKerjaLuarCraneTable.Cols.JUMLAH ,formGalpal6.getJumlah());
        contentValues.put(FG6PeralatanKerjaLuarCraneTable.Cols.KONDISI ,formGalpal6.getKondisi());
        contentValues.put(FG6PeralatanKerjaLuarCraneTable.Cols.LOKASI ,formGalpal6.getLokasi());
        contentValues.put(FG6PeralatanKerjaLuarCraneTable.Cols.STATUS ,formGalpal6.getStatus());
        contentValues.put(FG6PeralatanKerjaLuarCraneTable.Cols.SATUAN_KAPASITAS_TERPAKAI ,formGalpal6.getSatuanKapasitasTerpakai());
        contentValues.put(FG6PeralatanKerjaLuarCraneTable.Cols.SATUAN_KAPASITAS_TERPASANG ,formGalpal6.getSatuanKapastiasTerpasang());
        return contentValues;
    }

    private static ContentValues getContentValues(FormGalpal7 formGalpal7){
        ContentValues contentValues=new ContentValues();
        contentValues.put(FG7PeralatanKerjaLuarTugboatTable.Cols.ID_F1_PERALATAN_KERJA_LR_TUG ,formGalpal7.getIdPeralatanKerjaTugboat().toString());
        contentValues.put(FG7PeralatanKerjaLuarTugboatTable.Cols.ID_F1_PERALATAN_KERJA_LR_TUG_SERVER,formGalpal7.getFormServerId());
        contentValues.put(FG7PeralatanKerjaLuarTugboatTable.Cols.ID_KUALIFIKASI_SURVEY ,formGalpal7.getKualifikasiSurveyId());
        contentValues.put(FG7PeralatanKerjaLuarTugboatTable.Cols.JENIS_MESIN ,formGalpal7.getJenisPeralatan());
        contentValues.put(FG7PeralatanKerjaLuarTugboatTable.Cols.TAHUN_PEMBUATAN ,formGalpal7.getTahunPembuatan());
        contentValues.put(FG7PeralatanKerjaLuarTugboatTable.Cols.MERK ,formGalpal7.getMerek());
        contentValues.put(FG7PeralatanKerjaLuarTugboatTable.Cols.KAPASAITAS_TERPASANG ,formGalpal7.getKapasitasTerpasang());
        contentValues.put(FG7PeralatanKerjaLuarTugboatTable.Cols.KAPASITAS_TERPAKAI ,formGalpal7.getKapasitasTerpakai());
        contentValues.put(FG7PeralatanKerjaLuarTugboatTable.Cols.DIMENSI ,formGalpal7.getDimensi());
        contentValues.put(FG7PeralatanKerjaLuarTugboatTable.Cols.JUMLAH ,formGalpal7.getJumlah());
        contentValues.put(FG7PeralatanKerjaLuarTugboatTable.Cols.KONDISI ,formGalpal7.getKondisi());
        contentValues.put(FG7PeralatanKerjaLuarTugboatTable.Cols.LOKASI ,formGalpal7.getLokasi());
        contentValues.put(FG7PeralatanKerjaLuarTugboatTable.Cols.STATUS ,formGalpal7.getStatus());
        contentValues.put(FG7PeralatanKerjaLuarTugboatTable.Cols.SATUAN_KAPASITAS_TERPAKAI ,formGalpal7.getSatuanKapasitasTerpakai());
        contentValues.put(FG7PeralatanKerjaLuarTugboatTable.Cols.SATUAN_KAPASITAS_TERPASANG ,formGalpal7.getSatuanKapastiasTerpasang());
        return contentValues;
    }

    private static ContentValues getContentValues(FormGalpal8 formGalpal8){
        ContentValues contentValues=new ContentValues();
        contentValues.put(FG8PeralatanKerjaProduksiMesinTable.Cols.ID_F1_PERALATAN_KERJA_PROD_MESIN ,formGalpal8.getIdPeralatanKerjaProdMesin().toString());
        contentValues.put(FG8PeralatanKerjaProduksiMesinTable.Cols.ID_F1_PERALATAN_KERJA_PROD_MESIN_SERVER,formGalpal8.getFormServerId());
        contentValues.put(FG8PeralatanKerjaProduksiMesinTable.Cols.ID_KUALIFIKASI_SURVEY ,formGalpal8.getKualifikasiSurveyId());
        contentValues.put(FG8PeralatanKerjaProduksiMesinTable.Cols.JENIS_MESIN ,formGalpal8.getJenisMesin());
        contentValues.put(FG8PeralatanKerjaProduksiMesinTable.Cols.TAHUN_PEMBUATAN ,formGalpal8.getTahunPembuatan());
        contentValues.put(FG8PeralatanKerjaProduksiMesinTable.Cols.MERK ,formGalpal8.getMerek());
        contentValues.put(FG8PeralatanKerjaProduksiMesinTable.Cols.KAPASAITAS_TERPASANG ,formGalpal8.getKapasitasTerpasang());
        contentValues.put(FG8PeralatanKerjaProduksiMesinTable.Cols.KAPASITAS_TERPAKAI ,formGalpal8.getKapasitasTerpakai());
        contentValues.put(FG8PeralatanKerjaProduksiMesinTable.Cols.DIMENSI ,formGalpal8.getDimensi());
        contentValues.put(FG8PeralatanKerjaProduksiMesinTable.Cols.JUMLAH ,formGalpal8.getJumlah());
        contentValues.put(FG8PeralatanKerjaProduksiMesinTable.Cols.KONDISI ,formGalpal8.getKondisi());
        contentValues.put(FG8PeralatanKerjaProduksiMesinTable.Cols.LOKASI ,formGalpal8.getLokasi());
        contentValues.put(FG8PeralatanKerjaProduksiMesinTable.Cols.STATUS ,formGalpal8.getStatus());
        contentValues.put(FG8PeralatanKerjaProduksiMesinTable.Cols.SATUAN_KAPASITAS_TERPAKAI ,formGalpal8.getSatuanKapasitasTerpakai());
        contentValues.put(FG8PeralatanKerjaProduksiMesinTable.Cols.SATUAN_KAPASITAS_TERPASANG ,formGalpal8.getSatuanKapastiasTerpasang());
        return contentValues;
    }

    private static ContentValues getContentValues(FormGalpal9 formGalpal9){
        ContentValues contentValues=new ContentValues();
        contentValues.put(FG9PeralatanKerjaProduksiKontruksi.Cols.ID_F1_PERALATAN_KERJA_PRODUKSI_KONTRUKSI ,formGalpal9.getIdPeralatanKerjaProduksiKontruksi().toString());
        contentValues.put(FG9PeralatanKerjaProduksiKontruksi.Cols.ID_F1_PERALATAN_KERJA_PRODUKSI_KONTRUKSI_SERVER,formGalpal9.getFormServerId());
        contentValues.put(FG9PeralatanKerjaProduksiKontruksi.Cols.ID_KUALIFIKASI_SURVEY ,formGalpal9.getKualifikasiSurveyId());
        contentValues.put(FG9PeralatanKerjaProduksiKontruksi.Cols.JENIS_MESIN ,formGalpal9.getJenisMesin());
        contentValues.put(FG9PeralatanKerjaProduksiKontruksi.Cols.TAHUN_PEMBUATAN ,formGalpal9.getTahunPembuatan());
        contentValues.put(FG9PeralatanKerjaProduksiKontruksi.Cols.MERK ,formGalpal9.getMerek());
        contentValues.put(FG9PeralatanKerjaProduksiKontruksi.Cols.KAPASAITAS_TERPASANG ,formGalpal9.getKapasitasTerpasang());
        contentValues.put(FG9PeralatanKerjaProduksiKontruksi.Cols.KAPASITAS_TERPAKAI ,formGalpal9.getKapasitasTerpakai());
        contentValues.put(FG9PeralatanKerjaProduksiKontruksi.Cols.DIMENSI ,formGalpal9.getDimensi());
        contentValues.put(FG9PeralatanKerjaProduksiKontruksi.Cols.JUMLAH ,formGalpal9.getJumlah());
        contentValues.put(FG9PeralatanKerjaProduksiKontruksi.Cols.KONDISI ,formGalpal9.getKondisi());
        contentValues.put(FG9PeralatanKerjaProduksiKontruksi.Cols.LOKASI ,formGalpal9.getLokasi());
        contentValues.put(FG9PeralatanKerjaProduksiKontruksi.Cols.STATUS ,formGalpal9.getStatus());
        contentValues.put(FG9PeralatanKerjaProduksiKontruksi.Cols.SATUAN_KAPASITAS_TERPAKAI ,formGalpal9.getSatuanKapasitasTerpakai());
        contentValues.put(FG9PeralatanKerjaProduksiKontruksi.Cols.SATUAN_KAPASITAS_TERPASANG ,formGalpal9.getSatuanKapastiasTerpasang());
        return contentValues;
    }

    private static ContentValues getContentValues(FormGalpal10 formGalpal10){
        ContentValues contentValues=new ContentValues();
        contentValues.put(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.ID_F1_PERALATAN_KERJA_PRODUKSI_ELMEK ,formGalpal10.getIdPeralatanKerjaProdElektrikal().toString());
        contentValues.put(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.ID_F1_PERALATAN_KERJA_PRODUKSI_ELMEK_SERVER,formGalpal10.getFormServerId());
        contentValues.put(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.ID_KUALIFIKASI_SURVEY ,formGalpal10.getKualifikasiSurveyId());
        contentValues.put(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.JENIS_MESIN ,formGalpal10.getJenisMesin());
        contentValues.put(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.TAHUN_PEMBUATAN ,formGalpal10.getTahunPembuatan());
        contentValues.put(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.MERK ,formGalpal10.getMerek());
        contentValues.put(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.KAPASAITAS_TERPASANG ,formGalpal10.getKapasitasTerpasang());
        contentValues.put(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.KAPASITAS_TERPAKAI ,formGalpal10.getKapasitasTerpakai());
        contentValues.put(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.DIMENSI ,formGalpal10.getDimensi());
        contentValues.put(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.JUMLAH ,formGalpal10.getJumlah());
        contentValues.put(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.KONDISI ,formGalpal10.getKondisi());
        contentValues.put(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.LOKASI ,formGalpal10.getLokasi());
        contentValues.put(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.STATUS ,formGalpal10.getStatus());
        contentValues.put(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.SATUAN_KAPASITAS_TERPAKAI ,formGalpal10.getSatuanKapasitasTerpakai());
        contentValues.put(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.SATUAN_KAPASITAS_TERPASANG ,formGalpal10.getSatuanKapastiasTerpasang());
        return contentValues;
    }

    private static ContentValues getContentValues(FormGalpal11 formGalpal11){
        ContentValues contentValues=new ContentValues();
        contentValues.put(FG11PeralatanKerjaProduksiPengecatan.Cols.ID_F1_PERALATAN_KERJA_PRODUKSI_CAT ,formGalpal11.getIdPeralatanKerjaProdPengecatan().toString());
        contentValues.put(FG11PeralatanKerjaProduksiPengecatan.Cols.ID_F1_PERALATAN_KERJA_PRODUKSI_CAT_SERVER,formGalpal11.getFormServerId());
        contentValues.put(FG11PeralatanKerjaProduksiPengecatan.Cols.ID_KUALIFIKASI_SURVEY ,formGalpal11.getKualifikasiSurveyId());
        contentValues.put(FG11PeralatanKerjaProduksiPengecatan.Cols.JENIS_MESIN ,formGalpal11.getJenisMesin());
        contentValues.put(FG11PeralatanKerjaProduksiPengecatan.Cols.TAHUN_PEMBUATAN ,formGalpal11.getTahunPembuatan());
        contentValues.put(FG11PeralatanKerjaProduksiPengecatan.Cols.MERK ,formGalpal11.getMerek());
        contentValues.put(FG11PeralatanKerjaProduksiPengecatan.Cols.KAPASAITAS_TERPASANG ,formGalpal11.getKapasitasTerpasang());
        contentValues.put(FG11PeralatanKerjaProduksiPengecatan.Cols.KAPASITAS_TERPAKAI ,formGalpal11.getKapasitasTerpakai());
        contentValues.put(FG11PeralatanKerjaProduksiPengecatan.Cols.DIMENSI ,formGalpal11.getDimensi());
        contentValues.put(FG11PeralatanKerjaProduksiPengecatan.Cols.JUMLAH ,formGalpal11.getJumlah());
        contentValues.put(FG11PeralatanKerjaProduksiPengecatan.Cols.KONDISI ,formGalpal11.getKondisi());
        contentValues.put(FG11PeralatanKerjaProduksiPengecatan.Cols.LOKASI ,formGalpal11.getLokasi());
        contentValues.put(FG11PeralatanKerjaProduksiPengecatan.Cols.STATUS ,formGalpal11.getStatus());
        contentValues.put(FG11PeralatanKerjaProduksiPengecatan.Cols.SATUAN_KAPASITAS_TERPAKAI ,formGalpal11.getSatuanKapasitasTerpakai());
        contentValues.put(FG11PeralatanKerjaProduksiPengecatan.Cols.SATUAN_KAPASITAS_TERPASANG ,formGalpal11.getSatuanKapastiasTerpasang());
        return contentValues;
    }





    private static ContentValues getContentValues(FormKompal3a formKompal3a){
        ContentValues contentValues=new ContentValues();
        contentValues.put(FK3aJenisKapasitasProduksiTable.Cols.ID_F2_JENIS_KAPASITAS_PRODUKSI,formKompal3a.getIdJenisKapasitasProduksi().toString());
        contentValues.put(FK3aJenisKapasitasProduksiTable.Cols.ID_F2_JENIS_KAPASITAS_PRODUKSI_SERVER, formKompal3a.getFormServerId());
        contentValues.put(FK3aJenisKapasitasProduksiTable.Cols.ID_KUALIFIKASI_SURVEY,formKompal3a.getKualifikasiSurveyId());
        contentValues.put(FK3aJenisKapasitasProduksiTable.Cols.JENIS_PRODUKSI,formKompal3a.getJenisProduksi());
        contentValues.put(FK3aJenisKapasitasProduksiTable.Cols.KAPASITAS_PRODUKSI,formKompal3a.getKapasitasProduksi());
        contentValues.put(FK3aJenisKapasitasProduksiTable.Cols.ID_MST_SATUAN,formKompal3a.getSatuan());

        return contentValues;
    }

    private static ContentValues getContentValues(FormKompal3b formKompal3b){
        ContentValues contentValues=new ContentValues();
        contentValues.put(FK3bJumlahProduksiTable.Cols.ID_F2_JUMLAH_PRODUKSI,formKompal3b.getIdjumlahProduksi().toString());
        contentValues.put(FK3bJumlahProduksiTable.Cols.ID_F2_JUMLAH_PRODUKSI_SERVER,formKompal3b.getFormServerId());
        contentValues.put(FK3bJumlahProduksiTable.Cols.ID_KUALIFIKASI_SURVEY,formKompal3b.getKualifikasiSurveyId());
        contentValues.put(FK3bJumlahProduksiTable.Cols.ID_F2_JENIS_KAPASITAS_PRODUKSI,formKompal3b.getJenisProdukId());
        contentValues.put(FK3bJumlahProduksiTable.Cols.JUMLAH_PROD_NMIN1,formKompal3b.getJumlahProdThn1());
        contentValues.put(FK3bJumlahProduksiTable.Cols.JUMLAH_PROD_NMIN2,formKompal3b.getJumlahProdThn2());
        contentValues.put(FK3bJumlahProduksiTable.Cols.JUMLAH_PROD_NMIN3,formKompal3b.getJumlahProdThn3());
        contentValues.put(FK3bJumlahProduksiTable.Cols.JUMLAH_PROD_NMIN4,formKompal3b.getJumlahProdThn4());
        contentValues.put(FK3bJumlahProduksiTable.Cols.ID_MST_SATUAN,formKompal3b.getSatuanId());
        contentValues.put(FK3bJumlahProduksiTable.Cols.NILAI_PRODUKSI_NMIN1,formKompal3b.getNilaiProduksiThn1());
        contentValues.put(FK3bJumlahProduksiTable.Cols.NILAI_PRODUKSI_NMIN2,formKompal3b.getNilaiProduksiThn2());
        contentValues.put(FK3bJumlahProduksiTable.Cols.NILAI_PRODUKSI_NMIN3,formKompal3b.getNilaiProduksiThn3());
        contentValues.put(FK3bJumlahProduksiTable.Cols.NILAI_PRODUKSI_NMIN4,formKompal3b.getNilaiProduksiThn4());
        contentValues.put(FK3bJumlahProduksiTable.Cols.KETERANGAN,formKompal3b.getKeterangan());
        return contentValues;
    }

    private static ContentValues getContentValues(FormKompal3c formKompal3c){
        ContentValues contentValues=new ContentValues();
        contentValues.put(FK3cSistemBerproduksiTable.Cols.ID_F2_SISTEM_BERPRODUKSI,formKompal3c.getIdSistemBerproduksi().toString());
        contentValues.put(FK3cSistemBerproduksiTable.Cols.ID_F2_SISTEM_BERPRODUKSI_SERVER,formKompal3c.getFormServerId());
        contentValues.put(FK3cSistemBerproduksiTable.Cols.ID_KUALIFIKASI_SURVEY,formKompal3c.getKualifikasiSurveyId());
        contentValues.put(FK3cSistemBerproduksiTable.Cols.NAMA_PRODUK,formKompal3c.getNamaProduk());
        contentValues.put(FK3cSistemBerproduksiTable.Cols.ID_MST_JENIS_PRODUKSI,formKompal3c.getSistemProduksi());
        contentValues.put(FK3cSistemBerproduksiTable.Cols.JUMLAH_PROD_NMIN1,formKompal3c.getJumlahProduksiThn1());
        contentValues.put(FK3cSistemBerproduksiTable.Cols.JUMLAH_PROD_NMIN2,formKompal3c.getJumlahProduksiThn2());
        contentValues.put(FK3cSistemBerproduksiTable.Cols.JUMLAH_PROD_NMIN3,formKompal3c.getJumlahProduksiThn3());
        contentValues.put(FK3cSistemBerproduksiTable.Cols.JUMLAH_PROD_NMIN4,formKompal3c.getJumlahProduksiThn4());
        return contentValues;
    }

    private static ContentValues getContentValues(FormKompal3d formKompal3d){
        ContentValues contentValues=new ContentValues();
        contentValues.put(FK3dStandarMutuTableTable.Cols.ID_F2_STANDAR_MUTU,formKompal3d.getIdStandarMutu().toString());
        contentValues.put(FK3dStandarMutuTableTable.Cols.ID_F2_STANDAR_MUTU_SERVER,formKompal3d.getFormServerId());
        contentValues.put(FK3dStandarMutuTableTable.Cols.ID_KUALIFIKASI_SURVEY,formKompal3d.getKualifikasiSurveyId());
        contentValues.put(FK3dStandarMutuTableTable.Cols.JENIS_STANDAR_MUTU,formKompal3d.getJenisStandarMutu());
        contentValues.put(FK3dStandarMutuTableTable.Cols.KETERANGAN,formKompal3d.getKeterangan());
        return contentValues;
    }

    private ContentValues getContentValues(MenuCheckingGalpal menuCheckingGalpal){
        ContentValues contentValues=new ContentValues();
        contentValues.put(MenuCheckingGalpalTable.Cols.ID_MENU_F1_ENTRY_CHECKING,menuCheckingGalpal.getIdMenuCheckingGalpal());
        contentValues.put(MenuCheckingGalpalTable.Cols.ID_KUALIFIKASI_SURVEY,menuCheckingGalpal.getIdKualifikasiSurvey());
        contentValues.put(MenuCheckingGalpalTable.Cols.ID_MENU_F1,menuCheckingGalpal.getIdMenu());
        contentValues.put(MenuCheckingGalpalTable.Cols.IS_FILL,menuCheckingGalpal.isFill() ? 1 : 0);
        contentValues.put(MenuCheckingGalpalTable.Cols.IS_COMPLETE,menuCheckingGalpal.isComplete() ? 1 : 0);
        contentValues.put(MenuCheckingGalpalTable.Cols.IS_VERIFIED,menuCheckingGalpal.isVerified() ? 1 : 0);
        return contentValues;
    }

    private ContentValues getContentValues(MenuCheckingKompal menuCheckingKompal){
        ContentValues contentValues=new ContentValues();
        contentValues.put(MenuCheckingKompalTable.Cols.ID_MENU_F2_ENTRY_CHECKING,menuCheckingKompal.getIdMenuCheckingKompal());
        contentValues.put(MenuCheckingKompalTable.Cols.ID_KUALIFIKASI_SURVEY,menuCheckingKompal.getIdKualifikasiSurvey());
        contentValues.put(MenuCheckingKompalTable.Cols.ID_MENU_F2,menuCheckingKompal.getIdMenu());
        contentValues.put(MenuCheckingKompalTable.Cols.IS_FILL,menuCheckingKompal.isFill() ? 1 : 0);
        contentValues.put(MenuCheckingKompalTable.Cols.IS_COMPLETE,menuCheckingKompal.isComplete() ? 1 : 0);
        contentValues.put(MenuCheckingKompalTable.Cols.IS_VERIFIED,menuCheckingKompal.isVerified() ? 1 : 0);
        return contentValues;
    }

    private ContentValues getContentValues(MstPropinsi mstPropinsi){
        ContentValues contentValues=new ContentValues();
        contentValues.put(MstPropinsiTable.Cols.ID_PROPINSI, mstPropinsi.getId());
        contentValues.put(MstPropinsiTable.Cols.KODEBPS, mstPropinsi.getKodeBps());
        contentValues.put(MstPropinsiTable.Cols.NAMA, mstPropinsi.getNama());
        contentValues.put(MstPropinsiTable.Cols.KODEISO, mstPropinsi.getKodeiso());
        contentValues.put(MstPropinsiTable.Cols.IBUKOTA, mstPropinsi.getIbukota());
        contentValues.put(MstPropinsiTable.Cols.PULAU, mstPropinsi.getPulau());

        return contentValues;
    }

    private ContentValues getContentValues(MstKabupaten mstKabupaten){
        ContentValues contentValues=new ContentValues();
        contentValues.put(MstKabupatenTable.Cols.ID, mstKabupaten.getId());
        contentValues.put(MstKabupatenTable.Cols.NAMA, mstKabupaten.getNama());
        contentValues.put(MstKabupatenTable.Cols.IBU_KOTA, mstKabupaten.getIbuKota());
        contentValues.put(MstKabupatenTable.Cols.ID_PROPINSI, mstKabupaten.getId_propinsi());
        contentValues.put(MstKabupatenTable.Cols.IBUKOTAPROP, mstKabupaten.getIbuKotaPropinsi());
        contentValues.put(MstKabupatenTable.Cols.JMLPENDUDUK, mstKabupaten.getJumlahPenduduk());
        contentValues.put(MstKabupatenTable.Cols.KODEBPS, mstKabupaten.getKodebps());
        return contentValues;
    }

    private ContentValues getContentValues(MstAirPelayaran mstAirPelayaran){
        ContentValues contentValues=new ContentValues();
        contentValues.put(MstAirPelayaranTable.Cols.ID_MST_AIR_PELAYARAN,mstAirPelayaran.getIdMstAirPelayaran());
        contentValues.put(MstAirPelayaranTable.Cols.AIR_PELAYARAN,mstAirPelayaran.getAirPelayaran());
        return contentValues;
    }

    private static ContentValues getContentValues(MstArus mstArus){
        ContentValues contentValues=new ContentValues();
        contentValues.put(MstArusTable.Cols.ID_MST_ARUS,mstArus.getIdMstArus());
        contentValues.put(MstArusTable.Cols.ARUS,mstArus.getArus());
        return contentValues;
    }

    private static ContentValues getContentValues(MstGelombang mstGelombang){
        ContentValues contentValues=new ContentValues();
        contentValues.put(MstGelombangTable.Cols.ID_MST_GELOMBANG,mstGelombang.getIdMstGelombang());
        contentValues.put(MstGelombangTable.Cols.MST_GELOMBANG,mstGelombang.getMstGelombang());
        return contentValues;
    }

    private static ContentValues getContentValues(MstJarakKedalaman mstJarakKedalaman){
        ContentValues contentValues=new ContentValues();
        contentValues.put(MstJarakKedalamanTable.Cols.ID_MST_JARAK_KEDALAMAN,mstJarakKedalaman.getIdMstJarakKedalaman());
        contentValues.put(MstJarakKedalamanTable.Cols.JARAK_KEDALAMAN,mstJarakKedalaman.getJarakKedalaman());
        return contentValues;
    }

    private static ContentValues getContentValues(MstJenisProduksi mstJenisProduksi){
        ContentValues contentValues=new ContentValues();
        contentValues.put(MstJenisProduksiTable.Cols.ID_MST_JENIS_PRODUKSI,mstJenisProduksi.getIdMstJenisProduksi());
        contentValues.put(MstJenisProduksiTable.Cols.JENIS_PRODUKSI,mstJenisProduksi.getJenisProduksi());
        contentValues.put(MstJenisProduksiTable.Cols.KKI,mstJenisProduksi.getKki());
        return contentValues;
    }

    private static ContentValues getContentValues(MstPasangSurut mstPasangSurut){
        ContentValues contentValues=new ContentValues();
        contentValues.put(MstPasangSurutTable.Cols.ID_MST_PASANG_SURUT,mstPasangSurut.getIdMstPasangSurut());
        contentValues.put(MstPasangSurutTable.Cols.PASANG_SURUT,mstPasangSurut.getPasangSurut());
        return contentValues;
    }

    private static ContentValues getContentValues(MstSatuan mstSatuan){
        ContentValues contentValues=new ContentValues();
        contentValues.put(MstSatuanTable.Cols.ID_MST_SATUAN,mstSatuan.getIdMstSatuan());
        contentValues.put(MstSatuanTable.Cols.SATUAN,mstSatuan.getSatuan());
        return contentValues;
    }

    private static ContentValues getContentValues(MenuF1 menuF1){
        ContentValues contentValues=new ContentValues();
        contentValues.put(MenuF1Table.Cols.ID_MENU_F1,menuF1.getIdMenuF1());
        contentValues.put(MenuF1Table.Cols.NUMBER,menuF1.getNumber());
        contentValues.put(MenuF1Table.Cols.NAMA_MENU,menuF1.getNamaMenu());
        return contentValues;
    }

    private static ContentValues getContentValues(MenuF2 menuF2){
        ContentValues contentValues=new ContentValues();
        contentValues.put(MenuF2Table.Cols.ID_MENU_F2,menuF2.getIdMenuF2());
        contentValues.put(MenuF2Table.Cols.NUMBER,menuF2.getNumber());
        contentValues.put(MenuF2Table.Cols.NAMA_MENU,menuF2.getNamaMenu());
        return contentValues;
    }





    /*TEMPLATE CONTENT VALUE
    private static ContentValues getDammyContentValues(Dammy dammy){
        ContentValues contentValues=new ContentValues();
        contentValues.put(TABLE.Cols.,dammy.get);
        return contentValues;
    }
     */




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

    private CursorWrapperGal querya(String tableName, String whereClause, String[] whereArgs,String orderBy){

        Cursor cursor=mDatabase.query(
                tableName,
                null, // select all the column
                whereClause,
                whereArgs,
                null, //group by
                null, //having
                orderBy+" ASC"
        );

        return new CursorWrapperGal(cursor);
    }

    public File getPhotoFile(FormGalpal3 formGalpal3){
        File externalFilesDir=mContext.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        if(externalFilesDir==null){
            return null;
        }

        return new File(externalFilesDir,formGalpal3.getPhotoFileName());
    }

}
