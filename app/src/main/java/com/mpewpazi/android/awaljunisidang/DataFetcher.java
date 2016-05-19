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
import com.mpewpazi.android.awaljunisidang.database.DhSchema;
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
import static com.mpewpazi.android.awaljunisidang.database.DhSchema.SurveyAssignSurveyorTable;

/**
 * Created by asputra on 5/18/16.
 */
public class DataFetcher {
    private static final String TAG = "DataFethcer";


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

    public List<FormGalpal1> fetchFormGalpal1s() {
        List<FormGalpal1> items=new ArrayList<>();

        try {

            String jsonString = getUrlString("http://192.168.1.100/galpal/perusahaanIdentitas/perusahaanidentitasapi");
            Log.i(TAG, "Received JSON: " + jsonString);
            JSONArray jsonBody = new JSONArray(jsonString);
            parseFormGalpal1s(items,jsonBody);
        } catch (JSONException je){
            Log.e(TAG, "Failed to parse JSON", je);
        } catch (IOException ioe) {
            Log.e(TAG, "Failed to fetch items", ioe);
        }

        return items;
    }

    private void parseFormGalpal1s(List<FormGalpal1> items, JSONArray jsonBody) throws IOException, JSONException {

        for (int i = 0; i < jsonBody.length(); i++) {
            JSONObject formgalpal1JsonObject = jsonBody.getJSONObject(i);
            FormGalpal1 item = new FormGalpal1();
            item.setIdentitasPerusahaanId(formgalpal1JsonObject.getInt(FG1PerusahaanIdentitasTable.Cols.ID_PERUSAHAAN_IDENTITAS));
            item.setKualifikasiSurveyId(formgalpal1JsonObject.getInt(FG1PerusahaanIdentitasTable.Cols.ID_KUALIFIKASI_SURVEY));
            item.setAlamat(formgalpal1JsonObject.getString(FG1PerusahaanIdentitasTable.Cols.ALAMAT_PERUSAHAAN));
            item.setNomorTelepon(formgalpal1JsonObject.getString(FG1PerusahaanIdentitasTable.Cols.TELEPON_PERUSAHAAN));
            item.setFax(formgalpal1JsonObject.getString(FG1PerusahaanIdentitasTable.Cols.FAX_PERUSAHAAN));
            item.setKelurahan(formgalpal1JsonObject.getString(FG1PerusahaanIdentitasTable.Cols.KELURAHAN_PERUSAHAAN));
            item.setIdPropinsi(formgalpal1JsonObject.getInt(FG1PerusahaanIdentitasTable.Cols.ID_PROPINSI_PERUSAHAAN));
            item.setIdKabupaten_kota(formgalpal1JsonObject.getInt(FG1PerusahaanIdentitasTable.Cols.ID_KABUPATEN_PERUSAHAAN));
            item.setKodePos(formgalpal1JsonObject.getString(FG1PerusahaanIdentitasTable.Cols.KODE_POS_PERUSAHAAN));
            item.setAnggotaAsosiasi(formgalpal1JsonObject.getString(FG1PerusahaanIdentitasTable.Cols.ANGGOTA_ASOSIASI));
            item.setKategoriPerusahaan(formgalpal1JsonObject.getString(FG1PerusahaanIdentitasTable.Cols.KATEGORI_PERUSAHAAN));
            item.setContactPerson(formgalpal1JsonObject.getString(FG1PerusahaanIdentitasTable.Cols.CP_NAMA));
            item.setNomorCp(formgalpal1JsonObject.getString(FG1PerusahaanIdentitasTable.Cols.CP_NOMOR));
            item.setJabatan(formgalpal1JsonObject.getString(FG1PerusahaanIdentitasTable.Cols.CP_JABATAN));
            item.setEmail(formgalpal1JsonObject.getString(FG1PerusahaanIdentitasTable.Cols.CP_EMAIL));
            item.setWebsite(formgalpal1JsonObject.getString(FG1PerusahaanIdentitasTable.Cols.WEBSITE));
            item.setKecamatan(formgalpal1JsonObject.getString(FG1PerusahaanIdentitasTable.Cols.KECAMATAN_PERUSAHAAN));
            items.add(item);
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
            item.setUserId(jsonObject.getString(DhSchema.UserTable.Cols.USERID));
            item.setCodeId(jsonObject.getString(DhSchema.UserTable.Cols.CODE_ID));
            item.setType(jsonObject.getString(DhSchema.UserTable.Cols.TYPE));
            item.setFullName(jsonObject.getString(DhSchema.UserTable.Cols.FULL_NAME));
            item.setCompanyName(jsonObject.getInt(DhSchema.UserTable.Cols.COMPANY_NAME));
            item.setEmail(jsonObject.getString(DhSchema.UserTable.Cols.EMAIL));
            item.setPassword(jsonObject.getString(DhSchema.UserTable.Cols.PASSWORD));
            item.setSecurityCode(jsonObject.getString(DhSchema.UserTable.Cols.SECURITY_CODE));
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
            item.setKualifikasiSurveyId(jsonObject.getInt(DhSchema.KualifikasiSurveyTable.Cols.ID_KUALIFIKASI_SURVEY));
            item.setPerusahaanId(jsonObject.getInt(DhSchema.KualifikasiSurveyTable.Cols.ID_PERUSAHAAN));
            item.setPeriodeSurveyId(jsonObject.getInt(DhSchema.KualifikasiSurveyTable.Cols.ID_PERIODE));
            item.setGalanganKapalId(jsonObject.getInt(DhSchema.KualifikasiSurveyTable.Cols.ID_GALANGAN_KAPAL));
            item.setStatus(jsonObject.getInt(DhSchema.KualifikasiSurveyTable.Cols.STATUS));
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
            item.setPeriodeSurveyId(jsonObject.getInt(DhSchema.PeriodeSurveyTable.Cols.ID_PERIODE));
            item.setTahunKualifikasi(jsonObject.getString(DhSchema.PeriodeSurveyTable.Cols.TAHUN_KUALIFIKASI));
            item.setActivePeriode(jsonObject.getInt(DhSchema.PeriodeSurveyTable.Cols.IS_ACTIVE_PERIOD));
            item.setDone(jsonObject.getInt(DhSchema.PeriodeSurveyTable.Cols.IS_DONE));
            item.setKeterangan(jsonObject.getString(DhSchema.PeriodeSurveyTable.Cols.KETERANGAN));
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
            item.setId(jsonObject.getInt(DhSchema.PerusahaanTable.Cols.ID_PERUSAHAAN));
            item.setNamaPerusahaan(jsonObject.getString(DhSchema.PerusahaanTable.Cols.NAMA_PERUSAHAAN));
            item.setIndustri(jsonObject.getString(DhSchema.PerusahaanTable.Cols.INDUSTRI));
            item.setActive(jsonObject.getInt(DhSchema.PerusahaanTable.Cols.IS_ACTIV));
            items.add(item);
        }
    }

