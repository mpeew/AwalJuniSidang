package com.mpewpazi.android.awaljunisidang.Fragment;

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

import com.mpewpazi.android.awaljunisidang.DrawerFormActivity;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal6;
import com.mpewpazi.android.awaljunisidang.Form.SingleForm;
import com.mpewpazi.android.awaljunisidang.R;
import com.mpewpazi.android.awaljunisidang.dummy.DummyMaker;
import com.mpewpazi.android.awaljunisidang.model.KualifikasiSurvey;

import java.util.List;

/**
 * Created by mpewpazi on 4/18/16.
 */
public class FormGalpal6Fragment extends Fragment {
    private final static String NAMA_FORM="Peralatan Ruang Kerja Luar Ruang Cranes";

    private EditText mJenisMesinEditText;
    private EditText mTahunPembuatanEditText;
    private EditText mMerekEditText;
    private EditText mKapasitasTerpasangEditText;
    private EditText mDimensiEditText;
    private EditText mJumlahEditText;
    private EditText mKondisiEditText;
    private EditText mLokasiEditText;
    private EditText mStatusEditText;
    private EditText mKapasitasTerpakaiEditText;

    private Button mSubmitButton;
    private FormGalpal6 mFormGalpal6;

    private KualifikasiSurvey mKualifikasiSurvey;
    private List<SingleForm> mGalpalForms;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //sementara

        mKualifikasiSurvey= DummyMaker.get(getActivity()).getKualifikasiSurvey(DrawerFormActivity.kualifikasiSurveyId);
        mGalpalForms= DummyMaker.get(getActivity()).getGalpalForms(DrawerFormActivity.kualifikasiSurveyId);
        for(SingleForm singleForm:mGalpalForms){
            if(singleForm.getNamaForm().equals(NAMA_FORM)){
                mFormGalpal6=(FormGalpal6)singleForm;
            }
        }

        DummyMaker.get(getActivity()).addGalpalForm(mFormGalpal6);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_form_galpal6, container, false);

        mJenisMesinEditText=(EditText)rootView.findViewById(R.id.galpal6_jenis_mesin);
        mTahunPembuatanEditText=(EditText)rootView.findViewById(R.id.galpal6_tahun_pembuatan);
        mMerekEditText=(EditText)rootView.findViewById(R.id.galpal6_merek);
        mKapasitasTerpasangEditText=(EditText)rootView.findViewById(R.id.galpal6_dimensi);
        mKapasitasTerpakaiEditText=(EditText)rootView.findViewById(R.id.galpal6_kapasitas_terpakai);
        mDimensiEditText=(EditText)rootView.findViewById(R.id.galpal6_dimensi);
        mJumlahEditText=(EditText)rootView.findViewById(R.id.galpal6_jumlah);
        mKondisiEditText=(EditText)rootView.findViewById(R.id.galpal6_kondisi);
        mLokasiEditText=(EditText)rootView.findViewById(R.id.galpal6_lokasi);
        mStatusEditText=(EditText)rootView.findViewById(R.id.galpal6_status);

        mSubmitButton=(Button)rootView.findViewById(R.id.galpal6_btn_submit);


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

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



        return rootView;
    }
}
