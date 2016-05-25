package com.mpewpazi.android.awaljunisidang.Fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mpewpazi.android.awaljunisidang.DataPusher;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal6;
import com.mpewpazi.android.awaljunisidang.R;
import com.mpewpazi.android.awaljunisidang.dummy.DummyMaker;
import com.mpewpazi.android.awaljunisidang.model.KualifikasiSurvey;

import java.util.List;
import java.util.UUID;

/**
 * Created by mpewpazi on 4/18/16.
 */
public class FormGalpal6Fragment extends SingleFragment implements Validator.ValidationListener {
    private final static String NAMA_FORM="Peralatan Ruang Kerja Luar Ruang Cranes";
    private static final String ARG_FORMGALPAL6_ID="formgalpal6_id";
    private static final String ARG_FORMGALPAL6_KUALIFIKASI_SURVEY_ID="formgalpal6_kualifikasi_id";

    private Validator mValidator;
    private boolean isValidated;

    @NotEmpty
    private EditText mJenisMesinEditText;

    @NotEmpty
    private EditText mTahunPembuatanEditText;
    @NotEmpty
    private EditText mMerekEditText;
    @NotEmpty
    private EditText mKapasitasTerpasangEditText;
    @NotEmpty
    private EditText mDimensiEditText;
    @NotEmpty
    private EditText mJumlahEditText;
    @NotEmpty
    private EditText mKondisiEditText;
    @NotEmpty
    private EditText mLokasiEditText;
    @NotEmpty
    private EditText mStatusEditText;
    @NotEmpty
    private EditText mKapasitasTerpakaiEditText;


    private Button mSaveButton;


    private List<FormGalpal6> mFormGalpal6s;
    private FormGalpal6 mFormGalpal6;

    private KualifikasiSurvey mKualifikasiSurvey;




    public static FormGalpal6Fragment newInstance(UUID id, int kualifikasiSurveyId){
        //bundle itu berisi key-value fair seperti intent

        //bundle tidak jauh seperti intent penggunannya
        Bundle args=new Bundle();
        args.putSerializable(ARG_FORMGALPAL6_ID, id);
        args.putInt(ARG_FORMGALPAL6_KUALIFIKASI_SURVEY_ID, kualifikasiSurveyId);

        FormGalpal6Fragment fragment=new FormGalpal6Fragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //sementara
        int kualifikasiSurveyId=getArguments().getInt(ARG_FORMGALPAL6_KUALIFIKASI_SURVEY_ID);
        UUID formGalpal6Id=(UUID)getArguments().getSerializable(ARG_FORMGALPAL6_ID);

        mKualifikasiSurvey=DummyMaker.get(getActivity()).getKualifikasiSurvey(kualifikasiSurveyId);
        mFormGalpal6= DummyMaker.get(getActivity()).getFormGalpal6(formGalpal6Id);

        mValidator=new Validator(this);
        mValidator.setValidationListener(this);

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_form_galpal6, container, false);
        if(mKualifikasiSurvey.getStatus()==1||mKualifikasiSurvey.getStatus()==3||mKualifikasiSurvey.getStatus()==4){
            setViewEnabledFalse(rootView);
        }

        mJenisMesinEditText=(EditText)rootView.findViewById(R.id.galpal6_jenis_mesin);
        mTahunPembuatanEditText=(EditText)rootView.findViewById(R.id.galpal6_tahun_pembuatan);
        mMerekEditText=(EditText)rootView.findViewById(R.id.galpal6_merek);
        mKapasitasTerpasangEditText=(EditText)rootView.findViewById(R.id.galpal6_kapasitas_terpasang);
        mKapasitasTerpakaiEditText=(EditText)rootView.findViewById(R.id.galpal6_kapasitas_terpakai);
        mDimensiEditText=(EditText)rootView.findViewById(R.id.galpal6_dimensi);
        mJumlahEditText=(EditText)rootView.findViewById(R.id.galpal6_jumlah);
        mKondisiEditText=(EditText)rootView.findViewById(R.id.galpal6_kondisi);
        mLokasiEditText=(EditText)rootView.findViewById(R.id.galpal6_lokasi);
        mStatusEditText=(EditText)rootView.findViewById(R.id.galpal6_status);


        mSaveButton=(Button)rootView.findViewById(R.id.galpal6_btn_save);


        mJenisMesinEditText.setText(mFormGalpal6.getJenisMesin());
        mJenisMesinEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal6.setJenisMesin(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mTahunPembuatanEditText.setText(String.valueOf(mFormGalpal6.getTahunPembuatan()));
        mTahunPembuatanEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal6.setTahunPembuatan(11);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mMerekEditText.setText(mFormGalpal6.getMerek());
        mMerekEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal6.setMerek(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mKapasitasTerpasangEditText.setText(String.valueOf(mFormGalpal6.getKapasitasTerpasang()));
        mKapasitasTerpasangEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal6.setKapasitasTerpasang(11);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mDimensiEditText.setText(mFormGalpal6.getDimensi());
        mDimensiEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal6.setDimensi(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mJumlahEditText.setText(String.valueOf(mFormGalpal6.getJumlah()));
        mJumlahEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal6.setJumlah(11);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mKondisiEditText.setText(mFormGalpal6.getKondisi());
        mKondisiEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal6.setKondisi(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mLokasiEditText.setText(mFormGalpal6.getLokasi());
        mLokasiEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal6.setLokasi(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mStatusEditText.setText(mFormGalpal6.getStatus());
        mStatusEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal6.setStatus(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mKapasitasTerpakaiEditText.setText(String.valueOf(mFormGalpal6.getKapasitasTerpakai()));
        mKapasitasTerpakaiEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal6.setKapasitasTerpakai(11);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValidator.validate();
                if(!isValidated){
                    return;
                }
                DummyMaker.get(getActivity()).addFormGalpal6(mFormGalpal6);
                new PushTask().execute();
                getActivity().finish();

            }
        });



        return rootView;
    }




    @Override
    public void onValidationSucceeded() {
        isValidated=true;
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        for (ValidationError error : errors) {
            View view = error.getView();
            String message = error.getCollatedErrorMessage(getActivity());

            // Display error messages ;)
            if (view instanceof EditText) {
                EditText editText=((EditText) view);
                editText.setError(message);
            } else {
                Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
            }
        }
        isValidated=false;
    }

    private class PushTask extends AsyncTask<Void,Void,Void> {


        @Override
        protected Void doInBackground(Void... params) {

            new DataPusher().makePostRequestFG6(mFormGalpal6);
            return null;
        }
    }
}