    public List<FormGalpal3> fetchFormGalpal3s() {
        List<FormGalpal3> items=new ArrayList<>();

        try {

            String jsonString = getUrlString("http://192.168.1.102/galpal/");
            Log.i(TAG, "Received JSON: " + jsonString);
            JSONArray jsonBody = new JSONArray(jsonString);
            parseFormGalpal3s(items,jsonBody);
        } catch (JSONException je){
            Log.e(TAG, "Failed to parse JSON", je);
        } catch (IOException ioe) {
            Log.e(TAG, "Failed to fetch items", ioe);
        }

        return items;
    }

    private void parseFormGalpal3s(List<FormGalpal3> items, JSONArray jsonBody) throws IOException, JSONException {

        for (int i = 0; i < jsonBody.length(); i++) {
            JSONObject jsonObject = jsonBody.getJSONObject(i);
            FormGalpal3 item = new FormGalpal3();
            item.setIdentitasUmumGalanganId(jsonObject.getInt(DhSchema.FG3GalanganKapalTable.Cols.ID_GALANGAN_KAPAL));
            item.setNamaGalangan(jsonObject.getString(DhSchema.FG3GalanganKapalTable.Cols.NAMA_GALANGAN));
            item.setKategoriGalangan(jsonObject.getString(DhSchema.FG3GalanganKapalTable.Cols.KATEGORI_GALANGAN));
            item.setKualifikasiSurveyId(jsonObject.getInt(DhSchema.FG3GalanganKapalTable.Cols.ID_KUALIFIKASI_SURVEY));
            item.setNomorDock(jsonObject.getString(DhSchema.FG3GalanganKapalTable.Cols.NOMOR_DOCK));
            item.setAlamat(jsonObject.getString(DhSchema.FG3GalanganKapalTable.Cols.ALAMAT_GALANGAN));
            item.setKelurahan(jsonObject.getString(DhSchema.FG3GalanganKapalTable.Cols.KELURAHAN_GALANGAN));
            item.setKecamatan(jsonObject.getString(DhSchema.FG3GalanganKapalTable.Cols.KECAMATAN_GALANGAN));
            item.setKebupaten_kotaId(jsonObject.getInt(DhSchema.FG3GalanganKapalTable.Cols.ID_KABUPATEN_GALANGAN));
            item.setPropinsiId(jsonObject.getInt(DhSchema.FG3GalanganKapalTable.Cols.ID_PROPINSI_GALANGAN));
            item.setNomorTelepon(jsonObject.getString(DhSchema.FG3GalanganKapalTable.Cols.TELEPON_GALANGAN));
            item.setFax(jsonObject.getString(DhSchema.FG3GalanganKapalTable.Cols.FAX_GALANGAN));
            item.setKodePos(jsonObject.getString(DhSchema.FG3GalanganKapalTable.Cols.KODE_POS_GALANGAN));
            item.setLongitude(jsonObject.getString(DhSchema.FG3GalanganKapalTable.Cols.LONGITUDE));
            item.setLatitude(jsonObject.getString(DhSchema.FG3GalanganKapalTable.Cols.LATITUDE));
            items.add(item);
        }
    }

