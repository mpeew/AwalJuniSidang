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
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mpewpazi.android.awaljunisidang.R;
import com.mpewpazi.android.awaljunisidang.activity.DrawerFormActivity;
import com.mpewpazi.android.awaljunisidang.adapter.SpinnerAdapter;
import com.mpewpazi.android.awaljunisidang.database.DummyMaker;
import com.mpewpazi.android.awaljunisidang.formModel.FormGalpal3;
import com.mpewpazi.android.awaljunisidang.formModel.SingleForm;
import com.mpewpazi.android.awaljunisidang.masterDataModel.MstKabupaten;
import com.mpewpazi.android.awaljunisidang.masterDataModel.MstPropinsi;
import com.mpewpazi.android.awaljunisidang.modelExtras.KualifikasiSurvey;
import com.mpewpazi.android.awaljunisidang.modelExtras.MenuCheckingGalpal;
import com.mpewpazi.android.awaljunisidang.modelExtras.SingleMenuChecking;
import com.mpewpazi.android.awaljunisidang.service.PushGalpalService;
import com.mpewpazi.android.awaljunisidang.tools.ConnectionDetector;
import com.mpewpazi.android.awaljunisidang.tools.DataPusher;
import com.mpewpazi.android.awaljunisidang.tools.GalKomSharedPreference;

import java.util.List;

/**
 * Created by mpewpazi on 3/27/16.
 */
public class FormGalpal3Fragment extends SingleFragment implements Validator.ValidationListener {

    private static final int REQUEST_SELECT_FILE=1;
    private static final int REQUEST_PHOTO=2;

    private Validator mValidator;
    private boolean isValidated;

    private String mNamaPerusahaan;
    @NotEmpty
    private EditText mNamaGalanganEditText;
    private EditText mNamaPerusahaanEditText;
    @NotEmpty
    private EditText mNomorTeleponEditText;
    @NotEmpty
    private EditText mNomorDock;
    @NotEmpty
    private EditText mFaxEditText;
    @NotEmpty
    private EditText mAlamatEditText;
    @NotEmpty
    private EditText mKelurahanEditText;
    @NotEmpty
    private EditText mKecamatanEditText;
    @NotEmpty
    private EditText mKodePosEditText;
    @NotEmpty
    private EditText mLongitudeEditText;
    @NotEmpty
    private EditText mLatitudeEditText;
    private Spinner mKategoriGalanganSpinner;
    private Spinner mPropinsiSpinner;
    private Spinner mKabupatenSpinner;
    @NotEmpty
    private EditText mContactPersonEditText;
    @NotEmpty
    private EditText mNomorCpEditText;
    @NotEmpty
    private EditText mJabatanEditText;
    @Email
    private EditText mEmailEditText;
    @NotEmpty
    private EditText mCpNamaEditText;
    @NotEmpty
    private EditText mCpNoEditText;
    @NotEmpty
    private EditText mCpJabatanEditText;
    @Email
    private EditText mCpEmailEditText;
    private Button mSubmitButton;


    private List<SingleForm> mGalpalForms;
    private FormGalpal3 mFormGalpal3;


    private DummyMaker mDummyMaker;


    private KualifikasiSurvey mKualifikasiSurvey;
    private MenuCheckingGalpal mMenuCheckingGalpal;

    private List<MstKabupaten> mMstKabupatens;
    private List<MstPropinsi> mMstPropinsis;
    private SpinnerAdapter mPropinsiSpinnerAdapter;
    private SpinnerAdapter mKabupatenSpinnerAdapter;





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext=getActivity();

        mDummyMaker= DummyMaker.get(getActivity());
        mKualifikasiSurvey= DummyMaker.get(getActivity()).getKualifikasiSurvey(DrawerFormActivity.kualifikasiSurveyId);
        mFormGalpal3=DummyMaker.get(getActivity()).getFormGalpal3(DrawerFormActivity.kualifikasiSurveyId);
        mGalpalForms=DummyMaker.get(getActivity()).getGalpalForms();
        mMstPropinsis=DummyMaker.get(getActivity()).getMstPropinsis();

        mNamaPerusahaan=mDummyMaker.getPerusahaan(mKualifikasiSurvey.getPerusahaanId()).getNamaPerusahaan();
        mMenuCheckingGalpal=mDummyMaker.getMenuCheckingGalpal(DrawerFormActivity.kualifikasiSurveyId,FormGalpal3.kode);


