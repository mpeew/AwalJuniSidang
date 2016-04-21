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
import android.widget.Toast;

import com.mpewpazi.android.awaljunisidang.Form.FormGalpal3;
import com.mpewpazi.android.awaljunisidang.Form.SingleForm;
import com.mpewpazi.android.awaljunisidang.R;
import com.mpewpazi.android.awaljunisidang.database.BaseDBHelper;
import com.mpewpazi.android.awaljunisidang.database.FormGalpalDBHelper;


import java.util.List;

/**
 * Created by mpewpazi on 3/27/16.
 */
public class FormGalpal3Fragment extends Fragment {
/*
    private final static String NAMA_FORM="Identitas Umum Galangan";


    private Survey mSurvey;
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

    private List<SingleForm> mForms;
    private FormGalpal3 mFormGalpal3;
    private FormGalpalDBHelper dbHelper;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mSurvey=SurveyAssignation.get(getActivity()).getSurvey(DrawerFormActivity.surveyId);
        mNamaPerusahaan=mSurvey.getNamaPerusahaan();
        mFormGalpal3=mSurvey.getFormGalpal3();

        dbHelper=new FormGalpalDBHelper(getActivity());

        if(dbHelper.checkIsDataAlreadyInDBorNot(mFormGalpal3.getId(), BaseDBHelper.FORM_GALPAL3_TABLE_NAME)) {
            Cursor cursor = dbHelper.getDataForm(mFormGalpal3.getId(), BaseDBHelper.FORM_GALPAL3_TABLE_NAME);

            cursor.moveToNext();
            //mFormGalpal1.setId(cursor.getInt(cursor.getColumnIndex(BaseDBHelper.FORM_GALPAL1_COLUMN_ID)));


            mFormGalpal3.setNamaGalangan(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_GALPAL3_COLUMN_NAMA_GALANGAN)));
            mFormGalpal3.setNomorTelepon(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_GALPAL3_COLUMN_NOMOR_TELEPON)));
            mFormGalpal3.setFax(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_GALPAL3_COLUMN_FAX)));
            mFormGalpal3.setAlamat(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_GALPAL3_COLUMN_ALAMAT)));
            mFormGalpal3.setKelurahan(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_GALPAL3_COLUMN_KELURAHAN)));
            mFormGalpal3.setKecamatan(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_GALPAL3_COLUMN_KECAMATAN)));
            mFormGalpal3.setPropinsi(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_GALPAL3_COLUMN_PROPINSI)));
            mFormGalpal3.setKebupaten_kota(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_GALPAL3_COLUMN_KABUPATEN)));
            mFormGalpal3.setKodePos(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_GALPAL3_COLUMN_KODE_POS)));
            mFormGalpal3.setLongitude(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_GALPAL3_COLUMN_LONGITUDE)));
            mFormGalpal3.setLatitude(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_GALPAL3_COLUMN_LATITUDE)));
            mFormGalpal3.setKategoriGalangan(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_GALPAL3_COLUMN_KATEGORI_GALANGAN)));
            mFormGalpal3.setContactPerson(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_GALPAL3_COLUMN_CP)));
            mFormGalpal3.setNomorCp(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_GALPAL3_COLUMN_NO_CP)));
            mFormGalpal3.setJabatan(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_GALPAL3_COLUMN_JABATAN)));
            mFormGalpal3.setEmail(cursor.getString(cursor.getColumnIndex(BaseDBHelper.FORM_GALPAL3_COLUMN_EMAIL_CP)));
            cursor.close();


        }
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
        //mKategoriGalanganEditText=(Spinner)rootView.findViewById(R.id.kategori_galangan_spinner);
        mContactPersonEditText=(EditText)rootView.findViewById(R.id.contact_person);
        mNomorCpEditText=(EditText)rootView.findViewById(R.id.contact_person_no);
        mJabatanEditText=(EditText)rootView.findViewById(R.id.jabatan);
        mEmailEditText=(EditText)rootView.findViewById(R.id.alamat_email);

        mFormGalpal3.setNamaPerusahaan(mSurvey.getNamaPerusahaan());

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

       /* mKategoriGalanganEditText.setText(mFormGalpal3.getKategoriGalangan());
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


        mSubmitButton=(Button)rootView.findViewById(R.id.b3tn_signup);
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(dbHelper.checkIsDataAlreadyInDBorNot(mFormGalpal3.getId(), BaseDBHelper.FORM_GALPAL3_TABLE_NAME)) {
                    dbHelper.updateFormGalpal3(mFormGalpal3.getId(), mFormGalpal3.getNamaPerusahaan(), mFormGalpal3.getNamaGalangan(),mFormGalpal3.getNomorDock(),
                            mFormGalpal3.getNomorTelepon(), mFormGalpal3.getFax(), mFormGalpal3.getAlamat(),
                            mFormGalpal3.getKelurahan(), mFormGalpal3.getKecamatan(), mFormGalpal3.getPropinsi(), mFormGalpal3.getKebupaten_kota(),
                            mFormGalpal3.getKodePos(),  mFormGalpal3.getLongitude(),mFormGalpal3.getLatitude(), mFormGalpal3.getKategoriGalangan(),
                            mFormGalpal3.getContactPerson(), mFormGalpal3.getNomorCp(), mFormGalpal3.getJabatan(), mFormGalpal3.getEmail());
                }else{
                    dbHelper.insertFormGalpal3(mFormGalpal3.getId(), mFormGalpal3.getNamaPerusahaan(), mFormGalpal3.getNamaGalangan(), mFormGalpal3.getNomorDock(),
                            mFormGalpal3.getNomorTelepon(), mFormGalpal3.getFax(), mFormGalpal3.getAlamat(),
                            mFormGalpal3.getKelurahan(), mFormGalpal3.getKecamatan(), mFormGalpal3.getPropinsi(), mFormGalpal3.getKebupaten_kota(),
                            mFormGalpal3.getKodePos(), mFormGalpal3.getLongitude(), mFormGalpal3.getLatitude(), mFormGalpal3.getKategoriGalangan(),
                            mFormGalpal3.getContactPerson(), mFormGalpal3.getNomorCp(), mFormGalpal3.getJabatan(), mFormGalpal3.getEmail());
                }

                Toast.makeText(getContext(), "Berhasil ", Toast.LENGTH_SHORT).show();
            }
        });


        return rootView;
    }
*/
}