    public List<FormGalpal4> fetchFormGalpal4s() {
        List<FormGalpal4> items=new ArrayList<>();

        try {

            String jsonString = getUrlString("http://192.168.1.100/galpal/");
            Log.i(TAG, "Received JSON: " + jsonString);
            JSONArray jsonBody = new JSONArray(jsonString);
            parseFormGalpal4s(items,jsonBody);
        } catch (JSONException je){
            Log.e(TAG, "Failed to parse JSON", je);
        } catch (IOException ioe) {
            Log.e(TAG, "Failed to fetch items", ioe);
        }

        return items;
    }

    private void parseFormGalpal4s(List<FormGalpal4> items, JSONArray jsonBody) throws IOException, JSONException {

        for (int i = 0; i < jsonBody.length(); i++) {
            JSONObject jsonObject = jsonBody.getJSONObject(i);
            FormGalpal4 item = new FormGalpal4();
            item.setTinjauanWilayahMaritimId(jsonObject.getInt(DhSchema.FG4TinjauanAreaTable.Cols.ID_F1_TINJAUAN_AREA));
            item.setKualifikasiSurveyId(jsonObject.getInt(DhSchema.FG4TinjauanAreaTable.Cols.ID_KUALIFIKASI_SURVEY));
            item.setJarakKedalaman(jsonObject.getInt(DhSchema.FG4TinjauanAreaTable.Cols.ID_MST_JARAK_KEDALAMAN));
            item.setAirPelayaran(jsonObject.getInt(DhSchema.FG4TinjauanAreaTable.Cols.ID_MST_AIR_PELAYARAN));
            item.setPasangSurutPerairan(jsonObject.getInt(DhSchema.FG4TinjauanAreaTable.Cols.ID_MST_PASANG_SURUT));
            item.setArus(jsonObject.getInt(DhSchema.FG4TinjauanAreaTable.Cols.ID_MST_ARUS));
            item.setGelombang(jsonObject.getInt(DhSchema.FG4TinjauanAreaTable.Cols.ID_MST_GELOMBANG));
            item.setPanjangWaterfront(jsonObject.getInt(DhSchema.FG4TinjauanAreaTable.Cols.PANJANG_WATERFRONT));
            item.setLuasLahan(jsonObject.getInt(DhSchema.FG4TinjauanAreaTable.Cols.LUAS_LAHAN));
            item.setKetersediaanLahan(jsonObject.getString(DhSchema.FG4TinjauanAreaTable.Cols.KETERSEDIAAN_LAHAN));
            item.setLahanProduktif(jsonObject.getString(DhSchema.FG4TinjauanAreaTable.Cols.LAHAN_PRODUKTIF));
            item.setLahanPemukiman(jsonObject.getString(DhSchema.FG4TinjauanAreaTable.Cols.LAHAN_PEMUKIMAN));
            item.setPasangSurutDaratan(jsonObject.getString(DhSchema.FG4TinjauanAreaTable.Cols.PASANG_SURUT));
            item.setDayaDukung(jsonObject.getString(DhSchema.FG4TinjauanAreaTable.Cols.DAYA_DUKUNG));
            item.setKelandaian(jsonObject.getString(DhSchema.FG4TinjauanAreaTable.Cols.KELANDAIAAN));
            item.setDekatJalan(jsonObject.getString(DhSchema.FG4TinjauanAreaTable.Cols.DEKAT_JALAN));
            item.setKota(jsonObject.getString(DhSchema.FG4TinjauanAreaTable.Cols.KOTA));
            item.setInterkoneksiAngkutan(jsonObject.getString(DhSchema.FG4TinjauanAreaTable.Cols.INTERKONEKSI_ANGKUTAN));
            item.setNilaiEkonomi(jsonObject.getString(DhSchema.FG4TinjauanAreaTable.Cols.NILAI_EKONOMI));
            item.setPerkembanganWilayah(jsonObject.getString(DhSchema.FG4TinjauanAreaTable.Cols.PERKEMBANGAN_WILAYAH));
            item.setRutrw(jsonObject.getString(DhSchema.FG4TinjauanAreaTable.Cols.RUTWR));


            items.add(item);
        }
    }

