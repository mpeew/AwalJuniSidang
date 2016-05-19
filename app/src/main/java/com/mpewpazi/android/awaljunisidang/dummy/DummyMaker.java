package com.mpewpazi.android.awaljunisidang.dummy;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import com.mpewpazi.android.awaljunisidang.Form.FormGalpal1;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal3;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal4;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal6;
import com.mpewpazi.android.awaljunisidang.Form.FormKompal3a;
import com.mpewpazi.android.awaljunisidang.Form.FormKompal3b;
import com.mpewpazi.android.awaljunisidang.Form.FormKompal3c;
import com.mpewpazi.android.awaljunisidang.Form.FormKompal3d;
import com.mpewpazi.android.awaljunisidang.Form.SingleForm;
import com.mpewpazi.android.awaljunisidang.database.BaseDBHelper;
import com.mpewpazi.android.awaljunisidang.database.CursorWrapperGal;
import com.mpewpazi.android.awaljunisidang.masterData.Kabupaten;
import com.mpewpazi.android.awaljunisidang.masterData.Propinsi;
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

import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FG1PerusahaanIdentitasTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FG3GalanganKapalTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FG4TinjauanAreaTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FG6PeralatanKerjaLuarCraneTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FK3aJenisKapasitasProduksiTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FK3bJumlahProduksiTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FK3cSistemBerproduksiTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FK3dStandarMutuTableTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.KualifikasiSurveyTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.MenuCheckingGalpalTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.MenuCheckingKompalTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.MstKabupatenTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.MstPropinsiTable;
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

        Propinsi propinsi=new Propinsi();
        propinsi.setId(1);
        propinsi.setKodeBps(11);
        propinsi.setNama("Nangroe Aceh Darusalam");
        propinsi.setKodeiso("ID-AC");
        propinsi.setIbukota("Banda Aceh");
        propinsi.setPulau("Sumatra");
        addMstPropinsi(propinsi);

        Propinsi propinsia=new Propinsi();
        propinsia.setId(2);
        propinsia.setKodeBps(11);
        propinsia.setNama("Sumatra Barat");
        propinsia.setKodeiso("ID-AC");
        propinsia.setIbukota("Banda Aceh");
        propinsia.setPulau("Sumatra");
        addMstPropinsi(propinsia);

        Propinsi propinsib=new Propinsi();
        propinsib.setId(3);
        propinsib.setKodeBps(11);
        propinsib.setNama("DKI Jakarta");
        propinsib.setKodeiso("ID-AC");
        propinsib.setIbukota("Banda Aceh");
        propinsib.setPulau("Sumatra");
        addMstPropinsi(propinsib);

        Kabupaten kabupaten=new Kabupaten();
        kabupaten.setId(1);
        kabupaten.setNama("Meulaboh");
        kabupaten.setIbuKota("Kuningan");
        kabupaten.setId_propinsi(1);
        addMstKabupaten(kabupaten);

        Kabupaten kabupaten1=new Kabupaten();
        kabupaten1.setId(2);
        kabupaten1.setNama("Padang");
        kabupaten1.setId_propinsi(2);
        addMstKabupaten(kabupaten1);

        Kabupaten kabupaten2=new Kabupaten();
        kabupaten2.setId(3);
        kabupaten2.setNama("Jakarta Barat");
        kabupaten2.setId_propinsi(3);
        addMstKabupaten(kabupaten2);


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



        KualifikasiSurvey kualifikasiSurvey=new KualifikasiSurvey();
        kualifikasiSurvey.setKualifikasiSurveyId(20150001);
        kualifikasiSurvey.setPerusahaanId(1);
        kualifikasiSurvey.setPeriodeSurveyId(2014);
        kualifikasiSurvey.setGalanganKapalId(1);
        kualifikasiSurvey.setProgress(0);
        if(getPerusahaan(kualifikasiSurvey.getPerusahaanId()).getIndustri().equals("Galangan Kapal")){
            addGalpalForms(1,kualifikasiSurvey.getKualifikasiSurveyId());
            addMenuCheckingGalpals(kualifikasiSurvey.getKualifikasiSurveyId());
        }else{
            addKompalForms(1,kualifikasiSurvey.getKualifikasiSurveyId());
            addMenuCheckingKompals(kualifikasiSurvey.getKualifikasiSurveyId());
        }

        KualifikasiSurvey kualifikasiSurvey1=new KualifikasiSurvey();
        kualifikasiSurvey1.setKualifikasiSurveyId(2);
        kualifikasiSurvey1.setPerusahaanId(2);
        kualifikasiSurvey1.setPeriodeSurveyId(2014);
        kualifikasiSurvey1.setGalanganKapalId(1);
        if(getPerusahaan(kualifikasiSurvey1.getPerusahaanId()).getIndustri().equals("Galangan Kapal")) {
            addGalpalForms(2, kualifikasiSurvey1.getKualifikasiSurveyId());
            addMenuCheckingGalpals(kualifikasiSurvey1.getKualifikasiSurveyId());
        }else {
            addKompalForms(2, kualifikasiSurvey1.getKualifikasiSurveyId());
            addMenuCheckingKompals(kualifikasiSurvey1.getKualifikasiSurveyId());
        }

        KualifikasiSurvey kualifikasiSurvey2=new KualifikasiSurvey();
        kualifikasiSurvey2.setKualifikasiSurveyId(3);
        kualifikasiSurvey2.setPerusahaanId(3);
        kualifikasiSurvey2.setPeriodeSurveyId(2014);
        kualifikasiSurvey2.setGalanganKapalId(1);
        if(getPerusahaan(kualifikasiSurvey2.getPerusahaanId()).getIndustri().equals("Galangan Kapal")) {
            addGalpalForms(3, kualifikasiSurvey2.getKualifikasiSurveyId());
            addMenuCheckingGalpals(kualifikasiSurvey2.getKualifikasiSurveyId());
        }else {
            addMenuCheckingKompals(kualifikasiSurvey2.getKualifikasiSurveyId());
            addKompalForms(3, kualifikasiSurvey2.getKualifikasiSurveyId());
        }

        KualifikasiSurvey kualifikasiSurvey3=new KualifikasiSurvey();
        kualifikasiSurvey3.setKualifikasiSurveyId(4);
        kualifikasiSurvey3.setPerusahaanId(4);
        kualifikasiSurvey3.setPeriodeSurveyId(2014);
        kualifikasiSurvey3.setGalanganKapalId(1);
        if(getPerusahaan(kualifikasiSurvey3.getPerusahaanId()).getIndustri().equals("Galangan Kapal")) {
            addGalpalForms(4, kualifikasiSurvey3.getKualifikasiSurveyId());
            addMenuCheckingGalpals(kualifikasiSurvey3.getKualifikasiSurveyId());
        }else {
            addKompalForms(4, kualifikasiSurvey3.getKualifikasiSurveyId());
            addMenuCheckingKompals(kualifikasiSurvey3.getKualifikasiSurveyId());
        }

        addKualifikasiSurveya(kualifikasiSurvey);
        addKualifikasiSurveya(kualifikasiSurvey1);
        addKualifikasiSurveya(kualifikasiSurvey2);
        addKualifikasiSurveya(kualifikasiSurvey3);

        SurveyAssignSurveyor surveyAssignSurveyor=new SurveyAssignSurveyor();
        surveyAssignSurveyor.setSurveyAssignSurveyorId(1);
        surveyAssignSurveyor.setUserId("mpewpazi");
        surveyAssignSurveyor.setKualifikasiSurveyId(20150001);

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

    public List<Propinsi> getMstPropinsis(){
        List<Propinsi> propinsis=new ArrayList<>();
        CursorWrapperGal cursor=query(MstPropinsiTable.NAME,null,null);
        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                propinsis.add(cursor.getPropinsi());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        return propinsis;
    }

    public List<Kabupaten> getMstKabupaten(int idPropinsi){
        List<Kabupaten> kabupatens=new ArrayList<>();
        CursorWrapperGal cursor=querya(MstKabupatenTable.NAME,MstKabupatenTable.Cols.ID_PROPINSI+ "=?",
                new String[] {String.valueOf(idPropinsi)},MstKabupatenTable.Cols.NAMA);
        try{
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                kabupatens.add(cursor.getKabupaten());
                cursor.moveToNext();
            }
        }finally {
            cursor.close();
        }
        return kabupatens;
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

    private void addMstPropinsi(Propinsi propinsi){
        ContentValues values=getMstPropinsiContentValues(propinsi);
        int idPropinsi=propinsi.getId();

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

    private void addMstKabupaten(Kabupaten kabupaten){
        ContentValues values=getMstKabupatenContentValues(kabupaten);
        int idKabupaten=kabupaten.getId();

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

    public void addKualifikasiSurvey(KualifikasiSurvey kualifikasiSurvey) {
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

    public void addKualifikasiSurveya(KualifikasiSurvey kualifikasiSurvey) {
        ContentValues values=getKualifikasiSurveyContentValues(kualifikasiSurvey);
        int idKualifikasiSurvey=kualifikasiSurvey.getKualifikasiSurveyId();

        CursorWrapperGal cursor=query(KualifikasiSurveyTable.NAME,KualifikasiSurveyTable.Cols.ID_KUALIFIKASI_SURVEY+ "=?",
                new String[] {String.valueOf(idKualifikasiSurvey)});
        try{
            if(cursor.getCount()==0){
                mDatabase.insert(KualifikasiSurveyTable.NAME,null,values);
            }else{
            //    mDatabase.update(KualifikasiSurveyTable.NAME,values,KualifikasiSurveyTable.Cols.ID_KUALIFIKASI_SURVEY+" = ?",new String[]{String.valueOf(idKualifikasiSurvey)});
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

    public void addMenuCheckingGalpal(MenuCheckingGalpal menuCheckingGalpal){
        ContentValues values=getMenuCheckingGalpalContentValues(menuCheckingGalpal);
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

    private void addMenuCheckingGalpala(MenuCheckingGalpal menuCheckingGalpal){
        ContentValues values=getMenuCheckingGalpalContentValues(menuCheckingGalpal);
        String idMenuCheckingGalpal=String.valueOf(menuCheckingGalpal.getIdMenuCheckingGalpal());

        CursorWrapperGal cursor=query(MenuCheckingGalpalTable.NAME,MenuCheckingGalpalTable.Cols.ID_MENU_F1_ENTRY_CHECKING+ "=?",
                new String[] {idMenuCheckingGalpal});
        try{
            if(cursor.getCount()==0){
                mDatabase.insert(MenuCheckingGalpalTable.NAME,null,values);
            }else{
                //mDatabase.update(MenuCheckingGalpalTable.NAME,values,MenuCheckingGalpalTable.Cols.ID_MENU_F1_ENTRY_CHECKING+" = ?",new String[]{idMenuCheckingGalpal});
            }

        }finally {
            cursor.close();
        }
    }

    public void addMenuCheckingKompal(MenuCheckingKompal menuCheckingKompal){
        ContentValues values=getMenuCheckingKompalContentValues(menuCheckingKompal);
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

    private void addMenuCheckingKompala(MenuCheckingKompal menuCheckingKompal){
        ContentValues values=getMenuCheckingKompalContentValues(menuCheckingKompal);
        String idMenuCheckingKompal=String.valueOf(menuCheckingKompal.getIdMenuCheckingKompal());

        CursorWrapperGal cursor=query(MenuCheckingKompalTable.NAME,MenuCheckingKompalTable.Cols.ID_MENU_F2_ENTRY_CHECKING+ "=?",
                new String[] {idMenuCheckingKompal});
        try{
            if(cursor.getCount()==0){
                mDatabase.insert(MenuCheckingKompalTable.NAME,null,values);
            }else{
                //mDatabase.update(MenuCheckingKompalTable.NAME,values,MenuCheckingKompalTable.Cols.ID_MENU_F2_ENTRY_CHECKING+" = ?",new String[]{idMenuCheckingKompal});
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

    public void addFormGalpal1s(List<FormGalpal1> formGalpal1s){
        for(FormGalpal1 formGalpal1:formGalpal1s){
            addFormGalpal1(formGalpal1);
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

    public void addFormKompal3a(FormKompal3a formKompal3a){
        ContentValues values=getFormKompal3aContentValues(formKompal3a);
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

    public void addFormKompal3aa(FormKompal3a formKompal3a){
        ContentValues values=getFormKompal3aContentValues(formKompal3a);
        String formKompal3aId=formKompal3a.getIdJenisKapasitasProduksi().toString();

        CursorWrapperGal cursor=query(FK3aJenisKapasitasProduksiTable.NAME,FK3aJenisKapasitasProduksiTable.Cols.ID_F2_JENIS_KAPASITAS_PRODUKSI+ "=?",
                new String[] {formKompal3aId});
        try{
            if(cursor.getCount()==0){
                mDatabase.insert(FK3aJenisKapasitasProduksiTable.NAME,null,values);
            }else{
                //mDatabase.update(FK3aJenisKapasitasProduksiTable.NAME,values,FK3aJenisKapasitasProduksiTable.Cols.ID_F2_JENIS_KAPASITAS_PRODUKSI+" = ?",new String[]{formKompal3aId});
            }

        }finally {
            cursor.close();
        }
    }

    public void addFormKompal3b(FormKompal3b formKompal3b){
        ContentValues values=getFormKompal3bContentValues(formKompal3b);
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

    public void addFormKompal3ba(FormKompal3b formKompal3b){
        ContentValues values=getFormKompal3bContentValues(formKompal3b);
        String formKompal3bId=formKompal3b.getIdjumlahProduksi().toString();

        CursorWrapperGal cursor=query(FK3bJumlahProduksiTable.NAME,FK3bJumlahProduksiTable.Cols.ID_F2_JUMLAH_PRODUKSI+ "=?",
                new String[] {formKompal3bId});
        try{
            if(cursor.getCount()==0){
                mDatabase.insert(FK3bJumlahProduksiTable.NAME,null,values);
            }else{
                //mDatabase.update(FK3bJumlahProduksiTable.NAME,values,FK3bJumlahProduksiTable.Cols.ID_F2_JUMLAH_PRODUKSI+" = ?",new String[]{formKompal3bId});
            }

        }finally {
            cursor.close();
        }
    }

    public void addFormKompal3c(FormKompal3c formKompal3c){
        ContentValues values=getFormKompal3cContentValues(formKompal3c);
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

    public void addFormKompal3ca(FormKompal3c formKompal3c){
        ContentValues values=getFormKompal3cContentValues(formKompal3c);
        String formKompal3cId=formKompal3c.getIdSistemBerproduksi().toString();

        CursorWrapperGal cursor=query(FK3cSistemBerproduksiTable.NAME,FK3cSistemBerproduksiTable.Cols.ID_F2_SISTEM_BERPRODUKSI+ "=?",
                new String[] {formKompal3cId});
        try{
            if(cursor.getCount()==0){
                mDatabase.insert(FK3cSistemBerproduksiTable.NAME,null,values);
            }else{
               // mDatabase.update(FK3cSistemBerproduksiTable.NAME,values,FK3cSistemBerproduksiTable.Cols.ID_F2_SISTEM_BERPRODUKSI+" = ?",new String[]{formKompal3cId});
            }

        }finally {
            cursor.close();
        }
    }

    public void addFormKompal3d(FormKompal3d formKompal3d){
        ContentValues values=getFormKompal3dContentValues(formKompal3d);
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

    public void addFormKompal3da(FormKompal3d formKompal3d){
        ContentValues values=getFormKompal3dContentValues(formKompal3d);
        String formKompal3dId=formKompal3d.getIdStandarMutu().toString();

        CursorWrapperGal cursor=query(FK3dStandarMutuTableTable.NAME,FK3dStandarMutuTableTable.Cols.ID_F2_STANDAR_MUTU+ "=?",
                new String[] {formKompal3dId});
        try{
            if(cursor.getCount()==0){
                mDatabase.insert(FK3dStandarMutuTableTable.NAME,null,values);
            }else{
                //mDatabase.update(FK3dStandarMutuTableTable.NAME,values,FK3dStandarMutuTableTable.Cols.ID_F2_STANDAR_MUTU+" = ?",new String[]{formKompal3dId});
            }

        }finally {
            cursor.close();
        }
    }

    private void addGalpalForms(int formGalpalId,int kualifikasiSurveyId){
        FormGalpal1 formGalpal1=new FormGalpal1();
        formGalpal1.setIdentitasPerusahaanId(kualifikasiSurveyId);
        formGalpal1.setKualifikasiSurveyId(kualifikasiSurveyId);

        FormGalpal3 formGalpal3=new FormGalpal3();
        formGalpal3.setIdentitasUmumGalanganId(formGalpalId);
        formGalpal3.setKualifikasiSurveyId(kualifikasiSurveyId);

        FormGalpal4 formGalpal4=new FormGalpal4();
        formGalpal4.setTinjauanWilayahMaritimId(formGalpalId);
        formGalpal4.setKualifikasiSurveyId(kualifikasiSurveyId);


        addFormGalpal1a(formGalpal1);
        addFormGalpal3a(formGalpal3);
        addFormGalpal4a(formGalpal4);


    }

    private void addKompalForms(int formKompalId,int kualifikasiSurveyId){
        //form kompal3a,3b,3c,3d ditambahnya oleh user

    }

    private void addMenuCheckingGalpals(int kualifikasiSurveyId){
        for(int x=0;x<getGalpalForms().size();x++){
            MenuCheckingGalpal menuCheckingGalpal=new MenuCheckingGalpal();
            menuCheckingGalpal.setIdKualifikasiSurvey(kualifikasiSurveyId);
            menuCheckingGalpal.setIdMenu(x);
            addMenuCheckingGalpala(menuCheckingGalpal);
        }
    }

    private void addMenuCheckingKompals(int kualifikasiSurveyId){
        for(int x=0;x<getKompalForms().size();x++){
            MenuCheckingKompal menuCheckingKompal=new MenuCheckingKompal();
            menuCheckingKompal.setIdKualifikasiSurvey(kualifikasiSurveyId);
            menuCheckingKompal.setIdMenu(x);
            addMenuCheckingKompala(menuCheckingKompal);
        }
    }





    public void deleteFormGalpal6(FormGalpal6 formGalpal6){
        String formGalpal6Id=String.valueOf(formGalpal6.getIdPeralatanKerjaCrane());
        mDatabase.delete(FG6PeralatanKerjaLuarCraneTable.NAME,FG6PeralatanKerjaLuarCraneTable.Cols.ID_F1_PERALATAN_KERJA_LR_CRANE+ "=?",
                new String[] {formGalpal6Id});
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
        values.put(KualifikasiSurveyTable.Cols.PROGRESS,kualifikasiSurvey.getProgress());


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
        contentValues.put(FG6PeralatanKerjaLuarCraneTable.Cols.ID_F1_PERALATAN_KERJA_LR_CRANE ,formGalpal6.getIdPeralatanKerjaCrane().toString());
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



    private static ContentValues getFormKompal3aContentValues(FormKompal3a formKompal3a){
        ContentValues contentValues=new ContentValues();
        contentValues.put(FK3aJenisKapasitasProduksiTable.Cols.ID_F2_JENIS_KAPASITAS_PRODUKSI,formKompal3a.getIdJenisKapasitasProduksi().toString());
        contentValues.put(FK3aJenisKapasitasProduksiTable.Cols.ID_KUALIFIKASI_SURVEY,formKompal3a.getIdKualifikasiSurvey());
        contentValues.put(FK3aJenisKapasitasProduksiTable.Cols.JENIS_PRODUKSI,formKompal3a.getJenisProduksi());
        contentValues.put(FK3aJenisKapasitasProduksiTable.Cols.KAPASITAS_PRODUKSI,formKompal3a.getKapasitasProduksi());
        contentValues.put(FK3aJenisKapasitasProduksiTable.Cols.ID_MST_SATUAN,formKompal3a.getSatuan());

        return contentValues;
    }

    private static ContentValues getFormKompal3bContentValues(FormKompal3b formKompal3b){
        ContentValues contentValues=new ContentValues();
        contentValues.put(FK3bJumlahProduksiTable.Cols.ID_F2_JUMLAH_PRODUKSI,formKompal3b.getIdjumlahProduksi().toString());
        contentValues.put(FK3bJumlahProduksiTable.Cols.ID_KUALIFIKASI_SURVEY,formKompal3b.getIdKualifikasiSurvey());
        contentValues.put(FK3bJumlahProduksiTable.Cols.ID_F2_JENIS_KAPASITAS_PRODUKSI,formKompal3b.getJenisProduk());
        contentValues.put(FK3bJumlahProduksiTable.Cols.JUMLAH_PROD_NMIN1,formKompal3b.getJumlahProdThn1());
        contentValues.put(FK3bJumlahProduksiTable.Cols.JUMLAH_PROD_NMIN2,formKompal3b.getJumlahProdThn2());
        contentValues.put(FK3bJumlahProduksiTable.Cols.JUMLAH_PROD_NMIN3,formKompal3b.getJumlahProdThn3());
        contentValues.put(FK3bJumlahProduksiTable.Cols.JUMLAH_PROD_NMIN4,formKompal3b.getJumlahProdThn4());
        contentValues.put(FK3bJumlahProduksiTable.Cols.ID_MST_SATUAN,formKompal3b.getSatuan());
        contentValues.put(FK3bJumlahProduksiTable.Cols.NILAI_PRODUKSI_NMIN1,formKompal3b.getNilaiProduksiThn1());
        contentValues.put(FK3bJumlahProduksiTable.Cols.NILAI_PRODUKSI_NMIN2,formKompal3b.getNilaiProduksiThn2());
        contentValues.put(FK3bJumlahProduksiTable.Cols.NILAI_PRODUKSI_NMIN3,formKompal3b.getNilaiProduksiThn3());
        contentValues.put(FK3bJumlahProduksiTable.Cols.NILAI_PRODUKSI_NMIN4,formKompal3b.getNilaiProduksiThn4());
        contentValues.put(FK3bJumlahProduksiTable.Cols.KETERANGAN,formKompal3b.getKeterangan());
        return contentValues;
    }

    private static ContentValues getFormKompal3cContentValues(FormKompal3c formKompal3c){
        ContentValues contentValues=new ContentValues();
        contentValues.put(FK3cSistemBerproduksiTable.Cols.ID_F2_SISTEM_BERPRODUKSI,formKompal3c.getIdSistemBerproduksi().toString());
        contentValues.put(FK3cSistemBerproduksiTable.Cols.ID_KUALIFIKASI_SURVEY,formKompal3c.getIdKualifikasiSurvey());
        contentValues.put(FK3cSistemBerproduksiTable.Cols.NAMA_PRODUK,formKompal3c.getNamaProduk());
        contentValues.put(FK3cSistemBerproduksiTable.Cols.ID_MST_JENIS_PRODUKSI,formKompal3c.getSistemProduksi());
        contentValues.put(FK3cSistemBerproduksiTable.Cols.JUMLAH_PROD_NMIN1,formKompal3c.getJumlahProduksiThn1());
        contentValues.put(FK3cSistemBerproduksiTable.Cols.JUMLAH_PROD_NMIN2,formKompal3c.getJumlahProduksiThn2());
        contentValues.put(FK3cSistemBerproduksiTable.Cols.JUMLAH_PROD_NMIN3,formKompal3c.getJumlahProduksiThn3());
        contentValues.put(FK3cSistemBerproduksiTable.Cols.JUMLAH_PROD_NMIN4,formKompal3c.getJumlahProduksiThn4());
        return contentValues;
    }

    private static ContentValues getFormKompal3dContentValues(FormKompal3d formKompal3d){
        ContentValues contentValues=new ContentValues();
        contentValues.put(FK3dStandarMutuTableTable.Cols.ID_F2_STANDAR_MUTU,formKompal3d.getIdStandarMutu().toString());
        contentValues.put(FK3dStandarMutuTableTable.Cols.ID_KUALIFIKASI_SURVEY,formKompal3d.getIdKualifikasiSurvey());
        contentValues.put(FK3dStandarMutuTableTable.Cols.JENIS_STANDAR_MUTU,formKompal3d.getJenisStandarMutu());
        contentValues.put(FK3dStandarMutuTableTable.Cols.KETERANGAN,formKompal3d.getKeterangan());
        return contentValues;
    }

    private ContentValues getMenuCheckingGalpalContentValues(MenuCheckingGalpal menuCheckingGalpal){
        ContentValues contentValues=new ContentValues();
        contentValues.put(MenuCheckingGalpalTable.Cols.ID_MENU_F1_ENTRY_CHECKING,menuCheckingGalpal.getIdMenuCheckingGalpal().toString());
        contentValues.put(MenuCheckingGalpalTable.Cols.ID_KUALIFIKASI_SURVEY,menuCheckingGalpal.getIdKualifikasiSurvey());
        contentValues.put(MenuCheckingGalpalTable.Cols.ID_MENU_F1,menuCheckingGalpal.getIdMenu());
        contentValues.put(MenuCheckingGalpalTable.Cols.IS_FILL,menuCheckingGalpal.isFill() ? 1 : 0);
        contentValues.put(MenuCheckingGalpalTable.Cols.IS_COMPLETE,menuCheckingGalpal.isComplete() ? 1 : 0);
        contentValues.put(MenuCheckingGalpalTable.Cols.IS_VERIFIED,menuCheckingGalpal.isVerified() ? 1 : 0);
        return contentValues;
    }

    private ContentValues getMenuCheckingKompalContentValues(MenuCheckingKompal menuCheckingKompal){
        ContentValues contentValues=new ContentValues();
        contentValues.put(MenuCheckingKompalTable.Cols.ID_MENU_F2_ENTRY_CHECKING,menuCheckingKompal.getIdMenuCheckingKompal().toString());
        contentValues.put(MenuCheckingKompalTable.Cols.ID_KUALIFIKASI_SURVEY,menuCheckingKompal.getIdKualifikasiSurvey());
        contentValues.put(MenuCheckingKompalTable.Cols.ID_MENU_F2,menuCheckingKompal.getIdMenu());
        contentValues.put(MenuCheckingKompalTable.Cols.IS_FILL,menuCheckingKompal.isFill() ? 1 : 0);
        contentValues.put(MenuCheckingKompalTable.Cols.IS_COMPLETE,menuCheckingKompal.isComplete() ? 1 : 0);
        contentValues.put(MenuCheckingKompalTable.Cols.IS_VERIFIED,menuCheckingKompal.isVerified() ? 1 : 0);
        return contentValues;
    }

    private ContentValues getMstPropinsiContentValues(Propinsi propinsi){
        ContentValues contentValues=new ContentValues();
        contentValues.put(MstPropinsiTable.Cols.ID_PROPINSI,propinsi.getId());
        contentValues.put(MstPropinsiTable.Cols.KODEBPS,propinsi.getKodeBps());
        contentValues.put(MstPropinsiTable.Cols.NAMA,propinsi.getNama());
        contentValues.put(MstPropinsiTable.Cols.KODEISO,propinsi.getKodeiso());
        contentValues.put(MstPropinsiTable.Cols.IBUKOTA,propinsi.getIbukota());
        contentValues.put(MstPropinsiTable.Cols.PULAU,propinsi.getPulau());

        return contentValues;
    }

    private ContentValues getMstKabupatenContentValues(Kabupaten kabupaten){
        ContentValues contentValues=new ContentValues();
        contentValues.put(MstKabupatenTable.Cols.ID,kabupaten.getId());
        contentValues.put(MstKabupatenTable.Cols.NAMA,kabupaten.getNama());
        contentValues.put(MstKabupatenTable.Cols.IBU_KOTA,kabupaten.getIbuKota());
        contentValues.put(MstKabupatenTable.Cols.ID_PROPINSI,kabupaten.getId_propinsi());
        contentValues.put(MstKabupatenTable.Cols.IBUKOTAPROP,kabupaten.getIbuKotaPropinsi());
        contentValues.put(MstKabupatenTable.Cols.JMLPENDUDUK,kabupaten.getJumlahPenduduk());
        contentValues.put(MstKabupatenTable.Cols.KODEBPS,kabupaten.getKodebps());

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
