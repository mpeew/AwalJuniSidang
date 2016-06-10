package com.mpewpazi.android.awaljunisidang.Fragment;

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

import com.mpewpazi.android.awaljunisidang.ConnectionDetector;
import com.mpewpazi.android.awaljunisidang.DataFetcher;
import com.mpewpazi.android.awaljunisidang.DataPusher;
import com.mpewpazi.android.awaljunisidang.DrawerFormActivity;
import com.mpewpazi.android.awaljunisidang.Form.FormKompal3a;
import com.mpewpazi.android.awaljunisidang.Form.SingleForm;
import com.mpewpazi.android.awaljunisidang.FormKompal3aPagerActivity;
import com.mpewpazi.android.awaljunisidang.GalKomSharedPreference;
import com.mpewpazi.android.awaljunisidang.PushKompalService;
import com.mpewpazi.android.awaljunisidang.R;
import com.mpewpazi.android.awaljunisidang.dummy.DummyMaker;
import com.mpewpazi.android.awaljunisidang.model.KualifikasiSurvey;
import com.mpewpazi.android.awaljunisidang.model.MenuCheckingKompal;
import com.mpewpazi.android.awaljunisidang.model.SingleMenuChecking;

import java.util.List;

/**
 * Created by mpewpazi on 5/10/16.
 */
public class ListFormKompal3aFragment extends SingleFragment {
    private final static String EXTRA_KUALIFIKASISURVEY_FORMKOMPAL3A="extra_kualifikasisurvey_form_kompal3a";
    private final static String EXTRA_ID_FORMKOMPAL3A="extra_id_form_kompal3a";


    private List<FormKompal3a> mFormKompal3as;

    private RecyclerView mFormKompal3aRecyclerView;
    private FormKompal3aAdapter mAdapter;
    private DummyMaker mDummyMaker;

