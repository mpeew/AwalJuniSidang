package com.mpewpazi.android.awaljunisidang.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.mpewpazi.android.awaljunisidang.Form.FormGalpal1;
import com.mpewpazi.android.awaljunisidang.model.KualifikasiSurvey;
import com.mpewpazi.android.awaljunisidang.model.PeriodeSurvey;
import com.mpewpazi.android.awaljunisidang.model.Perusahaan;
import com.mpewpazi.android.awaljunisidang.model.SurveyAssignSurveyor;
import com.mpewpazi.android.awaljunisidang.model.User;

import static com.mpewpazi.android.awaljunisidang.database.DhSchema.*;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.UserTable;

/**
 * Created by mpewpazi on 4/27/16.
 */
public class CursorWrapperGal extends CursorWrapper{
    /**
     * Creates a cursor wrapper.
     *
     * @param cursor The underlying cursor to wrap.
     */
    public CursorWrapperGal(Cursor cursor) {
        super(cursor);
    }

    public User getUser(){
        String userid=getString(getColumnIndex(UserTable.Cols.USERID));
        String type=getString(getColumnIndex(UserTable.Cols.TYPE));
        String fullname=getString(getColumnIndex(UserTable.Cols.FULL_NAME));
        String email=getString(getColumnIndex(UserTable.Cols.EMAIL));
        String password=getString(getColumnIndex(UserTable.Cols.PASSWORD));
        // ada yang belum

        User user=new User();
        user.setUserId(userid);
        user.setType(type);
        user.setFullName(fullname);
        user.setEmail(email);
        user.setPassword(password);

        return user;
    }

    public SurveyAssignSurveyor getSurveyAssignSurveyor(){
        int idSurveyAssignSurveyor=getInt(getColumnIndex(SurveyAssignSurveyorTable.Cols.ID_SURVEY_ASSIGN_SURVEYOR));
        int idKualifikasiSurvey=getInt(getColumnIndex(SurveyAssignSurveyorTable.Cols.ID_KUALIFIKASI_SURVEY));
        String userId=getString(getColumnIndex(SurveyAssignSurveyorTable.Cols.USERID));
        //assign date
        //assign by

        SurveyAssignSurveyor surveyAssignSurveyor=new SurveyAssignSurveyor();
        surveyAssignSurveyor.setSurveyAssignSurveyorId(idSurveyAssignSurveyor);
        surveyAssignSurveyor.setKualifikasiSurveyId(idKualifikasiSurvey);
        surveyAssignSurveyor.setUserId(userId);

        return surveyAssignSurveyor;
    }

    public PeriodeSurvey getPeriodeSurvey(){
        int idPeriodeSurvey=getInt(getColumnIndex(PeriodeSurveyTable.Cols.ID_PERIODE));
        String tahunKualifikasi=getString(getColumnIndex(PeriodeSurveyTable.Cols.TAHUN_KUALIFIKASI));
        int isActivePeriod=getInt(getColumnIndex(PeriodeSurveyTable.Cols.IS_ACTIVE_PERIOD));
        int isDone=getInt(getColumnIndex(PeriodeSurveyTable.Cols.IS_DONE));
        String keterangan=getString(getColumnIndex(PeriodeSurveyTable.Cols.KETERANGAN));

        PeriodeSurvey periodeSurvey=new PeriodeSurvey();
        periodeSurvey.setPeriodeSurveyId(idPeriodeSurvey);
        periodeSurvey.setTahunKualifikasi(tahunKualifikasi);
        periodeSurvey.setActivePeriode(isActivePeriod);
        periodeSurvey.setDone(isDone);
        periodeSurvey.setKeterangan(keterangan);

        return periodeSurvey;
    }

    public Perusahaan getPerusahaan(){
        int idPerusahaan=getInt(getColumnIndex(PerusahaanTable.Cols.ID_PERUSAHAAN));
        String namaPerusahaan=getString(getColumnIndex(PerusahaanTable.Cols.NAMA_PERUSAHAAN));
        String industri=getString(getColumnIndex(PerusahaanTable.Cols.INDUSTRI));
        int isActive=getInt(getColumnIndex(PerusahaanTable.Cols.IS_ACTIV));

        Perusahaan perusahaan=new Perusahaan();
        perusahaan.setId(idPerusahaan);
        perusahaan.setNamaPerusahaan(namaPerusahaan);
        perusahaan.setIndustri(industri);
        perusahaan.setActive(isActive);

        return perusahaan;
    }

