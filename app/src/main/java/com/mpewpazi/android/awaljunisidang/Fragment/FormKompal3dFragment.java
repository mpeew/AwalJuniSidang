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

import com.mpewpazi.android.awaljunisidang.Form.FormKompal3d;
import com.mpewpazi.android.awaljunisidang.R;

import java.util.UUID;

/**
 * Created by mpewpazi on 5/6/16.
 */
public class FormKompal3dFragment extends Fragment {
    private static final String ARG_FORMKOMPAL3d_ID="formkompal3d_id";
    private static final String ARG_FORMKOMPAL3d_KUALIFIKASI_SURVEY_ID="formkompal3d_kualifikasi_id";

    private EditText mJenisStandarMutuEditText;
    private EditText mKeteranganEditText;

    private Button mDeleteButton;
    private boolean isDeleteButtonUnpressed=true;

    private FormKompal3d mFormKompal3d;



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

        //----------------------------------------------- ----------------------------------------------- -----------------------------------------------
        //mFormGalpal6= DummyMaker.get(getActivity()).getFormGalpal6(formKompal3dId);

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_form_kompal3d, container, false);

        mJenisStandarMutuEditText=(EditText)rootView.findViewById(R.id.kompal3d_jenis_standar_mutu);
        mKeteranganEditText=(EditText)rootView.findViewById(R.id.kompal3d_keterangan);

        mDeleteButton=(Button)rootView.findViewById(R.id.kompal3a_btn_delete);

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



        mDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /* ----------------------------------------------- ----------------------------------------------- -----------------------------------------------
                DummyMaker.get(getActivity()).deleteFormGalpal6(mFormGalpal6);
                isDeleteButtonUnpressed=false;
                getActivity().finish();*/

            }
        });



        return rootView;
    }

    @Override
    public void onPause() {
        super.onPause();
        if(isDeleteButtonUnpressed) {
            // ----------------------------------------------- ----------------------------------------------- -----------------------------------------------
            // DummyMaker.get(getActivity()).addFormGalpal6(mFormGalpal6);
        }
    }
}
