package com.mpewpazi.android.awaljunisidang.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.mpewpazi.android.awaljunisidang.database.DhSchema.*;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FG1PerusahaanIdentitasTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FG3GalanganKapalTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FG4TinjauanAreaTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FG6PeralatanKerjaLuarCraneTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FK3aJenisKapasitasProduksiTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FK3bJumlahProduksiTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FK3cSistemBerproduksiTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FK3dStandarMutuTableTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.KualifikasiSurveyTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.PeriodeSurveyTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.PerusahaanTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.SurveyAssignSurveyorTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.UserTable;

/**
 * Created by mpewpazi on 4/8/16.
 */
public class BaseDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "shipyardkemenperine.db";

    public BaseDBHelper(Context context)
    {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub

        //create tabel user
        db.execSQL(
                "create table "+ UserTable.NAME+
                        "("+UserTable.Cols.USERID+" text primary key ," +
                        UserTable.Cols.CODE_ID +", " +
                        UserTable.Cols.TYPE +", " +
                        UserTable.Cols.FULL_NAME +", " +
                        UserTable.Cols.COMPANY_NAME +", " +
                        UserTable.Cols.EMAIL +", " +
                        UserTable.Cols.PASSWORD +", " +
                        UserTable.Cols.SECURITY_CODE +" )"
        );

        //create tabel survey assign surveyor
        db.execSQL(
                "create table "+ SurveyAssignSurveyorTable.NAME+
                        "("+SurveyAssignSurveyorTable.Cols.ID_SURVEY_ASSIGN_SURVEYOR+" integer primary key ," +
                        SurveyAssignSurveyorTable.Cols.ID_KUALIFIKASI_SURVEY +", " +
                        SurveyAssignSurveyorTable.Cols.USERID +", " +
                        SurveyAssignSurveyorTable.Cols.ASSIGN_DATE +", " +
                        SurveyAssignSurveyorTable.Cols.ASSIGN_BY +" )"
        );

        //create tabel periode
        db.execSQL(
                "create table "+ PeriodeSurveyTable.NAME+
                        "("+PeriodeSurveyTable.Cols.ID_PERIODE+" integer primary key ," +
                        PeriodeSurveyTable.Cols.TAHUN_KUALIFIKASI +", " +
                        PeriodeSurveyTable.Cols.IS_ACTIVE_PERIOD +", " +
                        PeriodeSurveyTable.Cols.IS_DONE +", " +
                        PeriodeSurveyTable.Cols.KETERANGAN +" )"
        );
        //create tabel perusahaan
        db.execSQL(
                "create table "+ PerusahaanTable.NAME+
                        "("+PerusahaanTable.Cols.ID_PERUSAHAAN+" integer primary key ," +
                        PerusahaanTable.Cols.NAMA_PERUSAHAAN +", " +
                        PerusahaanTable.Cols.INDUSTRI +", " +
                        PerusahaanTable.Cols.IS_ACTIV +" )"
        );
        //create tabel kualifikasi survey
        db.execSQL(
                "create table "+ KualifikasiSurveyTable.NAME+
                        "("+KualifikasiSurveyTable.Cols.ID_KUALIFIKASI_SURVEY+" integer primary key ," +
                        KualifikasiSurveyTable.Cols.ID_PERUSAHAAN +", " +
                        KualifikasiSurveyTable.Cols.ID_PERIODE +", " +
                        KualifikasiSurveyTable.Cols.PROGRESS +", " +
                        KualifikasiSurveyTable.Cols.ID_GALANGAN_KAPAL +" )"
        );

        //create tabel Identitas Perusahaan
        db.execSQL(
                "create table "+ FG1PerusahaanIdentitasTable.NAME+
                        "("+FG1PerusahaanIdentitasTable.Cols.ID_PERUSAHAAN_IDENTITAS+" integer primary key ," +
                        FG1PerusahaanIdentitasTable.Cols.ID_PERUSAHAAN +" integer," +
                        FG1PerusahaanIdentitasTable.Cols.ID_KUALIFIKASI_SURVEY +" integer," +
                        FG1PerusahaanIdentitasTable.Cols.ALAMAT_PERUSAHAAN +" text," +
                        FG1PerusahaanIdentitasTable.Cols.JALAN_DESA_PERUSAHAAN +" text," +
                        FG1PerusahaanIdentitasTable.Cols.KELURAHAN_PERUSAHAAN +" text," +
                        FG1PerusahaanIdentitasTable.Cols.KECAMATAN_PERUSAHAAN +" text," +
                        FG1PerusahaanIdentitasTable.Cols.ID_KABUPATEN_PERUSAHAAN +" integer," +
                        FG1PerusahaanIdentitasTable.Cols.ID_PROPINSI_PERUSAHAAN +" integer," +
                        FG1PerusahaanIdentitasTable.Cols.TELEPON_PERUSAHAAN +" text," +
                        FG1PerusahaanIdentitasTable.Cols.FAX_PERUSAHAAN +" text," +
                        FG1PerusahaanIdentitasTable.Cols.KODE_POS_PERUSAHAAN +" text," +
                        FG1PerusahaanIdentitasTable.Cols.ALAMAT_PABRIK +" text," +
                        FG1PerusahaanIdentitasTable.Cols.JALAN_DESA_PABRIK +" text," +
                        FG1PerusahaanIdentitasTable.Cols.KELURAHAN_PABRIK +" text," +
                        FG1PerusahaanIdentitasTable.Cols.KECAMATAN_PABRIK +" text," +
                        FG1PerusahaanIdentitasTable.Cols.ID_KABUPATEN_PABRIK +" integer," +
                        FG1PerusahaanIdentitasTable.Cols.ID_PROPINSI_PABRIK +" integer," +
                        FG1PerusahaanIdentitasTable.Cols.TELEPON_PABRIK +" text," +
                        FG1PerusahaanIdentitasTable.Cols.FAX_PABRIK +" text," +
                        FG1PerusahaanIdentitasTable.Cols.KODE_POS_PABRIK +" text," +
                        FG1PerusahaanIdentitasTable.Cols.ID_MST_LOKASI_PABRIK +" integer," +
                        FG1PerusahaanIdentitasTable.Cols.LAHAN_PERUNTUKAN +" text," +
                        FG1PerusahaanIdentitasTable.Cols.LUAS_TANAH_PABRIK +" integer," +
                        FG1PerusahaanIdentitasTable.Cols.NPWP +" text," +
                        FG1PerusahaanIdentitasTable.Cols.NAMA_PIMPINAN +" text," +
                        FG1PerusahaanIdentitasTable.Cols.STATUS_KEPEMILIKAN_USAHA +" text," +
                        FG1PerusahaanIdentitasTable.Cols.KATEGORI_PERUSAHAAN +" text," +
                        FG1PerusahaanIdentitasTable.Cols.ANGGOTA_ASOSIASI +" text," +
                        FG1PerusahaanIdentitasTable.Cols.WEBSITE +" text," +
                        FG1PerusahaanIdentitasTable.Cols.CP_NAMA +" text," +
                        FG1PerusahaanIdentitasTable.Cols.CP_NO +" text," +
                        FG1PerusahaanIdentitasTable.Cols.CP_JABATAN +" text," +
                        FG1PerusahaanIdentitasTable.Cols.CP_EMAIL +" text," +
                        FG1PerusahaanIdentitasTable.Cols.ID_MST_JENIS_INDUSTRI +" integer," +
                        FG1PerusahaanIdentitasTable.Cols.LONGITUDE +" text," +
                        FG1PerusahaanIdentitasTable.Cols.LATITUDE +" text," +
                        FG1PerusahaanIdentitasTable.Cols.LINTANG +" text," +
                        FG1PerusahaanIdentitasTable.Cols.LINTANG_DERAJAT +" integer," +
                        FG1PerusahaanIdentitasTable.Cols.LINTANG_MENIT +" integer," +
                        FG1PerusahaanIdentitasTable.Cols.LINTANG_DETIK +" real," +
                        FG1PerusahaanIdentitasTable.Cols.BUJUR +" text," +
                        FG1PerusahaanIdentitasTable.Cols.BUJUR_DERAJAT +" integer," +
                        FG1PerusahaanIdentitasTable.Cols.BUJUR_MENIT +" int," +
                        FG1PerusahaanIdentitasTable.Cols.BUJUR_DETIK +" real," +
                        FG1PerusahaanIdentitasTable.Cols.CREATED_DATE +" numeric," +
                        FG1PerusahaanIdentitasTable.Cols.CREATED_USER +" text," +
                        FG1PerusahaanIdentitasTable.Cols.CREATED_IP_ADDRESS +" text," +
                        FG1PerusahaanIdentitasTable.Cols.MODIFIED_DATE +" numeric," +
                        FG1PerusahaanIdentitasTable.Cols.MODIFIED_USER +" text," +
                        FG1PerusahaanIdentitasTable.Cols.MODIFIED_IP_ADDRESS +" text)"
        );



        db.execSQL(
                "create table "+ FG3GalanganKapalTable.NAME+
                        "("+FG3GalanganKapalTable.Cols.ID_GALANGAN_KAPAL+" integer primary key ," +
                        FG3GalanganKapalTable.Cols.NAMA_GALANGAN +" text," +
                        FG3GalanganKapalTable.Cols.KATEGORI_GALANGAN +" text," +
                        FG3GalanganKapalTable.Cols.IS_NEW_BUILDING +" text," +
                        FG3GalanganKapalTable.Cols.IS_REPAIR +" text," +
                        FG3GalanganKapalTable.Cols.ID_KUALIFIKASI_SURVEY +" integer," +
                        FG3GalanganKapalTable.Cols.ID_PERUSAHAAN +" integer," +
                        FG3GalanganKapalTable.Cols.NOMOR_DOCK +" text," +
                        FG3GalanganKapalTable.Cols.ALAMAT_GALANGAN +" text," +
                        FG3GalanganKapalTable.Cols.JALAN_DESA_GALANGAN +" text," +
                        FG3GalanganKapalTable.Cols.KELURAHAN_GALANGAN +" text," +
                        FG3GalanganKapalTable.Cols.KECAMATAN_GALANGAN +" text," +
                        FG3GalanganKapalTable.Cols.ID_KABUPATEN_GALANGAN +" integer," +
                        FG3GalanganKapalTable.Cols.ID_PROPINSI_GALANGAN +" integer," +
                        FG3GalanganKapalTable.Cols.TELEPON_GALANGAN +" text," +
                        FG3GalanganKapalTable.Cols.FAX_GALANGAN +" text," +
                        FG3GalanganKapalTable.Cols.KODE_POS_GALANGAN +" text," +
                        FG3GalanganKapalTable.Cols.LONGITUDE +" text," +
                        FG3GalanganKapalTable.Cols.LATITUDE +" text," +
                        FG3GalanganKapalTable.Cols.LINTANG +" text," +
                        FG3GalanganKapalTable.Cols.LINTANG_DERAJAT +" integer," +
                        FG3GalanganKapalTable.Cols.LINTANG_MENIT +" integer," +
                        FG3GalanganKapalTable.Cols.LINTANG_DETIK +" real," +
                        FG3GalanganKapalTable.Cols.BUJUR +" text," +
                        FG3GalanganKapalTable.Cols.BUJUR_DERAJAT +" integer," +
                        FG3GalanganKapalTable.Cols.BUJUR_MENIT +" int," +
                        FG3GalanganKapalTable.Cols.BUJUR_DETIK +" real," +
                        FG3GalanganKapalTable.Cols.CP_NAMA +" text," +
                        FG3GalanganKapalTable.Cols.CP_NO +" text," +
                        FG3GalanganKapalTable.Cols.CP_JABATAN +" text," +
                        FG3GalanganKapalTable.Cols.CP_EMAIL +" text," +
                        FG3GalanganKapalTable.Cols.CREATED_DATE +" numeric," +
                        FG3GalanganKapalTable.Cols.CREATED_USER +" text," +
                        FG3GalanganKapalTable.Cols.CREATED_IP_ADDRESS +" text," +
                        FG3GalanganKapalTable.Cols.MODIFIED_DATE +" numeric," +
                        FG3GalanganKapalTable.Cols.MODIFIED_USER +" text," +
                        FG3GalanganKapalTable.Cols.MODIFIED_IP_ADDRESS +" text)"
        );

        //create tabel formgalpal4
        db.execSQL(
                "create table "+FG4TinjauanAreaTable.NAME+
                        "("+FG4TinjauanAreaTable.Cols.ID_F1_TINJAUAN_AREA+" integer primary key ," +
                        FG4TinjauanAreaTable.Cols.ID_KUALIFIKASI_SURVEY +" text," +
                        FG4TinjauanAreaTable.Cols.ID_PERIODE +" text," +
                        FG4TinjauanAreaTable.Cols.ID_MST_JARAK_KEDALAMAN +" text," +
                        FG4TinjauanAreaTable.Cols.ID_MST_AIR_PELAYARAN +" text," +
                        FG4TinjauanAreaTable.Cols.ID_MST_PASANG_SURUT +" text," +
                        FG4TinjauanAreaTable.Cols.ID_MST_ARUS +" text," +
                        FG4TinjauanAreaTable.Cols.ID_MST_GELOMBANG +" text," +
                        FG4TinjauanAreaTable.Cols.PANJANG_WATERFRONT +" text," +
                        FG4TinjauanAreaTable.Cols.LUAS_LAHAN +" text," +
                        FG4TinjauanAreaTable.Cols.KETERSEDIAAN_LAHAN +" text," +
                        FG4TinjauanAreaTable.Cols.LAHAN_PRODUKTIF +" text," +
                        FG4TinjauanAreaTable.Cols.LAHAN_PEMUKIMAN +" text," +
                        FG4TinjauanAreaTable.Cols.PASANG_SURUT +" text," +
                        FG4TinjauanAreaTable.Cols.DAYA_DUKUNG +" text," +
                        FG4TinjauanAreaTable.Cols.KELANDAIAAN +" text," +
                        FG4TinjauanAreaTable.Cols.DEKAT_JALAN +" text," +
                        FG4TinjauanAreaTable.Cols.KOTA +" text," +
                        FG4TinjauanAreaTable.Cols.INTERKONEKSI_ANGKUTAN +" text," +
                        FG4TinjauanAreaTable.Cols.NILAI_EKONOMI +" text," +
                        FG4TinjauanAreaTable.Cols.PERKEMBANGAN_WILAYAH +" text," +
                        FG4TinjauanAreaTable.Cols.RUTWR +" text," +
                        FG4TinjauanAreaTable.Cols.CREATED_DATE +" numeric," +
                        FG4TinjauanAreaTable.Cols.CREATED_USER +" text," +
                        FG4TinjauanAreaTable.Cols.CREATED_IP_ADDRESS +" text," +
                        FG4TinjauanAreaTable.Cols.MODIFIED_DATE +" numeric," +
                        FG4TinjauanAreaTable.Cols.MODIFIED_USER +" text," +
                        FG4TinjauanAreaTable.Cols.MODIFIED_IP_ADDRESS +" text)"
        );

        //create tabel formgalpal6
        db.execSQL(
                "create table "+FG6PeralatanKerjaLuarCraneTable.NAME+
                        "("+FG6PeralatanKerjaLuarCraneTable.Cols.ID_F1_PERALATAN_KERJA_LR_CRANE+" text primary key ," +
                        FG6PeralatanKerjaLuarCraneTable.Cols.ID_KUALIFIKASI_SURVEY +" integer ," +
                        FG6PeralatanKerjaLuarCraneTable.Cols.ID_PERIODE +" ," +
                        FG6PeralatanKerjaLuarCraneTable.Cols.JENIS_MESIN +" ," +
                        FG6PeralatanKerjaLuarCraneTable.Cols.TAHUN_PEMBUATAN +" ," +
                        FG6PeralatanKerjaLuarCraneTable.Cols.MERK +" ," +
                        FG6PeralatanKerjaLuarCraneTable.Cols.KAPASAITAS_TERPASANG +" ," +
                        FG6PeralatanKerjaLuarCraneTable.Cols.SATUAN_KAPASITAS_TERPASANG +" ," +
                        FG6PeralatanKerjaLuarCraneTable.Cols.KAPASITAS_TERPAKAI +" ," +
                        FG6PeralatanKerjaLuarCraneTable.Cols.SATUAN_KAPASITAS_TERPAKAI +" ," +
                        FG6PeralatanKerjaLuarCraneTable.Cols.DIMENSI +" ," +
                        FG6PeralatanKerjaLuarCraneTable.Cols.JUMLAH +" ," +
                        FG6PeralatanKerjaLuarCraneTable.Cols.KONDISI +" ," +
                        FG6PeralatanKerjaLuarCraneTable.Cols.LOKASI +" ," +
                        FG6PeralatanKerjaLuarCraneTable.Cols.STATUS +" ," +
                        FG6PeralatanKerjaLuarCraneTable.Cols.CREATED_DATE +" ," +
                        FG6PeralatanKerjaLuarCraneTable.Cols.CREATED_USER +" ," +
                        FG6PeralatanKerjaLuarCraneTable.Cols.CREATED_IP_ADDRESS +" ," +
                        FG6PeralatanKerjaLuarCraneTable.Cols.MODIFIED_DATE +" ," +
                        FG6PeralatanKerjaLuarCraneTable.Cols.MODIFIED_USER +" ," +
                        FG6PeralatanKerjaLuarCraneTable.Cols.MODIFIED_IP_ADDRESS +" )"
        );




        //Create Table FormKompal3a
        db.execSQL(
                "create table "+FK3aJenisKapasitasProduksiTable.NAME+
                        "("+FK3aJenisKapasitasProduksiTable.Cols.ID_F2_JENIS_KAPASITAS_PRODUKSI+" text primary key ," +
                        FK3aJenisKapasitasProduksiTable.Cols.ID_KUALIFIKASI_SURVEY +" integer ," +
                        FK3aJenisKapasitasProduksiTable.Cols.ID_PERIODE +" ," +
                        FK3aJenisKapasitasProduksiTable.Cols.JENIS_PRODUKSI +" ," +
                        FK3aJenisKapasitasProduksiTable.Cols.KAPASITAS_PRODUKSI +" ," +
                        FK3aJenisKapasitasProduksiTable.Cols.ID_MST_SATUAN +" ," +
                        FK3aJenisKapasitasProduksiTable.Cols.CREATED_DATE +" ," +
                        FK3aJenisKapasitasProduksiTable.Cols.CREATED_USER +" ," +
                        FK3aJenisKapasitasProduksiTable.Cols.CREATED_IP_ADDRESS +" ," +
                        FK3aJenisKapasitasProduksiTable.Cols.MODIFIED_DATE +" ," +
                        FK3aJenisKapasitasProduksiTable.Cols.MODIFIED_USER +" ," +
                        FK3aJenisKapasitasProduksiTable.Cols.MODIFIED_IP_ADDRESS +" )"
        );

        //CREATE TABLE FORMKOMPAL3b
        db.execSQL(
                "create table "+FK3bJumlahProduksiTable.NAME+
                        "("+FK3bJumlahProduksiTable.Cols.ID_F2_JUMLAH_PRODUKSI+" text primary key ," +
                        FK3bJumlahProduksiTable.Cols.ID_KUALIFIKASI_SURVEY +" integer ," +
                        FK3bJumlahProduksiTable.Cols.ID_PERIODE +" ," +
                        FK3bJumlahProduksiTable.Cols.ID_F2_JENIS_KAPASITAS_PRODUKSI +" ," +
                        FK3bJumlahProduksiTable.Cols.JUMLAH_PROD_NMIN4 +" ," +
                        FK3bJumlahProduksiTable.Cols.JUMLAH_PROD_NMIN3 +" ," +
                        FK3bJumlahProduksiTable.Cols.JUMLAH_PROD_NMIN2 +" ," +
                        FK3bJumlahProduksiTable.Cols.JUMLAH_PROD_NMIN1 +" ," +
                        FK3bJumlahProduksiTable.Cols.ID_MST_SATUAN +" ," +
                        FK3bJumlahProduksiTable.Cols.NILAI_PRODUKSI_NMIN4 +" ," +
                        FK3bJumlahProduksiTable.Cols.NILAI_PRODUKSI_NMIN3 +" ," +
                        FK3bJumlahProduksiTable.Cols.NILAI_PRODUKSI_NMIN2 +" ," +
                        FK3bJumlahProduksiTable.Cols.NILAI_PRODUKSI_NMIN1 +" ," +
                        FK3bJumlahProduksiTable.Cols.KETERANGAN +" ," +
                        FK3bJumlahProduksiTable.Cols.CREATED_DATE +" ," +
                        FK3bJumlahProduksiTable.Cols.CREATED_USER +" ," +
                        FK3bJumlahProduksiTable.Cols.CREATED_IP_ADDRESS +" ," +
                        FK3bJumlahProduksiTable.Cols.MODIFIED_DATE +" ," +
                        FK3bJumlahProduksiTable.Cols.MODIFIED_USER +" ," +
                        FK3bJumlahProduksiTable.Cols.MODIFIED_IP_ADDRESS +" )"
        );

        //CREATE TABLE FORMKOMPAL3c
        db.execSQL(
                "create table "+ FK3cSistemBerproduksiTable.NAME+
                        "("+FK3cSistemBerproduksiTable.Cols.ID_F2_SISTEM_BERPRODUKSI+" text primary key ," +
                        FK3cSistemBerproduksiTable.Cols.ID_KUALIFIKASI_SURVEY +" integer ," +
                        FK3cSistemBerproduksiTable.Cols.ID_PERIODE +" ," +
                        FK3cSistemBerproduksiTable.Cols.NAMA_PRODUK +" ," +
                        FK3cSistemBerproduksiTable.Cols.ID_MST_JENIS_PRODUKSI +" ," +
                        FK3cSistemBerproduksiTable.Cols.ID_MST_JENIS_BERPRODUKSI +" ," +
                        FK3cSistemBerproduksiTable.Cols.JUMLAH_PROD_NMIN4 +" ," +
                        FK3cSistemBerproduksiTable.Cols.JUMLAH_PROD_NMIN3 +" ," +
                        FK3cSistemBerproduksiTable.Cols.JUMLAH_PROD_NMIN2 +" ," +
                        FK3cSistemBerproduksiTable.Cols.JUMLAH_PROD_NMIN1 +" ," +
                        FK3cSistemBerproduksiTable.Cols.CREATED_DATE +" ," +
                        FK3cSistemBerproduksiTable.Cols.CREATED_USER +" ," +
                        FK3cSistemBerproduksiTable.Cols.CREATED_IP_ADDRESS +" ," +
                        FK3cSistemBerproduksiTable.Cols.MODIFIED_DATE +" ," +
                        FK3cSistemBerproduksiTable.Cols.MODIFIED_USER +" ," +
                        FK3cSistemBerproduksiTable.Cols.MODIFIED_IP_ADDRESS +" )"
        );

        //CREATE TABLE FORMKOMPAL3d
        db.execSQL(
                "create table "+FK3dStandarMutuTableTable.NAME+
                        "("+FK3dStandarMutuTableTable.Cols.ID_F2_STANDAR_MUTU+" text primary key ," +
                        FK3dStandarMutuTableTable.Cols.ID_KUALIFIKASI_SURVEY +" integer ," +
                        FK3dStandarMutuTableTable.Cols.ID_PERIODE +" ," +
                        FK3dStandarMutuTableTable.Cols.JENIS_STANDAR_MUTU +" ," +
                        FK3dStandarMutuTableTable.Cols.KETERANGAN +" ," +
                        FK3dStandarMutuTableTable.Cols.CREATED_DATE +" ," +
                        FK3dStandarMutuTableTable.Cols.CREATED_USER +" ," +
                        FK3dStandarMutuTableTable.Cols.CREATED_IP_ADDRESS +" ," +
                        FK3dStandarMutuTableTable.Cols.MODIFIED_DATE +" ," +
                        FK3dStandarMutuTableTable.Cols.MODIFIED_USER +" ," +
                        FK3dStandarMutuTableTable.Cols.MODIFIED_IP_ADDRESS +" )"
        );

        db.execSQL(
                "create table "+MenuCheckingGalpalTable.NAME+
                        "("+MenuCheckingGalpalTable.Cols.ID_MENU_F1_ENTRY_CHECKING+" integer primary key ," +
                        MenuCheckingGalpalTable.Cols.ID_KUALIFIKASI_SURVEY +" integer ," +
                        MenuCheckingGalpalTable.Cols.ID_MENU_F1 +" integer ," +
                        MenuCheckingGalpalTable.Cols.IS_FILL +" ," +
                        MenuCheckingGalpalTable.Cols.IS_COMPLETE +" ," +
                        MenuCheckingGalpalTable.Cols.IS_VERIFIED +" )"
        );

        db.execSQL(
                "create table "+MenuCheckingKompalTable.NAME+
                        "("+MenuCheckingKompalTable.Cols.ID_MENU_F2_ENTRY_CHECKING+" integer primary key ," +
                        MenuCheckingKompalTable.Cols.ID_KUALIFIKASI_SURVEY +" integer ," +
                        MenuCheckingKompalTable.Cols.ID_MENU_F2 +" integer ," +
                        MenuCheckingKompalTable.Cols.IS_FILL +" ," +
                        MenuCheckingKompalTable.Cols.IS_COMPLETE +" ," +
                        MenuCheckingKompalTable.Cols.IS_VERIFIED +" )"
        );



       /* contoh
        db.execSQL(
                "create table "+DUMMY.NAME+
                        "("+DUMMY.Cols.+" integer primary key ," +
                        DUMMY.Cols.ID_KUALIFIKASI_SURVEY +" ," +
                        DUMMY.Cols.ID_PERIODE +" ," +
                        DUMMY.Cols. +" ," +
                        DUMMY.Cols. +" ," +
                        DUMMY.Cols. +" ," +
                        DUMMY.Cols. +" ," +
                        DUMMY.Cols. +" ," +
                        DUMMY.Cols. +" ," +
                        DUMMY.Cols.CREATED_DATE +" ," +
                        DUMMY.Cols.CREATED_USER +" ," +
                        DUMMY.Cols.CREATED_IP_ADDRESS +" ," +
                        DUMMY.Cols.MODIFIED_DATE +" ," +
                        DUMMY.Cols.MODIFIED_USER +" ," +
                        DUMMY.Cols.MODIFIED_IP_ADDRESS +" )"
        );

        */


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
