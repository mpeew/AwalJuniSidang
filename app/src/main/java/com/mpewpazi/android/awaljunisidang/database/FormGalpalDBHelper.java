package com.mpewpazi.android.awaljunisidang.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by mpewpazi on 4/7/16.
 */
public class FormGalpalDBHelper extends BaseDBHelper {


    public FormGalpalDBHelper(Context context) {
        super(context);
    }

    //FORM GALPAL 1 OPERATION ----------------------------------------------------------------------------------

    public boolean insertFormIdentitasPerusahaan  (int id,int idPerusahaan,int idKualifikasiSurvey, String statusKepemilikanUsaha,
                                       String nomorTelepon, String fax,String alamat,
                                       String kelurahan, String kecamatan, int propinsi,
                                       int kabupaten, String kodePos, String anggotaAsosiasi,
                                       String kategoriPerusahaan, String contactPerson, String nomorCP,
                                       String jabatan, String emailCp, String website)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(FORM_PERUSAHAAN_IDENTITAS_COLUMN_ID_PERUSAHAAN_IDENTITAS, id);
        contentValues.put(FORM_PERUSAHAAN_IDENTITAS_COLUMN_ID_PERUSAHAAN, idPerusahaan);
        contentValues.put(FORM_PERUSAHAAN_IDENTITAS_COLUMN_ID_KUALIFIKASI_SURVEY, idKualifikasiSurvey);
        contentValues.put(FORM_PERUSAHAAN_IDENTITAS_COLUMN_STATUS_KEPEMILIKAN_USAHA, statusKepemilikanUsaha);
        contentValues.put(FORM_PERUSAHAAN_IDENTITAS_COLUMN_TELEPON_PERUSAHAAN, nomorTelepon);
        contentValues.put(FORM_PERUSAHAAN_IDENTITAS_COLUMN_FAX_PERUSAHAAN, fax);
        contentValues.put(FORM_PERUSAHAAN_IDENTITAS_COLUMN_ALAMAT_PERUSAHAAN, alamat);
        contentValues.put(FORM_PERUSAHAAN_IDENTITAS_COLUMN_KELURAHAN_PERUSAHAAN, kelurahan);
        contentValues.put(FORM_PERUSAHAAN_IDENTITAS_COLUMN_KECAMATAN_PERUSAHAAN, kecamatan);
        contentValues.put(FORM_PERUSAHAAN_IDENTITAS_COLUMN_ID_PROPINSI_PERUSAHAAN, propinsi);
        contentValues.put(FORM_PERUSAHAAN_IDENTITAS_COLUMN_ID_KABUPATEN_PERUSAHAAN, kabupaten);
        contentValues.put(FORM_PERUSAHAAN_IDENTITAS_COLUMN_KODE_POS_PERUSAHAAN, kodePos);
        contentValues.put(FORM_PERUSAHAAN_IDENTITAS_COLUMN_ANGGOTA_ASOSIASI, anggotaAsosiasi);
        contentValues.put(FORM_PERUSAHAAN_IDENTITAS_COLUMN_KATEGORI_PERUSAHAAN, kategoriPerusahaan);
        contentValues.put(FORM_PERUSAHAAN_IDENTITAS_COLUMN_CP_NAMA, contactPerson);
        contentValues.put(FORM_PERUSAHAAN_IDENTITAS_COLUMN_CP_NO, nomorCP);
        contentValues.put(FORM_PERUSAHAAN_IDENTITAS_COLUMN_CP_JABATAN, jabatan);
        contentValues.put(FORM_PERUSAHAAN_IDENTITAS_COLUMN_CP_EMAIL, emailCp);
        contentValues.put(FORM_PERUSAHAAN_IDENTITAS_COLUMN_WEBSITE, website);

