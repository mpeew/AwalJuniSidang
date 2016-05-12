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
import android.widget.Spinner;

import com.mpewpazi.android.awaljunisidang.Form.FormKompal3c;
import com.mpewpazi.android.awaljunisidang.R;
import com.mpewpazi.android.awaljunisidang.dummy.DummyMaker;

import java.util.UUID;

/**
 * Created by mpewpazi on 5/6/16.
 */
public class FormKompal3cFragment extends Fragment {

    private static final String ARG_FORMKOMPAL3c_ID="formkompal3c_id";
    private static final String ARG_FORMKOMPAL3c_KUALIFIKASI_SURVEY_ID="formkompal3c_kualifikasi_id";

    private Spinner mNamaProdukSpinner;
    private Spinner mSistemProduksiSpinner;
    private EditText mJumlahProduksithn1EditText;
    private EditText mJumlahProduksithn2EditText;
    private EditText mJumlahProduksithn3EditText;
    private EditText mJumlahProduksithn4EditText;

    private Button mDeleteButton;
    private boolean isDeleteButtonUnpressed=true;

    private FormKompal3c mFormKompal3c;



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

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_form_kompal3c, container, false);

        mNamaProdukSpinner=(Spinner)rootView.findViewById(R.id.kompal3c_nama_produk);
        mSistemProduksiSpinner=(Spinner)rootView.findViewById(R.id.kompal3c_sistem_produksi);
        mJumlahProduksithn1EditText=(EditText)rootView .findViewById(R.id.kompal3c_jumlah_prod_2011);
        mJumlahProduksithn2EditText=(EditText)rootView .findViewById(R.id.kompal3c_jumlah_prod_2012);
        mJumlahProduksithn3EditText=(EditText)rootView .findViewById(R.id.kompal3c_jumlah_prod_2013);
        mJumlahProduksithn4EditText=(EditText)rootView .findViewById(R.id.kompal3c_jumlah_prod_2014);

        mDeleteButton=(Button)rootView.findViewById(R.id.kompal3a_btn_delete);

        mJumlahProduksithn1EditText.setText(String.valueOf(mFormKompal3c.getJumlahProduksiThn1()));
        mJumlahProduksithn1EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormKompal3c.setJumlahProduksiThn1(11);
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
                mFormKompal3c.setJumlahProduksiThn2(11);
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
                mFormKompal3c.setJumlahProduksiThn3(11);
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
                mFormKompal3c.setJumlahProduksiThn4(11);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });





        mDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DummyMaker.get(getActivity()).deleteFormKompal3c(mFormKompal3c);
                isDeleteButtonUnpressed=false;
                getActivity().finish();

            }
        });



        return rootView;
    }

    @Override
    public void onPause() {
        super.onPause();
        if(isDeleteButtonUnpressed) {
            // ----------------------------------------------- ----------------------------------------------- -----------------------------------------------
            DummyMaker.get(getActivity()).addFormKompal3c(mFormKompal3c);
        }
    }
}