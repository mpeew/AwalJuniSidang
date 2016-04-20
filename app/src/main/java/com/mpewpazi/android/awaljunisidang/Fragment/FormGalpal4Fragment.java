package com.mpewpazi.android.awaljunisidang.Fragment;

import android.database.Cursor;
import android.os.Bundle;
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

import com.mpewpazi.android.awaljunisidang.DrawerFormActivity;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal4;
import com.mpewpazi.android.awaljunisidang.Form.SingleForm;
import com.mpewpazi.android.awaljunisidang.R;
import com.mpewpazi.android.awaljunisidang.database.BaseDBHelper;
import com.mpewpazi.android.awaljunisidang.database.FormGalpalDBHelper;


import java.util.List;

/**
 * Created by mpewpazi on 3/27/16.
 */
public class FormGalpal4Fragment extends Fragment {
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

    private Survey mSurvey;
    private List<SingleForm> mForms;
    private FormKompal1 mFormKompal1;

    private FormKompalDBHelper dbHelper;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSurvey=SurveyAssignation.get(getActivity()).getSurvey(DrawerFormActivity.surveyId);
        mFormKompal1=mSurvey.getFormKompal1();

        dbHelper=new FormKompalDBHelper(getActivity());

        if(dbHelper.checkIsDataAlreadyInDBorNot(mFormKompal1.getId(), BaseDBHelper.FORM_KOMPAL1_TABLE_NAME)) {
            Cursor cursor = dbHelper.getDataForm(mFormKompal1.getId(), BaseDBHelper.FORM_KOMPAL1_TABLE_NAME);

            cursor.moveToNext();
            //mFormGalpal1.setId(cursor.getInt(cursor.getColumnIndex(BaseDBHelper.FORM_GALPAL1_COLUMN_ID)));


            mFormKompal1.setJarakKedalaman(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_KOMPAL1_COLUMN_JARAK_KEDALAMAN)));
            mFormKompal1.setAirPelayaran(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_KOMPAL1_COLUMN_AIR_PELAYARAN)));
            mFormKompal1.setPasangSurut(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_KOMPAL1_COLUMN_PASANG_SURUT)));
            mFormKompal1.setArus(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_KOMPAL1_COLUMN_ARUS)));
            mFormKompal1.setGelombang(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_KOMPAL1_COLUMN_GELOMBANG)));
            mFormKompal1.setPanjangWaterfront(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_KOMPAL1_COLUMN_PANJANG_WATERFRONT)));
            mFormKompal1.setLuasLahan(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_KOMPAL1_COLUMN_LUAS_LAHAN)));
            mFormKompal1.setKetersediaanLahan(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_KOMPAL1_COLUMN_KETERSEDIAAN_LAHAN)));
            mFormKompal1.setLahanProduktif(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_KOMPAL1_COLUMN_LAHAN_PRODUKTIF)));
            mFormKompal1.setLahanPemukiman(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_KOMPAL1_COLUMN_LAHAN_PEMUKIMAN)));
            mFormKompal1.setDayaDukung(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_KOMPAL1_COLUMN_DAYA_DUKUNG)));
            mFormKompal1.setKelandaian(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_KOMPAL1_COLUMN_KELANDAIAAN)));
            mFormKompal1.setDekatJalan(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_KOMPAL1_COLUMN_DEKAT_JALAN)));
            mFormKompal1.setKota(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_KOMPAL1_COLUMN_KOTA)));
            mFormKompal1.setInterkoneksiAngkutan(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_KOMPAL1_COLUMN_INTERKONEKSI_ANGKUTAN)));
            mFormKompal1.setNilaiEkonomi(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_KOMPAL1_COLUMN_NILAI_EKONOMI)));
            mFormKompal1.setPerkembanganWilayah(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_KOMPAL1_COLUMN_PERKEMBANGAN_WILAYAH)));
            mFormKompal1.setRutrw(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_KOMPAL1_COLUMN_RUTWR)));

            cursor.close();


        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {





        View rootView = inflater.inflate(R.layout.fragment_form_kompal1, container, false);

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
        mSubmitButton=(Button)rootView.findViewById(R.id.kompal1_btn_submit);


        mPanjangWaterfrontEditText.setText(mFormKompal1.getPanjangWaterfront());
        mPanjangWaterfrontEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormKompal1.setPanjangWaterfront(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mLuasLahanEditText.setText(mFormKompal1.getLuasLahan());
        mLuasLahanEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormKompal1.setLuasLahan(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dbHelper.checkIsDataAlreadyInDBorNot(mFormKompal1.getId(),BaseDBHelper.FORM_KOMPAL1_TABLE_NAME)) {
                    dbHelper.updateFormKompal1(mFormKompal1.getId(),mFormKompal1.getJarakKedalaman(),mFormKompal1.getAirPelayaran(),mFormKompal1.getPasangSurut(),
                            mFormKompal1.getArus(),mFormKompal1.getGelombang(),mFormKompal1.getPanjangWaterfront(),mFormKompal1.getLuasLahan(),
                            mFormKompal1.getKetersediaanLahan(),mFormKompal1.getLahanProduktif(),mFormKompal1.getLahanPemukiman(),mFormKompal1.getDayaDukung(),
                            mFormKompal1.getKelandaian(),mFormKompal1.getDekatJalan(),mFormKompal1.getKota(),mFormKompal1.getInterkoneksiAngkutan(),mFormKompal1.getNilaiEkonomi(),
                            mFormKompal1.getPerkembanganWilayah(),mFormKompal1.getRutrw());
                }else{
                    dbHelper.insertFormKompal1(mFormKompal1.getId(), mFormKompal1.getJarakKedalaman(), mFormKompal1.getAirPelayaran(), mFormKompal1.getPasangSurut(),
                            mFormKompal1.getArus(), mFormKompal1.getGelombang(), mFormKompal1.getPanjangWaterfront(), mFormKompal1.getLuasLahan(),
                            mFormKompal1.getKetersediaanLahan(), mFormKompal1.getLahanProduktif(), mFormKompal1.getLahanPemukiman(), mFormKompal1.getDayaDukung(),
                            mFormKompal1.getKelandaian(), mFormKompal1.getDekatJalan(), mFormKompal1.getKota(), mFormKompal1.getInterkoneksiAngkutan(), mFormKompal1.getNilaiEkonomi(),
                            mFormKompal1.getPerkembanganWilayah(),mFormKompal1.getRutrw());
                }

                Toast.makeText(getContext(), "Berhasil ", Toast.LENGTH_SHORT).show();
            }
        });


        return rootView;
    }
}
