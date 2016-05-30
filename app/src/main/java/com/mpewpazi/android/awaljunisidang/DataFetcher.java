package com.mpewpazi.android.awaljunisidang;

import android.net.Uri;
import android.util.Log;

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
import com.mpewpazi.android.awaljunisidang.Form.SingleForm;
import com.mpewpazi.android.awaljunisidang.masterData.MstAirPelayaran;
import com.mpewpazi.android.awaljunisidang.masterData.MstArus;
import com.mpewpazi.android.awaljunisidang.masterData.MstGelombang;
import com.mpewpazi.android.awaljunisidang.masterData.MstJarakKedalaman;
import com.mpewpazi.android.awaljunisidang.masterData.MstJenisProduksi;
import com.mpewpazi.android.awaljunisidang.masterData.MstKabupaten;
import com.mpewpazi.android.awaljunisidang.masterData.MstPasangSurut;
import com.mpewpazi.android.awaljunisidang.masterData.MstPropinsi;
import com.mpewpazi.android.awaljunisidang.masterData.MstSatuan;
import com.mpewpazi.android.awaljunisidang.masterData.SingleMaster;
import com.mpewpazi.android.awaljunisidang.model.KualifikasiSurvey;
import com.mpewpazi.android.awaljunisidang.model.MenuCheckingGalpal;
import com.mpewpazi.android.awaljunisidang.model.MenuCheckingKompal;
import com.mpewpazi.android.awaljunisidang.model.PeriodeSurvey;
import com.mpewpazi.android.awaljunisidang.model.Perusahaan;
import com.mpewpazi.android.awaljunisidang.model.SurveyAssignSurveyor;
import com.mpewpazi.android.awaljunisidang.model.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
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
 * Created by asputra on 5/18/16.
 */
public class DataFetcher {
    private static final String TAG = "DataFethcer";

    private static final Uri FG1ENDPOINT = Uri.parse("http://192.168.1.100/galpal/perusahaanIdentitas/perusahaanidentitasapi/id");
    private static final Uri FG3ENDPOINT = Uri.parse("http://192.168.1.100/galpal/galanganKapal/galangankapalapi/id");
    private static final Uri FG4ENDPOINT = Uri.parse("http://192.168.1.100/galpal/f1TinjauanArea/api/id");
    public static final Uri FG6ENDPOINT = Uri.parse("http://192.168.1.100/galpal/f1PeralatanKerjaLrCrane/api/id");
    public static final Uri FG7ENDPOINT = Uri.parse("http://192.168.1.100/galpal/f1PeralatanKerjaLrTug/api/id");
    public static final Uri FG8ENDPOINT = Uri.parse("http://192.168.1.100/galpal/f1PeralatanKerjaProdMesin/api/id");
    public static final Uri FG9ENDPOINT = Uri.parse("http://192.168.1.100/galpal/f1PeralatanKerjaProdKonstruksi/api/id");
    public static final Uri FG10ENDPOINT = Uri.parse("http://192.168.1.100/galpal/f1PeralatanKerjaProdElmek/api/id");
    public static final Uri FG11ENDPOINT = Uri.parse("http://192.168.1.100/galpal/f1PeralatanKerjaProdCat/api/id");

    public static final Uri FK3aENDPOINT = Uri.parse("http://192.168.1.100/galpal/f2JenisKapasitasProduksi/api/id");
    public static final Uri FK3bENDPOINT = Uri.parse("http://192.168.1.100/galpal/f2JumlahProduksi/api/id");
    public static final Uri FK3cENDPOINT = Uri.parse("http://192.168.1.100/galpal/f2SistemBerproduksi/api/id");
    public static final Uri FK3dENDPOINT = Uri.parse("http://192.168.1.100/galpal/f2StandardMutu/api/id");


    private static final Uri KualifikasiSurveyENDPOINT=Uri.parse("http://192.168.1.100/galpal/kualifikasiSurvey/api/id");
    private static final Uri PerusahaanENDPOINT=Uri.parse("http://192.168.1.100/galpal/perusahaan/api/id");

    public static final Uri DELETEFG6ENDPOINT = Uri.parse("http://192.168.1.100/galpal/f1PeralatanKerjaLrCrane/deleteapi/id");
    public static final Uri DELETEFG7ENDPOINT = Uri.parse("http://192.168.1.100/galpal/f1PeralatanKerjaLrTug/deleteapi/id");
    public static final Uri DELETEFG8ENDPOINT = Uri.parse("http://192.168.1.100/galpal/f1PeralatanKerjaProdMesin/deleteapi/id");
    public static final Uri DELETEFG9ENDPOINT = Uri.parse("http://192.168.1.100/galpal/f1PeralatanKerjaProdKonstruksi/deleteapi/id");
    public static final Uri DELETEFG10ENDPOINT = Uri.parse("http://192.168.1.100/galpal/f1PeralatanKerjaProdElmek/deleteapi/id");
    public static final Uri DELETEFG11ENDPOINT = Uri.parse("http://192.168.1.100/galpal/f1PeralatanKerjaProdCat/deleteapi/id");
    public static final Uri DELETEFK3aENDPOINT = Uri.parse("http://192.168.1.100/galpal/f2JenisKapasitasProduksi/deleteapi/id");
    public static final Uri DELETEFK3bENDPOINT = Uri.parse("http://192.168.1.100/galpal/f2JumlahProduksi/deleteapi/id");
    public static final Uri DELETEFK3cENDPOINT = Uri.parse("http://192.168.1.100/galpal/f2SistemBerproduksi/deleteapi/id");
    public static final Uri DELETEFK3dENDPOINT = Uri.parse("http://192.168.1.100/galpal/f2StandardMutu/deleteapi/id");

    private static final String MSTPropinsiENDPOINT="http://192.168.1.100/galpal/mstPropinsi/api";
    private static final String MSTKabupatenENDPOINT="http://192.168.1.100/galpal/mstKabupatenkota/api";
    private static final String MSTJarakKedalamanENDPOINT="http://192.168.1.100/galpal/mstJarakKedalaman/api";
    private static final String MSTAirPelayaranENDPOINT="http://192.168.1.100/galpal/";
    private static final String MSTPasangSurutENDPOINT="http://192.168.1.100/galpal/mstPasangSurut/api";
    private static final String MSTArusENDPOINT="http://192.168.1.100/galpal/mstArus/api";
    private static final String MSTGelombangENDPOINT="http://192.168.1.100/galpal/mstGelombang/api";
    private static final String MSTSatuanENDPOINT="http://192.168.1.100/galpal/mstSatuan/api";
    private static final String MSTJenisProduksiENDPOINT="http://192.168.1.100/galpal/mstJenisProduksi/api";

    private static final String KualifikasiSurveysENDPOINT="http://192.168.1.100/galpal/kualifikasiSurvey/api";

    private static final Uri MenuCheckingGalpalENDPOINT = Uri.parse("http://192.168.1.100/galpal/menuF1EntryChecking/api/id");
    private static final Uri MenuCheckingKompalENDPOINT = Uri.parse("http://192.168.1.100/galpal/menuF2EntryChecking/api/id");
    private static final String MenuF1ENDPOINT="http://192.168.1.100/galpal/menuF1/api";
    private static final String MenuF2ENDPOINT="http://192.168.1.100/galpal/menuF2/api";


    //private static final String MSTENDPOINT="http://192.168.1.100/galpal/";



    private String buildUrl(Uri endpoint, String id) {
        Uri.Builder uriBuilder = endpoint.buildUpon().appendPath(id);
        return uriBuilder.build().toString();
    }

    public byte[] getUrlBytes(String urlSpec) throws IOException{
        URL url=new URL(urlSpec);
        HttpURLConnection connection=(HttpURLConnection)url.openConnection();

        try{
            ByteArrayOutputStream out=new ByteArrayOutputStream();
            InputStream in=connection.getInputStream();

            if(connection.getResponseCode()!=HttpURLConnection.HTTP_OK){
                throw new IOException(connection.getResponseMessage()+": with "+urlSpec);
            }

            int byteRead=0;
            byte[] buffer=new byte[1024];
            while((byteRead=in.read(buffer))>0){
                out.write(buffer, 0, byteRead);
            }
            out.close();
            return out.toByteArray();
        }finally {
            connection.disconnect();
        }
    }

    public String getUrlString(String urlSpec) throws  IOException{
        return new String(getUrlBytes(urlSpec));
    }

    public void deleteForm(int idFormKompal3aServer,Uri uriFormDelete) {
        try {
            String uriFormKompal3a=buildUrl(uriFormDelete,String.valueOf(idFormKompal3aServer));
            getUrlString(uriFormKompal3a);
        } catch (IOException ioe) {
            Log.e(TAG, "Failed to fetch items", ioe);
        }
    }


    public List<SurveyAssignSurveyor> fetchSurveyAssignSurveyors() {
        List<SurveyAssignSurveyor> items=new ArrayList<>();

        try {
            String jsonString = getUrlString("http://192.168.1.102/galpal/");
            Log.i(TAG, "Received JSON: " + jsonString);
            JSONArray jsonBody = new JSONArray(jsonString);
            parseSurveyAssignSurveyors(items,jsonBody);
        } catch (JSONException je){
            Log.e(TAG, "Failed to parse JSON", je);
        } catch (IOException ioe) {
            Log.e(TAG, "Failed to fetch items", ioe);
        }

        return items;
    }

