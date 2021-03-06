package com.mpewpazi.android.awaljunisidang.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mpewpazi.android.awaljunisidang.formModel.FormGalpal9;
import com.mpewpazi.android.awaljunisidang.R;
import com.mpewpazi.android.awaljunisidang.database.DummyMaker;
import com.mpewpazi.android.awaljunisidang.modelExtras.KualifikasiSurvey;
import com.mpewpazi.android.awaljunisidang.modelExtras.MenuCheckingGalpal;

import java.util.List;
import java.util.UUID;

/**
 * Created by mpewpazi on 5/27/16.
 */
public class FormGalpal9Fragment extends SingleFragment implements Validator.ValidationListener {
    private static final String ARG_FORMGALPAL9_ID="formgalpal9_id";
    private static final String ARG_FORMGALPAL9_KUALIFIKASI_SURVEY_ID="formgalpal9_kualifikasi_id";

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


    private List<FormGalpal9> mFormGalpal9s;
    private FormGalpal9 mFormGalpal9;

    private KualifikasiSurvey mKualifikasiSurvey;
    private MenuCheckingGalpal mMenuCheckingGalpal;




    public static FormGalpal9Fragment newInstance(UUID id, int kualifikasiSurveyId){
        //bundle itu berisi key-value fair seperti intent

        //bundle tidak jauh seperti intent penggunannya
        Bundle args=new Bundle();
        args.putSerializable(ARG_FORMGALPAL9_ID, id);
        args.putInt(ARG_FORMGALPAL9_KUALIFIKASI_SURVEY_ID, kualifikasiSurveyId);

        FormGalpal9Fragment fragment=new FormGalpal9Fragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //sementara
        int kualifikasiSurveyId=getArguments().getInt(ARG_FORMGALPAL9_KUALIFIKASI_SURVEY_ID);
        UUID formGalpal9Id=(UUID)getArguments().getSerializable(ARG_FORMGALPAL9_ID);

        mKualifikasiSurvey= DummyMaker.get(getActivity()).getKualifikasiSurvey(kualifikasiSurveyId);
        mFormGalpal9= DummyMaker.get(getActivity()).getFormGalpal9(formGalpal9Id);
        mMenuCheckingGalpal=DummyMaker.get(getActivity()).getMenuCheckingGalpal(kualifikasiSurveyId,mFormGalpal9.getKodeForm());


        mValidator=new Validator(this);
        mValidator.setValidationListener(this);

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_form_galpal_peralatan, container, false);
        if(mKualifikasiSurvey.getStatus()==1||mKualifikasiSurvey.getStatus()==3||mKualifikasiSurvey.getStatus()==4||mMenuCheckingGalpal.isVerified()){
            setViewEnabledFalse(rootView);
        }
        TextView mJudulTextView=(TextView)rootView.findViewById(R.id.galpal_peralatan_judul);
        FormGalpal9 formGalpal9=new FormGalpal9();
        mJudulTextView.setText(formGalpal9.getNamaForm());

        mJenisMesinEditText=(EditText)rootView.findViewById(R.id.galpal_peralatan_jenis_mesin);
        mTahunPembuatanEditText=(EditText)rootView.findViewById(R.id.galpal_peralatan_tahun_pembuatan);
        mMerekEditText=(EditText)rootView.findViewById(R.id.galpal_peralatan_merek);
        mKapasitasTerpasangEditText=(EditText)rootView.findViewById(R.id.galpal_peralatan_kapasitas_terpasang);
        mKapasitasTerpakaiEditText=(EditText)rootView.findViewById(R.id.galpal_peralatan_kapasitas_terpakai);
        mDimensiEditText=(EditText)rootView.findViewById(R.id.galpal_peralatan_dimensi);
        mJumlahEditText=(EditText)rootView.findViewById(R.id.galpal_peralatan_jumlah);
        mKondisiEditText=(EditText)rootView.findViewById(R.id.galpal_peralatan_kondisi);
        mLokasiEditText=(EditText)rootView.findViewById(R.id.galpal_peralatan_lokasi);
        mStatusEditText=(EditText)rootView.findViewById(R.id.galpal_peralatan_status);


        mSaveButton=(Button)rootView.findViewById(R.id.galpal_peralatan_btn_save);


        mJenisMesinEditText.setText(mFormGalpal9.getJenisMesin());
        mJenisMesinEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal9.setJenisMesin(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mTahunPembuatanEditText.setText(String.valueOf(mFormGalpal9.getTahunPembuatan()));
        mTahunPembuatanEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal9.setTahunPembuatan(convertToInt(s.toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mMerekEditText.setText(mFormGalpal9.getMerek());
        mMerekEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal9.setMerek(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mKapasitasTerpasangEditText.setText(String.valueOf(mFormGalpal9.getKapasitasTerpasang()));
        mKapasitasTerpasangEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal9.setKapasitasTerpasang(convertToInt(s.toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mDimensiEditText.setText(mFormGalpal9.getDimensi());
        mDimensiEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal9.setDimensi(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mJumlahEditText.setText(String.valueOf(mFormGalpal9.getJumlah()));
        mJumlahEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal9.setJumlah(convertToInt(s.toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mKondisiEditText.setText(mFormGalpal9.getKondisi());
        mKondisiEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal9.setKondisi(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mLokasiEditText.setText(mFormGalpal9.getLokasi());
        mLokasiEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal9.setLokasi(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mStatusEditText.setText(mFormGalpal9.getStatus());
        mStatusEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal9.setStatus(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mKapasitasTerpakaiEditText.setText(String.valueOf(mFormGalpal9.getKapasitasTerpakai()));
        mKapasitasTerpakaiEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal9.setKapasitasTerpakai(convertToInt(s.toString()));
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
                DummyMaker.get(getActivity()).addFormGalpal9(mFormGalpal9);
                getActivity().finish();

            }
        });



        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setViewNote(mKualifikasiSurvey,mFormGalpal9);
    }


    private int convertToInt(String stoString){
        if(stoString.length()>0){
            return Integer.parseInt(stoString);
        }
        return 0;
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
}
