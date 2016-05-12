package com.mpewpazi.android.awaljunisidang.Fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.mpewpazi.android.awaljunisidang.DrawerFormActivity;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal3;
import com.mpewpazi.android.awaljunisidang.Form.SingleForm;
import com.mpewpazi.android.awaljunisidang.R;
import com.mpewpazi.android.awaljunisidang.dummy.DummyMaker;
import com.mpewpazi.android.awaljunisidang.model.KualifikasiSurvey;

import java.util.List;

/**
 * Created by mpewpazi on 3/27/16.
 */
public class FormGalpal3Fragment extends SingleFragment {

    private final static String NAMA_FORM="Identitas Umum Galangan";



    private String mNamaPerusahaan;

    private EditText mNamaGalanganEditText;
    private EditText mNamaPerusahaanEditText;
    private EditText mNomorTeleponEditText;
    private EditText mFaxEditText;
    private EditText mAlamatEditText;
    private EditText mKelurahanEditText;
    private EditText mKecamatanEditText;
    private EditText mKodePosEditText;
    private EditText mLongitudeEditText;
    private EditText mLatitudeEditText;
    private EditText mKategoriGalanganEditText;
    private EditText mContactPersonEditText;
    private EditText mNomorCpEditText;
    private EditText mJabatanEditText;
    private EditText mEmailEditText;
    private Button mSubmitButton;

    private List<SingleForm> mGalpalForms;
    private FormGalpal3 mFormGalpal3;

    private DummyMaker mDummyMaker;


    private KualifikasiSurvey mKualifikasiSurvey;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mDummyMaker= DummyMaker.get(getActivity());
        mKualifikasiSurvey= DummyMaker.get(getActivity()).getKualifikasiSurvey(DrawerFormActivity.kualifikasiSurveyId);
        mFormGalpal3=DummyMaker.get(getActivity()).getFormGalpal3(DrawerFormActivity.kualifikasiSurveyId);
        mGalpalForms=DummyMaker.get(getActivity()).getGalpalForms();

        mNamaPerusahaan=mDummyMaker.getPerusahaan(mKualifikasiSurvey.getPerusahaanId()).getNamaPerusahaan();


    }







    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_form_galpal3, container, false);

        mNamaPerusahaanEditText=(EditText)rootView.findViewById(R.id.nama_perusahaan3);
        mNamaGalanganEditText=(EditText)rootView.findViewById(R.id.nama_galangan3);
        mNomorTeleponEditText=(EditText)rootView.findViewById(R.id.nomor_telepon);
        mFaxEditText=(EditText)rootView.findViewById(R.id.fax);
        mAlamatEditText=(EditText)rootView.findViewById(R.id.alamat);
        mKelurahanEditText=(EditText)rootView.findViewById(R.id.kelurahan);
        mKecamatanEditText=(EditText)rootView.findViewById(R.id.kecamatan);
        mKodePosEditText=(EditText)rootView.findViewById(R.id.kode_pos);
        mLongitudeEditText=(EditText)rootView.findViewById(R.id.long3);
        mLatitudeEditText=(EditText)rootView.findViewById(R.id.lat);
       // mKategoriGalanganEditText=(Spinner)rootView.findViewById(R.id.kategori_galangan_spinner);
        mContactPersonEditText=(EditText)rootView.findViewById(R.id.contact_person);
        mNomorCpEditText=(EditText)rootView.findViewById(R.id.contact_person_no);
        mJabatanEditText=(EditText)rootView.findViewById(R.id.jabatan);
        mEmailEditText=(EditText)rootView.findViewById(R.id.alamat_email);

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

            }
        });

       /*mKategoriGalanganEditText.setText(mFormGalpal3.getKategoriGalangan());
        mKategoriGalanganEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mFormGalpal3.setKategoriGalangan(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });*/

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

            }
        });


        mNamaPerusahaanEditText.setText(mNamaPerusahaan);
        mNamaPerusahaanEditText.setEnabled(false);


        mSubmitButton=(Button)rootView.findViewById(R.id.galpal3_btn_submit);
        if(mFormGalpal3.isSend()){
            mSubmitButton.setText(R.string.belum_lengkap);
            mSubmitButton.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
        }
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mFormGalpal3.isSend()){
                    mFormGalpal3.setSend(true);
                    mKualifikasiSurvey.setProgress(mKualifikasiSurvey.getProgress()+100/mGalpalForms.size());
                    mSubmitButton.setText(R.string.belum_lengkap);
                    mSubmitButton.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
                }else{
                    mFormGalpal3.setSend(false);
                    mKualifikasiSurvey.setProgress(mKualifikasiSurvey.getProgress()-100/mGalpalForms.size());
                    mSubmitButton.setText(R.string.lengkap);
                    mSubmitButton.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
                }

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
        mDummyMaker.addFormGalpal3(mFormGalpal3);

    }

}
