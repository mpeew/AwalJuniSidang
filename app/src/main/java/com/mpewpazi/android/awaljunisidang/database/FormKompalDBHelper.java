package com.mpewpazi.android.awaljunisidang.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by mpewpazi on 4/8/16.
 */
public class FormKompalDBHelper extends BaseDBHelper {
    public FormKompalDBHelper(Context context) {
        super(context);
    }

    //FORM KOMPAL 1 OPERATION ----------------------------------------------------------------------------------

    public boolean insertFormKompal1  (int id,String jarakKedalaman, String airPelayaran,
                                       String pasangSurut, String arus,String gelombang,
                                       String panjangWaterfornt, String luasLahan, String ketersediaanLahan,
                                       String lahanProduktif, String lahanPemukiman, String dayaDukung,
                                       String kelandaian, String dekatJalan, String kota,
                                       String interkoneksiAngkutan, String nilaiEkonomi, String perkembanganWilayah,
                                       String rutrw)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(FORM_KOMPAL2_COLUMN_ID, id);
        contentValues.put(FORM_KOMPAL1_COLUMN_JARAK_KEDALAMAN, jarakKedalaman);
        contentValues.put(FORM_KOMPAL1_COLUMN_AIR_PELAYARAN, airPelayaran);
        contentValues.put(FORM_KOMPAL1_COLUMN_PASANG_SURUT, pasangSurut);
        contentValues.put(FORM_KOMPAL1_COLUMN_ARUS, arus);
        contentValues.put(FORM_KOMPAL1_COLUMN_GELOMBANG, gelombang);
        contentValues.put(FORM_KOMPAL1_COLUMN_PANJANG_WATERFRONT, panjangWaterfornt);
        contentValues.put(FORM_KOMPAL1_COLUMN_LUAS_LAHAN, luasLahan);
        contentValues.put(FORM_KOMPAL1_COLUMN_KETERSEDIAAN_LAHAN, ketersediaanLahan);
        contentValues.put(FORM_KOMPAL1_COLUMN_LAHAN_PRODUKTIF, lahanProduktif);
        contentValues.put(FORM_KOMPAL1_COLUMN_LAHAN_PEMUKIMAN, lahanPemukiman);
        contentValues.put(FORM_KOMPAL1_COLUMN_PASANG_SURUT, pasangSurut);
        contentValues.put(FORM_KOMPAL1_COLUMN_DAYA_DUKUNG, dayaDukung);
        contentValues.put(FORM_KOMPAL1_COLUMN_KELANDAIAAN, kelandaian);
        contentValues.put(FORM_KOMPAL1_COLUMN_DEKAT_JALAN, dekatJalan);
        contentValues.put(FORM_KOMPAL1_COLUMN_KOTA, kota);
        contentValues.put(FORM_KOMPAL1_COLUMN_INTERKONEKSI_ANGKUTAN, interkoneksiAngkutan);
        contentValues.put(FORM_KOMPAL1_COLUMN_NILAI_EKONOMI, nilaiEkonomi);
        contentValues.put(FORM_KOMPAL1_COLUMN_PERKEMBANGAN_WILAYAH, perkembanganWilayah);
        contentValues.put(FORM_KOMPAL1_COLUMN_RUTWR, rutrw);

