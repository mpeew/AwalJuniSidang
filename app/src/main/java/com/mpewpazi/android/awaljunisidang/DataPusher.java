package com.mpewpazi.android.awaljunisidang;

import android.util.Log;

import com.mpewpazi.android.awaljunisidang.Form.FormGalpal1;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal3;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal4;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal6;
import com.mpewpazi.android.awaljunisidang.Form.FormKompal3a;
import com.mpewpazi.android.awaljunisidang.Form.FormKompal3b;
import com.mpewpazi.android.awaljunisidang.Form.FormKompal3c;
import com.mpewpazi.android.awaljunisidang.Form.FormKompal3d;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FG1PerusahaanIdentitasTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FG3GalanganKapalTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FG4TinjauanAreaTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FG6PeralatanKerjaLuarCraneTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FK3aJenisKapasitasProduksiTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FK3bJumlahProduksiTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FK3cSistemBerproduksiTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FK3dStandarMutuTableTable;


/**
 * Created by mpewpazi on 5/20/16.
 */
public class DataPusher {
    private static final String urlPostFG1="http://192.168.1.100/galpal/perusahaanIdentitas/postperusahaanidentitasapi/";
    private static final String urlPostFG3="http://192.168.1.100/galpal/galanganKapal/postgalangankapalapi/";
    private static final String urlPostFG4="http://192.168.1.100/galpal/f1TinjauanArea/postapi/";
    private static final String urlPostFG6="http://192.168.1.100/galpal/f1PeralatanKerjaLrCrane/postapi/";
    private static final String urlPostFK3a="http://192.168.1.100/galpal/f2JenisKapasitasProduksi/postapi/";
    private static final String urlPostFK3b="http://192.168.1.100/galpal/f2JumlahProduksi/postapi/";
    private static final String urlPostFK3c="http://192.168.1.100/galpal/f2SistemBerproduksi/postapi/";
    private static final String urlPostFK3d="http://192.168.1.100/galpal/f2StandardMutu/postapi/";



