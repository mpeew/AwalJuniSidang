package com.mpewpazi.android.awaljunisidang;

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
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal3;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal4;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal6;
import com.mpewpazi.android.awaljunisidang.Form.FormKompal3a;
import com.mpewpazi.android.awaljunisidang.Form.FormKompal3b;
import com.mpewpazi.android.awaljunisidang.Form.FormKompal3c;
import com.mpewpazi.android.awaljunisidang.Form.FormKompal3d;
import com.mpewpazi.android.awaljunisidang.Form.SingleForm;
import com.mpewpazi.android.awaljunisidang.dummy.DummyMaker;
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

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity implements Validator.ValidationListener {
    private static final String EXTRA_ID_USER="usr";

    private boolean isValidated;


    private Validator validator;
    private Button mSignInButton;

    private DummyMaker mDummyMaker;
    private List<KualifikasiSurvey> mKualifikasiSurveys;

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
       // new FetchMenuCheckingGalpalTask(String.valueOf(20150001)).execute();
       // new FetchMenuCheckingKompalTask(String.valueOf(20150001)).execute();
       // new FetchMstDataTask().execute();

        mDummyMaker=DummyMaker.get(this);
        mKualifikasiSurveys=mDummyMaker.getKualifikasiSurveys();


       // new PushTask().execute();
        /*for(KualifikasiSurvey kualifikasiSurvey:mKualifikasiSurveys) {
            String jenisIndustri=mDummyMaker.getPerusahaan(kualifikasiSurvey.getPerusahaanId()).getIndustri();
            if(jenisIndustri.equals("Galangan Kapal")) {
                new FetchFormGalpalTask(String.valueOf(kualifikasiSurvey.getKualifikasiSurveyId())).execute();
            }else{
                new FetchFormKompalTask(String.valueOf(kualifikasiSurvey.getKualifikasiSurveyId())).execute();
            }
        }*/


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
                if(mUserId.equals("perinurpazri")|| mUserId.equals("mpewpazi")){
                    Intent intent=new Intent(LoginActivity.this,HomePageActivity.class);
                    intent.putExtra(EXTRA_ID_USER,mUserId);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),"Salah",Toast.LENGTH_SHORT).show();
                    return;
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

    private class PushTask extends AsyncTask<Void,Void,Void> {


        @Override
        protected Void doInBackground(Void... params) {

            //new DataPusher().makePostRequestFG1();
            return null;
        }
    }

    private class FetchFormGalpalTask extends AsyncTask<Void,Void,List<SingleForm>> {
        private String mIdKualifikasiSurvey;

        private FetchFormGalpalTask(String idKualifikasiSurvey){
            mIdKualifikasiSurvey=idKualifikasiSurvey;
        }

        @Override
        protected List<SingleForm> doInBackground(Void... params) {
            Log.i("a", "Received JSON Galpal: " + mIdKualifikasiSurvey);
            return new DataFetcher().fetchFormGalpals(mIdKualifikasiSurvey);
        }



        @Override
        protected void onPostExecute(List<SingleForm> singleForms) {
            for(SingleForm singleForm:singleForms){
                switch(singleForm.getKodeForm()){
                    case FormGalpal1.kode:
                        DummyMaker.get(getApplicationContext()).addFormGalpal1((FormGalpal1)singleForm);
                        break;
                    case FormGalpal3.kode:
                        DummyMaker.get(getApplicationContext()).addFormGalpal3((FormGalpal3)singleForm);
                        break;
                    case FormGalpal4.kode:
                        DummyMaker.get(getApplicationContext()).addFormGalpal4((FormGalpal4)singleForm);
                        break;
                    case FormGalpal6.kode:
                        DummyMaker.get(getApplicationContext()).addFormGalpal6Server((FormGalpal6)singleForm);
                        break;
                }
            }

        }
    }

    private class FetchFormKompalTask extends AsyncTask<Void,Void,List<SingleForm>> {
        private String mIdKualifikasiSurvey;

        private FetchFormKompalTask(String idKualifikasiSurvey){
            mIdKualifikasiSurvey=idKualifikasiSurvey;
        }

        @Override
        protected List<SingleForm> doInBackground(Void... params) {
            Log.i("a", "Received JSON Kompal: " + mIdKualifikasiSurvey);
            return new DataFetcher().fetchFormKompals(mIdKualifikasiSurvey);
        }



        @Override
        protected void onPostExecute(List<SingleForm> singleForms) {
            for(SingleForm singleForm:singleForms){
                switch(singleForm.getKodeForm()){
                    case FormKompal3a.kode:
                        DummyMaker.get(getApplicationContext()).addFormKompal3a((FormKompal3a)singleForm);

                        break;
                    case FormKompal3b.kode:
                        DummyMaker.get(getApplicationContext()).addFormKompal3b((FormKompal3b)singleForm);

                        break;
                    case FormKompal3c.kode:
                        DummyMaker.get(getApplicationContext()).addFormKompal3c((FormKompal3c)singleForm);

                        break;
                    case FormKompal3d.kode:
                        DummyMaker.get(getApplicationContext()).addFormKompal3d((FormKompal3d)singleForm);

                        break;
                }
            }

        }
    }

    private class FetchMstDataTask extends AsyncTask<Void,Void,List<SingleMaster>> {


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


        }
    }

    private class FetchMenuCheckingGalpalTask extends AsyncTask<Void,Void,List<MenuCheckingGalpal>> {
        private String mIdKualifikasiSurvey;

        private FetchMenuCheckingGalpalTask(String idKualifikasiSurvey){
            mIdKualifikasiSurvey=idKualifikasiSurvey;
        }

        @Override
        protected List<MenuCheckingGalpal> doInBackground(Void... params) {
            Log.i("a", "Received JSON MenuCheckingGalpal: " + mIdKualifikasiSurvey);
            return new DataFetcher().fetchMenuCheckingGalpal(mIdKualifikasiSurvey);
        }



        @Override
        protected void onPostExecute(List<MenuCheckingGalpal> menuCheckingGalpals) {
            Log.i("a",String.valueOf(menuCheckingGalpals.get(0).getIdKualifikasiSurvey()));
        }
    }

    private class FetchMenuCheckingKompalTask extends AsyncTask<Void,Void,List<MenuCheckingKompal>> {
        private String mIdKualifikasiSurvey;

        private FetchMenuCheckingKompalTask(String idKualifikasiSurvey){
            mIdKualifikasiSurvey=idKualifikasiSurvey;
        }

        @Override
        protected List<MenuCheckingKompal> doInBackground(Void... params) {
            Log.i("a", "Received JSON MenuCheckingKompal: " + mIdKualifikasiSurvey);
            return new DataFetcher().fetchMenuCheckingKompals(mIdKualifikasiSurvey);
        }



        @Override
        protected void onPostExecute(List<MenuCheckingKompal> menuCheckingKompals) {
            Log.i("a",String.valueOf(menuCheckingKompals.get(0).getIdKualifikasiSurvey()));
        }
    }
}
