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
import android.widget.ImageView;
import android.widget.Toast;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mpewpazi.android.awaljunisidang.formModel.FormGalpalFoto;
import com.mpewpazi.android.awaljunisidang.R;
import com.mpewpazi.android.awaljunisidang.database.DummyMaker;
import com.mpewpazi.android.awaljunisidang.modelExtras.KualifikasiSurvey;
import com.mpewpazi.android.awaljunisidang.modelExtras.MenuCheckingGalpal;

import java.util.List;
import java.util.UUID;

/**
 * Created by mpewpazi on 6/2/16.
 */
public class FormGalpalFotoFragment extends SingleFragment implements Validator.ValidationListener {
    private static final String ARG_FORMGALPALFOTO_ID="formgalpal_foto_id";
    private static final String ARG_FORMGALPALFOTO_KUALIFIKASI_SURVEY_ID="formgalpal_foto_kualifikasi_id";

    private Validator mValidator;
    private boolean isValidated;

    @NotEmpty
    private EditText mNamaFotoEditText;
    private ImageView mImageView;
    private Button mSaveButton;

    private List<FormGalpalFoto> mFormGalpalFotos;
    private FormGalpalFoto mFormGalpalFoto;

    private KualifikasiSurvey mKualifikasiSurvey;
    private MenuCheckingGalpal mMenuCheckingGalpal;


    public static FormGalpalFotoFragment newInstance(UUID id, int kualifikasiSurveyId){
        //bundle itu berisi key-value fair seperti intent

        //bundle tidak jauh seperti intent penggunannya
        Bundle args=new Bundle();
        args.putSerializable(ARG_FORMGALPALFOTO_ID, id);
        args.putInt(ARG_FORMGALPALFOTO_KUALIFIKASI_SURVEY_ID, kualifikasiSurveyId);

        FormGalpalFotoFragment fragment=new FormGalpalFotoFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        int kualifikasiSurveyId=getArguments().getInt(ARG_FORMGALPALFOTO_KUALIFIKASI_SURVEY_ID);
        UUID formGalpalFotoId=(UUID)getArguments().getSerializable(ARG_FORMGALPALFOTO_ID);

        mKualifikasiSurvey= DummyMaker.get(getActivity()).getKualifikasiSurvey(kualifikasiSurveyId);
        mFormGalpalFoto= DummyMaker.get(getActivity()).getFormGalpalFoto(formGalpalFotoId);
        mMenuCheckingGalpal=DummyMaker.get(getActivity()).getMenuCheckingGalpal(kualifikasiSurveyId,mFormGalpalFoto.getKodeForm());

        mValidator=new Validator(this);
        mValidator.setValidationListener(this);

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_form_galpal_foto, container, false);
        if(mKualifikasiSurvey.getStatus()==1||mKualifikasiSurvey.getStatus()==3||mKualifikasiSurvey.getStatus()==4||mMenuCheckingGalpal.isVerified()){
            setViewEnabledFalse(rootView);
        }


        mNamaFotoEditText=(EditText)rootView.findViewById(R.id.galpal_foto_nama_foto);
        mImageView=(ImageView)rootView.findViewById(R.id.galpal_foto_image_view);
        mSaveButton=(Button)rootView.findViewById(R.id.galpal_foto_btn_save);

        mNamaFotoEditText.setText(String.valueOf(mFormGalpalFoto.getNamaFoto()));
        mNamaFotoEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpalFoto.setNamaFoto(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        updatePhotoView(mFormGalpalFoto,mImageView);





        mSaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mValidator.validate();
                if(!isValidated){
                    return;
                }
                DummyMaker.get(getActivity()).addFormGalpalFoto(mFormGalpalFoto);
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
