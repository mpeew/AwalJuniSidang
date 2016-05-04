package com.mpewpazi.android.awaljunisidang.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.mpewpazi.android.awaljunisidang.database.DhSchema.*;

/**
 * Created by mpewpazi on 4/8/16.
 */
public class BaseDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "shipyardkemenperin.db";

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
                        FG6PeralatanKerjaLuarCraneTable.Cols.ID_KUALIFIKASI_SURVEY +" ," +
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

       /* //create tabel formgalpal19
        //foreign key belum dimasukan
        db.execSQL(
                "create table "+FORM_GALPAL19_TABLE_NAME+
                        "("+FORM_GALPAL19_COLUMN_ID+" integer primary key ," +
                        FORM_GALPAL19_COLUMN_NAMA_BENGKEL +" text," +
                        FORM_GALPAL19_COLUMN_LUAS +" integer," +
                        FORM_GALPAL19_COLUMN_DIMENSI +" text," +
                        FORM_GALPAL19_COLUMN_KAPASITAS +" integer," +
                        FORM_GALPAL19_COLUMN_STATUS +" text," +
                        FORM_GALPAL19_COLUMN_JARAK +" integer," +
                        FORM_UMUM_COLUMN_CREATED_DATE +" date," +
                        FORM_UMUM_COLUMN_CREATED_USER +" text," +
                        FORM_UMUM_COLUMN_CREATED_IP_ADDRESS +" text," +
                        FORM_UMUM_COLUMN_MODIFIED_DATE +" date," +
                        FORM_UMUM_COLUMN_MODIFIED_USER +" text," +
                        FORM_UMUM_COLUMN_MODIFIED_IP_ADDRESS +" text)"
        );*/




       /* //create tabel formkompal2
        db.execSQL(
                "create table " + FORM_KOMPAL2_TABLE_NAME +
                        "(" + FORM_KOMPAL2_COLUMN_ID + " integer primary key ," +
                        FORM_KOMPAL2_COLUMN_BAHAN_BAKU + " text," +
                        FORM_KOMPAL2_COLUMN_MESIN_SISTEM_ELEKTRIKAL + " text," +
                        FORM_KOMPAL2_COLUMN_PERLENGKAPAN_KAPAL + " text)"
        );*/


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


}