    public KualifikasiSurvey getKualifikasiSurvey(){
        int idKualifikasiSurvey=getInt(getColumnIndex(KualifikasiSurveyTable.Cols.ID_KUALIFIKASI_SURVEY));
        int idPerusahaan=getInt(getColumnIndex(KualifikasiSurveyTable.Cols.ID_PERUSAHAAN));
        int idPeriodeSurvey=getInt(getColumnIndex(KualifikasiSurveyTable.Cols.ID_PERIODE));
        int idGalangan=getInt(getColumnIndex(KualifikasiSurveyTable.Cols.ID_GALANGAN_KAPAL));

        KualifikasiSurvey kualifikasiSurvey=new KualifikasiSurvey();
        kualifikasiSurvey.setKualifikasiSurveyId(idKualifikasiSurvey);
        kualifikasiSurvey.setPerusahaanId(idPerusahaan);
        kualifikasiSurvey.setPeriodeSurveyId(idPeriodeSurvey);
        kualifikasiSurvey.setGalanganKapalId(idGalangan);

        return kualifikasiSurvey;
    }

    public FormGalpal1 getFormGalpal1(){
        int idIdentitasPerusahaan=getInt(getColumnIndex(PerusahaanIdentitasTable.Cols.ID_PERUSAHAAN_IDENTITAS));
        int idKualifikasiSurvey=getInt(getColumnIndex(PerusahaanIdentitasTable.Cols.ID_KUALIFIKASI_SURVEY));
        String statusKememilikanUsaha=getString(getColumnIndex(PerusahaanIdentitasTable.Cols.STATUS_KEPEMILIKAN_USAHA));
        String nomorTelepon=getString(getColumnIndex(PerusahaanIdentitasTable.Cols.TELEPON_PERUSAHAAN));
        String nomorFax=getString(getColumnIndex(PerusahaanIdentitasTable.Cols.FAX_PERUSAHAAN));
        String alamat=getString(getColumnIndex(PerusahaanIdentitasTable.Cols.ALAMAT_PERUSAHAAN));
        String kelurahan=getString(getColumnIndex(PerusahaanIdentitasTable.Cols.KELURAHAN_PERUSAHAAN));
        String kecamatan=getString(getColumnIndex(PerusahaanIdentitasTable.Cols.KECAMATAN_PERUSAHAAN));
        String propinsi=getString(getColumnIndex(PerusahaanIdentitasTable.Cols.ID_PROPINSI_PERUSAHAAN));
        String kabupaten_kota=getString(getColumnIndex(PerusahaanIdentitasTable.Cols.ID_KABUPATEN_PERUSAHAAN));
        String kodePos=getString(getColumnIndex(PerusahaanIdentitasTable.Cols.KODE_POS_PERUSAHAAN));
        String anggotaAsosiasi=getString(getColumnIndex(PerusahaanIdentitasTable.Cols.ANGGOTA_ASOSIASI));
        String kategoriPerusahaan=getString(getColumnIndex(PerusahaanIdentitasTable.Cols.KATEGORI_PERUSAHAAN));
        String cpNama=getString(getColumnIndex(PerusahaanIdentitasTable.Cols.CP_NAMA));
        String cpNo=getString(getColumnIndex(PerusahaanIdentitasTable.Cols.CP_NO));
        String cpJabatan=getString(getColumnIndex(PerusahaanIdentitasTable.Cols.CP_JABATAN));
        String cpEmail=getString(getColumnIndex(PerusahaanIdentitasTable.Cols.CP_EMAIL));
        String website=getString(getColumnIndex(PerusahaanIdentitasTable.Cols.WEBSITE));

        FormGalpal1 formGalpal1=new FormGalpal1();
        formGalpal1.setIdentitasPerusahaanId(idIdentitasPerusahaan);
        formGalpal1.setKualifikasiSurveyId(idKualifikasiSurvey);
        formGalpal1.setStatusKepemilikanUsaha(statusKememilikanUsaha);
        formGalpal1.setNomorTelepon(nomorTelepon);
        formGalpal1.setFax(nomorFax);
        formGalpal1.setAlamat(alamat);
        formGalpal1.setKelurahan(kelurahan);
        formGalpal1.setKecamatan(kecamatan);
        formGalpal1.setPropinsi(propinsi);
        formGalpal1.setKebupaten_kota(kabupaten_kota);
        formGalpal1.setKodePos(kodePos);
        formGalpal1.setAnggotaAsosiasi(anggotaAsosiasi);
        formGalpal1.setKategoriPerusahaan(kategoriPerusahaan);
        formGalpal1.setContactPerson(cpNama);
        formGalpal1.setNomorCp(cpNo);
        formGalpal1.setJabatan(cpJabatan);
        formGalpal1.setEmail(cpEmail);
        formGalpal1.setWebsite(website);

        return formGalpal1;
    }
}
