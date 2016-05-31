package com.mpewpazi.android.awaljunisidang.Fragment;

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
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal11;
import com.mpewpazi.android.awaljunisidang.R;
import com.mpewpazi.android.awaljunisidang.dummy.DummyMaker;
import com.mpewpazi.android.awaljunisidang.model.KualifikasiSurvey;
import com.mpewpazi.android.awaljunisidang.model.MenuCheckingGalpal;

import java.util.List;
import java.util.UUID;

/**
 * Created by mpewpazi on 5/27/16.
 */
public class FormGalpal11Fragment extends SingleFragment implements Validator.ValidationListener {
    private static final String ARG_FORMGALPAL11_ID="formgalpal11_id";
    private static final String ARG_FORMGALPAL11_KUALIFIKASI_SURVEY_ID="formgalpal11_kualifikasi_id";

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


    private List<FormGalpal11> mFormGalpal11s;
    private FormGalpal11 mFormGalpal11;

    private KualifikasiSurvey mKualifikasiSurvey;
    private MenuCheckingGalpal mMenuCheckingGalpal;




    public static FormGalpal11Fragment newInstance(UUID id, int kualifikasiSurveyId){
        //bundle itu berisi key-value fair seperti intent

        //bundle tidak jauh seperti intent penggunannya
        Bundle args=new Bundle();
        args.putSerializable(ARG_FORMGALPAL11_ID, id);
        args.putInt(ARG_FORMGALPAL11_KUALIFIKASI_SURVEY_ID, kualifikasiSurveyId);

        FormGalpal11Fragment fragment=new FormGalpal11Fragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //sementara
        int kualifikasiSurveyId=getArguments().getInt(ARG_FORMGALPAL11_KUALIFIKASI_SURVEY_ID);
        UUID formGalpal11Id=(UUID)getArguments().getSerializable(ARG_FORMGALPAL11_ID);

        mKualifikasiSurvey= DummyMaker.get(getActivity()).getKualifikasiSurvey(kualifikasiSurveyId);
        mFormGalpal11= DummyMaker.get(getActivity()).getFormGalpal11(formGalpal11Id);
        mMenuCheckingGalpal=DummyMaker.get(getActivity()).getMenuCheckingGalpal(kualifikasiSurveyId,mFormGalpal11.getKodeForm());


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
        FormGalpal11 formGalpal11=new FormGalpal11();
        mJudulTextView.setText(formGalpal11.getNamaForm());

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


        mJenisMesinEditText.setText(mFormGalpal11.getJenisMesin());
        mJenisMesinEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal11.setJenisMesin(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mTahunPembuatanEditText.setText(String.valueOf(mFormGalpal11.getTahunPembuatan()));
        mTahunPembuatanEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal11.setTahunPembuatan(convertToInt(s.toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mMerekEditText.setText(mFormGalpal11.getMerek());
        mMerekEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal11.setMerek(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mKapasitasTerpasangEditText.setText(String.valueOf(mFormGalpal11.getKapasitasTerpasang()));
        mKapasitasTerpasangEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal11.setKapasitasTerpasang(convertToInt(s.toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mDimensiEditText.setText(mFormGalpal11.getDimensi());
        mDimensiEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal11.setDimensi(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mJumlahEditText.setText(String.valueOf(mFormGalpal11.getJumlah()));
        mJumlahEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal11.setJumlah(convertToInt(s.toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mKondisiEditText.setText(mFormGalpal11.getKondisi());
        mKondisiEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal11.setKondisi(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mLokasiEditText.setText(mFormGalpal11.getLokasi());
        mLokasiEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal11.setLokasi(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mStatusEditText.setText(mFormGalpal11.getStatus());
        mStatusEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal11.setStatus(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mKapasitasTerpakaiEditText.setText(String.valueOf(mFormGalpal11.getKapasitasTerpakai()));
        mKapasitasTerpakaiEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal11.setKapasitasTerpakai(convertToInt(s.toString()));
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
                DummyMaker.get(getActivity()).addFormGalpal11(mFormGalpal11);
                getActivity().finish();

            }
        });



        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setViewNote(mKualifikasiSurvey,mFormGalpal11);
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