    public void makePostRequestFG1(FormGalpal1 formGalpal1) {

        HttpClient client = new DefaultHttpClient();
        String postURL = (urlPostFG1);
        HttpPost post = new HttpPost(postURL);
        try {
            // Add the data
            List<NameValuePair> pairs = new ArrayList<>();
            pairs.add(new BasicNameValuePair("Id", String.valueOf(formGalpal1.getIdentitasPerusahaanId())));
            pairs.add(new BasicNameValuePair(encapsulateFG1Cols(FG1PerusahaanIdentitasTable.Cols.ID_KUALIFIKASI_SURVEY), String.valueOf(formGalpal1.getKualifikasiSurveyId())));
            pairs.add(new BasicNameValuePair(encapsulateFG1Cols(FG1PerusahaanIdentitasTable.Cols.ALAMAT_PERUSAHAAN), formGalpal1.getAlamat()));
            pairs.add(new BasicNameValuePair(encapsulateFG1Cols(FG1PerusahaanIdentitasTable.Cols.STATUS_KEPEMILIKAN_USAHA), formGalpal1.getStatusKepemilikanUsaha()));
            pairs.add(new BasicNameValuePair(encapsulateFG1Cols(FG1PerusahaanIdentitasTable.Cols.TELEPON_PERUSAHAAN), formGalpal1.getNomorTelepon()));
            pairs.add(new BasicNameValuePair(encapsulateFG1Cols(FG1PerusahaanIdentitasTable.Cols.FAX_PERUSAHAAN), formGalpal1.getFax()));
            pairs.add(new BasicNameValuePair(encapsulateFG1Cols(FG1PerusahaanIdentitasTable.Cols.KELURAHAN_PERUSAHAAN), formGalpal1.getKelurahan()));
            pairs.add(new BasicNameValuePair(encapsulateFG1Cols(FG1PerusahaanIdentitasTable.Cols.KECAMATAN_PERUSAHAAN), formGalpal1.getKecamatan()));
            pairs.add(new BasicNameValuePair(encapsulateFG1Cols(FG1PerusahaanIdentitasTable.Cols.ID_KABUPATEN_PERUSAHAAN), String.valueOf(formGalpal1.getIdKabupaten_kota())));
            pairs.add(new BasicNameValuePair(encapsulateFG1Cols(FG1PerusahaanIdentitasTable.Cols.ID_PROPINSI_PERUSAHAAN), String.valueOf(formGalpal1.getIdPropinsi())));
            pairs.add(new BasicNameValuePair(encapsulateFG1Cols(FG1PerusahaanIdentitasTable.Cols.KODE_POS_PERUSAHAAN), formGalpal1.getKodePos()));
            pairs.add(new BasicNameValuePair(encapsulateFG1Cols(FG1PerusahaanIdentitasTable.Cols.ANGGOTA_ASOSIASI), formGalpal1.getAnggotaAsosiasi()));
            pairs.add(new BasicNameValuePair(encapsulateFG1Cols(FG1PerusahaanIdentitasTable.Cols.KATEGORI_PERUSAHAAN), formGalpal1.getKategoriPerusahaan()));
            pairs.add(new BasicNameValuePair(encapsulateFG1Cols(FG1PerusahaanIdentitasTable.Cols.CP_NAMA), formGalpal1.getContactPerson()));
            pairs.add(new BasicNameValuePair(encapsulateFG1Cols(FG1PerusahaanIdentitasTable.Cols.CP_NOMOR), formGalpal1.getNomorCp()));
            pairs.add(new BasicNameValuePair(encapsulateFG1Cols(FG1PerusahaanIdentitasTable.Cols.CP_JABATAN), formGalpal1.getJabatan()));
            pairs.add(new BasicNameValuePair(encapsulateFG1Cols(FG1PerusahaanIdentitasTable.Cols.CP_EMAIL), formGalpal1.getEmail()));
            pairs.add(new BasicNameValuePair(encapsulateFG1Cols(FG1PerusahaanIdentitasTable.Cols.WEBSITE), formGalpal1.getWebsite()));
            UrlEncodedFormEntity uefe = new UrlEncodedFormEntity(pairs);
            post.setEntity(uefe);
            // Execute the HTTP Post Request
            HttpResponse response = client.execute(post);
            // Convert the response into a String
            HttpEntity resEntity = response.getEntity();
            if (resEntity != null) {
                Log.i("RESPONSE1", EntityUtils.toString(resEntity));
            }
        } catch (UnsupportedEncodingException uee) {
            uee.printStackTrace();
        } catch (ClientProtocolException cpe) {
            cpe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

    public void makePostRequestFG3(FormGalpal3 formGalpal3) {

        HttpClient client = new DefaultHttpClient();
        String postURL = (urlPostFG3);
        HttpPost post = new HttpPost(postURL);
        try {
            // Add the data
            List<NameValuePair> pairs = new ArrayList<>();
            pairs.add(new BasicNameValuePair("Id", String.valueOf(formGalpal3.getIdentitasUmumGalanganId())));
            pairs.add(new BasicNameValuePair(encapsulateFG3Cols(FG3GalanganKapalTable.Cols.ID_KUALIFIKASI_SURVEY), String.valueOf(formGalpal3.getKualifikasiSurveyId())));

            pairs.add(new BasicNameValuePair(encapsulateFG3Cols(FG3GalanganKapalTable.Cols.NAMA_GALANGAN), formGalpal3.getNamaGalangan()));
            pairs.add(new BasicNameValuePair(encapsulateFG3Cols(FG3GalanganKapalTable.Cols.NOMOR_DOCK), formGalpal3.getNomorDock()));
            pairs.add(new BasicNameValuePair(encapsulateFG3Cols(FG3GalanganKapalTable.Cols.TELEPON_GALANGAN), formGalpal3.getNomorTelepon()));
            pairs.add(new BasicNameValuePair(encapsulateFG3Cols(FG3GalanganKapalTable.Cols.FAX_GALANGAN), formGalpal3.getFax()));
            pairs.add(new BasicNameValuePair(encapsulateFG3Cols(FG3GalanganKapalTable.Cols.ALAMAT_GALANGAN), formGalpal3.getAlamat()));
            pairs.add(new BasicNameValuePair(encapsulateFG3Cols(FG3GalanganKapalTable.Cols.KELURAHAN_GALANGAN), formGalpal3.getKelurahan()));
            pairs.add(new BasicNameValuePair(encapsulateFG3Cols(FG3GalanganKapalTable.Cols.KECAMATAN_GALANGAN), formGalpal3.getKecamatan()));
            pairs.add(new BasicNameValuePair(encapsulateFG3Cols(FG3GalanganKapalTable.Cols.ID_PROPINSI_GALANGAN), String.valueOf(formGalpal3.getPropinsiId())));
            pairs.add(new BasicNameValuePair(encapsulateFG3Cols(FG3GalanganKapalTable.Cols.ID_KABUPATEN_GALANGAN), String.valueOf(formGalpal3.getKebupaten_kotaId())));
            pairs.add(new BasicNameValuePair(encapsulateFG3Cols(FG3GalanganKapalTable.Cols.KODE_POS_GALANGAN), formGalpal3.getKodePos()));
            pairs.add(new BasicNameValuePair(encapsulateFG3Cols(FG3GalanganKapalTable.Cols.LATITUDE), formGalpal3.getLatitude()));
            pairs.add(new BasicNameValuePair(encapsulateFG3Cols(FG3GalanganKapalTable.Cols.LONGITUDE), formGalpal3.getLongitude()));
            pairs.add(new BasicNameValuePair(encapsulateFG3Cols(FG3GalanganKapalTable.Cols.KATEGORI_GALANGAN), formGalpal3.getKategoriGalangan()));
            pairs.add(new BasicNameValuePair(encapsulateFG3Cols(FG3GalanganKapalTable.Cols.CP_NAMA), formGalpal3.getContactPerson()));
            pairs.add(new BasicNameValuePair(encapsulateFG3Cols(FG3GalanganKapalTable.Cols.CP_JABATAN), formGalpal3.getJabatan()));
            pairs.add(new BasicNameValuePair(encapsulateFG3Cols(FG3GalanganKapalTable.Cols.CP_EMAIL), formGalpal3.getEmail()));
            pairs.add(new BasicNameValuePair(encapsulateFG3Cols(FG3GalanganKapalTable.Cols.CP_NO), formGalpal3.getNomorCp()));

            UrlEncodedFormEntity uefe = new UrlEncodedFormEntity(pairs);
            post.setEntity(uefe);
            // Execute the HTTP Post Request
            HttpResponse response = client.execute(post);
            // Convert the response into a String
            HttpEntity resEntity = response.getEntity();
            if (resEntity != null) {
                Log.i("RESPONSE3", EntityUtils.toString(resEntity));
            }
        } catch (UnsupportedEncodingException uee) {
            uee.printStackTrace();
        } catch (ClientProtocolException cpe) {
            cpe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

    public void makePostRequestFG4(FormGalpal4 formGalpal4) {

        HttpClient client = new DefaultHttpClient();
        String postURL = (urlPostFG4);
        HttpPost post = new HttpPost(postURL);
        try {
            // Add the data
            List<NameValuePair> pairs = new ArrayList<>();
            pairs.add(new BasicNameValuePair("Id", String.valueOf(formGalpal4.getTinjauanWilayahMaritimId())));
            pairs.add(new BasicNameValuePair("userid", "mpewpazi"));
            pairs.add(new BasicNameValuePair("password", "49916022Peri"));
            pairs.add(new BasicNameValuePair(encapsulateFG4Cols(FG4TinjauanAreaTable.Cols.ID_KUALIFIKASI_SURVEY), String.valueOf(formGalpal4.getKualifikasiSurveyId())));
            pairs.add(new BasicNameValuePair(encapsulateFG4Cols(FG4TinjauanAreaTable.Cols.ID_PERIODE), String.valueOf(formGalpal4.getIdPeriode())));
            pairs.add(new BasicNameValuePair(encapsulateFG4Cols(FG4TinjauanAreaTable.Cols.ID_MST_JARAK_KEDALAMAN), String.valueOf(formGalpal4.getJarakKedalaman())));
            pairs.add(new BasicNameValuePair(encapsulateFG4Cols(FG4TinjauanAreaTable.Cols.ID_MST_AIR_PELAYARAN), String.valueOf(formGalpal4.getAirPelayaran())));
            pairs.add(new BasicNameValuePair(encapsulateFG4Cols(FG4TinjauanAreaTable.Cols.ID_MST_PASANG_SURUT), String.valueOf(formGalpal4.getPasangSurutPerairan())));
            pairs.add(new BasicNameValuePair(encapsulateFG4Cols(FG4TinjauanAreaTable.Cols.ID_MST_ARUS), String.valueOf(formGalpal4.getArus())));
            pairs.add(new BasicNameValuePair(encapsulateFG4Cols(FG4TinjauanAreaTable.Cols.ID_MST_GELOMBANG), String.valueOf(formGalpal4.getGelombang())));
            pairs.add(new BasicNameValuePair(encapsulateFG4Cols(FG4TinjauanAreaTable.Cols.PANJANG_WATERFRONT), String.valueOf(formGalpal4.getPanjangWaterfront())));
            pairs.add(new BasicNameValuePair(encapsulateFG4Cols(FG4TinjauanAreaTable.Cols.LUAS_LAHAN), String.valueOf(formGalpal4.getLuasLahan())));
            pairs.add(new BasicNameValuePair(encapsulateFG4Cols(FG4TinjauanAreaTable.Cols.KETERSEDIAAN_LAHAN), formGalpal4.getKetersediaanLahan()));
            pairs.add(new BasicNameValuePair(encapsulateFG4Cols(FG4TinjauanAreaTable.Cols.LAHAN_PRODUKTIF), formGalpal4.getLahanProduktif()));
            pairs.add(new BasicNameValuePair(encapsulateFG4Cols(FG4TinjauanAreaTable.Cols.LAHAN_PEMUKIMAN), formGalpal4.getLahanPemukiman()));
            pairs.add(new BasicNameValuePair(encapsulateFG4Cols(FG4TinjauanAreaTable.Cols.PASANG_SURUT), formGalpal4.getPasangSurutDaratan()));
            pairs.add(new BasicNameValuePair(encapsulateFG4Cols(FG4TinjauanAreaTable.Cols.DAYA_DUKUNG), formGalpal4.getDayaDukung()));
            pairs.add(new BasicNameValuePair(encapsulateFG4Cols(FG4TinjauanAreaTable.Cols.KELANDAIAAN), formGalpal4.getKelandaian()));
            pairs.add(new BasicNameValuePair(encapsulateFG4Cols(FG4TinjauanAreaTable.Cols.DEKAT_JALAN), formGalpal4.getDekatJalan()));
            pairs.add(new BasicNameValuePair(encapsulateFG4Cols(FG4TinjauanAreaTable.Cols.KOTA), formGalpal4.getKota()));
            pairs.add(new BasicNameValuePair(encapsulateFG4Cols(FG4TinjauanAreaTable.Cols.INTERKONEKSI_ANGKUTAN), formGalpal4.getInterkoneksiAngkutan()));
            pairs.add(new BasicNameValuePair(encapsulateFG4Cols(FG4TinjauanAreaTable.Cols.NILAI_EKONOMI), formGalpal4.getNilaiEkonomi()));
            pairs.add(new BasicNameValuePair(encapsulateFG4Cols(FG4TinjauanAreaTable.Cols.PERKEMBANGAN_WILAYAH), formGalpal4.getPerkembanganWilayah()));
            pairs.add(new BasicNameValuePair(encapsulateFG4Cols(FG4TinjauanAreaTable.Cols.RUTWR), formGalpal4.getRutrw()));


            UrlEncodedFormEntity uefe = new UrlEncodedFormEntity(pairs);
            post.setEntity(uefe);
            // Execute the HTTP Post Request
            HttpResponse response = client.execute(post);
            // Convert the response into a String
            HttpEntity resEntity = response.getEntity();
            if (resEntity != null) {
                Log.i("RESPONSE4", EntityUtils.toString(resEntity));
            }
        } catch (UnsupportedEncodingException uee) {
            uee.printStackTrace();
        } catch (ClientProtocolException cpe) {
            cpe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

    public void makePostRequestFG6(FormGalpal6 formGalpal6) {

        HttpClient client = new DefaultHttpClient();
        String postURL = (urlPostFG6);
        HttpPost post = new HttpPost(postURL);
        try {
            // Add the data
            List<NameValuePair> pairs = new ArrayList<>();
            pairs.add(new BasicNameValuePair("userid", "mpewpazi"));
            pairs.add(new BasicNameValuePair("password", "49916022Peri"));
            pairs.add(new BasicNameValuePair("Id", String.valueOf(formGalpal6.getIdPeralatanKerjaCraneServer())));
            pairs.add(new BasicNameValuePair(encapsulateFG6Cols(FG6PeralatanKerjaLuarCraneTable.Cols.ID_KUALIFIKASI_SURVEY), String.valueOf(formGalpal6.getKualifikasiSurveyId())));
            pairs.add(new BasicNameValuePair(encapsulateFG6Cols(FG6PeralatanKerjaLuarCraneTable.Cols.ID_PERIODE), String.valueOf(formGalpal6.getIdPeriode())));
            pairs.add(new BasicNameValuePair(encapsulateFG6Cols(FG6PeralatanKerjaLuarCraneTable.Cols.JENIS_MESIN), formGalpal6.getJenisMesin()));
            pairs.add(new BasicNameValuePair(encapsulateFG6Cols(FG6PeralatanKerjaLuarCraneTable.Cols.TAHUN_PEMBUATAN), String.valueOf(formGalpal6.getTahunPembuatan())));
            pairs.add(new BasicNameValuePair(encapsulateFG6Cols(FG6PeralatanKerjaLuarCraneTable.Cols.MERK), formGalpal6.getMerek()));
            pairs.add(new BasicNameValuePair(encapsulateFG6Cols(FG6PeralatanKerjaLuarCraneTable.Cols.KAPASAITAS_TERPASANG), String.valueOf(formGalpal6.getKapasitasTerpasang())));
            pairs.add(new BasicNameValuePair(encapsulateFG6Cols(FG6PeralatanKerjaLuarCraneTable.Cols.SATUAN_KAPASITAS_TERPASANG), formGalpal6.getSatuanKapastiasTerpasang()));
            pairs.add(new BasicNameValuePair(encapsulateFG6Cols(FG6PeralatanKerjaLuarCraneTable.Cols.SATUAN_KAPASITAS_TERPAKAI), formGalpal6.getSatuanKapasitasTerpakai()));
            pairs.add(new BasicNameValuePair(encapsulateFG6Cols(FG6PeralatanKerjaLuarCraneTable.Cols.KAPASITAS_TERPAKAI), String.valueOf(formGalpal6.getKapasitasTerpakai())));
            pairs.add(new BasicNameValuePair(encapsulateFG6Cols(FG6PeralatanKerjaLuarCraneTable.Cols.DIMENSI), formGalpal6.getDimensi()));
            pairs.add(new BasicNameValuePair(encapsulateFG6Cols(FG6PeralatanKerjaLuarCraneTable.Cols.JUMLAH), String.valueOf(formGalpal6.getJumlah())));
            pairs.add(new BasicNameValuePair(encapsulateFG6Cols(FG6PeralatanKerjaLuarCraneTable.Cols.KONDISI), formGalpal6.getKondisi()));
            pairs.add(new BasicNameValuePair(encapsulateFG6Cols(FG6PeralatanKerjaLuarCraneTable.Cols.LOKASI), formGalpal6.getLokasi()));
            pairs.add(new BasicNameValuePair(encapsulateFG6Cols(FG6PeralatanKerjaLuarCraneTable.Cols.STATUS), formGalpal6.getStatus()));

            UrlEncodedFormEntity uefe = new UrlEncodedFormEntity(pairs);
            post.setEntity(uefe);
            // Execute the HTTP Post Request
            HttpResponse response = client.execute(post);
            // Convert the response into a String
            HttpEntity resEntity = response.getEntity();
            if (resEntity != null) {
                Log.i("RESPONSE6", EntityUtils.toString(resEntity));
            }
        } catch (UnsupportedEncodingException uee) {
            uee.printStackTrace();
        } catch (ClientProtocolException cpe) {
            cpe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void makePostRequestFK3a(FormKompal3a formKompal3a) {

        HttpClient client = new DefaultHttpClient();
        String postURL = (urlPostFK3a);
        HttpPost post = new HttpPost(postURL);
        try {
            // Add the data
            List<NameValuePair> pairs = new ArrayList<>();
            pairs.add(new BasicNameValuePair("userid", "mpewpazi"));
            pairs.add(new BasicNameValuePair("password", "49916022Peri"));
            pairs.add(new BasicNameValuePair("Id", String.valueOf(formKompal3a.getIdJenisKapasitasProduksiServer())));
            pairs.add(new BasicNameValuePair(encapsulateFK3aCols(FK3aJenisKapasitasProduksiTable.Cols.ID_KUALIFIKASI_SURVEY), String.valueOf(formKompal3a.getKualifikasiSurveyId())));
            pairs.add(new BasicNameValuePair(encapsulateFK3aCols(FK3aJenisKapasitasProduksiTable.Cols.ID_PERIODE), String.valueOf(formKompal3a.getIdPeriode())));
            pairs.add(new BasicNameValuePair(encapsulateFK3aCols(FK3aJenisKapasitasProduksiTable.Cols.JENIS_PRODUKSI), formKompal3a.getJenisProduksi()));
            pairs.add(new BasicNameValuePair(encapsulateFK3aCols(FK3aJenisKapasitasProduksiTable.Cols.KAPASITAS_PRODUKSI), String.valueOf(formKompal3a.getKapasitasProduksi())));
            pairs.add(new BasicNameValuePair(encapsulateFK3aCols(FK3aJenisKapasitasProduksiTable.Cols.ID_MST_SATUAN), String.valueOf(formKompal3a.getSatuan())));

            UrlEncodedFormEntity uefe = new UrlEncodedFormEntity(pairs);
            post.setEntity(uefe);
            // Execute the HTTP Post Request
            HttpResponse response = client.execute(post);
            // Convert the response into a String
            HttpEntity resEntity = response.getEntity();
            if (resEntity != null) {
                Log.i("RESPONSE3A", EntityUtils.toString(resEntity));
            }
        } catch (UnsupportedEncodingException uee) {
            uee.printStackTrace();
        } catch (ClientProtocolException cpe) {
            cpe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void makePostRequestFK3b(FormKompal3b formKompal3b) {

        HttpClient client = new DefaultHttpClient();
        String postURL = (urlPostFK3b);
        HttpPost post = new HttpPost(postURL);
        try {
            // Add the data
            List<NameValuePair> pairs = new ArrayList<>();
            pairs.add(new BasicNameValuePair("userid", "mpewpazi"));
            pairs.add(new BasicNameValuePair("password", "49916022Peri"));
            pairs.add(new BasicNameValuePair("Id", String.valueOf(formKompal3b.getIdJumlahProduksiServer())));
            pairs.add(new BasicNameValuePair(encapsulateFK3bCols(FK3bJumlahProduksiTable.Cols.ID_KUALIFIKASI_SURVEY), String.valueOf(formKompal3b.getKualifikasiSurveyId())));
            pairs.add(new BasicNameValuePair(encapsulateFK3bCols(FK3bJumlahProduksiTable.Cols.ID_PERIODE), String.valueOf(formKompal3b.getIdPeriode())));
            pairs.add(new BasicNameValuePair(encapsulateFK3bCols(FK3bJumlahProduksiTable.Cols.ID_F2_JENIS_KAPASITAS_PRODUKSI), String.valueOf(formKompal3b.getJenisProdukId())));
            pairs.add(new BasicNameValuePair(encapsulateFK3bCols(FK3bJumlahProduksiTable.Cols.JUMLAH_PROD_NMIN1), String.valueOf(formKompal3b.getJumlahProdThn1())));
            pairs.add(new BasicNameValuePair(encapsulateFK3bCols(FK3bJumlahProduksiTable.Cols.JUMLAH_PROD_NMIN2), String.valueOf(formKompal3b.getJumlahProdThn2())));
            pairs.add(new BasicNameValuePair(encapsulateFK3bCols(FK3bJumlahProduksiTable.Cols.JUMLAH_PROD_NMIN3), String.valueOf(formKompal3b.getJumlahProdThn3())));
            pairs.add(new BasicNameValuePair(encapsulateFK3bCols(FK3bJumlahProduksiTable.Cols.JUMLAH_PROD_NMIN4), String.valueOf(formKompal3b.getJumlahProdThn4())));
            pairs.add(new BasicNameValuePair(encapsulateFK3bCols(FK3bJumlahProduksiTable.Cols.ID_MST_SATUAN), String.valueOf(formKompal3b.getSatuanId())));
            pairs.add(new BasicNameValuePair(encapsulateFK3bCols(FK3bJumlahProduksiTable.Cols.NILAI_PRODUKSI_NMIN1), String.valueOf(formKompal3b.getNilaiProduksiThn1())));
            pairs.add(new BasicNameValuePair(encapsulateFK3bCols(FK3bJumlahProduksiTable.Cols.NILAI_PRODUKSI_NMIN2), String.valueOf(formKompal3b.getNilaiProduksiThn2())));
            pairs.add(new BasicNameValuePair(encapsulateFK3bCols(FK3bJumlahProduksiTable.Cols.NILAI_PRODUKSI_NMIN3), String.valueOf(formKompal3b.getNilaiProduksiThn3())));
            pairs.add(new BasicNameValuePair(encapsulateFK3bCols(FK3bJumlahProduksiTable.Cols.NILAI_PRODUKSI_NMIN4), String.valueOf(formKompal3b.getNilaiProduksiThn4())));
            pairs.add(new BasicNameValuePair(encapsulateFK3bCols(FK3bJumlahProduksiTable.Cols.KETERANGAN), formKompal3b.getKeterangan()));

            UrlEncodedFormEntity uefe = new UrlEncodedFormEntity(pairs);
            post.setEntity(uefe);
            // Execute the HTTP Post Request
            HttpResponse response = client.execute(post);
            // Convert the response into a String
            HttpEntity resEntity = response.getEntity();
            if (resEntity != null) {
                Log.i("RESPONSE3B", EntityUtils.toString(resEntity));
            }
        } catch (UnsupportedEncodingException uee) {
            uee.printStackTrace();
        } catch (ClientProtocolException cpe) {
            cpe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void makePostRequestFK3c(FormKompal3c formKompal3c) {

        HttpClient client = new DefaultHttpClient();
        String postURL = (urlPostFK3c);
        HttpPost post = new HttpPost(postURL);
        try {
            // Add the data
            List<NameValuePair> pairs = new ArrayList<>();
            pairs.add(new BasicNameValuePair("userid", "mpewpazi"));
            pairs.add(new BasicNameValuePair("password", "49916022Peri"));
            pairs.add(new BasicNameValuePair("Id", String.valueOf(formKompal3c.getIdSistemBerproduksiServer())));
            pairs.add(new BasicNameValuePair(encapsulateFK3cCols(FK3cSistemBerproduksiTable.Cols.ID_KUALIFIKASI_SURVEY), String.valueOf(formKompal3c.getKualifikasiSurveyId())));
            pairs.add(new BasicNameValuePair(encapsulateFK3cCols(FK3cSistemBerproduksiTable.Cols.ID_PERIODE), String.valueOf(formKompal3c.getIdPeriode())));
            pairs.add(new BasicNameValuePair(encapsulateFK3cCols(FK3cSistemBerproduksiTable.Cols.NAMA_PRODUK), formKompal3c.getNamaProduk()));
            pairs.add(new BasicNameValuePair(encapsulateFK3cCols(FK3cSistemBerproduksiTable.Cols.ID_MST_JENIS_BERPRODUKSI), String.valueOf(formKompal3c.getSistemProduksi())));
            pairs.add(new BasicNameValuePair(encapsulateFK3cCols(FK3cSistemBerproduksiTable.Cols.ID_MST_JENIS_PRODUKSI), String.valueOf(formKompal3c.getJenisProduksi())));
            pairs.add(new BasicNameValuePair(encapsulateFK3cCols(FK3cSistemBerproduksiTable.Cols.JUMLAH_PROD_NMIN4), String.valueOf(formKompal3c.getJumlahProduksiThn4())));
            pairs.add(new BasicNameValuePair(encapsulateFK3cCols(FK3cSistemBerproduksiTable.Cols.JUMLAH_PROD_NMIN3), String.valueOf(formKompal3c.getJumlahProduksiThn3())));
            pairs.add(new BasicNameValuePair(encapsulateFK3cCols(FK3cSistemBerproduksiTable.Cols.JUMLAH_PROD_NMIN2), String.valueOf(formKompal3c.getJumlahProduksiThn2())));
            pairs.add(new BasicNameValuePair(encapsulateFK3cCols(FK3cSistemBerproduksiTable.Cols.JUMLAH_PROD_NMIN1), String.valueOf(formKompal3c.getJumlahProduksiThn1())));

            UrlEncodedFormEntity uefe = new UrlEncodedFormEntity(pairs);
            post.setEntity(uefe);
            // Execute the HTTP Post Request
            HttpResponse response = client.execute(post);
            // Convert the response into a String
            HttpEntity resEntity = response.getEntity();
            if (resEntity != null) {
                Log.i("RESPONSE3C", EntityUtils.toString(resEntity));
            }
        } catch (UnsupportedEncodingException uee) {
            uee.printStackTrace();
        } catch (ClientProtocolException cpe) {
            cpe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void makePostRequestFK3d(FormKompal3d formKompal3d) {

        HttpClient client = new DefaultHttpClient();
        String postURL = (urlPostFK3d);
        HttpPost post = new HttpPost(postURL);
        try {
            // Add the data
            List<NameValuePair> pairs = new ArrayList<>();
            pairs.add(new BasicNameValuePair("userid", "mpewpazi"));
            pairs.add(new BasicNameValuePair("password", "49916022Peri"));
            pairs.add(new BasicNameValuePair("Id", String.valueOf(formKompal3d.getIdStandarMutuServer())));
            pairs.add(new BasicNameValuePair(encapsulateFK3dCols(FK3dStandarMutuTableTable.Cols.ID_KUALIFIKASI_SURVEY), String.valueOf(formKompal3d.getKualifikasiSurveyId())));
            pairs.add(new BasicNameValuePair(encapsulateFK3dCols(FK3dStandarMutuTableTable.Cols.ID_PERIODE), String.valueOf(formKompal3d.getIdPeriode())));
            pairs.add(new BasicNameValuePair(encapsulateFK3dCols(FK3dStandarMutuTableTable.Cols.JENIS_STANDAR_MUTU), formKompal3d.getJenisStandarMutu()));
            pairs.add(new BasicNameValuePair(encapsulateFK3dCols(FK3dStandarMutuTableTable.Cols.KETERANGAN), formKompal3d.getKeterangan()));

            UrlEncodedFormEntity uefe = new UrlEncodedFormEntity(pairs);
            post.setEntity(uefe);
            // Execute the HTTP Post Request
            HttpResponse response = client.execute(post);
            // Convert the response into a String
            HttpEntity resEntity = response.getEntity();
            if (resEntity != null) {
                Log.i("RESPONSE3D", EntityUtils.toString(resEntity));
            }
        } catch (UnsupportedEncodingException uee) {
            uee.printStackTrace();
        } catch (ClientProtocolException cpe) {
            cpe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }


    private String encapsulateFG1Cols(String cols){
        return "PerusahaanIdentitas["+cols+"]";
    }

    private String encapsulateFG3Cols(String cols){
        return "GalanganKapal["+cols+"]";
    }

    private String encapsulateFG4Cols(String cols){
        return "F1TinjauanArea["+cols+"]";
    }

    private String encapsulateFG6Cols(String cols){
        return "F1PeralatanKerjaLrCrane["+cols+"]";
    }

    private String encapsulateFK3aCols(String cols){
        return "F2JenisKapasitasProduksi["+cols+"]";
    }

    private String encapsulateFK3bCols(String cols){
        return "F2JumlahProduksi["+cols+"]";
    }

    private String encapsulateFK3cCols(String cols){
        return "F2SistemBerproduksi["+cols+"]";
    }

    private String encapsulateFK3dCols(String cols){
        return "F2StandardMutu["+cols+"]";
    }

}
