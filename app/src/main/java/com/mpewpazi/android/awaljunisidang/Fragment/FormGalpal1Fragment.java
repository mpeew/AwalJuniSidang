package com.mpewpazi.android.awaljunisidang.Fragment;

import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.mpewpazi.android.awaljunisidang.DrawerFormActivity;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal1;
import com.mpewpazi.android.awaljunisidang.Form.SingleForm;
import com.mpewpazi.android.awaljunisidang.MasterDataCreator;
import com.mpewpazi.android.awaljunisidang.R;
import com.mpewpazi.android.awaljunisidang.database.BaseDBHelper;
import com.mpewpazi.android.awaljunisidang.database.FormGalpalDBHelper;
import com.mpewpazi.android.awaljunisidang.dummy.DummyMaker;
import com.mpewpazi.android.awaljunisidang.masterData.Propinsi;
import com.mpewpazi.android.awaljunisidang.model.KualifikasiSurvey;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mpewpazi on 3/27/16.
 */
public class FormGalpal1Fragment extends Fragment  {

    private static final String NAMA_FORM="Identitas Umum Perusahaan";

    private EditText mNamaPerusahaanEditText;
    private EditText mNomorTeleponEditText;
    private EditText mFaxEditText;
    private EditText mAlamatEditText;
    private EditText mKelurahanEditText;
    private EditText mKecamatanEditText;
    private EditText mKodePosEditText;
    private EditText mAnggotaAsosiasiEditText;
    private EditText mKategoriPerusahaanEditText;
    private EditText mContactPersonEditText;
    private EditText mNomorCpEditText;
    private EditText mJabatanEditText;
    private EditText mEmailEditText;
    private TextInputLayout mEmailInputLayout;
    private EditText mWebsiteEditText;

    private Spinner mPropinsiSpinner;

    private Button mSubmitButton;



    private List<Propinsi> mPropinsis;
    private List<String> mPropinsiNames;

    private List<SingleForm> mGalpalForms;
    private KualifikasiSurvey mKualifikasiSurvey;

    private FormGalpal1 mFormGalpal1;

    private FormGalpalDBHelper dbHelper;

    private String mNamaPerusahaan;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // memasukan master data propinsi
        mPropinsis= MasterDataCreator.get().getPropinsis();
        mPropinsiNames=new ArrayList<>();
        for(int a=0;a<mPropinsis.size();a++){
            mPropinsiNames.add(mPropinsis.get(a).getNama());
        }


        mKualifikasiSurvey=DummyMaker.get(getActivity()).getKualifikasiSurvey(DrawerFormActivity.kualifikasiSurveyId);
        mFormGalpal1=(FormGalpal1) DummyMaker.get(getActivity()).
                getGalpalForm(DrawerFormActivity.kualifikasiSurveyId,NAMA_FORM);


        mNamaPerusahaan=mKualifikasiSurvey.getPerusahaan().getNamaPerusahaan();



       dbHelper=new FormGalpalDBHelper(getActivity());

