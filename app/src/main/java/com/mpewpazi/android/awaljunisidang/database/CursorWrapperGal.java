package com.mpewpazi.android.awaljunisidang.database;

import android.database.Cursor;
import android.database.CursorWrapper;

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
import com.mpewpazi.android.awaljunisidang.masterData.MenuF1;
import com.mpewpazi.android.awaljunisidang.masterData.MenuF2;
import com.mpewpazi.android.awaljunisidang.masterData.MstAirPelayaran;
import com.mpewpazi.android.awaljunisidang.masterData.MstArus;
import com.mpewpazi.android.awaljunisidang.masterData.MstGelombang;
import com.mpewpazi.android.awaljunisidang.masterData.MstJarakKedalaman;
import com.mpewpazi.android.awaljunisidang.masterData.MstJenisProduksi;
import com.mpewpazi.android.awaljunisidang.masterData.MstKabupaten;
import com.mpewpazi.android.awaljunisidang.masterData.MstPasangSurut;
import com.mpewpazi.android.awaljunisidang.masterData.MstPropinsi;
import com.mpewpazi.android.awaljunisidang.masterData.MstSatuan;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpalFoto;
import com.mpewpazi.android.awaljunisidang.model.KualifikasiSurvey;
import com.mpewpazi.android.awaljunisidang.model.MenuCheckingGalpal;
import com.mpewpazi.android.awaljunisidang.model.MenuCheckingKompal;
import com.mpewpazi.android.awaljunisidang.model.Notification;
import com.mpewpazi.android.awaljunisidang.model.PeriodeSurvey;
import com.mpewpazi.android.awaljunisidang.model.Perusahaan;
import com.mpewpazi.android.awaljunisidang.model.SurveyAssignSurveyor;
import com.mpewpazi.android.awaljunisidang.model.User;

import java.util.Date;
import java.util.UUID;

