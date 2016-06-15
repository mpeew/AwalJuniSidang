package com.mpewpazi.android.awaljunisidang.tools;

import android.util.Log;

import com.mpewpazi.android.awaljunisidang.formModel.FormGalpal1;
import com.mpewpazi.android.awaljunisidang.formModel.FormGalpal10;
import com.mpewpazi.android.awaljunisidang.formModel.FormGalpal11;
import com.mpewpazi.android.awaljunisidang.formModel.FormGalpal3;
import com.mpewpazi.android.awaljunisidang.formModel.FormGalpal4;
import com.mpewpazi.android.awaljunisidang.formModel.FormGalpal6;
import com.mpewpazi.android.awaljunisidang.formModel.FormGalpal7;
import com.mpewpazi.android.awaljunisidang.formModel.FormGalpal8;
import com.mpewpazi.android.awaljunisidang.formModel.FormGalpal9;
import com.mpewpazi.android.awaljunisidang.formModel.FormGalpalFoto;
import com.mpewpazi.android.awaljunisidang.formModel.FormKompal3a;
import com.mpewpazi.android.awaljunisidang.formModel.FormKompal3b;
import com.mpewpazi.android.awaljunisidang.formModel.FormKompal3c;
import com.mpewpazi.android.awaljunisidang.formModel.FormKompal3d;
import com.mpewpazi.android.awaljunisidang.formModel.SingleForm;
import com.mpewpazi.android.awaljunisidang.modelExtras.KualifikasiSurvey;
import com.mpewpazi.android.awaljunisidang.modelExtras.MenuCheckingGalpal;
import com.mpewpazi.android.awaljunisidang.modelExtras.MenuCheckingKompal;
import com.mpewpazi.android.awaljunisidang.modelExtras.Notification;

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
import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FG10PeralatanKerjaProduksiElektrikalMekanikal;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FG11PeralatanKerjaProduksiPengecatan;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FG1PerusahaanIdentitasTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FG3GalanganKapalTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FG4TinjauanAreaTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FG6PeralatanKerjaLuarCraneTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FG7PeralatanKerjaLuarTugboatTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FG8PeralatanKerjaProduksiMesinTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FG9PeralatanKerjaProduksiKontruksi;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FK3aJenisKapasitasProduksiTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FK3bJumlahProduksiTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FK3cSistemBerproduksiTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FK3dStandarMutuTableTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.FormGalpalFotoTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.KualifikasiSurveyTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.MenuCheckingGalpalTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.MenuCheckingKompalTable;
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.NotificationTable;


/**
 * Created by mpewpazi on 5/20/16.
 */
public class DataPusher {
    private static final String urlPostFG1="http://192.168.1.100/galpal/perusahaanIdentitas/postperusahaanidentitasapi/";
    private static final String urlPostFG3="http://192.168.1.100/galpal/galanganKapal/postgalangankapalapi/";
    private static final String urlPostFG4="http://192.168.1.100/galpal/f1TinjauanArea/postapi/";
    private static final String urlPostFG6="http://192.168.1.100/galpal/f1PeralatanKerjaLrCrane/postapi/";
    private static final String urlPostFG7="http://192.168.1.100/galpal/f1PeralatanKerjaLrTug/postapi/";
    private static final String urlPostFG8="http://192.168.1.100/galpal/f1PeralatanKerjaProdMesin/postapi/";
    private static final String urlPostFG9="http://192.168.1.100/galpal/f1PeralatanKerjaProdKonstruksi/postapi/";
    private static final String urlPostFG10="http://192.168.1.100/galpal/f1PeralatanKerjaProdElmek/postapi/";
    private static final String urlPostFG11="http://192.168.1.100/galpal/f1PeralatanKerjaProdCat/postapi/";
    public static final String urlPostFGFoto="http://192.168.1.100/galpal/f1FotoGalangan/postfotoapi";

    private static final String urlPostFK3a="http://192.168.1.100/galpal/f2JenisKapasitasProduksi/postapi/";
    private static final String urlPostFK3b="http://192.168.1.100/galpal/f2JumlahProduksi/postapi/";
    private static final String urlPostFK3c="http://192.168.1.100/galpal/f2SistemBerproduksi/postapi/";
    private static final String urlPostFK3d="http://192.168.1.100/galpal/f2StandardMutu/postapi/";

    public static final String urlCheckPostFG1="http://192.168.1.100/galpal/perusahaanIdentitas/postperusahaanidentitasapi/";
    public static final String urlCheckPostFG3="http://192.168.1.100/galpal/galanganKapal/postgalangankapalapi/";
    public static final String urlCheckPostFG4="http://192.168.1.100/galpal/f1TinjauanArea/postcheckapi/";
    public static final String urlCheckPostFG6="http://192.168.1.100/galpal/f1PeralatanKerjaLrCrane/postcheckapi/";
    public static final String urlCheckPostFG7="http://192.168.1.100/galpal/f1PeralatanKerjaLrTug/postcheckapi/";
    public static final String urlCheckPostFG8="http://192.168.1.100/galpal/f1PeralatanKerjaProdMesin/postcheckapi/";
    public static final String urlCheckPostFG9="http://192.168.1.100/galpal/f1PeralatanKerjaProdKonstruksi/postcheckapi/";
    public static final String urlCheckPostFG10="http://192.168.1.100/galpal/f1PeralatanKerjaProdElmek/postcheckapi/";
    public static final String urlCheckPostFG11="http://192.168.1.100/galpal/f1PeralatanKerjaProdCat/postcheckapi/";
    public static final String urlCheckPostFGFoto="http://192.168.1.100/galpal/f1FotoGalangan/postcheckapi";

    public static final String urlCheckPostFK3a="http://192.168.1.100/galpal/f2JenisKapasitasProduksi/postcheckapi/";
    public static final String urlCheckPostFK3b="http://192.168.1.100/galpal/f2JumlahProduksi/postcheckapi/";
    public static final String urlCheckPostFK3c="http://192.168.1.100/galpal/f2SistemBerproduksi/postcheckapi/";
    public static final String urlCheckPostFK3d="http://192.168.1.100/galpal/f2StandardMutu/postcheckapi/";



    private static final String urlPostMenuCheckingGalpal="http://192.168.1.100/galpal/menuF1EntryChecking/postapichecking/";
    private static final String urlPostMenuCheckingKompal="http://192.168.1.100/galpal/menuF2EntryChecking/postapichecking/";

    private static final String urlPostKualifikasiSurvey="http://192.168.1.100/galpal/kualifikasiSurvey/postapi/";
    private static final String urlPostNotification="http://192.168.1.100/galpal/notification/postapi/";
    private static final String urlPostLogin="http://192.168.1.100/galpal/users/authapi/";

    private String mUserid,mPassword;


    public DataPusher(String userid,String password){
        mUserid=userid;
        mPassword=password;
    }

