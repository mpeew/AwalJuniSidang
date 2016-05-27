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
import android.widget.Spinner;
import android.widget.Toast;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mpewpazi.android.awaljunisidang.Form.FormKompal3a;
import com.mpewpazi.android.awaljunisidang.R;
import com.mpewpazi.android.awaljunisidang.dummy.DummyMaker;
import com.mpewpazi.android.awaljunisidang.model.KualifikasiSurvey;
import com.mpewpazi.android.awaljunisidang.model.MenuCheckingKompal;

import java.util.List;
import java.util.UUID;

/**
 * Created by mpewpazi on 5/6/16.
 */
public class FormKompal3aFragment extends SingleFragment implements Validator.ValidationListener {

    private static final String ARG_FORMKOMPAL3a_ID="formkompal3a_id";
    private static final String ARG_FORMKOMPAL3a_KUALIFIKASI_SURVEY_ID="formkompal3a_kualifikasi_id";
    private Validator mValidator;
    private boolean isValidated;

    @NotEmpty
    private EditText mJenisProduksi;
    @NotEmpty
    private EditText mKapasitasProduksiEditText;
    private Spinner mSatuanSpinner;

    private Button mSaveButton;
    private boolean isSaveButtonUnpressed=true;

    private FormKompal3a mFormKompal3a;
    private KualifikasiSurvey mKualifikasiSurvey;
    private MenuCheckingKompal mMenuCheckingKompal;



    public static FormKompal3aFragment newInstance(UUID id, int kualifikasiSurveyId){
        //bundle itu berisi key-value fair seperti intent

        //bundle tidak jauh seperti intent penggunannya
        Bundle args=new Bundle();
        args.putSerializable(ARG_FORMKOMPAL3a_ID, id);
        args.putInt(ARG_FORMKOMPAL3a_KUALIFIKASI_SURVEY_ID, kualifikasiSurveyId);

        FormKompal3aFragment fragment=new FormKompal3aFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int kualifikasiSurveyId=getArguments().getInt(ARG_FORMKOMPAL3a_KUALIFIKASI_SURVEY_ID);
        UUID formKompal3aId=(UUID)getArguments().getSerializable(ARG_FORMKOMPAL3a_ID);

        //----------------------------------------------- ----------------------------------------------- -----------------------------------------------
        mFormKompal3a= DummyMaker.get(getActivity()).getFormKompal3a(formKompal3aId);
        mKualifikasiSurvey=DummyMaker.get(getActivity()).getKualifikasiSurvey(kualifikasiSurveyId);
        mMenuCheckingKompal=DummyMaker.get(getActivity()).getMenuCheckingKompal(kualifikasiSurveyId,mFormKompal3a.getKodeForm());

        mValidator=new Validator(this);
        mValidator.setValidationListener(this);

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_form_kompal3a, container, false);
        if(mKualifikasiSurvey.getStatus()==1||mKualifikasiSurvey.getStatus()==3||mKualifikasiSurvey.getStatus()==4||mMenuCheckingKompal.isVerified()){
            setViewEnabledFalse(rootView);
        }

        mJenisProduksi=(EditText)rootView.findViewById(R.id.kompal3a_jenis_produksi);
        mKapasitasProduksiEditText=(EditText)rootView.findViewById(R.id.kompal3a_kapasitas_produksi);
        mSatuanSpinner=(Spinner)rootView.findViewById(R.id.kompal3a_satuan_spinner);
        mSaveButton=(Button)rootView.findViewById(R.id.kompal3a_btn_save);


        mJenisProduksi.setText(mFormKompal3a.getJenisProduksi());
        mJenisProduksi.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormKompal3a.setJenisProduksi(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mKapasitasProduksiEditText.setText(String.valueOf(mFormKompal3a.getKapasitasProduksi()));
        mKapasitasProduksiEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //mFormKompal3a.setKapasitasProduksi(s.toString());
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
                DummyMaker.get(getActivity()).addFormKompal3a(mFormKompal3a);
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



}
