package com.mpewpazi.android.awaljunisidang.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.mpewpazi.android.awaljunisidang.database.DhSchema.*;

/**
 * Created by mpewpazi on 4/8/16.
 */
public class BaseDBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "shipyard.db";


    //FORM GALPAL3 TABEL
    public static final String FORM_GALPAL3_TABLE_NAME = "form_galpal3";
    public static final String FORM_GALPAL3_COLUMN_ID = "id";
    public static final String FORM_GALPAL3_COLUMN_NAMA_PERUSAHAAN = "nama_perusahaan";
    public static final String FORM_GALPAL3_COLUMN_NAMA_GALANGAN = "nama_galangan";
    public static final String FORM_GALPAL3_COLUMN_NOMOR_DOCK = "nomor_dock";
    public static final String FORM_GALPAL3_COLUMN_NOMOR_TELEPON = "nomor_telepon";
    public static final String FORM_GALPAL3_COLUMN_FAX = "fax";
    public static final String FORM_GALPAL3_COLUMN_ALAMAT = "alamat";
    public static final String FORM_GALPAL3_COLUMN_KELURAHAN="kelurahan";
    public static final String FORM_GALPAL3_COLUMN_KECAMATAN="kecamatan";
    public static final String FORM_GALPAL3_COLUMN_PROPINSI="propinsi";
    public static final String FORM_GALPAL3_COLUMN_KABUPATEN="kabupaten";
    public static final String FORM_GALPAL3_COLUMN_KODE_POS="kode_pos";
    public static final String FORM_GALPAL3_COLUMN_LONGITUDE = "longitude";
    public static final String FORM_GALPAL3_COLUMN_LATITUDE = "latitude";
    public static final String FORM_GALPAL3_COLUMN_KATEGORI_GALANGAN="kategori_galangan";
    public static final String FORM_GALPAL3_COLUMN_CP="contact_person";
    public static final String FORM_GALPAL3_COLUMN_NO_CP="no_contact_person";
    public static final String FORM_GALPAL3_COLUMN_JABATAN="jabatan";
    public static final String FORM_GALPAL3_COLUMN_EMAIL_CP="email_cp";

    //SUDAH SESUAI DENGAN DATABASE CENTRAL
    //FORM GALPAL 19 TABEL
    public static final String FORM_GALPAL19_TABLE_NAME = "f1_organisasi_bengkel";
    public static final String FORM_GALPAL19_COLUMN_ID = "id_f1_organisasi_bengkel";
    public static final String FORM_GALPAL19_COLUMN_NAMA_BENGKEL = "nama_tempat";
    public static final String FORM_GALPAL19_COLUMN_LUAS = "luas";
    public static final String FORM_GALPAL19_COLUMN_DIMENSI = "dimensi";
    public static final String FORM_GALPAL19_COLUMN_KAPASITAS = "kapasitas";
    public static final String FORM_GALPAL19_COLUMN_STATUS = "status";
    public static final String FORM_GALPAL19_COLUMN_JARAK = "jarak";



    //FORM KOMPAL 1 TABEL
    public static final String FORM_KOMPAL1_TABLE_NAME = "form_kompal1";
    public static final String FORM_KOMPAL1_COLUMN_ID = "id";
    public static final String FORM_KOMPAL1_COLUMN_JARAK_KEDALAMAN = "jarak_kedalaman";
    public static final String FORM_KOMPAL1_COLUMN_AIR_PELAYARAN = "air_pelayaran";
    public static final String FORM_KOMPAL1_COLUMN_PASANG_SURUT = "pasang_surut";
    public static final String FORM_KOMPAL1_COLUMN_ARUS = "arus";
    public static final String FORM_KOMPAL1_COLUMN_GELOMBANG = "gelombang";
    public static final String FORM_KOMPAL1_COLUMN_PANJANG_WATERFRONT = "panjang_waterfront";
    public static final String FORM_KOMPAL1_COLUMN_LUAS_LAHAN = "luas_lahan";
    public static final String FORM_KOMPAL1_COLUMN_KETERSEDIAAN_LAHAN = "ketersediaan_lahan";
    public static final String FORM_KOMPAL1_COLUMN_LAHAN_PRODUKTIF = "lahan_produktif";
    public static final String FORM_KOMPAL1_COLUMN_LAHAN_PEMUKIMAN = "lahan_pemukiman";
    public static final String FORM_KOMPAL1_COLUMN_DAYA_DUKUNG = "daya_dukung";
    public static final String FORM_KOMPAL1_COLUMN_KELANDAIAAN = "kelandaian";
    public static final String FORM_KOMPAL1_COLUMN_DEKAT_JALAN = "dekat_jalan";
    public static final String FORM_KOMPAL1_COLUMN_KOTA = "kota";
    public static final String FORM_KOMPAL1_COLUMN_INTERKONEKSI_ANGKUTAN = "interkoneksi_angkutan";
    public static final String FORM_KOMPAL1_COLUMN_NILAI_EKONOMI = "nilai_ekonomi";
    public static final String FORM_KOMPAL1_COLUMN_PERKEMBANGAN_WILAYAH = "perkembangan_wilayah";
    public static final String FORM_KOMPAL1_COLUMN_RUTWR = "rutwr";



    //FORM KOMPAL2 TABEL
    public static final String FORM_KOMPAL2_TABLE_NAME = "form_kompal2";
    public static final String FORM_KOMPAL2_COLUMN_ID = "id";
    public static final String FORM_KOMPAL2_COLUMN_BAHAN_BAKU = "bahan_Baku";
    public static final String FORM_KOMPAL2_COLUMN_MESIN_SISTEM_ELEKTRIKAL = "mesin_sistem_elektrikal";
    public static final String FORM_KOMPAL2_COLUMN_PERLENGKAPAN_KAPAL = "perlengkapan_kapal";








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
                        "("+UserTable.Cols.USERID+" integer primary key ," +
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
                "create table "+ PerusahaanIdentitasTable.NAME+
                        "("+PerusahaanIdentitasTable.Cols.ID_PERUSAHAAN_IDENTITAS+" integer primary key ," +
                        PerusahaanIdentitasTable.Cols.ID_PERUSAHAAN +" integer," +
                        PerusahaanIdentitasTable.Cols.ID_KUALIFIKASI_SURVEY +" integer," +
                        PerusahaanIdentitasTable.Cols.ALAMAT_PERUSAHAAN +" text," +
                        PerusahaanIdentitasTable.Cols.JALAN_DESA_PERUSAHAAN +" text," +
                        PerusahaanIdentitasTable.Cols.KELURAHAN_PERUSAHAAN +" text," +
                        PerusahaanIdentitasTable.Cols.KECAMATAN_PERUSAHAAN +" text," +
                        PerusahaanIdentitasTable.Cols.ID_KABUPATEN_PERUSAHAAN +" integer," +
                        PerusahaanIdentitasTable.Cols.ID_PROPINSI_PERUSAHAAN +" integer," +
                        PerusahaanIdentitasTable.Cols.TELEPON_PERUSAHAAN +" text," +
                        PerusahaanIdentitasTable.Cols.FAX_PERUSAHAAN +" text," +
                        PerusahaanIdentitasTable.Cols.KODE_POS_PERUSAHAAN +" text," +
                        PerusahaanIdentitasTable.Cols.ALAMAT_PABRIK +" text," +
                        PerusahaanIdentitasTable.Cols.JALAN_DESA_PABRIK +" text," +
                        PerusahaanIdentitasTable.Cols.KELURAHAN_PABRIK +" text," +
                        PerusahaanIdentitasTable.Cols.KECAMATAN_PABRIK +" text," +
                        PerusahaanIdentitasTable.Cols.ID_KABUPATEN_PABRIK +" integer," +
                        PerusahaanIdentitasTable.Cols.ID_PROPINSI_PABRIK +" integer," +
                        PerusahaanIdentitasTable.Cols.TELEPON_PABRIK +" text," +
                        PerusahaanIdentitasTable.Cols.FAX_PABRIK +" text," +
                        PerusahaanIdentitasTable.Cols.KODE_POS_PABRIK +" text," +
                        PerusahaanIdentitasTable.Cols.ID_MST_LOKASI_PABRIK +" integer," +
                        PerusahaanIdentitasTable.Cols.LAHAN_PERUNTUKAN +" text," +
                        PerusahaanIdentitasTable.Cols.LUAS_TANAH_PABRIK +" integer," +
                        PerusahaanIdentitasTable.Cols.NPWP +" text," +
                        PerusahaanIdentitasTable.Cols.NAMA_PIMPINAN +" text," +
                        PerusahaanIdentitasTable.Cols.STATUS_KEPEMILIKAN_USAHA +" text," +
                        PerusahaanIdentitasTable.Cols.KATEGORI_PERUSAHAAN +" text," +
                        PerusahaanIdentitasTable.Cols.ANGGOTA_ASOSIASI +" text," +
                        PerusahaanIdentitasTable.Cols.WEBSITE +" text," +
                        PerusahaanIdentitasTable.Cols.CP_NAMA +" text," +
                        PerusahaanIdentitasTable.Cols.CP_NO +" text," +
                        PerusahaanIdentitasTable.Cols.CP_JABATAN +" text," +
                        PerusahaanIdentitasTable.Cols.CP_EMAIL +" text," +
                        PerusahaanIdentitasTable.Cols.ID_MST_JENIS_INDUSTRI +" integer," +
                        PerusahaanIdentitasTable.Cols.LONGITUDE +" text," +
                        PerusahaanIdentitasTable.Cols.LATITUDE +" text," +
                        PerusahaanIdentitasTable.Cols.LINTANG +" text," +
                        PerusahaanIdentitasTable.Cols.LINTANG_DERAJAT +" integer," +
                        PerusahaanIdentitasTable.Cols.LINTANG_MENIT +" integer," +
                        PerusahaanIdentitasTable.Cols.LINTANG_DETIK +" real," +
                        PerusahaanIdentitasTable.Cols.BUJUR +" text," +
                        PerusahaanIdentitasTable.Cols.BUJUR_DERAJAT +" integer," +
                        PerusahaanIdentitasTable.Cols.BUJUR_MENIT +" int," +
                        PerusahaanIdentitasTable.Cols.BUJUR_DETIK +" real," +
                        PerusahaanIdentitasTable.Cols.CREATED_DATE +" numeric," +
                        PerusahaanIdentitasTable.Cols.CREATED_USER +" text," +
                        PerusahaanIdentitasTable.Cols.CREATED_IP_ADDRESS +" text," +
                        PerusahaanIdentitasTable.Cols.MODIFIED_DATE +" numeric," +
                        PerusahaanIdentitasTable.Cols.MODIFIED_USER +" text," +
                        PerusahaanIdentitasTable.Cols.MODIFIED_IP_ADDRESS +" text)"
        );


        /*//create tabel formgalpal3
        db.execSQL(
                "create table "+FORM_GALPAL3_TABLE_NAME+
                        "("+FORM_GALPAL3_COLUMN_ID+" integer primary key ," +
                        FORM_GALPAL3_COLUMN_NAMA_GALANGAN +" text," +
                        FORM_GALPAL3_COLUMN_NAMA_PERUSAHAAN +" text," +
                        FORM_GALPAL3_COLUMN_NOMOR_DOCK +" text," +
                        FORM_GALPAL3_COLUMN_NOMOR_TELEPON +" text," +
                        FORM_GALPAL3_COLUMN_FAX +" text," +
                        FORM_GALPAL3_COLUMN_ALAMAT +" text," +
                        FORM_GALPAL3_COLUMN_KELURAHAN +" text," +
                        FORM_GALPAL3_COLUMN_KECAMATAN +" text," +
                        FORM_GALPAL3_COLUMN_PROPINSI +" text," +
                        FORM_GALPAL3_COLUMN_KABUPATEN +" text," +
                        FORM_GALPAL3_COLUMN_KODE_POS +" text," +
                        FORM_GALPAL3_COLUMN_LATITUDE +" text," +
                        FORM_GALPAL3_COLUMN_LONGITUDE +" text," +
                        FORM_GALPAL3_COLUMN_KATEGORI_GALANGAN +" text," +
                        FORM_GALPAL3_COLUMN_CP +" text," +
                        FORM_GALPAL3_COLUMN_NO_CP +" text," +
                        FORM_GALPAL3_COLUMN_EMAIL_CP +" text," +
                        FORM_GALPAL3_COLUMN_JABATAN +" text)"
        );

        //create tabel formgalpal19
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
        );


        //create tabel formkompal1
        db.execSQL(
                "create table "+FORM_KOMPAL1_TABLE_NAME+
                        "("+FORM_KOMPAL1_COLUMN_ID+" integer primary key ," +
                        FORM_KOMPAL1_COLUMN_JARAK_KEDALAMAN +" text," +
                        FORM_KOMPAL1_COLUMN_AIR_PELAYARAN +" text," +
                        FORM_KOMPAL1_COLUMN_PASANG_SURUT +" text," +
                        FORM_KOMPAL1_COLUMN_ARUS +" text," +
                        FORM_KOMPAL1_COLUMN_GELOMBANG +" text," +
                        FORM_KOMPAL1_COLUMN_PANJANG_WATERFRONT +" text," +
                        FORM_KOMPAL1_COLUMN_LUAS_LAHAN +" text," +
                        FORM_KOMPAL1_COLUMN_KETERSEDIAAN_LAHAN +" text," +
                        FORM_KOMPAL1_COLUMN_LAHAN_PRODUKTIF +" text," +
                        FORM_KOMPAL1_COLUMN_LAHAN_PEMUKIMAN +" text," +
                        FORM_KOMPAL1_COLUMN_DAYA_DUKUNG +" text," +
                        FORM_KOMPAL1_COLUMN_KELANDAIAAN +" text," +
                        FORM_KOMPAL1_COLUMN_DEKAT_JALAN +" text," +
                        FORM_KOMPAL1_COLUMN_KOTA +" text," +
                        FORM_KOMPAL1_COLUMN_INTERKONEKSI_ANGKUTAN +" text," +
                        FORM_KOMPAL1_COLUMN_NILAI_EKONOMI +" text," +
                        FORM_KOMPAL1_COLUMN_RUTWR +" text," +
                        FORM_KOMPAL1_COLUMN_PERKEMBANGAN_WILAYAH +" text)"
        );

        //create tabel formkompal2
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