    private void parseSurveyAssignSurveyors(List<SurveyAssignSurveyor> items, JSONArray jsonBody) throws IOException, JSONException {
        for (int i = 0; i < jsonBody.length(); i++) {
            JSONObject surveyAssignSurveyorJsonObject = jsonBody.getJSONObject(i);
            SurveyAssignSurveyor item = new SurveyAssignSurveyor();
            item.setAssignByUserId(surveyAssignSurveyorJsonObject.getInt(SurveyAssignSurveyorTable.Cols.ID_SURVEY_ASSIGN_SURVEYOR));
            item.setKualifikasiSurveyId(surveyAssignSurveyorJsonObject.getInt(SurveyAssignSurveyorTable.Cols.ID_KUALIFIKASI_SURVEY));
            item.setUserId(surveyAssignSurveyorJsonObject.getString(SurveyAssignSurveyorTable.Cols.USERID));
            //item.setAssignDate(surveyAssignSurveyorJsonObject.getString(SurveyAssignSurveyorTable.Cols.ASSIGN_DATE));
            item.setAssignByUserId(surveyAssignSurveyorJsonObject.getInt(SurveyAssignSurveyorTable.Cols.ASSIGN_BY));
            items.add(item);
        }
    }

    public List<User> fetchUsers() {
        List<User> items=new ArrayList<>();

        try {

            String jsonString = getUrlString("http://192.168.1.102/galpal/");
            Log.i(TAG, "Received JSON: " + jsonString);
            JSONArray jsonBody = new JSONArray(jsonString);
            parseUsers(items,jsonBody);
        } catch (JSONException je){
            Log.e(TAG, "Failed to parse JSON", je);
        } catch (IOException ioe) {
            Log.e(TAG, "Failed to fetch items", ioe);
        }

        return items;
    }

    private void parseUsers(List<User> items, JSONArray jsonBody) throws IOException, JSONException {

        for (int i = 0; i < jsonBody.length(); i++) {
            JSONObject jsonObject = jsonBody.getJSONObject(i);
            User item = new User();
            item.setUserId(jsonObject.getString(UserTable.Cols.USERID));
            item.setCodeId(jsonObject.getString(UserTable.Cols.CODE_ID));
            item.setType(jsonObject.getString(UserTable.Cols.TYPE));
            item.setFullName(jsonObject.getString(UserTable.Cols.FULL_NAME));
            item.setCompanyName(jsonObject.getInt(UserTable.Cols.COMPANY_NAME));
            item.setEmail(jsonObject.getString(UserTable.Cols.EMAIL));
            item.setPassword(jsonObject.getString(UserTable.Cols.PASSWORD));
            item.setSecurityCode(jsonObject.getString(UserTable.Cols.SECURITY_CODE));
            items.add(item);
        }
    }

    public Perusahaan fetchPerusahaan(String idPerusahaan){

        Perusahaan mPerusahaan=new Perusahaan();
        String uriPerusahaan=buildUrl(PerusahaanENDPOINT,idPerusahaan);

        try {
            String jsonPerusahaanString=getUrlString(uriPerusahaan);

            Log.i(TAG, "Received JSON: " + jsonPerusahaanString);

            JSONObject jsonPerusahaanBody = new JSONObject(jsonPerusahaanString);

            parsePerusahaan(mPerusahaan,jsonPerusahaanBody);


        } catch (JSONException je){
            Log.e(TAG, "Failed to parse JSON", je);
        } catch (IOException ioe) {
            Log.e(TAG, "Failed to fetch items", ioe);
        }

        return mPerusahaan;
    }


    private void parsePerusahaan(Perusahaan perusahaan, JSONObject jsonObject) throws IOException, JSONException {
        perusahaan.setId(jsonObject.getInt(PerusahaanTable.Cols.ID_PERUSAHAAN));
        perusahaan.setIndustri(jsonObject.getString(PerusahaanTable.Cols.INDUSTRI));
        perusahaan.setNamaPerusahaan(jsonObject.getString(PerusahaanTable.Cols.NAMA_PERUSAHAAN));
        perusahaan.setActive(jsonObject.getInt(PerusahaanTable.Cols.IS_ACTIV)==1);
    }


    public List<KualifikasiSurvey> fetchKualifikasiSurveys() {
        List<KualifikasiSurvey> items=new ArrayList<>();

        try {

            String jsonString = getUrlString(KualifikasiSurveysENDPOINT);
            Log.i(TAG, "Received JSON: " + jsonString);
            JSONArray jsonBody = new JSONArray(jsonString);
            parseKualifikasiSurveys(items,jsonBody);
        } catch (JSONException je){
            Log.e(TAG, "Failed to parse JSON", je);
        } catch (IOException ioe) {
            Log.e(TAG, "Failed to fetch items", ioe);
        }

        return items;
    }

    public KualifikasiSurvey fetchKualifikasiSurvey(String idKualifikasiSurvey){

        KualifikasiSurvey mKualifikasiSurvey=new KualifikasiSurvey();
        String uriKualifikasiSurvey=buildUrl(KualifikasiSurveyENDPOINT,idKualifikasiSurvey);

        try {
            String jsonKualifikasiSurveyString=getUrlString(uriKualifikasiSurvey);

            Log.i(TAG, "Received JSON: " + jsonKualifikasiSurveyString);

            JSONObject jsonKualifikasiSurveyBody = new JSONObject(jsonKualifikasiSurveyString);

            parseKualifikasiSurvey(mKualifikasiSurvey,jsonKualifikasiSurveyBody);


        } catch (JSONException je){
            Log.e(TAG, "Failed to parse JSON", je);
        } catch (IOException ioe) {
            Log.e(TAG, "Failed to fetch items", ioe);
        }

        return mKualifikasiSurvey;
    }

    private void parseKualifikasiSurvey(KualifikasiSurvey kualifikasiSurvey, JSONObject jsonObject) throws IOException, JSONException {
        kualifikasiSurvey.setKualifikasiSurveyId(jsonObject.getInt(KualifikasiSurveyTable.Cols.ID_KUALIFIKASI_SURVEY));
        kualifikasiSurvey.setPerusahaanId(jsonObject.getInt(KualifikasiSurveyTable.Cols.ID_PERUSAHAAN));
        kualifikasiSurvey.setPeriodeSurveyId(jsonObject.getInt(KualifikasiSurveyTable.Cols.ID_PERIODE));
        kualifikasiSurvey.setGalanganKapalId(jsonObject.getInt(KualifikasiSurveyTable.Cols.ID_GALANGAN_KAPAL));
        kualifikasiSurvey.setStatus(jsonObject.getInt(KualifikasiSurveyTable.Cols.STATUS));

    }

    private void parseKualifikasiSurveys(List<KualifikasiSurvey> items, JSONArray jsonBody) throws IOException, JSONException {

        for (int i = 0; i < jsonBody.length(); i++) {
            JSONObject jsonObject = jsonBody.getJSONObject(i);
            KualifikasiSurvey item = new KualifikasiSurvey();
            item.setKualifikasiSurveyId(jsonObject.getInt(KualifikasiSurveyTable.Cols.ID_KUALIFIKASI_SURVEY));
            item.setPerusahaanId(jsonObject.getInt(KualifikasiSurveyTable.Cols.ID_PERUSAHAAN));
            item.setPeriodeSurveyId(jsonObject.getInt(KualifikasiSurveyTable.Cols.ID_PERIODE));
            item.setGalanganKapalId(jsonObject.getInt(KualifikasiSurveyTable.Cols.ID_GALANGAN_KAPAL));
            item.setStatus(jsonObject.getInt(KualifikasiSurveyTable.Cols.STATUS));
            items.add(item);
        }
    }



    public List<PeriodeSurvey> fetchPeriodeSurveys() {
        List<PeriodeSurvey> items=new ArrayList<>();

        try {

            String jsonString = getUrlString("http://192.168.1.102/galpal/");
            Log.i(TAG, "Received JSON: " + jsonString);
            JSONArray jsonBody = new JSONArray(jsonString);
            parsePeriodeSurveys(items,jsonBody);
        } catch (JSONException je){
            Log.e(TAG, "Failed to parse JSON", je);
        } catch (IOException ioe) {
            Log.e(TAG, "Failed to fetch items", ioe);
        }

        return items;
    }

    private void parsePeriodeSurveys(List<PeriodeSurvey> items, JSONArray jsonBody) throws IOException, JSONException {

        for (int i = 0; i < jsonBody.length(); i++) {
            JSONObject jsonObject = jsonBody.getJSONObject(i);
            PeriodeSurvey item = new PeriodeSurvey();
            item.setPeriodeSurveyId(jsonObject.getInt(PeriodeSurveyTable.Cols.ID_PERIODE));
            item.setTahunKualifikasi(jsonObject.getString(PeriodeSurveyTable.Cols.TAHUN_KUALIFIKASI));
            item.setActivePeriode(jsonObject.getInt(PeriodeSurveyTable.Cols.IS_ACTIVE_PERIOD));
            item.setDone(jsonObject.getInt(PeriodeSurveyTable.Cols.IS_DONE));
            item.setKeterangan(jsonObject.getString(PeriodeSurveyTable.Cols.KETERANGAN));
            items.add(item);
        }
    }

