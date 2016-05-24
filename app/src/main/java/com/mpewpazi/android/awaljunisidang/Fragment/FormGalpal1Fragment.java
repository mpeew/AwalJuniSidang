package com.mpewpazi.android.awaljunisidang.Fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.Domain;
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mpewpazi.android.awaljunisidang.DrawerFormActivity;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal1;
import com.mpewpazi.android.awaljunisidang.Form.SingleForm;
import com.mpewpazi.android.awaljunisidang.R;
import com.mpewpazi.android.awaljunisidang.dummy.DummyMaker;
import com.mpewpazi.android.awaljunisidang.masterData.MstKabupaten;
import com.mpewpazi.android.awaljunisidang.masterData.MstPropinsi;
import com.mpewpazi.android.awaljunisidang.model.KualifikasiSurvey;
import com.mpewpazi.android.awaljunisidang.model.MenuCheckingGalpal;

import java.util.ArrayList;
import java.util.List;

import static android.widget.AdapterView.OnItemSelectedListener;

/**
 * Created by mpewpazi on 3/27/16.
 */
public class FormGalpal1Fragment extends SingleFragment implements Validator.ValidationListener {

    private boolean isValidated;


    private EditText mNamaPerusahaanEditText;

    @NotEmpty
    private EditText mNomorTeleponEditText;
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
    private EditText mAnggotaAsosiasiEditText;
    @NotEmpty
    private EditText mKategoriPerusahaanEditText;
    @NotEmpty
    private EditText mContactPersonEditText;
    @NotEmpty
    private EditText mNomorCpEditText;
    @NotEmpty
    private EditText mJabatanEditText;
    @Email
    private EditText mEmailEditText;

    @Domain
    private EditText mWebsiteEditText;

    private Spinner mPropinsiSpinner;
    private Spinner mKabupatenSpinner;

    private Button mSubmitButton;



    private List<MstPropinsi> mMstPropinsis;
    private List<MstKabupaten> mMstKabupatens;

    private List<String> mPropinsiNames;
    private List<String> mKabupatenNames;

    private List<SingleForm> mGalpalForms;
    private KualifikasiSurvey mKualifikasiSurvey;

    private FormGalpal1 mFormGalpal1;
    private DummyMaker mDummyMaker;
    private MenuCheckingGalpal mMenuCheckingGalpal;

    private Validator mValidator;



    private String mNamaPerusahaan;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mDummyMaker=DummyMaker.get(getActivity());
        mGalpalForms=mDummyMaker.getGalpalForms();
        mKualifikasiSurvey=mDummyMaker.getKualifikasiSurvey(DrawerFormActivity.kualifikasiSurveyId);
        mFormGalpal1=mDummyMaker.getFormGalpal1(DrawerFormActivity.kualifikasiSurveyId);
        mMenuCheckingGalpal=mDummyMaker.getMenuCheckingGalpal(DrawerFormActivity.kualifikasiSurveyId,FormGalpal1.kode);

        mValidator=new Validator(this);
        mValidator.setValidationListener(this);

        mNamaPerusahaan=mDummyMaker.getPerusahaan(mKualifikasiSurvey.getPerusahaanId()).getNamaPerusahaan();

        // memasukan master data propinsi
        mMstPropinsis = DummyMaker.get(getActivity()).getMstPropinsis();