        if(mFormGalpal3==null) {
            mFormGalpal3 = new FormGalpal3();
            mFormGalpal3.setKualifikasiSurveyId(DrawerFormActivity.kualifikasiSurveyId);
        }



        mValidator=new Validator(this);
        mValidator.setValidationListener(this);

    }







    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_form_galpal3, container, false);
        if(mKualifikasiSurvey.getStatus()==1||mKualifikasiSurvey.getStatus()==3||mKualifikasiSurvey.getStatus()==4||mMenuCheckingGalpal.isVerified()){
            setViewEnabledFalse(rootView);
        }

        mNamaPerusahaanEditText=(EditText)rootView.findViewById(R.id.galpal3_nama_perusahaan3);
        mNamaGalanganEditText=(EditText)rootView.findViewById(R.id.galpal3_nama_galangan3);
        mNomorTeleponEditText=(EditText)rootView.findViewById(R.id.galpal3_nomor_telepon);
        mFaxEditText=(EditText)rootView.findViewById(R.id.galpal3_fax);
        mAlamatEditText=(EditText)rootView.findViewById(R.id.galpal3_alamat);
        mKelurahanEditText=(EditText)rootView.findViewById(R.id.galpal3_kelurahan);
        mKecamatanEditText=(EditText)rootView.findViewById(R.id.galpal3_kecamatan);
        mNomorDock=(EditText)rootView.findViewById(R.id.galpal3_nomor_dock3);
        mKodePosEditText=(EditText)rootView.findViewById(R.id.galpal3_kode_pos);
        mLongitudeEditText=(EditText)rootView.findViewById(R.id.galpal3_long3);
        mLatitudeEditText=(EditText)rootView.findViewById(R.id.galpal3_lat);
        mKategoriGalanganSpinner=(Spinner)rootView.findViewById(R.id.galpal3_kategori_galangan_spinner);
        mPropinsiSpinner=(Spinner)rootView.findViewById(R.id.galpal3_propinsi_spinner);
        mKabupatenSpinner=(Spinner)rootView.findViewById(R.id.galpal3_kabupaten_spinner);
        mContactPersonEditText=(EditText)rootView.findViewById(R.id.galpal3_contact_person);
        mNomorCpEditText=(EditText)rootView.findViewById(R.id.galpal3_contact_person_no);
        mJabatanEditText=(EditText)rootView.findViewById(R.id.galpal3_jabatan);
        mEmailEditText=(EditText)rootView.findViewById(R.id.galpal3_alamat_email);
        mCpNamaEditText=(EditText)rootView.findViewById(R.id.galpal3_contact_person);
        mCpNoEditText=(EditText)rootView.findViewById(R.id.galpal3_contact_person_no);
        mCpEmailEditText=(EditText)rootView.findViewById(R.id.galpal3_alamat_email);
        mCpJabatanEditText=(EditText)rootView.findViewById(R.id.galpal3_jabatan);


        mPropinsiSpinnerAdapter = new SpinnerAdapter(getActivity(), mMstPropinsis);
        mPropinsiSpinner.setAdapter(mPropinsiSpinnerAdapter);
        mPropinsiSpinner.setSelection(mPropinsiSpinnerAdapter.getIndex(mFormGalpal3.getIdPropinsi()));
        mPropinsiSpinner.setOnItemSelectedListener(myListener);

        mKategoriGalanganSpinner.setSelection(SpinnerAdapter.getIndex(mKategoriGalanganSpinner,mFormGalpal3.getKategoriGalangan()));
        mKategoriGalanganSpinner.setOnItemSelectedListener(myListener);

        mFormGalpal3.setPerusahaanId(mKualifikasiSurvey.getPerusahaanId());



        mNamaGalanganEditText.setText(mFormGalpal3.getNamaGalangan());
        mNamaGalanganEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal3.setNamaGalangan(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                mMenuCheckingGalpal.setFill(true);
                mDummyMaker.addMenuCheckingGalpal(mMenuCheckingGalpal);
                mCustomClickListener.clickListener();
            }
        });

        mNomorDock.setText(mFormGalpal3.getNomorDock());
        mNomorDock.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal3.setNomorDock(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                mMenuCheckingGalpal.setFill(true);
                mDummyMaker.addMenuCheckingGalpal(mMenuCheckingGalpal);
                mCustomClickListener.clickListener();
            }
        });

        mNomorTeleponEditText.setText(mFormGalpal3.getNomorTelepon());
        mNomorTeleponEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal3.setNomorTelepon(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                mMenuCheckingGalpal.setFill(true);
                mDummyMaker.addMenuCheckingGalpal(mMenuCheckingGalpal);
                mCustomClickListener.clickListener();
            }
        });

        mFaxEditText.setText(mFormGalpal3.getFax());
        mFaxEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal3.setFax(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                mMenuCheckingGalpal.setFill(true);
                mDummyMaker.addMenuCheckingGalpal(mMenuCheckingGalpal);
                mCustomClickListener.clickListener();
            }
        });

        mAlamatEditText.setText(mFormGalpal3.getAlamat());
        mAlamatEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal3.setAlamat(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                mMenuCheckingGalpal.setFill(true);
                mDummyMaker.addMenuCheckingGalpal(mMenuCheckingGalpal);
                mCustomClickListener.clickListener();
            }
        });

        mKelurahanEditText.setText(mFormGalpal3.getKelurahan());
        mKelurahanEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal3.setKelurahan(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                mMenuCheckingGalpal.setFill(true);
                mDummyMaker.addMenuCheckingGalpal(mMenuCheckingGalpal);
                mCustomClickListener.clickListener();
            }
        });

        mKecamatanEditText.setText(mFormGalpal3.getKecamatan());
        mKecamatanEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal3.setKecamatan(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                mMenuCheckingGalpal.setFill(true);
                mDummyMaker.addMenuCheckingGalpal(mMenuCheckingGalpal);
                mCustomClickListener.clickListener();
            }
        });

        mKodePosEditText.setText(mFormGalpal3.getKodePos());
        mKodePosEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal3.setKodePos(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                mMenuCheckingGalpal.setFill(true);
                mDummyMaker.addMenuCheckingGalpal(mMenuCheckingGalpal);
                mCustomClickListener.clickListener();
            }
        });


        mLatitudeEditText.setText(mFormGalpal3.getLatitude());
        mLatitudeEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal3.setLatitude(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                mMenuCheckingGalpal.setFill(true);
                mDummyMaker.addMenuCheckingGalpal(mMenuCheckingGalpal);
                mCustomClickListener.clickListener();
            }
        });

        mLongitudeEditText.setText(mFormGalpal3.getLongitude());
        mLongitudeEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal3.setLongitude(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                mMenuCheckingGalpal.setFill(true);
                mDummyMaker.addMenuCheckingGalpal(mMenuCheckingGalpal);
                mCustomClickListener.clickListener();
            }
        });


        mContactPersonEditText.setText(mFormGalpal3.getContactPerson());
        mContactPersonEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal3.setContactPerson(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                mMenuCheckingGalpal.setFill(true);
                mDummyMaker.addMenuCheckingGalpal(mMenuCheckingGalpal);
                mCustomClickListener.clickListener();
            }
        });

        mNomorCpEditText.setText(mFormGalpal3.getNomorCp());
        mNomorCpEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal3.setNomorCp(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                mMenuCheckingGalpal.setFill(true);
                mDummyMaker.addMenuCheckingGalpal(mMenuCheckingGalpal);
                mCustomClickListener.clickListener();
            }
        });

        mJabatanEditText.setText(mFormGalpal3.getJabatan());
        mJabatanEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal3.setJabatan(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                mMenuCheckingGalpal.setFill(true);
                mDummyMaker.addMenuCheckingGalpal(mMenuCheckingGalpal);
                mCustomClickListener.clickListener();
            }
        });

        mEmailEditText.setText(mFormGalpal3.getEmail());
        mEmailEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal3.setEmail(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                mMenuCheckingGalpal.setFill(true);
                mDummyMaker.addMenuCheckingGalpal(mMenuCheckingGalpal);
                mCustomClickListener.clickListener();
            }
        });

        mCpNamaEditText.setText(mFormGalpal3.getContactPerson());
        mCpNamaEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal3.setContactPerson(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                mMenuCheckingGalpal.setFill(true);
                mDummyMaker.addMenuCheckingGalpal(mMenuCheckingGalpal);
                mCustomClickListener.clickListener();
            }
        });


        mCpNoEditText.setText(mFormGalpal3.getNomorCp());
        mCpNoEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal3.setNomorCp(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                mMenuCheckingGalpal.setFill(true);
                mDummyMaker.addMenuCheckingGalpal(mMenuCheckingGalpal);
                mCustomClickListener.clickListener();
            }
        });

        mCpEmailEditText.setText(mFormGalpal3.getEmail());
        mCpEmailEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal3.setEmail(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                mMenuCheckingGalpal.setFill(true);
                mDummyMaker.addMenuCheckingGalpal(mMenuCheckingGalpal);
                mCustomClickListener.clickListener();
            }
        });

        mCpJabatanEditText.setText(mFormGalpal3.getJabatan());
        mCpJabatanEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal3.setJabatan(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                mMenuCheckingGalpal.setFill(true);
                mDummyMaker.addMenuCheckingGalpal(mMenuCheckingGalpal);
                mCustomClickListener.clickListener();
            }
        });

        mNamaPerusahaanEditText.setText(mNamaPerusahaan);
        mNamaPerusahaanEditText.setEnabled(false);






        mSubmitButton=(Button)rootView.findViewById(R.id.galpal3_btn_submit);
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
                mDummyMaker.addFormGalpal3(mFormGalpal3);
                mDummyMaker.addKualifikasiSurvey(mKualifikasiSurvey);
                mCustomClickListener.clickListener();

            }
        });


        return rootView;
    }

    @Override
    public void onPause() {
        super.onPause();
        if(mKualifikasiSurvey.getStatus()==0||mKualifikasiSurvey.getStatus()==2 && !mMenuCheckingGalpal.isVerified()){
            mDummyMaker.addFormGalpal3(mFormGalpal3);
            if(!new ConnectionDetector(getActivity()).isConnectingToInternet()){
                PushGalpalService.setServiceAlarm(getActivity(),true);
                Log.i("NotificationService","FG3");
            }else {
                new PushTask(mFormGalpal3, mMenuCheckingGalpal).execute();

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
        private FormGalpal3 mFormGalpal3;
        private SingleMenuChecking mSingleMenuChecking;

        public PushTask(FormGalpal3 formGalpal3, SingleMenuChecking singleMenuChecking){
            mFormGalpal3=formGalpal3;
            mSingleMenuChecking=singleMenuChecking;
        }

        @Override
        protected Void doInBackground(Void... params) {
            new DataPusher(GalKomSharedPreference.getUserId(mContext),GalKomSharedPreference.getPassword(mContext)).makePostRequestFG3(mFormGalpal3);
            new DataPusher(GalKomSharedPreference.getUserId(mContext),GalKomSharedPreference.getPassword(mContext)).makePostRequestMenuCheckingGalpal((MenuCheckingGalpal) mSingleMenuChecking);
            return null;
        }
    }

    AdapterView.OnItemSelectedListener myListener=new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            switch (parent.getId()) {
                case R.id.galpal3_kabupaten_spinner:
                    MstKabupaten mstKabupaten= (MstKabupaten) mKabupatenSpinnerAdapter.getItem(position);
                    mFormGalpal3.setIdKabupaten_kota(mstKabupaten.getId());
                    break;
                case R.id.galpal3_propinsi_spinner:
                    MstPropinsi mstPropinsi=(MstPropinsi) mPropinsiSpinnerAdapter.getItem(position);
                    mFormGalpal3.setIdPropinsi(mstPropinsi.getId());

                    if(mFormGalpal3.getIdPropinsi()!=0){
                        mMstKabupatens=DummyMaker.get(getActivity()).getMstKabupatens(mFormGalpal3.getIdPropinsi());
                        mKabupatenSpinnerAdapter=new SpinnerAdapter(getActivity(),mMstKabupatens);
                        mKabupatenSpinner.setAdapter(mKabupatenSpinnerAdapter);
                        mKabupatenSpinner.setSelection(mKabupatenSpinnerAdapter.getIndex(mFormGalpal3.getIdKabupaten_kota()));
                        mKabupatenSpinner.setOnItemSelectedListener(myListener);
                    }else{
                        mKabupatenSpinner.setEnabled(false);
                    }
                    break;
                case R.id.galpal3_kategori_galangan_spinner:
                    mFormGalpal3.setKategoriGalangan(parent.getItemAtPosition(position).toString());
                    break;
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };




}
