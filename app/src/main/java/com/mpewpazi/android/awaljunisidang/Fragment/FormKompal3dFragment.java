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
import android.widget.Toast;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mpewpazi.android.awaljunisidang.formModel.FormKompal3d;
import com.mpewpazi.android.awaljunisidang.R;
import com.mpewpazi.android.awaljunisidang.database.DummyMaker;
import com.mpewpazi.android.awaljunisidang.modelExtras.KualifikasiSurvey;
import com.mpewpazi.android.awaljunisidang.modelExtras.MenuCheckingKompal;

import java.util.List;
import java.util.UUID;

/**
 * Created by mpewpazi on 5/6/16.
 */
public class FormKompal3dFragment extends SingleFragment implements Validator.ValidationListener {
    private static final String ARG_FORMKOMPAL3d_ID="formkompal3d_id";
    private static final String ARG_FORMKOMPAL3d_KUALIFIKASI_SURVEY_ID="formkompal3d_kualifikasi_id";

    private Validator mValidator;
    private boolean isValidated;

    @NotEmpty
    private EditText mJenisStandarMutuEditText;
    @NotEmpty
    private EditText mKeteranganEditText;

    private Button mSaveButton;
    private boolean isSaveButtonUnpressed=true;

    private FormKompal3d mFormKompal3d;
    private KualifikasiSurvey mKualifikasiSurvey;
    private MenuCheckingKompal mMenuCheckingKompal;


    public static FormKompal3dFragment newInstance(UUID id, int kualifikasiSurveyId){
        //bundle itu berisi key-value fair seperti intent

        //bundle tidak jauh seperti intent penggunannya
        Bundle args=new Bundle();
        args.putSerializable(ARG_FORMKOMPAL3d_ID, id);
        args.putInt(ARG_FORMKOMPAL3d_KUALIFIKASI_SURVEY_ID, kualifikasiSurveyId);

        FormKompal3dFragment fragment=new FormKompal3dFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int kualifikasiSurveyId=getArguments().getInt(ARG_FORMKOMPAL3d_KUALIFIKASI_SURVEY_ID);
        UUID formKompal3dId=(UUID)getArguments().getSerializable(ARG_FORMKOMPAL3d_ID);

        mFormKompal3d= DummyMaker.get(getActivity()).getFormKompal3d(formKompal3dId);
        mKualifikasiSurvey=DummyMaker.get(getActivity()).getKualifikasiSurvey(kualifikasiSurveyId);
        mMenuCheckingKompal=DummyMaker.get(getActivity()).getMenuCheckingKompal(kualifikasiSurveyId,mFormKompal3d.getKodeForm());

        mValidator=new Validator(this);
        mValidator.setValidationListener(this);

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_form_kompal3d, container, false);
        if(mKualifikasiSurvey.getStatus()==1||mKualifikasiSurvey.getStatus()==3||mKualifikasiSurvey.getStatus()==4||mMenuCheckingKompal.isVerified()){
            setViewEnabledFalse(rootView);
        }
        mJenisStandarMutuEditText=(EditText)rootView.findViewById(R.id.kompal3d_jenis_standar_mutu);
        mKeteranganEditText=(EditText)rootView.findViewById(R.id.kompal3d_keterangan);

        mSaveButton=(Button)rootView.findViewById(R.id.kompal3d_btn_save);

        mJenisStandarMutuEditText.setText(mFormKompal3d.getJenisStandarMutu());
        mJenisStandarMutuEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormKompal3d.setJenisStandarMutu(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mKeteranganEditText.setText(mFormKompal3d.getKeterangan());
        mKeteranganEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormKompal3d.setKeterangan(s.toString());
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
                DummyMaker.get(getActivity()).addFormKompal3d(mFormKompal3d);
                getActivity().finish();

            }
        });



        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setViewNote(mKualifikasiSurvey,mFormKompal3d);
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
