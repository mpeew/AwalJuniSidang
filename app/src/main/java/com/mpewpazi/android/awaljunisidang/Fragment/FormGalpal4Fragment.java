package com.mpewpazi.android.awaljunisidang.Fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.mpewpazi.android.awaljunisidang.DrawerFormActivity;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal4;
import com.mpewpazi.android.awaljunisidang.Form.SingleForm;
import com.mpewpazi.android.awaljunisidang.R;
import com.mpewpazi.android.awaljunisidang.dummy.DummyMaker;
import com.mpewpazi.android.awaljunisidang.model.KualifikasiSurvey;

import java.util.List;

/**
 * Created by mpewpazi on 3/27/16.
 */
public class FormGalpal4Fragment extends SingleFragment {
    private final String NAMA_FORM="Tinjauan Wilayah Maritim";

    private Spinner mJarakKedalamanSpinner;
    private Spinner mAirPelayaranSpinner;
    private Spinner mPasangSurutSpinner;
    private Spinner mArusSpinner;
    private Spinner mGelombangSpinner;
    private EditText mPanjangWaterfrontEditText;
    private EditText mLuasLahanEditText;
    private Spinner mKetersediaanLahanSpinner;
    private Spinner mLahanProduktifSpinner;
    private Spinner mLahanPemukimanSpinner;
    private Spinner mDayaDukungSpinner;
    private Spinner mKelandaianSpinner;
    private Spinner mDekatJalanSpinner;
    private Spinner mKotaSpinner;
    private Spinner mInterkoneksiAngkutanSpinner;
    private Spinner mNilaiEkonomiSpinner;
    private Spinner mPerkembanganWilayahSpinner;
    private Spinner mRutrwSpinner;
    private Button mSubmitButton;

    private DummyMaker mDummyMaker;
    private KualifikasiSurvey mKualifikasiSurvey;
    private List<SingleForm> mGalpalForms;
    private FormGalpal4 mFormGalpal4;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mDummyMaker=DummyMaker.get(getActivity());
        mKualifikasiSurvey= mDummyMaker.getKualifikasiSurvey(DrawerFormActivity.kualifikasiSurveyId);
        mFormGalpal4=mDummyMaker.getFormGalpal4(DrawerFormActivity.kualifikasiSurveyId);
        mGalpalForms=mDummyMaker.getGalpalForms();



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {





        View rootView = inflater.inflate(R.layout.fragment_form_galpal4, container, false);

        mJarakKedalamanSpinner=(Spinner)rootView.findViewById(R.id.kompal1_jarak_kedalaman_spinner);
        mAirPelayaranSpinner=(Spinner)rootView.findViewById(R.id.kompal1_air_pelayaran_spinner);
        mPasangSurutSpinner=(Spinner)rootView.findViewById(R.id.kompal1_pasang_surut_spinner);
        mArusSpinner=(Spinner)rootView.findViewById(R.id.kompal1_gelombang_spinner);
        mGelombangSpinner=(Spinner)rootView.findViewById(R.id.kompal1_gelombang_spinner);
        mPanjangWaterfrontEditText=(EditText)rootView.findViewById(R.id.kompal1_panjang_waterfront);
        mLuasLahanEditText=(EditText)rootView.findViewById(R.id.kompal1_luas_lahan);
        mKetersediaanLahanSpinner=(Spinner)rootView.findViewById(R.id.kompal1_ketersediaan_lahan_spinner);
        mLahanProduktifSpinner=(Spinner)rootView.findViewById(R.id.kompal1_lahan_produktif_spinner);
        mLahanPemukimanSpinner=(Spinner)rootView.findViewById(R.id.kompal1_lahan_pemukiman_spinner);
        mDayaDukungSpinner=(Spinner)rootView.findViewById(R.id.kompal1_daya_dukung_spinner);
        mKelandaianSpinner=(Spinner)rootView.findViewById(R.id.kompal1_kelandaian_spinner);
        mDekatJalanSpinner=(Spinner)rootView.findViewById(R.id.kompal1_dekat_jalan_spinner);
        mKotaSpinner=(Spinner)rootView.findViewById(R.id.kompal1_kota_spinner);
        mInterkoneksiAngkutanSpinner=(Spinner)rootView.findViewById(R.id.kompal1_interkoneksi_angkutan_spinner);
        mNilaiEkonomiSpinner=(Spinner)rootView.findViewById(R.id.kompal1_nilai_ekonomi_spinner);
        mPerkembanganWilayahSpinner=(Spinner)rootView.findViewById(R.id.kompal1_perkembangan_wilayah_spinner);
        mRutrwSpinner=(Spinner)rootView.findViewById(R.id.kompal1_rutrw_spinner);
        mSubmitButton=(Button)rootView.findViewById(R.id.galpal4_btn_submit);


        mPanjangWaterfrontEditText.setText(mFormGalpal4.getPanjangWaterfront());
        mPanjangWaterfrontEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal4.setPanjangWaterfront(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mLuasLahanEditText.setText(mFormGalpal4.getLuasLahan());
        mLuasLahanEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal4.setLuasLahan(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        if(mFormGalpal4.isSend()){
            mSubmitButton.setText(R.string.belum_lengkap);
            mSubmitButton.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
        }
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mFormGalpal4.isSend()){
                    mFormGalpal4.setSend(true);
                    mKualifikasiSurvey.setProgress(mKualifikasiSurvey.getProgress()+100/mGalpalForms.size());
                    mSubmitButton.setText(R.string.belum_lengkap);
                    mSubmitButton.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
                }else{
                    mFormGalpal4.setSend(false);
                    mKualifikasiSurvey.setProgress(mKualifikasiSurvey.getProgress()-100/mGalpalForms.size());
                    mSubmitButton.setText(R.string.lengkap);
                    mSubmitButton.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
                }

                mDummyMaker.addFormGalpal4(mFormGalpal4);
                mDummyMaker.addKualifikasiSurvey(mKualifikasiSurvey);
                mCustomClickListener.clickListener();

            }
        });


        return rootView;
    }

    @Override
    public void onPause() {
        super.onPause();
        mDummyMaker.addFormGalpal4(mFormGalpal4);

    }
}