    private MenuCheckingKompal mMenuCheckingKompal;
    private KualifikasiSurvey mKualifikasiSurvey;
    private List<SingleForm> mKompalForms;
    private Button mSubmitButton;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);

        mDummyMaker=DummyMaker.get(getContext());
        mKualifikasiSurvey=mDummyMaker.getKualifikasiSurvey(DrawerFormActivity.kualifikasiSurveyId);
        mKompalForms=mDummyMaker.getKompalForms();
        mMenuCheckingKompal=mDummyMaker.getMenuCheckingKompal(DrawerFormActivity.kualifikasiSurveyId,FormKompal3a.kode);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_form_kompal3a_list, container, false);
        if(mKualifikasiSurvey.getStatus()==1||mKualifikasiSurvey.getStatus()==3||mKualifikasiSurvey.getStatus()==4){
            setViewEnabledFalse(view);
        }

        mFormKompal3aRecyclerView = (RecyclerView) view.findViewById(R.id.form_kompal3a_recycler_view);
        mSubmitButton=(Button)view.findViewById(R.id.kompal3a_btn_submit);

        //recycler view butuh layoutmanager untuk mempossionig item di screen
        //ada banyak macam layout manager, kalau linear itu untuk vertikal posisioningnya
        //kedepanya ada gridLayoutManager
        mFormKompal3aRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        if(mMenuCheckingKompal.isComplete()){
            mSubmitButton.setText(R.string.belum_lengkap);
            mSubmitButton.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
        }
        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mMenuCheckingKompal.isComplete()){
                    mMenuCheckingKompal.setComplete(true);
                    mKualifikasiSurvey.setProgress(mKualifikasiSurvey.getProgress()+100/mKompalForms.size());
                    mSubmitButton.setText(R.string.belum_lengkap);
                    mSubmitButton.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
                }else{
                    mMenuCheckingKompal.setComplete(false);
                    mKualifikasiSurvey.setProgress(mKualifikasiSurvey.getProgress()-100/mKompalForms.size());
                    mSubmitButton.setText(R.string.lengkap);
                    mSubmitButton.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
                }

                mDummyMaker.addMenuCheckingKompal(mMenuCheckingKompal);
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
        mFormKompal3as=mDummyMaker.getFormKompal3as(DrawerFormActivity.kualifikasiSurveyId);
        mAdapter = new FormKompal3aAdapter(mFormKompal3as);
        mFormKompal3aRecyclerView.setAdapter(mAdapter);
        if(mFormKompal3as.size()>0){
            mMenuCheckingKompal.setFill(true);
        }else{
            mMenuCheckingKompal.setFill(false);
        }
        mDummyMaker.addMenuCheckingKompal(mMenuCheckingKompal);
        mCustomClickListener.clickListener();
    }


    private class FormKompal3aHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView mNoTextView;
        private TextView mJenisProduksiTextView;
        private TextView mKapasitasProduksiTextView;
        private ImageButton mDeleteButton;

        private FormKompal3a mFormKompal3a;

        public void bindFormKompal3a(final FormKompal3a formKompal3a, int no) {
            mFormKompal3a = formKompal3a;
            mJenisProduksiTextView.setText(mFormKompal3a.getJenisProduksi());
            mKapasitasProduksiTextView.setText(String.valueOf(mFormKompal3a.getKapasitasProduksi()));
            mNoTextView.setText(String.valueOf(no));
            if(mKualifikasiSurvey.getStatus()==1||mKualifikasiSurvey.getStatus()==3||mKualifikasiSurvey.getStatus()==4){
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
                            DummyMaker.get(getActivity()).deleteFormKompal3a(formKompal3a);
                            updateUI();
                            new DeleteTask(formKompal3a.getFormServerId()).execute();

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

        public FormKompal3aHolder(View itemView) {
            //setiap ada yang masuk ke super , reference setiap wideget dibuat oleh parent
            super(itemView);
            itemView.setOnClickListener(this);

            mNoTextView=(TextView)itemView.findViewById(R.id.list_item_kompal3a_no);
            mJenisProduksiTextView = (TextView) itemView.findViewById(R.id.list_item_kompal3a_jenis_produksi);
            mKapasitasProduksiTextView = (TextView) itemView.findViewById(R.id.list_item_kompal3a_kapasitas_produksi);
            mDeleteButton=(ImageButton)itemView.findViewById(R.id.list_item_kompal3a_delete);


        }


        @Override
        public void onClick(View v) {
             Intent intent=new Intent(getActivity(),FormKompal3aPagerActivity.class);
             intent.putExtra(EXTRA_ID_FORMKOMPAL3A,mFormKompal3a.getIdJenisKapasitasProduksi());
             intent.putExtra(EXTRA_KUALIFIKASISURVEY_FORMKOMPAL3A,mFormKompal3a.getKualifikasiSurveyId());
             startActivity(intent);
        }
    }

    private class FormKompal3aAdapter extends RecyclerView.Adapter<FormKompal3aHolder> {
        private List<FormKompal3a> mFormKompal3as;

        public FormKompal3aAdapter(List<FormKompal3a> formKompal3as) {
            mFormKompal3as = formKompal3as;
        }

        @Override
        public FormKompal3aHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View view = layoutInflater
                    .inflate(R.layout.list_item_form_kompal3a, parent, false);
            return new FormKompal3aHolder(view);
        }

        @Override
        public void onBindViewHolder(FormKompal3aHolder holder, int position) {
            FormKompal3a formKompal3a = mFormKompal3as.get(position);
            holder.bindFormKompal3a(formKompal3a,position+1);
        }

        @Override
        public int getItemCount() {
            return mFormKompal3as.size();
        }

        public void setData(List<FormKompal3a> formKompal3as){
            mFormKompal3as=formKompal3as;
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        if(mKualifikasiSurvey.getStatus()==0||mKualifikasiSurvey.getStatus()==2 && !mMenuCheckingKompal.isVerified()){
            inflater.inflate(R.menu.fragment_form_list, menu);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_item_new_crime:
                FormKompal3a formKompal3a=new FormKompal3a();
                formKompal3a.setKualifikasiSurveyId(DrawerFormActivity.kualifikasiSurveyId);
                DummyMaker.get(getActivity()).addFormKompal3a(formKompal3a);
                Intent intent=new Intent(getActivity(),FormKompal3aPagerActivity.class);
                intent.putExtra(EXTRA_ID_FORMKOMPAL3A,formKompal3a.getIdJenisKapasitasProduksi());
                intent.putExtra(EXTRA_KUALIFIKASISURVEY_FORMKOMPAL3A,formKompal3a.getKualifikasiSurveyId());
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if(mKualifikasiSurvey.getStatus()==0||mKualifikasiSurvey.getStatus()==2 && !mMenuCheckingKompal.isVerified()){
            if(!new ConnectionDetector(getActivity()).isConnectingToInternet()){
                PushKompalService.setServiceAlarm(getActivity(),true);
            }else {
                new PushTask(mFormKompal3as, mMenuCheckingKompal).execute();
            }
        }
    }

    private class PushTask extends AsyncTask<Void,Void,List<FormKompal3a>> {
        private List<FormKompal3a> mFormKompal3as;
        private SingleMenuChecking mSingleMenuChecking;

        public PushTask(List<FormKompal3a> formKompal3as, SingleMenuChecking singleMenuChecking){
            mFormKompal3as=formKompal3as;
            mSingleMenuChecking=singleMenuChecking;
        }

        @Override
        protected List<FormKompal3a> doInBackground(Void... params) {
            if(mFormKompal3as.size()>0) {
                for (FormKompal3a formKompal3a : mFormKompal3as) {
                    new DataPusher(GalKomSharedPreference.getUserId(mContext),GalKomSharedPreference.getPassword(mContext)).makePostRequestFK3a(formKompal3a);
                }
            }
            new DataPusher(GalKomSharedPreference.getUserId(mContext),GalKomSharedPreference.getPassword(mContext)).makePostRequestMenuCheckingKompal((MenuCheckingKompal) mSingleMenuChecking);
            return mFormKompal3as;
        }

        @Override
        protected void onPostExecute(List<FormKompal3a> formKompal3as) {
            for(FormKompal3a formKompal3a:formKompal3as) {
                DummyMaker.get(getActivity()).addFormKompal3a(formKompal3a);
                Log.i("INA",String.valueOf(formKompal3a.getFormServerId()));
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
            new DataFetcher().deleteForm(mIdForm,DataFetcher.DELETEFK3aENDPOINT);
            return null;
        }
    }


}
