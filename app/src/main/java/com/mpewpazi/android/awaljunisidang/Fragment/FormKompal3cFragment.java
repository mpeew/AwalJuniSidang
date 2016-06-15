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
import android.widget.Spinner;
import android.widget.Toast;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mpewpazi.android.awaljunisidang.formModel.FormKompal3c;
import com.mpewpazi.android.awaljunisidang.R;
import com.mpewpazi.android.awaljunisidang.database.DummyMaker;
import com.mpewpazi.android.awaljunisidang.modelExtras.KualifikasiSurvey;
import com.mpewpazi.android.awaljunisidang.modelExtras.MenuCheckingKompal;

import java.util.List;
import java.util.UUID;

/**
 * Created by mpewpazi on 5/6/16.
 */
public class FormKompal3cFragment extends SingleFragment implements Validator.ValidationListener {

    private static final String ARG_FORMKOMPAL3c_ID="formkompal3c_id";
    private static final String ARG_FORMKOMPAL3c_KUALIFIKASI_SURVEY_ID="formkompal3c_kualifikasi_id";

    private Validator mValidator;
    private boolean isValidated;

    private Spinner mNamaProdukSpinner;
    private Spinner mSistemProduksiSpinner;
    @NotEmpty
    private EditText mJumlahProduksithn1EditText;
    @NotEmpty
    private EditText mJumlahProduksithn2EditText;
    @NotEmpty
    private EditText mJumlahProduksithn3EditText;
    @NotEmpty
    private EditText mJumlahProduksithn4EditText;

    private Button mSaveButton;
    private boolean isSaveButtonUnpressed=true;

    private FormKompal3c mFormKompal3c;
    private KualifikasiSurvey mKualifikasiSurvey;
    private MenuCheckingKompal mMenuCheckingKompal;



    public static FormKompal3cFragment newInstance(UUID id, int kualifikasiSurveyId){
        //bundle itu berisi key-value fair seperti intent

        //bundle tidak jauh seperti intent penggunannya
        Bundle args=new Bundle();
        args.putSerializable(ARG_FORMKOMPAL3c_ID, id);
        args.putInt(ARG_FORMKOMPAL3c_KUALIFIKASI_SURVEY_ID, kualifikasiSurveyId);

        FormKompal3cFragment fragment=new FormKompal3cFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int kualifikasiSurveyId=getArguments().getInt(ARG_FORMKOMPAL3c_KUALIFIKASI_SURVEY_ID);
        UUID formKompal3cId=(UUID)getArguments().getSerializable(ARG_FORMKOMPAL3c_ID);


        //----------------------------------------------- ----------------------------------------------- -----------------------------------------------
        mFormKompal3c= DummyMaker.get(getActivity()).getFormKompal3c(formKompal3cId);
        mKualifikasiSurvey=DummyMaker.get(getActivity()).getKualifikasiSurvey(kualifikasiSurveyId);
        mMenuCheckingKompal=DummyMaker.get(getActivity()).getMenuCheckingKompal(kualifikasiSurveyId,mFormKompal3c.getKodeForm());

        mValidator=new Validator(this);
        mValidator.setValidationListener(this);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_form_kompal3c, container, false);
        if(mKualifikasiSurvey.getStatus()==1||mKualifikasiSurvey.getStatus()==3||mKualifikasiSurvey.getStatus()==4||mMenuCheckingKompal.isVerified()){
            setViewEnabledFalse(rootView);
        }

        mNamaProdukSpinner=(Spinner)rootView.findViewById(R.id.kompal3c_nama_produk);
        mSistemProduksiSpinner=(Spinner)rootView.findViewById(R.id.kompal3c_sistem_produksi);
        mJumlahProduksithn1EditText=(EditText)rootView .findViewById(R.id.kompal3c_jumlah_prod_2011);
        mJumlahProduksithn2EditText=(EditText)rootView .findViewById(R.id.kompal3c_jumlah_prod_2012);
        mJumlahProduksithn3EditText=(EditText)rootView .findViewById(R.id.kompal3c_jumlah_prod_2013);
        mJumlahProduksithn4EditText=(EditText)rootView .findViewById(R.id.kompal3c_jumlah_prod_2014);

        mSaveButton=(Button)rootView.findViewById(R.id.kompal3c_btn_save);

        mJumlahProduksithn1EditText.setText(String.valueOf(mFormKompal3c.getJumlahProduksiThn1()));
        mJumlahProduksithn1EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormKompal3c.setJumlahProduksiThn1(convertToInt(s.toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mJumlahProduksithn2EditText.setText(String.valueOf(mFormKompal3c.getJumlahProduksiThn2()));
        mJumlahProduksithn2EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormKompal3c.setJumlahProduksiThn2(convertToInt(s.toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mJumlahProduksithn3EditText.setText(String.valueOf(mFormKompal3c.getJumlahProduksiThn3()));
        mJumlahProduksithn3EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormKompal3c.setJumlahProduksiThn3(convertToInt(s.toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mJumlahProduksithn4EditText.setText(String.valueOf(mFormKompal3c.getJumlahProduksiThn4()));
        mJumlahProduksithn4EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormKompal3c.setJumlahProduksiThn4(convertToInt(s.toString()));
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
                DummyMaker.get(getActivity()).addFormKompal3c(mFormKompal3c);

                getActivity().finish();

            }
        });



        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setViewNote(mKualifikasiSurvey,mFormKompal3c);
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
