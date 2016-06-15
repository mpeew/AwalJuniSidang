package com.mpewpazi.android.awaljunisidang.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;
import com.mpewpazi.android.awaljunisidang.service.NotificationService;
import com.mpewpazi.android.awaljunisidang.R;
import com.mpewpazi.android.awaljunisidang.tools.ConnectionDetector;
import com.mpewpazi.android.awaljunisidang.tools.DataFetcher;
import com.mpewpazi.android.awaljunisidang.tools.DataPusher;
import com.mpewpazi.android.awaljunisidang.tools.GalKomSharedPreference;
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
import com.mpewpazi.android.awaljunisidang.database.DummyMaker;
import com.mpewpazi.android.awaljunisidang.masterDataModel.Menu;
import com.mpewpazi.android.awaljunisidang.masterDataModel.MenuF1;
import com.mpewpazi.android.awaljunisidang.masterDataModel.MenuF2;
import com.mpewpazi.android.awaljunisidang.masterDataModel.MstAirPelayaran;
import com.mpewpazi.android.awaljunisidang.masterDataModel.MstArus;
import com.mpewpazi.android.awaljunisidang.masterDataModel.MstGelombang;
import com.mpewpazi.android.awaljunisidang.masterDataModel.MstJarakKedalaman;
import com.mpewpazi.android.awaljunisidang.masterDataModel.MstJenisProduksi;
import com.mpewpazi.android.awaljunisidang.masterDataModel.MstKabupaten;
import com.mpewpazi.android.awaljunisidang.masterDataModel.MstPasangSurut;
import com.mpewpazi.android.awaljunisidang.masterDataModel.MstPropinsi;
import com.mpewpazi.android.awaljunisidang.masterDataModel.MstSatuan;
import com.mpewpazi.android.awaljunisidang.masterDataModel.SingleMaster;
import com.mpewpazi.android.awaljunisidang.modelExtras.KualifikasiSurvey;
import com.mpewpazi.android.awaljunisidang.modelExtras.MenuCheckingGalpal;
import com.mpewpazi.android.awaljunisidang.modelExtras.MenuCheckingKompal;
import com.mpewpazi.android.awaljunisidang.modelExtras.Perusahaan;
import com.mpewpazi.android.awaljunisidang.modelExtras.SingleMenuChecking;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity implements Validator.ValidationListener {
    private static final String EXTRA_ID_USER="usr";

    private boolean isValidated;


    private Validator validator;
    private Button mSignInButton;

    private DummyMaker mDummyMaker;


    @NotEmpty
    private EditText mUsernameEditText;

    @Password
    private EditText mPasswordEditText;
    private ProgressDialog mProgressDialog;



    private String buildUrl(Uri endpoint, String id) {
        Uri.Builder uriBuilder = endpoint.buildUpon().appendPath(id);
        return uriBuilder.build().toString();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mProgressDialog=new ProgressDialog(LoginActivity.this);
        validator=new Validator(this);
        validator.setValidationListener(this);

        mDummyMaker=DummyMaker.get(this);


        List<MstPropinsi> mstPropinsis=mDummyMaker.getMstPropinsis();

        if(mstPropinsis.size()<=0) {
            new FetchMenuTask().execute();
            new FetchMstDataTask().execute();
        }






        mUsernameEditText=(EditText)findViewById(R.id.login_username);
        mPasswordEditText=(EditText)findViewById(R.id.login_password);

        mSignInButton=(Button)findViewById(R.id.login_btn_signin);



        mSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validator.validate();
                if(!isValidated){
                    return;
                }
                String userid=mUsernameEditText.getText().toString();
                String password=mPasswordEditText.getText().toString();
                if(new ConnectionDetector(getApplicationContext()).isConnectingToInternet()) {
                    new FetchKualifikasiSurveyTask(userid, password).execute();
                }else{
                    Toast.makeText(getApplicationContext(),"Koneksi Internet Tidak Tersedia", Toast.LENGTH_LONG).show();
                }

            }
        });


    }

    @Override
    public void onValidationSucceeded() {
        isValidated=true;
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(this);

            // Display error messages ;)
            if (view instanceof EditText) {
                EditText editText=((EditText) view);
                editText.setError(message);
                editText.requestFocus();
            } else {
                Toast.makeText(this, message, Toast.LENGTH_LONG).show();
            }
        }
        isValidated=false;

    }



    private class FetchFormsTask extends AsyncTask<Void,Void,List<SingleForm>> {
        private List<KualifikasiSurvey> mKualifikasiSurveys;
        private List<SingleForm> mSingleForms=new ArrayList<>();

        private FetchFormsTask(List<KualifikasiSurvey> kualifikasiSurveys){
            mKualifikasiSurveys=kualifikasiSurveys;
        }

        @Override
        protected List<SingleForm> doInBackground(Void... params) {
            for(KualifikasiSurvey kualifikasiSurvey:mKualifikasiSurveys) {
                String jenisIndustri=mDummyMaker.getPerusahaan(kualifikasiSurvey.getPerusahaanId()).getIndustri();
                if(jenisIndustri.equals(Perusahaan.industriGalpal)) {
                    mSingleForms.addAll(new DataFetcher().fetchFormGalpals(String.valueOf(kualifikasiSurvey.getKualifikasiSurveyId())));
                }else{
                    mSingleForms.addAll(new DataFetcher().fetchFormKompals(String.valueOf(kualifikasiSurvey.getKualifikasiSurveyId())));
                }
            }
            return mSingleForms;
        }



        @Override
        protected void onPostExecute(List<SingleForm> singleForms) {
            for(SingleForm singleForm:singleForms){
                switch(singleForm.getKodeAsync()){
                    case FormGalpal1.kodeAsync:
                        DummyMaker.get(getApplicationContext()).addFormGalpal1((FormGalpal1)singleForm);
                        break;
                    case FormGalpal3.kodeAsync:
                        DummyMaker.get(getApplicationContext()).addFormGalpal3((FormGalpal3)singleForm);
                        break;
                    case FormGalpal4.kodeAsync:
                        DummyMaker.get(getApplicationContext()).addFormGalpal4((FormGalpal4)singleForm);
                        break;
                    case FormGalpal6.kodeAsync:
                        Log.i("test","kok kagak diload");
                        DummyMaker.get(getApplicationContext()).addFormGalpal6Server((FormGalpal6)singleForm);
                        break;
                    case FormGalpal7.kodeAsync:
                        DummyMaker.get(getApplicationContext()).addFormGalpal7Server((FormGalpal7)singleForm);
                        break;
                    case FormGalpal8.kodeAsync:
                        DummyMaker.get(getApplicationContext()).addFormGalpal8Server((FormGalpal8)singleForm);
                        break;
                    case FormGalpal9.kodeAsync:
                        DummyMaker.get(getApplicationContext()).addFormGalpal9Server((FormGalpal9)singleForm);
                        break;
                    case FormGalpal10.kodeAsync:
                        DummyMaker.get(getApplicationContext()).addFormGalpal10Server((FormGalpal10)singleForm);
                        break;
                    case FormGalpal11.kodeAsync:
                        DummyMaker.get(getApplicationContext()).addFormGalpal11Server((FormGalpal11)singleForm);
                        break;
                    case FormGalpalFoto.kodeAsync:
                        DummyMaker.get(getApplicationContext()).addFormGalpalFotoServer((FormGalpalFoto) singleForm);
                        break;
                    case FormKompal3a.kodeAsync:
                        DummyMaker.get(getApplicationContext()).addFormKompal3aServer((FormKompal3a)singleForm);
                        break;
                    case FormKompal3b.kodeAsync:
                        DummyMaker.get(getApplicationContext()).addFormKompal3bServer((FormKompal3b)singleForm);
                        break;
                    case FormKompal3c.kodeAsync:
                        DummyMaker.get(getApplicationContext()).addFormKompal3cServer((FormKompal3c)singleForm);
                        break;
                    case FormKompal3d.kodeAsync:
                        DummyMaker.get(getApplicationContext()).addFormKompal3dServer((FormKompal3d)singleForm);
                        break;
                }
            }
            mProgressDialog.dismiss();

        }
    }


    private class FetchMstDataTask extends AsyncTask<Void,Void,List<SingleMaster>> {
        ProgressDialog mProgressDialogMst=new ProgressDialog(LoginActivity.this);

        @Override
        protected void onPreExecute() {
            mProgressDialogMst.setMessage("Please Wait..");
            mProgressDialogMst.show();
        }

        @Override
        protected List<SingleMaster> doInBackground(Void... params) {

            return new DataFetcher().fetchMasterDatas();
        }



        @Override
        protected void onPostExecute(List<SingleMaster> singleMasters) {
            for(SingleMaster singleMaster:singleMasters){
                switch(singleMaster.getKodeMst()){
                    case MstAirPelayaran.kode:
                        DummyMaker.get(getApplicationContext()).addMstAirPelayaran((MstAirPelayaran) singleMaster);
                        break;
                    case MstArus.kode:
                        DummyMaker.get(getApplicationContext()).addMstArus((MstArus) singleMaster);
                        break;
                    case MstGelombang.kode:
                        DummyMaker.get(getApplicationContext()).addMstGelombang((MstGelombang) singleMaster);
                        break;
                    case MstJarakKedalaman.kode:
                        DummyMaker.get(getApplicationContext()).addMstJarakKedalaman((MstJarakKedalaman) singleMaster);
                        break;
                    case MstJenisProduksi.kode:
                        DummyMaker.get(getApplicationContext()).addMstJenisProduksi((MstJenisProduksi) singleMaster);
                        break;
                    case MstKabupaten.kode:
                        DummyMaker.get(getApplicationContext()).addMstKabupaten((MstKabupaten) singleMaster);
                        break;
                    case MstPasangSurut.kode:
                        DummyMaker.get(getApplicationContext()).addPasangSurut((MstPasangSurut) singleMaster);
                        break;
                    case MstPropinsi.kode:
                        DummyMaker.get(getApplicationContext()).addMstPropinsi((MstPropinsi) singleMaster);
                        break;
                    case MstSatuan.kode:
                        DummyMaker.get(getApplicationContext()).addSatuan((MstSatuan) singleMaster);
                        break;
                }
            }
            mProgressDialogMst.dismiss();


        }
    }




    private class FetchMenuCheckingTask extends AsyncTask<Void,Void,List<SingleMenuChecking>> {
        private List<KualifikasiSurvey> mKualifikasiSurveys;
        private List<SingleMenuChecking> mSingleMenuCheckings=new ArrayList<>();

        private FetchMenuCheckingTask(List<KualifikasiSurvey> kualifikasiSurveys){
            mKualifikasiSurveys=kualifikasiSurveys;
        }

        @Override
        protected List<SingleMenuChecking> doInBackground(Void... params) {
            for(KualifikasiSurvey kualifikasiSurvey:mKualifikasiSurveys) {
                String jenisIndustri=mDummyMaker.getPerusahaan(kualifikasiSurvey.getPerusahaanId()).getIndustri();
                if(jenisIndustri.equals(Perusahaan.industriGalpal)) {
                    mSingleMenuCheckings.addAll(new DataFetcher().fetchMenuCheckingGalpal(String.valueOf(kualifikasiSurvey.getKualifikasiSurveyId())));
                }else{
                    mSingleMenuCheckings.addAll(new DataFetcher().fetchMenuCheckingKompals(String.valueOf(kualifikasiSurvey.getKualifikasiSurveyId())));
                }
            }
            return mSingleMenuCheckings;
        }



        @Override
        protected void onPostExecute(List<SingleMenuChecking> singleMenuCheckings) {
            for(SingleMenuChecking singleMenuChecking:singleMenuCheckings){
                switch(singleMenuChecking.kodeAsync()){
                    case MenuCheckingGalpal.kodeAsync:
                        DummyMaker.get(getApplicationContext()).addMenuCheckingGalpalServer((MenuCheckingGalpal) singleMenuChecking);
                        break;
                    case MenuCheckingKompal.kodeAsync:
                        DummyMaker.get(getApplicationContext()).addMenuCheckingKompalServer((MenuCheckingKompal) singleMenuChecking);
                        break;
                }
            }
            Intent intent=new Intent(LoginActivity.this,HomePageActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);

        }
    }

    private class FetchMenuTask extends AsyncTask<Void,Void,List<Menu>> {

        @Override
        protected List<Menu> doInBackground(Void... params) {

            return new DataFetcher().fetchMenus();
        }



        @Override
        protected void onPostExecute(List<Menu> menus) {
            for(Menu menu:menus){
                switch(menu.getKodeAsync()){
                    case MenuF1.kodeAsync:
                        DummyMaker.get(getApplicationContext()).addMenuF1((MenuF1) menu);
                        break;
                    case MenuF2.kodeAsync:
                        DummyMaker.get(getApplicationContext()).addMenuF2((MenuF2) menu);
                        break;
                }
            }

        }
    }


    private class FetchKualifikasiSurveyTask extends AsyncTask<Void,Void,List<KualifikasiSurvey>> {
        private String mUserId;
        private String mPassword;




        public FetchKualifikasiSurveyTask(String userId,String password){
            mUserId=userId;
            mPassword=md5(password);
        }

        @Override
        protected void onPreExecute() {
            mProgressDialog.setMessage("Please Wait...");
            mProgressDialog.show();
        }

        @Override
        protected List<KualifikasiSurvey> doInBackground(Void... params) {

            return new DataPusher().makePostRequestLogin(mUserId,mPassword);
        }



        @Override
        protected void onPostExecute(List<KualifikasiSurvey> kualifikasiSurveys) {
            if(kualifikasiSurveys!=null) {
                for (KualifikasiSurvey kualifikasiSurvey : kualifikasiSurveys) {
                    DummyMaker.get(getApplicationContext()).addKualifikasiSurvey(kualifikasiSurvey);
                }
                new FetchPerusahaanTask(kualifikasiSurveys).execute();
                GalKomSharedPreference.setLoggedIn(getApplicationContext(),true);
                GalKomSharedPreference.setUserId(getApplicationContext(),mUserId);
                GalKomSharedPreference.setPassword(getApplicationContext(),mPassword);
                NotificationService.setServiceAlarm(LoginActivity.this,true);
            }else{
                Toast.makeText(getApplicationContext(),"Username Atau Password Salah", Toast.LENGTH_LONG).show();
                mProgressDialog.dismiss();
            }

        }
    }

    private class FetchPerusahaanTask extends AsyncTask<Void,Void,List<Perusahaan>> {
        private List<KualifikasiSurvey> mKualifikasiSurveys;
        List<Perusahaan> perusahaans=new ArrayList<>();

        public FetchPerusahaanTask(List <KualifikasiSurvey> kualifikasiSurveys){
            mKualifikasiSurveys=kualifikasiSurveys;
        }



        @Override
        protected List<Perusahaan> doInBackground(Void... params) {
            DataFetcher dataFetcher=new DataFetcher();
            for(KualifikasiSurvey kualifikasiSurvey:mKualifikasiSurveys){
                Perusahaan perusahaan=dataFetcher.fetchPerusahaan(String.valueOf(kualifikasiSurvey.getPerusahaanId()));
                perusahaans.add(perusahaan);
            }
            return perusahaans;
        }



        @Override
        protected void onPostExecute(List<Perusahaan> perusahaans) {
            for(Perusahaan perusahaan:perusahaans) {
                DummyMaker.get(getApplicationContext()).addPerusahaan(perusahaan);
            }
            new FetchFormsTask(mKualifikasiSurveys).execute();
            new FetchMenuCheckingTask(mKualifikasiSurveys).execute();
        }
    }

    private class PushTask extends AsyncTask<Void,Void,Void> {



        @Override
        protected Void doInBackground(Void... params) {
            new DataPusher().makePostRequestLogin("surveyorira","e251a0ac0aa6f4404548aac24316de31");
            return null;
        }


    }

    public static final String md5(final String s) {
        final String MD5 = "MD5";
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest
                    .getInstance(MD5);
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuilder hexString = new StringBuilder();
            for (byte aMessageDigest : messageDigest) {
                String h = Integer.toHexString(0xFF & aMessageDigest);
                while (h.length() < 2)
                    h = "0" + h;
                hexString.append(h);
            }
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