    public List<FormGalpal6> fetchFormGalpal6s() {
        List<FormGalpal6> items=new ArrayList<>();

        try {

            String jsonString = getUrlString("http://192.168.1.102/galpal/");
            Log.i(TAG, "Received JSON: " + jsonString);
            JSONArray jsonBody = new JSONArray(jsonString);
            parseFormGalpal6s(items,jsonBody);
        } catch (JSONException je){
            Log.e(TAG, "Failed to parse JSON", je);
        } catch (IOException ioe) {
            Log.e(TAG, "Failed to fetch items", ioe);
        }

        return items;
    }

    private void parseFormGalpal6s(List<FormGalpal6> items, JSONArray jsonBody) throws IOException, JSONException {

        for (int i = 0; i < jsonBody.length(); i++) {
            JSONObject jsonObject = jsonBody.getJSONObject(i);
            FormGalpal6 item = new FormGalpal6();
            //item.setIdPeralatanKerjaCrane(jsonObject.getInt(DhSchema.FG6PeralatanKerjaLuarCraneTable.Cols.ID_F1_PERALATAN_KERJA_LR_CRANE));
            item.setKualifikasiSurveyId(jsonObject.getInt(DhSchema.FG6PeralatanKerjaLuarCraneTable.Cols.ID_KUALIFIKASI_SURVEY));
            item.setJenisMesin(jsonObject.getString(DhSchema.FG6PeralatanKerjaLuarCraneTable.Cols.JENIS_MESIN));
            item.setTahunPembuatan(jsonObject.getInt(DhSchema.FG6PeralatanKerjaLuarCraneTable.Cols.TAHUN_PEMBUATAN));
            item.setMerek(jsonObject.getString(DhSchema.FG6PeralatanKerjaLuarCraneTable.Cols.MERK));
            item.setKapasitasTerpakai(jsonObject.getInt(DhSchema.FG6PeralatanKerjaLuarCraneTable.Cols.KAPASITAS_TERPAKAI));
            item.setSatuanKapasitasTerpakai(jsonObject.getString(DhSchema.FG6PeralatanKerjaLuarCraneTable.Cols.SATUAN_KAPASITAS_TERPAKAI));
            item.setKapasitasTerpasang(jsonObject.getInt(DhSchema.FG6PeralatanKerjaLuarCraneTable.Cols.KAPASAITAS_TERPASANG));
            item.setSatuanKapastiasTerpasang(jsonObject.getString(DhSchema.FG6PeralatanKerjaLuarCraneTable.Cols.SATUAN_KAPASITAS_TERPASANG));
            item.setDimensi(jsonObject.getString(DhSchema.FG6PeralatanKerjaLuarCraneTable.Cols.DIMENSI));
            item.setJumlah(jsonObject.getInt(DhSchema.FG6PeralatanKerjaLuarCraneTable.Cols.JUMLAH));
            item.setKondisi(jsonObject.getString(DhSchema.FG6PeralatanKerjaLuarCraneTable.Cols.KONDISI));
            item.setLokasi(jsonObject.getString(DhSchema.FG6PeralatanKerjaLuarCraneTable.Cols.LOKASI));
            item.setStatus(jsonObject.getString(DhSchema.FG6PeralatanKerjaLuarCraneTable.Cols.STATUS));
            items.add(item);
        }
    }