    public List<Perusahaan> fetchPerusahaans() {
        List<Perusahaan> items=new ArrayList<>();

        try {

            String jsonString = getUrlString("http://192.168.1.102/galpal/");
            Log.i(TAG, "Received JSON: " + jsonString);
            JSONArray jsonBody = new JSONArray(jsonString);
            parsePerusahaans(items,jsonBody);
        } catch (JSONException je){
            Log.e(TAG, "Failed to parse JSON", je);
        } catch (IOException ioe) {
            Log.e(TAG, "Failed to fetch items", ioe);
        }

        return items;
    }

    private void parsePerusahaans(List<Perusahaan> items, JSONArray jsonBody) throws IOException, JSONException {

        for (int i = 0; i < jsonBody.length(); i++) {
            JSONObject jsonObject = jsonBody.getJSONObject(i);
            Perusahaan item = new Perusahaan();
            item.setId(jsonObject.getInt(PerusahaanTable.Cols.ID_PERUSAHAAN));
            item.setNamaPerusahaan(jsonObject.getString(PerusahaanTable.Cols.NAMA_PERUSAHAAN));
            item.setIndustri(jsonObject.getString(PerusahaanTable.Cols.INDUSTRI));
            item.setActive(jsonObject.getInt(PerusahaanTable.Cols.IS_ACTIV)==1);
            items.add(item);
        }
    }

    public List<SingleForm> fetchFormGalpals(String idKualifikasiSurvey) {

        List<SingleForm> items=new ArrayList<>();
        String uriFormGalpal1=buildUrl(FG1ENDPOINT,idKualifikasiSurvey);
        String uriFormGalpal3=buildUrl(FG3ENDPOINT,idKualifikasiSurvey);
        String uriFormGalpal4=buildUrl(FG4ENDPOINT,idKualifikasiSurvey);
        String uriFormGalpal6=buildUrl(FG6ENDPOINT,idKualifikasiSurvey);
        String uriFormGalpal7=buildUrl(FG7ENDPOINT,idKualifikasiSurvey);
        String uriFormGalpal8=buildUrl(FG8ENDPOINT,idKualifikasiSurvey);
        String uriFormGalpal9=buildUrl(FG9ENDPOINT,idKualifikasiSurvey);
        String uriFormGalpal10=buildUrl(FG10ENDPOINT,idKualifikasiSurvey);
        String uriFormGalpal11=buildUrl(FG11ENDPOINT,idKualifikasiSurvey);

        try {
            String jsonFormGalpal1String=getUrlString(uriFormGalpal1);
            String jsonFormGalpal3String=getUrlString(uriFormGalpal3);
            String jsonFormGalpal4String=getUrlString(uriFormGalpal4);
            String jsonFormGalpal6String=getUrlString(uriFormGalpal6);
            String jsonFormGalpal7String=getUrlString(uriFormGalpal7);
            String jsonFormGalpal8String=getUrlString(uriFormGalpal8);
            String jsonFormGalpal9String=getUrlString(uriFormGalpal9);
            String jsonFormGalpal10String=getUrlString(uriFormGalpal10);
            String jsonFormGalpal11String=getUrlString(uriFormGalpal11);


           Log.i(TAG, "Received JSON: " + jsonFormGalpal1String);
           Log.i(TAG, "Received JSON: " + jsonFormGalpal3String);
           Log.i(TAG, "Received JSON: " + jsonFormGalpal4String);
            Log.i(TAG, "Received JSON: " + jsonFormGalpal6String);
            Log.i(TAG, "Received JSON: " + jsonFormGalpal7String);
            Log.i(TAG, "Received JSON: " + jsonFormGalpal8String);
            Log.i(TAG, "Received JSON: " + jsonFormGalpal9String);
            Log.i(TAG, "Received JSON: " + jsonFormGalpal10String);
            Log.i(TAG, "Received JSON: " + jsonFormGalpal11String);



            JSONObject jsonFormGalpal1Body = new JSONObject(jsonFormGalpal1String);
            JSONObject jsonFormGalpal3Body = new JSONObject(jsonFormGalpal3String);
            JSONArray jsonFormGalpal4Body = new JSONArray(jsonFormGalpal4String);
            JSONArray jsonFormGalpal6Body = new JSONArray(jsonFormGalpal6String);
            JSONArray jsonFormGalpal7Body = new JSONArray(jsonFormGalpal7String);
            JSONArray jsonFormGalpal8Body = new JSONArray(jsonFormGalpal8String);
            JSONArray jsonFormGalpal9Body = new JSONArray(jsonFormGalpal9String);
            JSONArray jsonFormGalpal10Body = new JSONArray(jsonFormGalpal10String);
            JSONArray jsonFormGalpal11Body = new JSONArray(jsonFormGalpal11String);

            parseFormGalpal3(items,jsonFormGalpal3Body);
            parseFormGalpal1(items,jsonFormGalpal1Body);
            parseFormGalpal4(items,jsonFormGalpal4Body);
            parseFormGalpal6s(items,jsonFormGalpal6Body);
            parseFormGalpal7s(items,jsonFormGalpal7Body);
            parseFormGalpal8s(items,jsonFormGalpal8Body);
            parseFormGalpal9s(items,jsonFormGalpal9Body);
            parseFormGalpal10s(items,jsonFormGalpal10Body);
            parseFormGalpal11s(items,jsonFormGalpal11Body);


        } catch (JSONException je){
            Log.e(TAG, "Failed to parse JSON", je);
        } catch (IOException ioe) {
            Log.e(TAG, "Failed to fetch items", ioe);
        }

        return items;
    }



    public List<SingleForm> fetchFormKompals(String idKualifikasiSurvey) {

        List<SingleForm> items=new ArrayList<>();
        String uriFormKompal3a=buildUrl(FK3aENDPOINT,idKualifikasiSurvey);
        String uriFormKompal3b=buildUrl(FK3bENDPOINT,idKualifikasiSurvey);
        String uriFormKompal3c=buildUrl(FK3cENDPOINT,idKualifikasiSurvey);
        String uriFormKompal3d=buildUrl(FK3dENDPOINT,idKualifikasiSurvey);

        try {
            String jsonFormKompal3aString=getUrlString(uriFormKompal3a);
            String jsonFormKompal3bString=getUrlString(uriFormKompal3b);
            String jsonFormKompal3cString=getUrlString(uriFormKompal3c);
            String jsonFormKompal3dString=getUrlString(uriFormKompal3d);


           // Log.i(TAG, "Received JSON: " + jsonFormKompal3aString);
           // Log.i(TAG, "Received JSON: " + jsonFormKompal3bString);
           // Log.i(TAG, "Received JSON: " + jsonFormKompal3cString);
           // Log.i(TAG, "Received JSON: " + jsonFormKompal3dString);


            JSONArray jsonFormKompal3aBody=new JSONArray(jsonFormKompal3aString);
            JSONArray jsonFormKompal3bBody=new JSONArray(jsonFormKompal3bString);
            JSONArray jsonFormKompal3cBody=new JSONArray(jsonFormKompal3cString);
            JSONArray jsonFormKompal3dBody=new JSONArray(jsonFormKompal3dString);


            parseFormKompal3as(items,jsonFormKompal3aBody);
            parseFormKompal3bs(items,jsonFormKompal3bBody);
            parseFormKompal3cs(items,jsonFormKompal3cBody);
            parseFormKompal3ds(items,jsonFormKompal3dBody);

        } catch (JSONException je){
            Log.e(TAG, "Failed to parse JSON", je);
        } catch (IOException ioe) {
            Log.e(TAG, "Failed to fetch items", ioe);
        }

        return items;
    }

    public void fetchFormLastInsert(SingleForm singleForm,Uri ENDPOINT,String formServerIdNameCols) {
        String idKualifikasiSurvey=String.valueOf(singleForm.getKualifikasiSurveyId());
        String uriForm=buildUrl(ENDPOINT,idKualifikasiSurvey);

        try {

            String jsonFormString=getUrlString(uriForm);
            // Log.i(TAG, "Received JSON: " + jsonFormKompal3aString);
            JSONArray jsonFormBody=new JSONArray(jsonFormString);

            parseFormLast(singleForm,jsonFormBody,formServerIdNameCols);


        } catch (JSONException je){
            Log.e(TAG, "Failed to parse JSON", je);
        } catch (IOException ioe) {
            Log.e(TAG, "Failed to fetch items", ioe);
        }
    }

    private void parseFormLast(SingleForm singleForm, JSONArray jsonBody, String serverIdName) throws IOException, JSONException {
        JSONObject jsonObject = jsonBody.getJSONObject((jsonBody.length())-1);
        singleForm.setFormServerId(jsonObject.getInt(serverIdName));
    }