        mPropinsiNames=new ArrayList<>();
        for(int a = 0; a< mMstPropinsis.size(); a++){
            mPropinsiNames.add(mMstPropinsis.get(a).getNama());
        }







    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_form_galpal1, container, false);



        mNamaPerusahaanEditText=(EditText)rootView.findViewById(R.id.galpal1_nama_perusahaan);
        mNomorTeleponEditText=(EditText)rootView.findViewById(R.id.galpal1_nomor_telepon);
        mFaxEditText=(EditText)rootView.findViewById(R.id.galpal1_fax);
        mAlamatEditText=(EditText)rootView.findViewById(R.id.galpal1_alamat);
        mKelurahanEditText=(EditText)rootView.findViewById(R.id.galpal1_kelurahan);
        mKecamatanEditText=(EditText)rootView.findViewById(R.id.galpal1_kecamatan);
        mKodePosEditText=(EditText)rootView.findViewById(R.id.galpal1_kode_pos);
        mAnggotaAsosiasiEditText=(EditText)rootView.findViewById(R.id.galpal1_anggota_asosiasi);
        mKategoriPerusahaanEditText=(EditText)rootView.findViewById(R.id.galpal1_kategori_perusahaan);
        mContactPersonEditText=(EditText)rootView.findViewById(R.id.galpal1_contact_person);
        mNomorCpEditText=(EditText)rootView.findViewById(R.id.galpal1_contact_person_no);
        mJabatanEditText=(EditText)rootView.findViewById(R.id.galpal1_jabatan);
        mEmailEditText=(EditText)rootView.findViewById(R.id.galpal1_alamat_email);
        mPropinsiSpinner=(Spinner)rootView.findViewById(R.id.galpal1_propinsi_spinner);
        mWebsiteEditText=(EditText)rootView.findViewById(R.id.galpal1_website);
        mKabupatenSpinner=(Spinner)rootView.findViewById(R.id.galpal1_kabupaten_spinner);

        // setting spinner propinsi

        ArrayAdapter<String> dataAdapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,mPropinsiNames);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mPropinsiSpinner.setAdapter(dataAdapter);
       // mPropinsiSpinner.setSelection(mFormGalpal1.getIdPropinsi());
        mPropinsiSpinner.setOnItemSelectedListener(myListener);


        /*if(mFormGalpal1.getIdPropinsi()!=0){
            mMstKabupatens=DummyMaker.get(getActivity()).getMstKabupaten(mFormGalpal1.getIdPropinsi());
            mKabupatenNames=new ArrayList<>();
            for(int a=0;a<mMstKabupatens.size();a++){
                mKabupatenNames.add(mMstKabupatens.get(a).getNama());
            }
            ArrayAdapter<String> dataAdapter1=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,mKabupatenNames);
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            mKabupatenSpinner.setAdapter(dataAdapter1);
            mKabupatenSpinner.setSelection(mFormGalpal1.getIdKabupaten_kota());
            mKabupatenSpinner.setOnItemSelectedListener(myListener);
        }else{
            mKabupatenSpinner.setEnabled(false);
        }*/

        //nama perusahaan di lock
        mFormGalpal1.setNamaPerusahaan(mNamaPerusahaan);


        mNomorTeleponEditText.setText(mFormGalpal1.getNomorTelepon());
        mNomorTeleponEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal1.setNomorTelepon(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {
                mMenuCheckingGalpal.setFill(true);
                mDummyMaker.addMenuCheckingGalpal(mMenuCheckingGalpal);
                mCustomClickListener.clickListener();
            }
        });

        mFaxEditText.setText(mFormGalpal1.getFax());
        mFaxEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal1.setFax(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                mMenuCheckingGalpal.setFill(true);
                mDummyMaker.addMenuCheckingGalpal(mMenuCheckingGalpal);
                mCustomClickListener.clickListener();
            }
        });

        mAlamatEditText.setText(mFormGalpal1.getAlamat());
        mAlamatEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal1.setAlamat(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                mMenuCheckingGalpal.setFill(true);
                mDummyMaker.addMenuCheckingGalpal(mMenuCheckingGalpal);
                mCustomClickListener.clickListener();
            }
        });

        mKelurahanEditText.setText(mFormGalpal1.getKelurahan());
        mKelurahanEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal1.setKelurahan(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                mMenuCheckingGalpal.setFill(true);
                mDummyMaker.addMenuCheckingGalpal(mMenuCheckingGalpal);
                mCustomClickListener.clickListener();
            }
        });

        mKecamatanEditText.setText(mFormGalpal1.getKecamatan());
        mKecamatanEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal1.setKecamatan(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                mMenuCheckingGalpal.setFill(true);
                mDummyMaker.addMenuCheckingGalpal(mMenuCheckingGalpal);
                mCustomClickListener.clickListener();
            }
        });

        mKodePosEditText.setText(mFormGalpal1.getKodePos());
        mKodePosEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal1.setKodePos(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                mMenuCheckingGalpal.setFill(true);
                mDummyMaker.addMenuCheckingGalpal(mMenuCheckingGalpal);
                mCustomClickListener.clickListener();
            }
        });


        mAnggotaAsosiasiEditText.setText(mFormGalpal1.getAnggotaAsosiasi());
        mAnggotaAsosiasiEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal1.setAnggotaAsosiasi(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                mMenuCheckingGalpal.setFill(true);
                mDummyMaker.addMenuCheckingGalpal(mMenuCheckingGalpal);
                mCustomClickListener.clickListener();
            }
        });

        mKategoriPerusahaanEditText.setText(mFormGalpal1.getKategoriPerusahaan());
        mKategoriPerusahaanEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal1.setKategoriPerusahaan(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                mMenuCheckingGalpal.setFill(true);
                mDummyMaker.addMenuCheckingGalpal(mMenuCheckingGalpal);
                mCustomClickListener.clickListener();
            }
        });

        mContactPersonEditText.setText(mFormGalpal1.getContactPerson());
        mContactPersonEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal1.setContactPerson(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                mMenuCheckingGalpal.setFill(true);
                mDummyMaker.addMenuCheckingGalpal(mMenuCheckingGalpal);
                mCustomClickListener.clickListener();
            }
        });

        mNomorCpEditText.setText(mFormGalpal1.getNomorCp());
        mNomorCpEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal1.setNomorCp(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                mMenuCheckingGalpal.setFill(true);
                mDummyMaker.addMenuCheckingGalpal(mMenuCheckingGalpal);
                mCustomClickListener.clickListener();
            }
        });

        mJabatanEditText.setText(mFormGalpal1.getJabatan());
        mJabatanEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal1.setJabatan(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                mMenuCheckingGalpal.setFill(true);
                mDummyMaker.addMenuCheckingGalpal(mMenuCheckingGalpal);
                mCustomClickListener.clickListener();
            }
        });

        mEmailEditText.setText(mFormGalpal1.getEmail());
        mEmailEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal1.setEmail(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                mMenuCheckingGalpal.setFill(true);
                mDummyMaker.addMenuCheckingGalpal(mMenuCheckingGalpal);
                mCustomClickListener.clickListener();
            }
        });

        mWebsiteEditText.setText(mFormGalpal1.getWebsite());
        mWebsiteEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal1.setWebsite(s.toString());
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


        mSubmitButton=(Button)rootView.findViewById(R.id.galpal1_btn_submit);
        if(mMenuCheckingGalpal.isComplete()){
            mSubmitButton.setText(R.string.belum_lengkap);
            mSubmitButton.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
        }
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mValidator.validate();
                if(!isValidated){
                    return;
                }


                if(!mMenuCheckingGalpal.isComplete()){
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
                mDummyMaker.addFormGalpal1(mFormGalpal1);
                mDummyMaker.addKualifikasiSurvey(mKualifikasiSurvey);
                mCustomClickListener.clickListener();



            }
        });


        return rootView;
    }





    @Override
    public void onPause() {
        super.onPause();
        mDummyMaker.addFormGalpal1(mFormGalpal1);

    }

    OnItemSelectedListener myListener=new OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            switch (parent.getId()) {
                case R.id.galpal1_kabupaten_spinner:
                    mFormGalpal1.setIdKabupaten_kota(position+1);
                    break;
                case R.id.galpal1_propinsi_spinner:
                    mFormGalpal1.setIdPropinsi(position+1);
                    break;


            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };


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
}
