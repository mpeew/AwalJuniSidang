package com.mpewpazi.android.awaljunisidang;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mpewpazi.android.awaljunisidang.Form.FormGalpal1;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal3;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal4;
import com.mpewpazi.android.awaljunisidang.Form.FormGalpal6;
import com.mpewpazi.android.awaljunisidang.Form.FormKompal3a;
import com.mpewpazi.android.awaljunisidang.Form.FormKompal3b;
import com.mpewpazi.android.awaljunisidang.Form.FormKompal3c;
import com.mpewpazi.android.awaljunisidang.Form.FormKompal3d;
import com.mpewpazi.android.awaljunisidang.Form.SingleForm;
import com.mpewpazi.android.awaljunisidang.dummy.DummyMaker;
import com.mpewpazi.android.awaljunisidang.model.KualifikasiSurvey;
import com.mpewpazi.android.awaljunisidang.model.SurveyAssignSurveyor;

import java.util.List;

public class HomePageActivity extends AppCompatActivity {
    private static final String EXTRA_ID_USER="usr";

    private RecyclerView mRecyclerView;
    private KualifikasiSurveyAdapter mKualifikasiSurveyAdapter;

    private DummyMaker mDummyMaker;
    private List<SurveyAssignSurveyor> mSurveyAssignSurveyors;
    private List<KualifikasiSurvey> mKualifikasiSurveys;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        mRecyclerView=(RecyclerView)findViewById(R.id.surveyy_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        updateUi();

        //for(KualifikasiSurvey kualifikasiSurvey:mKualifikasiSurveys){
            new FetchItemTask(String.valueOf(20150101)).execute();
        //}

    }

    private void updateUi() {
        String userId=getIntent().getStringExtra(EXTRA_ID_USER);
        mDummyMaker= DummyMaker.get(this);
        mKualifikasiSurveys=mDummyMaker.getKualifikasiSurveys(userId);
        if(mKualifikasiSurveyAdapter==null) {
            mKualifikasiSurveyAdapter = new KualifikasiSurveyAdapter(mKualifikasiSurveys);
            mRecyclerView.setAdapter(mKualifikasiSurveyAdapter);
        }else{
            mKualifikasiSurveyAdapter.notifyDataSetChanged();
            mKualifikasiSurveyAdapter.setKualifikasiSurveys(mKualifikasiSurveys);

        }
    }


    private class KualifikasiSurveyHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private static final String EXTRA_ID_SURVEY_KUALIFIKASI="test";

        private TextView mNamaPerusahaanTextView;
        private TextView mPeriodeSurveyTextView;
        private TextView mJenisObjekTextView;
        private TextView mProgressTextView;
        private ImageView mImageViewGembok;

        private KualifikasiSurvey mKualifikasiSurvey;
        public KualifikasiSurvey kualifikasiSurvey;

