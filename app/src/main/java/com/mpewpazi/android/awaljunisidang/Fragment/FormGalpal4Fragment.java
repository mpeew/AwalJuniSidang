package com.mpewpazi.android.awaljunisidang.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mpewpazi.android.awaljunisidang.tools.ConnectionDetector;
import com.mpewpazi.android.awaljunisidang.tools.DataPusher;
import com.mpewpazi.android.awaljunisidang.activity.DrawerFormActivity;
import com.mpewpazi.android.awaljunisidang.formModel.FormGalpal4;
import com.mpewpazi.android.awaljunisidang.formModel.SingleForm;
import com.mpewpazi.android.awaljunisidang.tools.GalKomSharedPreference;
import com.mpewpazi.android.awaljunisidang.service.PushGalpalService;
import com.mpewpazi.android.awaljunisidang.R;
import com.mpewpazi.android.awaljunisidang.adapter.SpinnerAdapter;
import com.mpewpazi.android.awaljunisidang.database.DummyMaker;
import com.mpewpazi.android.awaljunisidang.masterDataModel.MstAirPelayaran;
import com.mpewpazi.android.awaljunisidang.masterDataModel.MstArus;
import com.mpewpazi.android.awaljunisidang.masterDataModel.MstGelombang;
import com.mpewpazi.android.awaljunisidang.masterDataModel.MstJarakKedalaman;
import com.mpewpazi.android.awaljunisidang.modelExtras.KualifikasiSurvey;
import com.mpewpazi.android.awaljunisidang.modelExtras.MenuCheckingGalpal;
import com.mpewpazi.android.awaljunisidang.modelExtras.SingleMenuChecking;

import java.util.List;

/**
 * Created by mpewpazi on 3/27/16.
 */
public class FormGalpal4Fragment extends SingleFragment implements Validator.ValidationListener {
    private final String NAMA_FORM="Tinjauan Wilayah Maritim";

    private Validator mValidator;
    private boolean isValidated;

    private Spinner mJarakKedalamanSpinner;
    private SpinnerAdapter mJarakKedalamanAdapter;
    private List<MstJarakKedalaman> mMstJarakKedalamans;

    private Spinner mAirPelayaranSpinner;
    private SpinnerAdapter mAirPelayaranAdapter;
    private List<MstAirPelayaran> mMstAirPelayarans;

    private Spinner mPasangSurutSpinner;

    private Spinner mArusSpinner;
    private SpinnerAdapter mArusAdapter;
    private List<MstArus> mMstAruss;

    private Spinner mGelombangSpinner;
    private SpinnerAdapter mGelombangAdapter;
    private List<MstGelombang> mMstGelombangs;

    @NotEmpty
    private EditText mPanjangWaterfrontEditText;

    @NotEmpty
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
    private MenuCheckingGalpal mMenuCheckingGalpal;




    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext=getActivity();
        mDummyMaker=DummyMaker.get(getActivity());
        mKualifikasiSurvey= mDummyMaker.getKualifikasiSurvey(DrawerFormActivity.kualifikasiSurveyId);
        mFormGalpal4=mDummyMaker.getFormGalpal4(DrawerFormActivity.kualifikasiSurveyId);
        mGalpalForms=mDummyMaker.getGalpalForms();
        mMenuCheckingGalpal=mDummyMaker.getMenuCheckingGalpal(DrawerFormActivity.kualifikasiSurveyId,FormGalpal4.kode);

        mMstAirPelayarans=mDummyMaker.getMstAirPelayarans();
        mMstAruss=mDummyMaker.getMstAruss();
        mMstGelombangs=mDummyMaker.getMstGelombangs();
        mMstJarakKedalamans=mDummyMaker.getMstJarakKedalamans();

        if(mFormGalpal4==null) {
            mFormGalpal4 = new FormGalpal4();
            mFormGalpal4.setKualifikasiSurveyId(DrawerFormActivity.kualifikasiSurveyId);
        }