    public DataPusher(){

    }

    public boolean isConflictRequest(SingleForm singleForm, String urlPost){
        String isiResponse="ok";
        HttpClient client = new DefaultHttpClient();
        String postURL = (urlPost);
        HttpPost post = new HttpPost(postURL);
        try {
            // Add the data
            List<NameValuePair> pairs = new ArrayList<>();
            pairs.add(new BasicNameValuePair("id", String.valueOf(singleForm.getKualifikasiSurveyId())));
            pairs.add(new BasicNameValuePair("modified_date",singleForm.getModifyDate()));
            UrlEncodedFormEntity uefe = new UrlEncodedFormEntity(pairs);
            post.setEntity(uefe);
            // Execute the HTTP Post Request
            HttpResponse response = client.execute(post);
            // Convert the response into a String
            HttpEntity resEntity = response.getEntity();
           //
            if (resEntity != null) {
                isiResponse=EntityUtils.toString(resEntity);
                Log.i("RESPONSE1", isiResponse);
            }



        } catch (UnsupportedEncodingException uee) {
            uee.printStackTrace();
        } catch (ClientProtocolException cpe) {
            cpe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        if(isiResponse.equals("\"conflict\"")){
            return true;
        }else{
            return false;
        }
    }

    public void makePostRequestFG1(FormGalpal1 formGalpal1) {
        HttpClient client = new DefaultHttpClient();
        String postURL = (urlPostFG1);
        HttpPost post = new HttpPost(postURL);
        try {
            // Add the data
            List<NameValuePair> pairs = new ArrayList<>();
            pairs.add(new BasicNameValuePair("id", String.valueOf(formGalpal1.getIdentitasPerusahaanId())));
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
                Log.i("PushFG1", EntityUtils.toString(resEntity));
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
            pairs.add(new BasicNameValuePair("id", String.valueOf(formGalpal3.getIdentitasUmumGalanganId())));
            pairs.add(new BasicNameValuePair(encapsulateFG3Cols(FG3GalanganKapalTable.Cols.ID_KUALIFIKASI_SURVEY), String.valueOf(formGalpal3.getKualifikasiSurveyId())));
            pairs.add(new BasicNameValuePair(encapsulateFG3Cols(FG3GalanganKapalTable.Cols.ID_PERIODE), String.valueOf("0")));
            pairs.add(new BasicNameValuePair(encapsulateFG3Cols(FG3GalanganKapalTable.Cols.NAMA_GALANGAN), formGalpal3.getNamaGalangan()));
            pairs.add(new BasicNameValuePair(encapsulateFG3Cols(FG3GalanganKapalTable.Cols.NOMOR_DOCK), formGalpal3.getNomorDock()));
            pairs.add(new BasicNameValuePair(encapsulateFG3Cols(FG3GalanganKapalTable.Cols.TELEPON_GALANGAN), formGalpal3.getNomorTelepon()));
            pairs.add(new BasicNameValuePair(encapsulateFG3Cols(FG3GalanganKapalTable.Cols.FAX_GALANGAN), formGalpal3.getFax()));
            pairs.add(new BasicNameValuePair(encapsulateFG3Cols(FG3GalanganKapalTable.Cols.ALAMAT_GALANGAN), formGalpal3.getAlamat()));
            pairs.add(new BasicNameValuePair(encapsulateFG3Cols(FG3GalanganKapalTable.Cols.KELURAHAN_GALANGAN), formGalpal3.getKelurahan()));
            pairs.add(new BasicNameValuePair(encapsulateFG3Cols(FG3GalanganKapalTable.Cols.KECAMATAN_GALANGAN), formGalpal3.getKecamatan()));
            pairs.add(new BasicNameValuePair(encapsulateFG3Cols(FG3GalanganKapalTable.Cols.ID_PROPINSI_GALANGAN), String.valueOf(formGalpal3.getIdPropinsi())));
            pairs.add(new BasicNameValuePair(encapsulateFG3Cols(FG3GalanganKapalTable.Cols.ID_KABUPATEN_GALANGAN), String.valueOf(formGalpal3.getIdKabupaten_kota())));
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
                Log.i("PushFG3", EntityUtils.toString(resEntity));
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
            pairs.add(new BasicNameValuePair("id", String.valueOf(formGalpal4.getTinjauanWilayahMaritimId())));
            pairs.add(new BasicNameValuePair("userid", mUserid));
            pairs.add(new BasicNameValuePair("password", mPassword));
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
                Log.i("PushFG4", EntityUtils.toString(resEntity));
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
            pairs.add(new BasicNameValuePair("userid", mUserid));
            pairs.add(new BasicNameValuePair("password", mPassword));
            if(formGalpal6.getFormServerId()!=0) {
                pairs.add(new BasicNameValuePair("id", String.valueOf(formGalpal6.getFormServerId())));
            }
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
                Log.i("PushFG6", EntityUtils.toString(resEntity));
            }
            if(formGalpal6.getFormServerId()==0) {
                new DataFetcher().fetchFormLastInsert(formGalpal6,DataFetcher.FG6ENDPOINT, FG6PeralatanKerjaLuarCraneTable.Cols.ID_F1_PERALATAN_KERJA_LR_CRANE_SERVER);
            }
            new DataFetcher().fetchModifyDate(formGalpal6,DataFetcher.FG6ENDPOINT, FG6PeralatanKerjaLuarCraneTable.Cols.ID_F1_PERALATAN_KERJA_LR_CRANE_SERVER);
        } catch (UnsupportedEncodingException uee) {
            uee.printStackTrace();
        } catch (ClientProtocolException cpe) {
            cpe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void makePostRequestFG7(FormGalpal7 formGalpal7) {

        HttpClient client = new DefaultHttpClient();
        String postURL = (urlPostFG7);
        HttpPost post = new HttpPost(postURL);
        try {
            // Add the data
            List<NameValuePair> pairs = new ArrayList<>();
            pairs.add(new BasicNameValuePair("userid", mUserid));
            pairs.add(new BasicNameValuePair("password", mPassword));
            if(formGalpal7.getFormServerId()!=0) {
                pairs.add(new BasicNameValuePair("id", String.valueOf(formGalpal7.getFormServerId())));
            }
            pairs.add(new BasicNameValuePair(encapsulateFG7Cols(FG7PeralatanKerjaLuarTugboatTable.Cols.ID_KUALIFIKASI_SURVEY), String.valueOf(formGalpal7.getKualifikasiSurveyId())));
            pairs.add(new BasicNameValuePair(encapsulateFG7Cols(FG7PeralatanKerjaLuarTugboatTable.Cols.ID_PERIODE), String.valueOf(formGalpal7.getIdPeriode())));
            pairs.add(new BasicNameValuePair(encapsulateFG7Cols(FG7PeralatanKerjaLuarTugboatTable.Cols.JENIS_MESIN), formGalpal7.getJenisPeralatan()));
            pairs.add(new BasicNameValuePair(encapsulateFG7Cols(FG7PeralatanKerjaLuarTugboatTable.Cols.TAHUN_PEMBUATAN), String.valueOf(formGalpal7.getTahunPembuatan())));
            pairs.add(new BasicNameValuePair(encapsulateFG7Cols(FG7PeralatanKerjaLuarTugboatTable.Cols.MERK), formGalpal7.getMerek()));
            pairs.add(new BasicNameValuePair(encapsulateFG7Cols(FG7PeralatanKerjaLuarTugboatTable.Cols.KAPASAITAS_TERPASANG), String.valueOf(formGalpal7.getKapasitasTerpasang())));
            pairs.add(new BasicNameValuePair(encapsulateFG7Cols(FG7PeralatanKerjaLuarTugboatTable.Cols.SATUAN_KAPASITAS_TERPASANG), formGalpal7.getSatuanKapastiasTerpasang()));
            pairs.add(new BasicNameValuePair(encapsulateFG7Cols(FG7PeralatanKerjaLuarTugboatTable.Cols.SATUAN_KAPASITAS_TERPAKAI), formGalpal7.getSatuanKapasitasTerpakai()));
            pairs.add(new BasicNameValuePair(encapsulateFG7Cols(FG7PeralatanKerjaLuarTugboatTable.Cols.KAPASITAS_TERPAKAI), String.valueOf(formGalpal7.getKapasitasTerpakai())));
            pairs.add(new BasicNameValuePair(encapsulateFG7Cols(FG7PeralatanKerjaLuarTugboatTable.Cols.DIMENSI), formGalpal7.getDimensi()));
            pairs.add(new BasicNameValuePair(encapsulateFG7Cols(FG7PeralatanKerjaLuarTugboatTable.Cols.JUMLAH), String.valueOf(formGalpal7.getJumlah())));
            pairs.add(new BasicNameValuePair(encapsulateFG7Cols(FG7PeralatanKerjaLuarTugboatTable.Cols.KONDISI), formGalpal7.getKondisi()));
            pairs.add(new BasicNameValuePair(encapsulateFG7Cols(FG7PeralatanKerjaLuarTugboatTable.Cols.LOKASI), formGalpal7.getLokasi()));
            pairs.add(new BasicNameValuePair(encapsulateFG7Cols(FG7PeralatanKerjaLuarTugboatTable.Cols.STATUS), formGalpal7.getStatus()));

            UrlEncodedFormEntity uefe = new UrlEncodedFormEntity(pairs);
            post.setEntity(uefe);
            // Execute the HTTP Post Request
            HttpResponse response = client.execute(post);
            // Convert the response into a String
            HttpEntity resEntity = response.getEntity();
            if (resEntity != null) {
                Log.i("PushFG7", EntityUtils.toString(resEntity));
            }
            if(formGalpal7.getFormServerId()==0) {
                new DataFetcher().fetchFormLastInsert(formGalpal7,DataFetcher.FG7ENDPOINT,FG7PeralatanKerjaLuarTugboatTable.Cols.ID_F1_PERALATAN_KERJA_LR_TUG_SERVER);
            }
            new DataFetcher().fetchModifyDate(formGalpal7,DataFetcher.FG7ENDPOINT,FG7PeralatanKerjaLuarTugboatTable.Cols.ID_F1_PERALATAN_KERJA_LR_TUG_SERVER);
        } catch (UnsupportedEncodingException uee) {
            uee.printStackTrace();
        } catch (ClientProtocolException cpe) {
            cpe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void makePostRequestFG8(FormGalpal8 formGalpal8) {

        HttpClient client = new DefaultHttpClient();
        String postURL = (urlPostFG8);
        HttpPost post = new HttpPost(postURL);
        try {
            // Add the data
            List<NameValuePair> pairs = new ArrayList<>();
            pairs.add(new BasicNameValuePair("userid", mUserid));
            pairs.add(new BasicNameValuePair("password", mPassword));
            if(formGalpal8.getFormServerId()!=0) {
                pairs.add(new BasicNameValuePair("id", String.valueOf(formGalpal8.getFormServerId())));
            }
            pairs.add(new BasicNameValuePair(encapsulateFG8Cols(FG8PeralatanKerjaProduksiMesinTable.Cols.ID_KUALIFIKASI_SURVEY), String.valueOf(formGalpal8.getKualifikasiSurveyId())));
            pairs.add(new BasicNameValuePair(encapsulateFG8Cols(FG8PeralatanKerjaProduksiMesinTable.Cols.ID_PERIODE), String.valueOf(formGalpal8.getIdPeriode())));
            pairs.add(new BasicNameValuePair(encapsulateFG8Cols(FG8PeralatanKerjaProduksiMesinTable.Cols.JENIS_MESIN), formGalpal8.getJenisMesin()));
            pairs.add(new BasicNameValuePair(encapsulateFG8Cols(FG8PeralatanKerjaProduksiMesinTable.Cols.TAHUN_PEMBUATAN), String.valueOf(formGalpal8.getTahunPembuatan())));
            pairs.add(new BasicNameValuePair(encapsulateFG8Cols(FG8PeralatanKerjaProduksiMesinTable.Cols.MERK), formGalpal8.getMerek()));
            pairs.add(new BasicNameValuePair(encapsulateFG8Cols(FG8PeralatanKerjaProduksiMesinTable.Cols.KAPASAITAS_TERPASANG), String.valueOf(formGalpal8.getKapasitasTerpasang())));
            pairs.add(new BasicNameValuePair(encapsulateFG8Cols(FG8PeralatanKerjaProduksiMesinTable.Cols.SATUAN_KAPASITAS_TERPASANG), formGalpal8.getSatuanKapastiasTerpasang()));
            pairs.add(new BasicNameValuePair(encapsulateFG8Cols(FG8PeralatanKerjaProduksiMesinTable.Cols.SATUAN_KAPASITAS_TERPAKAI), formGalpal8.getSatuanKapasitasTerpakai()));
            pairs.add(new BasicNameValuePair(encapsulateFG8Cols(FG8PeralatanKerjaProduksiMesinTable.Cols.KAPASITAS_TERPAKAI), String.valueOf(formGalpal8.getKapasitasTerpakai())));
            pairs.add(new BasicNameValuePair(encapsulateFG8Cols(FG8PeralatanKerjaProduksiMesinTable.Cols.DIMENSI), formGalpal8.getDimensi()));
            pairs.add(new BasicNameValuePair(encapsulateFG8Cols(FG8PeralatanKerjaProduksiMesinTable.Cols.JUMLAH), String.valueOf(formGalpal8.getJumlah())));
            pairs.add(new BasicNameValuePair(encapsulateFG8Cols(FG8PeralatanKerjaProduksiMesinTable.Cols.KONDISI), formGalpal8.getKondisi()));
            pairs.add(new BasicNameValuePair(encapsulateFG8Cols(FG8PeralatanKerjaProduksiMesinTable.Cols.LOKASI), formGalpal8.getLokasi()));
            pairs.add(new BasicNameValuePair(encapsulateFG8Cols(FG8PeralatanKerjaProduksiMesinTable.Cols.STATUS), formGalpal8.getStatus()));

            UrlEncodedFormEntity uefe = new UrlEncodedFormEntity(pairs);
            post.setEntity(uefe);
            // Execute the HTTP Post Request
            HttpResponse response = client.execute(post);
            // Convert the response into a String
            HttpEntity resEntity = response.getEntity();
            if (resEntity != null) {
                Log.i("PushFG8", EntityUtils.toString(resEntity));
            }
            if(formGalpal8.getFormServerId()==0) {
                new DataFetcher().fetchFormLastInsert(formGalpal8,DataFetcher.FG8ENDPOINT,FG8PeralatanKerjaProduksiMesinTable.Cols.ID_F1_PERALATAN_KERJA_PROD_MESIN_SERVER);
            }
            new DataFetcher().fetchModifyDate(formGalpal8,DataFetcher.FG8ENDPOINT,FG8PeralatanKerjaProduksiMesinTable.Cols.ID_F1_PERALATAN_KERJA_PROD_MESIN_SERVER);
        } catch (UnsupportedEncodingException uee) {
            uee.printStackTrace();
        } catch (ClientProtocolException cpe) {
            cpe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void makePostRequestFG9(FormGalpal9 formGalpal9) {
        HttpClient client = new DefaultHttpClient();
        String postURL = (urlPostFG9);
        HttpPost post = new HttpPost(postURL);
        try {
            // Add the data
            List<NameValuePair> pairs = new ArrayList<>();
            pairs.add(new BasicNameValuePair("userid", mUserid));
            pairs.add(new BasicNameValuePair("password", mPassword));
            if(formGalpal9.getFormServerId()!=0) {
                pairs.add(new BasicNameValuePair("id", String.valueOf(formGalpal9.getFormServerId())));
            }
            pairs.add(new BasicNameValuePair(encapsulateFG9Cols(FG9PeralatanKerjaProduksiKontruksi.Cols.ID_KUALIFIKASI_SURVEY), String.valueOf(formGalpal9.getKualifikasiSurveyId())));
            pairs.add(new BasicNameValuePair(encapsulateFG9Cols(FG9PeralatanKerjaProduksiKontruksi.Cols.ID_PERIODE), String.valueOf(formGalpal9.getIdPeriode())));
            pairs.add(new BasicNameValuePair(encapsulateFG9Cols(FG9PeralatanKerjaProduksiKontruksi.Cols.JENIS_MESIN), formGalpal9.getJenisMesin()));
            pairs.add(new BasicNameValuePair(encapsulateFG9Cols(FG9PeralatanKerjaProduksiKontruksi.Cols.TAHUN_PEMBUATAN), String.valueOf(formGalpal9.getTahunPembuatan())));
            pairs.add(new BasicNameValuePair(encapsulateFG9Cols(FG9PeralatanKerjaProduksiKontruksi.Cols.MERK), formGalpal9.getMerek()));
            pairs.add(new BasicNameValuePair(encapsulateFG9Cols(FG9PeralatanKerjaProduksiKontruksi.Cols.KAPASAITAS_TERPASANG), String.valueOf(formGalpal9.getKapasitasTerpasang())));
            pairs.add(new BasicNameValuePair(encapsulateFG9Cols(FG9PeralatanKerjaProduksiKontruksi.Cols.SATUAN_KAPASITAS_TERPASANG), formGalpal9.getSatuanKapastiasTerpasang()));
            pairs.add(new BasicNameValuePair(encapsulateFG9Cols(FG9PeralatanKerjaProduksiKontruksi.Cols.SATUAN_KAPASITAS_TERPAKAI), formGalpal9.getSatuanKapasitasTerpakai()));
            pairs.add(new BasicNameValuePair(encapsulateFG9Cols(FG9PeralatanKerjaProduksiKontruksi.Cols.KAPASITAS_TERPAKAI), String.valueOf(formGalpal9.getKapasitasTerpakai())));
            pairs.add(new BasicNameValuePair(encapsulateFG9Cols(FG9PeralatanKerjaProduksiKontruksi.Cols.DIMENSI), formGalpal9.getDimensi()));
            pairs.add(new BasicNameValuePair(encapsulateFG9Cols(FG9PeralatanKerjaProduksiKontruksi.Cols.JUMLAH), String.valueOf(formGalpal9.getJumlah())));
            pairs.add(new BasicNameValuePair(encapsulateFG9Cols(FG9PeralatanKerjaProduksiKontruksi.Cols.KONDISI), formGalpal9.getKondisi()));
            pairs.add(new BasicNameValuePair(encapsulateFG9Cols(FG9PeralatanKerjaProduksiKontruksi.Cols.LOKASI), formGalpal9.getLokasi()));
            pairs.add(new BasicNameValuePair(encapsulateFG9Cols(FG9PeralatanKerjaProduksiKontruksi.Cols.STATUS), formGalpal9.getStatus()));

            UrlEncodedFormEntity uefe = new UrlEncodedFormEntity(pairs);
            post.setEntity(uefe);
            // Execute the HTTP Post Request
            HttpResponse response = client.execute(post);
            // Convert the response into a String
            HttpEntity resEntity = response.getEntity();
            if (resEntity != null) {
                Log.i("PushFG9", EntityUtils.toString(resEntity));
            }
            if(formGalpal9.getFormServerId()==0) {
                new DataFetcher().fetchFormLastInsert(formGalpal9,DataFetcher.FG9ENDPOINT,FG9PeralatanKerjaProduksiKontruksi.Cols.ID_F1_PERALATAN_KERJA_PRODUKSI_KONTRUKSI_SERVER);
            }
            new DataFetcher().fetchModifyDate(formGalpal9,DataFetcher.FG9ENDPOINT,FG9PeralatanKerjaProduksiKontruksi.Cols.ID_F1_PERALATAN_KERJA_PRODUKSI_KONTRUKSI_SERVER);
        } catch (UnsupportedEncodingException uee) {
            uee.printStackTrace();
        } catch (ClientProtocolException cpe) {
            cpe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void makePostRequestFG10(FormGalpal10 formGalpal10) {

        HttpClient client = new DefaultHttpClient();
        String postURL = (urlPostFG10);
        HttpPost post = new HttpPost(postURL);
        try {
            // Add the data
            List<NameValuePair> pairs = new ArrayList<>();
            pairs.add(new BasicNameValuePair("userid", mUserid));
            pairs.add(new BasicNameValuePair("password", mPassword));
            if(formGalpal10.getFormServerId()!=0) {
                pairs.add(new BasicNameValuePair("id", String.valueOf(formGalpal10.getFormServerId())));
            }
            pairs.add(new BasicNameValuePair(encapsulateFG10Cols(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.ID_KUALIFIKASI_SURVEY), String.valueOf(formGalpal10.getKualifikasiSurveyId())));
            pairs.add(new BasicNameValuePair(encapsulateFG10Cols(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.ID_PERIODE), String.valueOf(formGalpal10.getIdPeriode())));
            pairs.add(new BasicNameValuePair(encapsulateFG10Cols(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.JENIS_MESIN), formGalpal10.getJenisMesin()));
            pairs.add(new BasicNameValuePair(encapsulateFG10Cols(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.TAHUN_PEMBUATAN), String.valueOf(formGalpal10.getTahunPembuatan())));
            pairs.add(new BasicNameValuePair(encapsulateFG10Cols(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.MERK), formGalpal10.getMerek()));
            pairs.add(new BasicNameValuePair(encapsulateFG10Cols(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.KAPASAITAS_TERPASANG), String.valueOf(formGalpal10.getKapasitasTerpasang())));
            pairs.add(new BasicNameValuePair(encapsulateFG10Cols(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.SATUAN_KAPASITAS_TERPASANG), formGalpal10.getSatuanKapastiasTerpasang()));
            pairs.add(new BasicNameValuePair(encapsulateFG10Cols(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.SATUAN_KAPASITAS_TERPAKAI), formGalpal10.getSatuanKapasitasTerpakai()));
            pairs.add(new BasicNameValuePair(encapsulateFG10Cols(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.KAPASITAS_TERPAKAI), String.valueOf(formGalpal10.getKapasitasTerpakai())));
            pairs.add(new BasicNameValuePair(encapsulateFG10Cols(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.DIMENSI), formGalpal10.getDimensi()));
            pairs.add(new BasicNameValuePair(encapsulateFG10Cols(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.JUMLAH), String.valueOf(formGalpal10.getJumlah())));
            pairs.add(new BasicNameValuePair(encapsulateFG10Cols(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.KONDISI), formGalpal10.getKondisi()));
            pairs.add(new BasicNameValuePair(encapsulateFG10Cols(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.LOKASI), formGalpal10.getLokasi()));
            pairs.add(new BasicNameValuePair(encapsulateFG10Cols(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.STATUS), formGalpal10.getStatus()));

            UrlEncodedFormEntity uefe = new UrlEncodedFormEntity(pairs);
            post.setEntity(uefe);
            // Execute the HTTP Post Request
            HttpResponse response = client.execute(post);
            // Convert the response into a String
            HttpEntity resEntity = response.getEntity();
            if (resEntity != null) {
                Log.i("PushFG10", EntityUtils.toString(resEntity));
            }
            if(formGalpal10.getFormServerId()==0) {
                new DataFetcher().fetchFormLastInsert(formGalpal10,DataFetcher.FG10ENDPOINT,FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.ID_F1_PERALATAN_KERJA_PRODUKSI_ELMEK_SERVER);
            }
            new DataFetcher().fetchModifyDate(formGalpal10,DataFetcher.FG10ENDPOINT,FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.ID_F1_PERALATAN_KERJA_PRODUKSI_ELMEK_SERVER);
        } catch (UnsupportedEncodingException uee) {
            uee.printStackTrace();
        } catch (ClientProtocolException cpe) {
            cpe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void makePostRequestFG11(FormGalpal11 formGalpal11) {

        HttpClient client = new DefaultHttpClient();
        String postURL = (urlPostFG11);
        HttpPost post = new HttpPost(postURL);
        try {
            // Add the data
            List<NameValuePair> pairs = new ArrayList<>();
            pairs.add(new BasicNameValuePair("userid", mUserid));
            pairs.add(new BasicNameValuePair("password", mPassword));
            if(formGalpal11.getFormServerId()!=0) {
                pairs.add(new BasicNameValuePair("id", String.valueOf(formGalpal11.getFormServerId())));
            }
            pairs.add(new BasicNameValuePair(encapsulateFG11Cols(FG11PeralatanKerjaProduksiPengecatan.Cols.ID_KUALIFIKASI_SURVEY), String.valueOf(formGalpal11.getKualifikasiSurveyId())));
            pairs.add(new BasicNameValuePair(encapsulateFG11Cols(FG11PeralatanKerjaProduksiPengecatan.Cols.ID_PERIODE), String.valueOf(formGalpal11.getIdPeriode())));
            pairs.add(new BasicNameValuePair(encapsulateFG11Cols(FG11PeralatanKerjaProduksiPengecatan.Cols.JENIS_MESIN), formGalpal11.getJenisMesin()));
            pairs.add(new BasicNameValuePair(encapsulateFG11Cols(FG11PeralatanKerjaProduksiPengecatan.Cols.TAHUN_PEMBUATAN), String.valueOf(formGalpal11.getTahunPembuatan())));
            pairs.add(new BasicNameValuePair(encapsulateFG11Cols(FG11PeralatanKerjaProduksiPengecatan.Cols.MERK), formGalpal11.getMerek()));
            pairs.add(new BasicNameValuePair(encapsulateFG11Cols(FG11PeralatanKerjaProduksiPengecatan.Cols.KAPASAITAS_TERPASANG), String.valueOf(formGalpal11.getKapasitasTerpasang())));
            pairs.add(new BasicNameValuePair(encapsulateFG11Cols(FG11PeralatanKerjaProduksiPengecatan.Cols.SATUAN_KAPASITAS_TERPASANG), formGalpal11.getSatuanKapastiasTerpasang()));
            pairs.add(new BasicNameValuePair(encapsulateFG11Cols(FG11PeralatanKerjaProduksiPengecatan.Cols.SATUAN_KAPASITAS_TERPAKAI), formGalpal11.getSatuanKapasitasTerpakai()));
            pairs.add(new BasicNameValuePair(encapsulateFG11Cols(FG11PeralatanKerjaProduksiPengecatan.Cols.KAPASITAS_TERPAKAI), String.valueOf(formGalpal11.getKapasitasTerpakai())));
            pairs.add(new BasicNameValuePair(encapsulateFG11Cols(FG11PeralatanKerjaProduksiPengecatan.Cols.DIMENSI), formGalpal11.getDimensi()));
            pairs.add(new BasicNameValuePair(encapsulateFG11Cols(FG11PeralatanKerjaProduksiPengecatan.Cols.JUMLAH), String.valueOf(formGalpal11.getJumlah())));
            pairs.add(new BasicNameValuePair(encapsulateFG11Cols(FG11PeralatanKerjaProduksiPengecatan.Cols.KONDISI), formGalpal11.getKondisi()));
            pairs.add(new BasicNameValuePair(encapsulateFG11Cols(FG11PeralatanKerjaProduksiPengecatan.Cols.LOKASI), formGalpal11.getLokasi()));
            pairs.add(new BasicNameValuePair(encapsulateFG11Cols(FG11PeralatanKerjaProduksiPengecatan.Cols.STATUS), formGalpal11.getStatus()));

            UrlEncodedFormEntity uefe = new UrlEncodedFormEntity(pairs);
            post.setEntity(uefe);
            // Execute the HTTP Post Request
            HttpResponse response = client.execute(post);
            // Convert the response into a String
            HttpEntity resEntity = response.getEntity();
            if (resEntity != null) {
                Log.i("PushFG11", EntityUtils.toString(resEntity));
            }
            if(formGalpal11.getFormServerId()==0) {
                new DataFetcher().fetchFormLastInsert(formGalpal11,DataFetcher.FG11ENDPOINT,FG11PeralatanKerjaProduksiPengecatan.Cols.ID_F1_PERALATAN_KERJA_PRODUKSI_CAT_SERVER);
            }
            new DataFetcher().fetchModifyDate(formGalpal11,DataFetcher.FG11ENDPOINT,FG11PeralatanKerjaProduksiPengecatan.Cols.ID_F1_PERALATAN_KERJA_PRODUKSI_CAT_SERVER);
        } catch (UnsupportedEncodingException uee) {
            uee.printStackTrace();
        } catch (ClientProtocolException cpe) {
            cpe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void makePostRequestFGFoto(FormGalpalFoto formGalpalFoto) {

        HttpClient client = new DefaultHttpClient();
        String postURL = (urlPostFGFoto);
        HttpPost post = new HttpPost(postURL);
        try {
            // Add the data
            List<NameValuePair> pairs = new ArrayList<>();
            pairs.add(new BasicNameValuePair("userid", mUserid));
            pairs.add(new BasicNameValuePair("password", mPassword));
            if(formGalpalFoto.getFormServerId()!=0) {
                pairs.add(new BasicNameValuePair("id", String.valueOf(formGalpalFoto.getFormServerId())));
            }
            pairs.add(new BasicNameValuePair(encapsulateFGFotoCols(FormGalpalFotoTable.Cols.ID_KUALIFIKASI_SURVEY), String.valueOf(formGalpalFoto.getKualifikasiSurveyId())));
            pairs.add(new BasicNameValuePair(encapsulateFGFotoCols(FormGalpalFotoTable.Cols.ID_PERIODE), String.valueOf(formGalpalFoto.getIdPeriode())));
            pairs.add(new BasicNameValuePair(encapsulateFGFotoCols(FormGalpalFotoTable.Cols.NAMA_FOTO), formGalpalFoto.getNamaFoto()));
            pairs.add(new BasicNameValuePair(encapsulateFGFotoCols(FormGalpalFotoTable.Cols.FOTO_GALANGAN), formGalpalFoto.getFotoGalangan()));
            pairs.add(new BasicNameValuePair(encapsulateFGFotoCols(FormGalpalFotoTable.Cols.NOTE), formGalpalFoto.getNote()));


            UrlEncodedFormEntity uefe = new UrlEncodedFormEntity(pairs);
            post.setEntity(uefe);
            // Execute the HTTP Post Request
            HttpResponse response = client.execute(post);
            // Convert the response into a String
            HttpEntity resEntity = response.getEntity();
            if (resEntity != null) {
                Log.i("PushFGFoto", EntityUtils.toString(resEntity));
            }
            if(formGalpalFoto.getFormServerId()==0) {
                new DataFetcher().fetchFormLastInsert(formGalpalFoto,DataFetcher.FGFotoENDPOINT, FormGalpalFotoTable.Cols.ID_F1_FOTO_GALANGAN_SERVER);
            }
            new DataFetcher().fetchModifyDate(formGalpalFoto,DataFetcher.FGFotoENDPOINT, FormGalpalFotoTable.Cols.ID_F1_FOTO_GALANGAN_SERVER);
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
            pairs.add(new BasicNameValuePair("userid", mUserid));
            pairs.add(new BasicNameValuePair("password", mPassword));
            if(formKompal3a.getFormServerId()!=0) {
                pairs.add(new BasicNameValuePair("id", String.valueOf(formKompal3a.getFormServerId())));
            }
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
                Log.i("PushFK3a", EntityUtils.toString(resEntity));
            }
            if(formKompal3a.getFormServerId()==0) {
                new DataFetcher().fetchFormLastInsert(formKompal3a,DataFetcher.FK3aENDPOINT,FK3aJenisKapasitasProduksiTable.Cols.ID_F2_JENIS_KAPASITAS_PRODUKSI_SERVER);
            }
            new DataFetcher().fetchModifyDate(formKompal3a,DataFetcher.FK3aENDPOINT,FK3aJenisKapasitasProduksiTable.Cols.ID_F2_JENIS_KAPASITAS_PRODUKSI_SERVER);
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
            pairs.add(new BasicNameValuePair("userid", mUserid));
            pairs.add(new BasicNameValuePair("password", mPassword));
            if(formKompal3b.getFormServerId()!=0) {
                pairs.add(new BasicNameValuePair("id", String.valueOf(formKompal3b.getFormServerId())));
            }
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
                Log.i("PushFK3b", EntityUtils.toString(resEntity));
            }
            if(formKompal3b.getFormServerId()==0) {
               new DataFetcher().fetchFormLastInsert(formKompal3b,DataFetcher.FK3bENDPOINT,FK3bJumlahProduksiTable.Cols.ID_F2_JUMLAH_PRODUKSI_SERVER);
            }
            new DataFetcher().fetchModifyDate(formKompal3b,DataFetcher.FK3bENDPOINT,FK3bJumlahProduksiTable.Cols.ID_F2_JUMLAH_PRODUKSI_SERVER);
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
            pairs.add(new BasicNameValuePair("userid", mUserid));
            pairs.add(new BasicNameValuePair("password", mPassword));
            if(formKompal3c.getFormServerId()!=0) {
                pairs.add(new BasicNameValuePair("id", String.valueOf(formKompal3c.getFormServerId())));
            }
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
                Log.i("PushFK3c", EntityUtils.toString(resEntity));
            }
            if(formKompal3c.getFormServerId()==0) {
                new DataFetcher().fetchFormLastInsert(formKompal3c,DataFetcher.FK3cENDPOINT,FK3cSistemBerproduksiTable.Cols.ID_F2_SISTEM_BERPRODUKSI_SERVER);
            }
            new DataFetcher().fetchModifyDate(formKompal3c,DataFetcher.FK3cENDPOINT,FK3cSistemBerproduksiTable.Cols.ID_F2_SISTEM_BERPRODUKSI_SERVER);
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
            pairs.add(new BasicNameValuePair("userid", mUserid));
            pairs.add(new BasicNameValuePair("password", mPassword));
            if(formKompal3d.getFormServerId()!=0) {
                pairs.add(new BasicNameValuePair("id", String.valueOf(formKompal3d.getFormServerId())));
            }
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
                Log.i("PushFK3d", EntityUtils.toString(resEntity));
            }
            if(formKompal3d.getFormServerId()==0) {
                new DataFetcher().fetchFormLastInsert(formKompal3d,DataFetcher.FK3dENDPOINT,FK3dStandarMutuTableTable.Cols.ID_F2_STANDAR_MUTU_SERVER);
            }
            new DataFetcher().fetchModifyDate(formKompal3d,DataFetcher.FK3dENDPOINT,FK3dStandarMutuTableTable.Cols.ID_F2_STANDAR_MUTU_SERVER);
        } catch (UnsupportedEncodingException uee) {
            uee.printStackTrace();
        } catch (ClientProtocolException cpe) {
            cpe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void makePostRequestMenuCheckingGalpal(MenuCheckingGalpal menuCheckingGalpal) {
        HttpClient client = new DefaultHttpClient();
        String postURL = (urlPostMenuCheckingGalpal);
        HttpPost post = new HttpPost(postURL);
        try {
            // Add the data
            List<NameValuePair> pairs = new ArrayList<>();
            pairs.add(new BasicNameValuePair("userid", mUserid));
            pairs.add(new BasicNameValuePair("password", mPassword));
            if(menuCheckingGalpal.getIdMenuCheckingServer()!=0) {
                pairs.add(new BasicNameValuePair("id", String.valueOf(menuCheckingGalpal.getIdMenuCheckingServer())));
            }
            pairs.add(new BasicNameValuePair(encapsulateMenuCheckingGalpalCols(MenuCheckingGalpalTable.Cols.ID_KUALIFIKASI_SURVEY), String.valueOf(menuCheckingGalpal.getIdKualifikasiSurvey())));
            pairs.add(new BasicNameValuePair(encapsulateMenuCheckingGalpalCols(MenuCheckingGalpalTable.Cols.ID_MENU_F1), String.valueOf(menuCheckingGalpal.getIdMenu())));
            pairs.add(new BasicNameValuePair(encapsulateMenuCheckingGalpalCols(MenuCheckingGalpalTable.Cols.IS_FILL), String.valueOf(menuCheckingGalpal.isFill() ? 1 : 0)));
            pairs.add(new BasicNameValuePair(encapsulateMenuCheckingGalpalCols(MenuCheckingGalpalTable.Cols.IS_COMPLETE), String.valueOf(menuCheckingGalpal.isComplete() ? 1 : 0)));
            pairs.add(new BasicNameValuePair(encapsulateMenuCheckingGalpalCols(MenuCheckingGalpalTable.Cols.IS_VERIFIED), String.valueOf(menuCheckingGalpal.isVerified() ? 1 : 0)));

            UrlEncodedFormEntity uefe = new UrlEncodedFormEntity(pairs);
            post.setEntity(uefe);
            // Execute the HTTP Post Request
            HttpResponse response = client.execute(post);
            // Convert the response into a String
            HttpEntity resEntity = response.getEntity();
            if (resEntity != null) {
                Log.i("PushMCGalpal", EntityUtils.toString(resEntity));
            }
            if(menuCheckingGalpal.getIdMenuCheckingServer()==0){
                new DataFetcher().fetchMenuCheckingLastInsert(menuCheckingGalpal,DataFetcher.MenuCheckingGalpalENDPOINT,MenuCheckingGalpalTable.Cols.ID_MENU_F1_ENTRY_CHECKING_SERVER);
            }
        } catch (UnsupportedEncodingException uee) {
            uee.printStackTrace();
        } catch (ClientProtocolException cpe) {
            cpe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public void makePostRequestMenuCheckingKompal(MenuCheckingKompal menuCheckingKompal) {
        HttpClient client = new DefaultHttpClient();
        String postURL = (urlPostMenuCheckingKompal);
        HttpPost post = new HttpPost(postURL);
        try {
            // Add the data
            List<NameValuePair> pairs = new ArrayList<>();
            pairs.add(new BasicNameValuePair("userid", mUserid));
            pairs.add(new BasicNameValuePair("password", mPassword));
            if(menuCheckingKompal.getIdMenuCheckingServer()!=0) {
                pairs.add(new BasicNameValuePair("id", String.valueOf(menuCheckingKompal.getIdMenuCheckingServer())));
            }
            pairs.add(new BasicNameValuePair(encapsulateMenuCheckingKompalCols(MenuCheckingKompalTable.Cols.ID_KUALIFIKASI_SURVEY), String.valueOf(menuCheckingKompal.getIdKualifikasiSurvey())));
            pairs.add(new BasicNameValuePair(encapsulateMenuCheckingKompalCols(MenuCheckingKompalTable.Cols.ID_MENU_F2), String.valueOf(menuCheckingKompal.getIdMenu())));
            pairs.add(new BasicNameValuePair(encapsulateMenuCheckingKompalCols(MenuCheckingKompalTable.Cols.IS_FILL), String.valueOf(menuCheckingKompal.isFill() ? 1 : 0)));
            pairs.add(new BasicNameValuePair(encapsulateMenuCheckingKompalCols(MenuCheckingKompalTable.Cols.IS_COMPLETE), String.valueOf(menuCheckingKompal.isComplete() ? 1 : 0)));
            pairs.add(new BasicNameValuePair(encapsulateMenuCheckingKompalCols(MenuCheckingKompalTable.Cols.IS_VERIFIED), String.valueOf(menuCheckingKompal.isVerified() ? 1 : 0)));

            UrlEncodedFormEntity uefe = new UrlEncodedFormEntity(pairs);
            post.setEntity(uefe);
            // Execute the HTTP Post Request
            HttpResponse response = client.execute(post);
            // Convert the response into a String
            HttpEntity resEntity = response.getEntity();
            if (resEntity != null) {
                Log.i("PushMCKompal", EntityUtils.toString(resEntity));
            }
            if(menuCheckingKompal.getIdMenuCheckingServer()==0){
                new DataFetcher().fetchMenuCheckingLastInsert(menuCheckingKompal,DataFetcher.MenuCheckingKompalENDPOINT, MenuCheckingKompalTable.Cols.ID_MENU_F2_ENTRY_CHECKING_SERVER);
            }
        } catch (UnsupportedEncodingException uee) {
            uee.printStackTrace();
        } catch (ClientProtocolException cpe) {
            cpe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

    public void makePostRequestKualifikasiSurvey(KualifikasiSurvey kualifikasiSurvey) {
        HttpClient client = new DefaultHttpClient();
        String postURL = (urlPostKualifikasiSurvey);
        HttpPost post = new HttpPost(postURL);
        try {
            // Add the data
            List<NameValuePair> pairs = new ArrayList<>();
            pairs.add(new BasicNameValuePair("userid", mUserid));
            pairs.add(new BasicNameValuePair("password", mPassword));
            pairs.add(new BasicNameValuePair("id", String.valueOf(kualifikasiSurvey.getKualifikasiSurveyId())));
            pairs.add(new BasicNameValuePair(encapsulateKualifikasiSurveyCols(KualifikasiSurveyTable.Cols.ID_PERUSAHAAN), String.valueOf(kualifikasiSurvey.getPerusahaanId())));
            pairs.add(new BasicNameValuePair(encapsulateKualifikasiSurveyCols(KualifikasiSurveyTable.Cols.ID_PERIODE), String.valueOf(kualifikasiSurvey.getPeriodeSurveyId())));
            pairs.add(new BasicNameValuePair(encapsulateKualifikasiSurveyCols(KualifikasiSurveyTable.Cols.ID_GALANGAN_KAPAL), String.valueOf(kualifikasiSurvey.getGalanganKapalId())));
            pairs.add(new BasicNameValuePair(encapsulateKualifikasiSurveyCols(KualifikasiSurveyTable.Cols.STATUS), String.valueOf(kualifikasiSurvey.getStatus())));

            UrlEncodedFormEntity uefe = new UrlEncodedFormEntity(pairs);
            post.setEntity(uefe);
            // Execute the HTTP Post Request
            HttpResponse response = client.execute(post);
            // Convert the response into a String
            HttpEntity resEntity = response.getEntity();
            if (resEntity != null) {
                Log.i("PushKualifikasiSurvey", EntityUtils.toString(resEntity));
            }
        } catch (UnsupportedEncodingException uee) {
            uee.printStackTrace();
        } catch (ClientProtocolException cpe) {
            cpe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

    public void makePostRequestNotification(Notification notification) {
        HttpClient client = new DefaultHttpClient();
        String postURL = (urlPostNotification);
        HttpPost post = new HttpPost(postURL);
        try {
            // Add the data
            List<NameValuePair> pairs = new ArrayList<>();
            pairs.add(new BasicNameValuePair("userid", mUserid));
            pairs.add(new BasicNameValuePair("password", mPassword));
            pairs.add(new BasicNameValuePair("id", String.valueOf(notification.getIdNotification())));
            pairs.add(new BasicNameValuePair(encapsulateNotificationCols(NotificationTable.Cols.USERID), notification.getUserId()));
            pairs.add(new BasicNameValuePair(encapsulateNotificationCols(NotificationTable.Cols.FROMUSERID), notification.getFromUserId()));
            pairs.add(new BasicNameValuePair(encapsulateNotificationCols(NotificationTable.Cols.NOTIF_DATE), String.valueOf(notification.getNotifyDate().getTime())));
            pairs.add(new BasicNameValuePair(encapsulateNotificationCols(NotificationTable.Cols.NOTIF_MESSAGE), notification.getNotifyMessage()));
            pairs.add(new BasicNameValuePair(encapsulateNotificationCols(NotificationTable.Cols.NOTIF_TITLE), notification.getNotifyTitle()));
            pairs.add(new BasicNameValuePair(encapsulateNotificationCols(NotificationTable.Cols.NOTIF_STATUS), notification.getNotifyStatus()));

            UrlEncodedFormEntity uefe = new UrlEncodedFormEntity(pairs);
            post.setEntity(uefe);
            // Execute the HTTP Post Request
            HttpResponse response = client.execute(post);
            // Convert the response into a String
            HttpEntity resEntity = response.getEntity();
            if (resEntity != null) {
                Log.i("RESPONSEPOSTNOTIF", EntityUtils.toString(resEntity));
            }
        } catch (UnsupportedEncodingException uee) {
            uee.printStackTrace();
        } catch (ClientProtocolException cpe) {
            cpe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

    public List<KualifikasiSurvey> makePostRequestLogin(String username,String password) {
        List<KualifikasiSurvey> mKualifikasiSurveys=new ArrayList<>();
        HttpClient client = new DefaultHttpClient();
        String postURL = (urlPostLogin);
        HttpPost post = new HttpPost(postURL);
        try {
            // Add the data
            List<NameValuePair> pairs = new ArrayList<>();
            pairs.add(new BasicNameValuePair("userid", username));
            pairs.add(new BasicNameValuePair("password", password));

            UrlEncodedFormEntity uefe = new UrlEncodedFormEntity(pairs);
            post.setEntity(uefe);
            // Execute the HTTP Post Request
            HttpResponse response = client.execute(post);
            // Convert the response into a String
            HttpEntity resEntity = response.getEntity();
            String hasilLogin=EntityUtils.toString(resEntity);

            if (resEntity != null) {
                Log.i("PushLogin", hasilLogin);
            }
            if(!hasilLogin.equals("null")) {
                JSONArray jsonKualifikasiSurveyArray = new JSONArray(hasilLogin);
                for (int i = 0; i < jsonKualifikasiSurveyArray.length(); i++) {
                    if(jsonKualifikasiSurveyArray.getString(i)!=null) {
                        mKualifikasiSurveys.add(new DataFetcher().fetchKualifikasiSurvey(jsonKualifikasiSurveyArray.getString(i)));
                    }else{
                        mKualifikasiSurveys=new ArrayList<>();
                    }
                }
                return mKualifikasiSurveys;
            }
        } catch (UnsupportedEncodingException uee) {
            uee.printStackTrace();
        } catch (ClientProtocolException cpe) {
            cpe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
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

    private String encapsulateFG7Cols(String cols){
        return "F1PeralatanKerjaLrTug["+cols+"]";
    }

    private String encapsulateFG8Cols(String cols){
        return "F1PeralatanKerjaProdMesin["+cols+"]";
    }

    private String encapsulateFG9Cols(String cols){
        return "F1PeralatanKerjaProdKonstruksi["+cols+"]";
    }

    private String encapsulateFG10Cols(String cols){
        return "F1PeralatanKerjaProdElmek["+cols+"]";
    }

    private String encapsulateFG11Cols(String cols){
        return "F1PeralatanKerjaProdCat["+cols+"]";
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

    private String encapsulateMenuCheckingGalpalCols(String cols){
        return "MenuF1EntryChecking["+cols+"]";
    }

    private String encapsulateMenuCheckingKompalCols(String cols){
        return "MenuF2EntryChecking["+cols+"]";
    }

    private String encapsulateKualifikasiSurveyCols(String cols){
        return "KualifikasiSurvey["+cols+"]";
    }

    private String encapsulateNotificationCols(String cols){
        return "Notification["+cols+"]";
    }

    private String encapsulateFGFotoCols(String cols){
        return "F1FotoGalangan["+cols+"]";
    }

}
