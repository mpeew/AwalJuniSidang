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
import com.mpewpazi.android.awaljunisidang.database.FormKompalDBHelper;
import com.mpewpazi.android.awaljunisidang.dummy.DummyMaker;
import com.mpewpazi.android.awaljunisidang.model.KualifikasiSurvey;

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

    private KualifikasiSurvey mKualifikasiSurvey;
    private List<SingleForm> mKompalForms;
    private FormGalpal4 mFormGalpal4;

    private FormKompalDBHelper dbHelper;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mKualifikasiSurvey= DummyMaker.get(getActivity()).getKualifikasiSurvey(DrawerFormActivity.kualifikasiSurveyId);
        mKompalForms= DummyMaker.get(getActivity()).getKompalForms(DrawerFormActivity.kualifikasiSurveyId);
        for(SingleForm singleForm:mKompalForms){
            if(singleForm.getNamaForm().equals(NAMA_FORM)){
                mFormGalpal4=(FormGalpal4)singleForm;
            }
        }

        dbHelper=new FormKompalDBHelper(getActivity());

        if(dbHelper.checkIsDataAlreadyInDBorNot(mFormGalpal4.getTinjauanWilayahMaritimId(), BaseDBHelper.FORM_KOMPAL1_TABLE_NAME)) {
            Cursor cursor = dbHelper.getDataForm(mFormGalpal4.getTinjauanWilayahMaritimId(), BaseDBHelper.FORM_KOMPAL1_TABLE_NAME);

            cursor.moveToNext();
            //mFormGalpal1.setId(cursor.getInt(cursor.getColumnIndex(BaseDBHelper.FORM_GALPAL1_COLUMN_ID)));


            mFormGalpal4.setJarakKedalaman(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_KOMPAL1_COLUMN_JARAK_KEDALAMAN)));
            mFormGalpal4.setAirPelayaran(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_KOMPAL1_COLUMN_AIR_PELAYARAN)));
            mFormGalpal4.setPasangSurut(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_KOMPAL1_COLUMN_PASANG_SURUT)));
            mFormGalpal4.setArus(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_KOMPAL1_COLUMN_ARUS)));
            mFormGalpal4.setGelombang(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_KOMPAL1_COLUMN_GELOMBANG)));
            mFormGalpal4.setPanjangWaterfront(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_KOMPAL1_COLUMN_PANJANG_WATERFRONT)));
            mFormGalpal4.setLuasLahan(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_KOMPAL1_COLUMN_LUAS_LAHAN)));
            mFormGalpal4.setKetersediaanLahan(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_KOMPAL1_COLUMN_KETERSEDIAAN_LAHAN)));
            mFormGalpal4.setLahanProduktif(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_KOMPAL1_COLUMN_LAHAN_PRODUKTIF)));
            mFormGalpal4.setLahanPemukiman(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_KOMPAL1_COLUMN_LAHAN_PEMUKIMAN)));
            mFormGalpal4.setDayaDukung(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_KOMPAL1_COLUMN_DAYA_DUKUNG)));
            mFormGalpal4.setKelandaian(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_KOMPAL1_COLUMN_KELANDAIAAN)));
            mFormGalpal4.setDekatJalan(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_KOMPAL1_COLUMN_DEKAT_JALAN)));
            mFormGalpal4.setKota(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_KOMPAL1_COLUMN_KOTA)));
            mFormGalpal4.setInterkoneksiAngkutan(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_KOMPAL1_COLUMN_INTERKONEKSI_ANGKUTAN)));
            mFormGalpal4.setNilaiEkonomi(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_KOMPAL1_COLUMN_NILAI_EKONOMI)));
            mFormGalpal4.setPerkembanganWilayah(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_KOMPAL1_COLUMN_PERKEMBANGAN_WILAYAH)));
            mFormGalpal4.setRutrw(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_KOMPAL1_COLUMN_RUTWR)));

            cursor.close();


        }

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
        mSubmitButton=(Button)rootView.findViewById(R.id.kompal1_btn_submit);


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

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dbHelper.checkIsDataAlreadyInDBorNot(mFormGalpal4.getTinjauanWilayahMaritimId(),BaseDBHelper.FORM_KOMPAL1_TABLE_NAME)) {
                    dbHelper.updateFormKompal1(mFormGalpal4.getTinjauanWilayahMaritimId(),mFormGalpal4.getJarakKedalaman(),mFormGalpal4.getAirPelayaran(),mFormGalpal4.getPasangSurut(),
                            mFormGalpal4.getArus(),mFormGalpal4.getGelombang(),mFormGalpal4.getPanjangWaterfront(),mFormGalpal4.getLuasLahan(),
                            mFormGalpal4.getKetersediaanLahan(),mFormGalpal4.getLahanProduktif(),mFormGalpal4.getLahanPemukiman(),mFormGalpal4.getDayaDukung(),
                            mFormGalpal4.getKelandaian(),mFormGalpal4.getDekatJalan(),mFormGalpal4.getKota(),mFormGalpal4.getInterkoneksiAngkutan(),mFormGalpal4.getNilaiEkonomi(),
                            mFormGalpal4.getPerkembanganWilayah(),mFormGalpal4.getRutrw());
                }else{
                    dbHelper.insertFormKompal1(mFormGalpal4.getTinjauanWilayahMaritimId(), mFormGalpal4.getJarakKedalaman(), mFormGalpal4.getAirPelayaran(), mFormGalpal4.getPasangSurut(),
                            mFormGalpal4.getArus(), mFormGalpal4.getGelombang(), mFormGalpal4.getPanjangWaterfront(), mFormGalpal4.getLuasLahan(),
                            mFormGalpal4.getKetersediaanLahan(), mFormGalpal4.getLahanProduktif(), mFormGalpal4.getLahanPemukiman(), mFormGalpal4.getDayaDukung(),
                            mFormGalpal4.getKelandaian(), mFormGalpal4.getDekatJalan(), mFormGalpal4.getKota(), mFormGalpal4.getInterkoneksiAngkutan(), mFormGalpal4.getNilaiEkonomi(),
                            mFormGalpal4.getPerkembanganWilayah(),mFormGalpal4.getRutrw());
                }

                Toast.makeText(getContext(), "Berhasil ", Toast.LENGTH_SHORT).show();
            }
        });


        return rootView;
    }
}
