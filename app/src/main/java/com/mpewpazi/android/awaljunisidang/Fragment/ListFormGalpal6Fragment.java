package com.mpewpazi.android.awaljunisidang.fragment;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.mpewpazi.android.awaljunisidang.tools.ConnectionDetector;
import com.mpewpazi.android.awaljunisidang.tools.DataFetcher;
import com.mpewpazi.android.awaljunisidang.tools.DataPusher;
import com.mpewpazi.android.awaljunisidang.activity.DrawerFormActivity;
import com.mpewpazi.android.awaljunisidang.formModel.FormGalpal6;
import com.mpewpazi.android.awaljunisidang.formModel.SingleForm;
import com.mpewpazi.android.awaljunisidang.activity.FormGalpal6PagerActivity;
import com.mpewpazi.android.awaljunisidang.tools.GalKomSharedPreference;
import com.mpewpazi.android.awaljunisidang.service.PushGalpalService;
import com.mpewpazi.android.awaljunisidang.R;
import com.mpewpazi.android.awaljunisidang.database.DummyMaker;
import com.mpewpazi.android.awaljunisidang.modelExtras.KualifikasiSurvey;
import com.mpewpazi.android.awaljunisidang.modelExtras.MenuCheckingGalpal;
import com.mpewpazi.android.awaljunisidang.modelExtras.SingleMenuChecking;

import java.util.List;

/**
 * Created by mpewpazi on 4/22/16.
 */
public class ListFormGalpal6Fragment extends SingleFragment {

    private final static String EXTRA_KUALIFIKASISURVEY_FORMGALPAL6="extra_kualifikasisurvey_form_galpal6";
    private final static String EXTRA_ID_FORMGALPAL6="extra_id_form_galpal6";


    private List<FormGalpal6> mFormGalpal6s;

    private RecyclerView mFormGalpal6RecyclerView;
    private FormGalpal6Adapter mAdapter;
    private DummyMaker mDummyMaker;




    private KualifikasiSurvey mKualifikasiSurvey;

    private List<SingleForm> mGalpalForms;
    private MenuCheckingGalpal mMenuCheckingGalpal;

    private Button mSubmitButton;

    public ListFormGalpal6Fragment (){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext=getActivity();
        setHasOptionsMenu(true);

        mDummyMaker=DummyMaker.get(getContext());
        mKualifikasiSurvey=mDummyMaker.getKualifikasiSurvey(DrawerFormActivity.kualifikasiSurveyId);
        mGalpalForms=mDummyMaker.getGalpalForms();
        mMenuCheckingGalpal=mDummyMaker.getMenuCheckingGalpal(DrawerFormActivity.kualifikasiSurveyId,FormGalpal6.kode);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_form_galpal_peralatan_list, container, false);
        TextView mJudulTextView=(TextView)view.findViewById(R.id.galpal_peralatan_judul_list);
        FormGalpal6 formGalpal6=new FormGalpal6();
        mJudulTextView.setText(formGalpal6.getNamaForm());

        if(mKualifikasiSurvey.getStatus()==1||mKualifikasiSurvey.getStatus()==3||mKualifikasiSurvey.getStatus()==4||mMenuCheckingGalpal.isVerified()){
            setViewEnabledFalse(view);
        }

        mFormGalpal6RecyclerView = (RecyclerView) view.findViewById(R.id.form_galpal_peralatan_recycler_view);


        //recycler view butuh layoutmanager untuk mempossionig item di screen
        //ada banyak macam layout manager, kalau linear itu untuk vertikal posisioningnya
        //kedepanya ada gridLayoutManager
        mFormGalpal6RecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        Log.d("updateG","true");
        updateUI();

        mSubmitButton=(Button)view.findViewById(R.id.galpal_peralatan_btn_submit);
        if(mMenuCheckingGalpal.isComplete()){
            mSubmitButton.setText(R.string.belum_lengkap);
            mSubmitButton.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
        }
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                mDummyMaker.addKualifikasiSurvey(mKualifikasiSurvey);
                mCustomClickListener.clickListener();

            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private void updateUI() {
        mDummyMaker=DummyMaker.get(getActivity());
        mFormGalpal6s=mDummyMaker.getFormGalpal6s(DrawerFormActivity.kualifikasiSurveyId);

        //if (mAdapter == null) {
        mAdapter = new FormGalpal6Adapter(mFormGalpal6s);
        mFormGalpal6RecyclerView.setAdapter(mAdapter);
        if(mFormGalpal6s.size()>0){
            mMenuCheckingGalpal.setFill(true);
        }else{
            mMenuCheckingGalpal.setFill(false);
        }
        mDummyMaker.addMenuCheckingGalpal(mMenuCheckingGalpal);
        mCustomClickListener.clickListener();
        Log.d("updateGui","true");
        //} else {

        // reload all the item in he list
        //Log.d("updateGui","else");
        //mAdapter.setData(mFormGalpal6s);
        //mAdapter.notifyDataSetChanged();
        //}
    }

    private class FormGalpal6Holder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mNoTextView;
        private TextView mJenisMesinTextView;
        private TextView mMerekTextView;
        private ImageButton mDeleteButton;

        private FormGalpal6 mFormGalpal6;