       if(dbHelper.checkIsDataAlreadyInDBorNot(mFormGalpal1.getIdentitasPerusahaanId(), BaseDBHelper.FORM_PERUSAHAAN_IDENTITAS_TABLE_NAME)) {
            Cursor cursor = dbHelper.getDataForm(mFormGalpal1.getIdentitasPerusahaanId(), BaseDBHelper.FORM_PERUSAHAAN_IDENTITAS_TABLE_NAME);

            cursor.moveToNext();
            //mFormGalpal1.setId(cursor.getInt(cursor.getColumnIndex(BaseDBHelper.FORM_PERUSAHAAN_IDENTITAS_COLUMN_ID)));


            mFormGalpal1.setNomorTelepon(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_PERUSAHAAN_IDENTITAS_COLUMN_TELEPON_PERUSAHAAN)));
            mFormGalpal1.setFax(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_PERUSAHAAN_IDENTITAS_COLUMN_FAX_PERUSAHAAN)));
            mFormGalpal1.setAlamat(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_PERUSAHAAN_IDENTITAS_COLUMN_ALAMAT_PERUSAHAAN)));
            mFormGalpal1.setKelurahan(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_PERUSAHAAN_IDENTITAS_COLUMN_KELURAHAN_PERUSAHAAN)));
            mFormGalpal1.setKecamatan(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_PERUSAHAAN_IDENTITAS_COLUMN_KECAMATAN_PERUSAHAAN)));
            mFormGalpal1.setPropinsi(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_PERUSAHAAN_IDENTITAS_COLUMN_ID_PROPINSI_PERUSAHAAN)));
            mFormGalpal1.setKebupaten_kota(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_PERUSAHAAN_IDENTITAS_COLUMN_ID_KABUPATEN_PERUSAHAAN)));
            mFormGalpal1.setKodePos(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_PERUSAHAAN_IDENTITAS_COLUMN_KODE_POS_PERUSAHAAN)));
            mFormGalpal1.setAnggotaAsosiasi(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_PERUSAHAAN_IDENTITAS_COLUMN_ANGGOTA_ASOSIASI)));
            mFormGalpal1.setKategoriPerusahaan(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_PERUSAHAAN_IDENTITAS_COLUMN_KATEGORI_PERUSAHAAN)));
            mFormGalpal1.setContactPerson(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_PERUSAHAAN_IDENTITAS_COLUMN_CP_NAMA)));
            mFormGalpal1.setNomorCp(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_PERUSAHAAN_IDENTITAS_COLUMN_CP_NO)));
            mFormGalpal1.setJabatan(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_PERUSAHAAN_IDENTITAS_COLUMN_CP_JABATAN)));
            mFormGalpal1.setEmail(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_PERUSAHAAN_IDENTITAS_COLUMN_CP_EMAIL)));
            mFormGalpal1.setWebsite(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_PERUSAHAAN_IDENTITAS_COLUMN_WEBSITE)));
            cursor.close();


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
        mEmailInputLayout=(TextInputLayout)rootView.findViewById(R.id.galpal1_alamat_email_layout);
        mPropinsiSpinner=(Spinner)rootView.findViewById(R.id.galpal1_propinsi_spinner);
        mWebsiteEditText=(EditText)rootView.findViewById(R.id.galpal1_website);

        // setting spinner propinsi

        ArrayAdapter<String> dataAdapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,mPropinsiNames);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mPropinsiSpinner.setAdapter(dataAdapter);
        mPropinsiSpinner.setSelection(dataAdapter.getPosition(mFormGalpal1.getPropinsi()));

        //nama perusahaan di lock
        mFormGalpal1.setNamaPerusahaan(mKualifikasiSurvey.getPerusahaan().getNamaPerusahaan());


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
                validateEmail();

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

            }
        });
        

        mNamaPerusahaanEditText.setText(mNamaPerusahaan);
        mNamaPerusahaanEditText.setEnabled(false);


        mSubmitButton=(Button)rootView.findViewById(R.id.galpal1_btn_submit);
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!validateEmail()) {
                    Toast.makeText(getContext(),"Terdapat data yang tidak valid ", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(dbHelper.checkIsDataAlreadyInDBorNot(mFormGalpal1.getIdentitasPerusahaanId(),BaseDBHelper.FORM_PERUSAHAAN_IDENTITAS_TABLE_NAME)) {
                    dbHelper.updateFormIdentitasPerusahaan(mFormGalpal1.getIdentitasPerusahaanId(),mFormGalpal1.getKualifikasiSurvey().getPerusahaan().getId(),mFormGalpal1.getKualifikasiSurvey().getKualifikasiSurveyId(), mFormGalpal1.getStatusKepemilikanUsaha(),
                            mFormGalpal1.getNomorTelepon(), mFormGalpal1.getFax(), mFormGalpal1.getAlamat(),
                            mFormGalpal1.getKelurahan(), mFormGalpal1.getKecamatan(), 1, 2,
                            mFormGalpal1.getKodePos(), mFormGalpal1.getAnggotaAsosiasi(), mFormGalpal1.getKategoriPerusahaan(),
                            mFormGalpal1.getContactPerson(), mFormGalpal1.getNomorCp(), mFormGalpal1.getJabatan(), mFormGalpal1.getEmail(),mFormGalpal1.getWebsite());
                }else{
                    dbHelper.insertFormIdentitasPerusahaan(mFormGalpal1.getIdentitasPerusahaanId(),mFormGalpal1.getKualifikasiSurvey().getPerusahaan().getId(),mFormGalpal1.getKualifikasiSurvey().getKualifikasiSurveyId(), mFormGalpal1.getStatusKepemilikanUsaha(),
                            mFormGalpal1.getNomorTelepon(), mFormGalpal1.getFax(), mFormGalpal1.getAlamat(),
                            mFormGalpal1.getKelurahan(), mFormGalpal1.getKecamatan(), 1, 2,
                            mFormGalpal1.getKodePos(), mFormGalpal1.getAnggotaAsosiasi(), mFormGalpal1.getKategoriPerusahaan(),
                            mFormGalpal1.getContactPerson(), mFormGalpal1.getNomorCp(), mFormGalpal1.getJabatan(), mFormGalpal1.getEmail(),mFormGalpal1.getWebsite());
                }

                Toast.makeText(getContext(),"Berhasil ", Toast.LENGTH_SHORT).show();
            }
        });


        return rootView;
    }

    private boolean validateEmail() {
        String email = mEmailEditText.getText().toString().trim();

        if (email.isEmpty() || !isValidEmail(email)) {
            mEmailInputLayout.setError("Masukan email yang valid");
            requestFocus(mEmailEditText);
            return false;
        } else {
            mEmailInputLayout.setErrorEnabled(false);
        }

        return true;
    }

    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }





}