    private void parseFormGalpal1(List<SingleForm> items, JSONObject jsonObject) throws IOException, JSONException {

            FormGalpal1 item = new FormGalpal1();
            item.setIdentitasPerusahaanId(jsonObject.getInt(FG1PerusahaanIdentitasTable.Cols.ID_PERUSAHAAN_IDENTITAS));
            item.setKualifikasiSurveyId(jsonObject.getInt(FG1PerusahaanIdentitasTable.Cols.ID_KUALIFIKASI_SURVEY));
            item.setAlamat(jsonObject.getString(FG1PerusahaanIdentitasTable.Cols.ALAMAT_PERUSAHAAN));
            item.setNomorTelepon(jsonObject.getString(FG1PerusahaanIdentitasTable.Cols.TELEPON_PERUSAHAAN));
            item.setFax(jsonObject.getString(FG1PerusahaanIdentitasTable.Cols.FAX_PERUSAHAAN));
            item.setKelurahan(jsonObject.getString(FG1PerusahaanIdentitasTable.Cols.KELURAHAN_PERUSAHAAN));
            item.setIdPropinsi(jsonObject.getInt(FG1PerusahaanIdentitasTable.Cols.ID_PROPINSI_PERUSAHAAN));
            item.setIdKabupaten_kota(jsonObject.getInt(FG1PerusahaanIdentitasTable.Cols.ID_KABUPATEN_PERUSAHAAN));
            item.setKodePos(jsonObject.getString(FG1PerusahaanIdentitasTable.Cols.KODE_POS_PERUSAHAAN));
            item.setAnggotaAsosiasi(jsonObject.getString(FG1PerusahaanIdentitasTable.Cols.ANGGOTA_ASOSIASI));
            item.setKategoriPerusahaan(jsonObject.getString(FG1PerusahaanIdentitasTable.Cols.KATEGORI_PERUSAHAAN));
            item.setContactPerson(jsonObject.getString(FG1PerusahaanIdentitasTable.Cols.CP_NAMA));
            item.setNomorCp(jsonObject.getString(FG1PerusahaanIdentitasTable.Cols.CP_NOMOR));
            item.setJabatan(jsonObject.getString(FG1PerusahaanIdentitasTable.Cols.CP_JABATAN));
            item.setEmail(jsonObject.getString(FG1PerusahaanIdentitasTable.Cols.CP_EMAIL));
            item.setWebsite(jsonObject.getString(FG1PerusahaanIdentitasTable.Cols.WEBSITE));
            item.setKecamatan(jsonObject.getString(FG1PerusahaanIdentitasTable.Cols.KECAMATAN_PERUSAHAAN));
            items.add(item);

    }

    private void parseFormGalpal3(List<SingleForm> items, JSONObject jsonObject) throws IOException, JSONException {

            FormGalpal3 item = new FormGalpal3();
            item.setIdentitasUmumGalanganId(jsonObject.getInt(FG3GalanganKapalTable.Cols.ID_GALANGAN_KAPAL));
            item.setNamaGalangan(jsonObject.getString(FG3GalanganKapalTable.Cols.NAMA_GALANGAN));
            item.setKategoriGalangan(jsonObject.getString(FG3GalanganKapalTable.Cols.KATEGORI_GALANGAN));
            item.setKualifikasiSurveyId(jsonObject.getInt(FG3GalanganKapalTable.Cols.ID_KUALIFIKASI_SURVEY));
            item.setNomorDock(jsonObject.getString(FG3GalanganKapalTable.Cols.NOMOR_DOCK));
            item.setAlamat(jsonObject.getString(FG3GalanganKapalTable.Cols.ALAMAT_GALANGAN));
            item.setKelurahan(jsonObject.getString(FG3GalanganKapalTable.Cols.KELURAHAN_GALANGAN));
            item.setKecamatan(jsonObject.getString(FG3GalanganKapalTable.Cols.KECAMATAN_GALANGAN));
            item.setKebupaten_kotaId(jsonObject.getInt(FG3GalanganKapalTable.Cols.ID_KABUPATEN_GALANGAN));
            item.setPropinsiId(jsonObject.getInt(FG3GalanganKapalTable.Cols.ID_PROPINSI_GALANGAN));
            item.setNomorTelepon(jsonObject.getString(FG3GalanganKapalTable.Cols.TELEPON_GALANGAN));
            item.setFax(jsonObject.getString(FG3GalanganKapalTable.Cols.FAX_GALANGAN));
            item.setKodePos(jsonObject.getString(FG3GalanganKapalTable.Cols.KODE_POS_GALANGAN));
            item.setLongitude(jsonObject.getString(FG3GalanganKapalTable.Cols.LONGITUDE));
            item.setLatitude(jsonObject.getString(FG3GalanganKapalTable.Cols.LATITUDE));
            item.setContactPerson(jsonObject.getString(FG3GalanganKapalTable.Cols.CP_NAMA));
            item.setNomorCp(jsonObject.getString(FG3GalanganKapalTable.Cols.CP_NO));
            item.setJabatan(jsonObject.getString(FG3GalanganKapalTable.Cols.CP_JABATAN));
            item.setEmail(jsonObject.getString(FG3GalanganKapalTable.Cols.CP_EMAIL));
            items.add(item);
    }

    private void parseFormGalpal4(List<SingleForm> items, JSONArray jsonBody) throws IOException, JSONException {

        for (int i = 0; i < jsonBody.length(); i++) {
            JSONObject jsonObject = jsonBody.getJSONObject(i);
            FormGalpal4 item = new FormGalpal4();
            item.setTinjauanWilayahMaritimId(jsonObject.getInt(FG4TinjauanAreaTable.Cols.ID_F1_TINJAUAN_AREA));
            item.setKualifikasiSurveyId(jsonObject.getInt(FG4TinjauanAreaTable.Cols.ID_KUALIFIKASI_SURVEY));
            item.setJarakKedalaman(jsonObject.getInt(FG4TinjauanAreaTable.Cols.ID_MST_JARAK_KEDALAMAN));
            item.setAirPelayaran(jsonObject.getInt(FG4TinjauanAreaTable.Cols.ID_MST_AIR_PELAYARAN));
            item.setPasangSurutPerairan(jsonObject.getInt(FG4TinjauanAreaTable.Cols.ID_MST_PASANG_SURUT));
            item.setArus(jsonObject.getInt(FG4TinjauanAreaTable.Cols.ID_MST_ARUS));
            item.setGelombang(jsonObject.getInt(FG4TinjauanAreaTable.Cols.ID_MST_GELOMBANG));
            item.setPanjangWaterfront(jsonObject.getInt(FG4TinjauanAreaTable.Cols.PANJANG_WATERFRONT));
            item.setLuasLahan(jsonObject.getInt(FG4TinjauanAreaTable.Cols.LUAS_LAHAN));
            item.setKetersediaanLahan(jsonObject.getString(FG4TinjauanAreaTable.Cols.KETERSEDIAAN_LAHAN));
            item.setLahanProduktif(jsonObject.getString(FG4TinjauanAreaTable.Cols.LAHAN_PRODUKTIF));
            item.setLahanPemukiman(jsonObject.getString(FG4TinjauanAreaTable.Cols.LAHAN_PEMUKIMAN));
            item.setPasangSurutDaratan(jsonObject.getString(FG4TinjauanAreaTable.Cols.PASANG_SURUT));
            item.setDayaDukung(jsonObject.getString(FG4TinjauanAreaTable.Cols.DAYA_DUKUNG));
            item.setKelandaian(jsonObject.getString(FG4TinjauanAreaTable.Cols.KELANDAIAAN));
            item.setDekatJalan(jsonObject.getString(FG4TinjauanAreaTable.Cols.DEKAT_JALAN));
            item.setKota(jsonObject.getString(FG4TinjauanAreaTable.Cols.KOTA));
            item.setInterkoneksiAngkutan(jsonObject.getString(FG4TinjauanAreaTable.Cols.INTERKONEKSI_ANGKUTAN));
            item.setNilaiEkonomi(jsonObject.getString(FG4TinjauanAreaTable.Cols.NILAI_EKONOMI));
            item.setPerkembanganWilayah(jsonObject.getString(FG4TinjauanAreaTable.Cols.PERKEMBANGAN_WILAYAH));
            item.setRutrw(jsonObject.getString(FG4TinjauanAreaTable.Cols.RUTWR));

            items.add(item);
        }

    }

