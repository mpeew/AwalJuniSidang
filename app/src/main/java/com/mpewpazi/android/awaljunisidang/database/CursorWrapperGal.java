package com.mpewpazi.android.awaljunisidang.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.mpewpazi.android.awaljunisidang.Form.FormGalpal1;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal3;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal4;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal6;
import com.mpewpazi.android.awaljunisidang.model.KualifikasiSurvey;
import com.mpewpazi.android.awaljunisidang.model.PeriodeSurvey;
import com.mpewpazi.android.awaljunisidang.model.Perusahaan;
import com.mpewpazi.android.awaljunisidang.model.SurveyAssignSurveyor;
import com.mpewpazi.android.awaljunisidang.model.User;

import java.util.UUID;

import static com.mpewpazi.android.awaljunisidang.database.DhSchema.*;


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
        int idIdentitasPerusahaan=getInt(getColumnIndex(FG1PerusahaanIdentitasTable.Cols.ID_PERUSAHAAN_IDENTITAS));
        int idKualifikasiSurvey=getInt(getColumnIndex(FG1PerusahaanIdentitasTable.Cols.ID_KUALIFIKASI_SURVEY));
        String statusKememilikanUsaha=getString(getColumnIndex(FG1PerusahaanIdentitasTable.Cols.STATUS_KEPEMILIKAN_USAHA));
        String nomorTelepon=getString(getColumnIndex(FG1PerusahaanIdentitasTable.Cols.TELEPON_PERUSAHAAN));
        String nomorFax=getString(getColumnIndex(FG1PerusahaanIdentitasTable.Cols.FAX_PERUSAHAAN));
        String alamat=getString(getColumnIndex(FG1PerusahaanIdentitasTable.Cols.ALAMAT_PERUSAHAAN));
        String kelurahan=getString(getColumnIndex(FG1PerusahaanIdentitasTable.Cols.KELURAHAN_PERUSAHAAN));
        String kecamatan=getString(getColumnIndex(FG1PerusahaanIdentitasTable.Cols.KECAMATAN_PERUSAHAAN));
        String propinsi=getString(getColumnIndex(FG1PerusahaanIdentitasTable.Cols.ID_PROPINSI_PERUSAHAAN));
        String kabupaten_kota=getString(getColumnIndex(FG1PerusahaanIdentitasTable.Cols.ID_KABUPATEN_PERUSAHAAN));
        String kodePos=getString(getColumnIndex(FG1PerusahaanIdentitasTable.Cols.KODE_POS_PERUSAHAAN));
        String anggotaAsosiasi=getString(getColumnIndex(FG1PerusahaanIdentitasTable.Cols.ANGGOTA_ASOSIASI));
        String kategoriPerusahaan=getString(getColumnIndex(FG1PerusahaanIdentitasTable.Cols.KATEGORI_PERUSAHAAN));
        String cpNama=getString(getColumnIndex(FG1PerusahaanIdentitasTable.Cols.CP_NAMA));
        String cpNo=getString(getColumnIndex(FG1PerusahaanIdentitasTable.Cols.CP_NO));
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
        String provinsi=getString(getColumnIndex(FG3GalanganKapalTable.Cols.ID_PROPINSI_GALANGAN));
        String kabupaten=getString(getColumnIndex(FG3GalanganKapalTable.Cols.ID_KABUPATEN_GALANGAN));
        String kodePos=getString(getColumnIndex(FG3GalanganKapalTable.Cols.KODE_POS_GALANGAN));
        String latitude=getString(getColumnIndex(FG3GalanganKapalTable.Cols.LATITUDE));
        String longitude=getString(getColumnIndex(FG3GalanganKapalTable.Cols.LONGITUDE));
        String kategotiGalangan=getString(getColumnIndex(FG3GalanganKapalTable.Cols.KATEGORI_GALANGAN));
        String cpNama=getString(getColumnIndex(FG3GalanganKapalTable.Cols.CP_NAMA));
        String cpNo=getString(getColumnIndex(FG3GalanganKapalTable.Cols.CP_NO));
        String cpJabatan=getString(getColumnIndex(FG3GalanganKapalTable.Cols.CP_JABATAN));
        String cpEmail=getString(getColumnIndex(FG3GalanganKapalTable.Cols.CP_EMAIL));

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
        formGalpal3.setPropinsi(provinsi);
        formGalpal3.setKebupaten_kota(kabupaten);
        formGalpal3.setKodePos(kodePos);
        formGalpal3.setLatitude(latitude);
        formGalpal3.setLongitude(longitude);
        formGalpal3.setKategoriGalangan(kategotiGalangan);
        formGalpal3.setContactPerson(cpNama);
        formGalpal3.setNomorCp(cpNo);
        formGalpal3.setJabatan(cpJabatan);
        formGalpal3.setEmail(cpEmail);

        return formGalpal3;
    }

    public FormGalpal4 getFormGalpal4(){
        int idTinjauanWilayahMaritim=getInt(getColumnIndex(FG4TinjauanAreaTable.Cols.ID_F1_TINJAUAN_AREA));
        int idKualifikasiSurvey=getInt(getColumnIndex(FG4TinjauanAreaTable.Cols.ID_KUALIFIKASI_SURVEY));
        String jarakKedalaman=getString(getColumnIndex(FG4TinjauanAreaTable.Cols.ID_MST_JARAK_KEDALAMAN));
        String airPelayaran=getString(getColumnIndex(FG4TinjauanAreaTable.Cols.ID_MST_AIR_PELAYARAN));
        String pasangSurut=getString(getColumnIndex(FG4TinjauanAreaTable.Cols.ID_MST_PASANG_SURUT));
        String arus=getString(getColumnIndex(FG4TinjauanAreaTable.Cols.ID_MST_ARUS));
        String gelombang=getString(getColumnIndex(FG4TinjauanAreaTable.Cols.ID_MST_GELOMBANG));
        String panjangWaterfornt=getString(getColumnIndex(FG4TinjauanAreaTable.Cols.PANJANG_WATERFRONT));
        String luasLahan=getString(getColumnIndex(FG4TinjauanAreaTable.Cols.LUAS_LAHAN));
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
        formGalpal4.setJarakKedalaman(jarakKedalaman);
        formGalpal4.setAirPelayaran(airPelayaran);
        formGalpal4.setPasangSurutPerairan(pasangSurut);
        formGalpal4.setArus(arus);
        formGalpal4.setGelombang(gelombang);
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

        FormGalpal6 formGalpal6=new FormGalpal6(UUID.fromString(idPeralatanKerjaCrane));
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

        return formGalpal6;
    }
}
