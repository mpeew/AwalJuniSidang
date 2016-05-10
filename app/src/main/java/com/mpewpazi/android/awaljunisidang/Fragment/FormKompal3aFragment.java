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

import com.mpewpazi.android.awaljunisidang.Form.FormKompal3a;
import com.mpewpazi.android.awaljunisidang.R;
import com.mpewpazi.android.awaljunisidang.dummy.DummyMaker;

import java.util.UUID;

/**
 * Created by mpewpazi on 5/6/16.
 */
public class FormKompal3aFragment extends Fragment {

    private static final String ARG_FORMKOMPAL3a_ID="formkompal3a_id";
    private static final String ARG_FORMKOMPAL3a_KUALIFIKASI_SURVEY_ID="formkompal3a_kualifikasi_id";

    private EditText mJenisProduksi;
    private EditText mKapasitasProduksiEditText;
    private Spinner mSatuanSpinner;

    private Button mDeleteButton;
    private boolean isDeleteButtonUnpressed=true;

    private FormKompal3a mFormKompal3a;



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

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_form_kompal3a, container, false);

        mJenisProduksi=(EditText)rootView.findViewById(R.id.kompal3a_jenis_produksi);
        mKapasitasProduksiEditText=(EditText)rootView.findViewById(R.id.kompal3a_kapasitas_produksi);
        mSatuanSpinner=(Spinner)rootView.findViewById(R.id.kompal3a_satuan_spinner);
        mDeleteButton=(Button)rootView.findViewById(R.id.kompal3a_btn_delete);


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

        mKapasitasProduksiEditText.setText(mFormKompal3a.getKapasitasProduksi());
        mKapasitasProduksiEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormKompal3a.setKapasitasProduksi(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });



        mDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // ----------------------------------------------- ----------------------------------------------- -----------------------------------------------
                DummyMaker.get(getActivity()).deleteFormKompal3a(mFormKompal3a);
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
            DummyMaker.get(getActivity()).addFormKompal3a(mFormKompal3a);
        }
    }

}