    private void parseFormGalpal6s(List<SingleForm> items, JSONArray jsonBody) throws IOException, JSONException {

        for (int i = 0; i < jsonBody.length(); i++) {
            JSONObject jsonObject = jsonBody.getJSONObject(i);
            FormGalpal6 item = new FormGalpal6();
            item.setFormServerId(jsonObject.getInt(FG6PeralatanKerjaLuarCraneTable.Cols.ID_F1_PERALATAN_KERJA_LR_CRANE_SERVER));
            item.setKualifikasiSurveyId(jsonObject.getInt(FG6PeralatanKerjaLuarCraneTable.Cols.ID_KUALIFIKASI_SURVEY));
            item.setJenisMesin(jsonObject.getString(FG6PeralatanKerjaLuarCraneTable.Cols.JENIS_MESIN));
            item.setTahunPembuatan(jsonObject.getInt(FG6PeralatanKerjaLuarCraneTable.Cols.TAHUN_PEMBUATAN));
            item.setMerek(jsonObject.getString(FG6PeralatanKerjaLuarCraneTable.Cols.MERK));
            item.setKapasitasTerpakai(jsonObject.getInt(FG6PeralatanKerjaLuarCraneTable.Cols.KAPASITAS_TERPAKAI));
            item.setSatuanKapasitasTerpakai(jsonObject.getString(FG6PeralatanKerjaLuarCraneTable.Cols.SATUAN_KAPASITAS_TERPAKAI));
            item.setKapasitasTerpasang(jsonObject.getInt(FG6PeralatanKerjaLuarCraneTable.Cols.KAPASAITAS_TERPASANG));
            item.setSatuanKapastiasTerpasang(jsonObject.getString(FG6PeralatanKerjaLuarCraneTable.Cols.SATUAN_KAPASITAS_TERPASANG));
            item.setDimensi(jsonObject.getString(FG6PeralatanKerjaLuarCraneTable.Cols.DIMENSI));
            item.setJumlah(jsonObject.getInt(FG6PeralatanKerjaLuarCraneTable.Cols.JUMLAH));
            item.setKondisi(jsonObject.getString(FG6PeralatanKerjaLuarCraneTable.Cols.KONDISI));
            item.setLokasi(jsonObject.getString(FG6PeralatanKerjaLuarCraneTable.Cols.LOKASI));
            item.setStatus(jsonObject.getString(FG6PeralatanKerjaLuarCraneTable.Cols.STATUS));
            items.add(item);
        }
    }

    private void parseFormGalpal7s(List<SingleForm> items, JSONArray jsonBody) throws IOException, JSONException {

        for (int i = 0; i < jsonBody.length(); i++) {
            JSONObject jsonObject = jsonBody.getJSONObject(i);
            FormGalpal7 item = new FormGalpal7();
            item.setFormServerId(jsonObject.getInt(FG7PeralatanKerjaLuarTugboatTable.Cols.ID_F1_PERALATAN_KERJA_LR_TUG_SERVER));
            item.setKualifikasiSurveyId(jsonObject.getInt(FG7PeralatanKerjaLuarTugboatTable.Cols.ID_KUALIFIKASI_SURVEY));
            item.setJenisPeralatan(jsonObject.getString(FG7PeralatanKerjaLuarTugboatTable.Cols.JENIS_MESIN));
            item.setTahunPembuatan(jsonObject.getInt(FG7PeralatanKerjaLuarTugboatTable.Cols.TAHUN_PEMBUATAN));
            item.setMerek(jsonObject.getString(FG7PeralatanKerjaLuarTugboatTable.Cols.MERK));
            item.setKapasitasTerpakai(jsonObject.getInt(FG7PeralatanKerjaLuarTugboatTable.Cols.KAPASITAS_TERPAKAI));
            item.setSatuanKapasitasTerpakai(jsonObject.getString(FG7PeralatanKerjaLuarTugboatTable.Cols.SATUAN_KAPASITAS_TERPAKAI));
            item.setKapasitasTerpasang(jsonObject.getInt(FG7PeralatanKerjaLuarTugboatTable.Cols.KAPASAITAS_TERPASANG));
            item.setSatuanKapastiasTerpasang(jsonObject.getString(FG7PeralatanKerjaLuarTugboatTable.Cols.SATUAN_KAPASITAS_TERPASANG));
            item.setDimensi(jsonObject.getString(FG7PeralatanKerjaLuarTugboatTable.Cols.DIMENSI));
            item.setJumlah(jsonObject.getInt(FG7PeralatanKerjaLuarTugboatTable.Cols.JUMLAH));
            item.setKondisi(jsonObject.getString(FG7PeralatanKerjaLuarTugboatTable.Cols.KONDISI));
            item.setLokasi(jsonObject.getString(FG7PeralatanKerjaLuarTugboatTable.Cols.LOKASI));
            item.setStatus(jsonObject.getString(FG7PeralatanKerjaLuarTugboatTable.Cols.STATUS));
            items.add(item);
        }
    }

    private void parseFormGalpal8s(List<SingleForm> items, JSONArray jsonBody) throws IOException, JSONException {

        for (int i = 0; i < jsonBody.length(); i++) {
            JSONObject jsonObject = jsonBody.getJSONObject(i);
            FormGalpal8 item = new FormGalpal8();
            item.setFormServerId(jsonObject.getInt(FG8PeralatanKerjaProduksiMesinTable.Cols.ID_F1_PERALATAN_KERJA_PROD_MESIN_SERVER));
            item.setKualifikasiSurveyId(jsonObject.getInt(FG8PeralatanKerjaProduksiMesinTable.Cols.ID_KUALIFIKASI_SURVEY));
            item.setJenisMesin(jsonObject.getString(FG8PeralatanKerjaProduksiMesinTable.Cols.JENIS_MESIN));
            item.setTahunPembuatan(jsonObject.getInt(FG8PeralatanKerjaProduksiMesinTable.Cols.TAHUN_PEMBUATAN));
            item.setMerek(jsonObject.getString(FG8PeralatanKerjaProduksiMesinTable.Cols.MERK));
            item.setKapasitasTerpakai(jsonObject.getInt(FG8PeralatanKerjaProduksiMesinTable.Cols.KAPASITAS_TERPAKAI));
            item.setSatuanKapasitasTerpakai(jsonObject.getString(FG8PeralatanKerjaProduksiMesinTable.Cols.SATUAN_KAPASITAS_TERPAKAI));
            item.setKapasitasTerpasang(jsonObject.getInt(FG8PeralatanKerjaProduksiMesinTable.Cols.KAPASAITAS_TERPASANG));
            item.setSatuanKapastiasTerpasang(jsonObject.getString(FG8PeralatanKerjaProduksiMesinTable.Cols.SATUAN_KAPASITAS_TERPASANG));
            item.setDimensi(jsonObject.getString(FG8PeralatanKerjaProduksiMesinTable.Cols.DIMENSI));
            item.setJumlah(jsonObject.getInt(FG8PeralatanKerjaProduksiMesinTable.Cols.JUMLAH));
            item.setKondisi(jsonObject.getString(FG8PeralatanKerjaProduksiMesinTable.Cols.KONDISI));
            item.setLokasi(jsonObject.getString(FG8PeralatanKerjaProduksiMesinTable.Cols.LOKASI));
            item.setStatus(jsonObject.getString(FG8PeralatanKerjaProduksiMesinTable.Cols.STATUS));
            items.add(item);
        }
    }

    private void parseFormGalpal9s(List<SingleForm> items, JSONArray jsonBody) throws IOException, JSONException {

        for (int i = 0; i < jsonBody.length(); i++) {
            JSONObject jsonObject = jsonBody.getJSONObject(i);
            FormGalpal9 item = new FormGalpal9();
            item.setFormServerId(jsonObject.getInt(FG9PeralatanKerjaProduksiKontruksi.Cols.ID_F1_PERALATAN_KERJA_PRODUKSI_KONTRUKSI_SERVER));
            item.setKualifikasiSurveyId(jsonObject.getInt(FG9PeralatanKerjaProduksiKontruksi.Cols.ID_KUALIFIKASI_SURVEY));
            item.setJenisMesin(jsonObject.getString(FG9PeralatanKerjaProduksiKontruksi.Cols.JENIS_MESIN));
            item.setTahunPembuatan(jsonObject.getInt(FG9PeralatanKerjaProduksiKontruksi.Cols.TAHUN_PEMBUATAN));
            item.setMerek(jsonObject.getString(FG9PeralatanKerjaProduksiKontruksi.Cols.MERK));
            item.setKapasitasTerpakai(jsonObject.getInt(FG9PeralatanKerjaProduksiKontruksi.Cols.KAPASITAS_TERPAKAI));
            item.setSatuanKapasitasTerpakai(jsonObject.getString(FG9PeralatanKerjaProduksiKontruksi.Cols.SATUAN_KAPASITAS_TERPAKAI));
            item.setKapasitasTerpasang(jsonObject.getInt(FG9PeralatanKerjaProduksiKontruksi.Cols.KAPASAITAS_TERPASANG));
            item.setSatuanKapastiasTerpasang(jsonObject.getString(FG9PeralatanKerjaProduksiKontruksi.Cols.SATUAN_KAPASITAS_TERPASANG));
            item.setDimensi(jsonObject.getString(FG9PeralatanKerjaProduksiKontruksi.Cols.DIMENSI));
            item.setJumlah(jsonObject.getInt(FG9PeralatanKerjaProduksiKontruksi.Cols.JUMLAH));
            item.setKondisi(jsonObject.getString(FG9PeralatanKerjaProduksiKontruksi.Cols.KONDISI));
            item.setLokasi(jsonObject.getString(FG9PeralatanKerjaProduksiKontruksi.Cols.LOKASI));
            item.setStatus(jsonObject.getString(FG9PeralatanKerjaProduksiKontruksi.Cols.STATUS));
            items.add(item);
        }
    }