        mValidator=new Validator(this);
        mValidator.setValidationListener(this);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {





        View rootView = inflater.inflate(R.layout.fragment_form_galpal4, container, false);
        if(mKualifikasiSurvey.getStatus()==1||mKualifikasiSurvey.getStatus()==3||mKualifikasiSurvey.getStatus()==4||mMenuCheckingGalpal.isVerified()){
            setViewEnabledFalse(rootView);
        }

        mJarakKedalamanSpinner=(Spinner)rootView.findViewById(R.id.galpal4_jarak_kedalaman_spinner);
        mAirPelayaranSpinner=(Spinner)rootView.findViewById(R.id.galpal4_air_pelayaran_spinner);
        mPasangSurutSpinner=(Spinner)rootView.findViewById(R.id.galpal4_pasang_surut_spinner);
        mArusSpinner=(Spinner)rootView.findViewById(R.id.galpal4_arus_spinner);
        mGelombangSpinner=(Spinner)rootView.findViewById(R.id.galpal4_gelombang_spinner);
        mPanjangWaterfrontEditText=(EditText)rootView.findViewById(R.id.galpal4_panjang_waterfront);
        mLuasLahanEditText=(EditText)rootView.findViewById(R.id.galpal4_luas_lahan);
        mKetersediaanLahanSpinner=(Spinner)rootView.findViewById(R.id.galpal4_ketersediaan_lahan_spinner);
        mLahanProduktifSpinner=(Spinner)rootView.findViewById(R.id.galpal4_lahan_produktif_spinner);
        mLahanPemukimanSpinner=(Spinner)rootView.findViewById(R.id.galpal4_lahan_pemukiman_spinner);
        mDayaDukungSpinner=(Spinner)rootView.findViewById(R.id.galpal4_daya_dukung_spinner);
        mKelandaianSpinner=(Spinner)rootView.findViewById(R.id.galpal4_kelandaian_spinner);
        mDekatJalanSpinner=(Spinner)rootView.findViewById(R.id.galpal4_dekat_jalan_spinner);
        mKotaSpinner=(Spinner)rootView.findViewById(R.id.galpal4_kota_spinner);
        mInterkoneksiAngkutanSpinner=(Spinner)rootView.findViewById(R.id.galpal4_interkoneksi_angkutan_spinner);
        mNilaiEkonomiSpinner=(Spinner)rootView.findViewById(R.id.galpal4_nilai_ekonomi_spinner);
        mPerkembanganWilayahSpinner=(Spinner)rootView.findViewById(R.id.galpal4_perkembangan_wilayah_spinner);
        mRutrwSpinner=(Spinner)rootView.findViewById(R.id.galpal4_rutrw_spinner);
        mSubmitButton=(Button)rootView.findViewById(R.id.galpal4_btn_submit);

        mJarakKedalamanAdapter=new SpinnerAdapter(getActivity(),mMstJarakKedalamans);
        mJarakKedalamanSpinner.setAdapter(mJarakKedalamanAdapter);
        mJarakKedalamanSpinner.setSelection(mJarakKedalamanAdapter.getIndex(mFormGalpal4.getJarakKedalaman()));
        mJarakKedalamanSpinner.setOnItemSelectedListener(myListener);

        mAirPelayaranAdapter=new SpinnerAdapter(getActivity(),mMstAirPelayarans);
        mAirPelayaranSpinner.setAdapter(mAirPelayaranAdapter);
        mAirPelayaranSpinner.setSelection(mAirPelayaranAdapter.getIndex(mFormGalpal4.getAirPelayaran()));
        mAirPelayaranSpinner.setOnItemSelectedListener(myListener);

        mArusAdapter=new SpinnerAdapter(getActivity(),mMstAruss);
        mArusSpinner.setAdapter(mArusAdapter);
        mArusSpinner.setSelection(mArusAdapter.getIndex(mFormGalpal4.getArus()));
        mArusSpinner.setOnItemSelectedListener(myListener);

        mGelombangAdapter=new SpinnerAdapter(getActivity(),mMstGelombangs);
        mGelombangSpinner.setAdapter(mGelombangAdapter);
        mGelombangSpinner.setSelection(mGelombangAdapter.getIndex(mFormGalpal4.getGelombang()));
        mGelombangSpinner.setOnItemSelectedListener(myListener);

        mKetersediaanLahanSpinner.setSelection(SpinnerAdapter.getIndex(mKetersediaanLahanSpinner,mFormGalpal4.getKetersediaanLahan()));
        mKetersediaanLahanSpinner.setOnItemSelectedListener(myListener);

        mLahanProduktifSpinner.setSelection(SpinnerAdapter.getIndex(mLahanProduktifSpinner,mFormGalpal4.getLahanProduktif()));
        mLahanProduktifSpinner.setOnItemSelectedListener(myListener);

        mLahanPemukimanSpinner.setSelection(SpinnerAdapter.getIndex(mLahanPemukimanSpinner,mFormGalpal4.getLahanPemukiman()));
        mLahanPemukimanSpinner.setOnItemSelectedListener(myListener);

        mPasangSurutSpinner.setSelection(SpinnerAdapter.getIndex(mPasangSurutSpinner,mFormGalpal4.getPasangSurutDaratan()));
        mPasangSurutSpinner.setOnItemSelectedListener(myListener);

        mDayaDukungSpinner.setSelection(SpinnerAdapter.getIndex(mDayaDukungSpinner,mFormGalpal4.getDayaDukung()));
        mDayaDukungSpinner.setOnItemSelectedListener(myListener);

        mKelandaianSpinner.setSelection(SpinnerAdapter.getIndex(mKelandaianSpinner,mFormGalpal4.getKelandaian()));
        mKelandaianSpinner.setOnItemSelectedListener(myListener);

        mDekatJalanSpinner.setSelection(SpinnerAdapter.getIndex(mDekatJalanSpinner,mFormGalpal4.getDekatJalan()));
        mDekatJalanSpinner.setOnItemSelectedListener(myListener);

        mKotaSpinner.setSelection(SpinnerAdapter.getIndex(mKotaSpinner,mFormGalpal4.getKota()));
        mKotaSpinner.setOnItemSelectedListener(myListener);

        mInterkoneksiAngkutanSpinner.setSelection(SpinnerAdapter.getIndex(mInterkoneksiAngkutanSpinner,mFormGalpal4.getInterkoneksiAngkutan()));
        mInterkoneksiAngkutanSpinner.setOnItemSelectedListener(myListener);

        mNilaiEkonomiSpinner.setSelection(SpinnerAdapter.getIndex(mNilaiEkonomiSpinner,mFormGalpal4.getNilaiEkonomi()));
        mNilaiEkonomiSpinner.setOnItemSelectedListener(myListener);

        mPerkembanganWilayahSpinner.setSelection(SpinnerAdapter.getIndex(mPerkembanganWilayahSpinner,mFormGalpal4.getPerkembanganWilayah()));
        mPerkembanganWilayahSpinner.setOnItemSelectedListener(myListener);

        mRutrwSpinner.setSelection(SpinnerAdapter.getIndex(mRutrwSpinner,mFormGalpal4.getRutrw()));
        mRutrwSpinner.setOnItemSelectedListener(myListener);


        mPanjangWaterfrontEditText.setText(String.valueOf(mFormGalpal4.getPanjangWaterfront()));
        mPanjangWaterfrontEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().length()>0) {
                    mFormGalpal4.setPanjangWaterfront(Integer.parseInt(s.toString()));
                }
                mMenuCheckingGalpal.setFill(true);
                mDummyMaker.addMenuCheckingGalpal(mMenuCheckingGalpal);
                mCustomClickListener.clickListener();
            }
        });

        mLuasLahanEditText.setText(String.valueOf(mFormGalpal4.getLuasLahan()));
        mLuasLahanEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().length()>0) {
                    mFormGalpal4.setLuasLahan(Integer.parseInt(s.toString()));
                }
                mMenuCheckingGalpal.setFill(true);
                mDummyMaker.addMenuCheckingGalpal(mMenuCheckingGalpal);
                mCustomClickListener.clickListener();
            }
        });

        if(mMenuCheckingGalpal.isComplete()){
            mSubmitButton.setText(R.string.belum_lengkap);
            mSubmitButton.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
        }
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(!mMenuCheckingGalpal.isComplete()){
                    mValidator.validate();
                    if(!isValidated){
                        return;
                    }
                    mMenuCheckingGalpal.setComplete(true);
                    mKualifikasiSurvey.setProgress(mKualifikasiSurvey.getProgress()+100/mGalpalForms.size());
                    mSubmitButton.setText(R.string.belum_lengkap);
                    mSubmitButton.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
                }else{
                    mMenuCheckingGalpal.setComplete(false);
                    mKualifikasiSurvey.setProgress(mKualifikasiSurvey.getProgress()-100/mGalpalForms.size());
                    mSubmitButton.setText(R.string.lengkap);
                    mSubmitButton.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
                }

                mDummyMaker.addMenuCheckingGalpal(mMenuCheckingGalpal);
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
        if(mKualifikasiSurvey.getStatus()==0||mKualifikasiSurvey.getStatus()==2 && !mMenuCheckingGalpal.isVerified()) {
            mDummyMaker.addFormGalpal4(mFormGalpal4);
            if(!new ConnectionDetector(getActivity()).isConnectingToInternet()){
                PushGalpalService.setServiceAlarm(getActivity(),true);
                Log.i("NotificationService","FG4");
            }else {
                new PushTask(mFormGalpal4, mMenuCheckingGalpal).execute();
            }
        }
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
        isValidated =false;
    }


    private class PushTask extends AsyncTask<Void,Void,Void> {
        private FormGalpal4 mFormGalpal4;
        private SingleMenuChecking mSingleMenuChecking;

        public PushTask(FormGalpal4 formGalpal4, SingleMenuChecking singleMenuChecking){
            mFormGalpal4=formGalpal4;
            mSingleMenuChecking=singleMenuChecking;
        }

        @Override
        protected Void doInBackground(Void... params) {
            new DataPusher(GalKomSharedPreference.getUserId(mContext),GalKomSharedPreference.getPassword(mContext)).makePostRequestFG4(mFormGalpal4);
            new DataPusher(GalKomSharedPreference.getUserId(mContext),GalKomSharedPreference.getPassword(mContext)).makePostRequestMenuCheckingGalpal((MenuCheckingGalpal) mSingleMenuChecking);
            return null;
        }
    }

    AdapterView.OnItemSelectedListener myListener=new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            switch (parent.getId()) {
                case R.id.galpal4_ketersediaan_lahan_spinner:
                    mFormGalpal4.setKetersediaanLahan(parent.getItemAtPosition(position).toString());
                    break;
                case R.id.galpal4_lahan_produktif_spinner:
                    mFormGalpal4.setLahanProduktif(parent.getItemAtPosition(position).toString());
                    break;
                case R.id.galpal4_lahan_pemukiman_spinner:
                    mFormGalpal4.setLahanPemukiman(parent.getItemAtPosition(position).toString());
                    break;
                case R.id.galpal4_pasang_surut_spinner:
                    mFormGalpal4.setPasangSurutDaratan(parent.getItemAtPosition(position).toString());
                    break;
                case R.id.galpal4_daya_dukung_spinner:
                    mFormGalpal4.setDayaDukung(parent.getItemAtPosition(position).toString());
                    break;
                case R.id.galpal4_kelandaian_spinner:
                    mFormGalpal4.setKelandaian(parent.getItemAtPosition(position).toString());
                    break;
                case R.id.galpal4_dekat_jalan_spinner:
                    mFormGalpal4.setDekatJalan(parent.getItemAtPosition(position).toString());
                    break;
                case R.id.galpal4_kota_spinner:
                    mFormGalpal4.setKota(parent.getItemAtPosition(position).toString());
                    break;
                case R.id.galpal4_interkoneksi_angkutan_spinner:
                    mFormGalpal4.setInterkoneksiAngkutan(parent.getItemAtPosition(position).toString());
                    break;
                case R.id.galpal4_nilai_ekonomi_spinner:
                    mFormGalpal4.setNilaiEkonomi(parent.getItemAtPosition(position).toString());
                    break;
                case R.id.galpal4_perkembangan_wilayah_spinner:
                    mFormGalpal4.setPerkembanganWilayah(parent.getItemAtPosition(position).toString());
                    break;
                case R.id.galpal4_rutrw_spinner:
                    mFormGalpal4.setRutrw(parent.getItemAtPosition(position).toString());
                    break;
                case R.id.galpal4_jarak_kedalaman_spinner:
                    MstJarakKedalaman mst= (MstJarakKedalaman) mJarakKedalamanAdapter.getItem(position);
                    mFormGalpal4.setJarakKedalaman(mst.getId());
                    break;
                case R.id.galpal4_air_pelayaran_spinner:
                    MstAirPelayaran mst1= (MstAirPelayaran) mAirPelayaranAdapter.getItem(position);
                    mFormGalpal4.setAirPelayaran(mst1.getId());
                    break;
                case R.id.galpal4_arus_spinner:
                    MstArus mst2= (MstArus) mArusAdapter.getItem(position);
                    mFormGalpal4.setArus(mst2.getId());
                    break;
                case R.id.galpal4_gelombang_spinner:
                    MstGelombang mstGelombang= (MstGelombang) mGelombangAdapter.getItem(position);
                    mFormGalpal4.setGelombang(mstGelombang.getId());
                    break;

            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };
}
