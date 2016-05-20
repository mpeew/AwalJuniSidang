package com.mpewpazi.android.awaljunisidang;

import android.net.Uri;
import android.util.Log;

import com.mpewpazi.android.awaljunisidang.Form.FormGalpal1;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal3;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal4;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal6;
import com.mpewpazi.android.awaljunisidang.Form.FormKompal3a;
import com.mpewpazi.android.awaljunisidang.Form.FormKompal3b;
import com.mpewpazi.android.awaljunisidang.Form.FormKompal3c;
import com.mpewpazi.android.awaljunisidang.Form.FormKompal3d;
import com.mpewpazi.android.awaljunisidang.Form.SingleForm;
import com.mpewpazi.android.awaljunisidang.database.DhSchema;
import com.mpewpazi.android.awaljunisidang.masterData.Kabupaten;
import com.mpewpazi.android.awaljunisidang.masterData.Propinsi;
import com.mpewpazi.android.awaljunisidang.masterData.SingleMaster;
import com.mpewpazi.android.awaljunisidang.model.KualifikasiSurvey;
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
 * Created by asputra on 5/18/16.
 */
public class DataFetcher {
    private static final String TAG = "DataFethcer";

    private static final Uri FG1ENDPOINT = Uri.parse("http://192.168.1.100/galpal/perusahaanIdentitas/perusahaanidentitasapi/id");
    private static final Uri FG3ENDPOINT = Uri.parse("http://192.168.1.100/galpal/galanganKapal/galangankapalapi/id");
    private static final Uri FG4ENDPOINT = Uri.parse("http://192.168.1.100/galpal/f1TinjauanArea/api/id");
    private static final Uri FG6ENDPOINT = Uri.parse("http://192.168.1.100/galpal/f1PeralatanKerjaLrCrane/api/id");
    private static final Uri FK3aENDPOINT = Uri.parse("http://192.168.1.100/galpal/f2JenisKapasitasProduksi/api/id");
    private static final Uri FK3bENDPOINT = Uri.parse("http://192.168.1.100/galpal/f2JumlahProduksi/api/id");
    private static final Uri FK3cENDPOINT = Uri.parse("http://192.168.1.100/galpal/f2SistemBerproduksi/api/id");
    private static final Uri FK3dENDPOINT = Uri.parse("http://192.168.1.100/galpal/f2StandardMutu/api/id");

    private static final String MSTPropinsiENDPOINT="http://192.168.1.100/galpal/mstPropinsi/api";
    private static final String MSTKabupatenENDPOINT="http://192.168.1.100/galpal/mstKabupatenkota/api";
    private static final String MSTJarakKedalamanENDPOINT="http://192.168.1.100/galpal/mstJarakKedalaman/api";
    private static final String MSTAirPelayaranENDPOINT="http://192.168.1.100/galpal/";
    private static final String MSTPasangSurutENDPOINT="http://192.168.1.100/galpal/mstPasangSurut/api";
    private static final String MSTArusENDPOINT="http://192.168.1.100/galpal/mstArus/api";
    private static final String MSTGelombangENDPOINT="http://192.168.1.100/galpal/mstGelombang/api";
    private static final String MSTSatuanENDPOINT="http://192.168.1.100/galpal/mstSatuan/api";
    private static final String MSTJenisProduksiENDPOINT="http://192.168.1.100/galpal/mstJenisProduksi/api";

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

    public List<KualifikasiSurvey> fetchKualifikasiSurveys() {
        List<KualifikasiSurvey> items=new ArrayList<>();

        try {

            String jsonString = getUrlString("http://192.168.1.102/galpal/");
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
            item.setActive(jsonObject.getInt(PerusahaanTable.Cols.IS_ACTIV));
            items.add(item);
        }
    }