    private void parseFormGalpal10s(List<SingleForm> items, JSONArray jsonBody) throws IOException, JSONException {

        for (int i = 0; i < jsonBody.length(); i++) {
            JSONObject jsonObject = jsonBody.getJSONObject(i);
            FormGalpal10 item = new FormGalpal10();
            item.setFormServerId(jsonObject.getInt(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.ID_F1_PERALATAN_KERJA_PRODUKSI_ELMEK_SERVER));
            item.setKualifikasiSurveyId(jsonObject.getInt(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.ID_KUALIFIKASI_SURVEY));
            item.setJenisMesin(jsonObject.getString(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.JENIS_MESIN));
            item.setTahunPembuatan(jsonObject.getInt(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.TAHUN_PEMBUATAN));
            item.setMerek(jsonObject.getString(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.MERK));
            item.setKapasitasTerpakai(jsonObject.getInt(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.KAPASITAS_TERPAKAI));
            item.setSatuanKapasitasTerpakai(jsonObject.getString(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.SATUAN_KAPASITAS_TERPAKAI));
            item.setKapasitasTerpasang(jsonObject.getInt(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.KAPASAITAS_TERPASANG));
            item.setSatuanKapastiasTerpasang(jsonObject.getString(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.SATUAN_KAPASITAS_TERPASANG));
            item.setDimensi(jsonObject.getString(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.DIMENSI));
            item.setJumlah(jsonObject.getInt(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.JUMLAH));
            item.setKondisi(jsonObject.getString(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.KONDISI));
            item.setLokasi(jsonObject.getString(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.LOKASI));
            item.setStatus(jsonObject.getString(FG10PeralatanKerjaProduksiElektrikalMekanikal.Cols.STATUS));
            items.add(item);
        }
    }

    private void parseFormGalpal11s(List<SingleForm> items, JSONArray jsonBody) throws IOException, JSONException {

        for (int i = 0; i < jsonBody.length(); i++) {
            JSONObject jsonObject = jsonBody.getJSONObject(i);
            FormGalpal11 item = new FormGalpal11();
            item.setFormServerId(jsonObject.getInt(FG11PeralatanKerjaProduksiPengecatan.Cols.ID_F1_PERALATAN_KERJA_PRODUKSI_CAT_SERVER));
            item.setKualifikasiSurveyId(jsonObject.getInt(FG11PeralatanKerjaProduksiPengecatan.Cols.ID_KUALIFIKASI_SURVEY));
            item.setJenisMesin(jsonObject.getString(FG11PeralatanKerjaProduksiPengecatan.Cols.JENIS_MESIN));
            item.setTahunPembuatan(jsonObject.getInt(FG11PeralatanKerjaProduksiPengecatan.Cols.TAHUN_PEMBUATAN));
            item.setMerek(jsonObject.getString(FG11PeralatanKerjaProduksiPengecatan.Cols.MERK));
            item.setKapasitasTerpakai(jsonObject.getInt(FG11PeralatanKerjaProduksiPengecatan.Cols.KAPASITAS_TERPAKAI));
            item.setSatuanKapasitasTerpakai(jsonObject.getString(FG11PeralatanKerjaProduksiPengecatan.Cols.SATUAN_KAPASITAS_TERPAKAI));
            item.setKapasitasTerpasang(jsonObject.getInt(FG11PeralatanKerjaProduksiPengecatan.Cols.KAPASAITAS_TERPASANG));
            item.setSatuanKapastiasTerpasang(jsonObject.getString(FG11PeralatanKerjaProduksiPengecatan.Cols.SATUAN_KAPASITAS_TERPASANG));
            item.setDimensi(jsonObject.getString(FG11PeralatanKerjaProduksiPengecatan.Cols.DIMENSI));
            item.setJumlah(jsonObject.getInt(FG11PeralatanKerjaProduksiPengecatan.Cols.JUMLAH));
            item.setKondisi(jsonObject.getString(FG11PeralatanKerjaProduksiPengecatan.Cols.KONDISI));
            item.setLokasi(jsonObject.getString(FG11PeralatanKerjaProduksiPengecatan.Cols.LOKASI));
            item.setStatus(jsonObject.getString(FG11PeralatanKerjaProduksiPengecatan.Cols.STATUS));
            items.add(item);
        }
    }

    private void parseFormKompal3as(List<SingleForm> items, JSONArray jsonBody) throws IOException, JSONException {

        for (int i = 0; i < jsonBody.length(); i++) {
            JSONObject jsonObject = jsonBody.getJSONObject(i);
            FormKompal3a item = new FormKompal3a();
            item.setFormServerId(jsonObject.getInt(FK3aJenisKapasitasProduksiTable.Cols.ID_F2_JENIS_KAPASITAS_PRODUKSI_SERVER));
            item.setKualifikasiSurveyId(jsonObject.getInt(FK3aJenisKapasitasProduksiTable.Cols.ID_KUALIFIKASI_SURVEY));
            item.setJenisProduksi(jsonObject.getString(FK3aJenisKapasitasProduksiTable.Cols.JENIS_PRODUKSI));
            item.setKapasitasProduksi(jsonObject.getInt(FK3aJenisKapasitasProduksiTable.Cols.KAPASITAS_PRODUKSI));
            item.setSatuan(jsonObject.getInt(FK3aJenisKapasitasProduksiTable.Cols.ID_MST_SATUAN));
            items.add(item);
        }
    }



    private void parseFormKompal3bs(List<SingleForm> items, JSONArray jsonBody) throws IOException, JSONException {

        for (int i = 0; i < jsonBody.length(); i++) {
            JSONObject jsonObject = jsonBody.getJSONObject(i);
            FormKompal3b item = new FormKompal3b();
            item.setFormServerId(jsonObject.getInt(FK3bJumlahProduksiTable.Cols.ID_F2_JUMLAH_PRODUKSI_SERVER));
            item.setKualifikasiSurveyId(jsonObject.getInt(FK3bJumlahProduksiTable.Cols.ID_KUALIFIKASI_SURVEY));
            item.setJenisProdukId(jsonObject.getInt(FK3bJumlahProduksiTable.Cols.ID_F2_JENIS_KAPASITAS_PRODUKSI));
            item.setJumlahProdThn4(jsonObject.getInt(FK3bJumlahProduksiTable.Cols.JUMLAH_PROD_NMIN4));
            item.setJumlahProdThn3(jsonObject.getInt(FK3bJumlahProduksiTable.Cols.JUMLAH_PROD_NMIN3));
            item.setJumlahProdThn2(jsonObject.getInt(FK3bJumlahProduksiTable.Cols.JUMLAH_PROD_NMIN2));
            item.setJumlahProdThn1(jsonObject.getInt(FK3bJumlahProduksiTable.Cols.JUMLAH_PROD_NMIN1));
            item.setSatuanId(jsonObject.getInt(FK3bJumlahProduksiTable.Cols.ID_MST_SATUAN));
            item.setNilaiProduksiThn4(jsonObject.getDouble(FK3bJumlahProduksiTable.Cols.NILAI_PRODUKSI_NMIN4));
            item.setNilaiProduksiThn3(jsonObject.getDouble(FK3bJumlahProduksiTable.Cols.NILAI_PRODUKSI_NMIN3));
            item.setNilaiProduksiThn2(jsonObject.getDouble(FK3bJumlahProduksiTable.Cols.NILAI_PRODUKSI_NMIN2));
            item.setNilaiProduksiThn1(jsonObject.getDouble(FK3bJumlahProduksiTable.Cols.NILAI_PRODUKSI_NMIN1));
            item.setKeterangan(jsonObject.getString(FK3bJumlahProduksiTable.Cols.KETERANGAN));

            items.add(item);
        }
    }



    private void parseFormKompal3cs(List<SingleForm> items, JSONArray jsonBody) throws IOException, JSONException {
        for (int i = 0; i < jsonBody.length(); i++) {
            JSONObject jsonObject = jsonBody.getJSONObject(i);
            FormKompal3c item = new FormKompal3c();
            item.setFormServerId(jsonObject.getInt(FK3cSistemBerproduksiTable.Cols.ID_F2_SISTEM_BERPRODUKSI_SERVER));
            item.setKualifikasiSurveyId(jsonObject.getInt(FK3cSistemBerproduksiTable.Cols.ID_KUALIFIKASI_SURVEY));
            item.setNamaProduk(jsonObject.getString(FK3cSistemBerproduksiTable.Cols.NAMA_PRODUK));
            item.setSistemProduksi(jsonObject.getInt(FK3cSistemBerproduksiTable.Cols.ID_MST_JENIS_BERPRODUKSI));
            item.setJenisProduksi(jsonObject.getInt(FK3cSistemBerproduksiTable.Cols.ID_MST_JENIS_PRODUKSI));
            item.setJumlahProduksiThn4(jsonObject.getInt(FK3cSistemBerproduksiTable.Cols.JUMLAH_PROD_NMIN4));
            item.setJumlahProduksiThn3(jsonObject.getInt(FK3cSistemBerproduksiTable.Cols.JUMLAH_PROD_NMIN3));
            item.setJumlahProduksiThn2(jsonObject.getInt(FK3cSistemBerproduksiTable.Cols.JUMLAH_PROD_NMIN2));
            item.setJumlahProduksiThn1(jsonObject.getInt(FK3cSistemBerproduksiTable.Cols.JUMLAH_PROD_NMIN1));
            items.add(item);
        }
    }