        public void bindFormGalpal6(final FormGalpal6 formGalpal6, int no) {
            mFormGalpal6 = formGalpal6;
            mJenisMesinTextView.setText(mFormGalpal6.getJenisMesin());
            mMerekTextView.setText(mFormGalpal6.getMerek());
            mNoTextView.setText(String.valueOf(no));
            if(mKualifikasiSurvey.getStatus()==1||mKualifikasiSurvey.getStatus()==3||mKualifikasiSurvey.getStatus()==4||mMenuCheckingGalpal.isVerified()){
                mDeleteButton.setVisibility(View.GONE);
            }
            mDeleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder alertDialogBuilder=new AlertDialog.Builder(getActivity());
                    alertDialogBuilder.setMessage("Apakah anda yakin akan menghapus kolom ini");

                    alertDialogBuilder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            DummyMaker.get(getActivity()).deleteFormGalpal6(formGalpal6);
                            updateUI();
                            new DeleteTask(formGalpal6.getFormServerId()).execute();
                        }
                    });
                    alertDialogBuilder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });

                    alertDialogBuilder.show();
                }
            });

        }

        public FormGalpal6Holder(View itemView) {
            //setiap ada yang masuk ke super , reference setiap wideget dibuat oleh parent
            super(itemView);
            itemView.setOnClickListener(this);

            mNoTextView=(TextView)itemView.findViewById(R.id.list_item_galpal_peralatan_no);
            mJenisMesinTextView = (TextView) itemView.findViewById(R.id.list_item_galpal_peralatan_jenis_mesin);
            mMerekTextView = (TextView) itemView.findViewById(R.id.list_item_galpal_peralatan_merek);
            mDeleteButton=(ImageButton) itemView.findViewById(R.id.list_item_galpal_peralatan_delete);


        }


        @Override
        public void onClick(View v) {
            Intent intent=new Intent(getActivity(),FormGalpal6PagerActivity.class);
            intent.putExtra(EXTRA_ID_FORMGALPAL6,mFormGalpal6.getIdPeralatanKerjaCrane());
            intent.putExtra(EXTRA_KUALIFIKASISURVEY_FORMGALPAL6,mFormGalpal6.getKualifikasiSurveyId());
            startActivity(intent);
        }
    }

    private class FormGalpal6Adapter extends RecyclerView.Adapter<FormGalpal6Holder> {
        private List<FormGalpal6> mFormGalpal6s;

        public FormGalpal6Adapter(List<FormGalpal6> formGalpal6s) {
            mFormGalpal6s = formGalpal6s;
        }

        @Override
        public FormGalpal6Holder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater
                    .inflate(R.layout.list_item_form_galpal_peralatan, parent, false);

            return new FormGalpal6Holder(view);
        }

        @Override
        public void onBindViewHolder(FormGalpal6Holder holder, int position) {
            FormGalpal6 formGalpal6 = mFormGalpal6s.get(position);
            holder.bindFormGalpal6(formGalpal6,position+1);
        }

        @Override
        public int getItemCount() {
            return mFormGalpal6s.size();
        }

        public void setData(List<FormGalpal6> formGalpal6s){
            mFormGalpal6s=formGalpal6s;
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        if(mKualifikasiSurvey.getStatus()==0||mKualifikasiSurvey.getStatus()==2 && !mMenuCheckingGalpal.isVerified()){
            inflater.inflate(R.menu.fragment_form_list, menu);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_item_new_crime:
                FormGalpal6 formGalpal6=new FormGalpal6();
                formGalpal6.setKualifikasiSurveyId(DrawerFormActivity.kualifikasiSurveyId);
                DummyMaker.get(getActivity()).addFormGalpal6(formGalpal6);
                Intent intent=new Intent(getActivity(),FormGalpal6PagerActivity.class);
                intent.putExtra(EXTRA_ID_FORMGALPAL6,formGalpal6.getIdPeralatanKerjaCrane());
                intent.putExtra(EXTRA_KUALIFIKASISURVEY_FORMGALPAL6,formGalpal6.getKualifikasiSurveyId());
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if(mKualifikasiSurvey.getStatus()==0||mKualifikasiSurvey.getStatus()==2||!mMenuCheckingGalpal.isVerified() && !mMenuCheckingGalpal.isVerified()){
            if(!new ConnectionDetector(getActivity()).isConnectingToInternet()){
                Log.i("NotificationService","FG6");
                PushGalpalService.setServiceAlarm(getActivity(),true);
            }else {
                new PushTask(mFormGalpal6s, mMenuCheckingGalpal).execute();
            }
        }
    }

    private class PushTask extends AsyncTask<Void,Void,List<FormGalpal6>> {
        private List<FormGalpal6> mFormGalpal6s;
        private SingleMenuChecking mSingleMenuChecking;

        public PushTask(List<FormGalpal6> formGalpal6s, SingleMenuChecking singleMenuChecking){
            mFormGalpal6s=formGalpal6s;
            mSingleMenuChecking=singleMenuChecking;
        }

        @Override
        protected List<FormGalpal6> doInBackground(Void... params) {
            if(mFormGalpal6s.size()>0) {
                for (FormGalpal6 formGalpal6 : mFormGalpal6s) {
                    new DataPusher(GalKomSharedPreference.getUserId(mContext),GalKomSharedPreference.getPassword(mContext)).makePostRequestFG6(formGalpal6);
                }
            }
            new DataPusher(GalKomSharedPreference.getUserId(mContext),GalKomSharedPreference.getPassword(mContext)).makePostRequestMenuCheckingGalpal((MenuCheckingGalpal) mSingleMenuChecking);
            return mFormGalpal6s;
        }

        @Override
        protected void onPostExecute(List<FormGalpal6> formGalpal6s) {
            for(FormGalpal6 formGalpal6:formGalpal6s) {
                DummyMaker.get(getActivity()).addFormGalpal6(formGalpal6);
            }
        }
    }

    private class DeleteTask extends AsyncTask<Void,Void,Void> {
        private int mIdForm;

        public DeleteTask(int idForm){
            mIdForm=idForm;
        }

        @Override
        protected Void doInBackground(Void... params) {
            new DataFetcher().deleteForm(mIdForm,DataFetcher.DELETEFG6ENDPOINT);
            return null;
        }
    }





}