    public List<FormKompal3a> fetchFormKompal3as() {
        List<FormKompal3a> items=new ArrayList<>();

        try {

            String jsonString = getUrlString("http://192.168.1.102/galpal/");
            Log.i(TAG, "Received JSON: " + jsonString);
            JSONArray jsonBody = new JSONArray(jsonString);
            parseFormKompal3as(items,jsonBody);
        } catch (JSONException je){
            Log.e(TAG, "Failed to parse JSON", je);
        } catch (IOException ioe) {
            Log.e(TAG, "Failed to fetch items", ioe);
        }

        return items;
    }

    private void parseFormKompal3as(List<FormKompal3a> items, JSONArray jsonBody) throws IOException, JSONException {

        for (int i = 0; i < jsonBody.length(); i++) {
            JSONObject jsonObject = jsonBody.getJSONObject(i);
            FormKompal3a item = new FormKompal3a();
            //item.setIdJenisKapasitasProduksi(jsonObject.getInt(DhSchema.FK3aJenisKapasitasProduksiTable.Cols.ID_F2_JENIS_KAPASITAS_PRODUKSI));
            item.setKualifikasiSurveyId(jsonObject.getInt(DhSchema.FK3aJenisKapasitasProduksiTable.Cols.ID_KUALIFIKASI_SURVEY));
            item.setJenisProduksi(jsonObject.getString(DhSchema.FK3aJenisKapasitasProduksiTable.Cols.JENIS_PRODUKSI));
            item.setKapasitasProduksi(jsonObject.getInt(DhSchema.FK3aJenisKapasitasProduksiTable.Cols.KAPASITAS_PRODUKSI));
            item.setSatuan(jsonObject.getInt(DhSchema.FK3aJenisKapasitasProduksiTable.Cols.ID_MST_SATUAN));
            items.add(item);
        }
    }

    public List<FormKompal3b> fetchFormKompal3bs() {
        List<FormKompal3b> items=new ArrayList<>();

        try {

            String jsonString = getUrlString("http://192.168.1.102/galpal/");
            Log.i(TAG, "Received JSON: " + jsonString);
            JSONArray jsonBody = new JSONArray(jsonString);
            parseFormKompal3bs(items,jsonBody);
        } catch (JSONException je){
            Log.e(TAG, "Failed to parse JSON", je);
        } catch (IOException ioe) {
            Log.e(TAG, "Failed to fetch items", ioe);
        }

        return items;
    }

    private void parseFormKompal3bs(List<FormKompal3b> items, JSONArray jsonBody) throws IOException, JSONException {

        for (int i = 0; i < jsonBody.length(); i++) {
            JSONObject jsonObject = jsonBody.getJSONObject(i);
            FormKompal3b item = new FormKompal3b();
            //item.setIdjumlahProduksi(jsonObject.getInt(DhSchema.FK3bJumlahProduksiTable.Cols.ID_F2_JUMLAH_PRODUKSI));
            item.setIdKualifikasiSurvey(jsonObject.getInt(DhSchema.FK3bJumlahProduksiTable.Cols.ID_KUALIFIKASI_SURVEY));
            item.setJenisProdukId(jsonObject.getInt(DhSchema.FK3bJumlahProduksiTable.Cols.ID_F2_JENIS_KAPASITAS_PRODUKSI));
            item.setJumlahProdThn4(jsonObject.getInt(DhSchema.FK3bJumlahProduksiTable.Cols.JUMLAH_PROD_NMIN4));
            item.setJumlahProdThn3(jsonObject.getInt(DhSchema.FK3bJumlahProduksiTable.Cols.JUMLAH_PROD_NMIN3));
            item.setJumlahProdThn2(jsonObject.getInt(DhSchema.FK3bJumlahProduksiTable.Cols.JUMLAH_PROD_NMIN2));
            item.setJumlahProdThn1(jsonObject.getInt(DhSchema.FK3bJumlahProduksiTable.Cols.JUMLAH_PROD_NMIN1));
            item.setSatuanId(jsonObject.getInt(DhSchema.FK3bJumlahProduksiTable.Cols.ID_MST_SATUAN));
            item.setNilaiProduksiThn4(jsonObject.getDouble(DhSchema.FK3bJumlahProduksiTable.Cols.NILAI_PRODUKSI_NMIN4));
            item.setNilaiProduksiThn3(jsonObject.getDouble(DhSchema.FK3bJumlahProduksiTable.Cols.NILAI_PRODUKSI_NMIN3));
            item.setNilaiProduksiThn2(jsonObject.getDouble(DhSchema.FK3bJumlahProduksiTable.Cols.NILAI_PRODUKSI_NMIN2));
            item.setNilaiProduksiThn1(jsonObject.getDouble(DhSchema.FK3bJumlahProduksiTable.Cols.NILAI_PRODUKSI_NMIN1));
            item.setKeterangan(jsonObject.getString(DhSchema.FK3bJumlahProduksiTable.Cols.KETERANGAN));

            items.add(item);
        }
    }