    private void parseFormKompal3ds(List<SingleForm> items, JSONArray jsonBody) throws IOException, JSONException {

        for (int i = 0; i < jsonBody.length(); i++) {
            JSONObject jsonObject = jsonBody.getJSONObject(i);
            FormKompal3d item = new FormKompal3d();
            item.setFormServerId(jsonObject.getInt(FK3dStandarMutuTableTable.Cols.ID_F2_STANDAR_MUTU_SERVER));
            item.setKualifikasiSurveyId(jsonObject.getInt(FK3dStandarMutuTableTable.Cols.ID_KUALIFIKASI_SURVEY));
            item.setJenisStandarMutu(jsonObject.getString(FK3dStandarMutuTableTable.Cols.JENIS_STANDAR_MUTU));
            item.setKeterangan(jsonObject.getString(FK3dStandarMutuTableTable.Cols.KETERANGAN));
            items.add(item);
        }
    }



    public List<SingleMaster> fetchMasterDatas() {
        List<SingleMaster> items=new ArrayList<>();

        try {

            String jsonMstPropinsiString = getUrlString(MSTPropinsiENDPOINT);
            String jsonMstKabupatenString = getUrlString(MSTKabupatenENDPOINT);
            //String jsonMstAirPelayaranString=getUrlString(MSTAirPelayaranENDPOINT);
            String jsonMstArusString=getUrlString(MSTArusENDPOINT);
            String jsonMstGelombangString=getUrlString(MSTGelombangENDPOINT);
            String jsonMstJarakKedalamanString=getUrlString(MSTJarakKedalamanENDPOINT);
            String jsonMstJenisProduksiString=getUrlString(MSTJenisProduksiENDPOINT);
            String jsonMstPasangSurutString=getUrlString(MSTPasangSurutENDPOINT);
            String jsonMstSatuanString=getUrlString(MSTSatuanENDPOINT);

            Log.i(TAG, "Received JSON: " + jsonMstPropinsiString);
            Log.i(TAG, "Received JSON: " + jsonMstKabupatenString);
           // Log.i(TAG, "Received JSON: " + jsonMstAirPelayaranString);
            Log.i(TAG, "Received JSON: " + jsonMstArusString);
            Log.i(TAG, "Received JSON: " + jsonMstGelombangString);
            Log.i(TAG, "Received JSON: " + jsonMstJarakKedalamanString);
            Log.i(TAG, "Received JSON: " + jsonMstJenisProduksiString);
            Log.i(TAG, "Received JSON: " + jsonMstPasangSurutString);
            Log.i(TAG, "Received JSON: " + jsonMstSatuanString);

            JSONArray jsonMstPropinsiBody = new JSONArray(jsonMstPropinsiString);
            JSONArray jsonMstKabupatenBody = new JSONArray(jsonMstKabupatenString);
            //JSONArray jsonMstAirPelayaranBody = new JSONArray(jsonMstAirPelayaranString);
            JSONArray jsonMstArusBody = new JSONArray(jsonMstArusString);
            JSONArray jsonMstGelombangBody = new JSONArray(jsonMstGelombangString);
            JSONArray jsonMstJarakKedalamanBody = new JSONArray(jsonMstJarakKedalamanString);
            JSONArray jsonMstJenisProduksiBody = new JSONArray(jsonMstJenisProduksiString);
            JSONArray jsonMstPasangSurutBody = new JSONArray(jsonMstPasangSurutString);
            JSONArray jsonMstSatuanBody = new JSONArray(jsonMstSatuanString);


            parsePropinsis(items,jsonMstPropinsiBody);
            parseKabupatens(items,jsonMstKabupatenBody);
            //parseMstAirPelayarans(items,jsonMstAirPelayaranBody);
            parseMstAruss(items,jsonMstArusBody);
            parseMstGelombangs(items,jsonMstGelombangBody);
            parseMstJarakKedalamans(items,jsonMstJarakKedalamanBody);
            parseMstJenisProduksis(items,jsonMstJenisProduksiBody);
            parseMstPasangSuruts(items,jsonMstPasangSurutBody);
            parseMstSatuans(items,jsonMstSatuanBody);


        } catch (JSONException je){
            Log.e(TAG, "Failed to parse JSON", je);
        } catch (IOException ioe) {
            Log.e(TAG, "Failed to fetch items", ioe);
        }

        return items;
    }



    private void parsePropinsis(List<SingleMaster> items, JSONArray jsonBody) throws IOException, JSONException {

        for (int i = 0; i < jsonBody.length(); i++) {
            JSONObject jsonObject = jsonBody.getJSONObject(i);
            MstPropinsi item = new MstPropinsi();
            item.setId(jsonObject.getInt(MstPropinsiTable.Cols.ID_PROPINSI));
            item.setKodeBps(jsonObject.getInt(MstPropinsiTable.Cols.KODEBPS));
            item.setNama(jsonObject.getString(MstPropinsiTable.Cols.NAMA));
            item.setKodeiso(jsonObject.getString(MstPropinsiTable.Cols.KODEISO));
            item.setIbukota(jsonObject.getString(MstPropinsiTable.Cols.IBUKOTA));
            item.setPulau(jsonObject.getString(MstPropinsiTable.Cols.PULAU));
            items.add(item);
        }
    }

    private void parseKabupatens(List<SingleMaster> items, JSONArray jsonBody) throws IOException, JSONException {

        for (int i = 0; i < jsonBody.length(); i++) {
            JSONObject jsonObject = jsonBody.getJSONObject(i);
            MstKabupaten item = new MstKabupaten();
            item.setId(jsonObject.getInt(MstKabupatenTable.Cols.ID));
            item.setNama(jsonObject.getString(MstKabupatenTable.Cols.NAMA));
            item.setIbuKota(jsonObject.getString(MstKabupatenTable.Cols.IBU_KOTA));
            item.setId_propinsi(jsonObject.getInt(MstKabupatenTable.Cols.ID_PROPINSI));
            item.setIbuKotaPropinsi(jsonObject.getInt(MstKabupatenTable.Cols.IBUKOTAPROP));
            item.setJumlahPenduduk(jsonObject.getInt(MstKabupatenTable.Cols.JMLPENDUDUK));
            item.setKodebps(jsonObject.getInt(MstKabupatenTable.Cols.KODEBPS));
            items.add(item);
        }
    }

    private void parseMstAirPelayarans(List<SingleMaster> items, JSONArray jsonBody) throws IOException, JSONException {

        for (int i = 0; i < jsonBody.length(); i++) {
            JSONObject jsonObject = jsonBody.getJSONObject(i);
            MstAirPelayaran item = new MstAirPelayaran();
            item.setIdMstAirPelayaran(jsonObject.getInt(MstAirPelayaranTable.Cols.ID_MST_AIR_PELAYARAN));
            item.setAirPelayaran(jsonObject.getString(MstAirPelayaranTable.Cols.AIR_PELAYARAN));
            items.add(item);
        }
    }

    private void parseMstAruss(List<SingleMaster> items, JSONArray jsonBody) throws IOException, JSONException {

        for (int i = 0; i < jsonBody.length(); i++) {
            JSONObject jsonObject = jsonBody.getJSONObject(i);
            MstArus item = new MstArus();
            item.setIdMstArus(jsonObject.getInt(MstArusTable.Cols.ID_MST_ARUS));
            item.setArus(jsonObject.getString(MstArusTable.Cols.ARUS));
            items.add(item);
        }
    }

    private void parseMstGelombangs(List<SingleMaster> items, JSONArray jsonBody) throws IOException, JSONException {

        for (int i = 0; i < jsonBody.length(); i++) {
            JSONObject jsonObject = jsonBody.getJSONObject(i);
            MstGelombang item = new MstGelombang();
            item.setIdMstGelombang(jsonObject.getInt(MstGelombangTable.Cols.ID_MST_GELOMBANG));
            item.setMstGelombang(jsonObject.getString(MstGelombangTable.Cols.MST_GELOMBANG));
            items.add(item);
        }
    }

    private void parseMstJarakKedalamans(List<SingleMaster> items, JSONArray jsonBody) throws IOException, JSONException {

        for (int i = 0; i < jsonBody.length(); i++) {
            JSONObject jsonObject = jsonBody.getJSONObject(i);
            MstJarakKedalaman item = new MstJarakKedalaman();
            item.setIdMstJarakKedalaman(jsonObject.getInt(MstJarakKedalamanTable.Cols.ID_MST_JARAK_KEDALAMAN));
            item.setJarakKedalaman(jsonObject.getString(MstJarakKedalamanTable.Cols.JARAK_KEDALAMAN));
            items.add(item);
        }
    }