    public List<SingleForm> fetchFormGalpal1s(String idKualifikasiSurvey) {

        List<SingleForm> items=new ArrayList<>();
        String uriFormGalpal1=buildUrl(FG1ENDPOINT,idKualifikasiSurvey);
        String uriFormGalpal3=buildUrl(FG3ENDPOINT,idKualifikasiSurvey);
        String uriFormGalpal4=buildUrl(FG4ENDPOINT,idKualifikasiSurvey);
        String uriFormGalpal6=buildUrl(FG6ENDPOINT,idKualifikasiSurvey);
        String uriFormKompal3a=buildUrl(FK3aENDPOINT,idKualifikasiSurvey);
        String uriFormKompal3b=buildUrl(FK3bENDPOINT,idKualifikasiSurvey);
        String uriFormKompal3c=buildUrl(FK3cENDPOINT,idKualifikasiSurvey);
        String uriFormKompal3d=buildUrl(FK3dENDPOINT,idKualifikasiSurvey);

        try {
            String jsonFormGalpal1String=getUrlString(uriFormGalpal1);
            String jsonFormGalpal3String=getUrlString(uriFormGalpal3);
            String jsonFormGalpal4String=getUrlString(uriFormGalpal4);
            String jsonFormGalpal6String=getUrlString(uriFormGalpal6);
            String jsonFormKompal3aString=getUrlString(uriFormKompal3a);
            String jsonFormKompal3bString=getUrlString(uriFormKompal3b);
            String jsonFormKompal3cString=getUrlString(uriFormKompal3c);
            String jsonFormKompal3dString=getUrlString(uriFormKompal3d);

            Log.i(TAG, "Received JSON: " + jsonFormGalpal1String);
            Log.i(TAG, "Received JSON: " + jsonFormGalpal3String);
            Log.i(TAG, "Received JSON: " + jsonFormGalpal4String);
            //Log.i(TAG, "Received JSON: " + jsonFormGalpal6String);
            //Log.i(TAG, "Received JSON: " + jsonFormKompal3aString);
            //Log.i(TAG, "Received JSON: " + jsonFormKompal3bString);
           // Log.i(TAG, "Received JSON: " + jsonFormKompal3cString);
           // Log.i(TAG, "Received JSON: " + jsonFormKompal3dString);


            JSONObject jsonFormGalpal1Body = new JSONObject(jsonFormGalpal1String);
            JSONObject jsonFormGalpal3Body = new JSONObject(jsonFormGalpal3String);
            JSONObject jsonFormGalpal4Body = new JSONObject(jsonFormGalpal4String);
            //JSONArray jsonFormGalpal6Body = new JSONArray(jsonFormGalpal6String);
           // JSONArray jsonFormKompal3aBody=new JSONArray(jsonFormKompal3aString);
           // JSONArray jsonFormKompal3bBody=new JSONArray(jsonFormKompal3bString);
          //  JSONArray jsonFormKompal3cBody=new JSONArray(jsonFormKompal3cString);
          //  JSONArray jsonFormKompal3dBody=new JSONArray(jsonFormKompal3dString);

            parseFormGalpal3(items,jsonFormGalpal3Body);
            parseFormGalpal1(items,jsonFormGalpal1Body);

            parseFormGalpal4(items,jsonFormGalpal4Body);
            //parseFormGalpal6s(items,jsonFormGalpal6Body);
           // parseFormKompal3as(items,jsonFormKompal3aBody);
           // parseFormKompal3bs(items,jsonFormKompal3bBody);
           // parseFormKompal3cs(items,jsonFormKompal3cBody);
           // parseFormKompal3ds(items,jsonFormKompal3dBody);

        } catch (JSONException je){
            Log.e(TAG, "Failed to parse JSON", je);
        } catch (IOException ioe) {
            Log.e(TAG, "Failed to fetch items", ioe);
        }

        return items;
    }

