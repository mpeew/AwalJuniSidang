package com.mpewpazi.android.awaljunisidang;

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
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal1;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal10;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal11;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal3;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal4;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal6;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal7;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal8;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal9;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpalFoto;
import com.mpewpazi.android.awaljunisidang.Form.FormKompal3a;
import com.mpewpazi.android.awaljunisidang.Form.FormKompal3b;
import com.mpewpazi.android.awaljunisidang.Form.FormKompal3c;
import com.mpewpazi.android.awaljunisidang.Form.FormKompal3d;
import com.mpewpazi.android.awaljunisidang.Form.SingleForm;
import com.mpewpazi.android.awaljunisidang.dummy.DummyMaker;
import com.mpewpazi.android.awaljunisidang.masterData.Menu;
import com.mpewpazi.android.awaljunisidang.masterData.MenuF1;
import com.mpewpazi.android.awaljunisidang.masterData.MenuF2;
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
import com.mpewpazi.android.awaljunisidang.model.Perusahaan;
import com.mpewpazi.android.awaljunisidang.model.SingleMenuChecking;

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


    private String mUserId;

    private String buildUrl(Uri endpoint, String id) {
        Uri.Builder uriBuilder = endpoint.buildUpon().appendPath(id);
        return uriBuilder.build().toString();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        validator=new Validator(this);
        validator.setValidationListener(this);

        mDummyMaker=DummyMaker.get(this);


        new FetchMenuTask().execute();
        new FetchMstDataTask().execute();

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
                mUserId=mUsernameEditText.getText().toString();
                FetchKualifikasiSurveyTask fetchKualifikasiSurveyTask;
                if(mUserId.equals("perinurpazri")){
                    fetchKualifikasiSurveyTask=new FetchKualifikasiSurveyTask(mUserId);
                    fetchKualifikasiSurveyTask.execute();
                    GalKomSharedPreference.setUserId(getApplicationContext(),mUserId);
                }else if(mUserId.equals("mpewpazi")){
                    fetchKualifikasiSurveyTask=new FetchKualifikasiSurveyTask(mUserId);
                    fetchKualifikasiSurveyTask.execute();
                    GalKomSharedPreference.setUserId(getApplicationContext(),mUserId);
                }else{
                    Toast.makeText(getApplicationContext(),"Salah",Toast.LENGTH_SHORT).show();
                    return;
                }
                GalKomSharedPreference.setLoggedIn(getApplicationContext(),true);
                NotificationService.setServiceAlarm(LoginActivity.this,true);
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

        }
    }


    private class FetchMstDataTask extends AsyncTask<Void,Void,List<SingleMaster>> {
        ProgressDialog mProgressDialog=new ProgressDialog(LoginActivity.this);

        @Override
        protected void onPreExecute() {
            mProgressDialog.setMessage("Please Wait..");
            mProgressDialog.show();
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
            mProgressDialog.dismiss();


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
                        DummyMaker.get(getApplicationContext()).addMenuCheckingGalpal((MenuCheckingGalpal) singleMenuChecking);
                        break;
                    case MenuCheckingKompal.kodeAsync:
                        DummyMaker.get(getApplicationContext()).addMenuCheckingKompal((MenuCheckingKompal) singleMenuChecking);
                        break;
                }
            }

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
        private ProgressDialog dialog=new ProgressDialog(LoginActivity.this);

        private KualifikasiSurvey mKualifikasiSurveyId1;
        private KualifikasiSurvey mKualifikasISurveyId2;

        public FetchKualifikasiSurveyTask(String userId){
            mUserId=userId;
        }

        @Override
        protected void onPreExecute() {
            dialog.setMessage("Please Wait...");
            dialog.show();
        }

        @Override
        protected List<KualifikasiSurvey> doInBackground(Void... params) {
            Log.i("a", "Received JSON ");
            List<KualifikasiSurvey> kualifikasiSurveys=new ArrayList<>();
            DataFetcher dataFetcher=new DataFetcher();
            if(mUserId.equals("mpewpazi")){
                mKualifikasiSurveyId1=dataFetcher.fetchKualifikasiSurvey(String.valueOf(20150101));
                mKualifikasISurveyId2=dataFetcher.fetchKualifikasiSurvey(String.valueOf(20150102));
            }else if(mUserId.equals("perinurpazri")){
                mKualifikasiSurveyId1=dataFetcher.fetchKualifikasiSurvey(String.valueOf(20150205));
                mKualifikasISurveyId2=dataFetcher.fetchKualifikasiSurvey(String.valueOf(20150291));
            }

            kualifikasiSurveys.add(mKualifikasiSurveyId1);
            kualifikasiSurveys.add(mKualifikasISurveyId2);
            return kualifikasiSurveys;
        }



        @Override
        protected void onPostExecute(List<KualifikasiSurvey> kualifikasiSurveys) {
            for(KualifikasiSurvey kualifikasiSurvey:kualifikasiSurveys) {
                DummyMaker.get(getApplicationContext()).addKualifikasiSurvey(kualifikasiSurvey);
            }

            new FetchPerusahaanTask(kualifikasiSurveys).execute();
            dialog.dismiss();
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
            Intent intent=new Intent(LoginActivity.this,HomePageActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
    }

    private class PushTask extends AsyncTask<Void,Void,Void> {



        @Override
        protected Void doInBackground(Void... params) {

            return null;
        }


    }
}