    private void parseMstJenisProduksis(List<SingleMaster> items, JSONArray jsonBody) throws IOException, JSONException {

        for (int i = 0; i < jsonBody.length(); i++) {
            JSONObject jsonObject = jsonBody.getJSONObject(i);
            MstJenisProduksi item = new MstJenisProduksi();
            item.setIdMstJenisProduksi(jsonObject.getInt(MstJenisProduksiTable.Cols.ID_MST_JENIS_PRODUKSI));
            item.setJenisProduksi(jsonObject.getString(MstJenisProduksiTable.Cols.JENIS_PRODUKSI));
            item.setKki(jsonObject.getString(MstJenisProduksiTable.Cols.KKI));
            items.add(item);
        }
    }

    private void parseMstPasangSuruts(List<SingleMaster> items, JSONArray jsonBody) throws IOException, JSONException {

        for (int i = 0; i < jsonBody.length(); i++) {
            JSONObject jsonObject = jsonBody.getJSONObject(i);
            MstPasangSurut item = new MstPasangSurut();
            item.setIdMstPasangSurut(jsonObject.getInt(MstPasangSurutTable.Cols.ID_MST_PASANG_SURUT));
            item.setPasangSurut(jsonObject.getString(MstPasangSurutTable.Cols.PASANG_SURUT));
            items.add(item);
        }
    }

    private void parseMstSatuans(List<SingleMaster> items, JSONArray jsonBody) throws IOException, JSONException {

        for (int i = 0; i < jsonBody.length(); i++) {
            JSONObject jsonObject = jsonBody.getJSONObject(i);
            MstSatuan item = new MstSatuan();
            item.setIdMstSatuan(jsonObject.getInt(MstSatuanTable.Cols.ID_MST_SATUAN));
            item.setSatuan(jsonObject.getString(MstSatuanTable.Cols.SATUAN));
            items.add(item);
        }
    }

    public List<MenuCheckingKompal> fetchMenuCheckingKompals(String idKualifikasiSurvey) {
        List<MenuCheckingKompal> items=new ArrayList<>();
        String uriMenuCheckingKompal=buildUrl(MenuCheckingKompalENDPOINT,idKualifikasiSurvey);
        try {
            String jsonMenuCheckingKompalString=getUrlString(uriMenuCheckingKompal);
            Log.i(TAG, "Received JSON: " + jsonMenuCheckingKompalString);

            JSONArray jsonMenuCheckingKompalBody=new JSONArray(jsonMenuCheckingKompalString);
            parseMenuCheckingKompals(items,jsonMenuCheckingKompalBody);

        } catch (JSONException je){
            Log.e(TAG, "Failed to parse JSON", je);
        } catch (IOException ioe) {
            Log.e(TAG, "Failed to fetch items", ioe);
        }

        return items;
    }

    public List<MenuCheckingGalpal> fetchMenuCheckingGalpal(String idKualifikasiSurvey) {
        List<MenuCheckingGalpal> items=new ArrayList<>();
        String uriMenuCheckingGalpal=buildUrl(MenuCheckingGalpalENDPOINT,idKualifikasiSurvey);
        try {
            String jsonMenuCheckingGalpalString=getUrlString(uriMenuCheckingGalpal);
            Log.i(TAG, "Received JSON: " + jsonMenuCheckingGalpalString);

            JSONArray jsonMenuCheckingGalpalBody=new JSONArray(jsonMenuCheckingGalpalString);
            parseMenuCheckingGalpals(items,jsonMenuCheckingGalpalBody);

        } catch (JSONException je){
            Log.e(TAG, "Failed to parse JSON", je);
        } catch (IOException ioe) {
            Log.e(TAG, "Failed to fetch items", ioe);
        }

        return items;
    }

    private void parseMenuCheckingGalpals(List<MenuCheckingGalpal> items, JSONArray jsonBody) throws IOException, JSONException {

        for (int i = 0; i < jsonBody.length(); i++) {
            JSONObject jsonObject = jsonBody.getJSONObject(i);
            MenuCheckingGalpal item = new MenuCheckingGalpal();
            item.setIdMenuCheckingGalpal(jsonObject.getInt(MenuCheckingGalpalTable.Cols.ID_MENU_F1_ENTRY_CHECKING));
            item.setIdKualifikasiSurvey(jsonObject.getInt(MenuCheckingGalpalTable.Cols.ID_KUALIFIKASI_SURVEY));
            item.setIdMenu(jsonObject.getInt(MenuCheckingGalpalTable.Cols.ID_MENU_F1));
            item.setFill((jsonObject.getInt(MenuCheckingGalpalTable.Cols.IS_FILL)==1));
            item.setComplete(jsonObject.getInt(MenuCheckingGalpalTable.Cols.IS_COMPLETE)==1);
            item.setVerified(jsonObject.getInt(MenuCheckingGalpalTable.Cols.IS_VERIFIED)==1);
            items.add(item);
        }
    }

    private void parseMenuCheckingKompals(List<MenuCheckingKompal> items, JSONArray jsonBody) throws IOException, JSONException {

        for (int i = 0; i < jsonBody.length(); i++) {
            JSONObject jsonObject = jsonBody.getJSONObject(i);
            MenuCheckingKompal item = new MenuCheckingKompal();
            item.setIdMenuCheckingKompal(jsonObject.getInt(MenuCheckingKompalTable.Cols.ID_MENU_F2_ENTRY_CHECKING));
            item.setIdKualifikasiSurvey(jsonObject.getInt(MenuCheckingKompalTable.Cols.ID_KUALIFIKASI_SURVEY));
            item.setIdMenu(jsonObject.getInt(MenuCheckingKompalTable.Cols.ID_MENU_F2));
            item.setFill((jsonObject.getInt(MenuCheckingKompalTable.Cols.IS_FILL)==1));
            item.setComplete(jsonObject.getInt(MenuCheckingKompalTable.Cols.IS_COMPLETE)==1);
            item.setVerified(jsonObject.getInt(MenuCheckingKompalTable.Cols.IS_VERIFIED)==1);
            items.add(item);
        }
    }

    public List<Menu> fetchMenus() {
        List<Menu> items=new ArrayList<>();

        try {

            String jsonMenuF1String = getUrlString(MenuF1ENDPOINT);
            String jsonMenuF2String = getUrlString(MenuF2ENDPOINT);

            Log.i(TAG, "Received JSON: " + jsonMenuF1String);
            Log.i(TAG, "Received JSON: " + jsonMenuF1String);

            JSONArray jsonMenuF1Body = new JSONArray(jsonMenuF1String);
            JSONArray jsonMenuF2Body = new JSONArray(jsonMenuF2String);

            parseMenuF1s(items,jsonMenuF1Body);
            parseMenuF2s(items,jsonMenuF2Body);


        } catch (JSONException je){
            Log.e(TAG, "Failed to parse JSON", je);
        } catch (IOException ioe) {
            Log.e(TAG, "Failed to fetch items", ioe);
        }

        return items;
    }

    private void parseMenuF1s(List<Menu> items, JSONArray jsonBody) throws IOException, JSONException {
        for (int i = 0; i < jsonBody.length(); i++) {
            JSONObject jsonObject = jsonBody.getJSONObject(i);
            MenuF1 item = new MenuF1();
            item.setIdMenuF1(jsonObject.getInt(MenuF1Table.Cols.ID_MENU_F1));
            item.setNamaMenu(jsonObject.getString(MenuF1Table.Cols.NAMA_MENU));
            item.setNumber(jsonObject.getString(MenuF1Table.Cols.NUMBER));
            items.add(item);
        }
    }

    private void parseMenuF2s(List<Menu> items, JSONArray jsonBody) throws IOException, JSONException {
        for (int i = 0; i < jsonBody.length(); i++) {
            JSONObject jsonObject = jsonBody.getJSONObject(i);
            MenuF2 item = new MenuF2();
            item.setIdMenuF2(jsonObject.getInt(MenuF2Table.Cols.ID_MENU_F2));
            item.setNamaMenu(jsonObject.getString(MenuF2Table.Cols.NAMA_MENU));
            item.setNumber(jsonObject.getString(MenuF2Table.Cols.NUMBER));
            items.add(item);
        }
    }





/*
    public List<MODEL> fetchMODELs() {
        List<MODEL> items=new ArrayList<>();

        try {

            String jsonString = getUrlString("http://192.168.1.102/galpal/");
            Log.i(TAG, "Received JSON: " + jsonString);
            JSONArray jsonBody = new JSONArray(jsonString);
            parseMODELs(items,jsonBody);
        } catch (JSONException je){
            Log.e(TAG, "Failed to parse JSON", je);
        } catch (IOException ioe) {
            Log.e(TAG, "Failed to fetch items", ioe);
        }

        return items;
    }

    private void parseMODELs(List<MODEL> items, JSONArray jsonBody) throws IOException, JSONException {

        for (int i = 0; i < jsonBody.length(); i++) {
            JSONObject jsonObject = jsonBody.getJSONObject(i);
            MODEL item = new MODEL();
            item.set(jsonObject.get(DhSchema.MODELTable.Cols.));
            items.add(item);
        }
    }

*/


}