import static com.mpewpazi.android.awaljunisidang.database.DhSchema.*;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FG10PeralatanKerjaProduksiElektrikalMekanikal;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FG11PeralatanKerjaProduksiPengecatan;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FG1PerusahaanIdentitasTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FG3GalanganKapalTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FG4TinjauanAreaTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FG6PeralatanKerjaLuarCraneTable;
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
        perusahaan.setActive(isActive==1);

        return perusahaan;
    }

    public KualifikasiSurvey getKualifikasiSurvey(){
        int idKualifikasiSurvey=getInt(getColumnIndex(KualifikasiSurveyTable.Cols.ID_KUALIFIKASI_SURVEY));
        int idPerusahaan=getInt(getColumnIndex(KualifikasiSurveyTable.Cols.ID_PERUSAHAAN));
        int idPeriodeSurvey=getInt(getColumnIndex(KualifikasiSurveyTable.Cols.ID_PERIODE));
        int idGalangan=getInt(getColumnIndex(KualifikasiSurveyTable.Cols.ID_GALANGAN_KAPAL));
        int status=getInt(getColumnIndex(KualifikasiSurveyTable.Cols.STATUS));
        int progress=getInt(getColumnIndex(KualifikasiSurveyTable.Cols.PROGRESS));

        KualifikasiSurvey kualifikasiSurvey=new KualifikasiSurvey();
        kualifikasiSurvey.setKualifikasiSurveyId(idKualifikasiSurvey);
        kualifikasiSurvey.setPerusahaanId(idPerusahaan);
        kualifikasiSurvey.setPeriodeSurveyId(idPeriodeSurvey);
        kualifikasiSurvey.setGalanganKapalId(idGalangan);
        kualifikasiSurvey.setStatus(status);
        kualifikasiSurvey.setProgress(progress);

        return kualifikasiSurvey;
    }

    public FormGalpal1 getFormGalpal1(){
        int idIdentitasPerusahaan=getInt(getColumnIndex(FG1PerusahaanIdentitasTable.Cols.ID_PERUSAHAAN_IDENTITAS));
        int idKualifikasiSurvey=getInt(getColumnIndex(FG1PerusahaanIdentitasTable.Cols.ID_KUALIFIKASI_SURVEY));
        String statusKememilikanUsaha=getString(getColumnIndex(FG1PerusahaanIdentitasTable.Cols.STATUS_KEPEMILIKAN_USAHA));
        String nomorTelepon=getString(getColumnIndex(FG1PerusahaanIdentitasTable.Cols.TELEPON_PERUSAHAAN));
        String nomorFax=getString(getColumnIndex(FG1PerusahaanIdentitasTable.Cols.FAX_PERUSAHAAN));
        String alamat=getString(getColumnIndex(FG1PerusahaanIdentitasTable.Cols.ALAMAT_PERUSAHAAN));
        String kelurahan=getString(getColumnIndex(FG1PerusahaanIdentitasTable.Cols.KELURAHAN_PERUSAHAAN));
        String kecamatan=getString(getColumnIndex(FG1PerusahaanIdentitasTable.Cols.KECAMATAN_PERUSAHAAN));
        int idPropinsi=getInt(getColumnIndex(FG1PerusahaanIdentitasTable.Cols.ID_PROPINSI_PERUSAHAAN));
        int idKabupaten_kota=getInt(getColumnIndex(FG1PerusahaanIdentitasTable.Cols.ID_KABUPATEN_PERUSAHAAN));
        String kodePos=getString(getColumnIndex(FG1PerusahaanIdentitasTable.Cols.KODE_POS_PERUSAHAAN));
        String anggotaAsosiasi=getString(getColumnIndex(FG1PerusahaanIdentitasTable.Cols.ANGGOTA_ASOSIASI));
        String kategoriPerusahaan=getString(getColumnIndex(FG1PerusahaanIdentitasTable.Cols.KATEGORI_PERUSAHAAN));
        String cpNama=getString(getColumnIndex(FG1PerusahaanIdentitasTable.Cols.CP_NAMA));
        String cpNo=getString(getColumnIndex(FG1PerusahaanIdentitasTable.Cols.CP_NOMOR));
        String cpJabatan=getString(getColumnIndex(FG1PerusahaanIdentitasTable.Cols.CP_JABATAN));
        String cpEmail=getString(getColumnIndex(FG1PerusahaanIdentitasTable.Cols.CP_EMAIL));
        String website=getString(getColumnIndex(FG1PerusahaanIdentitasTable.Cols.WEBSITE));


        FormGalpal1 formGalpal1=new FormGalpal1();
        formGalpal1.setIdentitasPerusahaanId(idIdentitasPerusahaan);
        formGalpal1.setKualifikasiSurveyId(idKualifikasiSurvey);
        formGalpal1.setStatusKepemilikanUsaha(statusKememilikanUsaha);
        formGalpal1.setNomorTelepon(nomorTelepon);
        formGalpal1.setFax(nomorFax);
        formGalpal1.setAlamat(alamat);
        formGalpal1.setKelurahan(kelurahan);
        formGalpal1.setKecamatan(kecamatan);
        formGalpal1.setIdPropinsi(idPropinsi);
        formGalpal1.setIdKabupaten_kota(idKabupaten_kota);
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

    public FormGalpal3 getFormGalpal3(){
        int idGalanganKapal=getInt(getColumnIndex(FG3GalanganKapalTable.Cols.ID_GALANGAN_KAPAL));
        int idPerusahaan=getInt(getColumnIndex(FG3GalanganKapalTable.Cols.ID_PERUSAHAAN));
        int idKualifikasiSurvey=getInt(getColumnIndex(FG3GalanganKapalTable.Cols.ID_KUALIFIKASI_SURVEY));
        String namaGalangan=getString(getColumnIndex(FG3GalanganKapalTable.Cols.NAMA_GALANGAN));
        String nomorDock=getString(getColumnIndex(FG3GalanganKapalTable.Cols.NOMOR_DOCK));
        String nomorTelepon=getString(getColumnIndex(FG3GalanganKapalTable.Cols.TELEPON_GALANGAN));
        String faxGalangan=getString(getColumnIndex(FG3GalanganKapalTable.Cols.FAX_GALANGAN));
        String alamat=getString(getColumnIndex(FG3GalanganKapalTable.Cols.ALAMAT_GALANGAN));
        String kelurahan=getString(getColumnIndex(FG3GalanganKapalTable.Cols.KELURAHAN_GALANGAN));
        String kecamatan=getString(getColumnIndex(FG3GalanganKapalTable.Cols.KECAMATAN_GALANGAN));
        int provinsiId=getInt(getColumnIndex(FG3GalanganKapalTable.Cols.ID_PROPINSI_GALANGAN));
        int kabupatenId=getInt(getColumnIndex(FG3GalanganKapalTable.Cols.ID_KABUPATEN_GALANGAN));
        String kodePos=getString(getColumnIndex(FG3GalanganKapalTable.Cols.KODE_POS_GALANGAN));
        String latitude=getString(getColumnIndex(FG3GalanganKapalTable.Cols.LATITUDE));
        String longitude=getString(getColumnIndex(FG3GalanganKapalTable.Cols.LONGITUDE));
        String kategotiGalangan=getString(getColumnIndex(FG3GalanganKapalTable.Cols.KATEGORI_GALANGAN));
        String cpNama=getString(getColumnIndex(FG3GalanganKapalTable.Cols.CP_NAMA));
        String cpNo=getString(getColumnIndex(FG3GalanganKapalTable.Cols.CP_NO));
        String cpJabatan=getString(getColumnIndex(FG3GalanganKapalTable.Cols.CP_JABATAN));
        String cpEmail=getString(getColumnIndex(FG3GalanganKapalTable.Cols.CP_EMAIL));
        String imagePath=getString(getColumnIndex(FG3GalanganKapalTable.Cols.IMAGE_PATH));


        FormGalpal3 formGalpal3=new FormGalpal3();
        formGalpal3.setIdentitasUmumGalanganId(idGalanganKapal);
        formGalpal3.setKualifikasiSurveyId(idKualifikasiSurvey);
        formGalpal3.setPerusahaanId(idPerusahaan);
        formGalpal3.setNamaGalangan(namaGalangan);
        formGalpal3.setNomorDock(nomorDock);
        formGalpal3.setNomorTelepon(nomorTelepon);
        formGalpal3.setFax(faxGalangan);
        formGalpal3.setAlamat(alamat);
        formGalpal3.setKelurahan(kelurahan);
        formGalpal3.setKecamatan(kecamatan);
        formGalpal3.setIdPropinsi(provinsiId);
        formGalpal3.setIdKabupaten_kota(kabupatenId);
        formGalpal3.setKodePos(kodePos);
        formGalpal3.setLatitude(latitude);
        formGalpal3.setLongitude(longitude);
        formGalpal3.setKategoriGalangan(kategotiGalangan);
        formGalpal3.setContactPerson(cpNama);
        formGalpal3.setNomorCp(cpNo);
        formGalpal3.setJabatan(cpJabatan);
        formGalpal3.setEmail(cpEmail);
        formGalpal3.setImagePath(imagePath);


        return formGalpal3;
    }

    public FormGalpal4 getFormGalpal4(){
        int idTinjauanWilayahMaritim=getInt(getColumnIndex(FG4TinjauanAreaTable.Cols.ID_F1_TINJAUAN_AREA));
        int idKualifikasiSurvey=getInt(getColumnIndex(FG4TinjauanAreaTable.Cols.ID_KUALIFIKASI_SURVEY));
        int mstJarakKedalaman=getInt(getColumnIndex(FG4TinjauanAreaTable.Cols.ID_MST_JARAK_KEDALAMAN));
        int mstAirPelayaran=getInt(getColumnIndex(FG4TinjauanAreaTable.Cols.ID_MST_AIR_PELAYARAN));
        int mstPasangSurut=getInt(getColumnIndex(FG4TinjauanAreaTable.Cols.ID_MST_PASANG_SURUT));
        int mstArus=getInt(getColumnIndex(FG4TinjauanAreaTable.Cols.ID_MST_ARUS));
        int mstGelombang=getInt(getColumnIndex(FG4TinjauanAreaTable.Cols.ID_MST_GELOMBANG));
        int panjangWaterfornt=getInt(getColumnIndex(FG4TinjauanAreaTable.Cols.PANJANG_WATERFRONT));
        int luasLahan=getInt(getColumnIndex(FG4TinjauanAreaTable.Cols.LUAS_LAHAN));
        String ketersediaanLahan=getString(getColumnIndex(FG4TinjauanAreaTable.Cols.KETERSEDIAAN_LAHAN));
        String lahanProduktif=getString(getColumnIndex(FG4TinjauanAreaTable.Cols.LAHAN_PRODUKTIF));
        String lahanPemukiman=getString(getColumnIndex(FG4TinjauanAreaTable.Cols.LAHAN_PEMUKIMAN));
        String pasangSurut2=getString(getColumnIndex(FG4TinjauanAreaTable.Cols.PASANG_SURUT));
        String dayaDukung=getString(getColumnIndex(FG4TinjauanAreaTable.Cols.DAYA_DUKUNG));
        String kelandaian=getString(getColumnIndex(FG4TinjauanAreaTable.Cols.KELANDAIAAN));
        String dekatJalan=getString(getColumnIndex(FG4TinjauanAreaTable.Cols.DEKAT_JALAN));
        String kota=getString(getColumnIndex(FG4TinjauanAreaTable.Cols.KOTA));
        String interkoneksiAngkutan=getString(getColumnIndex(FG4TinjauanAreaTable.Cols.INTERKONEKSI_ANGKUTAN));
        String nilaiEkonomi=getString(getColumnIndex(FG4TinjauanAreaTable.Cols.NILAI_EKONOMI));
        String perkembanganWilayah=getString(getColumnIndex(FG4TinjauanAreaTable.Cols.PERKEMBANGAN_WILAYAH));
        String rutrw=getString(getColumnIndex(FG4TinjauanAreaTable.Cols.RUTWR));


        FormGalpal4 formGalpal4=new FormGalpal4();
        formGalpal4.setTinjauanWilayahMaritimId(idTinjauanWilayahMaritim);
        formGalpal4.setKualifikasiSurveyId(idKualifikasiSurvey);
        formGalpal4.setJarakKedalaman(mstJarakKedalaman);
        formGalpal4.setAirPelayaran(mstAirPelayaran);
        formGalpal4.setPasangSurutPerairan(mstPasangSurut);
        formGalpal4.setArus(mstArus);
        formGalpal4.setGelombang(mstGelombang);
        formGalpal4.setPanjangWaterfront(panjangWaterfornt);
        formGalpal4.setLuasLahan(luasLahan);
        formGalpal4.setKetersediaanLahan(ketersediaanLahan);
        formGalpal4.setLahanProduktif(lahanProduktif);
        formGalpal4.setLahanPemukiman(lahanPemukiman);
        formGalpal4.setPasangSurutDaratan(pasangSurut2);
        formGalpal4.setDayaDukung(dayaDukung);
        formGalpal4.setKelandaian(kelandaian);
        formGalpal4.setDekatJalan(dekatJalan);
        formGalpal4.setKota(kota);
        formGalpal4.setInterkoneksiAngkutan(interkoneksiAngkutan);
        formGalpal4.setNilaiEkonomi(nilaiEkonomi);
        formGalpal4.setPerkembanganWilayah(perkembanganWilayah);
        formGalpal4.setRutrw(rutrw);


        return formGalpal4;
    }

    public FormGalpal6 getFormGalpal6(){
        String idPeralatanKerjaCrane=getString(getColumnIndex(FG6PeralatanKerjaLuarCraneTable.Cols.ID_F1_PERALATAN_KERJA_LR_CRANE));
        int idServerPeralatanKerjaCrane=getInt(getColumnIndex(FG6PeralatanKerjaLuarCraneTable.Cols.ID_F1_PERALATAN_KERJA_LR_CRANE_SERVER));
        int idKualifikasiSurvey=getInt(getColumnIndex(FG6PeralatanKerjaLuarCraneTable.Cols.ID_KUALIFIKASI_SURVEY));
        String jenisMesin=getString(getColumnIndex(FG6PeralatanKerjaLuarCraneTable.Cols.JENIS_MESIN));
        int tahunPembuatan=getInt(getColumnIndex(FG6PeralatanKerjaLuarCraneTable.Cols.TAHUN_PEMBUATAN));
        String merek=getString(getColumnIndex(FG6PeralatanKerjaLuarCraneTable.Cols.MERK));
        int kapasitasTerpasang=getInt(getColumnIndex(FG6PeralatanKerjaLuarCraneTable.Cols.KAPASAITAS_TERPASANG));
        String stnKapasitasTerpasang=getString(getColumnIndex(FG6PeralatanKerjaLuarCraneTable.Cols.SATUAN_KAPASITAS_TERPASANG));
        int kapasitasTerpakai=getInt(getColumnIndex(FG6PeralatanKerjaLuarCraneTable.Cols.KAPASITAS_TERPAKAI));
        String stnKapasitasTerpakai=getString(getColumnIndex(FG6PeralatanKerjaLuarCraneTable.Cols.SATUAN_KAPASITAS_TERPAKAI));
        String dimensi=getString(getColumnIndex(FG6PeralatanKerjaLuarCraneTable.Cols.DIMENSI));
        int jumlah=getInt(getColumnIndex(FG6PeralatanKerjaLuarCraneTable.Cols.JUMLAH));
        String kondisi=getString(getColumnIndex(FG6PeralatanKerjaLuarCraneTable.Cols.KONDISI));
        String lokasi=getString(getColumnIndex(FG6PeralatanKerjaLuarCraneTable.Cols.LOKASI));
        String status=getString(getColumnIndex(FG6PeralatanKerjaLuarCraneTable.Cols.STATUS));
        String note=getString(getColumnIndex(FG6PeralatanKerjaLuarCraneTable.Cols.NOTE));

        FormGalpal6 formGalpal6=new FormGalpal6(UUID.fromString(idPeralatanKerjaCrane));
        formGalpal6.setFormServerId(idServerPeralatanKerjaCrane);
        formGalpal6.setKualifikasiSurveyId(idKualifikasiSurvey);
        formGalpal6.setJenisMesin(jenisMesin);
        formGalpal6.setTahunPembuatan(tahunPembuatan);
        formGalpal6.setMerek(merek);
        formGalpal6.setKapasitasTerpasang(kapasitasTerpasang);
        formGalpal6.setKapasitasTerpakai(kapasitasTerpakai);
        formGalpal6.setSatuanKapasitasTerpakai(stnKapasitasTerpakai);
        formGalpal6.setSatuanKapastiasTerpasang(stnKapasitasTerpasang);
        formGalpal6.setDimensi(dimensi);
        formGalpal6.setJumlah(jumlah);
        formGalpal6.setKondisi(kondisi);
        formGalpal6.setLokasi(lokasi);
        formGalpal6.setStatus(status);
        formGalpal6.setNote(note);

        return formGalpal6;
    }

    public FormGalpal7 getFormGalpal7(){
        String idPeralatanKerjaCrane=getString(getColumnIndex(FG7PeralatanKerjaLuarTugboatTable.Cols.ID_F1_PERALATAN_KERJA_LR_TUG));
        int idServerPeralatanKerjaCrane=getInt(getColumnIndex(FG7PeralatanKerjaLuarTugboatTable.Cols.ID_F1_PERALATAN_KERJA_LR_TUG_SERVER));
        int idKualifikasiSurvey=getInt(getColumnIndex(FG7PeralatanKerjaLuarTugboatTable.Cols.ID_KUALIFIKASI_SURVEY));
        String jenisMesin=getString(getColumnIndex(FG7PeralatanKerjaLuarTugboatTable.Cols.JENIS_MESIN));
        int tahunPembuatan=getInt(getColumnIndex(FG7PeralatanKerjaLuarTugboatTable.Cols.TAHUN_PEMBUATAN));
        String merek=getString(getColumnIndex(FG7PeralatanKerjaLuarTugboatTable.Cols.MERK));
        int kapasitasTerpasang=getInt(getColumnIndex(FG7PeralatanKerjaLuarTugboatTable.Cols.KAPASAITAS_TERPASANG));
        String stnKapasitasTerpasang=getString(getColumnIndex(FG7PeralatanKerjaLuarTugboatTable.Cols.SATUAN_KAPASITAS_TERPASANG));
        int kapasitasTerpakai=getInt(getColumnIndex(FG7PeralatanKerjaLuarTugboatTable.Cols.KAPASITAS_TERPAKAI));
        String stnKapasitasTerpakai=getString(getColumnIndex(FG7PeralatanKerjaLuarTugboatTable.Cols.SATUAN_KAPASITAS_TERPAKAI));
        String dimensi=getString(getColumnIndex(FG7PeralatanKerjaLuarTugboatTable.Cols.DIMENSI));
        int jumlah=getInt(getColumnIndex(FG7PeralatanKerjaLuarTugboatTable.Cols.JUMLAH));
        String kondisi=getString(getColumnIndex(FG7PeralatanKerjaLuarTugboatTable.Cols.KONDISI));
        String lokasi=getString(getColumnIndex(FG7PeralatanKerjaLuarTugboatTable.Cols.LOKASI));
        String status=getString(getColumnIndex(FG7PeralatanKerjaLuarTugboatTable.Cols.STATUS));
        String note=getString(getColumnIndex(FG7PeralatanKerjaLuarTugboatTable.Cols.NOTE));

        FormGalpal7 formGalpal7=new FormGalpal7(UUID.fromString(idPeralatanKerjaCrane));
        formGalpal7.setFormServerId(idServerPeralatanKerjaCrane);
        formGalpal7.setKualifikasiSurveyId(idKualifikasiSurvey);
        formGalpal7.setJenisPeralatan(jenisMesin);
        formGalpal7.setTahunPembuatan(tahunPembuatan);
        formGalpal7.setMerek(merek);
        formGalpal7.setKapasitasTerpasang(kapasitasTerpasang);
        formGalpal7.setKapasitasTerpakai(kapasitasTerpakai);
        formGalpal7.setSatuanKapasitasTerpakai(stnKapasitasTerpakai);
        formGalpal7.setSatuanKapastiasTerpasang(stnKapasitasTerpasang);
        formGalpal7.setDimensi(dimensi);
        formGalpal7.setJumlah(jumlah);
        formGalpal7.setKondisi(kondisi);
        formGalpal7.setLokasi(lokasi);
        formGalpal7.setStatus(status);
        formGalpal7.setNote(note);

        return formGalpal7;
    }


    public FormGalpal8 getFormGalpal8(){
        String idPeralatanKerjaCrane=getString(getColumnIndex(FG8PeralatanKerjaProduksiMesinTable.Cols.ID_F1_PERALATAN_KERJA_PROD_MESIN));
        int idServerPeralatanKerjaCrane=getInt(getColumnIndex(FG8PeralatanKerjaProduksiMesinTable.Cols.ID_F1_PERALATAN_KERJA_PROD_MESIN_SERVER));
        int idKualifikasiSurvey=getInt(getColumnIndex(FG8PeralatanKerjaProduksiMesinTable.Cols.ID_KUALIFIKASI_SURVEY));
        String jenisMesin=getString(getColumnIndex(FG8PeralatanKerjaProduksiMesinTable.Cols.JENIS_MESIN));
        int tahunPembuatan=getInt(getColumnIndex(FG8PeralatanKerjaProduksiMesinTable.Cols.TAHUN_PEMBUATAN));
        String merek=getString(getColumnIndex(FG8PeralatanKerjaProduksiMesinTable.Cols.MERK));
        int kapasitasTerpasang=getInt(getColumnIndex(FG8PeralatanKerjaProduksiMesinTable.Cols.KAPASAITAS_TERPASANG));
        String stnKapasitasTerpasang=getString(getColumnIndex(FG8PeralatanKerjaProduksiMesinTable.Cols.SATUAN_KAPASITAS_TERPASANG));
        int kapasitasTerpakai=getInt(getColumnIndex(FG8PeralatanKerjaProduksiMesinTable.Cols.KAPASITAS_TERPAKAI));
        String stnKapasitasTerpakai=getString(getColumnIndex(FG8PeralatanKerjaProduksiMesinTable.Cols.SATUAN_KAPASITAS_TERPAKAI));
        String dimensi=getString(getColumnIndex(FG8PeralatanKerjaProduksiMesinTable.Cols.DIMENSI));
        int jumlah=getInt(getColumnIndex(FG8PeralatanKerjaProduksiMesinTable.Cols.JUMLAH));
        String kondisi=getString(getColumnIndex(FG8PeralatanKerjaProduksiMesinTable.Cols.KONDISI));
        String lokasi=getString(getColumnIndex(FG8PeralatanKerjaProduksiMesinTable.Cols.LOKASI));
        String status=getString(getColumnIndex(FG8PeralatanKerjaProduksiMesinTable.Cols.STATUS));
        String note=getString(getColumnIndex(FG8PeralatanKerjaProduksiMesinTable.Cols.NOTE));

        FormGalpal8 formGalpal8=new FormGalpal8(UUID.fromString(idPeralatanKerjaCrane));
        formGalpal8.setFormServerId(idServerPeralatanKerjaCrane);
        formGalpal8.setKualifikasiSurveyId(idKualifikasiSurvey);
        formGalpal8.setJenisMesin(jenisMesin);
        formGalpal8.setTahunPembuatan(tahunPembuatan);
        formGalpal8.setMerek(merek);
        formGalpal8.setKapasitasTerpasang(kapasitasTerpasang);
        formGalpal8.setKapasitasTerpakai(kapasitasTerpakai);
        formGalpal8.setSatuanKapasitasTerpakai(stnKapasitasTerpakai);
        formGalpal8.setSatuanKapastiasTerpasang(stnKapasitasTerpasang);
        formGalpal8.setDimensi(dimensi);
        formGalpal8.setJumlah(jumlah);
        formGalpal8.setKondisi(kondisi);
        formGalpal8.setLokasi(lokasi);
        formGalpal8.setStatus(status);
        formGalpal8.setNote(note);

        return formGalpal8;
    }

    public FormGalpal9 getFormGalpal9(){
        String idPeralatanKerjaCrane=getString(getColumnIndex(FG9PeralatanKerjaProduksiKontruksi.Cols.ID_F1_PERALATAN_KERJA_PRODUKSI_KONTRUKSI));
        int idServerPeralatanKerjaCrane=getInt(getColumnIndex(FG9PeralatanKerjaProduksiKontruksi.Cols.ID_F1_PERALATAN_KERJA_PRODUKSI_KONTRUKSI_SERVER));
        int idKualifikasiSurvey=getInt(getColumnIndex(FG9PeralatanKerjaProduksiKontruksi.Cols.ID_KUALIFIKASI_SURVEY));
        String jenisMesin=getString(getColumnIndex(FG9PeralatanKerjaProduksiKontruksi.Cols.JENIS_MESIN));
        int tahunPembuatan=getInt(getColumnIndex(FG9PeralatanKerjaProduksiKontruksi.Cols.TAHUN_PEMBUATAN));
        String merek=getString(getColumnIndex(FG9PeralatanKerjaProduksiKontruksi.Cols.MERK));
        int kapasitasTerpasang=getInt(getColumnIndex(FG9PeralatanKerjaProduksiKontruksi.Cols.KAPASAITAS_TERPASANG));
        String stnKapasitasTerpasang=getString(getColumnIndex(FG9PeralatanKerjaProduksiKontruksi.Cols.SATUAN_KAPASITAS_TERPASANG));
        int kapasitasTerpakai=getInt(getColumnIndex(FG9PeralatanKerjaProduksiKontruksi.Cols.KAPASITAS_TERPAKAI));
        String stnKapasitasTerpakai=getString(getColumnIndex(FG9PeralatanKerjaProduksiKontruksi.Cols.SATUAN_KAPASITAS_TERPAKAI));
        String dimensi=getString(getColumnIndex(FG9PeralatanKerjaProduksiKontruksi.Cols.DIMENSI));
        int jumlah=getInt(getColumnIndex(FG9PeralatanKerjaProduksiKontruksi.Cols.JUMLAH));
        String kondisi=getString(getColumnIndex(FG9PeralatanKerjaProduksiKontruksi.Cols.KONDISI));
        String lokasi=getString(getColumnIndex(FG9PeralatanKerjaProduksiKontruksi.Cols.LOKASI));
        String status=getString(getColumnIndex(FG9PeralatanKerjaProduksiKontruksi.Cols.STATUS));
        String note=getString(getColumnIndex(FG9PeralatanKerjaProduksiKontruksi.Cols.NOTE));

        FormGalpal9 formGalpal9=new FormGalpal9(UUID.fromString(idPeralatanKerjaCrane));
        formGalpal9.setFormServerId(idServerPeralatanKerjaCrane);
        formGalpal9.setKualifikasiSurveyId(idKualifikasiSurvey);
        formGalpal9.setJenisMesin(jenisMesin);
        formGalpal9.setTahunPembuatan(tahunPembuatan);
        formGalpal9.setMerek(merek);
        formGalpal9.setKapasitasTerpasang(kapasitasTerpasang);
        formGalpal9.setKapasitasTerpakai(kapasitasTerpakai);
        formGalpal9.setSatuanKapasitasTerpakai(stnKapasitasTerpakai);
        formGalpal9.setSatuanKapastiasTerpasang(stnKapasitasTerpasang);
        formGalpal9.setDimensi(dimensi);
        formGalpal9.setJumlah(jumlah);
        formGalpal9.setKondisi(kondisi);
        formGalpal9.setLokasi(lokasi);
        formGalpal9.setStatus(status);
        formGalpal9.setNote(note);

        return formGalpal9;
    }

    public FormGalpal10 getFormGalpal10(){
        String idPeralatanKerjaCrane=getString(getColumnIndex(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.ID_F1_PERALATAN_KERJA_PRODUKSI_ELMEK));
        int idServerPeralatanKerjaCrane=getInt(getColumnIndex(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.ID_F1_PERALATAN_KERJA_PRODUKSI_ELMEK_SERVER));
        int idKualifikasiSurvey=getInt(getColumnIndex(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.ID_KUALIFIKASI_SURVEY));
        String jenisMesin=getString(getColumnIndex(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.JENIS_MESIN));
        int tahunPembuatan=getInt(getColumnIndex(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.TAHUN_PEMBUATAN));
        String merek=getString(getColumnIndex(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.MERK));
        int kapasitasTerpasang=getInt(getColumnIndex(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.KAPASAITAS_TERPASANG));
        String stnKapasitasTerpasang=getString(getColumnIndex(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.SATUAN_KAPASITAS_TERPASANG));
        int kapasitasTerpakai=getInt(getColumnIndex(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.KAPASITAS_TERPAKAI));
        String stnKapasitasTerpakai=getString(getColumnIndex(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.SATUAN_KAPASITAS_TERPAKAI));
        String dimensi=getString(getColumnIndex(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.DIMENSI));
        int jumlah=getInt(getColumnIndex(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.JUMLAH));
        String kondisi=getString(getColumnIndex(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.KONDISI));
        String lokasi=getString(getColumnIndex(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.LOKASI));
        String status=getString(getColumnIndex(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.STATUS));
        String note=getString(getColumnIndex(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.NOTE));

        FormGalpal10 formGalpal10=new FormGalpal10(UUID.fromString(idPeralatanKerjaCrane));
        formGalpal10.setFormServerId(idServerPeralatanKerjaCrane);
        formGalpal10.setKualifikasiSurveyId(idKualifikasiSurvey);
        formGalpal10.setJenisMesin(jenisMesin);
        formGalpal10.setTahunPembuatan(tahunPembuatan);
        formGalpal10.setMerek(merek);
        formGalpal10.setKapasitasTerpasang(kapasitasTerpasang);
        formGalpal10.setKapasitasTerpakai(kapasitasTerpakai);
        formGalpal10.setSatuanKapasitasTerpakai(stnKapasitasTerpakai);
        formGalpal10.setSatuanKapastiasTerpasang(stnKapasitasTerpasang);
        formGalpal10.setDimensi(dimensi);
        formGalpal10.setJumlah(jumlah);
        formGalpal10.setKondisi(kondisi);
        formGalpal10.setLokasi(lokasi);
        formGalpal10.setStatus(status);
        formGalpal10.setNote(note);

        return formGalpal10;
    }

    public FormGalpal11 getFormGalpal11(){
        String idPeralatanKerjaCrane=getString(getColumnIndex(FG11PeralatanKerjaProduksiPengecatan.Cols.ID_F1_PERALATAN_KERJA_PRODUKSI_CAT));
        int idServerPeralatanKerjaCrane=getInt(getColumnIndex(FG11PeralatanKerjaProduksiPengecatan.Cols.ID_F1_PERALATAN_KERJA_PRODUKSI_CAT_SERVER));
        int idKualifikasiSurvey=getInt(getColumnIndex(FG11PeralatanKerjaProduksiPengecatan.Cols.ID_KUALIFIKASI_SURVEY));
        String jenisMesin=getString(getColumnIndex(FG11PeralatanKerjaProduksiPengecatan.Cols.JENIS_MESIN));
        int tahunPembuatan=getInt(getColumnIndex(FG11PeralatanKerjaProduksiPengecatan.Cols.TAHUN_PEMBUATAN));
        String merek=getString(getColumnIndex(FG11PeralatanKerjaProduksiPengecatan.Cols.MERK));
        int kapasitasTerpasang=getInt(getColumnIndex(FG11PeralatanKerjaProduksiPengecatan.Cols.KAPASAITAS_TERPASANG));
        String stnKapasitasTerpasang=getString(getColumnIndex(FG11PeralatanKerjaProduksiPengecatan.Cols.SATUAN_KAPASITAS_TERPASANG));
        int kapasitasTerpakai=getInt(getColumnIndex(FG11PeralatanKerjaProduksiPengecatan.Cols.KAPASITAS_TERPAKAI));
        String stnKapasitasTerpakai=getString(getColumnIndex(FG11PeralatanKerjaProduksiPengecatan.Cols.SATUAN_KAPASITAS_TERPAKAI));
        String dimensi=getString(getColumnIndex(FG11PeralatanKerjaProduksiPengecatan.Cols.DIMENSI));
        int jumlah=getInt(getColumnIndex(FG11PeralatanKerjaProduksiPengecatan.Cols.JUMLAH));
        String kondisi=getString(getColumnIndex(FG11PeralatanKerjaProduksiPengecatan.Cols.KONDISI));
        String lokasi=getString(getColumnIndex(FG11PeralatanKerjaProduksiPengecatan.Cols.LOKASI));
        String status=getString(getColumnIndex(FG11PeralatanKerjaProduksiPengecatan.Cols.STATUS));
        String note=getString(getColumnIndex(FG11PeralatanKerjaProduksiPengecatan.Cols.NOTE));

        FormGalpal11 formGalpal11=new FormGalpal11(UUID.fromString(idPeralatanKerjaCrane));
        formGalpal11.setFormServerId(idServerPeralatanKerjaCrane);
        formGalpal11.setKualifikasiSurveyId(idKualifikasiSurvey);
        formGalpal11.setJenisMesin(jenisMesin);
        formGalpal11.setTahunPembuatan(tahunPembuatan);
        formGalpal11.setMerek(merek);
        formGalpal11.setKapasitasTerpasang(kapasitasTerpasang);
        formGalpal11.setKapasitasTerpakai(kapasitasTerpakai);
        formGalpal11.setSatuanKapasitasTerpakai(stnKapasitasTerpakai);
        formGalpal11.setSatuanKapastiasTerpasang(stnKapasitasTerpasang);
        formGalpal11.setDimensi(dimensi);
        formGalpal11.setJumlah(jumlah);
        formGalpal11.setKondisi(kondisi);
        formGalpal11.setLokasi(lokasi);
        formGalpal11.setStatus(status);
        formGalpal11.setNote(note);

        return formGalpal11;
    }

    public FormGalpalFoto getFormGalpalFoto(){
        String id=getString(getColumnIndex(FormGalpalFotoTable.Cols.ID_F1_FOTO_GALANGAN));
        int idServer=getInt(getColumnIndex(FormGalpalFotoTable.Cols.ID_F1_FOTO_GALANGAN_SERVER));
        int idKualifikasiSurvey=getInt(getColumnIndex(FormGalpalFotoTable.Cols.ID_KUALIFIKASI_SURVEY));
        int idPeriode=getInt(getColumnIndex(FormGalpalFotoTable.Cols.ID_PERIODE));
        String namaFoto=getString(getColumnIndex(FormGalpalFotoTable.Cols.NAMA_FOTO));
        String fotoGalangan=getString(getColumnIndex(FormGalpalFotoTable.Cols.FOTO_GALANGAN));
        String fotoUrl=getString(getColumnIndex(FormGalpalFotoTable.Cols.FOTO_URL));
        String imagePath=getString(getColumnIndex(FormGalpalFotoTable.Cols.IMAGE_PATH));
        int isFetchFromServer=getInt(getColumnIndex(FormGalpalFotoTable.Cols.IS_FETCH_FROM_SERVER));

        FormGalpalFoto foto=new FormGalpalFoto(UUID.fromString(id));
        foto.setFormServerId(idServer);
        foto.setKualifikasiSurveyId(idKualifikasiSurvey);
        foto.setIdPeriode(idPeriode);
        foto.setNamaFoto(namaFoto);
        foto.setFotoGalangan(fotoGalangan);
        foto.setFotoUrl(fotoUrl);
        foto.setImagePath(imagePath);
        foto.setFetchFromServer(isFetchFromServer==1);

        return foto;
    }

    public FormKompal3a getFormKompal3a(){
        String idJenisKapasitasProduksi=getString(getColumnIndex(FK3aJenisKapasitasProduksiTable.Cols.ID_F2_JENIS_KAPASITAS_PRODUKSI));
        int idServerJenisKapasitasProduksi=getInt(getColumnIndex(FK3aJenisKapasitasProduksiTable.Cols.ID_F2_JENIS_KAPASITAS_PRODUKSI_SERVER));
        int idKualifikasiSurvey=getInt(getColumnIndex(FK3aJenisKapasitasProduksiTable.Cols.ID_KUALIFIKASI_SURVEY));
        String jenisProduksi=getString(getColumnIndex(FK3aJenisKapasitasProduksiTable.Cols.JENIS_PRODUKSI));
        int satuan=getInt(getColumnIndex(FK3aJenisKapasitasProduksiTable.Cols.ID_MST_SATUAN));
        String note=getString(getColumnIndex(FK3aJenisKapasitasProduksiTable.Cols.NOTE));

        FormKompal3a formKompal3a=new FormKompal3a(UUID.fromString(idJenisKapasitasProduksi));
        formKompal3a.setFormServerId(idServerJenisKapasitasProduksi);
        formKompal3a.setKualifikasiSurveyId(idKualifikasiSurvey);
        formKompal3a.setJenisProduksi(jenisProduksi);
        formKompal3a.setSatuan(satuan);
        formKompal3a.setNote(note);

        return formKompal3a;
    }

    public FormKompal3b getFormKompal3b(){
        String idJumlahProduksi=getString(getColumnIndex(FK3bJumlahProduksiTable.Cols.ID_F2_JUMLAH_PRODUKSI));
        int idServerJumlahProduksi=getInt(getColumnIndex(FK3bJumlahProduksiTable.Cols.ID_F2_JUMLAH_PRODUKSI_SERVER));
        int idKualifikasiSurvey=getInt(getColumnIndex(FK3bJumlahProduksiTable.Cols.ID_KUALIFIKASI_SURVEY));
        int jenisProduk=getInt(getColumnIndex(FK3bJumlahProduksiTable.Cols.ID_F2_JENIS_KAPASITAS_PRODUKSI));
        int jumlahProdthn1=getInt(getColumnIndex(FK3bJumlahProduksiTable.Cols.JUMLAH_PROD_NMIN1));
        int jumlahProdthn2=getInt(getColumnIndex(FK3bJumlahProduksiTable.Cols.JUMLAH_PROD_NMIN2));
        int jumlahProdthn3=getInt(getColumnIndex(FK3bJumlahProduksiTable.Cols.JUMLAH_PROD_NMIN3));
        int jumlahProdthn4=getInt(getColumnIndex(FK3bJumlahProduksiTable.Cols.JUMLAH_PROD_NMIN4));
        int satuan=getInt(getColumnIndex(FK3bJumlahProduksiTable.Cols.ID_MST_SATUAN));
        int nilaiProduksiThn1=getInt(getColumnIndex(FK3bJumlahProduksiTable.Cols.NILAI_PRODUKSI_NMIN1));
        int nilaiProduksiThn2=getInt(getColumnIndex(FK3bJumlahProduksiTable.Cols.NILAI_PRODUKSI_NMIN2));
        int nilaiProduksiThn3=getInt(getColumnIndex(FK3bJumlahProduksiTable.Cols.NILAI_PRODUKSI_NMIN3));
        int nilaiProduksiThn4=getInt(getColumnIndex(FK3bJumlahProduksiTable.Cols.NILAI_PRODUKSI_NMIN4));
        String keterangan=getString(getColumnIndex(FK3bJumlahProduksiTable.Cols.KETERANGAN));
        String note=getString(getColumnIndex(FK3bJumlahProduksiTable.Cols.NOTE));

        FormKompal3b formKompal3b=new FormKompal3b(UUID.fromString(idJumlahProduksi));
        formKompal3b.setFormServerId(idServerJumlahProduksi);
        formKompal3b.setKualifikasiSurveyId(idKualifikasiSurvey);
        formKompal3b.setJenisProdukId(jenisProduk);
        formKompal3b.setJumlahProdThn1(jumlahProdthn1);
        formKompal3b.setJumlahProdThn2(jumlahProdthn2);
        formKompal3b.setJumlahProdThn3(jumlahProdthn3);
        formKompal3b.setJumlahProdThn4(jumlahProdthn4);
        formKompal3b.setSatuanId(satuan);
        formKompal3b.setNilaiProduksiThn1(nilaiProduksiThn1);
        formKompal3b.setNilaiProduksiThn2(nilaiProduksiThn2);
        formKompal3b.setNilaiProduksiThn3(nilaiProduksiThn3);
        formKompal3b.setNilaiProduksiThn4(nilaiProduksiThn4);
        formKompal3b.setKeterangan(keterangan);
        formKompal3b.setNote(note);

        return formKompal3b;
    }

    public FormKompal3c getFormKompal3c(){
        String idSistemBerproduksi=getString(getColumnIndex(FK3cSistemBerproduksiTable.Cols.ID_F2_SISTEM_BERPRODUKSI));
        int idServerSistemBerproduksi=getInt(getColumnIndex(FK3cSistemBerproduksiTable.Cols.ID_F2_SISTEM_BERPRODUKSI_SERVER));
        int idKualifikasiSurvey=getInt(getColumnIndex(FK3cSistemBerproduksiTable.Cols.ID_KUALIFIKASI_SURVEY));
        String namaProduk=getString(getColumnIndex(FK3cSistemBerproduksiTable.Cols.NAMA_PRODUK));
        int sistemProduksi=getInt(getColumnIndex(FK3cSistemBerproduksiTable.Cols.ID_MST_JENIS_PRODUKSI));
        int jumlahProdthn1=getInt(getColumnIndex(FK3cSistemBerproduksiTable.Cols.JUMLAH_PROD_NMIN1));
        int jumlahProdthn2=getInt(getColumnIndex(FK3cSistemBerproduksiTable.Cols.JUMLAH_PROD_NMIN2));
        int jumlahProdthn3=getInt(getColumnIndex(FK3cSistemBerproduksiTable.Cols.JUMLAH_PROD_NMIN3));
        int jumlahProdthn4=getInt(getColumnIndex(FK3cSistemBerproduksiTable.Cols.JUMLAH_PROD_NMIN4));
        String note=getString(getColumnIndex(FK3cSistemBerproduksiTable.Cols.NOTE));

        FormKompal3c formKompal3c=new FormKompal3c(UUID.fromString(idSistemBerproduksi));
        formKompal3c.setFormServerId(idServerSistemBerproduksi);
        formKompal3c.setKualifikasiSurveyId(idKualifikasiSurvey);
        formKompal3c.setNamaProduk(namaProduk);
        formKompal3c.setSistemProduksi(sistemProduksi);
        formKompal3c.setJumlahProduksiThn1(jumlahProdthn1);
        formKompal3c.setJumlahProduksiThn2(jumlahProdthn2);
        formKompal3c.setJumlahProduksiThn3(jumlahProdthn3);
        formKompal3c.setJumlahProduksiThn4(jumlahProdthn4);
        formKompal3c.setNote(note);

        return formKompal3c;
    }

    public FormKompal3d getFormKompal3d(){
        String idStandarMutu=getString(getColumnIndex(FK3dStandarMutuTableTable.Cols.ID_F2_STANDAR_MUTU));
        int idServerStandarMutu=getInt(getColumnIndex(FK3dStandarMutuTableTable.Cols.ID_F2_STANDAR_MUTU_SERVER));
        int idKualifikasiSurvey=getInt(getColumnIndex(FK3dStandarMutuTableTable.Cols.ID_KUALIFIKASI_SURVEY));
        String jenisStandarMutu=getString(getColumnIndex(FK3dStandarMutuTableTable.Cols.JENIS_STANDAR_MUTU));
        String keterangan=getString(getColumnIndex(FK3dStandarMutuTableTable.Cols.KETERANGAN));
        String note=getString(getColumnIndex(FK3dStandarMutuTableTable.Cols.NOTE));

        FormKompal3d formKompal3d=new FormKompal3d(UUID.fromString(idStandarMutu));
        formKompal3d.setFormServerId(idServerStandarMutu);
        formKompal3d.setKualifikasiSurveyId(idKualifikasiSurvey);
        formKompal3d.setJenisStandarMutu(jenisStandarMutu);
        formKompal3d.setKeterangan(keterangan);
        formKompal3d.setNote(note);

        return formKompal3d;
    }

    public MenuCheckingGalpal getMenuCheckingGalpal(){
        int idMenuCheckingGalpal=getInt(getColumnIndex(MenuCheckingGalpalTable.Cols.ID_MENU_F1_ENTRY_CHECKING));
        int idKualifikasiSurvey=getInt(getColumnIndex(MenuCheckingGalpalTable.Cols.ID_KUALIFIKASI_SURVEY));
        int idMenu=getInt(getColumnIndex(MenuCheckingGalpalTable.Cols.ID_MENU_F1));
        int isFill=getInt(getColumnIndex(MenuCheckingGalpalTable.Cols.IS_FILL));
        int isComplete=getInt(getColumnIndex(MenuCheckingGalpalTable.Cols.IS_COMPLETE));
        int isVerified=getInt(getColumnIndex(MenuCheckingGalpalTable.Cols.IS_VERIFIED));

        MenuCheckingGalpal menuCheckingGalpal=new MenuCheckingGalpal();
        menuCheckingGalpal.setIdMenuCheckingGalpal(idMenuCheckingGalpal);
        menuCheckingGalpal.setIdKualifikasiSurvey(idKualifikasiSurvey);
        menuCheckingGalpal.setIdMenu(idMenu);
        menuCheckingGalpal.setFill(isFill==1);
        menuCheckingGalpal.setComplete(isComplete==1);
        menuCheckingGalpal.setVerified(isVerified==1);

        return menuCheckingGalpal;
    }

    public MenuCheckingKompal getMenuCheckingKompal(){
        int idMenuCheckingKompal=getInt(getColumnIndex(MenuCheckingKompalTable.Cols.ID_MENU_F2_ENTRY_CHECKING));
        int idKualifikasiSurvey=getInt(getColumnIndex(MenuCheckingKompalTable.Cols.ID_KUALIFIKASI_SURVEY));
        int idMenu=getInt(getColumnIndex(MenuCheckingKompalTable.Cols.ID_MENU_F2));
        int isFill=getInt(getColumnIndex(MenuCheckingKompalTable.Cols.IS_FILL));
        int isComplete=getInt(getColumnIndex(MenuCheckingKompalTable.Cols.IS_COMPLETE));
        int isVerified=getInt(getColumnIndex(MenuCheckingKompalTable.Cols.IS_VERIFIED));

        MenuCheckingKompal menuCheckingKompal=new MenuCheckingKompal();
        menuCheckingKompal.setIdMenuCheckingKompal(idMenuCheckingKompal);
        menuCheckingKompal.setIdKualifikasiSurvey(idKualifikasiSurvey);
        menuCheckingKompal.setIdMenu(idMenu);
        menuCheckingKompal.setFill(isFill==1);
        menuCheckingKompal.setComplete(isComplete==1);
        menuCheckingKompal.setVerified(isVerified==1);

        return menuCheckingKompal;
    }


    public MstPropinsi getPropinsi(){
        int idPropinsi=getInt(getColumnIndex(MstPropinsiTable.Cols.ID_PROPINSI));
        int kodeBps=getInt(getColumnIndex(MstPropinsiTable.Cols.KODEBPS));
        String nama=getString(getColumnIndex(MstPropinsiTable.Cols.NAMA));
        String kodeIso=getString(getColumnIndex(MstPropinsiTable.Cols.KODEISO));
        String ibuKota=getString(getColumnIndex(MstPropinsiTable.Cols.IBUKOTA));
        String pulau=getString(getColumnIndex(MstPropinsiTable.Cols.PULAU));

        MstPropinsi mstPropinsi =new MstPropinsi();
        mstPropinsi.setId(idPropinsi);
        mstPropinsi.setKodeBps(kodeBps);
        mstPropinsi.setNama(nama);
        mstPropinsi.setKodeiso(kodeIso);
        mstPropinsi.setIbukota(ibuKota);
        mstPropinsi.setPulau(pulau);

        return mstPropinsi;
    }

    public MstKabupaten getKabupaten(){
        int id=getInt(getColumnIndex(MstKabupatenTable.Cols.ID));
        String nama=getString(getColumnIndex(MstKabupatenTable.Cols.NAMA));
        String ibuKota=getString(getColumnIndex(MstKabupatenTable.Cols.IBU_KOTA));
        int idPropinsi=getInt(getColumnIndex(MstKabupatenTable.Cols.ID_PROPINSI));
        int ibuKotaProp=getInt(getColumnIndex(MstKabupatenTable.Cols.IBU_KOTA));
        int jumlahPenduduk=getInt(getColumnIndex(MstKabupatenTable.Cols.JMLPENDUDUK));
        int kodeBps=getInt(getColumnIndex(MstKabupatenTable.Cols.KODEBPS));

        MstKabupaten mstKabupaten =new MstKabupaten();
        mstKabupaten.setId(id);
        mstKabupaten.setNama(nama);
        mstKabupaten.setIbuKota(ibuKota);
        mstKabupaten.setId_propinsi(idPropinsi);
        mstKabupaten.setIbuKotaPropinsi(ibuKotaProp);
        mstKabupaten.setJumlahPenduduk(jumlahPenduduk);
        mstKabupaten.setKodebps(kodeBps);

        return mstKabupaten;
    }

    public MstAirPelayaran getAirPelayaran(){
        int id=getInt(getColumnIndex(MstAirPelayaranTable.Cols.ID_MST_AIR_PELAYARAN));
        String nama=getString(getColumnIndex(MstAirPelayaranTable.Cols.AIR_PELAYARAN));

        MstAirPelayaran mstAirPelayaran=new MstAirPelayaran();
        mstAirPelayaran.setId(id);
        mstAirPelayaran.setNama(nama);

        return mstAirPelayaran;
    }

    public MstArus getArus(){
        int id=getInt(getColumnIndex(MstArusTable.Cols.ID_MST_ARUS));
        String nama=getString(getColumnIndex(MstArusTable.Cols.ARUS));

        MstArus mstArus=new MstArus();
        mstArus.setId(id);
        mstArus.setNama(nama);

        return mstArus;
    }

    public MstGelombang getGelombang(){
        int id=getInt(getColumnIndex(MstGelombangTable.Cols.ID_MST_GELOMBANG));
        String nama=getString(getColumnIndex(MstGelombangTable.Cols.MST_GELOMBANG));

        MstGelombang mstGelombang=new MstGelombang();
        mstGelombang.setId(id);
        mstGelombang.setNama(nama);

        return mstGelombang;
    }

    public MstJarakKedalaman getJarakKedalaman(){
        int id=getInt(getColumnIndex(MstJarakKedalamanTable.Cols.ID_MST_JARAK_KEDALAMAN));
        String nama=getString(getColumnIndex(MstJarakKedalamanTable.Cols.JARAK_KEDALAMAN));

        MstJarakKedalaman mstJarakKedalaman=new MstJarakKedalaman();
        mstJarakKedalaman.setId(id);
        mstJarakKedalaman.setNama(nama);

        return mstJarakKedalaman;
    }

    public MstJenisProduksi getJenisProduksi(){
        int id=getInt(getColumnIndex(MstJenisProduksiTable.Cols.ID_MST_JENIS_PRODUKSI));
        String nama=getString(getColumnIndex(MstJenisProduksiTable.Cols.JENIS_PRODUKSI));
        String kki=getString(getColumnIndex(MstJenisProduksiTable.Cols.KKI));

        MstJenisProduksi mstJenisProduksi=new MstJenisProduksi();
        mstJenisProduksi.setId(id);
        mstJenisProduksi.setNama(nama);
        mstJenisProduksi.setKki(kki);

        return mstJenisProduksi;
    }

    public MstPasangSurut getPasangSurut(){
        int id=getInt(getColumnIndex(MstPasangSurutTable.Cols.ID_MST_PASANG_SURUT));
        String nama=getString(getColumnIndex(MstPasangSurutTable.Cols.PASANG_SURUT));

        MstPasangSurut mstPasangSurut=new MstPasangSurut();
        mstPasangSurut.setId(id);
        mstPasangSurut.setNama(nama);

        return mstPasangSurut;

    }

    public MstSatuan getSatuan(){
        int id=getInt(getColumnIndex(MstSatuanTable.Cols.ID_MST_SATUAN));
        String nama=getString(getColumnIndex(MstSatuanTable.Cols.SATUAN));

        MstSatuan mstSatuan=new MstSatuan();
        mstSatuan.setId(id);
        mstSatuan.setNama(nama);

        return mstSatuan;
    }

    public MenuF1 getMenuF1(){
        int id=getInt(getColumnIndex(MenuF1Table.Cols.ID_MENU_F1));
        String number=getString(getColumnIndex(MenuF1Table.Cols.NUMBER));
        String namaMenu=getString(getColumnIndex(MenuF1Table.Cols.NAMA_MENU));

        MenuF1 menuF1=new MenuF1();
        menuF1.setIdMenuF1(id);
        menuF1.setNumber(number);
        menuF1.setNamaMenu(namaMenu);

        return menuF1;
    }

    public MenuF2 getMenuF2(){
        int id=getInt(getColumnIndex(MenuF2Table.Cols.ID_MENU_F2));
        String number=getString(getColumnIndex(MenuF2Table.Cols.NUMBER));
        String namaMenu=getString(getColumnIndex(MenuF2Table.Cols.NAMA_MENU));

        MenuF2 menuF2=new MenuF2();
        menuF2.setIdMenuF2(id);
        menuF2.setNumber(number);
        menuF2.setNamaMenu(namaMenu);

        return menuF2;
    }

    public Notification getNotification(){
        int id=getInt(getColumnIndex(NotificationTable.Cols.ID_NOTIFICATION));
        String userid=getString(getColumnIndex(NotificationTable.Cols.USERID));
        String fromUserid=getString(getColumnIndex(NotificationTable.Cols.FROMUSERID));
        long notifyDate=getLong(getColumnIndex(NotificationTable.Cols.NOTIF_DATE));
        String notifyMessage=getString(getColumnIndex(NotificationTable.Cols.NOTIF_MESSAGE));
        String notifyTitle=getString(getColumnIndex(NotificationTable.Cols.NOTIF_TITLE));
        String notifyStatus=getString(getColumnIndex(NotificationTable.Cols.NOTIF_STATUS));

        Notification notification=new Notification();
        notification.setIdNotification(id);
        notification.setUserId(userid);
        notification.setFromUserId(fromUserid);
        notification.setNotifyDate(new Date(notifyDate));
        notification.setNotifyMessage(notifyMessage);
        notification.setNotifyTitle(notifyTitle);
        notification.setNotifyStatus(notifyStatus);

        return notification;
    }


}