        db.insert(FORM_KOMPAL1_TABLE_NAME, null, contentValues);
        return true;
    }


    public boolean updateFormKompal1 (int id,String jarakKedalaman, String airPelayaran,
                                      String pasangSurut, String arus,String gelombang,
                                      String panjangWaterfornt, String luasLahan, String ketersediaanLahan,
                                      String lahanProduktif, String lahanPemukiman, String dayaDukung,
                                      String kelandaian, String dekatJalan, String kota,
                                      String interkoneksiAngkutan, String nilaiEkonomi, String perkembanganWilayah,
                                      String rutrw)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(FORM_KOMPAL2_COLUMN_ID, id);
        contentValues.put(FORM_KOMPAL1_COLUMN_JARAK_KEDALAMAN, jarakKedalaman);
        contentValues.put(FORM_KOMPAL1_COLUMN_AIR_PELAYARAN, airPelayaran);
        contentValues.put(FORM_KOMPAL1_COLUMN_PASANG_SURUT, pasangSurut);
        contentValues.put(FORM_KOMPAL1_COLUMN_ARUS, arus);
        contentValues.put(FORM_KOMPAL1_COLUMN_GELOMBANG, gelombang);
        contentValues.put(FORM_KOMPAL1_COLUMN_PANJANG_WATERFRONT, panjangWaterfornt);
        contentValues.put(FORM_KOMPAL1_COLUMN_LUAS_LAHAN, luasLahan);
        contentValues.put(FORM_KOMPAL1_COLUMN_KETERSEDIAAN_LAHAN, ketersediaanLahan);
        contentValues.put(FORM_KOMPAL1_COLUMN_LAHAN_PRODUKTIF, lahanProduktif);
        contentValues.put(FORM_KOMPAL1_COLUMN_LAHAN_PEMUKIMAN, lahanPemukiman);
        contentValues.put(FORM_KOMPAL1_COLUMN_PASANG_SURUT, pasangSurut);
        contentValues.put(FORM_KOMPAL1_COLUMN_DAYA_DUKUNG, dayaDukung);
        contentValues.put(FORM_KOMPAL1_COLUMN_KELANDAIAAN, kelandaian);
        contentValues.put(FORM_KOMPAL1_COLUMN_DEKAT_JALAN, dekatJalan);
        contentValues.put(FORM_KOMPAL1_COLUMN_KOTA, kota);
        contentValues.put(FORM_KOMPAL1_COLUMN_INTERKONEKSI_ANGKUTAN, interkoneksiAngkutan);
        contentValues.put(FORM_KOMPAL1_COLUMN_NILAI_EKONOMI, nilaiEkonomi);
        contentValues.put(FORM_KOMPAL1_COLUMN_PERKEMBANGAN_WILAYAH, perkembanganWilayah);
        contentValues.put(FORM_KOMPAL1_COLUMN_RUTWR, rutrw);
        db.update(FORM_KOMPAL1_TABLE_NAME, contentValues, "id = ? ", new String[] { Integer.toString(id) } );
        return true;
    }






    //FORM KOMPAL 2 OPERATION ----------------------------------------------------------------------------------
    //


    public boolean insertFormKompal2  (int id,String bahanBaku, String mesinSitemElektrikal,
                                       String perlengkapanKapal)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(FORM_KOMPAL2_COLUMN_ID, id);
        contentValues.put(FORM_KOMPAL2_COLUMN_BAHAN_BAKU, bahanBaku);
        contentValues.put(FORM_KOMPAL2_COLUMN_MESIN_SISTEM_ELEKTRIKAL, mesinSitemElektrikal);
        contentValues.put(FORM_KOMPAL2_COLUMN_PERLENGKAPAN_KAPAL, perlengkapanKapal);

        db.insert(FORM_KOMPAL2_TABLE_NAME, null, contentValues);
        return true;
    }


    public boolean updateFormKompal2 (int id,String bahanBaku, String mesinSitemElektrikal,
                                      String perlengkapanKapal)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(FORM_KOMPAL2_COLUMN_ID, id);
        contentValues.put(FORM_KOMPAL2_COLUMN_BAHAN_BAKU, bahanBaku);
        contentValues.put(FORM_KOMPAL2_COLUMN_MESIN_SISTEM_ELEKTRIKAL, mesinSitemElektrikal);
        contentValues.put(FORM_KOMPAL2_COLUMN_PERLENGKAPAN_KAPAL, perlengkapanKapal);
        db.update(FORM_KOMPAL2_TABLE_NAME, contentValues, "id = ? ", new String[] { Integer.toString(id) } );
        return true;
    }


}