        db.insert(FORM_PERUSAHAAN_IDENTITAS_TABLE_NAME, null, contentValues);
        return true;
    }



    public boolean updateFormIdentitasPerusahaan (int id,int idPerusahaan,int idKualifikasiSurvey, String statusKepemilikanUsaha,
                                                  String nomorTelepon, String fax,String alamat,
                                                  String kelurahan, String kecamatan, int propinsi,
                                                  int kabupaten, String kodePos, String anggotaAsosiasi,
                                                  String kategoriPerusahaan, String contactPerson, String nomorCP,
                                                  String jabatan, String emailCp, String website)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(FORM_PERUSAHAAN_IDENTITAS_COLUMN_ID_PERUSAHAAN_IDENTITAS, id);
        contentValues.put(FORM_PERUSAHAAN_IDENTITAS_COLUMN_ID_PERUSAHAAN, idPerusahaan);
        contentValues.put(FORM_PERUSAHAAN_IDENTITAS_COLUMN_ID_KUALIFIKASI_SURVEY, idKualifikasiSurvey);
        contentValues.put(FORM_PERUSAHAAN_IDENTITAS_COLUMN_STATUS_KEPEMILIKAN_USAHA, statusKepemilikanUsaha);
        contentValues.put(FORM_PERUSAHAAN_IDENTITAS_COLUMN_TELEPON_PERUSAHAAN, nomorTelepon);
        contentValues.put(FORM_PERUSAHAAN_IDENTITAS_COLUMN_FAX_PERUSAHAAN, fax);
        contentValues.put(FORM_PERUSAHAAN_IDENTITAS_COLUMN_ALAMAT_PERUSAHAAN, alamat);
        contentValues.put(FORM_PERUSAHAAN_IDENTITAS_COLUMN_KELURAHAN_PERUSAHAAN, kelurahan);
        contentValues.put(FORM_PERUSAHAAN_IDENTITAS_COLUMN_KECAMATAN_PERUSAHAAN, kecamatan);
        contentValues.put(FORM_PERUSAHAAN_IDENTITAS_COLUMN_ID_PROPINSI_PERUSAHAAN, propinsi);
        contentValues.put(FORM_PERUSAHAAN_IDENTITAS_COLUMN_ID_KABUPATEN_PERUSAHAAN, kabupaten);
        contentValues.put(FORM_PERUSAHAAN_IDENTITAS_COLUMN_KODE_POS_PERUSAHAAN, kodePos);
        contentValues.put(FORM_PERUSAHAAN_IDENTITAS_COLUMN_ANGGOTA_ASOSIASI, anggotaAsosiasi);
        contentValues.put(FORM_PERUSAHAAN_IDENTITAS_COLUMN_KATEGORI_PERUSAHAAN, kategoriPerusahaan);
        contentValues.put(FORM_PERUSAHAAN_IDENTITAS_COLUMN_CP_NAMA, contactPerson);
        contentValues.put(FORM_PERUSAHAAN_IDENTITAS_COLUMN_CP_NO, nomorCP);
        contentValues.put(FORM_PERUSAHAAN_IDENTITAS_COLUMN_CP_JABATAN, jabatan);
        contentValues.put(FORM_PERUSAHAAN_IDENTITAS_COLUMN_CP_EMAIL, emailCp);
        contentValues.put(FORM_PERUSAHAAN_IDENTITAS_COLUMN_WEBSITE, website);

        db.update(FORM_PERUSAHAAN_IDENTITAS_TABLE_NAME, contentValues, "id = ? ", new String[] { Integer.toString(id) } );
        return true;
    }





    //FORM GALPAL 3 OPERATION ----------------------------------------------------------------------------------


    public boolean insertFormGalpal3  (int id,String namaPerusahaan, String namaGalangan,String nomorDock,
                                       String nomorTelepon, String fax,String alamat,
                                       String kelurahan, String kecamatan, String propinsi,
                                       String kabupaten, String kodePos, String longitude,String latitude,
                                       String kategoriGalangan, String contactPerson, String nomorCP,
                                       String jabatan, String emailCp)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(FORM_GALPAL3_COLUMN_ID, id);
        contentValues.put(FORM_GALPAL3_COLUMN_NAMA_PERUSAHAAN, namaPerusahaan);
        contentValues.put(FORM_GALPAL3_COLUMN_NAMA_GALANGAN, namaGalangan);
        contentValues.put(FORM_GALPAL3_COLUMN_NOMOR_DOCK, nomorDock);
        contentValues.put(FORM_GALPAL3_COLUMN_NOMOR_TELEPON, nomorTelepon);
        contentValues.put(FORM_GALPAL3_COLUMN_FAX, fax);
        contentValues.put(FORM_GALPAL3_COLUMN_ALAMAT, alamat);
        contentValues.put(FORM_GALPAL3_COLUMN_KELURAHAN, kelurahan);
        contentValues.put(FORM_GALPAL3_COLUMN_KECAMATAN, kecamatan);
        contentValues.put(FORM_GALPAL3_COLUMN_PROPINSI, propinsi);
        contentValues.put(FORM_GALPAL3_COLUMN_KABUPATEN, kabupaten);
        contentValues.put(FORM_GALPAL3_COLUMN_KODE_POS, kodePos);
        contentValues.put(FORM_GALPAL3_COLUMN_LATITUDE, latitude);
        contentValues.put(FORM_GALPAL3_COLUMN_LONGITUDE, longitude);
        contentValues.put(FORM_GALPAL3_COLUMN_KATEGORI_GALANGAN, kategoriGalangan);
        contentValues.put(FORM_GALPAL3_COLUMN_CP, contactPerson);
        contentValues.put(FORM_GALPAL3_COLUMN_NO_CP, nomorCP);
        contentValues.put(FORM_GALPAL3_COLUMN_JABATAN, jabatan);
        contentValues.put(FORM_GALPAL3_COLUMN_EMAIL_CP, emailCp);

        db.insert(FORM_GALPAL3_TABLE_NAME, null, contentValues);
        return true;
    }



    public boolean updateFormGalpal3 (int id,String namaPerusahaan, String namaGalangan,String nomorDock,
                                      String nomorTelepon, String fax,String alamat,
                                      String kelurahan, String kecamatan, String propinsi,
                                      String kabupaten, String kodePos, String longitude,String latitude,
                                      String kategoriGalangan, String contactPerson, String nomorCP,
                                      String jabatan, String emailCp)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(FORM_GALPAL3_COLUMN_ID, id);
        contentValues.put(FORM_GALPAL3_COLUMN_NAMA_PERUSAHAAN, namaPerusahaan);
        contentValues.put(FORM_GALPAL3_COLUMN_NAMA_GALANGAN, namaGalangan);
        contentValues.put(FORM_GALPAL3_COLUMN_NOMOR_DOCK, nomorDock);
        contentValues.put(FORM_GALPAL3_COLUMN_NOMOR_TELEPON, nomorTelepon);
        contentValues.put(FORM_GALPAL3_COLUMN_FAX, fax);
        contentValues.put(FORM_GALPAL3_COLUMN_ALAMAT, alamat);
        contentValues.put(FORM_GALPAL3_COLUMN_KELURAHAN, kelurahan);
        contentValues.put(FORM_GALPAL3_COLUMN_KECAMATAN, kecamatan);
        contentValues.put(FORM_GALPAL3_COLUMN_PROPINSI, propinsi);
        contentValues.put(FORM_GALPAL3_COLUMN_KABUPATEN, kabupaten);
        contentValues.put(FORM_GALPAL3_COLUMN_KODE_POS, kodePos);
        contentValues.put(FORM_GALPAL3_COLUMN_LATITUDE, latitude);
        contentValues.put(FORM_GALPAL3_COLUMN_LONGITUDE, longitude);
        contentValues.put(FORM_GALPAL3_COLUMN_KATEGORI_GALANGAN, kategoriGalangan);
        contentValues.put(FORM_GALPAL3_COLUMN_CP, contactPerson);
        contentValues.put(FORM_GALPAL3_COLUMN_NO_CP, nomorCP);
        contentValues.put(FORM_GALPAL3_COLUMN_JABATAN, jabatan);
        contentValues.put(FORM_GALPAL3_COLUMN_EMAIL_CP, emailCp);
        db.update(FORM_GALPAL3_TABLE_NAME, contentValues, "id = ? ", new String[] { Integer.toString(id) } );
        return true;
    }



}
