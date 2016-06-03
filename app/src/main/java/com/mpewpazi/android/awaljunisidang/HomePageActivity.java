package com.mpewpazi.android.awaljunisidang;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.mpewpazi.android.awaljunisidang.dummy.DummyMaker;
import com.mpewpazi.android.awaljunisidang.model.KualifikasiSurvey;
import com.mpewpazi.android.awaljunisidang.model.SurveyAssignSurveyor;

import java.util.ArrayList;
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

        if(!GalKomSharedPreference.isLoggedIn(getApplicationContext())){
            Intent i = new Intent(this, LoginActivity.class);
            // Closing all the Activities
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            // Add new Flag to start new Activity
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            // Staring Login Activity

            startActivity(i);


        }else{
            if(new ConnectionDetector(HomePageActivity.this).isConnectingToInternet()) {
                new FetchKualifikasiSurveyTask(GalKomSharedPreference.getUserId(getApplicationContext())).execute();
            }else{
                updateUi();
            }
        }







    }

    private void updateUi() {
        mDummyMaker= DummyMaker.get(this);
        mKualifikasiSurveys=mDummyMaker.getKualifikasiSurveys();
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
        private TextView mJenisObjekTextView;
        private TextView mProgressTextView;
        private TextView mStatusTextView;
        private Button mSubmitButton;

        int statusClick=0;


        public KualifikasiSurvey kualifikasiSurvey;


        public KualifikasiSurveyHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            mNamaPerusahaanTextView=(TextView)itemView.findViewById(R.id.survey_nama_perusahaan);
            mJenisObjekTextView=(TextView)itemView.findViewById(R.id.survey_jenis_objek_survey);
            mProgressTextView=(TextView)itemView.findViewById(R.id.survey_progres_persen);
            mStatusTextView=(TextView)itemView.findViewById(R.id.survey_status_survey);
            mSubmitButton=(Button)itemView.findViewById(R.id.survey_submit_button);
        }

        public void bindSurvey(final KualifikasiSurvey kualifikasiSurvey) {

            String namaPerusahaan=mDummyMaker.getPerusahaan(kualifikasiSurvey.getPerusahaanId()).getNamaPerusahaan();
            String jeisObjek=mDummyMaker.getPerusahaan(kualifikasiSurvey.getPerusahaanId()).getIndustri();
            String statusKeterangan="";
            String btnText="Kirim";
            int color=0;

            switch(kualifikasiSurvey.getStatus()){
                case 0:
                    statusClick=1;
                    statusKeterangan="Belum Lengkap";
                    color=getResources().getColor(android.R.color.holo_red_light);
                    break;
                case 1:
                    statusKeterangan="Menunggu Verifikasi";

                    color=getResources().getColor(android.R.color.darker_gray);
                    btnText="-";
                    mSubmitButton.setEnabled(false);
                    break;
                case 2:
                    statusClick=4;
                    statusKeterangan="Revisi";
                    color=getResources().getColor(android.R.color.holo_red_light);
                    break;
                case 3:
                    statusKeterangan="Terverifikasi";
                    color=getResources().getColor(android.R.color.holo_green_light);
                    btnText="-";
                    mSubmitButton.setEnabled(false);
                    break;
                case 4:
                    statusKeterangan="Telah Direvisi";
                    color=getResources().getColor(android.R.color.darker_gray);
                    btnText="-";
                    mSubmitButton.setEnabled(false);
                    break;
            }

            mNamaPerusahaanTextView.setText(namaPerusahaan);
            mJenisObjekTextView.setText(jeisObjek);
            mProgressTextView.setText(String.valueOf(kualifikasiSurvey.getProgress())+"%");
            mStatusTextView.setText(statusKeterangan);
            mStatusTextView.setTextColor(color);
            mSubmitButton.setBackgroundColor(color);
            mSubmitButton.setText(btnText);
            mSubmitButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(HomePageActivity.this);
                    if(new ConnectionDetector(HomePageActivity.this).isConnectingToInternet()) {
                        alertDialogBuilder.setMessage("Apakah Anda Yakin Akan Mengirim Kualifikasi Survey Ini");
                        alertDialogBuilder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                kualifikasiSurvey.setStatus(statusClick);
                                new PushKualifikasiSurveyTask(kualifikasiSurvey).execute();
                                mDummyMaker.addKualifikasiSurvey(kualifikasiSurvey);
                                updateUi();
                            }
                        });
                        alertDialogBuilder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });

                    }else{
                        alertDialogBuilder.setMessage("Koneksi Internet Tidak Tersedia, Ulangi Lain Waktu");
                        alertDialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        });
                    }

                    alertDialogBuilder.show();
                }
            });
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

    private class PushKualifikasiSurveyTask extends AsyncTask<Void,Void,Void> {
        private KualifikasiSurvey mKualifikasiSurvey;

        public PushKualifikasiSurveyTask(KualifikasiSurvey kualifikasiSurvey){
            mKualifikasiSurvey=kualifikasiSurvey;
        }

        @Override
        protected Void doInBackground(Void... params) {
            new DataPusher().makePostRequestKualifikasiSurvey(mKualifikasiSurvey);
            return null;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_logout) {
            GalKomSharedPreference.setLoggedIn(getApplicationContext(),false);
            Intent i = new Intent(this, LoginActivity.class);
            // Closing all the Activities
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            // Staring Login Activity
            startActivity(i);
            mDummyMaker.deleteGalpalFormsMenus();
            mDummyMaker.deleteKompalFormsMenus();
            mDummyMaker.deleteKualifikasiSurveys();
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    private class FetchKualifikasiSurveyTask extends AsyncTask<Void,Void,List<KualifikasiSurvey>> {
        private String mUserId;


        private KualifikasiSurvey mKualifikasiSurveyId1;
        private KualifikasiSurvey mKualifikasISurveyId2;

        public FetchKualifikasiSurveyTask(String userId){
            mUserId=userId;
        }


        @Override
        protected List<KualifikasiSurvey> doInBackground(Void... params) {
            Log.i("a", "Received JSON ");
            List<KualifikasiSurvey> kualifikasiSurveys=new ArrayList<>();
            DataFetcher dataFetcher=new DataFetcher();
            if(mUserId.equals("mpewpazi")){
                mKualifikasiSurveyId1=dataFetcher.fetchKualifikasiSurvey(String.valueOf(20150101));
                mKualifikasISurveyId2=dataFetcher.fetchKualifikasiSurvey(String.valueOf(20150102));
            }else if(mUserId.equals("perinurpazri")){
                mKualifikasiSurveyId1=dataFetcher.fetchKualifikasiSurvey(String.valueOf(20150205));
                mKualifikasISurveyId2=dataFetcher.fetchKualifikasiSurvey(String.valueOf(20150291));
            }

            kualifikasiSurveys.add(mKualifikasiSurveyId1);
            kualifikasiSurveys.add(mKualifikasISurveyId2);

            return kualifikasiSurveys;
        }



        @Override
        protected void onPostExecute(List<KualifikasiSurvey> kualifikasiSurveys) {
            for(KualifikasiSurvey kualifikasiSurvey:kualifikasiSurveys) {
                DummyMaker.get(getApplicationContext()).addKualifikasiSurvey(kualifikasiSurvey);
            }
            updateUi();
        }
    }
}