    public List<FormKompal3c> fetchFormKompal3cs() {
        List<FormKompal3c> items=new ArrayList<>();

        try {

            String jsonString = getUrlString("http://192.168.1.102/galpal/");
            Log.i(TAG, "Received JSON: " + jsonString);
            JSONArray jsonBody = new JSONArray(jsonString);
            parseFormKompal3cs(items,jsonBody);
        } catch (JSONException je){
            Log.e(TAG, "Failed to parse JSON", je);
        } catch (IOException ioe) {
            Log.e(TAG, "Failed to fetch items", ioe);
        }

        return items;
    }

    private void parseFormKompal3cs(List<FormKompal3c> items, JSONArray jsonBody) throws IOException, JSONException {

        for (int i = 0; i < jsonBody.length(); i++) {
            JSONObject jsonObject = jsonBody.getJSONObject(i);
            FormKompal3c item = new FormKompal3c();
           // item.setIdSistemBerproduksi(jsonObject.getInt(DhSchema.FK3cSistemBerproduksiTable.Cols.ID_F2_SISTEM_BERPRODUKSI));
            item.setKualifikasiSurveyId(jsonObject.getInt(DhSchema.FK3cSistemBerproduksiTable.Cols.ID_KUALIFIKASI_SURVEY));
            item.setNamaProduk(jsonObject.getString(DhSchema.FK3cSistemBerproduksiTable.Cols.NAMA_PRODUK));
            item.setSistemProduksi(jsonObject.getInt(DhSchema.FK3cSistemBerproduksiTable.Cols.ID_MST_JENIS_BERPRODUKSI));
            item.setJenisProduksi(jsonObject.getInt(DhSchema.FK3cSistemBerproduksiTable.Cols.ID_MST_JENIS_PRODUKSI));
            item.setJumlahProduksiThn4(jsonObject.getInt(DhSchema.FK3cSistemBerproduksiTable.Cols.JUMLAH_PROD_NMIN4));
            item.setJumlahProduksiThn3(jsonObject.getInt(DhSchema.FK3cSistemBerproduksiTable.Cols.JUMLAH_PROD_NMIN3));
            item.setJumlahProduksiThn2(jsonObject.getInt(DhSchema.FK3cSistemBerproduksiTable.Cols.JUMLAH_PROD_NMIN2));
            item.setJumlahProduksiThn1(jsonObject.getInt(DhSchema.FK3cSistemBerproduksiTable.Cols.JUMLAH_PROD_NMIN1));
            items.add(item);
        }
    }

    public List<FormKompal3d> fetchFormKompal3ds() {
        List<FormKompal3d> items=new ArrayList<>();

        try {

            String jsonString = getUrlString("http://192.168.1.102/galpal/");
            Log.i(TAG, "Received JSON: " + jsonString);
            JSONArray jsonBody = new JSONArray(jsonString);
            parseFormKompal3ds(items,jsonBody);
        } catch (JSONException je){
            Log.e(TAG, "Failed to parse JSON", je);
        } catch (IOException ioe) {
            Log.e(TAG, "Failed to fetch items", ioe);
        }

        return items;
    }

    private void parseFormKompal3ds(List<FormKompal3d> items, JSONArray jsonBody) throws IOException, JSONException {

        for (int i = 0; i < jsonBody.length(); i++) {
            JSONObject jsonObject = jsonBody.getJSONObject(i);
            FormKompal3d item = new FormKompal3d();
            //item.setIdStandarMutu(jsonObject.getInt(DhSchema.FK3dStandarMutuTableTable.Cols.JENIS_STANDAR_MUTU));
            item.setKualifikasiSurveyId(jsonObject.getInt(DhSchema.FK3dStandarMutuTableTable.Cols.ID_KUALIFIKASI_SURVEY));
            item.setJenisStandarMutu(jsonObject.getString(DhSchema.FK3dStandarMutuTableTable.Cols.JENIS_STANDAR_MUTU));
            item.setKeterangan(jsonObject.getString(DhSchema.FK3dStandarMutuTableTable.Cols.KETERANGAN));
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