        public KualifikasiSurveyHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            mNamaPerusahaanTextView=(TextView)itemView.findViewById(R.id.survey_nama_perusahaan);
            mPeriodeSurveyTextView=(TextView)itemView.findViewById(R.id.survey_periode_survey);
            mJenisObjekTextView=(TextView)itemView.findViewById(R.id.survey_jenis_objek_survey);
            mProgressTextView=(TextView)itemView.findViewById(R.id.survey_progres_persen);
            mImageViewGembok=(ImageView)itemView.findViewById(R.id.survey_gembok_image);
        }

        public void bindSurvey(KualifikasiSurvey kualifikasiSurvey) {

            mKualifikasiSurvey = kualifikasiSurvey;
            String namaPerusahaan=mDummyMaker.getPerusahaan(kualifikasiSurvey.getPerusahaanId()).getNamaPerusahaan();
            String periodeSurvey=mDummyMaker.getPeriodeSurvey(kualifikasiSurvey.getPeriodeSurveyId()).getTahunKualifikasi();
            String jeisObjek=mDummyMaker.getPerusahaan(kualifikasiSurvey.getPerusahaanId()).getIndustri();
            mNamaPerusahaanTextView.setText(namaPerusahaan);
            mJenisObjekTextView.setText(jeisObjek);
            mPeriodeSurveyTextView.setText(periodeSurvey);
            mProgressTextView.setText(String.valueOf(kualifikasiSurvey.getProgress())+"%");
            mImageViewGembok.setImageResource(R.drawable.lock);

        }

        @Override
        public void onClick(View v) {
            //extranya id kualifikasiSurvey yang di klik
            Intent intent=new Intent(HomePageActivity.this,DrawerFormActivity.class);
            intent.putExtra(EXTRA_ID_SURVEY_KUALIFIKASI,kualifikasiSurvey.getKualifikasiSurveyId());
            startActivity(intent);
        }
    }

    private class KualifikasiSurveyAdapter extends RecyclerView.Adapter<KualifikasiSurveyHolder>{
        private List<KualifikasiSurvey> mKualifikasiSurveys;

        public KualifikasiSurveyAdapter(List<KualifikasiSurvey> kualifikasiSurveys){
            mKualifikasiSurveys=kualifikasiSurveys;
        }

        @Override
        public KualifikasiSurveyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater=LayoutInflater.from(HomePageActivity.this);
            View view=layoutInflater.inflate(R.layout.list_item_survey,parent,false);
            return new KualifikasiSurveyHolder(view);
        }

        @Override
        public void onBindViewHolder(KualifikasiSurveyHolder holder, int position) {
            holder.kualifikasiSurvey=mKualifikasiSurveys.get(position);
            holder.bindSurvey(holder.kualifikasiSurvey);

        }

        @Override
        public int getItemCount() {
            return mKualifikasiSurveys.size();
        }

        public void setKualifikasiSurveys(List<KualifikasiSurvey> kualifikasiSurveys){
            mKualifikasiSurveys=kualifikasiSurveys;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateUi();
    }

    private class FetchItemTask extends AsyncTask<Void,Void,List<SingleForm>> {
        private String mIdKualifikasiSurvey;

        private FetchItemTask(String idKualifikasiSurvey){
            mIdKualifikasiSurvey=idKualifikasiSurvey;
        }

        @Override
        protected List<SingleForm> doInBackground(Void... params) {
            Log.i("a", "Received JSON: " + mIdKualifikasiSurvey);
            return new DataFetcher().fetchFormGalpal1s(mIdKualifikasiSurvey);
        }



        @Override
        protected void onPostExecute(List<SingleForm> singleForms) {

            for(SingleForm singleForm:singleForms){
                switch(singleForm.getKodeForm()){
                    case "FG1":
                        DummyMaker.get(getApplicationContext()).addFormGalpal1((FormGalpal1)singleForm);
                        break;
                    case "FG3":
                        DummyMaker.get(getApplicationContext()).addFormGalpal3((FormGalpal3)singleForm);
                        break;
                    case "FG4":
                        DummyMaker.get(getApplicationContext()).addFormGalpal4((FormGalpal4)singleForm);
                        break;
                    case "FG6":
                        DummyMaker.get(getApplicationContext()).addFormGalpal6((FormGalpal6)singleForm);
                        break;
                    case "FK3a":
                        DummyMaker.get(getApplicationContext()).addFormKompal3a((FormKompal3a)singleForm);
                        break;
                    case "FK3b":
                        DummyMaker.get(getApplicationContext()).addFormKompal3b((FormKompal3b)singleForm);
                        break;
                    case "FK3c":
                        DummyMaker.get(getApplicationContext()).addFormKompal3c((FormKompal3c)singleForm);
                        break;
                    case "FK3d":
                        DummyMaker.get(getApplicationContext()).addFormKompal3d((FormKompal3d)singleForm);
                        break;

                }
            }

        }
    }


}
