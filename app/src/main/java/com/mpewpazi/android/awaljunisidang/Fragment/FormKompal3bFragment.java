package com.mpewpazi.android.awaljunisidang.Fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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
import com.mpewpazi.android.awaljunisidang.DataPusher;
import com.mpewpazi.android.awaljunisidang.Form.FormKompal3b;
import com.mpewpazi.android.awaljunisidang.R;
import com.mpewpazi.android.awaljunisidang.dummy.DummyMaker;

import java.util.List;
import java.util.UUID;

/**
 * Created by mpewpazi on 5/6/16.
 */
public class FormKompal3bFragment extends Fragment implements Validator.ValidationListener {
    private static final String ARG_FORMKOMPAL3b_ID="formkompal3b_id";
    private static final String ARG_FORMKOMPAL3b_KUALIFIKASI_SURVEY_ID="formkompal3b_kualifikasi_id";

    private Validator mValidator;
    private boolean isValidated;

    private Spinner mjenisProdukSpinner;
    @NotEmpty
    private EditText mJumlahProduksiThn1EditText;
    @NotEmpty
    private EditText mJumlahProduksiThn2EditText;
    @NotEmpty
    private EditText mJumlahProduksiThn3EditText;
    @NotEmpty
    private EditText mJumlahProduksiThn4EditText;
    private Spinner mSatuanSpinner;
    @NotEmpty
    private EditText mNilaiProduksiThn1EditText;
    @NotEmpty
    private EditText mNilaiProduksiThn2EditText;
    @NotEmpty
    private EditText mNilaiProduksiThn3EditText;
    @NotEmpty
    private EditText mNilaiProduksiThn4EditText;
    @NotEmpty
    private EditText mKeteranganEditText;

    private Button mSaveButton;
    private boolean isSaveButtonUnpressed=true;

    private FormKompal3b mFormKompal3b;



    public static FormKompal3bFragment newInstance(UUID id, int kualifikasiSurveyId){
        //bundle itu berisi key-value fair seperti intent

        //bundle tidak jauh seperti intent penggunannya
        Bundle args=new Bundle();
        args.putSerializable(ARG_FORMKOMPAL3b_ID, id);
        args.putInt(ARG_FORMKOMPAL3b_KUALIFIKASI_SURVEY_ID, kualifikasiSurveyId);

        FormKompal3bFragment fragment=new FormKompal3bFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int kualifikasiSurveyId=getArguments().getInt(ARG_FORMKOMPAL3b_KUALIFIKASI_SURVEY_ID);
        UUID formKompal3bId=(UUID)getArguments().getSerializable(ARG_FORMKOMPAL3b_ID);

        //----------------------------------------------- ----------------------------------------------- -----------------------------------------------
        mFormKompal3b= DummyMaker.get(getActivity()).getFormKompal3b(formKompal3bId);

        mValidator=new Validator(this);
        mValidator.setValidationListener(this);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_form_kompal3b, container, false);

        mjenisProdukSpinner=(Spinner)rootView.findViewById(R.id.kompal3b_jenis_produk);
        mJumlahProduksiThn1EditText=(EditText)rootView.findViewById(R.id.kompal3b_jumlah_prod_2011);
        mJumlahProduksiThn2EditText=(EditText)rootView.findViewById(R.id.kompal3b_jumlah_prod_2012);
        mJumlahProduksiThn3EditText=(EditText)rootView.findViewById(R.id.kompal3b_jumlah_prod_2013);
        mJumlahProduksiThn4EditText=(EditText)rootView.findViewById(R.id.kompal3b_jumlah_prod_2014);
        mSatuanSpinner=(Spinner)rootView.findViewById(R.id.kompal3b_satuan);
        mNilaiProduksiThn1EditText=(EditText)rootView.findViewById(R.id.kompal3b_nilai_prod_2011);
        mNilaiProduksiThn2EditText=(EditText)rootView.findViewById(R.id.kompal3b_nilai_prod_2012);
        mNilaiProduksiThn3EditText=(EditText)rootView.findViewById(R.id.kompal3b_nilai_prod_2013);
        mNilaiProduksiThn4EditText=(EditText)rootView.findViewById(R.id.kompal3b_nilai_prod_2014);
        mKeteranganEditText=(EditText)rootView.findViewById(R.id.kompal3b_keterangan);

        mSaveButton=(Button)rootView.findViewById(R.id.kompal3b_btn_save);


        mJumlahProduksiThn1EditText.setText(String.valueOf(mFormKompal3b.getJumlahProdThn1()));
        mJumlahProduksiThn1EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormKompal3b.setJumlahProdThn1(11);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        mJumlahProduksiThn2EditText.setText(String.valueOf(mFormKompal3b.getJumlahProdThn2()));
        mJumlahProduksiThn2EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormKompal3b.setJumlahProdThn2(11);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mJumlahProduksiThn3EditText.setText(String.valueOf(mFormKompal3b.getJumlahProdThn3()));
        mJumlahProduksiThn3EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormKompal3b.setJumlahProdThn3(11);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mJumlahProduksiThn4EditText.setText(String.valueOf(mFormKompal3b.getJumlahProdThn4()));
        mJumlahProduksiThn4EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormKompal3b.setJumlahProdThn4(11);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mNilaiProduksiThn1EditText.setText(String.valueOf(mFormKompal3b.getNilaiProduksiThn1()));
        mNilaiProduksiThn1EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormKompal3b.setNilaiProduksiThn1(11);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mNilaiProduksiThn2EditText.setText(String.valueOf(mFormKompal3b.getNilaiProduksiThn2()));
        mNilaiProduksiThn2EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormKompal3b.setNilaiProduksiThn2(11);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mNilaiProduksiThn3EditText.setText(String.valueOf(mFormKompal3b.getNilaiProduksiThn3()));
        mNilaiProduksiThn3EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormKompal3b.setNilaiProduksiThn3(11);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mNilaiProduksiThn4EditText.setText(String.valueOf(mFormKompal3b.getNilaiProduksiThn4()));
        mNilaiProduksiThn4EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormKompal3b.setNilaiProduksiThn4(11);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mKeteranganEditText.setText(mFormKompal3b.getKeterangan());
        mKeteranganEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormKompal3b.setKeterangan(s.toString());
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
                DummyMaker.get(getActivity()).addFormKompal3b(mFormKompal3b);
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

            new DataPusher().makePostRequestFK3b(mFormKompal3b);
            return null;
        }
    }

}