    private void parseFormGalpal1(List<SingleForm> items, JSONObject jsonBody) throws IOException, JSONException {

            FormGalpal1 item = new FormGalpal1();
            item.setIdentitasPerusahaanId(jsonBody.getInt(FG1PerusahaanIdentitasTable.Cols.ID_PERUSAHAAN_IDENTITAS));
            item.setKualifikasiSurveyId(jsonBody.getInt(FG1PerusahaanIdentitasTable.Cols.ID_KUALIFIKASI_SURVEY));
            item.setAlamat(jsonBody.getString(FG1PerusahaanIdentitasTable.Cols.ALAMAT_PERUSAHAAN));
            item.setNomorTelepon(jsonBody.getString(FG1PerusahaanIdentitasTable.Cols.TELEPON_PERUSAHAAN));
            item.setFax(jsonBody.getString(FG1PerusahaanIdentitasTable.Cols.FAX_PERUSAHAAN));
            item.setKelurahan(jsonBody.getString(FG1PerusahaanIdentitasTable.Cols.KELURAHAN_PERUSAHAAN));
            item.setIdPropinsi(jsonBody.getInt(FG1PerusahaanIdentitasTable.Cols.ID_PROPINSI_PERUSAHAAN));
            item.setIdKabupaten_kota(jsonBody.getInt(FG1PerusahaanIdentitasTable.Cols.ID_KABUPATEN_PERUSAHAAN));
            item.setKodePos(jsonBody.getString(FG1PerusahaanIdentitasTable.Cols.KODE_POS_PERUSAHAAN));
            item.setAnggotaAsosiasi(jsonBody.getString(FG1PerusahaanIdentitasTable.Cols.ANGGOTA_ASOSIASI));
            item.setKategoriPerusahaan(jsonBody.getString(FG1PerusahaanIdentitasTable.Cols.KATEGORI_PERUSAHAAN));
            item.setContactPerson(jsonBody.getString(FG1PerusahaanIdentitasTable.Cols.CP_NAMA));
            item.setNomorCp(jsonBody.getString(FG1PerusahaanIdentitasTable.Cols.CP_NOMOR));
            item.setJabatan(jsonBody.getString(FG1PerusahaanIdentitasTable.Cols.CP_JABATAN));
            item.setEmail(jsonBody.getString(FG1PerusahaanIdentitasTable.Cols.CP_EMAIL));
            item.setWebsite(jsonBody.getString(FG1PerusahaanIdentitasTable.Cols.WEBSITE));
            item.setKecamatan(jsonBody.getString(FG1PerusahaanIdentitasTable.Cols.KECAMATAN_PERUSAHAAN));
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

    private void parseFormGalpal4(List<SingleForm> items, JSONObject jsonObject) throws IOException, JSONException {

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

    private void parseFormGalpal6s(List<SingleForm> items, JSONArray jsonBody) throws IOException, JSONException {

        for (int i = 0; i < jsonBody.length(); i++) {
            JSONObject jsonObject = jsonBody.getJSONObject(i);
            FormGalpal6 item = new FormGalpal6();
            //item.setIdPeralatanKerjaCrane(jsonObject.getInt(DhSchema.FG6PeralatanKerjaLuarCraneTable.Cols.ID_F1_PERALATAN_KERJA_LR_CRANE));
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



    private void parseFormKompal3as(List<SingleForm> items, JSONArray jsonBody) throws IOException, JSONException {

        for (int i = 0; i < jsonBody.length(); i++) {
            JSONObject jsonObject = jsonBody.getJSONObject(i);
            FormKompal3a item = new FormKompal3a();
            //item.setIdJenisKapasitasProduksi(jsonObject.getInt(DhSchema.FK3aJenisKapasitasProduksiTable.Cols.ID_F2_JENIS_KAPASITAS_PRODUKSI));
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
            //item.setIdjumlahProduksi(jsonObject.getInt(DhSchema.FK3bJumlahProduksiTable.Cols.ID_F2_JUMLAH_PRODUKSI));
            item.setIdKualifikasiSurvey(jsonObject.getInt(FK3bJumlahProduksiTable.Cols.ID_KUALIFIKASI_SURVEY));
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
           // item.setIdSistemBerproduksi(jsonObject.getInt(DhSchema.FK3cSistemBerproduksiTable.Cols.ID_F2_SISTEM_BERPRODUKSI));
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
            //item.setIdStandarMutu(jsonObject.getInt(DhSchema.FK3dStandarMutuTableTable.Cols.JENIS_STANDAR_MUTU));
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
            String jsonMstAirPelayaranString=getUrlString(MSTAirPelayaranENDPOINT);
            String jsonMstArusString=getUrlString(MSTArusENDPOINT);
            String jsonMstGelombangString=getUrlString(MSTGelombangENDPOINT);
            String jsonMstJarakKedalamanString=getUrlString(MSTJarakKedalamanENDPOINT);
            String jsonMstJenisProduksiString=getUrlString(MSTJenisProduksiENDPOINT);
            String jsonMstPasangSurutString=getUrlString(MSTPasangSurutENDPOINT);
            String jsonMstSatuanString=getUrlString(MSTSatuanENDPOINT);

            Log.i(TAG, "Received JSON: " + jsonMstPropinsiString);
            Log.i(TAG, "Received JSON: " + jsonMstKabupatenString);
            Log.i(TAG, "Received JSON: " + jsonMstAirPelayaranString);
            Log.i(TAG, "Received JSON: " + jsonMstArusString);
            Log.i(TAG, "Received JSON: " + jsonMstGelombangString);
            Log.i(TAG, "Received JSON: " + jsonMstJarakKedalamanString);
            Log.i(TAG, "Received JSON: " + jsonMstJenisProduksiString);
            Log.i(TAG, "Received JSON: " + jsonMstPasangSurutString);
            Log.i(TAG, "Received JSON: " + jsonMstSatuanString);

            JSONArray jsonMstPropinsiBody = new JSONArray(jsonMstPropinsiString);
            JSONArray jsonMstKabupatenBody = new JSONArray(jsonMstKabupatenString);
            JSONArray jsonMstAirPelayaranBody = new JSONArray(jsonMstAirPelayaranString);
            JSONArray jsonMstArusBody = new JSONArray(jsonMstArusString);
            JSONArray jsonMstGelombangBody = new JSONArray(jsonMstGelombangString);
            JSONArray jsonMstJarakKedalamanBody = new JSONArray(jsonMstJarakKedalamanString);
            JSONArray jsonMstJenisProduksiBody = new JSONArray(jsonMstJenisProduksiString);
            JSONArray jsonMstPasangSurutBody = new JSONArray(jsonMstPasangSurutString);
            JSONArray jsonMstSatuanBody = new JSONArray(jsonMstSatuanString);


            parsePropinsis(items,jsonMstPropinsiBody);
            parseKabupatens(items,jsonMstKabupatenBody);

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
            Propinsi item = new Propinsi();
            item.setId(jsonObject.getInt(DhSchema.MstPropinsiTable.Cols.ID_PROPINSI));
            item.setKodeBps(jsonObject.getInt(DhSchema.MstPropinsiTable.Cols.KODEBPS));
            item.setNama(jsonObject.getString(DhSchema.MstPropinsiTable.Cols.NAMA));
            item.setKodeiso(jsonObject.getString(DhSchema.MstPropinsiTable.Cols.KODEISO));
            item.setIbukota(jsonObject.getString(DhSchema.MstPropinsiTable.Cols.IBUKOTA));
            item.setPulau(jsonObject.getString(DhSchema.MstPropinsiTable.Cols.PULAU));
            items.add(item);
        }
    }

    private void parseKabupatens(List<SingleMaster> items, JSONArray jsonBody) throws IOException, JSONException {

        for (int i = 0; i < jsonBody.length(); i++) {
            JSONObject jsonObject = jsonBody.getJSONObject(i);
            Kabupaten item = new Kabupaten();
            item.setId(jsonObject.getInt(DhSchema.MstKabupatenTable.Cols.ID));
            item.setNama(jsonObject.getString(DhSchema.MstKabupatenTable.Cols.NAMA));
            item.setIbuKota(jsonObject.getString(DhSchema.MstKabupatenTable.Cols.IBU_KOTA));
            item.setId_propinsi(jsonObject.getInt(DhSchema.MstKabupatenTable.Cols.ID_PROPINSI));
            item.setIbuKotaPropinsi(jsonObject.getInt(DhSchema.MstKabupatenTable.Cols.IBUKOTAPROP));
            item.setJumlahPenduduk(jsonObject.getInt(DhSchema.MstKabupatenTable.Cols.JMLPENDUDUK));
            item.setKodebps(jsonObject.getInt(DhSchema.MstKabupatenTable.Cols.KODEBPS));
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
